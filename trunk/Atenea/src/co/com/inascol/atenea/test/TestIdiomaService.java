package co.com.inascol.atenea.test;

import java.util.Iterator;
import java.util.List;

import co.com.inascol.atenea.entity.GppIdioma;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.IdiomaService;
import co.com.inascol.atenea.logic.interfaces.IIdiomaService;
/**
 * @author Guillermo Toro
 *
 */
public class TestIdiomaService {

	private static IIdiomaService IdiomaService;
	private static GppUsuario usuarioAutenticado;
	private static Boolean estadoOperacion;
	
	public static void main(String argss[]){
//		crear();
//		actualizar();
//		borrar();
		buscarPorId();
//		buscarTodos();		
	}
	
	static void crear(){
		estadoOperacion = false;
		IdiomaService = new IdiomaService();
		String nombreIdioma = "Frances";
		usuarioAutenticado = new GppUsuario();
		usuarioAutenticado.setUsuVlogin("memotoro");
		estadoOperacion = IdiomaService.crearIdioma(nombreIdioma, usuarioAutenticado);
		System.out.println(estadoOperacion);		
	}
	
	static void actualizar(){
		estadoOperacion = false;
		IdiomaService = new IdiomaService();
		int idIdioma = 1;
		String nombreIdioma = "Frances";
		usuarioAutenticado = new GppUsuario();
		usuarioAutenticado.setUsuVlogin("memotoro");
		estadoOperacion = IdiomaService.actualizarIdioma(idIdioma, nombreIdioma, usuarioAutenticado);
		System.out.println(estadoOperacion);
	}
	
	static void borrar(){
		estadoOperacion = false;
		IdiomaService = new IdiomaService();
		int idIdioma = 3;
		estadoOperacion = IdiomaService.borrarIdioma(idIdioma);
		System.out.println(estadoOperacion);		 
	}
	
	static void buscarPorId(){
		IdiomaService = new IdiomaService();
		int idIdioma = 3;
		GppIdioma gppIdioma = IdiomaService.buscarPorIdIdioma(idIdioma);
		if(gppIdioma!=null){
			System.out.println(gppIdioma.getIdiNididioma());
			System.out.println(gppIdioma.getIdiVidioma());
			System.out.println(gppIdioma.getIdiVusucrea());
			System.out.println(gppIdioma.getIdiDfeccrea());
			System.out.println(gppIdioma.getIdiVusumodifica());
			System.out.println(gppIdioma.getIdiDfecmodifica());
		}else{
			System.out.println("error");
		}		
	}
	
	static void buscarTodos(){
		IdiomaService = new IdiomaService();		
		List<Object> gppIdiomas = IdiomaService.buscarIdiomas();
		GppIdioma gppIdioma;
		if(gppIdiomas!=null){
			Iterator<Object> it = gppIdiomas.iterator();
			while(it.hasNext()){
				gppIdioma = (GppIdioma) it.next(); 
				System.out.println(gppIdioma.getIdiNididioma());
				System.out.println(gppIdioma.getIdiVidioma());
				System.out.println(gppIdioma.getIdiVusucrea());
				System.out.println(gppIdioma.getIdiDfeccrea());
				System.out.println(gppIdioma.getIdiVusumodifica());
				System.out.println(gppIdioma.getIdiDfecmodifica());
			}
		}else{
			System.out.println("error");
		}		
	}
}