package co.com.inascol.atenea.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import co.com.inascol.atenea.dao.utils.DAO;
import co.com.inascol.atenea.dao.utils.TemplateManager;
import co.com.inascol.atenea.entity.GppPersona;
import co.com.inascol.atenea.entity.rowmapper.GppPersonaRowMapper;

public class GppPersonaDAO implements DAO{

	private GppPersona gppPersona;
	private GppPersonaRowMapper gppPersonaRowMapper;
	private List<Object> gppPersonas;
	private Boolean estadoOperation;	
	private String sentenciaSQL;
	private JdbcTemplate jdbcTemplate;

	public boolean actualizar(Object obj) {
		estadoOperation = false;
		try{
			gppPersona = (GppPersona) obj;			
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "update gpp_persona " +
							"set per_vnombres = ?, " +
							"per_vapellidos = ?, " +
							"per_nidentificacion = ?, " +
							"per_vsexo = ?, " +
							"per_dfecnacimiento = ?, " +
							"per_vlibretamilitar = ?, " +	
							"per_vmovil = ?, " +
							"per_vemail = ?, " +	
							"per_vdireccion = ?, " +
							"per_vtelefono = ?, " +	
							"gpp_municipio_mun_vidmunicipio = ?, " +
							"tdc_nidtipodoc = ?, " +	
							"esc_nidestadocivil = ?, " +
							"per_vusumodifica = ?, " +
							"per_dfecmodifica = ? " +								
							"where per_nidpersona = ?";	
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppPersona.getPerVnombres(),
															gppPersona.getPerVapellidos(),
															gppPersona.getPerNidentificacion(),
															gppPersona.getPerVsexo(),
															gppPersona.getPerDfecnacimiento(),
															gppPersona.getPerVlibretamilitar(),
															gppPersona.getPerVmovil(),
															gppPersona.getPerVemail(),
															gppPersona.getPerVdireccion(),
															gppPersona.getPerVtelefono(),
															gppPersona.getMunVidmunicipio(),
															gppPersona.getTdcNidtipodoc(),
															gppPersona.getEscNidestadocivil(),
															gppPersona.getPerVusumodifica(),
															gppPersona.getPerDfecmodifica(),
															gppPersona.getPerNidpersona()},
															new int[] {Types.VARCHAR,
																		Types.VARCHAR,
																		Types.INTEGER,
																		Types.VARCHAR,
																		Types.DATE,
																		Types.VARCHAR,
																		Types.VARCHAR,
																		Types.VARCHAR,
																		Types.VARCHAR,
																		Types.VARCHAR,
																		Types.VARCHAR,
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
			sentenciaSQL = "delete from gpp_persona " +
							"where per_nidpersona = ? ";	
			jdbcTemplate.update(sentenciaSQL, new Object[] {idObj}, new int[] {Types.INTEGER});	
			estadoOperation = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return estadoOperation;
	}

	public Object buscarPorId(Object idObj) {
		gppPersona = null;
		try{
			gppPersonaRowMapper = new GppPersonaRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_persona where per_nidpersona = ?";
			gppPersona = (GppPersona) jdbcTemplate.queryForObject(sentenciaSQL, new Object[] {idObj}, gppPersonaRowMapper);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppPersona;
	}

	public List<Object> buscarTodos() {
		gppPersonas = null;
		try{
			gppPersonaRowMapper = new GppPersonaRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_persona order by per_vnombres asc";
			gppPersonas = (List) jdbcTemplate.query(sentenciaSQL, gppPersonaRowMapper);
		} catch(Exception ex){
			ex.printStackTrace();
		}
		return gppPersonas;
	}

	public boolean crear(Object obj) {
		estadoOperation = false;
		try{
			gppPersona = (GppPersona) obj;			
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "insert into gpp_persona (per_vnombres, per_vapellidos, per_nidentificacion, per_vsexo, per_dfecnacimiento, per_vlibretamilitar, per_vmovil, per_vemail, per_vdireccion, per_vtelefono, gpp_municipio_mun_vidmunicipio, tdc_nidtipodoc, esc_nidestadocivil, per_vusucrea, per_dfeccrea) " +								
							"values (? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,?)";	
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppPersona.getPerVnombres(),
															gppPersona.getPerVapellidos(),
															gppPersona.getPerNidentificacion(),
															gppPersona.getPerVsexo(),
															gppPersona.getPerDfecnacimiento(),
															gppPersona.getPerVlibretamilitar(),
															gppPersona.getPerVmovil(),
															gppPersona.getPerVemail(),
															gppPersona.getPerVdireccion(),
															gppPersona.getPerVtelefono(),
															gppPersona.getMunVidmunicipio(),
															gppPersona.getTdcNidtipodoc(),
															gppPersona.getEscNidestadocivil(),
															gppPersona.getPerVusucrea(),
															gppPersona.getPerDfeccrea()},
															new int[] {Types.VARCHAR,
																		Types.VARCHAR,
																		Types.INTEGER,
																		Types.VARCHAR,
																		Types.DATE,
																		Types.VARCHAR,
																		Types.VARCHAR,
																		Types.VARCHAR,
																		Types.VARCHAR,
																		Types.VARCHAR,
																		Types.VARCHAR,
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
	
	public GppPersona buscarPersonaPorCedula(Object numeroCedula){
		gppPersona = null;
		try{
			gppPersonaRowMapper = new GppPersonaRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_persona where per_nidentificacion = ?";
			gppPersona = (GppPersona) jdbcTemplate.queryForObject(sentenciaSQL, new Object[] {numeroCedula}, gppPersonaRowMapper);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppPersona;
	}
}