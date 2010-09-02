package co.com.inascol.atenea.managed.bean.delegate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;

import co.com.inascol.atenea.entity.GppPerfilequivalente;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.PerfilequivalenteService;
import co.com.inascol.atenea.logic.interfaces.IPerfilequivalenteService;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcción de Software
 * Esp. Sistemas de Información Geográfica
 * Ing. Catastral y Geodesta
 */
public class PerfilequivalenteDelegate {

	private IPerfilequivalenteService perfilequivalenteService;
	private List<Object> perfilequivalentes;
	private GppPerfilequivalente perfilequivalente;
	private GppUsuario usuarioAutenticado;
	
	public PerfilequivalenteDelegate(){}
	
	public List<Object> getListaPerfilequivalentes(){
		perfilequivalenteService = new PerfilequivalenteService();
		perfilequivalentes = perfilequivalenteService.buscarPerfilesEquivalentes();
		return perfilequivalentes;
	}
	
	public List<Object> getPerfilequivalentePorNombre(String nombrePerfilequivalente){
		perfilequivalenteService = new PerfilequivalenteService();
		perfilequivalentes = perfilequivalenteService.buscarPerfilesEquivalentes();		
		List<Object> perfilequivalentesConsultados = new ArrayList<Object>();
		CharSequence nombre = nombrePerfilequivalente.toLowerCase();
		if(perfilequivalentes.size()>0){
			if(nombrePerfilequivalente.equalsIgnoreCase("")){
				perfilequivalentesConsultados = perfilequivalentes;
			} else {
				Iterator<Object> it = perfilequivalentes.iterator();
				while(it.hasNext()){
					perfilequivalente = (GppPerfilequivalente) it.next();
					if(perfilequivalente.getPeqVperfileq().toLowerCase().contains(nombre)){
						perfilequivalentesConsultados.add(perfilequivalente);			
					}
				}
			}
		}		
		return perfilequivalentesConsultados;
	}
	
	public GppPerfilequivalente getSeleccionarPerfilequivalente(int idPerfilequivalente){
		perfilequivalenteService = new PerfilequivalenteService();
		perfilequivalentes = perfilequivalenteService.buscarPerfilesEquivalentes();
		if(perfilequivalentes.size()>0){
			Iterator<Object> it = perfilequivalentes.iterator();
			while(it.hasNext()){
				perfilequivalente = (GppPerfilequivalente) it.next();
				if(perfilequivalente.getPeqNidperfileq() == idPerfilequivalente){
					break;
				}
			}					
		}
		return perfilequivalente;
	}
	
	public Boolean getModificarPerfilequivalente(Integer idPerfilequivalente, String nombrePerfilequivalente){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		perfilequivalenteService = new PerfilequivalenteService();
		return perfilequivalenteService.actualizarPerfilEquivalente(idPerfilequivalente, nombrePerfilequivalente, usuarioAutenticado);
	}
	
	public Boolean getCrearPerfilequivalente(String nombrePerfilequivalente){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		perfilequivalenteService = new PerfilequivalenteService();
		return perfilequivalenteService.crearPerfilEquivalente(nombrePerfilequivalente, usuarioAutenticado);
	}
	
	public Boolean getEliminarPerfilequivalente(Integer idPerfilequivalente){
		perfilequivalenteService = new PerfilequivalenteService();
		return perfilequivalenteService.borrarPerfilEquivalente(idPerfilequivalente);
	}
}