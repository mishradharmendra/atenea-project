package co.com.inascol.atenea.managed.bean.delegate;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;

import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import co.com.inascol.atenea.entity.GppParametrizacion;
import co.com.inascol.atenea.entity.GppPersona;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.DepartamentoService;
import co.com.inascol.atenea.logic.DocumentoService;
import co.com.inascol.atenea.logic.EstadocivilService;
import co.com.inascol.atenea.logic.MunicipioService;
import co.com.inascol.atenea.logic.PaisService;
import co.com.inascol.atenea.logic.ParametrizacionService;
import co.com.inascol.atenea.logic.PerfilequivalenteService;
import co.com.inascol.atenea.logic.PersonaService;
import co.com.inascol.atenea.logic.TipodocService;
import co.com.inascol.atenea.logic.TituloequivalenteService;
import co.com.inascol.atenea.logic.interfaces.IDepartamentoService;
import co.com.inascol.atenea.logic.interfaces.IDocumentoService;
import co.com.inascol.atenea.logic.interfaces.IEstadocivilService;
import co.com.inascol.atenea.logic.interfaces.IMunicipioService;
import co.com.inascol.atenea.logic.interfaces.IPaisService;
import co.com.inascol.atenea.logic.interfaces.IParametrizacionService;
import co.com.inascol.atenea.logic.interfaces.IPerfilequivalenteService;
import co.com.inascol.atenea.logic.interfaces.IPersonaService;
import co.com.inascol.atenea.logic.interfaces.ITipodocService;
import co.com.inascol.atenea.logic.interfaces.ITituloequivalenteService;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcción de Software
 * Esp. Sistemas de Información Geográfica
 * Ing. Catastral y Geodesta
 */
public class PersonaDelegate {

	private IPersonaService personaService;	
	private ITipodocService tipodocService;
	private IPaisService paisService;
	private IDepartamentoService departamentoService;
	private IMunicipioService municipioService;
	private IEstadocivilService estadocivilService;
	private IDocumentoService documentoService;
	private ITituloequivalenteService tituloequivalenteService;
	private IPerfilequivalenteService perfilequivalenteService;
	private IParametrizacionService parametrizacionService;
	private List<Object> personas;
	private GppPersona persona;
	private String urlArchivo;
	private String nombreArchivo;
	private GppUsuario usuarioAutenticado;
	
	public PersonaDelegate(){}
	
	public List<Object> getListaPersonas(){
		personaService = new PersonaService();
		personas = personaService.buscarPersonas();
		return personas;
	}
	
	public List<Object> getListaPaises(){
		paisService = new PaisService();
		return paisService.buscarPaises();
	}	
	
	public List<Object> getListaDepartamentos(){
		departamentoService = new DepartamentoService();
		return departamentoService.buscarDepartamentos();
	}
	
	public List<Object> getListaMunicipios(){
		municipioService = new MunicipioService();
		return municipioService.buscarMunicipios();
	}
	
	public List<Object> getListaTipoIndentificacion(){
		tipodocService = new TipodocService();
		return tipodocService.buscarTiposDocumentos();
	}
	
	public List<Object> getListaEstadosCiviles(){
		estadocivilService = new EstadocivilService();
		return estadocivilService.buscarEstadosCiviles();
	}	
	
	public List<Object> getTitulosEquivalentes(){
		tituloequivalenteService = new TituloequivalenteService();
		return tituloequivalenteService.buscarTitulosEquivalentes();
	}
	
	public List<Object> getPerfilesProfesionalesEquivalente(){
		perfilequivalenteService = new PerfilequivalenteService();
		return perfilequivalenteService.buscarPerfilesEquivalentes();
	}
	
	public List<Object> getBusquedaBasicaPersona(String nombrePersona, String identificacionPersona){
		personas = new ArrayList<Object>();
		personaService = new PersonaService();
		List<Object> criteriosBusqueda = new ArrayList<Object>();
		if(nombrePersona.equalsIgnoreCase("") && identificacionPersona.equalsIgnoreCase("")){
			personas = personaService.buscarPersonas();
		}else{
			if(!nombrePersona.equalsIgnoreCase("") || !identificacionPersona.equalsIgnoreCase("")){
				if(!nombrePersona.equalsIgnoreCase("") && !identificacionPersona.equalsIgnoreCase(""))
					criteriosBusqueda.add("DOS|");
				else
					criteriosBusqueda.add("UNO|");
				String apellidoPersona = "";
				String [] nombreApellido = nombrePersona.split("\\s+");
				if(!nombreApellido[0].equalsIgnoreCase("")){
					if(nombreApellido.length==1){
						nombrePersona = nombreApellido[0];
						apellidoPersona = nombreApellido[0];
						criteriosBusqueda.add("per_vnombres"+"|"+nombrePersona);
						criteriosBusqueda.add("per_vapellidos"+"|OR|"+apellidoPersona);
					}				
					else if(nombreApellido.length==2){
						nombrePersona = nombreApellido[0];
						apellidoPersona = nombreApellido[1];
						criteriosBusqueda.add("per_vnombres"+"|"+nombrePersona);
						criteriosBusqueda.add("per_vapellidos"+"|AND|"+apellidoPersona);
					}
					else if(nombreApellido.length==3){
						nombrePersona = nombreApellido[0];
						apellidoPersona = nombreApellido[1] + " " + nombreApellido[2];
						criteriosBusqueda.add("per_vnombres"+"|"+nombrePersona);
						criteriosBusqueda.add("per_vapellidos"+"|AND|"+apellidoPersona);
					}
					else if(nombreApellido.length==4){
						nombrePersona = nombreApellido[0] + " " + nombreApellido[1];
						apellidoPersona = nombreApellido[2] + " " + nombreApellido[3];
						criteriosBusqueda.add("per_vnombres"+"|"+nombrePersona);
						criteriosBusqueda.add("per_vapellidos"+"|AND|"+apellidoPersona);
					}
				}
				if(!identificacionPersona.equalsIgnoreCase(""))
					criteriosBusqueda.add("per_nidentificacion"+"|"+identificacionPersona);
				personas = personaService.buscarPersonaPorCriterios(criteriosBusqueda);
			}
		}
		return personas;
	}
	
