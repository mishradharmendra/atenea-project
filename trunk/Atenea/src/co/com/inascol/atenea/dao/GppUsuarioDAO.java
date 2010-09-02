package co.com.inascol.atenea.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import co.com.inascol.atenea.dao.utils.DAO;
import co.com.inascol.atenea.dao.utils.TemplateManager;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.entity.GppUsuariorol;
import co.com.inascol.atenea.dao.GppUsuariorolDAO;
import co.com.inascol.atenea.entity.rowmapper.GppUsuarioRowMapper;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcción de Software
 * Esp. Sistemas de Información Geográfica
 * Ing. Catastral y Geodesta
 */
public class GppUsuarioDAO implements DAO {
	
	private GppUsuario gppUsuario;
	private GppUsuarioRowMapper gppUsuarioRowMapper;
	private List<Object> gppUsuarios;
	private Boolean estadoOperation;	
	private String sentenciaSQL;
	private JdbcTemplate jdbcTemplate;
	
	public boolean actualizar(Object obj) {
		estadoOperation = false;
		try{
			gppUsuario = (GppUsuario) obj;			
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "update gpp_usuario " +
							"set usu_vnombre = ?, " +
							"usu_vlogin = ?, " +
							"usu_vemail = ?, " +
							"usu_vtelefono = ?, " +														
							"usu_vusumodifica = ?, " +
							"usu_dfecmodifica = ?, " +							
							"usu_vactivo = ? " +							
							"where usu_nidusuario = ?";	
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppUsuario.getUsuVnombre(),
															gppUsuario.getUsuVlogin(),
															gppUsuario.getUsuVemail(),
															gppUsuario.getUsuVtelefono(),
															gppUsuario.getUsuVusumodifica(),
															gppUsuario.getUsuDfecmodifica(),
															gppUsuario.getUsuBactivo(),
															gppUsuario.getUsuNidusuario()},
															new int[] {Types.VARCHAR,
																		Types.VARCHAR,
																		Types.VARCHAR,
																		Types.VARCHAR,
																		Types.VARCHAR,																																				
																		Types.DATE,
																		Types.VARCHAR,
																		Types.INTEGER});	
			estadoOperation = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return estadoOperation;
	}

	public boolean borrar(Object idObj) {
		estadoOperation = false;
		try{	
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "delete from gpp_usuario " +
							"where usu_nidusuario = ? ";	
			jdbcTemplate.update(sentenciaSQL, new Object[] {idObj}, new int[] {Types.VARCHAR});	
			estadoOperation = true;
		} catch (DataIntegrityViolationException ex) {
			System.out.println("Login Duplicado");
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperation;
	}

	public Object buscarPorId(Object idObj) {
		gppUsuario = null;
		try{
			gppUsuarioRowMapper = new GppUsuarioRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_usuario where usu_nidusuario = ?";
			gppUsuario = (GppUsuario) jdbcTemplate.queryForObject(sentenciaSQL, new Object[] {idObj}, gppUsuarioRowMapper);
			GppUsuariorolDAO gppUsuariorol = new GppUsuariorolDAO(); 
			List <Object> usuarioRoles = gppUsuariorol.buscarTodosRolesUsuario(Integer.valueOf(gppUsuario.getUsuNidusuario()));
			if(usuarioRoles.size()>0){
				Iterator<Object> itUsuariorol = usuarioRoles.iterator();
				List<Object> gppRoles = new ArrayList<Object>();
				GppRolDAO rolDAO = new GppRolDAO();
				while(itUsuariorol.hasNext()){
					GppUsuariorol usuariorol = (GppUsuariorol) itUsuariorol.next();
					gppRoles.add(rolDAO.buscarPorId(usuariorol.getId().getRolNidrol()));
				}
				gppUsuario.setGppRoles(gppRoles);
			}
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppUsuario;
	}

	public List<Object> buscarTodos() {
		gppUsuarios = null;
		try{
			gppUsuarioRowMapper = new GppUsuarioRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_usuario order by usu_vlogin asc";
			gppUsuarios = (List) jdbcTemplate.query(sentenciaSQL, gppUsuarioRowMapper);
		} catch(Exception ex){
			ex.printStackTrace();
		}
		return gppUsuarios;
	}

	public boolean crear(Object obj) {
		estadoOperation = false;
		try{
			gppUsuario = (GppUsuario) obj;
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "insert into gpp_usuario " +
							"(usu_vnombre, usu_vlogin, usu_vemail, usu_vtelefono, usu_vusucrea, usu_dfeccrea, usu_vactivo) "+
							"values (?, ?, ?, ?, ?, ?, ?)";	
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppUsuario.getUsuVnombre(),
					 										gppUsuario.getUsuVlogin(),
															gppUsuario.getUsuVemail(),
															gppUsuario.getUsuVtelefono(),
															gppUsuario.getUsuVusucrea(),
															gppUsuario.getUsuDfeccrea(),
															gppUsuario.getUsuBactivo()},
															new int[] {Types.VARCHAR,
																		Types.VARCHAR,
																		Types.VARCHAR,
																		Types.VARCHAR,
																		Types.VARCHAR,
																		Types.DATE,
																		Types.VARCHAR});
			estadoOperation = true;
		} catch (DataIntegrityViolationException ex) {
			System.out.println("Login Duplicado");
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperation;
	}
	
	public Object buscarPorLogin (Object idObj) {
		gppUsuario = null;
		try{ 
			gppUsuarioRowMapper = new GppUsuarioRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_usuario where usu_vlogin = ? and usu_vactivo = 'true'";
			gppUsuario = (GppUsuario) jdbcTemplate.queryForObject(sentenciaSQL, new Object[] {idObj}, gppUsuarioRowMapper);
			System.out.println("Usuario Logeado: '"+idObj+"'.");
			GppUsuariorolDAO gppUsuariorol = new GppUsuariorolDAO(); 
			List <Object> usuarioRoles = gppUsuariorol.buscarTodosRolesUsuario(Integer.valueOf(gppUsuario.getUsuNidusuario()));
			if(usuarioRoles.size()>0){
				Iterator<Object> itUsuariorol = usuarioRoles.iterator();
				List<Object> gppRoles = new ArrayList<Object>();
				GppRolDAO rolDAO = new GppRolDAO();
				while(itUsuariorol.hasNext()){
					GppUsuariorol usuariorol = (GppUsuariorol) itUsuariorol.next();
					gppRoles.add(rolDAO.buscarPorId(usuariorol.getId().getRolNidrol()));
				}
				gppUsuario.setGppRoles(gppRoles);
			}
		} catch (EmptyResultDataAccessException ex){
			System.out.println("Usuario y Password no Encontrados. Datos ingresados: '"+idObj+"'.");
		}
		return gppUsuario;
	} 		
}