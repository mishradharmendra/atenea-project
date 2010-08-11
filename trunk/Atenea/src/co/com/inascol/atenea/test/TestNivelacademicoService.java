package co.com.inascol.atenea.test;

import java.util.Iterator;
import java.util.List;

import co.com.inascol.atenea.entity.GppNivelacademico;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.NivelacademicoService;
import co.com.inascol.atenea.logic.interfaces.INivelacademicoService;
/**
 * @author Guillermo Toro
 *
 */
public class TestNivelacademicoService {
	
	private static INivelacademicoService nivelacademicoService;
	private static Boolean estadoOperacion;
	private static GppUsuario usuarioAutenticado;
	
	public static void main(String args[]){
//		crear();
//		actualizar();
//		borrar();
//		buscarPorId();
		buscarTodos();
	}
	
	static void crear(){
		estadoOperacion = false;
		nivelacademicoService = new NivelacademicoService();
		String nombreNivelAcademico= "MSc";
		estadoOperacion = nivelacademicoService.crearNivelAcademico(nombreNivelAcademico, usuarioAutenticado);
		System.out.println(estadoOperacion);
	}
	
	static void actualizar(){
		estadoOperacion = false;
		nivelacademicoService = new NivelacademicoService();
		Integer idNivelAcademico = 1;
		String nombreNivelAcademico= "PhD-Actualizado";
		estadoOperacion = nivelacademicoService.actualizarNivelAcademico(idNivelAcademico, nombreNivelAcademico, usuarioAutenticado);
		System.out.println(estadoOperacion);		
	}
	
	static void borrar(){
		estadoOperacion = false;
		nivelacademicoService = new NivelacademicoService();
		Integer idNivelAcademico = 1;
		estadoOperacion = nivelacademicoService.borrarNivelAcademico(idNivelAcademico);
		System.out.println(estadoOperacion);		
	}
	
	static void buscarPorId(){
		nivelacademicoService = new NivelacademicoService();
		Integer idNivelAcademico = 1;
		GppNivelacademico gppNivelacademico = nivelacademicoService.buscarPorIdNivelAcademico(idNivelAcademico);
		if(gppNivelacademico!=null){
			System.out.println(gppNivelacademico.getNacNidnivelac());
			System.out.println(gppNivelacademico.getNacVnivelac());
			System.out.println(gppNivelacademico.getNacVusucrea());
			System.out.println(gppNivelacademico.getNacDfeccrea());
			System.out.println(gppNivelacademico.getNacVusumodifica());
			System.out.println(gppNivelacademico.getNacDfecmodifica());
		}else{
			System.out.println("error");
		}
	}
	
	static void buscarTodos(){
		nivelacademicoService = new NivelacademicoService();
		List<Object> gppNivelesacademicos = nivelacademicoService.buscarNivelesAcademicos();		
		if(gppNivelesacademicos!=null){
			Iterator<Object> it = gppNivelesacademicos.iterator();
			while(it.hasNext()){
				GppNivelacademico gppNivelacademico = (GppNivelacademico) it.next();
				System.out.println(gppNivelacademico.getNacNidnivelac());
				System.out.println(gppNivelacademico.getNacVnivelac());
				System.out.println(gppNivelacademico.getNacVusucrea());
				System.out.println(gppNivelacademico.getNacDfeccrea());
				System.out.println(gppNivelacademico.getNacVusumodifica());
				System.out.println(gppNivelacademico.getNacDfecmodifica());
			}
		}else{
			System.out.println("error");
		}		
	}
}