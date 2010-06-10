package co.com.inascol.atenea.managed.bean.delegate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import co.com.inascol.atenea.entity.GppEstadocivil;
import co.com.inascol.atenea.logic.EstadocivilService;
import co.com.inascol.atenea.logic.interfaces.IEstadocivilService;

public class EstadocivilDelegate {

	private IEstadocivilService estadocivilService;
	private List estadociviles;
	private GppEstadocivil estadocivil;
	
	public EstadocivilDelegate(){}
	
	public List getListaEstadocivils(){
		estadocivilService = new EstadocivilService();
		estadociviles = estadocivilService.buscarEstadosCiviles();
		return estadociviles;
	}
	
	public List getEstadocivilPorNombre(String nombreEstadocivil){
		estadocivilService = new EstadocivilService();
		estadociviles = estadocivilService.buscarEstadosCiviles();		
		List estadocivilsConsultados = new ArrayList();
		if(estadociviles.size()>0){
			if(nombreEstadocivil.equalsIgnoreCase("")){
				estadocivilsConsultados = estadociviles;
			} else {
				Iterator it = estadociviles.iterator();
				while(it.hasNext()){
					estadocivil = (GppEstadocivil) it.next();
					if(estadocivil.getEscVestadocivil().equalsIgnoreCase(nombreEstadocivil)){
						estadocivilsConsultados.add(estadocivil);			
						break;
					}
				}
			}
		}		
		return estadocivilsConsultados;
	}
	
	public GppEstadocivil getSeleccionarEstadocivil(int idEstadocivil){
		estadocivilService = new EstadocivilService();
		estadociviles = estadocivilService.buscarEstadosCiviles();
		if(estadociviles.size()>0){
			Iterator it = estadociviles.iterator();
			while(it.hasNext()){
				estadocivil = (GppEstadocivil) it.next();
				if(estadocivil.getEscNidestadocivil() == idEstadocivil){
					break;
				}
			}					
		}
		return estadocivil;
	}
	
	public boolean getModificarEstadocivil(int idEstadocivil, String nombreEstadocivil){
		estadocivilService = new EstadocivilService();
		return estadocivilService.actualizarEstadoCivil(idEstadocivil, nombreEstadocivil);
	}
	
	public boolean getCrearEstadocivil(String nombreEstadocivil){
		estadocivilService = new EstadocivilService();
		return estadocivilService.crearEstadoCivil(nombreEstadocivil);
	}
}