	public List<Object> getBusquedaAvanzadaPersona(String nombrePersona, String identificacionPersona, String idPregrado, Date fechaTarjetaProfesional, String idEspecializacion, String idMaestria, String cargo, String bd, String herramientas, String funciones, String idPerfil){
		personas = new ArrayList<Object>();
		personaService = new PersonaService();
		List<Object> criteriosBusqueda = new ArrayList<Object>();
		if(nombrePersona.equalsIgnoreCase("") && identificacionPersona.equalsIgnoreCase("") && idPregrado.equalsIgnoreCase("") && 
				idEspecializacion.equalsIgnoreCase("") && idMaestria.equalsIgnoreCase("") && cargo.equalsIgnoreCase("") &&
					herramientas.equalsIgnoreCase("") && bd.equalsIgnoreCase("") && funciones.equalsIgnoreCase("") && 
						idPerfil.equalsIgnoreCase("") && fechaTarjetaProfesional==null){
			personas = personaService.buscarPersonas();
		}else{
			if(!nombrePersona.equalsIgnoreCase("") || !identificacionPersona.equalsIgnoreCase("") || !idPregrado.equalsIgnoreCase("") || 
					!idEspecializacion.equalsIgnoreCase("") || !idMaestria.equalsIgnoreCase("") || !cargo.equalsIgnoreCase("") ||
						!herramientas.equalsIgnoreCase("") || !bd.equalsIgnoreCase("") || !funciones.equalsIgnoreCase("") || 
							!idPerfil.equalsIgnoreCase("") || fechaTarjetaProfesional!=null){
				String apellidoPersona = "";
				String [] nombreApellido = nombrePersona.split("\\s+");
				if(!nombreApellido[0].equalsIgnoreCase("")){
					if(nombreApellido.length==1){
						nombrePersona = nombreApellido[0];
						apellidoPersona = nombreApellido[0];
						criteriosBusqueda.add("p.per_vnombres LIKE '%"+nombrePersona+"%' OR p.per_vapellidos LIKE '%"+apellidoPersona+"%'");
					}				
					else if(nombreApellido.length==2){
						nombrePersona = nombreApellido[0];
						apellidoPersona = nombreApellido[1];
						criteriosBusqueda.add("p.per_vnombres LIKE '%"+nombrePersona+"%'");
						criteriosBusqueda.add("p.per_vapellidos LIKE '%"+apellidoPersona+"%'");
					}
					else if(nombreApellido.length==3){
						nombrePersona = nombreApellido[0];
						apellidoPersona = nombreApellido[1] + " " + nombreApellido[2];
						criteriosBusqueda.add("p.per_vnombres LIKE '%"+nombrePersona+"%'");
						criteriosBusqueda.add("p.per_vapellidos LIKE '%"+apellidoPersona+"%'");
					}
					else if(nombreApellido.length==4){
						nombrePersona = nombreApellido[0] + " " + nombreApellido[1];
						apellidoPersona = nombreApellido[2] + " " + nombreApellido[3];
						criteriosBusqueda.add("p.per_vnombres LIKE '%"+nombrePersona+"%'");
						criteriosBusqueda.add("p.per_vapellidos LIKE '%"+apellidoPersona+"%'");
					}
				}
				if(!identificacionPersona.equalsIgnoreCase(""))
					criteriosBusqueda.add("p.per_nidentificacion LIKE '%"+identificacionPersona+"%'");
				if(!idPregrado.equalsIgnoreCase(""))
					criteriosBusqueda.add("pre.teq_nidtituloeq = "+idPregrado);
				if(!idEspecializacion.equalsIgnoreCase(""))
					criteriosBusqueda.add("esp.teq_nidtituloeq = "+idEspecializacion);
				if(!idMaestria.equalsIgnoreCase(""))
					criteriosBusqueda.add("msc.teq_nidtituloeq = "+idMaestria);
				if(!cargo.equalsIgnoreCase(""))
					criteriosBusqueda.add("e.exp_vcargo LIKE '%"+cargo+"%'");
				if(!herramientas.equalsIgnoreCase(""))
					criteriosBusqueda.add("pp.ppr_vherrasw LIKE '%"+herramientas+"%'");
				if(!bd.equalsIgnoreCase(""))
					criteriosBusqueda.add("pp.ppr_vmotorbd LIKE '%"+bd+"%'");
				if(!funciones.equalsIgnoreCase(""))
					criteriosBusqueda.add("e.exp_vfuncionlogro LIKE '%"+funciones+"%'");
				if(!idPerfil.equalsIgnoreCase(""))
					criteriosBusqueda.add("pp.peq_nidperfileq = "+idPerfil);
				if(fechaTarjetaProfesional!=null){
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					criteriosBusqueda.add("pre.for_dfectarjeta = '"+dateFormat.format(fechaTarjetaProfesional)+"'");
				}
				personas = personaService.buscarPersonaPorCriteriosAvanzados(criteriosBusqueda);
			}
		}
		return personas;
	}
	
