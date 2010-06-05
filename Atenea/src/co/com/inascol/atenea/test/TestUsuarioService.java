package co.com.inascol.atenea.test;

import java.util.Iterator;
import java.util.List;

import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.UsuarioService;
import co.com.inascol.atenea.logic.interfaces.IUsuarioService;

public class TestUsuarioService {

	private static IUsuarioService usuarioService;
	private static Boolean estadoOperacion;
	
	public static void main(String argss[]){
//		crear();
//		actualizar();
		borrar();
//		buscarPorId();
//		buscarTodos();		
	}
	
	static void crear(){
		estadoOperacion = false;
		usuarioService = new UsuarioService();
		String nombreUsuario = "Lady García";
		String loginUsuario = "lady.garcia";
		String emailUsuario = "lady.garcia@inascol.com";
		String telefonoUsuario = "3405407";
		String activoUsuario ="SI";
		estadoOperacion = usuarioService.crearUsuario(nombreUsuario, loginUsuario, emailUsuario, telefonoUsuario, activoUsuario);
		System.out.println(estadoOperacion);		
	}
	
	static void actualizar(){
		estadoOperacion = false;
		usuarioService = new UsuarioService();
		int idUsuario = 1;
		String nombreUsuario = "Sandra Liliana Briñez";
		String loginUsuario = "sandra.barajas";
		String emailUsuario = "sandra.barajas@inascol.com";
		String telefonoUsuario = "3405407";
		String activoUsuario ="NO";
		estadoOperacion = usuarioService.actualizarUsuario(idUsuario, nombreUsuario, loginUsuario, emailUsuario, telefonoUsuario, activoUsuario);
		System.out.println(estadoOperacion);
	}
	
	static void borrar(){
		estadoOperacion = false;
		usuarioService = new UsuarioService();
		int idUsuario = 1;
		estadoOperacion = usuarioService.borrarUsuario(idUsuario);
		System.out.println(estadoOperacion);		 
	}
	
	static void buscarPorId(){
		usuarioService = new UsuarioService();
		int idUsuario = 1;
		GppUsuario gppUsuario = usuarioService.buscarPorIdUsuario(idUsuario);
		if(gppUsuario!=null){
			System.out.println(gppUsuario.getUsuNidusuario());
			System.out.println(gppUsuario.getUsuVnombre());
			System.out.println(gppUsuario.getUsuVlogin());
			System.out.println(gppUsuario.getUsuVtelefono());
			System.out.println(gppUsuario.getUsuVemail());			
			System.out.println(gppUsuario.getUsuVusucrea());
			System.out.println(gppUsuario.getUsuDfeccrea());
			System.out.println(gppUsuario.getUsuVusumodifica());
			System.out.println(gppUsuario.getUsuDfecmodifica());
			System.out.println(gppUsuario.getUsuVactivo());
			
		}else{
			System.out.println("error");
		}		
	}
	
	static void buscarTodos(){
		usuarioService = new UsuarioService();		
		List<Object> gppUsuarios = usuarioService.buscarUsuarios();
		GppUsuario gppUsuario;
		if(gppUsuarios!=null){
			Iterator<Object> it = gppUsuarios.iterator();
			while(it.hasNext()){
				gppUsuario = (GppUsuario) it.next(); 
				System.out.println(gppUsuario.getUsuNidusuario());
				System.out.println(gppUsuario.getUsuVnombre());
				System.out.println(gppUsuario.getUsuVlogin());
				System.out.println(gppUsuario.getUsuVtelefono());
				System.out.println(gppUsuario.getUsuVemail());			
				System.out.println(gppUsuario.getUsuVusucrea());
				System.out.println(gppUsuario.getUsuDfeccrea());
				System.out.println(gppUsuario.getUsuVusumodifica());
				System.out.println(gppUsuario.getUsuDfecmodifica());
				System.out.println(gppUsuario.getUsuVactivo());
			}
		}else{
			System.out.println("error");
		}		
	}
}