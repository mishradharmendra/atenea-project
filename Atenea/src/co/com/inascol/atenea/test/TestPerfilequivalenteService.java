package co.com.inascol.atenea.test;

import java.util.Iterator;
import java.util.List;

import co.com.inascol.atenea.entity.GppPerfilequivalente;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.PerfilequivalenteService;
import co.com.inascol.atenea.logic.interfaces.IPerfilequivalenteService;
/**
 * @author Guillermo Toro
 *
 */
public class TestPerfilequivalenteService {
	
	private static IPerfilequivalenteService perfilequivalenteService;
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
		perfilequivalenteService = new PerfilequivalenteService();
		for(int i =1; i<10;i++){
			String nombrePerfilEquivalente = "Developer "+i;
			estadoOperacion = perfilequivalenteService.crearPerfilEquivalente(nombrePerfilEquivalente, usuarioAutenticado);
			System.out.println(estadoOperacion);
		}
	}
	
	static void actualizar(){
		estadoOperacion = false;
		perfilequivalenteService = new PerfilequivalenteService();
		for(int i =1; i<10;i++){
			Integer idPerfilEquivalente = i;
			String nombrePerfilEquivalente = "Developer "+i;
			estadoOperacion = perfilequivalenteService.actualizarPerfilEquivalente(idPerfilEquivalente, nombrePerfilEquivalente, usuarioAutenticado);
			System.out.println(estadoOperacion);
		}
	}
	
	static void borrar(){
		estadoOperacion = false;
		perfilequivalenteService = new PerfilequivalenteService();
		Integer idPerfilEquivalente = 6;
		estadoOperacion = perfilequivalenteService.borrarPerfilEquivalente(idPerfilEquivalente);
		System.out.println(estadoOperacion);		 
	}
	
	static void buscarPorId(){
		perfilequivalenteService = new PerfilequivalenteService();
		Integer idPerfilEquivalente = 6;
		GppPerfilequivalente gppPerfilequivalente = perfilequivalenteService.buscarPerfilEquivalentePorId(idPerfilEquivalente);
		if(gppPerfilequivalente!=null){
			System.out.println(gppPerfilequivalente.getPeqNidperfileq());
			System.out.println(gppPerfilequivalente.getPeqVperfileq());
			System.out.println(gppPerfilequivalente.getPeqVusucrea());
			System.out.println(gppPerfilequivalente.getPeqDfeccrea());
			System.out.println(gppPerfilequivalente.getPeqVusumodifica());
			System.out.println(gppPerfilequivalente.getPeqDfecmodifica());
		} else{
			System.out.println("error");
		}		
	}
	
	static void buscarTodos(){
		perfilequivalenteService = new PerfilequivalenteService();
		List<Object> gppPerfilesEquivalentes = perfilequivalenteService.buscarPerfilesEquivalentes();
		GppPerfilequivalente gppPerfilequivalente;
		if(gppPerfilesEquivalentes!=null){
			Iterator<Object> it = gppPerfilesEquivalentes.iterator();
			while(it.hasNext()){
				gppPerfilequivalente = (GppPerfilequivalente) it.next(); 
				System.out.println(gppPerfilequivalente.getPeqNidperfileq());
				System.out.println(gppPerfilequivalente.getPeqVperfileq());
				System.out.println(gppPerfilequivalente.getPeqVusucrea());
				System.out.println(gppPerfilequivalente.getPeqDfeccrea());
				System.out.println(gppPerfilequivalente.getPeqVusumodifica());
				System.out.println(gppPerfilequivalente.getPeqDfecmodifica());
			}
		}else{
			System.out.println("error");
		}		
	}
}