	public List<Object> getBusquedaRapidaPersona(String criterioBusquedaRapida){
		personaService = new PersonaService();
		if(!criterioBusquedaRapida.equalsIgnoreCase(""))
			personas = personaService.buscarPersonaPorCriterioRapido(criterioBusquedaRapida);
		return personas;
	}
	
	public Boolean getGuardarPersona(GppPersona persona){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		personaService = new PersonaService();
		return personaService.crearPersona(persona.getPerVnombres(), persona.getPerVapellidos(), persona.getPerNidentificacion(), persona.getPerVsexo(), persona.getPerDfecnacimiento(), persona.getPerVlibretamilitar(), persona.getPerVmovil(), persona.getPerVemail(), persona.getPerVdireccion(), persona.getPerVtelefono(), persona.getMunNidmunicipio(), persona.getTdcNidtipodoc(), persona.getEscNidestadocivil(), persona.getPaiNpaisresidencia(), persona.getMunNmpioresidencia(), true, usuarioAutenticado);
	}
	
	public Boolean getActualizarPersona(GppPersona persona){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		personaService = new PersonaService();
		return personaService.actualizarPersona(persona.getPerNidpersona(), persona.getPerVnombres(), persona.getPerVapellidos(), persona.getPerNidentificacion(), persona.getPerVsexo(), persona.getPerDfecnacimiento(), persona.getPerVlibretamilitar(), persona.getPerVmovil(), persona.getPerVemail(), persona.getPerVdireccion(), persona.getPerVtelefono(), persona.getMunNidmunicipio(), persona.getTdcNidtipodoc(), persona.getEscNidestadocivil(), persona.getPaiNpaisresidencia(), persona.getMunNmpioresidencia(), persona.getPerBactivo(), usuarioAutenticado);		
	}
	
	public GppPersona getSeleccionarPersona(List<Object> personas, Integer idPersona){
		if(personas.size()>0){
			Iterator<Object> it = personas.iterator();
			while(it.hasNext()){
				persona = (GppPersona) it.next();
				if(persona.getPerNidpersona()==idPersona){
					break;
				}
			}		
		}
		return persona;
	}
	
	public void getSubirDocumentoHojaVida(GppPersona persona, UploadEvent event) throws IOException {
	    if (event != null) {
	    	parametrizacionService = new ParametrizacionService();
	        UploadItem item = event.getUploadItem();
	        File file = item.getFile();
	        nombreArchivo = item.getFileName();
	        urlArchivo = ( (GppParametrizacion) parametrizacionService.buscarPorIdParametrizacion(1) ).getParVvalor();
	        if(urlArchivo!=null){
		        urlArchivo = urlArchivo + "HV_CC_" + persona.getPerNidentificacion() + "_" + new SimpleDateFormat("ddMMyyyy-HHmmss").format(new Date()) + "_" + nombreArchivo;
		        FileInputStream fis = new FileInputStream(file.getPath());
		        BufferedInputStream bis = new BufferedInputStream(fis);
		        FileOutputStream fos = new FileOutputStream(urlArchivo);
		        BufferedOutputStream bos = new BufferedOutputStream(fos);
		        try {
		            byte[] array = new byte[100];
		            int leidos = bis.read(array);
		            while (leidos > 0) {
		                bos.write(array, 0, leidos);
		                leidos = bis.read(array);
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        } finally {
		            bis.close();
		            bos.close();
		        }
	        }
	    }
	}
	
	public void getGuardarHojaVida(GppPersona persona){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		documentoService = new DocumentoService();
		String nombreDocumento = "Hoja_de_Vida-"+persona.getPerVnombres()+"-"+persona.getPerVapellidos();
		Integer tipoDocumento = 1;
		if(nombreArchivo.toLowerCase().endsWith(".pdf")){
			tipoDocumento = 1;
		}else if(nombreArchivo.toLowerCase().endsWith(".zip") || nombreArchivo.toLowerCase().endsWith(".rar")){
			tipoDocumento = 4;
		}
		documentoService.crearDocumento(nombreDocumento, nombreArchivo, urlArchivo, new Date(), persona.getPerNidpersona(), tipoDocumento, usuarioAutenticado);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("DocumentoMB");
	}
}