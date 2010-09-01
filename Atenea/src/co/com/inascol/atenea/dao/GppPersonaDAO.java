package co.com.inascol.atenea.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;

import co.com.inascol.atenea.dao.utils.DAO;
import co.com.inascol.atenea.dao.utils.TemplateManager;
import co.com.inascol.atenea.entity.GppExperiencia;
import co.com.inascol.atenea.entity.GppFormacion;
import co.com.inascol.atenea.entity.GppNivelacademico;
import co.com.inascol.atenea.entity.GppPerfilprof;
import co.com.inascol.atenea.entity.GppPersona;
import co.com.inascol.atenea.entity.rowmapper.GppConsultaRapidaRowMapper;
import co.com.inascol.atenea.entity.rowmapper.GppPersonaRowMapper;
import co.com.inascol.atenea.util.Calculos;
/**
 * @author Guillermo Toro
 *
 */
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
															gppPersona.getMunNidmunicipio(),
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
																		Types.INTEGER,
																		Types.INTEGER,
																		Types.INTEGER,
																		Types.VARCHAR,
																		Types.DATE,
																		Types.INTEGER,
																		Types.INTEGER,
																		Types.VARCHAR,
																		Types.INTEGER});	
			estadoOperation = true;
		} catch (DataIntegrityViolationException ex) {
			System.out.println("Numero de Identificacion Duplicado");
		} catch (Exception ex){
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
			construirDatosPersonas(gppPersonas);
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
															gppPersona.getMunNidmunicipio(),
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
																		Types.INTEGER,
																		Types.INTEGER,
																		Types.INTEGER,
																		Types.VARCHAR,
																		Types.DATE,
																		Types.INTEGER,
																		Types.INTEGER,
																		Types.VARCHAR});	
			estadoOperation = true;
		} catch (DataIntegrityViolationException ex) {
			System.out.println("Numero de Identificacion Duplicado");
		} catch (Exception ex){
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
				String banderaConsulta = "";
				criterios = ( (String) it.next() ).split("\\|");
				banderaConsulta = criterios[0];
				while(it.hasNext()){
					if(banderaConsulta.equalsIgnoreCase("UNO")){
						if(contadorCriterios == 1){
							criterios = ( (String) it.next() ).split("\\|");						
							criterioConsulta = " WHERE " + criterios[0] + " LIKE '%" + criterios[1] + "%'";
						}else{
							criterios = ( (String) it.next() ).split("\\|");
							criterioConsulta = criterioConsulta + " " + criterios[1] + " " + criterios[0] + " LIKE '%" + criterios[2] + "%'";
						}
						contadorCriterios++;
					}else if(banderaConsulta.equalsIgnoreCase("DOS")){
						if(contadorCriterios == 1){
							criterios = ( (String) it.next() ).split("\\|");						
							criterioConsulta = " WHERE ( " + criterios[0] + " LIKE '%" + criterios[1] + "%'";
						}else{
							criterios = ( (String) it.next() ).split("\\|");
							if(criterios[0].equalsIgnoreCase("per_nidentificacion"))
								criterioConsulta = criterioConsulta + " AND " + criterios[0] + " LIKE '%" + criterios[1] + "%'";
							else
								criterioConsulta = criterioConsulta + " " + criterios[1] + " " + criterios[0] + " LIKE '%" + criterios[2] + "%' )";
						}
						contadorCriterios++;	
					}
				}
			}
			sentenciaSQL = "select * from gpp_persona " +
							criterioConsulta;
			gppPersonas = (List) jdbcTemplate.query(sentenciaSQL, gppPersonaRowMapper);
			construirDatosPersonas(gppPersonas);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppPersonas;
	}
	
	public List<Object> buscarPersonaPorCriteriosAvanzados(List<Object> criteriosBusqueda){
		gppPersonas = null;
		try{
			gppPersonaRowMapper = new GppPersonaRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			String criterioConsulta = "";
			if(criteriosBusqueda.size()>0){
				String criterios;
				Iterator<Object> it = criteriosBusqueda.iterator();
				int contadorCriterios = 1;
				while(it.hasNext()){
					criterios = (String) it.next();
					criterioConsulta += "AND " +criterios+" ";
					contadorCriterios++;
				}
			}
			sentenciaSQL = "select p.per_nidpersona " +
							"from gpp_persona p, gpp_perfilprof pp, gpp_experiencia e, gpp_formacion pre, gpp_formacion esp, gpp_formacion msc " +
							"where p.per_nidpersona = pp.per_nidpersona " +
							"and p.per_nidpersona = e.per_nidpersona " +
							"and p.per_nidpersona = pre.per_nidpersona " +
							"and p.per_nidpersona = esp.per_nidpersona " +
							"and p.per_nidpersona = msc.per_nidpersona " +
							criterioConsulta +
							"group by p.per_nidpersona ";
			List<Object> idPersonas = (List) jdbcTemplate.queryForList(sentenciaSQL, Integer.class);
			if(idPersonas.size()>0){
				Iterator<Object> itPersonas = idPersonas.iterator();
				List<Object> criteriosConsultaNuevos = new ArrayList<Object>();
				while(itPersonas.hasNext()){
					Integer idPersona = (Integer) itPersonas.next();
					criteriosConsultaNuevos.add("per_nidpersona"+"|"+idPersona);
				}				
				if(criteriosConsultaNuevos.size()>0){
					String [] criterios;
					Iterator<Object> it = criteriosConsultaNuevos.iterator();
					int contadorCriterios = 1;
					while(it.hasNext()){
						if(contadorCriterios == 1){
							criterios = ( (String) it.next() ).split("\\|");
							criterioConsulta = " WHERE " + criterios[0] + " = " + criterios[1];
						}else{
							criterios = ( (String) it.next() ).split("\\|");
							criterioConsulta = criterioConsulta + " OR " + criterios[0] + " = " + criterios[1];
						}
						contadorCriterios++;
					}
				}
				sentenciaSQL = "select * from gpp_persona " +
				criterioConsulta;
				gppPersonas = (List) jdbcTemplate.query(sentenciaSQL, gppPersonaRowMapper);
				construirDatosPersonas(gppPersonas);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return gppPersonas;
	}
	
	public List<Object> buscarPersonaPorCriterioRapido(String criterioBusquedaRapida){
		try{
			GppConsultaRapidaRowMapper gppConsultaRapidaRowMapper = new GppConsultaRapidaRowMapper();
			gppPersonaRowMapper = new GppPersonaRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			String criterioConsulta = "";
			sentenciaSQL = "select * from gpp_consulta_avanzada";
			List<Object> camposVista = (List) jdbcTemplate.query(sentenciaSQL, gppConsultaRapidaRowMapper);
			if(camposVista!=null){
				if(camposVista.size()>0){
					Iterator<Object> itCampos = camposVista.iterator();
					Integer control = 1;
					while(itCampos.hasNext()){
						if(control==1){
							criterioConsulta += "WHERE " + (String) itCampos.next() + " LIKE '%" +criterioBusquedaRapida + "%' ";
							control++;
						}
						else
							criterioConsulta += "OR " + (String) itCampos.next() + " LIKE '%" +criterioBusquedaRapida + "%' ";
					}
				}
				sentenciaSQL = "select per_nidpersona from gpp_consulta_avanzada " +
								criterioConsulta + " " +
								"group by per_nidpersona";
				List<Object> idPersonas = (List) jdbcTemplate.queryForList(sentenciaSQL, Integer.class);
				if(idPersonas.size()>0){
					Iterator<Object> itPersonas = idPersonas.iterator();
					List<Object> criteriosConsultaNuevos = new ArrayList<Object>();
					while(itPersonas.hasNext()){
						Integer idPersona = (Integer) itPersonas.next();
						criteriosConsultaNuevos.add("per_nidpersona"+"|"+idPersona);
					}				
					if(criteriosConsultaNuevos.size()>0){
						String [] criterios;
						Iterator<Object> it = criteriosConsultaNuevos.iterator();
						int contadorCriterios = 1;
						while(it.hasNext()){
							if(contadorCriterios == 1){
								criterios = ( (String) it.next() ).split("\\|");
								criterioConsulta = " WHERE " + criterios[0] + " = " + criterios[1];
							}else{
								criterios = ( (String) it.next() ).split("\\|");
								criterioConsulta = criterioConsulta + " OR " + criterios[0] + " = " + criterios[1];
							}
							contadorCriterios++;
						}
					}
					sentenciaSQL = "select * from gpp_persona " +
					criterioConsulta;
					gppPersonas = (List) jdbcTemplate.query(sentenciaSQL, gppPersonaRowMapper);
					construirDatosPersonas(gppPersonas);
				}
			}
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return gppPersonas;
	}
	
	public void construirDatosPersonas(List<Object> gppPersonas){
		if(gppPersonas.size()>0){
			GppFormacionDAO gppFormacionDAO = new GppFormacionDAO();
			GppPerfilproDAO gppPerfilproDAO = new GppPerfilproDAO();
			GppExperienciaDAO gppExperienciaDAO = new GppExperienciaDAO();
			GppNivelacademicoDAO nivelacademicoDAO = new GppNivelacademicoDAO();
			Iterator<Object> it = gppPersonas.iterator();
			while(it.hasNext()){
				gppPersona = (GppPersona) it.next();
				List<Object> gppFormaciones = gppFormacionDAO.buscarFormacionesPersona(gppPersona.getPerNidpersona());
				List<Object> gppPerfiles = gppPerfilproDAO.buscarPerfilesPersona(gppPersona.getPerNidpersona());
				List<Object> gppExperienciasLaborales = gppExperienciaDAO.buscarExperienciasPersona(gppPersona.getPerNidpersona());
				List<Object> gppCertificaciones = new ArrayList<Object>();
				if(gppFormaciones.size()>0){
					gppPersona.setGppFormaciones(organizarFormaciones(gppFormaciones));
					Iterator<Object> itFormacion = gppFormaciones.iterator();
					while(itFormacion.hasNext()){
						GppFormacion gppFormacion = (GppFormacion) itFormacion.next();
						GppNivelacademico gppNivelacademico = (GppNivelacademico) nivelacademicoDAO.buscarPorId(gppFormacion.getNacNidnivelac());
						CharSequence nombreCertificacion = "certifica";
						if(gppNivelacademico.getNacVnivelac().toLowerCase().contains(nombreCertificacion)){
							gppCertificaciones.add(gppFormacion);
						}
					}
					gppPersona.setGppCertificaciones(gppCertificaciones);
				}
				if(gppPerfiles.size()==1){
					gppPersona.setGppPerfilprofesional((GppPerfilprof) gppPerfiles.get(0));
				}
				if(gppExperienciasLaborales.size()>0){
					gppPersona.setGppExperienciasLaborales(organizarExperiencias(gppExperienciasLaborales));
				}
				gppPersona.setPerNpuntaje(getPuntajePersona(gppPersona));
			}
		}
	}
	
	public Integer getPuntajePersona(GppPersona gppPersona){
		Integer puntajeFormacion = 0;
		Integer puntajeExpe = 0;
		Date fechaPregrado = null;
		// Calculo de Otras Formaciones
		if(gppPersona.getGppFormaciones()!=null){
			if(gppPersona.getGppFormaciones().size()>0){
				Iterator<Object> itFormaciones = gppPersona.getGppFormaciones().iterator();
				GppFormacion gppFormacion = null;
				Boolean banderaOtros = false;
				Boolean banderaPregrado = false;
				Boolean banderaEspe = false;
				Boolean banderaMSc = false;
				Boolean banderaPmp = false;
				Boolean banderaJavaNet = false;
				// Formacion de Otros
				while(itFormaciones.hasNext()){
					gppFormacion = (GppFormacion) itFormaciones.next();
					if(gppFormacion.getNacNidnivelac()==1 || gppFormacion.getNacNidnivelac()==2
							|| gppFormacion.getNacNidnivelac()==6 || gppFormacion.getNacNidnivelac()==7
								|| gppFormacion.getNacNidnivelac()==8 || gppFormacion.getNacNidnivelac()==9 || gppFormacion.getNacNidnivelac()==10){
						if(banderaOtros==false){
							puntajeFormacion += 10;
							banderaOtros = true;
						}
					}
					// Formacion de Pregrado
					if(gppFormacion.getNacNidnivelac()==3){
						if(banderaPregrado==false){
							puntajeFormacion += 20;
							banderaPregrado=true;
							fechaPregrado = gppFormacion.getForDfecgrado();
						}
						if( (fechaPregrado.getTime() > gppFormacion.getForDfecgrado().getTime()) ){
							fechaPregrado = gppFormacion.getForDfecgrado();
						}
					}
					// Formacion Especializacion
					if(gppFormacion.getNacNidnivelac()==4){
						if(banderaEspe==false){
							puntajeFormacion += 10;
							banderaEspe=true;
						}
					}
					// Formacion Maestria
					if(gppFormacion.getNacNidnivelac()==5){
						if(banderaMSc==false){
							puntajeFormacion += 20;
							banderaMSc = true;
						}
					}
					// Formacion Certificacion PMP
					if(gppFormacion.getNacNidnivelac()==11){
						if(banderaPmp==false){
							puntajeFormacion += 15;
							banderaPmp = true;
						}
					}
					// Formacion Certificacion Java, .Net
					if(gppFormacion.getNacNidnivelac()==12 || gppFormacion.getNacNidnivelac()==13){
						if(banderaJavaNet==false){
							puntajeFormacion += 15;
							banderaJavaNet = true;
						}
					}
				}						
			}
		}
		if(gppPersona.getGppExperienciasLaborales()!=null){
			if(gppPersona.getGppExperienciasLaborales().size()>0){
				Iterator<Object> itExperiencias = gppPersona.getGppExperienciasLaborales().iterator();
				GppExperiencia gppExperiencia = null;
				Double aniosExperiencia = Double.valueOf("0");
				while(itExperiencias.hasNext()){
					gppExperiencia = (GppExperiencia) itExperiencias.next();
					if( (fechaPregrado.getTime() < gppExperiencia.getExpDfecingreso().getTime()) ){
						aniosExperiencia += Calculos.diferenciaFechasDias(gppExperiencia.getExpDfecingreso(), gppExperiencia.getExpDfecretiro()) / (365) ;
						if(aniosExperiencia>10){
							puntajeExpe = 10;
							break;
						}else{
							if(aniosExperiencia>1){
								puntajeExpe = aniosExperiencia.intValue();
								if(puntajeExpe>10){
									puntajeExpe = 10;
									break;
								}
							}
						}
					}
				}
			}
		}
		return puntajeFormacion+puntajeExpe;
	}
	
	public List<Object> organizarFormaciones(List<Object> gppFormaciones){
		if(gppFormaciones.size()>0){
			GppFormacion temp = new GppFormacion();
			for (int i = 0; i < gppFormaciones.size(); i++) {
				for (int j = 0; j < gppFormaciones.size()-1; j++) {
					if(((GppFormacion) gppFormaciones.get(i)).getForDfecgrado().getTime()<((GppFormacion) gppFormaciones.get(j)).getForDfecgrado().getTime()){
						temp = (GppFormacion) gppFormaciones.get(i);
						gppFormaciones.set(i, (GppFormacion) gppFormaciones.get(j));
						gppFormaciones.set(j, temp);
					}
				}
			}
		}
		return gppFormaciones;
	}
	
	public List<Object> organizarExperiencias(List<Object> gppExperienciasLaborales){
		if(gppExperienciasLaborales.size()>0){
			GppExperiencia temp = new GppExperiencia();
			for (int i = 0; i < gppExperienciasLaborales.size(); i++) {
				for (int j = 0; j < gppExperienciasLaborales.size()-1; j++) {
					if(((GppExperiencia)gppExperienciasLaborales.get(i)).getExpDfecingreso().getTime()>((GppExperiencia)gppExperienciasLaborales.get(j)).getExpDfecingreso().getTime()){
						temp = (GppExperiencia)gppExperienciasLaborales.get(i);
						gppExperienciasLaborales.set(i, (GppExperiencia)gppExperienciasLaborales.get(j));
						gppExperienciasLaborales.set(j, temp);
					}
				}
			}
		}
		return gppExperienciasLaborales;		
	}
}