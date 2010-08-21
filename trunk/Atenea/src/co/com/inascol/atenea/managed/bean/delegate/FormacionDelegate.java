package co.com.inascol.atenea.managed.bean.delegate;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;

import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import co.com.inascol.atenea.entity.GppFormacion;
import co.com.inascol.atenea.entity.GppParametrizacion;
import co.com.inascol.atenea.entity.GppPersona;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.DocumentoService;
import co.com.inascol.atenea.logic.FormacionService;
import co.com.inascol.atenea.logic.InstitucionService;
import co.com.inascol.atenea.logic.NivelacademicoService;
import co.com.inascol.atenea.logic.ParametrizacionService;
import co.com.inascol.atenea.logic.TituloequivalenteService;
import co.com.inascol.atenea.logic.interfaces.IDocumentoService;
import co.com.inascol.atenea.logic.interfaces.IFormacionService;
import co.com.inascol.atenea.logic.interfaces.IInstitucionService;
import co.com.inascol.atenea.logic.interfaces.INivelacademicoService;
import co.com.inascol.atenea.logic.interfaces.IParametrizacionService;
import co.com.inascol.atenea.logic.interfaces.ITituloequivalenteService;
/**
 * @author Guillermo Toro
 *
 */
public class FormacionDelegate {

	private IFormacionService formacionService;
	private INivelacademicoService nivelacademicoService;
	private IInstitucionService institucionService;
	private ITituloequivalenteService tituloequivalenteService;
	private IParametrizacionService parametrizacionService;
	private IDocumentoService documentoService;
	private GppFormacion formacion;
	private String nombreArchivoActa;
	private String urlArchivoActa;
	private String nombreArchivoDiploma;
	private String urlArchivoDiploma;	
	private String nombreArchivoSoportes;
	private String urlArchivoSoportes;		
	private List<Object> formaciones;
	private GppUsuario usuarioAutenticado;
	
	public FormacionDelegate(){}
	
	public List<Object> getBuscarFormacionesPersona(Integer idPersona){
		formacionService = new FormacionService();
		formaciones = formacionService.buscarFormacionPersona(idPersona);
		return formaciones;		
	}
	
	public List<Object> getNivelesAcademicos(){
		nivelacademicoService = new NivelacademicoService();
		return nivelacademicoService.buscarNivelesAcademicos();
	}
	
	public List<Object> getInstituciones(){
		institucionService = new InstitucionService();
		return institucionService.buscarInstituciones();
	}
	
	public List<Object> getTitulosEquivalentes(){
		tituloequivalenteService = new TituloequivalenteService();
		return tituloequivalenteService.buscarTitulosEquivalentes();
	}
	
	public Boolean getGuardarFormacion(GppFormacion formacion){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		formacionService = new FormacionService();
		return formacionService.crearFormacion(formacion.getForVtitulo(), formacion.getForDfecgrado(), formacion.getForNduracionmes(), formacion.getForVtarjetaprof(), formacion.getForDfectarjeta(), formacion.getPerNidpersona(), formacion.getNacNidnivelac(), formacion.getInsNidinstitucion(), formacion.getTeqNidtituloeq(), formacion.getDocNtarjetaprof(), formacion.getDocNactagrado(), formacion.getDocNidiploma(), usuarioAutenticado);
	}
	
	public Boolean getActualizarFormacion(GppFormacion formacion){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		formacionService = new FormacionService();
		return formacionService.actualizarFormacion(formacion.getForNidformacion(), formacion.getForVtitulo(), formacion.getForDfecgrado(), formacion.getForNduracionmes(), formacion.getForVtarjetaprof(), formacion.getForDfectarjeta(), formacion.getPerNidpersona(), formacion.getNacNidnivelac(), formacion.getInsNidinstitucion(), formacion.getTeqNidtituloeq(), formacion.getDocNtarjetaprof(), formacion.getDocNactagrado(), formacion.getDocNidiploma(), usuarioAutenticado);
	}
	
	public Boolean getBorrarFormacion(Integer idFormacion){
		formacionService = new FormacionService();
		return formacionService.borrarFormacion(idFormacion);
	}
	
	public GppFormacion getSeleccionarFormacion(List<Object> formaciones, Integer idFormacion){
		if(formaciones.size()>0){
			Iterator<Object> it = formaciones.iterator();
			while(it.hasNext()){
				formacion = (GppFormacion) it.next();
				if(formacion.getForNidformacion()==idFormacion){
					break;
				}
			}
		}
		return formacion;
	}
		
