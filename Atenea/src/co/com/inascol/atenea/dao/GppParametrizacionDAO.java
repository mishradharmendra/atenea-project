package co.com.inascol.atenea.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import co.com.inascol.atenea.dao.utils.DAO;
import co.com.inascol.atenea.dao.utils.TemplateManager;
import co.com.inascol.atenea.entity.GppParametrizacion;
import co.com.inascol.atenea.entity.rowmapper.GppParametrizacionRowMapper;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class GppParametrizacionDAO implements DAO {
	
	private GppParametrizacion gppParametrizacion;
	private GppParametrizacionRowMapper gppParametrizacionRowMapper;
	private List<Object> gppParametrizacions;
	private Boolean estadoOperation;	
	private String sentenciaSQL;
	private JdbcTemplate jdbcTemplate;
	
	public boolean actualizar(Object obj) {
		estadoOperation = false;
		try{
			gppParametrizacion = (GppParametrizacion) obj;			
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "update gpp_parametrizacion " +
							"set par_vnombre = ?, " +
							"par_vvalor = ?, " +
							"par_vdescripcion = ? " +														
							"where par_nidparam = ?";	
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppParametrizacion.getParVnombre(),
															gppParametrizacion.getParVvalor(),
															gppParametrizacion.getParVdescripcion(),
															gppParametrizacion.getParNidparam()},
															new int[] {Types.VARCHAR,
																		Types.VARCHAR,
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
			sentenciaSQL = "delete from gpp_parametrizacion " +
							"where par_nidparam = ? ";	
			jdbcTemplate.update(sentenciaSQL, new Object[] {idObj}, new int[] {Types.INTEGER});	
			estadoOperation = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return estadoOperation;
	}

	public Object buscarPorId(Object idObj) {
		gppParametrizacion = null;
		try{
			gppParametrizacionRowMapper = new GppParametrizacionRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_parametrizacion where par_nidparam = ?";
			gppParametrizacion = (GppParametrizacion) jdbcTemplate.queryForObject(sentenciaSQL, new Object[] {idObj}, gppParametrizacionRowMapper);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppParametrizacion;
	}

	public List<Object> buscarTodos() {
		gppParametrizacion = null;
		try{
			gppParametrizacionRowMapper = new GppParametrizacionRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_parametrizacion order by par_nidparam asc";
			gppParametrizacions = (List) jdbcTemplate.query(sentenciaSQL, gppParametrizacionRowMapper);
		} catch(Exception ex){
			ex.printStackTrace();
		}
		return gppParametrizacions;
	}

	public boolean crear(Object obj) {
		estadoOperation = false;
		try{
			gppParametrizacion = (GppParametrizacion) obj;
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "insert into gpp_parametrizacion " +
							"(par_nidparam, par_vnombre, par_vvalor, par_vdescripcion)" +
							"values (?, ?, ?, ?)";	
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppParametrizacion.getParNidparam(),
															gppParametrizacion.getParVnombre(),
															gppParametrizacion.getParVvalor(),
															gppParametrizacion.getParVdescripcion()},
															new int[] {Types.INTEGER,
																		Types.VARCHAR,
																		Types.VARCHAR,
																		Types.VARCHAR});
			estadoOperation = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return estadoOperation;
	}
}