package co.com.inascol.atenea.managed.bean.delegate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;

import co.com.inascol.atenea.entity.GppIdioma;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.IdiomaService;
import co.com.inascol.atenea.logic.interfaces.IIdiomaService;
/**
 * @author Guillermo Toro
 *
 */
public class IdiomaDelegate {

	private IIdiomaService idiomaService;
	private List<Object> idiomas;
	private GppIdioma idioma;
	private GppUsuario usuarioAutenticado;
	
	public IdiomaDelegate(){}
	
	public List<Object> getListaIdiomas(){
		idiomaService = new IdiomaService();
		idiomas = idiomaService.buscarIdiomas();
		return idiomas;
	}
	
	public List<Object> getIdiomaPorNombre(String nombreIdioma){
		idiomaService = new IdiomaService();
		idiomas = idiomaService.buscarIdiomas();		
		List<Object> idiomasConsultados = new ArrayList<Object>();
		CharSequence nombre = nombreIdioma.toLowerCase();
		if(idiomas.size()>0){
			if(nombreIdioma.equalsIgnoreCase("")){
				idiomasConsultados = idiomas;
			} else {
				Iterator<Object> it = idiomas.iterator();
				while(it.hasNext()){
					idioma = (GppIdioma) it.next();
					if(idioma.getIdiVidioma().toLowerCase().contains(nombre)){
						idiomasConsultados.add(idioma);			
					}
				}
			}
		}		
		return idiomasConsultados;
	}
	
	public GppIdioma getSeleccionarIdioma(int idIdioma){
		idiomaService = new IdiomaService();
		idiomas = idiomaService.buscarIdiomas();
		if(idiomas.size()>0){
			Iterator<Object> it = idiomas.iterator();
			while(it.hasNext()){
				idioma = (GppIdioma) it.next();
				if(idioma.getIdiNididioma() == idIdioma){
					break;
				}
			}					
		}
		return idioma;
	}
	
	public Boolean getModificarIdioma(Integer idIdioma, String nombreIdioma){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		idiomaService = new IdiomaService();
		return idiomaService.actualizarIdioma(idIdioma, nombreIdioma, usuarioAutenticado);
	}
	
	public Boolean getCrearIdioma(String nombreIdioma){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		idiomaService = new IdiomaService();
		return idiomaService.crearIdioma(nombreIdioma, usuarioAutenticado);
	}
	
	public Boolean getEliminarIdioma(Integer idIdioma){
		idiomaService = new IdiomaService();
		return idiomaService.borrarIdioma(idIdioma);
	}
}