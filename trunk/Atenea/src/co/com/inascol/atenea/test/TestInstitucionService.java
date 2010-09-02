package co.com.inascol.atenea.test;

import java.util.Iterator;
import java.util.List;

import co.com.inascol.atenea.entity.GppInstitucion;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.InstitucionService;
import co.com.inascol.atenea.logic.interfaces.IInstitucionService;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcción de Software
 * Esp. Sistemas de Información Geográfica
 * Ing. Catastral y Geodesta
 */
public class TestInstitucionService {

	private static IInstitucionService iInstitucionService;
	private static Boolean estadoOperacion;
	private static GppUsuario usuarioAutenticado;
	
	public static void main(String args[]){
//		crear();
//		actualizar();
//		borrar();
//		buscarPorId();
		buscarTodos();
	}
	
	static void crear(){
		estadoOperacion = false;
		iInstitucionService = new InstitucionService();	
		String nombreInstitucion = "UNIVERSIDAD NACIONAL";
		estadoOperacion = iInstitucionService.crearInstitucion(nombreInstitucion, usuarioAutenticado);
		System.out.println(estadoOperacion);
	}
	
	static void actualizar(){
		estadoOperacion = false;
		iInstitucionService = new InstitucionService();
		Integer idInstitucion = 1;
		String nombreInstitucion = "UNIVERSIDAD DISTRITAL-DC";
		estadoOperacion = iInstitucionService.actualizarInstitucion(idInstitucion, nombreInstitucion, usuarioAutenticado);
		System.out.println(estadoOperacion);	
	}
	
	static void borrar(){
		estadoOperacion = false;
		iInstitucionService = new InstitucionService();
		Integer idInstitucion = 1;
		estadoOperacion = iInstitucionService.borrarInstitucion(idInstitucion);
		System.out.println(estadoOperacion);
	}
	
	static void buscarPorId(){
		iInstitucionService = new InstitucionService();
		Integer idInstitucion = 2;
		GppInstitucion gppInstitucion = iInstitucionService.buscarPorIdInstitucion(idInstitucion);
		if(gppInstitucion!=null){
			System.out.println(gppInstitucion.getInsNidinstitucion());
			System.out.println(gppInstitucion.getInsVinstitucion());
			System.out.println(gppInstitucion.getInsVusucrea());
			System.out.println(gppInstitucion.getInsDfeccrea());
			System.out.println(gppInstitucion.getInsVusumodifica());
			System.out.println(gppInstitucion.getInsDfecmodifica());
		}else{
			System.out.println("error");
		}
	}
	
	static void buscarTodos(){
		iInstitucionService = new InstitucionService();
		List<Object> gppInstituciones = iInstitucionService.buscarInstituciones();		
		if(gppInstituciones!=null){
			Iterator<Object> it = gppInstituciones.iterator();
			while(it.hasNext()){
				GppInstitucion gppInstitucion = (GppInstitucion) it.next();
				System.out.println(gppInstitucion.getInsNidinstitucion());
				System.out.println(gppInstitucion.getInsVinstitucion());
				System.out.println(gppInstitucion.getInsVusucrea());
				System.out.println(gppInstitucion.getInsDfeccrea());
				System.out.println(gppInstitucion.getInsVusumodifica());
				System.out.println(gppInstitucion.getInsDfecmodifica());
			}
		}else{
			System.out.println("error");
		}		
	}
}