package co.com.inascol.atenea.dao;

import java.sql.Types;
import java.util.Iterator;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import co.com.inascol.atenea.dao.utils.DAO;
import co.com.inascol.atenea.dao.utils.TemplateManager;
import co.com.inascol.atenea.entity.GppDocumento;
import co.com.inascol.atenea.entity.GppTipoarchivo;
import co.com.inascol.atenea.entity.rowmapper.GppDocumentoRowMapper;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class GppDocumentoDAO implements DAO{

	private GppDocumento gppDocumento;
	private GppDocumentoRowMapper gppDocumentoRowMapper;
	private List<Object> gppDocumentos;
	private Boolean estadoOperation;	
	private String sentenciaSQL;
	private JdbcTemplate jdbcTemplate;
	
	public boolean actualizar(Object obj) {
		estadoOperation = false;
		try{
			gppDocumento = (GppDocumento) obj;			
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "update gpp_documento " +
							"set doc_vnombre = ?, " +
							"doc_varchivo = ?, " +
							"doc_vurlarchivo = ?, " +
							"doc_dfecexpide = ?, " +
							"per_nidpersona = ?, " +
							"tar_nidtipoarchivo = ?, " +
							"doc_vusumodifica = ?, " +
							"doc_dfecmodifica = ? " +
							"where doc_niddocumento = ?";	
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppDocumento.getDocVnombre(),
															gppDocumento.getDocVarchivo(),
															gppDocumento.getDocVurlarchivo(),
															gppDocumento.getDocDfecexpide(),
															gppDocumento.getPerNidpersona(),
															gppDocumento.getTarNidtipoarchivo(),
															gppDocumento.getDocVusumodifica(),
															gppDocumento.getDocDfecmodifica(),
															gppDocumento.getDocNiddocumento()},
															new int[] {Types.VARCHAR,
																		Types.VARCHAR,
																		Types.VARCHAR,
																		Types.DATE,
																		Types.INTEGER,
																		Types.INTEGER,
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
			sentenciaSQL = "delete from gpp_documento " +
							"where doc_niddocumento = ? ";	
			jdbcTemplate.update(sentenciaSQL, new Object[] {idObj}, new int[] {Types.INTEGER});	
			estadoOperation = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return estadoOperation;
	}

	public Object buscarPorId(Object idObj) {
		gppDocumento = null;
		try{
			gppDocumentoRowMapper = new GppDocumentoRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_documento where doc_niddocumento = ?";
			gppDocumento = (GppDocumento) jdbcTemplate.queryForObject(sentenciaSQL, new Object[] {idObj}, gppDocumentoRowMapper);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppDocumento;
	}

	public List<Object> buscarTodos() {
		gppDocumentos = null;
		try{
			gppDocumentoRowMapper = new GppDocumentoRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_documento order by doc_vnombre asc";
			gppDocumentos = (List) jdbcTemplate.query(sentenciaSQL, gppDocumentoRowMapper);
		} catch(Exception ex){
			ex.printStackTrace();
		}
		return gppDocumentos;
	}

	public boolean crear(Object obj) {
		estadoOperation = false;
		try{
			gppDocumento = (GppDocumento) obj;			
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "insert into gpp_documento (doc_vnombre, doc_varchivo, doc_vurlarchivo, doc_dfecexpide, per_nidpersona, tar_nidtipoarchivo, doc_vusucrea, doc_dfeccrea) " +
							"values (?, ?, ?, ?, ?, ?, ?, ?)";	
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppDocumento.getDocVnombre(),
															gppDocumento.getDocVarchivo(),
															gppDocumento.getDocVurlarchivo(),
															gppDocumento.getDocDfecexpide(),
															gppDocumento.getPerNidpersona(),
															gppDocumento.getTarNidtipoarchivo(),
															gppDocumento.getDocVusucrea(),
															gppDocumento.getDocDfeccrea()},
															new int[] {Types.VARCHAR,
																		Types.VARCHAR,
																		Types.VARCHAR,
																		Types.DATE,
																		Types.INTEGER,
																		Types.INTEGER,
																		Types.VARCHAR,
																		Types.DATE});	
			estadoOperation = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return estadoOperation;
	}
	
	public List<Object> buscarDocumentosPorPersona(Integer idPersona){
		gppDocumentos = null;
		try{
			gppDocumentoRowMapper = new GppDocumentoRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_documento where per_nidpersona = ?";
			gppDocumentos = (List) jdbcTemplate.query(sentenciaSQL, new Object[]{idPersona}, gppDocumentoRowMapper);
			if(gppDocumentos.size()>0){
				GppTipoarchivoDAO gppTipoarchivoDAO = new GppTipoarchivoDAO();
				Iterator<Object> it = gppDocumentos.iterator();
				while(it.hasNext()){
					gppDocumento = (GppDocumento) it.next();
					gppDocumento.setGppTipoarchivo((GppTipoarchivo) gppTipoarchivoDAO.buscarPorId(gppDocumento.getTarNidtipoarchivo()));
				}
			}
		} catch(Exception ex){
			ex.printStackTrace();
		}
		return gppDocumentos;		
	}
}