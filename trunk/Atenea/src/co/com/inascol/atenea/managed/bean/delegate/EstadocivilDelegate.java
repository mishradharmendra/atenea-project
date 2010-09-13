package co.com.inascol.atenea.managed.bean.delegate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;

import co.com.inascol.atenea.entity.GppEstadocivil;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.EstadocivilService;
import co.com.inascol.atenea.logic.interfaces.IEstadocivilService;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class EstadocivilDelegate {

	private IEstadocivilService estadocivilService;
	private List<Object> estadociviles;
	private GppEstadocivil estadocivil;
	private GppUsuario usuarioAutenticado;
	
	public EstadocivilDelegate(){}
	
	public List<Object> getListaEstadocivils(){
		estadocivilService = new EstadocivilService();
		estadociviles = estadocivilService.buscarEstadosCiviles();
		return estadociviles;
	}
	
	public List<Object> getEstadocivilPorNombre(String nombreEstadocivil){
		estadocivilService = new EstadocivilService();
		estadociviles = estadocivilService.buscarEstadosCiviles();		
		List<Object> estadocivilsConsultados = new ArrayList<Object>();
		CharSequence nombre = nombreEstadocivil.toLowerCase();
		if(estadociviles.size()>0){
			if(nombreEstadocivil.equalsIgnoreCase("")){
				estadocivilsConsultados = estadociviles;
			} else {
				Iterator<Object> it = estadociviles.iterator();
				while(it.hasNext()){
					estadocivil = (GppEstadocivil) it.next();
					if(estadocivil.getEscVestadocivil().toLowerCase().contains(nombre)){
						estadocivilsConsultados.add(estadocivil);			
					}
				}
			}
		}		
		return estadocivilsConsultados;
	}
	
	public GppEstadocivil getSeleccionarEstadocivil(Integer idEstadocivil){
		estadocivilService = new EstadocivilService();
		estadociviles = estadocivilService.buscarEstadosCiviles();
		if(estadociviles.size()>0){
			Iterator<Object> it = estadociviles.iterator();
			while(it.hasNext()){
				estadocivil = (GppEstadocivil) it.next();
				if(estadocivil.getEscNidestadocivil() == idEstadocivil){
					break;
				}
			}					
		}
		return estadocivil;
	}
	
	public Boolean getModificarEstadocivil(Integer idEstadocivil, String nombreEstadocivil){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		estadocivilService = new EstadocivilService();
		return estadocivilService.actualizarEstadoCivil(idEstadocivil, nombreEstadocivil, usuarioAutenticado);
	}
	
	public Boolean getCrearEstadocivil(String nombreEstadocivil){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		estadocivilService = new EstadocivilService();
		return estadocivilService.crearEstadoCivil(nombreEstadocivil, usuarioAutenticado);
	}
	
	public Boolean getEliminarEstadocivil(Integer idEstadocivil){
		estadocivilService = new EstadocivilService();
		return estadocivilService.borrarEstadoCivil(idEstadocivil);
	}	
}