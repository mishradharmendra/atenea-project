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
import co.com.inascol.atenea.logic.PersonaService;
import co.com.inascol.atenea.logic.TipodocService;
import co.com.inascol.atenea.logic.interfaces.IDepartamentoService;
import co.com.inascol.atenea.logic.interfaces.IDocumentoService;
import co.com.inascol.atenea.logic.interfaces.IEstadocivilService;
import co.com.inascol.atenea.logic.interfaces.IMunicipioService;
import co.com.inascol.atenea.logic.interfaces.IPaisService;
import co.com.inascol.atenea.logic.interfaces.IParametrizacionService;
import co.com.inascol.atenea.logic.interfaces.IPersonaService;
import co.com.inascol.atenea.logic.interfaces.ITipodocService;

public class PersonaDelegate {

	private IPersonaService personaService;	
	private ITipodocService tipodocService;
	private IPaisService paisService;
	private IDepartamentoService departamentoService;
	private IMunicipioService municipioService;
	private IEstadocivilService estadocivilService;
	private IDocumentoService documentoService;
	private IParametrizacionService parametrizacionService;
	private List<Object> personas;
	private GppPersona persona;
	private String urlArchivo;
	private String nombreArchivo;
	private SimpleDateFormat dateFormat; 
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
	
	public List<Object> getBusquedaBasicaPersona(String nombrePersona, String apellidoPersona, String identificacionPersona, Boolean estadoPersona){
		if(!nombrePersona.equalsIgnoreCase("") || !apellidoPersona.equalsIgnoreCase("") || !identificacionPersona.equalsIgnoreCase("")){
			personaService = new PersonaService();
			List<Object> criteriosBusqueda = new ArrayList<Object>();							
			if(!nombrePersona.equalsIgnoreCase(""))
				criteriosBusqueda.add("per_vnombres"+"|"+nombrePersona);
			if(!apellidoPersona.equalsIgnoreCase("")) 
				criteriosBusqueda.add("per_vapellidos"+"|"+apellidoPersona);
			if(!identificacionPersona.equalsIgnoreCase(""))
				criteriosBusqueda.add("per_nidentificacion"+"|"+identificacionPersona);
			if(estadoPersona!=null){
				criteriosBusqueda.add("per_vactivo"+"|"+estadoPersona);
			}
			personas = personaService.buscarPersonaPorCriterios(criteriosBusqueda);
		}		
		return personas;
	}
	
	public Boolean getGuardarPersona(GppPersona persona){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		personaService = new PersonaService();
		return personaService.crearPersona(persona.getPerVnombres(), persona.getPerVapellidos(), persona.getPerNidentificacion(), persona.getPerVsexo(), persona.getPerDfecnacimiento(), persona.getPerVlibretamilitar(), persona.getPerVmovil(), persona.getPerVemail(), persona.getPerVdireccion(), persona.getPerVtelefono(), persona.getMunVidmunicipio(), persona.getTdcNidtipodoc(), persona.getEscNidestadocivil(), persona.getPaiNpaisresidencia(), persona.getMunNmpioresidencia(), true, usuarioAutenticado);
	}
	
	public Boolean getActualizarPersona(GppPersona persona){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		personaService = new PersonaService();
		return personaService.actualizarPersona(persona.getPerNidpersona(), persona.getPerVnombres(), persona.getPerVapellidos(), persona.getPerNidentificacion(), persona.getPerVsexo(), persona.getPerDfecnacimiento(), persona.getPerVlibretamilitar(), persona.getPerVmovil(), persona.getPerVemail(), persona.getPerVdireccion(), persona.getPerVtelefono(), persona.getMunVidmunicipio(), persona.getTdcNidtipodoc(), persona.getEscNidestadocivil(), persona.getPaiNpaisresidencia(), persona.getMunNmpioresidencia(), persona.getPerBactivo(), usuarioAutenticado);		
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
	
	public void getSubirDocumentoHojaVida(UploadEvent event) throws IOException {
	    if (event != null) {
	    	parametrizacionService = new ParametrizacionService();
	    	dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
	        UploadItem item = event.getUploadItem();
	        File file = item.getFile();
	        nombreArchivo = item.getFileName();
	        urlArchivo = ( (GppParametrizacion) parametrizacionService.buscarPorIdParametrizacion(1) ).getParVvalor();
	        if(urlArchivo==null){
	        	urlArchivo = "/home/memo/Temp-Directory/";
	        }else{	        
		        urlArchivo = urlArchivo + "HV_" + dateFormat.format(new Date()) + "_" + nombreArchivo;
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
		String nombreDocumento = "Hoja de Vida-"+persona.getPerVnombres()+"-"+persona.getPerVapellidos();
		documentoService.crearDocumento(nombreDocumento, nombreArchivo, urlArchivo, new Date(), persona.getPerNidpersona(), 1, usuarioAutenticado);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("DocumentoMB");
	}
}