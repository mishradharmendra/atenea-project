package co.com.inascol.atenea.test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import co.com.inascol.atenea.entity.GppFormacion;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.FormacionService;
import co.com.inascol.atenea.logic.interfaces.IFormacionService;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcción de Software
 * Esp. Sistemas de Información Geográfica
 * Ing. Catastral y Geodesta
 */
public class TestFormacionService {

	private static IFormacionService formacionService;
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
		formacionService = new FormacionService();
		for(int i =1; i<10;i++){
			String titulo = "Titulo "+i;
			Date fechaGrado = new Date(); 
			Integer duracion = i;
			String unidadDuracion = "A";
			String tarjetaProfesional = "99--aaii-"+i;
			Date fechaTarjetaProfecional = new Date();
			Integer idPersona = i;
			Integer idNivelAcademico = i;
			Integer idInstitucion = i;
			Integer idTituloEquivalente = i;
			Integer idDocumentoTarjeta = i;
			Integer idActaGrado = i;
			Integer idDocumentoDiploma = i;
			estadoOperacion = formacionService.crearFormacion(titulo, fechaGrado, duracion, unidadDuracion, tarjetaProfesional, fechaTarjetaProfecional, idPersona, idNivelAcademico, idInstitucion, idTituloEquivalente, idDocumentoTarjeta, idActaGrado, idDocumentoDiploma, usuarioAutenticado);			
			System.out.println(estadoOperacion);
		}
	}
	
	static void actualizar(){
		estadoOperacion = false;
		formacionService = new FormacionService();
		for(int i =1; i<10;i++){
			Integer idFormacion = i;
			String titulo = "Titulo "+i+i;
			Date fechaGrado = new Date(); 
			Integer duracion = i;
			String unidadDuracion = "A";
			String tarjetaProfesional = "99--aaii-"+i+i;
			Date fechaTarjetaProfecional = new Date();
			Integer idPersona = i+i;
			Integer idNivelAcademico = i+i;
			Integer idInstitucion = i+i;
			Integer idTituloEquivalente = i+i;
			Integer idDocumentoTarjeta = i+i;
			Integer idActaGrado = i+i;
			Integer idDocumentoDiploma = i+i;
			estadoOperacion = formacionService.actualizarFormacion(idFormacion, titulo, fechaGrado, duracion, unidadDuracion, tarjetaProfesional, fechaTarjetaProfecional, idPersona, idNivelAcademico, idInstitucion, idTituloEquivalente, idDocumentoTarjeta, idActaGrado, idDocumentoDiploma, usuarioAutenticado);
			System.out.println(estadoOperacion);
		}
	}
	
	static void borrar(){
		estadoOperacion = false;
		formacionService = new FormacionService();
		Integer idFormacion = 1;
		estadoOperacion = formacionService.borrarFormacion(idFormacion);
		System.out.println(estadoOperacion);		 
	}
	
	static void buscarPorId(){
		formacionService = new FormacionService();
		Integer idFormacion = 1;
		GppFormacion gppFormacion = formacionService.buscarFormacionPorId(idFormacion);
		if(gppFormacion!=null){
			System.out.println(gppFormacion.getForNidformacion());
			System.out.println(gppFormacion.getForVtitulo());
			System.out.println(gppFormacion.getForDfecgrado());
			System.out.println(gppFormacion.getForNduracion());
			System.out.println(gppFormacion.getForVunidaddurac());
			System.out.println(gppFormacion.getForVtarjetaprof());
			System.out.println(gppFormacion.getForDfectarjeta());
			System.out.println(gppFormacion.getPerNidpersona());
			System.out.println(gppFormacion.getNacNidnivelac());
			System.out.println(gppFormacion.getInsNidinstitucion());
			System.out.println(gppFormacion.getTeqNidtituloeq());
			System.out.println(gppFormacion.getDocNidiploma());
			System.out.println(gppFormacion.getDocNactagrado());
			System.out.println(gppFormacion.getDocNtarjetaprof());
			System.out.println(gppFormacion.getForVusucrea());
			System.out.println(gppFormacion.getForDfeccrea());
			System.out.println(gppFormacion.getForVusumodifica());
			System.out.println(gppFormacion.getForDfecmodifica());			
		} else{
			System.out.println("error");
		}		
	}
	
	static void buscarTodos(){
		formacionService = new FormacionService();
		List<Object> gppFormaciones = formacionService.buscarFormaciones();
		GppFormacion gppFormacion;
		if(gppFormaciones!=null){
			Iterator<Object> it = gppFormaciones.iterator();
			while(it.hasNext()){
				gppFormacion = (GppFormacion) it.next(); 
				System.out.println(gppFormacion.getForNidformacion());
				System.out.println(gppFormacion.getForVtitulo());
				System.out.println(gppFormacion.getForDfecgrado());
				System.out.println(gppFormacion.getForNduracion());
				System.out.println(gppFormacion.getForVunidaddurac());
				System.out.println(gppFormacion.getForVtarjetaprof());
				System.out.println(gppFormacion.getForDfectarjeta());
				System.out.println(gppFormacion.getPerNidpersona());
				System.out.println(gppFormacion.getNacNidnivelac());
				System.out.println(gppFormacion.getInsNidinstitucion());
				System.out.println(gppFormacion.getTeqNidtituloeq());
				System.out.println(gppFormacion.getDocNidiploma());
				System.out.println(gppFormacion.getDocNactagrado());
				System.out.println(gppFormacion.getDocNtarjetaprof());
				System.out.println(gppFormacion.getForVusucrea());
				System.out.println(gppFormacion.getForDfeccrea());
				System.out.println(gppFormacion.getForVusumodifica());
				System.out.println(gppFormacion.getForDfecmodifica());	
			}
		}else{
			System.out.println("error");
		}		
	}
}