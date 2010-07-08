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

import co.com.inascol.atenea.entity.GppExperiencia;
import co.com.inascol.atenea.entity.GppParametrizacion;
import co.com.inascol.atenea.entity.GppPersona;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.CargoequivalenteService;
import co.com.inascol.atenea.logic.DepartamentoService;
import co.com.inascol.atenea.logic.DocumentoService;
import co.com.inascol.atenea.logic.ExperienciaService;
import co.com.inascol.atenea.logic.MunicipioService;
import co.com.inascol.atenea.logic.PaisService;
import co.com.inascol.atenea.logic.ParametrizacionService;
import co.com.inascol.atenea.logic.interfaces.ICargoequivalenteService;
import co.com.inascol.atenea.logic.interfaces.IDepartamentoService;
import co.com.inascol.atenea.logic.interfaces.IDocumentoService;
import co.com.inascol.atenea.logic.interfaces.IExperienciaService;
import co.com.inascol.atenea.logic.interfaces.IMunicipioService;
import co.com.inascol.atenea.logic.interfaces.IPaisService;
import co.com.inascol.atenea.logic.interfaces.IParametrizacionService;

public class ExperienciaDelegate {

	private IExperienciaService experienciaService;
	private IMunicipioService municipioService;
	private ICargoequivalenteService cargoequivalenteService;
	private IParametrizacionService parametrizacionService;
	private IDocumentoService documentoService;
	private IPaisService paisService;
	private IDepartamentoService departamentoService;
	private List<Object> experienciasLaborales;
	private GppExperiencia experiencia;	
	private String nombreArchivoCertificaciones;
	private String urlArchivoCertificaciones;	
	private String nombreArchivoCertificado1;
	private String urlArchivoCertificado1;
	private String nombreArchivoCertificado2;
	private String urlArchivoCertificado2;		
	private SimpleDateFormat dateFormat;
	private GppUsuario usuarioAutenticado;
	
	public ExperienciaDelegate(){}
	
