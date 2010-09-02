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

import co.com.inascol.atenea.entity.GppDocumento;
import co.com.inascol.atenea.entity.GppParametrizacion;
import co.com.inascol.atenea.entity.GppPersona;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.DocumentoService;
import co.com.inascol.atenea.logic.ParametrizacionService;
import co.com.inascol.atenea.logic.TipoarchivoService;
import co.com.inascol.atenea.logic.interfaces.IDocumentoService;
import co.com.inascol.atenea.logic.interfaces.IParametrizacionService;
import co.com.inascol.atenea.logic.interfaces.ITipoarchivoService;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcción de Software
 * Esp. Sistemas de Información Geográfica
 * Ing. Catastral y Geodesta
 */
public class DocumentoDelegate {

	private IDocumentoService documentoService;
	private IParametrizacionService parametrizacionService;
	private ITipoarchivoService tipoarchivoService;
	private String nombreArchivoSoporte;
	private String urlArchivoSoporte;
	private GppDocumento documento;
	private GppUsuario usuarioAutenticado;
	
	public DocumentoDelegate(){}
	
	public List<Object> getListaTiposArchivos(){
		tipoarchivoService = new TipoarchivoService();
		return tipoarchivoService.buscarTipoarchivos();
	}
	
	public Boolean getBorrarSoporte(Integer idDocumentoSoporte){
		documentoService = new DocumentoService();
		getBorrarSoporteFisico(idDocumentoSoporte);
		return documentoService.borrarDocumento(idDocumentoSoporte);
	}
	
	public void getSubirSoporte(GppPersona persona, UploadEvent event) throws IOException {
	    if (event != null) {
	    	parametrizacionService = new ParametrizacionService();
	        UploadItem item = event.getUploadItem();
	        File file = item.getFile();
	        nombreArchivoSoporte = item.getFileName();	        
	        urlArchivoSoporte = ( (GppParametrizacion) parametrizacionService.buscarPorIdParametrizacion(1) ).getParVvalor();
	        if(urlArchivoSoporte!=null){
	        	urlArchivoSoporte = urlArchivoSoporte + "DOCUMENTOS_CC_" + persona.getPerNidentificacion() + "_" + new SimpleDateFormat("ddMMyyyy-HHmmss").format(new Date()) + "_" + nombreArchivoSoporte;
		        FileInputStream fis = new FileInputStream(file.getPath());
		        BufferedInputStream bis = new BufferedInputStream(fis);
		        FileOutputStream fos = new FileOutputStream(urlArchivoSoporte);
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
	
	public Boolean getGuardarSoporte(GppDocumento documento, GppPersona persona){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		documentoService = new DocumentoService();
		String nombreDocumento = "Documento-"+persona.getPerVnombres()+"-"+persona.getPerVapellidos();		
		return documentoService.crearDocumento(nombreDocumento, nombreArchivoSoporte, urlArchivoSoporte, documento.getDocDfecexpide(), documento.getPerNidpersona(), documento.getTarNidtipoarchivo(), usuarioAutenticado);
	}
	
	public List<Object> getSoportesPorIdPersona(Integer idPersona){
		documentoService = new DocumentoService();
		return documentoService.buscarDocumentosPorPersona(idPersona);
	}
	
	public List<Object> getHojasDeVidaPersona(Integer idPersona){
		documentoService = new DocumentoService();
		List<Object> hojasDeVida = null;
		List<Object> documentos = documentoService.buscarDocumentosPorPersona(idPersona);
		String prefijo = "Hoja";
		if(documentos!=null){
			Iterator<Object> it = documentos.iterator();
			while(it.hasNext()){
				GppDocumento documento = (GppDocumento) it.next();
				if(documento.getDocVnombre().startsWith(prefijo)){
					if(hojasDeVida==null)
						hojasDeVida = new ArrayList<Object>();
					hojasDeVida.add(documento);
				}
			}
		}
		return hojasDeVida;
	}
	
	public void getBorrarSoporteFisico(Integer idDocumentoSoporte){
		documentoService = new DocumentoService();
		documento = (GppDocumento) documentoService.buscarDocumentoPorId(idDocumentoSoporte);
		if(documento!=null){
			String urlArchivo = documento.getDocVurlarchivo();
			if(urlArchivo!=null){
				File archivoBorrar = new File(urlArchivo);
				archivoBorrar.delete();
			}
		}
	}
}