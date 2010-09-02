package co.com.inascol.atenea.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import co.com.inascol.atenea.dao.utils.DAO;
import co.com.inascol.atenea.dao.utils.TemplateManager;
import co.com.inascol.atenea.entity.GppIdioma;
import co.com.inascol.atenea.entity.rowmapper.GppIdiomaRowMapper;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcción de Software
 * Esp. Sistemas de Información Geográfica
 * Ing. Catastral y Geodesta
 */
public class GppIdiomaDAO implements DAO {
	
	private GppIdioma gppIdioma;
	private GppIdiomaRowMapper gppIdiomaRowMapper;
	private List<Object> gppIdiomas;
	private Boolean estadoOperation;	
	private String sentenciaSQL;
	private JdbcTemplate jdbcTemplate;
	
	public boolean actualizar(Object obj) {
		estadoOperation = false;
		try{
			gppIdioma = (GppIdioma) obj;			
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "update gpp_idioma " +
							"set idi_vidioma = ?, " +
							"idi_vusumodifica = ?, " +
							"idi_dfecmodifica = ? " +														
							"where idi_nididioma = ?";	
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppIdioma.getIdiVidioma(),
															gppIdioma.getIdiVusumodifica(),
															gppIdioma.getIdiDfecmodifica(),
															gppIdioma.getIdiNididioma()},
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
			sentenciaSQL = "delete from gpp_idioma " +
							"where idi_nididioma = ? ";	
			jdbcTemplate.update(sentenciaSQL, new Object[] {idObj}, new int[] {Types.INTEGER});	
			estadoOperation = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return estadoOperation;
	}

	public Object buscarPorId(Object idObj) {
		gppIdioma = null;
		try{
			gppIdiomaRowMapper = new GppIdiomaRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_idioma where idi_nididioma = ?";
			gppIdioma = (GppIdioma) jdbcTemplate.queryForObject(sentenciaSQL, new Object[] {idObj}, gppIdiomaRowMapper);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppIdioma;
	}

	public List<Object> buscarTodos() {
		gppIdioma = null;
		try{
			gppIdiomaRowMapper = new GppIdiomaRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_idioma order by idi_vidioma asc";
			gppIdiomas = (List) jdbcTemplate.query(sentenciaSQL, gppIdiomaRowMapper);
		} catch(Exception ex){
			ex.printStackTrace();
		}
		return gppIdiomas;
	}

	public boolean crear(Object obj) {
		estadoOperation = false;
		try{
			gppIdioma = (GppIdioma) obj;
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "insert into gpp_idioma " +
							"(idi_vidioma, idi_vusucrea, idi_dfeccrea)" +
							"values (?, ?, ?)";	
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppIdioma.getIdiVidioma(),
															gppIdioma.getIdiVusucrea(),
															gppIdioma.getIdiDfeccrea()},
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