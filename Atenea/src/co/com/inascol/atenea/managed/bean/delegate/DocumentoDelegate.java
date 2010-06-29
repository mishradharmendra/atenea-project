package co.com.inascol.atenea.managed.bean.delegate;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import co.com.inascol.atenea.entity.GppDocumento;
import co.com.inascol.atenea.logic.DocumentoService;
import co.com.inascol.atenea.logic.TipoarchivoService;
import co.com.inascol.atenea.logic.interfaces.IDocumentoService;
import co.com.inascol.atenea.logic.interfaces.ITipoarchivoService;

public class DocumentoDelegate {

	private IDocumentoService documentoService;
	private ITipoarchivoService tipoarchivoService;
	private String nombreArchivoSoporte;
	private String urlArchivoSoporte;
	
	public DocumentoDelegate(){}
	
	public List<Object> getListaTiposArchivos(){
		tipoarchivoService = new TipoarchivoService();
		return tipoarchivoService.buscarTipoarchivos();
	}
	
	public Boolean getBorrarSoporte(Integer idDocumentoSoporte){
		documentoService = new DocumentoService();
		return documentoService.borrarDocumento(idDocumentoSoporte);
	}
	
	public void getSubirSoporte(UploadEvent event) throws IOException {
	    if (event != null) {
	        UploadItem item = event.getUploadItem();
	        File file = item.getFile();
	        nombreArchivoSoporte = item.getFileName();
	        urlArchivoSoporte = "/home/memo/TEMP/" + System.currentTimeMillis() + "_" + nombreArchivoSoporte;
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
	
	public Boolean getGuardarSoporte(GppDocumento documento){
		documentoService = new DocumentoService();
		return documentoService.crearDocumento("docu", "nombre", "url", documento.getDocDfecexpide(), documento.getPerNidpersona(), documento.getTarNidtipoarchivo());
	}
	
	public List<Object> getSoportesPorIdPersona(Integer idPersona){
		documentoService = new DocumentoService();
		return documentoService.buscarDocumentosPorPersona(idPersona);
	}
}