package co.com.inascol.atenea.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import co.com.inascol.atenea.dao.utils.DAO;
import co.com.inascol.atenea.dao.utils.TemplateManager;
import co.com.inascol.atenea.entity.GppServicio;
import co.com.inascol.atenea.entity.rowmapper.GppServicioRowMapper;
/**
 * @author Guillermo Toro
 *
 */
public class GppServicioDAO implements DAO {
	
	private GppServicio gppServicio;
	private GppServicioRowMapper gppServicioRowMapper;
	private List<Object> gppServicios;
	private Boolean estadoOperation;	
	private String sentenciaSQL;
	private JdbcTemplate jdbcTemplate;
	
	public boolean actualizar(Object obj) {
		estadoOperation = false;
		try{
			gppServicio = (GppServicio) obj;			
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "update gpp_servicio " +
							"set ser_vnombre = ?, " +
							"ser_vruta = ? " +
							"where ser_nidservicio = ?";	
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppServicio.getSerVnombre(),
															gppServicio.getSerVruta(),
															gppServicio.getSerNidservicio()},
															new int[] {Types.VARCHAR,
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
			sentenciaSQL = "delete from gpp_servicio " +
							"where ser_nidservicio = ? ";	
			jdbcTemplate.update(sentenciaSQL, new Object[] {idObj}, new int[] {Types.INTEGER});	
			estadoOperation = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return estadoOperation;
	}

	public Object buscarPorId(Object idObj) {
		gppServicio = null;
		try{
			gppServicioRowMapper = new GppServicioRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_servicio where ser_nidservicio = ?";
			gppServicio = (GppServicio) jdbcTemplate.queryForObject(sentenciaSQL, new Object[] {idObj}, gppServicioRowMapper);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppServicio;
	}

	public List<Object> buscarTodos() {
		gppServicio = null;
		try{
			gppServicioRowMapper = new GppServicioRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_servicio order by ser_nidservicio asc";
			gppServicios = (List) jdbcTemplate.query(sentenciaSQL, gppServicioRowMapper);
		} catch(Exception ex){
			ex.printStackTrace();
		}
		return gppServicios;
	}

	public boolean crear(Object obj) {
		estadoOperation = false;
		try{
			gppServicio = (GppServicio) obj;
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "insert into gpp_servicio " +
							"( ser_nidservicio, ser_vnombre, ser_vruta, ser_vusucrea, ser_dfeccrea)" +
							"values (?, ?, ?, ?, ?)";	
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppServicio.getSerNidservicio(),
															gppServicio.getSerVnombre(),
															gppServicio.getSerVruta(),
															gppServicio.getSerVusucrea(),
															gppServicio.getSerDfeccrea()},
															new int[] {Types.INTEGER,
																		Types.VARCHAR,
																		Types.VARCHAR,
																		Types.VARCHAR,
																		Types.DATE});
			estadoOperation = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return estadoOperation;
	}
}