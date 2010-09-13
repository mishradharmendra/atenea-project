package co.com.inascol.atenea.test;

import java.util.Iterator;
import java.util.List;

import co.com.inascol.atenea.entity.GppParametrizacion;
import co.com.inascol.atenea.logic.ParametrizacionService;
import co.com.inascol.atenea.logic.interfaces.IParametrizacionService;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class TestParametrizacionService {

	private static IParametrizacionService ParametrizacionService;
	private static Boolean estadoOperacion;
	
	public static void main(String argss[]){
		crear();
//		actualizar();
//		borrar();
//		buscarPorId();
//		buscarTodos();		
	}
	
	static void crear(){
		estadoOperacion = false;
		ParametrizacionService = new ParametrizacionService();
		String nombreParam = "Dias de Vigenca";
		String valorParam = "6";
		String descripcionParam = "Dias de Vigencia de Hojas de Vida";
		estadoOperacion = ParametrizacionService.crearParametrizacion(nombreParam, valorParam, descripcionParam);
		System.out.println(estadoOperacion);		
	}
	
	static void actualizar(){
		estadoOperacion = false;
		ParametrizacionService = new ParametrizacionService();
		int idParam = 1;
		String nombreParam = "Ruta del servidor";
		String valorParam = "http://serv.com:8080";
		String descripcionParam = "Servidor de correo de salida";
		estadoOperacion = ParametrizacionService.actualizarParametrizacion(idParam, nombreParam, valorParam, descripcionParam);
		System.out.println(estadoOperacion);
	}
	
	static void borrar(){
		estadoOperacion = false;
		ParametrizacionService = new ParametrizacionService();
		int idParam = 1;
		estadoOperacion = ParametrizacionService.borrarParametrizacion(idParam);
		System.out.println(estadoOperacion);		 
	}
	
	static void buscarPorId(){
		ParametrizacionService = new ParametrizacionService();
		int idParam = 3;
		GppParametrizacion gppParametrizacion = ParametrizacionService.buscarPorIdParametrizacion(idParam);
		if(gppParametrizacion!=null){
			System.out.println(gppParametrizacion.getParNidparam());
			System.out.println(gppParametrizacion.getParVnombre());
			System.out.println(gppParametrizacion.getParVvalor());
			System.out.println(gppParametrizacion.getParVdescripcion());
		}else{
			System.out.println("error");
		}		
	}
	
	static void buscarTodos(){
		ParametrizacionService = new ParametrizacionService();		
		List<Object> gppParametrizacions = ParametrizacionService.buscarParametrizacion();
		GppParametrizacion gppParametrizacion;
		if(gppParametrizacions!=null){
			Iterator<Object> it = gppParametrizacions.iterator();
			while(it.hasNext()){
				gppParametrizacion = (GppParametrizacion) it.next(); 
				System.out.println(gppParametrizacion.getParNidparam());
				System.out.println(gppParametrizacion.getParVnombre());
				System.out.println(gppParametrizacion.getParVvalor());
				System.out.println(gppParametrizacion.getParVdescripcion());
			}
		}else{
			System.out.println("error");
		}		
	}
}