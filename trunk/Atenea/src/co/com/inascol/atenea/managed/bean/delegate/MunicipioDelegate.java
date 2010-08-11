package co.com.inascol.atenea.managed.bean.delegate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;

import co.com.inascol.atenea.entity.GppMunicipio;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.MunicipioService;
import co.com.inascol.atenea.logic.interfaces.IMunicipioService;
/**
 * @author Guillermo Toro
 *
 */
public class MunicipioDelegate {

	private IMunicipioService municipioService;
	private List<Object> municipios;
	private GppMunicipio municipio;
	private GppUsuario usuarioAutenticado;
	
	public MunicipioDelegate(){}
	
	public List<Object> getListaMunicipios(){
		municipioService = new MunicipioService();
		municipios = municipioService.buscarMunicipios();
		return municipios;
	}
	
	public List<Object> getMunicipioPorNombre(String nombreMunicipio){
		municipioService = new MunicipioService();
		municipios = municipioService.buscarMunicipios();		
		List<Object> municipiosConsultados = new ArrayList<Object>();
		CharSequence nombre = nombreMunicipio.toLowerCase();
		if(municipios.size()>0){
			if(nombreMunicipio.equalsIgnoreCase("")){
				municipiosConsultados = municipios;
			} else {
				Iterator<Object> it = municipios.iterator();
				while(it.hasNext()){
					municipio = (GppMunicipio) it.next();
					if(municipio.getMunVmunicipio().toLowerCase().contains(nombre)){
						municipiosConsultados.add(municipio);			
					}
				}
			}
		}		
		return municipiosConsultados;
	}
	
	public GppMunicipio getSeleccionarMunicipio(String nombreMunicipio){
		municipioService = new MunicipioService();
		municipios = municipioService.buscarMunicipios();
		if(municipios.size()>0){
			Iterator<Object> it = municipios.iterator();
			while(it.hasNext()){
				municipio = (GppMunicipio) it.next();
				if(municipio.getMunVmunicipio().equalsIgnoreCase(nombreMunicipio)){
					break;
				}
			}					
		}
		return municipio;
	}
	
	public Boolean getModificarMunicipio(Integer idMunicipio, String nombreMunicipio, Integer idDepto){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		municipioService = new MunicipioService();
		return municipioService.actualizarMunicipio(idMunicipio, nombreMunicipio, idDepto, usuarioAutenticado);
	}
	
	public Boolean getCrearMunicipio(String nombreMunicipio, Integer idDepto){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		municipioService = new MunicipioService();
		return municipioService.crearMunicipio(nombreMunicipio, idDepto, usuarioAutenticado);
	}
	
	public Boolean getEliminarMunicipio(Integer idMunicipio){
		municipioService = new MunicipioService();
		return municipioService.borrarMunicipio(idMunicipio);
	}
}