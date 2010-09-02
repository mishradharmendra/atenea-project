package co.com.inascol.atenea.test;

import java.util.Iterator;
import java.util.List;

import co.com.inascol.atenea.entity.GppServiciorol;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.ServiciorolService;
import co.com.inascol.atenea.logic.interfaces.IServiciorolService;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcción de Software
 * Esp. Sistemas de Información Geográfica
 * Ing. Catastral y Geodesta
 */
public class TestServiciorolService {

	private static IServiciorolService serviciorolService;
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
		serviciorolService = new ServiciorolService();
		int idServicio = 4;
		int idRol = 1;
		estadoOperacion = serviciorolService.crearServiciorol(idServicio, idRol, usuarioAutenticado);
		System.out.println(estadoOperacion);		
	}
	
	static void actualizar(){
		estadoOperacion = false;
		serviciorolService = new ServiciorolService();
		int idServicio = 1;
		int idRol = 1;
		estadoOperacion = serviciorolService.actualizarServiciorol(idServicio, idRol, usuarioAutenticado);
		System.out.println(estadoOperacion);
	}
	
	static void borrar(){
		estadoOperacion = false;
		serviciorolService = new ServiciorolService();
		int idServicio = 4;
		int idRol = 1;
		estadoOperacion = serviciorolService.borrarServiciorol(idServicio, idRol);
		System.out.println(estadoOperacion);		 
	}
	
	static void buscarPorId(){
		serviciorolService = new ServiciorolService();
		int idServicio = 5;
		int idRol = 1;
		GppServiciorol gppServiciorol = serviciorolService.buscarPorIdServiciorol(idServicio, idRol);
		if(gppServiciorol!=null){
			System.out.println(gppServiciorol.getId().getSerNidservicio());
			System.out.println(gppServiciorol.getId().getRolNidrol());
			System.out.println(gppServiciorol.getSrlVusucrea());
			System.out.println(gppServiciorol.getSrlDfeccrea());
		}else{
			System.out.println("error");
		}		
	}
	
	static void buscarTodos(){
		serviciorolService = new ServiciorolService();		
		List<Object> gppServicioroles = serviciorolService.buscarServicioroles();
		GppServiciorol gppServiciorol;
		if(gppServicioroles!=null){
			Iterator<Object> it = gppServicioroles.iterator();
			while(it.hasNext()){
				gppServiciorol = (GppServiciorol) it.next(); 
				System.out.println(gppServiciorol.getId().getSerNidservicio());
				System.out.println(gppServiciorol.getId().getRolNidrol());
				System.out.println(gppServiciorol.getSrlVusucrea());
				System.out.println(gppServiciorol.getSrlDfeccrea());
			}
		}else{
			System.out.println("error");
		}		
	}
}