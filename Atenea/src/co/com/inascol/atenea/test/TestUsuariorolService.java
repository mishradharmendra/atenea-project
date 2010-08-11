package co.com.inascol.atenea.test;

import java.util.Iterator;
import java.util.List;

import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.entity.GppUsuariorol;
import co.com.inascol.atenea.logic.UsuariorolService;
import co.com.inascol.atenea.logic.interfaces.IUsuariorolService;
/**
 * @author Guillermo Toro
 *
 */
public class TestUsuariorolService {

	private static IUsuariorolService serviciorolService;
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
		serviciorolService = new UsuariorolService();
		int idUsuario = 2;
		int idRol = 1;
		estadoOperacion = serviciorolService.crearUsuariorol(idUsuario, idRol, usuarioAutenticado);
		System.out.println(estadoOperacion);		
	}
	
	static void actualizar(){
		estadoOperacion = false;
		serviciorolService = new UsuariorolService();
		int idUsuario = 1;
		int idRol = 1;
		estadoOperacion = serviciorolService.actualizarUsuariorol(idUsuario, idRol, usuarioAutenticado);
		System.out.println(estadoOperacion);
	}
	
	static void borrar(){
		estadoOperacion = false;
		serviciorolService = new UsuariorolService();
		int idUsuario = 2;
		int idRol = 1;
		estadoOperacion = serviciorolService.borrarUsuariorol(idUsuario, idRol);
		System.out.println(estadoOperacion);		 
	}
	
	static void buscarPorId(){
		serviciorolService = new UsuariorolService();
		int idUsuario = 2;
		int idRol = 1;
		GppUsuariorol gppUsuariorol = serviciorolService.buscarPorIdUsuariorol(idUsuario, idRol);
		if(gppUsuariorol!=null){
			System.out.println(gppUsuariorol.getId().getUsuNidusuario());
			System.out.println(gppUsuariorol.getId().getRolNidrol());
			System.out.println(gppUsuariorol.getUrlVusucrea());
			System.out.println(gppUsuariorol.getUrlDfeccrea());
		}else{
			System.out.println("error");
		}		
	}
	
	static void buscarTodos(){
		serviciorolService = new UsuariorolService();		
		List<Object> gppUsuarioroles = serviciorolService.buscarUsuarioroles();
		GppUsuariorol gppUsuariorol;
		if(gppUsuarioroles!=null){
			Iterator<Object> it = gppUsuarioroles.iterator();
			while(it.hasNext()){
				gppUsuariorol = (GppUsuariorol) it.next(); 
				System.out.println(gppUsuariorol.getId().getUsuNidusuario());
				System.out.println(gppUsuariorol.getId().getRolNidrol());
				System.out.println(gppUsuariorol.getUrlVusucrea());
				System.out.println(gppUsuariorol.getUrlDfeccrea());
			}
		}else{
			System.out.println("error");
		}		
	}
}