	public void getSubirDiploma(GppPersona persona, UploadEvent event) throws IOException {
	    if (event != null) {
	    	parametrizacionService = new ParametrizacionService();
	        UploadItem item = event.getUploadItem();
	        File file = item.getFile();
	        nombreArchivoDiploma = item.getFileName();
	        urlArchivoDiploma = ( (GppParametrizacion) parametrizacionService.buscarPorIdParametrizacion(1) ).getParVvalor();
	        if(urlArchivoDiploma!=null){
		        urlArchivoDiploma = urlArchivoDiploma + "DIPLOMA_" + persona.getPerNidentificacion() + "_" + nombreArchivoDiploma + "_" + new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss").format(new Date());
		        FileInputStream fis = new FileInputStream(file.getPath());
		        BufferedInputStream bis = new BufferedInputStream(fis);
		        FileOutputStream fos = new FileOutputStream(urlArchivoDiploma);
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
	
	public void getSubirActaGrado(GppPersona persona, UploadEvent event) throws IOException {
	    if (event != null) {
	    	parametrizacionService = new ParametrizacionService();
	        UploadItem item = event.getUploadItem();
	        File file = item.getFile();
	        nombreArchivoActa = item.getFileName();
	        urlArchivoActa = ( (GppParametrizacion) parametrizacionService.buscarPorIdParametrizacion(1) ).getParVvalor();
	        if(urlArchivoActa!=null){
	        	urlArchivoActa = urlArchivoActa + "ACTA_" + persona.getPerNidentificacion() + "_" + nombreArchivoDiploma + "_" + new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss").format(new Date());
		        FileInputStream fis = new FileInputStream(file.getPath());
		        BufferedInputStream bis = new BufferedInputStream(fis);
		        FileOutputStream fos = new FileOutputStream(urlArchivoActa);
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
	
	public void getSubirSoportesAcademicos(GppPersona persona, UploadEvent event) throws IOException {
	    if (event != null) {
	    	parametrizacionService = new ParametrizacionService();
	        UploadItem item = event.getUploadItem();
	        File file = item.getFile();
	        nombreArchivoSoportes = item.getFileName();
	        urlArchivoSoportes = ( (GppParametrizacion) parametrizacionService.buscarPorIdParametrizacion(1) ).getParVvalor();
	        if(urlArchivoSoportes!=null){
	        	urlArchivoSoportes = urlArchivoSoportes + "SOP_ACADEM_" + persona.getPerNidentificacion() + "_" + nombreArchivoSoportes + "_" + new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss").format(new Date());
		        FileInputStream fis = new FileInputStream(file.getPath());
		        BufferedInputStream bis = new BufferedInputStream(fis);
		        FileOutputStream fos = new FileOutputStream(urlArchivoSoportes);
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
	
	public void getGuardarSoporte(GppPersona persona){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		documentoService = new DocumentoService();
		String nombreDocumento = "Consolidado-Soportes-"+persona.getPerVnombres()+"-"+persona.getPerVapellidos();
		Integer tipoDocumento = 4;
		documentoService.crearDocumento(nombreDocumento, nombreArchivoSoportes, urlArchivoSoportes, new Date(), persona.getPerNidpersona(), tipoDocumento, usuarioAutenticado);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("DocumentoMB");
	}
	
	public void getGuardarDiploma(GppPersona persona, GppFormacion formacion){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		documentoService = new DocumentoService();
		String nombreDocumento = "Diploma-"+persona.getPerVnombres()+"-"+persona.getPerVapellidos();
		Integer tipoDocumento = 1;
		if(nombreArchivoDiploma.toLowerCase().endsWith(".pdf")){
			tipoDocumento = 1;
		}else if(nombreArchivoDiploma.toLowerCase().endsWith(".zip") || nombreArchivoDiploma.toLowerCase().endsWith(".rar")){
			tipoDocumento = 4;
		}else if(nombreArchivoDiploma.toLowerCase().endsWith(".jpeg") || nombreArchivoDiploma.toLowerCase().endsWith(".jpg") ||
					nombreArchivoDiploma.toLowerCase().endsWith(".bmp") || nombreArchivoDiploma.toLowerCase().endsWith(".tif") ||
						nombreArchivoDiploma.toLowerCase().endsWith(".tiff") || nombreArchivoDiploma.toLowerCase().endsWith(".png")){
			tipoDocumento = 6;
		}
		documentoService.crearDocumento(nombreDocumento, nombreArchivoDiploma, urlArchivoDiploma, formacion.getForDfecgrado(), persona.getPerNidpersona(), tipoDocumento, usuarioAutenticado);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("DocumentoMB");
	}
	
	public void getGuardarActa(GppPersona persona, GppFormacion formacion){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		documentoService = new DocumentoService();
		String nombreDocumento = "Acta-"+persona.getPerVnombres()+"-"+persona.getPerVapellidos();
		Integer tipoDocumento = 1;
		if(nombreArchivoActa.toLowerCase().endsWith(".pdf")){
			tipoDocumento = 1;
		}else if(nombreArchivoActa.toLowerCase().endsWith(".zip") || nombreArchivoActa.toLowerCase().endsWith(".rar")){
			tipoDocumento = 4;
		}else if(nombreArchivoActa.toLowerCase().endsWith(".jpeg") || nombreArchivoActa.toLowerCase().endsWith(".jpg") ||
					nombreArchivoActa.toLowerCase().endsWith(".bmp") || nombreArchivoActa.toLowerCase().endsWith(".tif") ||
						nombreArchivoActa.toLowerCase().endsWith(".tiff") || nombreArchivoActa.toLowerCase().endsWith(".png")){
			tipoDocumento = 6;
		}		
		documentoService.crearDocumento(nombreDocumento, nombreArchivoActa, urlArchivoActa, formacion.getForDfecgrado(), persona.getPerNidpersona(), tipoDocumento, usuarioAutenticado);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("DocumentoMB");
	}
}