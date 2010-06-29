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

import antlr.collections.impl.LList;

import co.com.inascol.atenea.entity.GppExperiencia;
import co.com.inascol.atenea.logic.CargoequivalenteService;
import co.com.inascol.atenea.logic.ExperienciaService;
import co.com.inascol.atenea.logic.MunicipioService;
import co.com.inascol.atenea.logic.interfaces.ICargoequivalenteService;
import co.com.inascol.atenea.logic.interfaces.IExperienciaService;
import co.com.inascol.atenea.logic.interfaces.IMunicipioService;

public class ExperienciaDelegate {

	private IExperienciaService experienciaService;
	private IMunicipioService municipioService;
	private ICargoequivalenteService cargoequivalenteService;
	private List<Object> experienciasLaborales;
	private GppExperiencia experiencia;	
	private String nombreArchivoCertificaciones;
	private String urlArchivoCertificaciones;	
	private String nombreArchivoCertificado1;
	private String urlArchivoCertificado1;
	private String nombreArchivoCertificado2;
	private String urlArchivoCertificado2;		
	
	public ExperienciaDelegate(){}
	
	public List<Object> getListaMunicipios(){
		municipioService =  new MunicipioService();
		return municipioService.buscarMunicipios();
	}
	
	public List<Object> getCargosEquivalentes(){
		cargoequivalenteService = new CargoequivalenteService();
		return cargoequivalenteService.buscarCargosEquivalentes();
	}
	
	public Boolean getGuardarExperiencia(GppExperiencia experiencia){
		experienciaService = new ExperienciaService();
		return experienciaService.crearExperiencia(experiencia.getExpVnomempresa(), experiencia.getExpVtelempresa(), experiencia.getExpVnomcontacto(), experiencia.getExpVemailcontacto(), experiencia.getExpVcargo(), experiencia.getExpDfecingreso(), experiencia.getExpDfecretiro(), experiencia.getExpVherrasw(), experiencia.getExpVfuncionlogro(), experiencia.getDocNcertifica1(), experiencia.getDocNcertifica2(), experiencia.getMunVidmunicipio(), experiencia.getCeqNidcargoeq());
	}
	
	public Boolean getActualizarExperiencia(GppExperiencia experiencia){
		experienciaService = new ExperienciaService();
		return experienciaService.actualizarExperiencia(experiencia.getExpNidexplaboral(), experiencia.getExpVnomempresa(), experiencia.getExpVtelempresa(), experiencia.getExpVnomcontacto(), experiencia.getExpVemailcontacto(), experiencia.getExpVcargo(), experiencia.getExpDfecingreso(), experiencia.getExpDfecretiro(), experiencia.getExpVherrasw(), experiencia.getExpVfuncionlogro(), experiencia.getDocNcertifica1(), experiencia.getDocNcertifica2(), experiencia.getMunVidmunicipio(), experiencia.getCeqNidcargoeq());		
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
	        UploadItem item = event.getUploadItem();
	        File file = item.getFile();
	        nombreArchivoCertificaciones = item.getFileName();
	        urlArchivoCertificaciones = "/home/memo/TEMP/" + System.currentTimeMillis() + "_" + nombreArchivoCertificaciones;
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