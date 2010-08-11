package co.com.inascol.atenea.managed.bean.delegate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;

import co.com.inascol.atenea.entity.GppTituloequivalente;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.TituloequivalenteService;
import co.com.inascol.atenea.logic.interfaces.ITituloequivalenteService;
/**
 * @author Guillermo Toro
 *
 */
public class TituloequivalenteDelegate {

	private ITituloequivalenteService tituloequivalenteService;
	private List<Object> tituloequivalentes;
	private GppTituloequivalente tituloequivalente;
	private GppUsuario usuarioAutenticado;
	
	public TituloequivalenteDelegate(){}
	
	public List<Object> getListaTituloequivalentes(){
		tituloequivalenteService = new TituloequivalenteService();
		tituloequivalentes = tituloequivalenteService.buscarTitulosEquivalentes();
		return tituloequivalentes;
	}
	
	public List<Object> getTituloequivalentePorNombre(String nombreTituloequivalente){
		tituloequivalenteService = new TituloequivalenteService();
		tituloequivalentes = tituloequivalenteService.buscarTitulosEquivalentes();		
		List<Object> tituloequivalentesConsultados = new ArrayList<Object>();
		CharSequence nombre = nombreTituloequivalente.toLowerCase();
		if(tituloequivalentes.size()>0){
			if(nombreTituloequivalente.equalsIgnoreCase("")){
				tituloequivalentesConsultados = tituloequivalentes;
			} else {
				Iterator<Object> it = tituloequivalentes.iterator();
				while(it.hasNext()){
					tituloequivalente = (GppTituloequivalente) it.next();
					if(tituloequivalente.getTeqVtituloeq().toLowerCase().contains(nombre)){
						tituloequivalentesConsultados.add(tituloequivalente);			
					}
				}
			}
		}		
		return tituloequivalentesConsultados;
	}
	
	public GppTituloequivalente getSeleccionarTituloequivalente(int idTituloequivalente){
		tituloequivalenteService = new TituloequivalenteService();
		tituloequivalentes = tituloequivalenteService.buscarTitulosEquivalentes();
		if(tituloequivalentes.size()>0){
			Iterator<Object> it = tituloequivalentes.iterator();
			while(it.hasNext()){
				tituloequivalente = (GppTituloequivalente) it.next();
				if(tituloequivalente.getTeqNidtituloeq() == idTituloequivalente){
					break;
				}
			}					
		}
		return tituloequivalente;
	}
	
	public Boolean getModificarTituloequivalente(Integer idTituloequivalente, String nombreTituloequivalente){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		tituloequivalenteService = new TituloequivalenteService();
		return tituloequivalenteService.actualizarTituloEquivalente(idTituloequivalente, nombreTituloequivalente, usuarioAutenticado);
	}
	
	public Boolean getCrearTituloequivalente(String nombreTituloequivalente){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		tituloequivalenteService = new TituloequivalenteService();
		return tituloequivalenteService.crearTituloEquivalente(nombreTituloequivalente, usuarioAutenticado);
	}
	
	public Boolean getEliminarTituloequivalente(Integer idTituloequivalente){
		tituloequivalenteService = new TituloequivalenteService();
		return tituloequivalenteService.borrarTituloEquivalente(idTituloequivalente);
	}
}