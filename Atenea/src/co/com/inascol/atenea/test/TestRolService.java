package co.com.inascol.atenea.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import co.com.inascol.atenea.entity.GppRol;
import co.com.inascol.atenea.logic.RolService;
import co.com.inascol.atenea.logic.interfaces.IRolService;

public class TestRolService {

	private static IRolService rolService;
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
		rolService = new RolService();
		String nombreRol = "Gestor Humano";
		String descripcionRol = "Administra las Hojas de Vida";
		String activoRol ="SI";
		List <Object> listaServicios= new ArrayList<Object>();
		listaServicios.add(1);
		listaServicios.add(2);    
		estadoOperacion = rolService.crearRol(nombreRol, descripcionRol, activoRol, listaServicios);
		System.out.println(estadoOperacion);		
	}
	
	static void actualizar(){
		estadoOperacion = false;
		rolService = new RolService();
		int idRol = 1;
		String nombreRol = "Administradores";
		String descripcionRol = "Administran la aplicaci�n de Hojas de Vida";
		String activoRol ="SI";
		estadoOperacion = rolService.actualizarRol(idRol, nombreRol, descripcionRol, activoRol);
		System.out.println(estadoOperacion);
	}
	
	static void borrar(){
		estadoOperacion = false;
		rolService = new RolService();
		int idRol = 1;
		estadoOperacion = rolService.borrarRol(idRol);
		System.out.println(estadoOperacion);		 
	}
	
	static void buscarPorId(){
		rolService = new RolService();
		int idRol = 1;
		GppRol gppRol = rolService.buscarPorIdRol(idRol);
		if(gppRol!=null){
			System.out.println(gppRol.getRolNidrol());
			System.out.println(gppRol.getRolVnombre());
			System.out.println(gppRol.getRolVdescripcion());
			System.out.println(gppRol.getRolVusucrea());
			System.out.println(gppRol.getRolDfeccrea());
			System.out.println(gppRol.getRolVusumodifica());
			System.out.println(gppRol.getRolDfecmodifica());
			System.out.println(gppRol.getRolVactivo());
			
		}else{
			System.out.println("error");
		}		
	}
	
	static void buscarTodos(){
		rolService = new RolService();		
		List<Object> gppRols = rolService.buscarRoles();
		GppRol gppRol;
		if(gppRols!=null){
			Iterator<Object> it = gppRols.iterator();
			while(it.hasNext()){
				gppRol = (GppRol) it.next(); 
				System.out.println(gppRol.getRolNidrol());
				System.out.println(gppRol.getRolVnombre());
				System.out.println(gppRol.getRolVdescripcion());
				System.out.println(gppRol.getRolVusucrea());
				System.out.println(gppRol.getRolDfeccrea());
				System.out.println(gppRol.getRolVusumodifica());
				System.out.println(gppRol.getRolDfecmodifica());
				System.out.println(gppRol.getRolVactivo());
			}
		}else{
			System.out.println("error");
		}		
	}
}