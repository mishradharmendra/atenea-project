package co.com.inascol.atenea.managed.bean.delegate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import co.com.inascol.atenea.entity.GppPais;
import co.com.inascol.atenea.logic.PaisService;
import co.com.inascol.atenea.logic.interfaces.IPaisService;

public class PaisDelegate {

	private IPaisService paisService;
	private List paises;
	private GppPais pais;
	
	public PaisDelegate(){}
	
	public List getListaPaises(){
		paisService = new PaisService();
		paises = paisService.buscarPaises();
		return paises;
	}
	
	public List getPaisPorNombre(String nombrePais){
		paisService = new PaisService();
		paises = paisService.buscarPaises();		
		List paisesConsultados = new ArrayList();
		if(paises.size()>0){
			if(nombrePais.equalsIgnoreCase("")){
				paisesConsultados = paises;
			} else {
				Iterator it = paises.iterator();
				while(it.hasNext()){
					pais = (GppPais) it.next();
					if(pais.getPaiVpais().equalsIgnoreCase(nombrePais)){
						paisesConsultados.add(pais);			
						break;
					}
				}
			}
		}		
		return paisesConsultados;
	}
	
	public GppPais getSeleccionarPais(String idPais){
		paisService = new PaisService();
		paises = paisService.buscarPaises();
		if(paises.size()>0){
			Iterator it = paises.iterator();
			while(it.hasNext()){
				pais = (GppPais) it.next();
				if(pais.getPaiVidpais().equals(idPais)){
					break;
				}
			}					
		}
		return pais;
	}
	
	public boolean getModificarPais(String idPais, String nombrePais){
		paisService = new PaisService();
		return paisService.actualizarPais(idPais, nombrePais);
	}
	
	public boolean getCrearPais(String idPais, String nombrePais){
		paisService = new PaisService();
		return paisService.crearPais(idPais, nombrePais);
	}	
}