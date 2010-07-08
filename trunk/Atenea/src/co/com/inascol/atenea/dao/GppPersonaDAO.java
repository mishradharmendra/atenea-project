package co.com.inascol.atenea.dao;

import java.sql.Types;
import java.util.Iterator;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import co.com.inascol.atenea.dao.utils.DAO;
import co.com.inascol.atenea.dao.utils.TemplateManager;
import co.com.inascol.atenea.entity.GppFormacion;
import co.com.inascol.atenea.entity.GppPerfilprof;
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
							"per_dfecmodifica = ?, " +								
							"pai_npaisresidencia = ?, " +
							"mun_nmpioresidencia = ?, " +
							"per_vactivo = ? " +
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
															gppPersona.getPaiNpaisresidencia(),
															gppPersona.getMunNmpioresidencia(),
															gppPersona.getPerBactivo(),
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
																		Types.INTEGER,
																		Types.INTEGER,
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
			gppPersonas = (List<Object>) jdbcTemplate.query(sentenciaSQL, gppPersonaRowMapper);
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
			sentenciaSQL = "insert into gpp_persona (per_vnombres, per_vapellidos, per_nidentificacion, per_vsexo, per_dfecnacimiento, per_vlibretamilitar, per_vmovil, per_vemail, per_vdireccion, per_vtelefono, gpp_municipio_mun_vidmunicipio, tdc_nidtipodoc, esc_nidestadocivil, per_vusucrea, per_dfeccrea, pai_npaisresidencia, mun_nmpioresidencia, per_vactivo) " +								
							"values (? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,?, ?, ?, ?)";	
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
															gppPersona.getPerDfeccrea(),
															gppPersona.getPaiNpaisresidencia(),
															gppPersona.getMunNmpioresidencia(),
															gppPersona.getPerBactivo()},
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
																		Types.INTEGER,
																		Types.INTEGER,
																		Types.VARCHAR});	
			estadoOperation = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return estadoOperation;
	}
	
	public List<Object> buscarPersonaPorCriterios(List<Object> criteriosBusqueda){
		gppPersonas = null;
		try{
			gppPersonaRowMapper = new GppPersonaRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			String criterioConsulta = "";
			if(criteriosBusqueda.size()>0){
				String [] criterios;
				Iterator<Object> it = criteriosBusqueda.iterator();
				int contadorCriterios = 1;
				while(it.hasNext()){
					if(contadorCriterios == 1){
						criterios = ( (String) it.next() ).split("\\|");
						criterioConsulta = " WHERE " + criterios[0] + " LIKE '%" + criterios[1] + "%'";
					}else{
						criterios = ( (String) it.next() ).split("\\|");
						criterioConsulta = criterioConsulta + " AND " + criterios[0] + " LIKE '%" + criterios[1] + "%'";
					}
					contadorCriterios++;
				}
			}
			sentenciaSQL = "select * from gpp_persona " +
							criterioConsulta;
			gppPersonas = (List) jdbcTemplate.query(sentenciaSQL, gppPersonaRowMapper);
			if(gppPersonas.size()>0){
				GppFormacionDAO gppFormacionDAO = new GppFormacionDAO();
				GppPerfilproDAO gppPerfilproDAO = new GppPerfilproDAO();
				Iterator<Object> it = gppPersonas.iterator();
				while(it.hasNext()){
					gppPersona = (GppPersona) it.next();
					List<Object> gppFormaciones = gppFormacionDAO.buscarFormacionesPersona(gppPersona.getPerNidpersona());
					List<Object> gppPerfiles = gppPerfilproDAO.buscarPerfilesPersona(gppPersona.getPerNidpersona());
					if(gppFormaciones.size()>0){
						gppPersona.setGppFormacion((GppFormacion) gppFormaciones.get(0));
					}
					if(gppPerfiles.size()==1){
						gppPersona.setGppPerfilprofesional((GppPerfilprof) gppPerfiles.get(0));
					}
				}
			}
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppPersonas;
	}
}