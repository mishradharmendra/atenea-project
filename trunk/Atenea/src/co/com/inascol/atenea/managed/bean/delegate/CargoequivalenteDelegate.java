package co.com.inascol.atenea.managed.bean.delegate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;

import co.com.inascol.atenea.entity.GppCargoequivalente;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.CargoequivalenteService;
import co.com.inascol.atenea.logic.interfaces.ICargoequivalenteService;
/**
 * @author Guillermo Toro
 *
 */
public class CargoequivalenteDelegate {

	private ICargoequivalenteService cargoequivalenteService;
	private List<Object> cargoequivalentes;
	private GppCargoequivalente cargoequivalente;
	private GppUsuario usuarioAutenticado;
	
	public CargoequivalenteDelegate(){}
	
	public List<Object> getListaCargoequivalentes(){
		cargoequivalenteService = new CargoequivalenteService();
		cargoequivalentes = cargoequivalenteService.buscarCargosEquivalentes();
		return cargoequivalentes;
	}
	
	public List<Object> getCargoequivalentePorNombre(String nombreCargoequivalente){
		cargoequivalenteService = new CargoequivalenteService();
		cargoequivalentes = cargoequivalenteService.buscarCargosEquivalentes();		
		List<Object> cargoequivalentesConsultados = new ArrayList<Object>();
		CharSequence nombre = nombreCargoequivalente.toLowerCase();
		if(cargoequivalentes.size()>0){
			if(nombreCargoequivalente.equalsIgnoreCase("")){
				cargoequivalentesConsultados = cargoequivalentes;
			} else {
				Iterator<Object> it = cargoequivalentes.iterator();
				while(it.hasNext()){
					cargoequivalente = (GppCargoequivalente) it.next();
					if(cargoequivalente.getCeqVcargoeq().toLowerCase().contains(nombre)){
						cargoequivalentesConsultados.add(cargoequivalente);			
					}
				}
			}
		}		
		return cargoequivalentesConsultados;
	}
	
	public GppCargoequivalente getSeleccionarCargoequivalente(int idCargoequivalente){
		cargoequivalenteService = new CargoequivalenteService();
		cargoequivalentes = cargoequivalenteService.buscarCargosEquivalentes();
		if(cargoequivalentes.size()>0){
			Iterator<Object> it = cargoequivalentes.iterator();
			while(it.hasNext()){
				cargoequivalente = (GppCargoequivalente) it.next();
				if(cargoequivalente.getCeqNidcargoeq() == idCargoequivalente){
					break;
				}
			}					
		}
		return cargoequivalente;
	}
	
	public Boolean getModificarCargoequivalente(Integer idCargoequivalente, String nombreCargoequivalente){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		cargoequivalenteService = new CargoequivalenteService();		
		return cargoequivalenteService.actualizarCargoEquivalente(idCargoequivalente, nombreCargoequivalente, usuarioAutenticado);
	}
	
	public Boolean getCrearCargoequivalente(String nombreCargoequivalente){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		cargoequivalenteService = new CargoequivalenteService();
		return cargoequivalenteService.crearCargoEquivalente(nombreCargoequivalente, usuarioAutenticado);
	}
	
	public Boolean getEliminarCargoequivalente(Integer idCargoequivalente){
		cargoequivalenteService = new CargoequivalenteService();
		return cargoequivalenteService.borrarCargoEquivalente(idCargoequivalente);
	}
}