package co.com.inascol.atenea.test;

import java.util.Iterator;
import java.util.List;

import co.com.inascol.atenea.entity.GppPerfilprof;
import co.com.inascol.atenea.logic.PerfilprofService;
import co.com.inascol.atenea.logic.interfaces.IPerfilprofService;

public class TestPerfilprofService {

	private static IPerfilprofService perfilprofService;
	private static Boolean estadoOperacion;
	
	public static void main(String argss[]){
//		crear();
//		actualizar();
//		borrar();
//		buscarPorId();
//		buscarTodos();		
	}
	
	static void crear(){
		estadoOperacion = false;
		perfilprofService = new PerfilprofService();
		for(int i =1; i<10;i++){
			String perfilProfesional = "Perfil Proofesional "+i;
			Integer nivelIdioma1 = 80;
			Integer nivelIdioma2 = 20;
			String herramientasSoftware = "Software " +i;
			String motoresBD = "Oracle "+i;
			Integer idPerfilEquivalente = 1;
			Integer idPersona = 1;
			Integer idIdioma1 = 1;
			Integer idIdioma2 = 2;
			estadoOperacion = perfilprofService.crearPerfilProfesional(perfilProfesional, nivelIdioma1, nivelIdioma2, herramientasSoftware, motoresBD, idPerfilEquivalente, idPersona, idIdioma1, idIdioma2);
			System.out.println(estadoOperacion);
		}
	}
	
	static void actualizar(){
		estadoOperacion = false;
		perfilprofService = new PerfilprofService();
		for(int i =1; i<10;i++){
			Integer idPerfilProfesional = i;
			String perfilProfesional = "Perfil Proofesional "+i;
			Integer nivelIdioma1 = 80;
			Integer nivelIdioma2 = 20;
			String herramientasSoftware = "Software " +i;
			String motoresBD = "Oracle "+i;
			Integer idPerfilEquivalente = 1;
			Integer idPersona = 1;
			Integer idIdioma1 = 1;
			Integer idIdioma2 = 2;
			estadoOperacion = perfilprofService.actualizarPerfilProfesional(idPerfilProfesional, perfilProfesional, nivelIdioma1, nivelIdioma2, herramientasSoftware, motoresBD, idPerfilEquivalente, idPersona, idIdioma1, idIdioma2);
			System.out.println(estadoOperacion);
		}
	}
	
	static void borrar(){
		estadoOperacion = false;
		perfilprofService = new PerfilprofService();
		Integer idPerfilProfesional = 1;
		estadoOperacion = perfilprofService.borrarPerfilProfesional(idPerfilProfesional);
		System.out.println(estadoOperacion);		 
	}
	
	static void buscarPorId(){
		perfilprofService = new PerfilprofService();
		Integer idPerfilProfesional = 1;
		GppPerfilprof gppPerfilprof = perfilprofService.buscarPerfilProfesionarlPorId(idPerfilProfesional);
		if(gppPerfilprof!=null){
			System.out.println(gppPerfilprof.getPprNidperfilprof());
			System.out.println(gppPerfilprof.getPprVperfil());
			System.out.println(gppPerfilprof.getPprNnivelidi1());
			System.out.println(gppPerfilprof.getPprNnivelidi2());
			System.out.println(gppPerfilprof.getPprVherrasw());
			System.out.println(gppPerfilprof.getPprVmotorbd());
			System.out.println(gppPerfilprof.getPeqNidperfileq());
			System.out.println(gppPerfilprof.getPerNidpersona());			
			System.out.println(gppPerfilprof.getIdiNididioma1());
			System.out.println(gppPerfilprof.getIdiNididioma2());
		} else{
			System.out.println("error");
		}		
	}
	
	static void buscarTodos(){
		perfilprofService = new PerfilprofService();
		List<Object> gppPerfilesProfesionales = perfilprofService.buscarPerfilesProfesionales();
		GppPerfilprof gppPerfilprof;
		if(gppPerfilesProfesionales!=null){
			Iterator<Object> it = gppPerfilesProfesionales .iterator();
			while(it.hasNext()){
				gppPerfilprof = (GppPerfilprof) it.next(); 
				System.out.println(gppPerfilprof.getPprNidperfilprof());
				System.out.println(gppPerfilprof.getPprVperfil());
				System.out.println(gppPerfilprof.getPprNnivelidi1());
				System.out.println(gppPerfilprof.getPprNnivelidi2());
				System.out.println(gppPerfilprof.getPprVherrasw());
				System.out.println(gppPerfilprof.getPprVmotorbd());
				System.out.println(gppPerfilprof.getPeqNidperfileq());
				System.out.println(gppPerfilprof.getPerNidpersona());			
				System.out.println(gppPerfilprof.getIdiNididioma1());
				System.out.println(gppPerfilprof.getIdiNididioma2());
			}
		}else{
			System.out.println("error");
		}		
	}
}