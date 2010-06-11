package co.com.inascol.atenea.managed.bean.delegate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import co.com.inascol.atenea.entity.GppParametrizacion;
import co.com.inascol.atenea.logic.ParametrizacionService;
import co.com.inascol.atenea.logic.interfaces.IParametrizacionService;

public class ParametrizacionDelegate {

	private IParametrizacionService parametrizacionService;
	private List parametrizacions;
	private GppParametrizacion parametrizacion;
	
	public ParametrizacionDelegate(){}
	
	public List getListaParametrizacions(){
		parametrizacionService = new ParametrizacionService();
		parametrizacions = parametrizacionService.buscarParametrizacion();
		return parametrizacions;
	}
	
	public List getParametrizacionPorNombre(String nombreParametrizacion){
		parametrizacionService = new ParametrizacionService();
		parametrizacions = parametrizacionService.buscarParametrizacion();		
		List parametrizacionsConsultados = new ArrayList();
		if(parametrizacions.size()>0){
			if(nombreParametrizacion.equalsIgnoreCase("")){
				parametrizacionsConsultados = parametrizacions;
			} else {
				Iterator it = parametrizacions.iterator();
				while(it.hasNext()){
					parametrizacion = (GppParametrizacion) it.next();
					if(parametrizacion.getParVnombre().equalsIgnoreCase(nombreParametrizacion)){
						parametrizacionsConsultados.add(parametrizacion);			
						break;
					}
				}
			}
		}		
		return parametrizacionsConsultados;
	}
	
	public GppParametrizacion getSeleccionarParametrizacion(int idParametrizacion){
		parametrizacionService = new ParametrizacionService();
		parametrizacions = parametrizacionService.buscarParametrizacion();
		if(parametrizacions.size()>0){
			Iterator it = parametrizacions.iterator();
			while(it.hasNext()){
				parametrizacion = (GppParametrizacion) it.next();
				if(parametrizacion.getParNidparam() == idParametrizacion){
					break;
				}
			}					
		}
		return parametrizacion;
	}
	
	public boolean getModificarParametrizacion(int idParametrizacion, String nombreParametrizacion, String valorParametrizacion, String descripcionParametrizacion){
		parametrizacionService = new ParametrizacionService();
		return parametrizacionService.actualizarParametrizacion(idParametrizacion, nombreParametrizacion, valorParametrizacion, descripcionParametrizacion);
	}
	
	public boolean getCrearParametrizacion(String nombreParametrizacion, String valorParametrizacion, String descripcionParametrizacion){
		parametrizacionService = new ParametrizacionService();
		return parametrizacionService.crearParametrizacion(nombreParametrizacion, valorParametrizacion, descripcionParametrizacion);
	}
}