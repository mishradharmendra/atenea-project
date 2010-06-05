package co.com.inascol.atenea.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import co.com.inascol.atenea.dao.utils.DAO;
import co.com.inascol.atenea.dao.utils.TemplateManager;
import co.com.inascol.atenea.entity.GppRol;
import co.com.inascol.atenea.entity.rowmapper.GppRolRowMapper;

public class GppRolDAO implements DAO {
	
	private GppRol gppRol;
	private GppRolRowMapper gppRolRowMapper;
	private List<Object> gppRols;
	private Boolean estadoOperation;	
	private String sentenciaSQL;
	private JdbcTemplate jdbcTemplate;

	public GppRolDAO(){}
	
	public boolean actualizar(Object obj) {
		estadoOperation = false;
		try{
			gppRol = (GppRol) obj;			
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "update gpp_rol " +
							"set rol_vnombre = ?, " +
							"rol_vdescripcion = ?, " +
							"rol_vusumodifica = ?, " +
							"rol_dfecmodifica = ?, " +							
							"rol_vactivo = ? " +							
							"where rol_nidrol = ?";	
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppRol.getRolVnombre(),
															gppRol.getRolVdescripcion(),
															gppRol.getRolVusumodifica(),
															gppRol.getRolDfecmodifica(),
															gppRol.getRolVactivo(),
															gppRol.getRolNidrol()},
															new int[] {Types.VARCHAR,
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
			sentenciaSQL = "delete from gpp_rol " +
							"where rol_nidrol = ? ";	
			jdbcTemplate.update(sentenciaSQL, new Object[] {idObj}, new int[] {Types.VARCHAR});	
			estadoOperation = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return estadoOperation;
	}

	public Object buscarPorId(Object idObj) {
		gppRol = null;
		try{
			gppRolRowMapper = new GppRolRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_rol where rol_nidrol = ?";
			gppRol = (GppRol) jdbcTemplate.queryForObject(sentenciaSQL, new Object[] {idObj}, gppRolRowMapper);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppRol;
	}

	public List<Object> buscarTodos() {
		gppRols = null;
		try{
			gppRolRowMapper = new GppRolRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_rol order by rol_vnombre asc";
			gppRols = (List) jdbcTemplate.query(sentenciaSQL, gppRolRowMapper);
		} catch(Exception ex){
			ex.printStackTrace();
		}
		return gppRols;
	}

	public boolean crear(Object obj) {
		estadoOperation = false;
		try{
			gppRol = (GppRol) obj;
			
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "insert into gpp_rol " +
							"(rol_vnombre, rol_vdescripcion, rol_vusucrea, rol_dfeccrea, rol_vactivo) "+
							"values (?, ?, ?, ?, ?)";	
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppRol.getRolVnombre(),
					 										gppRol.getRolVdescripcion(),
															gppRol.getRolVusucrea(),
															gppRol.getRolDfeccrea(),
															gppRol.getRolVactivo()},
															new int[] {Types.VARCHAR,
																		Types.VARCHAR,
																		Types.VARCHAR,
																		Types.DATE,
																		Types.VARCHAR});
			estadoOperation = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return estadoOperation;
	}
}