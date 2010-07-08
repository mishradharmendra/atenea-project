package co.com.inascol.atenea.test;

import java.util.Iterator;
import java.util.List;

import co.com.inascol.atenea.entity.GppServicio;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.ServicioService;
import co.com.inascol.atenea.logic.interfaces.IServicioService;

public class TestServicioService {

	private static IServicioService ServicioService;
	private static GppUsuario usuarioAutenticado;
	private static Boolean estadoOperacion;
	
	public static void main(String argss[]){
//		crear();
//		actualizar();
//		borrar();
//		buscarPorId();
		buscarTodos();		
	}
	
	static void crear(){
		estadoOperacion = false;
		ServicioService = new ServicioService();
		String nombreServicio = "srvConsultaRoles";
		String rutaServicio = "Consultar roles dentro del m�dulo de administraci�n";
		usuarioAutenticado = new GppUsuario();
		usuarioAutenticado.setUsuVlogin("memotoro");
		estadoOperacion = ServicioService.crearServicio(nombreServicio, rutaServicio, usuarioAutenticado);
		System.out.println(estadoOperacion);		
	}
	
	static void actualizar(){
		estadoOperacion = false;
		ServicioService = new ServicioService();
		int idServicio = 1;
		String nombreServicio = "srvConsultaRoles";
		String rutaServicio = "Consultar roles m�dulo de administraci�n";		
		usuarioAutenticado = new GppUsuario();
		usuarioAutenticado.setUsuVlogin("memotoro");
		estadoOperacion = ServicioService.actualizarServicio(idServicio, nombreServicio, rutaServicio);
		System.out.println(estadoOperacion);
	}
	
	static void borrar(){
		estadoOperacion = false;
		ServicioService = new ServicioService();
		int idServicio = 1;
		estadoOperacion = ServicioService.borrarServicio(idServicio);
		System.out.println(estadoOperacion);		 
	}
	
	static void buscarPorId(){
		ServicioService = new ServicioService();
		int idServicio = 4;
		GppServicio gppServicio = ServicioService.buscarPorIdServicio(idServicio);
		if(gppServicio!=null){
			System.out.println(gppServicio.getSerNidservicio());
			System.out.println(gppServicio.getSerVnombre());
			System.out.println(gppServicio.getSerVruta());
			System.out.println(gppServicio.getSerVusucrea());
			System.out.println(gppServicio.getSerDfeccrea());
		}else{
			System.out.println("error");
		}		
	}
	
	static void buscarTodos(){
		ServicioService = new ServicioService();		
		List<Object> gppServicios = ServicioService.buscarServicios();
		GppServicio gppServicio;
		if(gppServicios!=null){
			Iterator<Object> it = gppServicios.iterator();
			while(it.hasNext()){
				gppServicio = (GppServicio) it.next(); 
				System.out.println(gppServicio.getSerNidservicio());
				System.out.println(gppServicio.getSerVnombre());
				System.out.println(gppServicio.getSerVruta());
				System.out.println(gppServicio.getSerVusucrea());
				System.out.println(gppServicio.getSerDfeccrea());
			}
		}else{
			System.out.println("error");
		}		
	}
}