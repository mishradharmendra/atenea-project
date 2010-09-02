package co.com.inascol.atenea.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import co.com.inascol.atenea.dao.utils.DAO;
import co.com.inascol.atenea.dao.utils.TemplateManager;
import co.com.inascol.atenea.entity.GppCargoequivalente;
import co.com.inascol.atenea.entity.rowmapper.GppCargoequivalenteRowMapper;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcción de Software
 * Esp. Sistemas de Información Geográfica
 * Ing. Catastral y Geodesta
 */
public class GppCargoequivalenteDAO implements DAO{

	private GppCargoequivalente gppCargoequivalente;
	private GppCargoequivalenteRowMapper gppCargoequivalenteRowMapper;
	private List<Object> gppCargosequivalentes;
	private Boolean estadoOperation;	
	private String sentenciaSQL;
	private JdbcTemplate jdbcTemplate;
	
	public boolean actualizar(Object obj) {
		estadoOperation = false;
		try{
			gppCargoequivalente = (GppCargoequivalente) obj;			
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "update gpp_cargoequivalente " +
							"set ceq_vcargoeq = ?, " +
							"ceq_vusumodifica = ?, " +
							"ceq_dfecmodifica = ? " +							
							"where ceq_nidcargoeq = ?";	
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppCargoequivalente.getCeqVcargoeq(),
															gppCargoequivalente.getCeqVusumodifica(),
															gppCargoequivalente.getCeqDfecmodifica(),
															gppCargoequivalente.getCeqNidcargoeq()},
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
			sentenciaSQL = "delete from gpp_cargoequivalente " +
							"where ceq_nidcargoeq = ? ";	
			jdbcTemplate.update(sentenciaSQL, new Object[] {idObj}, new int[] {Types.INTEGER});	
			estadoOperation = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return estadoOperation;
	}

	public Object buscarPorId(Object idObj) {
		gppCargoequivalente = null;
		try{
			gppCargoequivalenteRowMapper = new GppCargoequivalenteRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_cargoequivalente where ceq_nidcargoeq = ?";
			gppCargoequivalente = (GppCargoequivalente) jdbcTemplate.queryForObject(sentenciaSQL, new Object[] {idObj}, gppCargoequivalenteRowMapper);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppCargoequivalente;
	}

	public List<Object> buscarTodos() {
		gppCargosequivalentes = null;
		try{
			gppCargoequivalenteRowMapper = new GppCargoequivalenteRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_cargoequivalente order by ceq_vcargoeq asc";
			gppCargosequivalentes = (List) jdbcTemplate.query(sentenciaSQL, gppCargoequivalenteRowMapper);
		} catch(Exception ex){
			ex.printStackTrace();
		}
		return gppCargosequivalentes;
	}

	public boolean crear(Object obj) {
		estadoOperation = false;
		try{
			gppCargoequivalente = (GppCargoequivalente) obj;
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "insert into gpp_cargoequivalente " +
							"(ceq_vcargoeq, ceq_vusucrea, ceq_dfeccrea) " +
							"values (?, ?, ?)";	
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppCargoequivalente.getCeqVcargoeq(),
															gppCargoequivalente.getCeqVusucrea(),
															gppCargoequivalente.getCeqDfeccrea()},
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