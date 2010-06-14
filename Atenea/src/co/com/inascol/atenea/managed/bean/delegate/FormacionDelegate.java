package co.com.inascol.atenea.managed.bean.delegate;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import co.com.inascol.atenea.entity.GppFormacion;
import co.com.inascol.atenea.logic.FormacionService;
import co.com.inascol.atenea.logic.InstitucionService;
import co.com.inascol.atenea.logic.NivelacademicoService;
import co.com.inascol.atenea.logic.TituloequivalenteService;
import co.com.inascol.atenea.logic.interfaces.IFormacionService;
import co.com.inascol.atenea.logic.interfaces.IInstitucionService;
import co.com.inascol.atenea.logic.interfaces.INivelacademicoService;
import co.com.inascol.atenea.logic.interfaces.ITituloequivalenteService;

public class FormacionDelegate {

	private IFormacionService formacionService;
	private INivelacademicoService nivelacademicoService;
	private IInstitucionService institucionService;
	private ITituloequivalenteService tituloequivalenteService;
	private GppFormacion formacion;
	private String nombreArchivoSoportes;
	private String urlArchivoSoportes;	
	private String nombreArchivoDiploma;
	private String urlArchivoDiploma;
	private String nombreArchivoActa;
	private String urlArchivoActa;	
	private List<Object> formaciones;
	
	public FormacionDelegate(){}
	
	public List<Object> getBuscarFormacionesPersona(Integer idPersona){
		formacionService = new FormacionService();
		formaciones = formacionService.buscarFormacionPersona(idPersona);
		return formaciones;
	}
	
	public boolean getGuardarFormacion(GppFormacion formacion){
		formacionService = new FormacionService();
		return formacionService.crearFormacion(formacion.getForVtitulo(), formacion.getForDfecgrado(), formacion.getForNduracionmes(), formacion.getForVtarjetaprof(), formacion.getForDfectarjeta(), formacion.getPerNidpersona(), formacion.getNacNidnivelac(), formacion.getInsNidinstitucion(), formacion.getTeqNidtituloeq(), formacion.getDocNtarjetaprof(), formacion.getDocNactagrado(), formacion.getDocNidiploma());
	}
	
	public GppFormacion getSeleccionarFormacion(Integer idFormacion){
		formacionService = new FormacionService();
		List<Object> listadoFormaciones = formacionService.buscarFormaciones();
		if(listadoFormaciones.size()>0){
			Iterator<Object> it = listadoFormaciones.iterator();
			while(it.hasNext()){
				formacion = (GppFormacion) it.next();
				if(formacion.getForNidformacion()==idFormacion){
					break;
				}
			}
		}
		return formacion;
	}
	
	public boolean getBorrarFormacion(Integer idFormacion){
		formacionService = new FormacionService();
		return formacionService.borrarFormacion(idFormacion);
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
	
	public void getSubirDiploma(UploadEvent event) throws IOException {
	    if (event != null) {
	        UploadItem item = event.getUploadItem();
	        File file = item.getFile();
	        nombreArchivoDiploma = item.getFileName();
	        urlArchivoDiploma = "/home/memo/TEMP/" + System.currentTimeMillis() + "_" + nombreArchivoDiploma;
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
	
	public void getSubirActaGrado(UploadEvent event) throws IOException {
	    if (event != null) {
	        UploadItem item = event.getUploadItem();
	        File file = item.getFile();
	        nombreArchivoActa = item.getFileName();
	        urlArchivoActa = "/home/memo/TEMP/" + System.currentTimeMillis() + "_" + nombreArchivoActa;
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
	
	public void getSubirSoportesAcademicos(UploadEvent event) throws IOException {
	    if (event != null) {
	        UploadItem item = event.getUploadItem();
	        File file = item.getFile();
	        nombreArchivoSoportes = item.getFileName();
	        urlArchivoSoportes = "/home/memo/TEMP/" + System.currentTimeMillis() + "_" + nombreArchivoSoportes;
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