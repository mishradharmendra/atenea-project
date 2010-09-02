package co.com.inascol.atenea.test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import co.com.inascol.atenea.entity.GppDocumento;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.DocumentoService;
import co.com.inascol.atenea.logic.interfaces.IDocumentoService;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcción de Software
 * Esp. Sistemas de Información Geográfica
 * Ing. Catastral y Geodesta
 */
public class TestDocumentoService {
	
	private static IDocumentoService documentoService;
	private static Boolean estadoOperacion;
	private static GppUsuario usuarioAutenticado;
	
	public static void main(String argss[]){
//		crear();
//		actualizar();
//		borrar();
//		buscarPorId();
		buscarTodos();		
	}
	
	static void crear(){
		estadoOperacion = false;
		documentoService = new DocumentoService();
		for(int i=1;i<10;i++){
			String nombreDocumento = "Nombre Documento "+i;
			String nombreArchivo  = "Archivo"+i;
			String urlArchivo  = "/url/test/"+i;
			Date fechaExpedicion  = new Date();
			Integer idPersona  = i;
			Integer idTipoArchivo  = i;
			estadoOperacion = documentoService.crearDocumento(nombreDocumento, nombreArchivo, urlArchivo, fechaExpedicion, idPersona, idTipoArchivo, usuarioAutenticado);
			System.out.println(estadoOperacion);
		}
	}
	
	static void actualizar(){
		estadoOperacion = false;
		documentoService = new DocumentoService();
		for(int i=1;i<10;i++){
			Integer idDocumento = i;
			String nombreDocumento = "Nombre Documento "+i+i;
			String nombreArchivo  = "Archivo"+i+i;
			String urlArchivo  = "/url/test/"+i+i;
			Date fechaExpedicion  = new Date();
			Integer idPersona  = i;
			Integer idTipoArchivo  = i;
			estadoOperacion = documentoService.actualizarDocumento(idDocumento, nombreDocumento, nombreArchivo, urlArchivo, fechaExpedicion, idPersona, idTipoArchivo, usuarioAutenticado);
			System.out.println(estadoOperacion);
		}
	}
	
	static void borrar(){
		estadoOperacion = false;
		documentoService = new DocumentoService();
		Integer idDocumento = 6;
		estadoOperacion = documentoService.borrarDocumento(idDocumento);
		System.out.println(estadoOperacion);		 
	}
	
	static void buscarPorId(){
		documentoService = new DocumentoService();
		Integer idDocumento = 6;
		GppDocumento gppDocumento = documentoService.buscarDocumentoPorId(idDocumento);
		if(gppDocumento!=null){
			System.out.println(gppDocumento.getDocNiddocumento());
			System.out.println(gppDocumento.getDocVnombre());
			System.out.println(gppDocumento.getDocVarchivo());
			System.out.println(gppDocumento.getDocVurlarchivo());
			System.out.println(gppDocumento.getDocDfecexpide());
			System.out.println(gppDocumento.getPerNidpersona());
			System.out.println(gppDocumento.getTarNidtipoarchivo());
			System.out.println(gppDocumento.getDocVusumodifica());
			System.out.println(gppDocumento.getDocDfecmodifica());
			System.out.println(gppDocumento.getDocVusucrea());
			System.out.println(gppDocumento.getDocDfeccrea());				
		}else{
			System.out.println("error");
		}		
	}
	
	static void buscarTodos(){
		documentoService = new DocumentoService();
		List<Object> gppDocumentos = documentoService.buscarDocumentos();
		GppDocumento gppDocumento;
		if(gppDocumentos!=null){
			Iterator<Object> it = gppDocumentos.iterator();
			while(it.hasNext()){
				gppDocumento = (GppDocumento) it.next(); 
				System.out.println(gppDocumento.getDocNiddocumento());
				System.out.println(gppDocumento.getDocVnombre());
				System.out.println(gppDocumento.getDocVarchivo());
				System.out.println(gppDocumento.getDocVurlarchivo());
				System.out.println(gppDocumento.getDocDfecexpide());
				System.out.println(gppDocumento.getPerNidpersona());
				System.out.println(gppDocumento.getTarNidtipoarchivo());
				System.out.println(gppDocumento.getDocVusumodifica());
				System.out.println(gppDocumento.getDocDfecmodifica());
				System.out.println(gppDocumento.getDocVusucrea());
				System.out.println(gppDocumento.getDocDfeccrea());	
			}
		}else{
			System.out.println("error");
		}		
	}
}