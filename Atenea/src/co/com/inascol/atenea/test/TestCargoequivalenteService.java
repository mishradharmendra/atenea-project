package co.com.inascol.atenea.test;

import java.util.Iterator;
import java.util.List;

import co.com.inascol.atenea.entity.GppCargoequivalente;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.CargoequivalenteService;
import co.com.inascol.atenea.logic.interfaces.ICargoequivalenteService;

public class TestCargoequivalenteService {

	private static ICargoequivalenteService cargoequivalenteService;
	private static Boolean estadoOperacion;
	private static GppUsuario usuarioAutenticado;
	
	public static void main(String argss[]){
//		crear();
//		actualizar();
		borrar();
//		buscarPorId();
//		buscarTodos();		
	}
	
	static void crear(){
		estadoOperacion = false;
		cargoequivalenteService = new CargoequivalenteService();
		for(int i =1; i<10;i++){
			String nombreCargoEquivalente = "Ingeniero Desarrolador "+i;
			estadoOperacion = cargoequivalenteService.crearCargoEquivalente(nombreCargoEquivalente,usuarioAutenticado);
			System.out.println(estadoOperacion);
		}
	}
	
	static void actualizar(){
		estadoOperacion = false;
		cargoequivalenteService = new CargoequivalenteService();
		for(int i =1; i<10;i++){
			Integer idCargoEquivalente = i;
			String nombreCargoEquivalente = "Ingeniero Desarrolador "+i;
			estadoOperacion = cargoequivalenteService.actualizarCargoEquivalente(idCargoEquivalente, nombreCargoEquivalente,usuarioAutenticado);
			System.out.println(estadoOperacion);
		}
	}
	
	static void borrar(){
		estadoOperacion = false;
		cargoequivalenteService = new CargoequivalenteService();
		Integer idCargoEquivalente = 6;
		estadoOperacion = cargoequivalenteService.borrarCargoEquivalente(idCargoEquivalente);
		System.out.println(estadoOperacion);		 
	}
	
	static void buscarPorId(){
		cargoequivalenteService = new CargoequivalenteService();
		Integer idCargoEquivalente = 6;
		GppCargoequivalente gppCargoequivalente = cargoequivalenteService.buscarCargoEquivalentePorId(idCargoEquivalente);
		if(gppCargoequivalente!=null){
			System.out.println(gppCargoequivalente.getCeqNidcargoeq());
			System.out.println(gppCargoequivalente.getCeqVcargoeq());
			System.out.println(gppCargoequivalente.getCeqVusucrea());
			System.out.println(gppCargoequivalente.getCeqDfeccrea());
			System.out.println(gppCargoequivalente.getCeqVusumodifica());
			System.out.println(gppCargoequivalente.getCeqDfecmodifica());
		} else{
			System.out.println("error");
		}		
	}
	
	static void buscarTodos(){
		cargoequivalenteService = new CargoequivalenteService();	
		List<Object> gppCargosEquivalentes = cargoequivalenteService.buscarCargosEquivalentes();
		GppCargoequivalente gppCargoequivalente;
		if(gppCargosEquivalentes!=null){
			Iterator<Object> it = gppCargosEquivalentes .iterator();
			while(it.hasNext()){
				gppCargoequivalente = (GppCargoequivalente) it.next(); 
				System.out.println(gppCargoequivalente.getCeqNidcargoeq());
				System.out.println(gppCargoequivalente.getCeqVcargoeq());
				System.out.println(gppCargoequivalente.getCeqVusucrea());
				System.out.println(gppCargoequivalente.getCeqDfeccrea());
				System.out.println(gppCargoequivalente.getCeqVusumodifica());
				System.out.println(gppCargoequivalente.getCeqDfecmodifica());
			}
		}else{
			System.out.println("error");
		}		
	}
}