package co.com.inascol.atenea.managed.bean.delegate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import co.com.inascol.atenea.entity.GppCargoequivalente;
import co.com.inascol.atenea.logic.CargoequivalenteService;
import co.com.inascol.atenea.logic.interfaces.ICargoequivalenteService;

public class CargoequivalenteDelegate {

	private ICargoequivalenteService cargoequivalenteService;
	private List cargoequivalentes;
	private GppCargoequivalente cargoequivalente;
	
	public CargoequivalenteDelegate(){}
	
	public List getListaCargoequivalentes(){
		cargoequivalenteService = new CargoequivalenteService();
		cargoequivalentes = cargoequivalenteService.buscarCargosEquivalentes();
		return cargoequivalentes;
	}
	
	public List getCargoequivalentePorNombre(String nombreCargoequivalente){
		cargoequivalenteService = new CargoequivalenteService();
		cargoequivalentes = cargoequivalenteService.buscarCargosEquivalentes();		
		List cargoequivalentesConsultados = new ArrayList();
		if(cargoequivalentes.size()>0){
			if(nombreCargoequivalente.equalsIgnoreCase("")){
				cargoequivalentesConsultados = cargoequivalentes;
			} else {
				Iterator it = cargoequivalentes.iterator();
				while(it.hasNext()){
					cargoequivalente = (GppCargoequivalente) it.next();
					if(cargoequivalente.getCeqVcargoeq().equalsIgnoreCase(nombreCargoequivalente)){
						cargoequivalentesConsultados.add(cargoequivalente);			
						break;
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
			Iterator it = cargoequivalentes.iterator();
			while(it.hasNext()){
				cargoequivalente = (GppCargoequivalente) it.next();
				if(cargoequivalente.getCeqNidcargoeq()== idCargoequivalente){
					break;
				}
			}					
		}
		return cargoequivalente;
	}
	
	public boolean getModificarCargoequivalente(int idCargoequivalente, String nombreCargoequivalente){
		cargoequivalenteService = new CargoequivalenteService();
		return cargoequivalenteService.actualizarCargoEquivalente(idCargoequivalente, nombreCargoequivalente);
	}
	
	public boolean getCrearCargoequivalente(String nombreCargoequivalente){
		cargoequivalenteService = new CargoequivalenteService();
		return cargoequivalenteService.crearCargoEquivalente(nombreCargoequivalente);
	}
}