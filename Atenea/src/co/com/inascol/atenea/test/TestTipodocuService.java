package co.com.inascol.atenea.test;

import java.util.Iterator;
import java.util.List;

import co.com.inascol.atenea.entity.GppTipodoc;
import co.com.inascol.atenea.logic.TipodocService;
import co.com.inascol.atenea.logic.interfaces.ITipodocService;

public class TestTipodocuService {

	private static ITipodocService tipodocService;
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
		tipodocService = new TipodocService();
		for(int i =1; i<10;i++){
			String nombreTipoDocumento = "Documento Tipo "+i;
			estadoOperacion = tipodocService.crearTipoDocumento(nombreTipoDocumento);
			System.out.println(estadoOperacion);
		}
	}
	
	static void actualizar(){
		estadoOperacion = false;
		tipodocService = new TipodocService();
		for(int i =1; i<10;i++){
			Integer idTipoDocumento = i;
			String nombreTipoDocumento = "Documento Tipo "+i;
			estadoOperacion = tipodocService.actualizarTipoDocumento(idTipoDocumento, nombreTipoDocumento);
			System.out.println(estadoOperacion);
		}
	}
	
	static void borrar(){
		estadoOperacion = false;
		tipodocService = new TipodocService();
		Integer idTipoDocumento = 1;
		estadoOperacion = tipodocService.borrarTipoDocumento(idTipoDocumento);
		System.out.println(estadoOperacion);		 
	}
	
	static void buscarPorId(){
		tipodocService = new TipodocService();
		Integer idTipoDocumento = 1;
		GppTipodoc gppTipodoc = tipodocService.buscarTipoDocumentoPorId(idTipoDocumento);
		if(gppTipodoc!=null){
			System.out.println(gppTipodoc.getTdcNidtipodoc());
			System.out.println(gppTipodoc.getTdcVnombre());
			System.out.println(gppTipodoc.getTdcVusucrea());
			System.out.println(gppTipodoc.getTdcDfeccrea());
			System.out.println(gppTipodoc.getTdcVusumodifica());
			System.out.println(gppTipodoc.getTdcDfecmodifica());
		} else{
			System.out.println("error");
		}		
	}
	
	static void buscarTodos(){
		tipodocService = new TipodocService();
		List<Object> gppTiposDocumentos = tipodocService.buscarTiposDocumentos();
		GppTipodoc gppTipodoc;
		if(gppTiposDocumentos!=null){
			Iterator<Object> it = gppTiposDocumentos.iterator();
			while(it.hasNext()){
				gppTipodoc = (GppTipodoc) it.next(); 
				System.out.println(gppTipodoc.getTdcNidtipodoc());
				System.out.println(gppTipodoc.getTdcVnombre());
				System.out.println(gppTipodoc.getTdcVusucrea());
				System.out.println(gppTipodoc.getTdcDfeccrea());
				System.out.println(gppTipodoc.getTdcVusumodifica());
				System.out.println(gppTipodoc.getTdcDfecmodifica());
			}
		}else{
			System.out.println("error");
		}		
	}
}