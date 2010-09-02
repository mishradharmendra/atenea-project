package co.com.inascol.atenea.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import co.com.inascol.atenea.dao.utils.DAO;
import co.com.inascol.atenea.dao.utils.TemplateManager;
import co.com.inascol.atenea.entity.GppEstadocivil;
import co.com.inascol.atenea.entity.rowmapper.GppEstadocivilRowMapper;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcción de Software
 * Esp. Sistemas de Información Geográfica
 * Ing. Catastral y Geodesta
 */
public class GppEstadocivilDAO implements DAO{

	private GppEstadocivil gppEstadocivil;
	private GppEstadocivilRowMapper gppEstadocivilRowMapper;
	private List<Object> gppEstadosCiviles;
	private Boolean estadoOperation;	
	private String sentenciaSQL;
	private JdbcTemplate jdbcTemplate;
	
	public boolean actualizar(Object obj) {
		estadoOperation = false;
		try{
			gppEstadocivil = (GppEstadocivil) obj;			
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "update gpp_estadocivil " +
							"set esc_vestadocivil = ?, " +
							"esc_vusumodifica = ?, " +
							"esc_dfecmodifica = ? " +							
							"where esc_nidestadocivil = ?";	
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppEstadocivil.getEscVestadocivil(),
															gppEstadocivil.getEscVusumodifica(),
															gppEstadocivil.getEscDfecmodifica(),
															gppEstadocivil.getEscNidestadocivil()},
															new int[] {Types.VARCHAR,
																		Types.VARCHAR,																		
																		Types.DATE,
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
			sentenciaSQL = "delete from gpp_estadocivil " +
							"where esc_nidestadocivil = ? ";	
			jdbcTemplate.update(sentenciaSQL, new Object[] {idObj}, new int[] {Types.INTEGER});	
			estadoOperation = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return estadoOperation;
	}

	public Object buscarPorId(Object idObj) {
		gppEstadocivil = null;
		try{
			gppEstadocivilRowMapper = new GppEstadocivilRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_estadocivil where esc_nidestadocivil = ?";
			gppEstadocivil = (GppEstadocivil) jdbcTemplate.queryForObject(sentenciaSQL, new Object[] {idObj}, gppEstadocivilRowMapper);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppEstadocivil;
	}

	public List<Object> buscarTodos() {
		gppEstadosCiviles = null;
		try{
			gppEstadocivilRowMapper = new GppEstadocivilRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_estadocivil order by esc_vestadocivil asc";
			gppEstadosCiviles = (List) jdbcTemplate.query(sentenciaSQL, gppEstadocivilRowMapper);
		} catch(Exception ex){
			ex.printStackTrace();
		}
		return gppEstadosCiviles;
	}

	public boolean crear(Object obj) {
		estadoOperation = false;
		try{
			gppEstadocivil = (GppEstadocivil) obj;
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "insert into gpp_estadocivil " +
							"(esc_vestadocivil, esc_vusucrea, esc_dfeccrea) " +
							"values (?, ?, ?)";	
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppEstadocivil.getEscVestadocivil(),
															gppEstadocivil.getEscVusucrea(),
															gppEstadocivil.getEscDfeccrea()},
															new int[] {Types.VARCHAR,
																		Types.VARCHAR,																		
																		Types.DATE});
			estadoOperation = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return estadoOperation;
	}
}