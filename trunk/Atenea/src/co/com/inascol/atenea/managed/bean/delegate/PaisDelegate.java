package co.com.inascol.atenea.managed.bean.delegate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;

import co.com.inascol.atenea.entity.GppPais;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.PaisService;
import co.com.inascol.atenea.logic.interfaces.IPaisService;

public class PaisDelegate {

	private IPaisService paisService;
	private List<Object> paises;
	private GppPais pais;
	private GppUsuario usuarioAutenticado;
	
	public PaisDelegate(){}
	
	public List<Object> getListaPaises(){
		paisService = new PaisService();
		paises = paisService.buscarPaises();
		return paises;
	}
	
	public List<Object> getPaisPorNombre(String nombrePais){
		paisService = new PaisService();
		paises = paisService.buscarPaises();		
		List<Object> paisesConsultados = new ArrayList<Object>();
		CharSequence nombre = nombrePais.toLowerCase();
		if(paises.size()>0){
			if(nombrePais.equalsIgnoreCase("")){
				paisesConsultados = paises;
			} else {
				Iterator<Object> it = paises.iterator();
				while(it.hasNext()){
					pais = (GppPais) it.next();
					if(pais.getPaiVpais().toLowerCase().contains(nombre)){
						paisesConsultados.add(pais);			
					}
				}
			}
		}		
		return paisesConsultados;
	}
	
	public GppPais getSeleccionarPais(Integer idPais){
		paisService = new PaisService();
		paises = paisService.buscarPaises();
		if(paises.size()>0){
			Iterator<Object> it = paises.iterator();
			while(it.hasNext()){
				pais = (GppPais) it.next();
				if(pais.getPaiNidpais()==idPais){
					break;
				}
			}					
		}
		return pais;
	}
	
	public Boolean getModificarPais(Integer idPais, String nombrePais){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		paisService = new PaisService();
		return paisService.actualizarPais(idPais, nombrePais, usuarioAutenticado);
	}
	
	public Boolean getCrearPais(String nombrePais){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		paisService = new PaisService();
		return paisService.crearPais(nombrePais, usuarioAutenticado);
	}

	public Boolean getEliminarPais(Integer idPais){
		paisService = new PaisService();
		return paisService.borrarPais(idPais);
	}	
}