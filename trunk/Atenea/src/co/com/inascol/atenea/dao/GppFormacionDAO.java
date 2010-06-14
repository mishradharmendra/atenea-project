package co.com.inascol.atenea.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import co.com.inascol.atenea.dao.utils.DAO;
import co.com.inascol.atenea.dao.utils.TemplateManager;
import co.com.inascol.atenea.entity.GppFormacion;
import co.com.inascol.atenea.entity.rowmapper.GppFormacionRowMapper;

public class GppFormacionDAO implements DAO{

	private GppFormacion gppFormacion;
	private GppFormacionRowMapper gppFormacionRowMapper;
	private List<Object> gppFormaciones;
	private Boolean estadoOperation;	
	private String sentenciaSQL;
	private JdbcTemplate jdbcTemplate;
	
	public boolean actualizar(Object obj) {
		estadoOperation = false;
		try{
			gppFormacion = (GppFormacion) obj;			
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "update gpp_formacion " +
							"set for_vtitulo = ?, " +
							"for_dfecgrado = ?, " +
							"for_nduracionmes = ?, " +
							"for_vtarjetaprof = ?, " +
							"for_dfectarjeta = ?, " +	
							"per_nidpersona = ?, " +
							"nac_nidnivelac = ?, " +	
							"Ins_nidinstitucion = ?, " +
							"teq_nidtituloeq = ?, " +	
							"doc_ntarjetaprof = ?, " +
							"doc_nactagrado = ?, " +	
							"doc_nidiploma = ?, " +
							"for_vusumodifica = ?, " +	
							"for_dfecmodifica = ? " +								
							"where for_nidformacion = ?";	
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppFormacion.getForVtitulo(),
															gppFormacion.getForDfecgrado(),
															gppFormacion.getForNduracionmes(),
															gppFormacion.getForVtarjetaprof(),
															gppFormacion.getForDfectarjeta(),
															gppFormacion.getPerNidpersona(),
															gppFormacion.getNacNidnivelac(),
															gppFormacion.getInsNidinstitucion(),
															gppFormacion.getTeqNidtituloeq(),
															gppFormacion.getDocNtarjetaprof(),
															gppFormacion.getDocNactagrado(),
															gppFormacion.getDocNidiploma(),
															gppFormacion.getForVusumodifica(),
															gppFormacion.getForDfecmodifica(),
															gppFormacion.getForNidformacion()},
															new int[] {Types.VARCHAR,
																		Types.DATE,
																		Types.INTEGER,																		
																		Types.VARCHAR,
																		Types.DATE,
																		Types.INTEGER,
																		Types.INTEGER,																		
																		Types.INTEGER,
																		Types.INTEGER,
																		Types.INTEGER,
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
			sentenciaSQL = "delete from gpp_formacion " +
							"where for_nidformacion = ? ";	
			jdbcTemplate.update(sentenciaSQL, new Object[] {idObj}, new int[] {Types.INTEGER});	
			estadoOperation = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return estadoOperation;
	}

	public Object buscarPorId(Object idObj) {
		gppFormacion = null;
		try{
			gppFormacionRowMapper = new GppFormacionRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_formacion where for_nidformacion = ?";
			gppFormacion = (GppFormacion) jdbcTemplate.queryForObject(sentenciaSQL, new Object[] {idObj}, gppFormacionRowMapper);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppFormacion;
	}

	public List<Object> buscarTodos() {
		gppFormaciones = null;
		try{
			gppFormacionRowMapper = new GppFormacionRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_formacion order by for_nidformacion asc";
			gppFormaciones = (List) jdbcTemplate.query(sentenciaSQL, gppFormacionRowMapper);
		} catch(Exception ex){
			ex.printStackTrace();
		}
		return gppFormaciones;
	}

	public boolean crear(Object obj) {
		estadoOperation = false;
		try{
			gppFormacion = (GppFormacion) obj;			
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "insert into gpp_formacion (for_vtitulo, for_dfecgrado, for_nduracionmes, for_vtarjetaprof, for_dfectarjeta, per_nidpersona, nac_nidnivelac, Ins_nidinstitucion, teq_nidtituloeq, doc_ntarjetaprof, doc_nactagrado, doc_nidiploma, for_vusucrea, for_dfeccrea) " +
							"values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppFormacion.getForVtitulo(),
															gppFormacion.getForDfecgrado(),
															gppFormacion.getForNduracionmes(),
															gppFormacion.getForVtarjetaprof(),
															gppFormacion.getForDfectarjeta(),
															gppFormacion.getPerNidpersona(),
															gppFormacion.getNacNidnivelac(),
															gppFormacion.getInsNidinstitucion(),
															gppFormacion.getTeqNidtituloeq(),
															gppFormacion.getDocNtarjetaprof(),
															gppFormacion.getDocNactagrado(),
															gppFormacion.getDocNidiploma(),
															gppFormacion.getForVusucrea(),
															gppFormacion.getForDfeccrea()},
															new int[] {Types.VARCHAR,
																		Types.DATE,
																		Types.INTEGER,																		
																		Types.VARCHAR,
																		Types.DATE,
																		Types.INTEGER,
																		Types.INTEGER,																		
																		Types.INTEGER,
																		Types.INTEGER,
																		Types.INTEGER,
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
	
	public List<Object> buscarFormacionesPersona(Object idObj){
		gppFormaciones = null;
		try{
			gppFormacionRowMapper = new GppFormacionRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_formacion where per_nidpersona = ? order by for_nidformacion asc";
			gppFormaciones = (List) jdbcTemplate.query(sentenciaSQL, new Object[] {idObj}, gppFormacionRowMapper);
		} catch(Exception ex){
			ex.printStackTrace();
		}
		return gppFormaciones;	
	}
}