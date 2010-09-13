package co.com.inascol.atenea.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import co.com.inascol.atenea.dao.utils.DAO;
import co.com.inascol.atenea.dao.utils.TemplateManager;
import co.com.inascol.atenea.entity.GppPais;
import co.com.inascol.atenea.entity.rowmapper.GppPaisRowMapper;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class GppPaisDAO implements DAO {
	
	private GppPais gppPais;
	private GppPaisRowMapper gppPaisRowMapper;
	private List<Object> gppPaiss;
	private Boolean estadoOperation;	
	private String sentenciaSQL;
	private JdbcTemplate jdbcTemplate;
	
	public boolean actualizar(Object obj) {
		estadoOperation = false;
		try{
			gppPais = (GppPais) obj;			
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "update gpp_pais " +
							"set pai_vpais = ?, " +
							"pai_vusumodifica = ?, " +
							"pai_dfecmodifica = ? " +							
							"where pai_nidpais = ?";	
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppPais.getPaiVpais(),
															gppPais.getPaiVusumodifica(),
															gppPais.getPaiDfecmodifica(),
															gppPais.getPaiNidpais()},
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
			sentenciaSQL = "delete from gpp_pais " +
							"where pai_nidpais = ? ";	
			jdbcTemplate.update(sentenciaSQL, new Object[] {idObj}, new int[] {Types.INTEGER});	
			estadoOperation = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return estadoOperation;
	}

	public Object buscarPorId(Object idObj) {
		gppPais = null;
		try{
			gppPaisRowMapper = new GppPaisRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_pais where pai_nidpais = ?";
			gppPais = (GppPais) jdbcTemplate.queryForObject(sentenciaSQL, new Object[] {idObj}, gppPaisRowMapper);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppPais;
	}

	public List<Object> buscarTodos() {
		gppPaiss = null;
		try{
			gppPaisRowMapper = new GppPaisRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_pais order by pai_vpais asc";
			gppPaiss = (List) jdbcTemplate.query(sentenciaSQL, gppPaisRowMapper);
		} catch(Exception ex){
			ex.printStackTrace();
		}
		return gppPaiss;
	}

	public boolean crear(Object obj) {
		estadoOperation = false;
		try{
			gppPais = (GppPais) obj;
			
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "insert into gpp_pais " +
							"(pai_vpais, pai_vusucrea, pai_dfeccrea)" +
							"values (?, ?, ?)";	
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppPais.getPaiVpais(),
															gppPais.getPaiVusucrea(),
															gppPais.getPaiDfeccrea()},
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