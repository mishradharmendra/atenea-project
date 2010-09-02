package co.com.inascol.atenea.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import co.com.inascol.atenea.dao.utils.DAO;
import co.com.inascol.atenea.dao.utils.TemplateManager;
import co.com.inascol.atenea.entity.GppServiciorol;
import co.com.inascol.atenea.entity.rowmapper.GppServiciorolRowMapper;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcción de Software
 * Esp. Sistemas de Información Geográfica
 * Ing. Catastral y Geodesta
 */
public class GppServiciorolDAO implements DAO {
	
	private GppServiciorol gppServiciorol;
	private GppServiciorolRowMapper gppServiciorolRowMapper;
	private List<Object> gppServicioroles;
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
			gppServiciorol = (GppServiciorol) obj;
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "delete from gpp_serviciorol " +
							"where ser_nidservicio = ? " +
							"and rol_nidrol = ? ";	
			jdbcTemplate.update(sentenciaSQL, new Object[] {gppServiciorol.getId().getSerNidservicio(), 
					                                        gppServiciorol.getId().getRolNidrol()}, 
					                             new int[] {Types.INTEGER,
															Types.INTEGER});	
			estadoOperation = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return estadoOperation;
	}

	public List<Object> buscarTodosServiciosRoles(Object obj) {
		gppServicioroles = null;
		try{
			gppServiciorolRowMapper = new GppServiciorolRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_serviciorol where rol_nidrol = ? order by ser_nidservicio asc";
			gppServicioroles = (List) jdbcTemplate.query(sentenciaSQL,new Object[] {obj}, gppServiciorolRowMapper);
		} catch(Exception ex){
			ex.printStackTrace();
		}
		return gppServicioroles;
	}
	
	public Object buscarPorId(Object idObj) {
		gppServiciorol = null;
		try{
			gppServiciorol = (GppServiciorol) idObj;
			gppServiciorolRowMapper = new GppServiciorolRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_serviciorol where rol_nidrol = ? and ser_nidservicio = ?";
			gppServiciorol = (GppServiciorol) jdbcTemplate.queryForObject(sentenciaSQL, 
					new Object[] {gppServiciorol.getId().getRolNidrol(), 
									gppServiciorol.getId().getSerNidservicio()},
                    new int[] {Types.INTEGER,
								Types.INTEGER} , gppServiciorolRowMapper);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppServiciorol;
	}

	public List<Object> buscarTodos() {
		gppServicioroles = null;
		try{
			gppServiciorolRowMapper = new GppServiciorolRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_serviciorol order by ser_nidservicio asc";
			gppServicioroles = (List) jdbcTemplate.query(sentenciaSQL, gppServiciorolRowMapper);
		} catch(Exception ex){
			ex.printStackTrace();
		}
		return gppServicioroles;
	}

	public boolean crear(Object obj) {
		estadoOperation = false;
		try{
			gppServiciorol = (GppServiciorol) obj;
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "insert into gpp_serviciorol " +
							"(ser_nidservicio, rol_nidrol, srl_vusucrea, srl_dfeccrea)" +
							"values (?, ?, ?, ?)";	
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppServiciorol.getId().getSerNidservicio(),
															gppServiciorol.getId().getRolNidrol(),
															gppServiciorol.getSrlVusucrea(),
															gppServiciorol.getSrlDfeccrea()},
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