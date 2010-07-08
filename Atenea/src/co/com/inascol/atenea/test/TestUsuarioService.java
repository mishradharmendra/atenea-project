package co.com.inascol.atenea.test;

import java.util.Iterator;
import java.util.List;

import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.entity.GppRol;
import co.com.inascol.atenea.entity.GppUsuariorol;
import co.com.inascol.atenea.entity.GppServiciorol;
import co.com.inascol.atenea.entity.GppServicio;
import co.com.inascol.atenea.logic.UsuarioService;
import co.com.inascol.atenea.logic.RolService;
import co.com.inascol.atenea.logic.ServicioService;
import co.com.inascol.atenea.logic.interfaces.IUsuarioService;
import co.com.inascol.atenea.logic.interfaces.IRolService;
import co.com.inascol.atenea.logic.interfaces.IServicioService;

public class TestUsuarioService {

	private static IUsuarioService usuarioService;
	private static IRolService rolService;
	private static IServicioService servicioService;
	private static Boolean estadoOperacion;
	private static GppUsuario usuarioAutenticado;
	
	public static void main(String argss[]){
//		crear();
//		actualizar();
//		borrar();
//		buscarPorId();
//		buscarTodos();
		buscarPorLogin();
	}
	
	static void crear(){
		estadoOperacion = false;
		usuarioService = new UsuarioService();
		String nombreUsuario = "Lady Garc�a";
		String loginUsuario = "lady.garcia";
		String emailUsuario = "lady.garcia@inascol.com";
		String telefonoUsuario = "3405407";
		String activoUsuario ="SI";
		estadoOperacion = usuarioService.crearUsuario(nombreUsuario, loginUsuario, emailUsuario, telefonoUsuario, activoUsuario, usuarioAutenticado);
		System.out.println(estadoOperacion);		
	}
	
	static void actualizar(){
		estadoOperacion = false;
		usuarioService = new UsuarioService();
		int idUsuario = 1;
		String nombreUsuario = "Sandra Liliana Bri�ez";
		String loginUsuario = "sandra.barajas";
		String emailUsuario = "sandra.barajas@inascol.com";
		String telefonoUsuario = "3405407";
		String activoUsuario ="NO";
		estadoOperacion = usuarioService.actualizarUsuario(idUsuario, nombreUsuario, loginUsuario, emailUsuario, telefonoUsuario, activoUsuario, usuarioAutenticado);
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
	static void buscarPorLogin(){
		usuarioService = new UsuarioService();
		rolService = new RolService();
		servicioService = new ServicioService();
		String loginUsuario = "lady.garcia";
		GppUsuario gppUsuario = usuarioService.buscarPorLogin(loginUsuario);
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
			List<Object> gppUsuarioRoles = gppUsuario.getGppRoles();
			GppUsuariorol gppUsuariorol;
			if(gppUsuarioRoles!=null){
				System.out.println("-----ROLES-----");
				Iterator<Object> it = gppUsuarioRoles.iterator();
				while(it.hasNext()){
					gppUsuariorol = (GppUsuariorol) it.next();
					System.out.println("-----USUARIOROLES-----");					
					System.out.println(gppUsuariorol.getId().getRolNidrol());
					System.out.println(gppUsuariorol.getUrlVusucrea());
					System.out.println(gppUsuariorol.getUrlDfeccrea());
					GppRol gppRol = rolService.buscarPorIdRol(gppUsuariorol.getId().getRolNidrol());
					System.out.println("-----ROLES-----");
					System.out.println(gppRol.getRolVnombre());
					System.out.println(gppRol.getRolVdescripcion());
					List<Object> gppServicios = gppRol.getRolServicios();
					GppServiciorol gppServiciorol;
					if(gppServicios!=null){
						Iterator<Object> itServicios = gppServicios.iterator();
						while(itServicios.hasNext()){
							gppServiciorol = (GppServiciorol) itServicios.next();
							System.out.println("-----SERVICIOSROL-----");
							System.out.println(gppServiciorol.getId().getSerNidservicio());
							System.out.println(gppServiciorol.getSrlVusucrea());
							System.out.println(gppServiciorol.getSrlDfeccrea());
							GppServicio gppServicio = servicioService.buscarPorIdServicio(gppServiciorol.getId().getSerNidservicio());
							System.out.println("-----SERVICIOS-----");
							System.out.println(gppServicio.getSerVnombre());
							System.out.println(gppServicio.getSerVruta());
							System.out.println(gppServicio.getSerVusucrea());
							System.out.println(gppServicio.getSerDfeccrea());							
						}					
					}
				}
			}else{
				System.out.println("error");
			}		
		}else{
			System.out.println("error");
		}		
	}
	
}