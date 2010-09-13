package co.com.inascol.atenea.test;

import java.util.Iterator;
import java.util.List;

import co.com.inascol.atenea.entity.GppDepartamento;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.DepartamentoService;
import co.com.inascol.atenea.logic.interfaces.IDepartamentoService;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class TestDepartamentoService {

	private static IDepartamentoService departamentoService;
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
		departamentoService = new DepartamentoService();
		String nombreDepto = "Atlantico";
		Integer idPais = 1;
		estadoOperacion = departamentoService.crearDepartamento(nombreDepto, idPais, usuarioAutenticado);
		System.out.println(estadoOperacion);		
	}
	
	static void actualizar(){
		estadoOperacion = false;
		departamentoService = new DepartamentoService();
		Integer idDepto = 1;
		String nombreDepto = "META";
		Integer idPais = 2;
		estadoOperacion = departamentoService.actualizarDepartamento(idDepto, nombreDepto, idPais, usuarioAutenticado);
		System.out.println(estadoOperacion);
	}
	
	static void borrar(){
		estadoOperacion = false;
		departamentoService = new DepartamentoService();
		Integer idDepto = 1;
		estadoOperacion = departamentoService.borrarDepartamento(idDepto);
		System.out.println(estadoOperacion);		 
	}
	
	static void buscarPorId(){
		departamentoService = new DepartamentoService();
		Integer idDepto = 1;
		GppDepartamento gppDepartamento = departamentoService.buscarPorIdDepartamento(idDepto);
		if(gppDepartamento!=null){
			System.out.println(gppDepartamento.getDptNiddepto());
			System.out.println(gppDepartamento.getDptVdepto());
			System.out.println(gppDepartamento.getPaiNidpais());
			System.out.println(gppDepartamento.getDptVusucrea());
			System.out.println(gppDepartamento.getDptDfeccrea());
			System.out.println(gppDepartamento.getDptVusumodifica());
			System.out.println(gppDepartamento.getDptDfecmodifica());
		}else{
			System.out.println("error");
		}		
	}
	
	static void buscarTodos(){
		departamentoService = new DepartamentoService();		
		List<Object> gppDepartamentos = departamentoService.buscarDepartamentos();
		GppDepartamento gppDepartamento;
		if(gppDepartamentos!=null){
			Iterator<Object> it = gppDepartamentos.iterator();
			while(it.hasNext()){
				gppDepartamento = (GppDepartamento) it.next(); 
				System.out.println(gppDepartamento.getDptNiddepto());
				System.out.println(gppDepartamento.getDptVdepto());
				System.out.println(gppDepartamento.getPaiNidpais());
				System.out.println(gppDepartamento.getDptVusucrea());
				System.out.println(gppDepartamento.getDptDfeccrea());
				System.out.println(gppDepartamento.getDptVusumodifica());
				System.out.println(gppDepartamento.getDptDfecmodifica());
			}
		}else{
			System.out.println("error");
		}		
	}
}