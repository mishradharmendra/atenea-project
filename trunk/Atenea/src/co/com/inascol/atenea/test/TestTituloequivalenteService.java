package co.com.inascol.atenea.test;

import java.util.Iterator;
import java.util.List;

import co.com.inascol.atenea.entity.GppTituloequivalente;
import co.com.inascol.atenea.logic.TituloequivalenteService;
import co.com.inascol.atenea.logic.interfaces.ITituloequivalenteService;

public class TestTituloequivalenteService {

	private static ITituloequivalenteService tituloequivalenteService;
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
		tituloequivalenteService = new TituloequivalenteService();
		for(int i =1; i<10;i++){
			String nombreTituloEquivalente = "Titulo Equivalente "+i;
			estadoOperacion = tituloequivalenteService.crearTituloEquivalente(nombreTituloEquivalente);
			System.out.println(estadoOperacion);
		}
	}
	
	static void actualizar(){
		estadoOperacion = false;
		tituloequivalenteService = new TituloequivalenteService();
		for(int i =1; i<10;i++){
			Integer idTituloEquivalente = i;
			String nombreTituloEquivalente = "Titulo Equivalente "+i+i;
			estadoOperacion = tituloequivalenteService.actualizarTituloEquivalente(idTituloEquivalente, nombreTituloEquivalente);
			System.out.println(estadoOperacion);
		}
	}
	
	static void borrar(){
		estadoOperacion = false;
		tituloequivalenteService = new TituloequivalenteService();
		Integer idTituloEquivalente = 1;
		estadoOperacion = tituloequivalenteService.borrarTituloEquivalente(idTituloEquivalente);
		System.out.println(estadoOperacion);		 
	}
	
	static void buscarPorId(){
		tituloequivalenteService = new TituloequivalenteService();
		Integer idTituloEquivalente = 1;
		GppTituloequivalente gppTituloequivalente = tituloequivalenteService.buscarTituloEquivalentePorId(idTituloEquivalente);
		if(gppTituloequivalente!=null){
			System.out.println(gppTituloequivalente.getTeqNidtituloeq());
			System.out.println(gppTituloequivalente.getTeqVtituloeq());
			System.out.println(gppTituloequivalente.getTeqVusucrea());
			System.out.println(gppTituloequivalente.getTeqDfeccrea());
			System.out.println(gppTituloequivalente.getTeqVusumodifica());
			System.out.println(gppTituloequivalente.getTeqDfecmodifica());
		} else{
			System.out.println("error");
		}		
	}
	
	static void buscarTodos(){
		tituloequivalenteService = new TituloequivalenteService();
		List<Object> gppTitulosEquivalentes = tituloequivalenteService.buscarTitulosEquivalentes();
		GppTituloequivalente gppTituloequivalente;
		if(gppTitulosEquivalentes!=null){
			Iterator<Object> it = gppTitulosEquivalentes.iterator();
			while(it.hasNext()){
				gppTituloequivalente = (GppTituloequivalente) it.next(); 
				System.out.println(gppTituloequivalente.getTeqNidtituloeq());
				System.out.println(gppTituloequivalente.getTeqVtituloeq());
				System.out.println(gppTituloequivalente.getTeqVusucrea());
				System.out.println(gppTituloequivalente.getTeqDfeccrea());
				System.out.println(gppTituloequivalente.getTeqVusumodifica());
				System.out.println(gppTituloequivalente.getTeqDfecmodifica());
			}
		}else{
			System.out.println("error");
		}		
	}
}