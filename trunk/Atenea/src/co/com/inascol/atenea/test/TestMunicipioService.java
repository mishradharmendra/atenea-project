package co.com.inascol.atenea.test;

import java.util.Iterator;
import java.util.List;

import co.com.inascol.atenea.entity.GppMunicipio;
import co.com.inascol.atenea.logic.MunicipioService;
import co.com.inascol.atenea.logic.interfaces.IMunicipioService;

public class TestMunicipioService {

	private static IMunicipioService municipioService;
	private static Boolean estadoOperacion;
	
	public static void main(String args[]){
//		crear();
//		actualizar();
//		borrar();
//		buscarPorId();
		buscarTodos();
	}
	
	static void crear(){
		estadoOperacion = false;
		municipioService = new MunicipioService();
		String idMunicipio = "3";
		String nombreMunicipio = "ANOLAIMA_CC";
		String idDepto = "2";
		estadoOperacion = municipioService.crearMunicipio(idMunicipio, nombreMunicipio, idDepto);
		System.out.println(estadoOperacion);
	}
	
	static void actualizar(){
		estadoOperacion = false;
		municipioService = new MunicipioService();
		String idMunicipio = "1";
		String nombreMunicipio = "BOGOTA-DC";
		String idDepto = "2";
		estadoOperacion = municipioService.actualizarMunicipio(idMunicipio, nombreMunicipio, idDepto);
		System.out.println(estadoOperacion);		
	}
	
	static void borrar(){
		estadoOperacion = false;
		municipioService = new MunicipioService();
		String idMunicipio = "3";
		estadoOperacion = municipioService.borrarMunicipio(idMunicipio);
		System.out.println(estadoOperacion);		
	}
	
	static void buscarPorId(){
		municipioService = new MunicipioService();
		String idMunicipio = "2";
		GppMunicipio gppMunicipio = municipioService.buscarPorIdMunicipio(idMunicipio);
		if(gppMunicipio!=null){
			System.out.println(gppMunicipio.getMunVidmunicipio());
			System.out.println(gppMunicipio.getMunVmunicipio());
			System.out.println(gppMunicipio.getDptViddepto());
			System.out.println(gppMunicipio.getMunVusucrea());
			System.out.println(gppMunicipio.getMunDfeccrea());
			System.out.println(gppMunicipio.getMunVusumodifica());
			System.out.println(gppMunicipio.getMunDfecmodifica());
		}else{
			System.out.println("error");
		}
	}
	
	static void buscarTodos(){
		municipioService = new MunicipioService();
		List<Object> gppMunicipios = municipioService.buscarMunicipios();		
		if(gppMunicipios!=null){
			Iterator<Object> it = gppMunicipios.iterator();
			while(it.hasNext()){
				GppMunicipio gppMunicipio = (GppMunicipio) it.next();
				System.out.println(gppMunicipio.getMunVidmunicipio());
				System.out.println(gppMunicipio.getMunVmunicipio());
				System.out.println(gppMunicipio.getDptViddepto());
				System.out.println(gppMunicipio.getMunVusucrea());
				System.out.println(gppMunicipio.getMunDfeccrea());
				System.out.println(gppMunicipio.getMunVusumodifica());
				System.out.println(gppMunicipio.getMunDfecmodifica());
			}
		}else{
			System.out.println("error");
		}		
	}
}