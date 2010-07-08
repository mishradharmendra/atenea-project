package co.com.inascol.atenea.test;

import java.util.Iterator;
import java.util.List;

import co.com.inascol.atenea.entity.GppEstadocivil;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.EstadocivilService;
import co.com.inascol.atenea.logic.interfaces.IEstadocivilService;

public class TestEstadocivilService {

	private static IEstadocivilService estadocivilService;
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
		estadocivilService = new EstadocivilService();
		for(int i =1; i<10;i++){
			String nombreEstadoCivil = "Casado "+i;
			estadoOperacion = estadocivilService.crearEstadoCivil(nombreEstadoCivil, usuarioAutenticado);
			System.out.println(estadoOperacion);
		}
	}
	
	static void actualizar(){
		estadoOperacion = false;
		estadocivilService = new EstadocivilService();
		for(int i =1; i<10;i++){
			Integer idEstadoCivil = i;
			String nombreEstadoCivil = "Casado "+i+i;
			estadoOperacion = estadocivilService.actualizarEstadoCivil(idEstadoCivil, nombreEstadoCivil, usuarioAutenticado);
			System.out.println(estadoOperacion);
		}
	}
	
	static void borrar(){
		estadoOperacion = false;
		estadocivilService = new EstadocivilService();
		Integer idEstadoCivil = 1;
		estadoOperacion = estadocivilService.borrarEstadoCivil(idEstadoCivil);
		System.out.println(estadoOperacion);		 
	}
	
	static void buscarPorId(){
		estadocivilService = new EstadocivilService();
		Integer idEstadoCivil = 1;
		GppEstadocivil gppEstadocivil = estadocivilService.buscarEstadoCivilPorId(idEstadoCivil);
		if(gppEstadocivil!=null){
			System.out.println(gppEstadocivil.getEscNidestadocivil());
			System.out.println(gppEstadocivil.getEscVestadocivil());
			System.out.println(gppEstadocivil.getEscVusucrea());
			System.out.println(gppEstadocivil.getEscDfeccrea());
			System.out.println(gppEstadocivil.getEscVusumodifica());
			System.out.println(gppEstadocivil.getEscDfecmodifica());
		} else{
			System.out.println("error");
		}		
	}
	
	static void buscarTodos(){
		estadocivilService = new EstadocivilService();	
		List<Object> gppCargosEquivalentes = estadocivilService.buscarEstadosCiviles();
		GppEstadocivil gppEstadocivil;
		if(gppCargosEquivalentes!=null){
			Iterator<Object> it = gppCargosEquivalentes .iterator();
			while(it.hasNext()){
				gppEstadocivil = (GppEstadocivil) it.next(); 
				System.out.println(gppEstadocivil.getEscNidestadocivil());
				System.out.println(gppEstadocivil.getEscVestadocivil());
				System.out.println(gppEstadocivil.getEscVusucrea());
				System.out.println(gppEstadocivil.getEscDfeccrea());
				System.out.println(gppEstadocivil.getEscVusumodifica());
				System.out.println(gppEstadocivil.getEscDfecmodifica());
			}
		}else{
			System.out.println("error");
		}		
	}
}