package co.com.inascol.atenea.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import co.com.inascol.atenea.dao.utils.DAO;
import co.com.inascol.atenea.dao.utils.TemplateManager;
import co.com.inascol.atenea.entity.GppUsuariorol;
import co.com.inascol.atenea.entity.rowmapper.GppUsuariorolRowMapper;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class GppUsuariorolDAO implements DAO {
	
	private GppUsuariorol gppUsuariorol;
	private GppUsuariorolRowMapper gppUsuariorolRowMapper;
	private List<Object> gppUsuarioroles;
	private Boolean estadoOperation;	
	private String sentenciaSQL;
	private JdbcTemplate jdbcTemplate;
	
	public boolean actualizar(Object obj) {
		estadoOperation = false;
		try{
			estadoOperation = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return estadoOperation;
	}
	
	public boolean borrar(Object obj) {
		estadoOperation = false;
		try{	
			gppUsuariorol = (GppUsuariorol) obj;
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "delete from gpp_usuariorol " +
							"where usu_nidusuario = ? " +
							"and rol_nidrol = ? ";	
			jdbcTemplate.update(sentenciaSQL, new Object[] {gppUsuariorol.getId().getUsuNidusuario(), 
					                                        gppUsuariorol.getId().getRolNidrol()}, 
					                             new int[] {Types.INTEGER,
															Types.INTEGER});	
			estadoOperation = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return estadoOperation;
	}

	public Object buscarPorId(Object idObj) {
		gppUsuariorol = null;
		try{
			gppUsuariorol = (GppUsuariorol) idObj;
			gppUsuariorolRowMapper = new GppUsuariorolRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_usuariorol where rol_nidrol = ? and usu_nidusuario = ?";
			gppUsuariorol = (GppUsuariorol) jdbcTemplate.queryForObject(sentenciaSQL, 
					new Object[] {gppUsuariorol.getId().getRolNidrol(), 
									gppUsuariorol.getId().getUsuNidusuario()},
                    new int[] {Types.INTEGER,
								Types.INTEGER} , gppUsuariorolRowMapper);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppUsuariorol;
	}

	public List<Object> buscarTodosRolesUsuario(Object obj) {
		gppUsuarioroles = null;
		try{
			gppUsuariorolRowMapper = new GppUsuariorolRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_usuariorol where usu_nidusuario = ? order by rol_nidrol asc";
			gppUsuarioroles = (List) jdbcTemplate.query(sentenciaSQL,new Object[] {obj}, gppUsuariorolRowMapper);
		} catch(Exception ex){
			ex.printStackTrace();
		}
		return gppUsuarioroles;
	}

	public List<Object> buscarTodos() {
		gppUsuarioroles = null;
		try{
			gppUsuariorolRowMapper = new GppUsuariorolRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_usuariorol order by usu_nidusuario asc";
			gppUsuarioroles = (List) jdbcTemplate.query(sentenciaSQL, gppUsuariorolRowMapper);
		} catch(Exception ex){
			ex.printStackTrace();
		}
		return gppUsuarioroles;
	}

	public boolean crear(Object obj) {
		estadoOperation = false;
		try{
			gppUsuariorol = (GppUsuariorol) obj;
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "insert into gpp_usuariorol " +
							"(usu_nidusuario, rol_nidrol, url_vusucrea, url_dfeccrea)" +
							"values (?, ?, ?, ?)";	
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppUsuariorol.getId().getUsuNidusuario(),
															gppUsuariorol.getId().getRolNidrol(),
															gppUsuariorol.getUrlVusucrea(),
															gppUsuariorol.getUrlDfeccrea()},
															new int[] {Types.INTEGER,
																		Types.INTEGER,
																		Types.VARCHAR,
																		Types.DATE});
			estadoOperation = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return estadoOperation;
	}
}