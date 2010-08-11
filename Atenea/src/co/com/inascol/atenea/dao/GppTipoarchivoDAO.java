package co.com.inascol.atenea.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import co.com.inascol.atenea.dao.utils.DAO;
import co.com.inascol.atenea.dao.utils.TemplateManager;
import co.com.inascol.atenea.entity.GppTipoarchivo;
import co.com.inascol.atenea.entity.rowmapper.GppTipoarchivoRowMapper;
/**
 * @author Guillermo Toro
 *
 */
public class GppTipoarchivoDAO implements DAO {
	
	private GppTipoarchivo gppTipoarchivo;
	private GppTipoarchivoRowMapper gppTipoarchivoRowMapper;
	private List<Object> gppTipoarchivos;
	private Boolean estadoOperation;	
	private String sentenciaSQL;
	private JdbcTemplate jdbcTemplate;
	
	public boolean actualizar(Object obj) {
		estadoOperation = false;
		try{
			gppTipoarchivo = (GppTipoarchivo) obj;			
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "update gpp_tipoarchivo " +
							"set tar_vtipoarchivo = ?, " +
							"tar_vusumodifica = ?, " +
							"tar_dfecmodifica = ? " +														
							"where tar_nidtipoarchivo = ?";	
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppTipoarchivo.getTarVtipoarchivo(),
															gppTipoarchivo.getTarVusumodifica(),
															gppTipoarchivo.getTarDfecmodifica(),
															gppTipoarchivo.getTarNidtipoarchivo()},
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
			sentenciaSQL = "delete from gpp_tipoarchivo " +
							"where tar_nidtipoarchivo = ? ";	
			jdbcTemplate.update(sentenciaSQL, new Object[] {idObj}, new int[] {Types.INTEGER});	
			estadoOperation = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return estadoOperation;
	}

	public Object buscarPorId(Object idObj) {
		gppTipoarchivo = null;
		try{
			gppTipoarchivoRowMapper = new GppTipoarchivoRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_tipoarchivo where tar_nidtipoarchivo = ?";
			gppTipoarchivo = (GppTipoarchivo) jdbcTemplate.queryForObject(sentenciaSQL, new Object[] {idObj}, gppTipoarchivoRowMapper);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppTipoarchivo;
	}

	public List<Object> buscarTodos() {
		gppTipoarchivo = null;
		try{
			gppTipoarchivoRowMapper = new GppTipoarchivoRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_tipoarchivo order by tar_vtipoarchivo asc";
			gppTipoarchivos = (List) jdbcTemplate.query(sentenciaSQL, gppTipoarchivoRowMapper);
		} catch(Exception ex){
			ex.printStackTrace();
		}
		return gppTipoarchivos;
	}

	public boolean crear(Object obj) {
		estadoOperation = false;
		try{
			gppTipoarchivo = (GppTipoarchivo) obj;
			
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "insert into gpp_tipoarchivo " +
							"(tar_vtipoarchivo, tar_vusucrea, tar_dfeccrea)" +
							"values ( ?, ?, ? )";	
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppTipoarchivo.getTarVtipoarchivo(),
															gppTipoarchivo.getTarVusucrea(),
															gppTipoarchivo.getTarDfeccrea()},
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