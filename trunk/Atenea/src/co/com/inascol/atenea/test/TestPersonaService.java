package co.com.inascol.atenea.test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import co.com.inascol.atenea.entity.GppPersona;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.PersonaService;
import co.com.inascol.atenea.logic.interfaces.IPersonaService;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class TestPersonaService {

	private static IPersonaService personaService;
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
		personaService = new PersonaService();
		for (int i = 1; i < 10; i++) {
			String nombrePersona = "Nombre "+i;
			String apellidoPersona = "Apellido " +i;
			Integer numeroIdentificacion = 1;
			String sexo = "1";
			Date fechaNacimiento = new Date();
			String libretaMilitar = "Libreta "+i;
			String celular = "310-3939391"+i;
			String email = "correo-"+i+"@hotmail.com";
			String direccion = "Carrera "+i;
			String telefono = "4567890"+i;
			Integer idMunicipio = 1;
			Integer tipoDocumento = 1;
			Integer idEstadoCivil = 1;
			Integer idPaisResidencia = 1;
			Integer idMunicipioResidencia = 1;
			Boolean usuarioActivo = true;
			estadoOperacion = personaService.crearPersona(nombrePersona, apellidoPersona, numeroIdentificacion, sexo, fechaNacimiento, libretaMilitar, celular, email, direccion, telefono, idMunicipio, tipoDocumento, idEstadoCivil, idPaisResidencia, idMunicipioResidencia, usuarioActivo, usuarioAutenticado);
			System.out.println(estadoOperacion);
		}		
	}
	
	static void actualizar(){
		estadoOperacion = false;
		personaService = new PersonaService();
		for (int i = 1; i < 10; i++) {
			Integer idPersona = i;
			String nombrePersona = "Nombre "+i+i;
			String apellidoPersona = "Apellido " +i+i;
			Integer numeroIdentificacion = 1;
			String sexo = "1";
			Date fechaNacimiento = new Date();
			String libretaMilitar = "Libreta "+i+i;
			String celular = "310-3939391"+i;
			String email = "correo-"+i+i+"@hotmail.com";
			String direccion = "Carrera "+i+i;
			String telefono = "4567890"+i+i;
			Integer idMunicipio = 1;
			Integer tipoDocumento = 1;
			Integer idEstadoCivil = 1;	
			Integer idPaisResidencia = 1;
			Integer idMunicipioResidencia = 1;
			Boolean usuarioActivo = true;
			estadoOperacion = personaService.actualizarPersona(idPersona, nombrePersona, apellidoPersona, numeroIdentificacion, sexo, fechaNacimiento, libretaMilitar, celular, email, direccion, telefono, idMunicipio, tipoDocumento, idEstadoCivil, idPaisResidencia, idMunicipioResidencia, usuarioActivo, usuarioAutenticado);
			System.out.println(estadoOperacion);
		}
	}
	
	static void borrar(){
		estadoOperacion = false;
		personaService = new PersonaService();
		Integer idPersona = 1;
		estadoOperacion = personaService.borrarPersona(idPersona);
		System.out.println(estadoOperacion);		 
	}
	
	static void buscarPorId(){
		personaService = new PersonaService();
		Integer idPersona = 2;
		GppPersona gppPersona = personaService.buscarPersonaPorId(idPersona);
		if(gppPersona!=null){
			System.out.println(gppPersona.getPerNidpersona());
			System.out.println(gppPersona.getPerVnombres());
			System.out.println(gppPersona.getPerVapellidos());
			System.out.println(gppPersona.getPerNidentificacion());
			System.out.println(gppPersona.getPerVsexo());
			System.out.println(gppPersona.getPerDfecnacimiento());
			System.out.println(gppPersona.getPerVlibretamilitar());
			System.out.println(gppPersona.getPerVmovil());
			System.out.println(gppPersona.getPerVemail());
			System.out.println(gppPersona.getPerVdireccion());
			System.out.println(gppPersona.getPerVtelefono());
			System.out.println(gppPersona.getMunNidmunicipio());
			System.out.println(gppPersona.getTdcNidtipodoc());
			System.out.println(gppPersona.getEscNidestadocivil());
			System.out.println(gppPersona.getPerVusucrea());
			System.out.println(gppPersona.getPerDfeccrea());
			System.out.println(gppPersona.getPerVusumodifica());
			System.out.println(gppPersona.getPerDfecmodifica());
		}else{
			System.out.println("error");
		}		
	}
	
	static void buscarTodos(){
		personaService = new PersonaService();		
		List<Object> gppPersonas = personaService.buscarPersonas();
		GppPersona gppPersona;
		if(gppPersonas!=null){
			Iterator<Object> it = gppPersonas.iterator();
			while(it.hasNext()){
				gppPersona = (GppPersona) it.next(); 
				System.out.println(gppPersona.getPerNidpersona());
				System.out.println(gppPersona.getPerVnombres());
				System.out.println(gppPersona.getPerVapellidos());
				System.out.println(gppPersona.getPerNidentificacion());
				System.out.println(gppPersona.getPerVsexo());
				System.out.println(gppPersona.getPerDfecnacimiento());
				System.out.println(gppPersona.getPerVlibretamilitar());
				System.out.println(gppPersona.getPerVmovil());
				System.out.println(gppPersona.getPerVemail());
				System.out.println(gppPersona.getPerVdireccion());
				System.out.println(gppPersona.getPerVtelefono());
				System.out.println(gppPersona.getMunNidmunicipio());
				System.out.println(gppPersona.getTdcNidtipodoc());
				System.out.println(gppPersona.getEscNidestadocivil());
				System.out.println(gppPersona.getPerVusucrea());
				System.out.println(gppPersona.getPerDfeccrea());
				System.out.println(gppPersona.getPerVusumodifica());
				System.out.println(gppPersona.getPerDfecmodifica());
			}
		}else{
			System.out.println("error");
		}		
	}
}