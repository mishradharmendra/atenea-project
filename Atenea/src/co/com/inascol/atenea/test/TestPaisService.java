package co.com.inascol.atenea.test;

import java.util.Iterator;
import java.util.List;

import co.com.inascol.atenea.entity.GppPais;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.PaisService;
import co.com.inascol.atenea.logic.interfaces.IPaisService;

public class TestPaisService {

	private static IPaisService paisService;
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
		paisService = new PaisService();
		String idPais = "10";
		String nombrePais = "Chile";
		usuarioAutenticado = new GppUsuario();
		usuarioAutenticado.setUsuVlogin("memotoro");
		estadoOperacion = paisService.crearPais(idPais, nombrePais);
		System.out.println(estadoOperacion);		
	}
	
	static void actualizar(){
		estadoOperacion = false;
		paisService = new PaisService();
		String idPais = "1";
		String nombrePais = "Estados Unidos";
		usuarioAutenticado = new GppUsuario();
		usuarioAutenticado.setUsuVlogin("memotoro");
		estadoOperacion = paisService.actualizarPais(idPais, nombrePais);
		System.out.println(estadoOperacion);
	}
	
	static void borrar(){
		estadoOperacion = false;
		paisService = new PaisService();
		String idPais = "1";
		estadoOperacion = paisService.borrarPais(idPais);
		System.out.println(estadoOperacion);		 
	}
	
	static void buscarPorId(){
		paisService = new PaisService();
		String idPais = "1";
		GppPais gppPais = paisService.buscarPorIdPais(idPais);
		if(gppPais!=null){
			System.out.println(gppPais.getPaiVidpais());
			System.out.println(gppPais.getPaiVpais());
			System.out.println(gppPais.getPaiVusucrea());
			System.out.println(gppPais.getPaiDfeccrea());
			System.out.println(gppPais.getPaiVusumodifica());
			System.out.println(gppPais.getPaiDfecmodifica());
		}else{
			System.out.println("error");
		}		
	}
	
	static void buscarTodos(){
		paisService = new PaisService();		
		List<Object> gppPaiss = paisService.buscarPaises();
		GppPais gppPais;
		if(gppPaiss!=null){
			Iterator<Object> it = gppPaiss.iterator();
			while(it.hasNext()){
				gppPais = (GppPais) it.next(); 
				System.out.println(gppPais.getPaiVidpais());
				System.out.println(gppPais.getPaiVpais());
				System.out.println(gppPais.getPaiVusucrea());
				System.out.println(gppPais.getPaiDfeccrea());
				System.out.println(gppPais.getPaiVusumodifica());
				System.out.println(gppPais.getPaiDfecmodifica());
			}
		}else{
			System.out.println("error");
		}		
	}
}