	public List<Object> buscarFormacionesPersona(Integer idPersona){
		experienciaService =  new ExperienciaService();
		experienciasLaborales = experienciaService.buscarExperienciasPersona(idPersona);
		return experienciasLaborales;
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
	
	public List<Object> getCargosEquivalentes(){
		cargoequivalenteService = new CargoequivalenteService();
		return cargoequivalenteService.buscarCargosEquivalentes();
	}
	
	public Boolean getGuardarExperiencia(GppExperiencia experiencia){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		experienciaService = new ExperienciaService();
		return experienciaService.crearExperiencia(experiencia.getExpVnomempresa(), experiencia.getExpVtelempresa(), experiencia.getExpVnomcontacto(), experiencia.getExpVemailcontacto(), experiencia.getExpVcargo(), experiencia.getExpDfecingreso(), experiencia.getExpDfecretiro(), experiencia.getExpVherrasw(), experiencia.getExpVfuncionlogro(), experiencia.getDocNcertifica1(), experiencia.getDocNcertifica2(), experiencia.getMunVidmunicipio(), experiencia.getCeqNidcargoeq(), experiencia.getPerNidpersona(), usuarioAutenticado);
	}
	
	public Boolean getActualizarExperiencia(GppExperiencia experiencia){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		experienciaService = new ExperienciaService();
		return experienciaService.actualizarExperiencia(experiencia.getExpNidexplaboral(), experiencia.getExpVnomempresa(), experiencia.getExpVtelempresa(), experiencia.getExpVnomcontacto(), experiencia.getExpVemailcontacto(), experiencia.getExpVcargo(), experiencia.getExpDfecingreso(), experiencia.getExpDfecretiro(), experiencia.getExpVherrasw(), experiencia.getExpVfuncionlogro(), experiencia.getDocNcertifica1(), experiencia.getDocNcertifica2(), experiencia.getMunVidmunicipio(), experiencia.getCeqNidcargoeq(), experiencia.getPerNidpersona(), usuarioAutenticado);		
	}
	
	public Boolean getBorrarExperiencia(Integer idExperiencia){
		experienciaService = new ExperienciaService();
		return experienciaService.borrarExperiencia(idExperiencia);
	}
	
	public GppExperiencia getSeleccionarExperiencia(List<Object> experiencias, Integer idExperiencia){
		if(experiencias.size()>0){
			Iterator<Object> it = experiencias.iterator();
			while(it.hasNext()){
				experiencia = (GppExperiencia) it.next();
				if(experiencia.getExpNidexplaboral()==idExperiencia){
					break;
				}
			}
		}
		return experiencia;
	}	
	
	public void getSubirCertificaciones(UploadEvent event) throws IOException {
	    if (event != null) {
	    	parametrizacionService = new ParametrizacionService();
	    	dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
	        UploadItem item = event.getUploadItem();
	        File file = item.getFile();
	        nombreArchivoCertificaciones = item.getFileName();
	        urlArchivoCertificaciones = ( (GppParametrizacion) parametrizacionService.buscarPorIdParametrizacion(1) ).getParVvalor();
	        if(urlArchivoCertificaciones==null){
	        	urlArchivoCertificaciones = "/home/memo/Temp-Directory/";
	        }else{		        
		        urlArchivoCertificaciones = urlArchivoCertificaciones + "CERT_" + dateFormat.format(new Date()) + "_" + nombreArchivoCertificaciones;
		        FileInputStream fis = new FileInputStream(file.getPath());
		        BufferedInputStream bis = new BufferedInputStream(fis);
		        FileOutputStream fos = new FileOutputStream(urlArchivoCertificaciones);
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
	
	public void getSubirCertificado1(UploadEvent event) throws IOException {
	    if (event != null) {
	    	parametrizacionService = new ParametrizacionService();
	    	dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
	        UploadItem item = event.getUploadItem();
	        File file = item.getFile();
	        nombreArchivoCertificado1 = item.getFileName();
	        urlArchivoCertificado1 = ( (GppParametrizacion) parametrizacionService.buscarPorIdParametrizacion(1) ).getParVvalor();
	        if(urlArchivoCertificado1==null){
	        	urlArchivoCertificado1 = "/home/memo/Temp-Directory/";
	        }else{		        
	        	urlArchivoCertificado1 = urlArchivoCertificado1 + "CERT_" + dateFormat.format(new Date()) + "_" + nombreArchivoCertificado1;
		        FileInputStream fis = new FileInputStream(file.getPath());
		        BufferedInputStream bis = new BufferedInputStream(fis);
		        FileOutputStream fos = new FileOutputStream(urlArchivoCertificado1);
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
	
	public void getSubirCertificado2(UploadEvent event) throws IOException {
	    if (event != null) {
	    	parametrizacionService = new ParametrizacionService();
	    	dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
	        UploadItem item = event.getUploadItem();
	        File file = item.getFile();
	        nombreArchivoCertificado2 = item.getFileName();
	        urlArchivoCertificado2 = ( (GppParametrizacion) parametrizacionService.buscarPorIdParametrizacion(1) ).getParVvalor();
	        if(urlArchivoCertificado2==null){
	        	urlArchivoCertificado2 = "/home/memo/Temp-Directory/";
	        }else{		        
	        	urlArchivoCertificado2 = urlArchivoCertificado2 + "CERT_" + dateFormat.format(new Date()) + "_" + nombreArchivoCertificado2;
		        FileInputStream fis = new FileInputStream(file.getPath());
		        BufferedInputStream bis = new BufferedInputStream(fis);
		        FileOutputStream fos = new FileOutputStream(urlArchivoCertificado2);
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
	
	public void getGuardarCertificaciones(GppPersona persona){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		documentoService = new DocumentoService();
		String nombreDocumento = "Consolidado-Certificaciones-"+persona.getPerVnombres()+"-"+persona.getPerVapellidos();
		documentoService.crearDocumento(nombreDocumento, nombreArchivoCertificaciones, urlArchivoCertificaciones, new Date(), persona.getPerNidpersona(), 1, usuarioAutenticado);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("DocumentoMB");
	}
	
	public void getGuardarCertificacion1(GppPersona persona){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		documentoService = new DocumentoService();
		String nombreDocumento = "Certificacion-1-"+persona.getPerVnombres()+"-"+persona.getPerVapellidos();
		documentoService.crearDocumento(nombreDocumento, nombreArchivoCertificado1, urlArchivoCertificado1, new Date(), persona.getPerNidpersona(), 1, usuarioAutenticado);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("DocumentoMB");
	}
	
	public void getGuardarCertificacion2(GppPersona persona){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		documentoService = new DocumentoService();
		String nombreDocumento = "Certificacion-2-"+persona.getPerVnombres()+"-"+persona.getPerVapellidos();
		documentoService.crearDocumento(nombreDocumento, nombreArchivoCertificado2, urlArchivoCertificado2, new Date(), persona.getPerNidpersona(), 1, usuarioAutenticado);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("DocumentoMB");
	}
}