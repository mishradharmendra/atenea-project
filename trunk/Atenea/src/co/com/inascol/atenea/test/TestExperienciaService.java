package co.com.inascol.atenea.test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import co.com.inascol.atenea.entity.GppExperiencia;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.ExperienciaService;
import co.com.inascol.atenea.logic.interfaces.IExperienciaService;

public class TestExperienciaService {

	private static IExperienciaService experienciaService;
	private static Boolean estadoOperacion;
	private static GppUsuario usuarioAutenticado;
	
	public static void main(String[] args){
//		crear();
//		actualizar();
//		borrar();
//		buscarPorId();
		buscarTodos();
	}
	
	static void crear(){
		estadoOperacion = false;
		experienciaService = new ExperienciaService();
		for(int i = 1; i<10 ;i++){
			String nombreEmpresa = "Empresa "+i;
			String telefonoEmpresa = "9808080-"+i;
			String nombreContacto = "Contacto "+i; 
			String emailContacto = "correo"+i;
			String nombreCargo = "Profesional "+i; 
			Date fechaIngreso = new Date(); 
			Date fechaRetiro = new Date(); 
			String herramientasSoftware = "Java "+i; 
			String funcionesLogros = "Logro "+i;
			Integer docCertificacion1 = 1; 
			Integer docCertificacion2 = 2; 
			Integer idMunicipio = 1; 
			Integer cargoEquivalente = 1;
			Integer idPersona = 1;
			estadoOperacion = experienciaService.crearExperiencia(nombreEmpresa, telefonoEmpresa, nombreContacto, emailContacto, nombreCargo, fechaIngreso, fechaRetiro, herramientasSoftware, funcionesLogros, docCertificacion1, docCertificacion2, idMunicipio, cargoEquivalente, idPersona, usuarioAutenticado);
			System.out.println(estadoOperacion);
		}
	}
	
	static void actualizar(){
		estadoOperacion = false;
		experienciaService = new ExperienciaService();
		for(int i = 1; i<10 ;i++){
			Integer idExperiencia = i;
			String nombreEmpresa = "Empresa "+i+i;
			String telefonoEmpresa = "9808080-"+i+i;
			String nombreContacto = "Contacto "+i+i; 
			String emailContacto = "correo"+i+i;
			String nombreCargo = "Profesional "+i+i; 
			Date fechaIngreso = new Date(); 
			Date fechaRetiro = new Date(); 
			String herramientasSoftware = "Java "+i+i; 
			String funcionesLogros = "Logro "+i+i;
			Integer docCertificacion1 = 1; 
			Integer docCertificacion2 = 2; 
			Integer idMunicipio = 1; 
			Integer cargoEquivalente = 1;
			Integer idPersona = 1;
			estadoOperacion = experienciaService.actualizarExperiencia(idExperiencia, nombreEmpresa, telefonoEmpresa, nombreContacto, emailContacto, nombreCargo, fechaIngreso, fechaRetiro, herramientasSoftware, funcionesLogros, docCertificacion1, docCertificacion2, idMunicipio, cargoEquivalente, idPersona, usuarioAutenticado);
			System.out.println(estadoOperacion);
		}		
	}
	
	static void borrar(){
		estadoOperacion = false;
		experienciaService = new ExperienciaService();
		Integer idExperiencia = 1;
		estadoOperacion = experienciaService.borrarExperiencia(idExperiencia);
		System.out.println(estadoOperacion);
	}
	
	static void buscarPorId(){
		Integer idExperiencia = 2;
		experienciaService = new ExperienciaService();
		GppExperiencia gppExperiencia = experienciaService.buscarExperienciaPorId(idExperiencia);
		if(gppExperiencia!=null){
			System.out.println(gppExperiencia.getExpNidexplaboral());
			System.out.println(gppExperiencia.getExpVnomempresa());
			System.out.println(gppExperiencia.getExpVtelempresa());
			System.out.println(gppExperiencia.getExpVnomcontacto());
			System.out.println(gppExperiencia.getExpVemailcontacto());
			System.out.println(gppExperiencia.getExpVcargo());
			System.out.println(gppExperiencia.getExpDfecingreso());
			System.out.println(gppExperiencia.getExpDfecretiro());
			System.out.println(gppExperiencia.getExpVherrasw());
			System.out.println(gppExperiencia.getExpVfuncionlogro());
			System.out.println(gppExperiencia.getDocNcertifica1());
			System.out.println(gppExperiencia.getDocNcertifica2());
//			DEPTO
			System.out.println(gppExperiencia.getMunVidmunicipio());
			System.out.println(gppExperiencia.getCeqNidcargoeq());
			System.out.println(gppExperiencia.getExpVusucrea());
			System.out.println(gppExperiencia.getExpDfeccrea());
			System.out.println(gppExperiencia.getExpVusumodifica());
			System.out.println(gppExperiencia.getExpDfecmodifica());
		} else {
			System.out.println("ERROR");
		}
	}
	
	static void buscarTodos(){
		experienciaService = new ExperienciaService();
		List<Object> experienciasLaborales = experienciaService.buscarExperienciasLaborales();
		if(experienciasLaborales.size()>0){
			Iterator<Object> it = experienciasLaborales.iterator();
			while(it.hasNext()){
				GppExperiencia gppExperiencia = (GppExperiencia) it.next();
				if(gppExperiencia!=null){
					System.out.println(gppExperiencia.getExpNidexplaboral());
					System.out.println(gppExperiencia.getExpVnomempresa());
					System.out.println(gppExperiencia.getExpVtelempresa());
					System.out.println(gppExperiencia.getExpVnomcontacto());
					System.out.println(gppExperiencia.getExpVemailcontacto());
					System.out.println(gppExperiencia.getExpVcargo());
					System.out.println(gppExperiencia.getExpDfecingreso());
					System.out.println(gppExperiencia.getExpDfecretiro());
					System.out.println(gppExperiencia.getExpVherrasw());
					System.out.println(gppExperiencia.getExpVfuncionlogro());
					System.out.println(gppExperiencia.getDocNcertifica1());
					System.out.println(gppExperiencia.getDocNcertifica2());
//					DEPTO
					System.out.println(gppExperiencia.getMunVidmunicipio());
					System.out.println(gppExperiencia.getCeqNidcargoeq());
					System.out.println(gppExperiencia.getExpVusucrea());
					System.out.println(gppExperiencia.getExpDfeccrea());
					System.out.println(gppExperiencia.getExpVusumodifica());
					System.out.println(gppExperiencia.getExpDfecmodifica());
				} else {
					System.out.println("ERROR");
				}						
			}			 
		}
	}	
}