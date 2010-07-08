package co.com.inascol.atenea.test;

import java.util.Iterator;
import java.util.List;

import co.com.inascol.atenea.entity.GppTipoarchivo;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.TipoarchivoService;
import co.com.inascol.atenea.logic.interfaces.ITipoarchivoService;

public class TestTipoarchivoService {

	private static ITipoarchivoService tipoarchivoService;
	private static GppUsuario usuarioAutenticado;
	private static Boolean estadoOperacion;	
	
	public static void main(String argss[]){
		crear();
//		actualizar();
//		borrar();
//		buscarPorId();
		buscarTodos();		
	}
	
	static void crear(){
		estadoOperacion = false;
		tipoarchivoService = new TipoarchivoService();
		String nombreTipoarchivo = "Acrobat";
		usuarioAutenticado = new GppUsuario();
		usuarioAutenticado.setUsuVlogin("memotoro");
		estadoOperacion = tipoarchivoService.crearTipoarchivo(nombreTipoarchivo, usuarioAutenticado);
		System.out.println(estadoOperacion);		
	}
	
	static void actualizar(){
		estadoOperacion = false;
		tipoarchivoService = new TipoarchivoService();
		int idTipoarchivo = 1;
		String nombreTipoarchivo = "WORD";
		usuarioAutenticado = new GppUsuario();
		usuarioAutenticado.setUsuVlogin("memotoro");
		estadoOperacion = tipoarchivoService.actualizarTipoarchivo(idTipoarchivo, nombreTipoarchivo, usuarioAutenticado);
		System.out.println(estadoOperacion);
	}
	
	static void borrar(){
		estadoOperacion = false;
		tipoarchivoService = new TipoarchivoService();
		int idTipoarchivo = 1;
		estadoOperacion = tipoarchivoService.borrarTipoarchivo(idTipoarchivo);
		System.out.println(estadoOperacion);		 
	}
	
	static void buscarPorId(){
		tipoarchivoService = new TipoarchivoService();
		int idTipoarchivo = 4;
		GppTipoarchivo gppTipoarchivo = tipoarchivoService.buscarPorIdTipoarchivo(idTipoarchivo);
		if(gppTipoarchivo!=null){
			System.out.println(gppTipoarchivo.getTarNidtipoarchivo());
			System.out.println(gppTipoarchivo.getTarVtipoarchivo());
			System.out.println(gppTipoarchivo.getTarVusucrea());
			System.out.println(gppTipoarchivo.getTarDfeccrea());
			System.out.println(gppTipoarchivo.getTarVusumodifica());
			System.out.println(gppTipoarchivo.getTarDfecmodifica());
		}else{
			System.out.println("error");
		}		
	}
	
	static void buscarTodos(){
		tipoarchivoService = new TipoarchivoService();		
		List<Object> gppTipoarchivos = tipoarchivoService.buscarTipoarchivos();
		GppTipoarchivo gppTipoarchivo;
		if(gppTipoarchivos!=null){
			Iterator<Object> it = gppTipoarchivos.iterator();
			while(it.hasNext()){
				gppTipoarchivo = (GppTipoarchivo) it.next(); 
				System.out.println(gppTipoarchivo.getTarNidtipoarchivo());
				System.out.println(gppTipoarchivo.getTarVtipoarchivo());
				System.out.println(gppTipoarchivo.getTarVusucrea());
				System.out.println(gppTipoarchivo.getTarDfeccrea());
				System.out.println(gppTipoarchivo.getTarVusumodifica());
				System.out.println(gppTipoarchivo.getTarDfecmodifica());
			}
		}else{
			System.out.println("error");
		}		
	}
}