package co.com.inascol.atenea.managed.bean.delegate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;

import co.com.inascol.atenea.entity.GppTipoarchivo;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.TipoarchivoService;
import co.com.inascol.atenea.logic.interfaces.ITipoarchivoService;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcción de Software
 * Esp. Sistemas de Información Geográfica
 * Ing. Catastral y Geodesta
 */
public class TipoarchivoDelegate {

	private ITipoarchivoService tipoarchivoService;
	private List<Object> tipoarchivos;
	private GppTipoarchivo tipoarchivo;
	private GppUsuario usuarioAutenticado;
	
	public TipoarchivoDelegate(){}
	
	public List<Object> getListaTipoarchivos(){
		tipoarchivoService = new TipoarchivoService();
		tipoarchivos = tipoarchivoService.buscarTipoarchivos();
		return tipoarchivos;
	}
	
	public List<Object> getTipoarchivoPorNombre(String nombreTipoarchivo){
		tipoarchivoService = new TipoarchivoService();
		tipoarchivos = tipoarchivoService.buscarTipoarchivos();		
		List<Object> tipoarchivosConsultados = new ArrayList<Object>();
		CharSequence nombre = nombreTipoarchivo.toLowerCase();
		if(tipoarchivos.size()>0){
			if(nombreTipoarchivo.equalsIgnoreCase("")){
				tipoarchivosConsultados = tipoarchivos;
			} else {
				Iterator<Object> it = tipoarchivos.iterator();
				while(it.hasNext()){
					tipoarchivo = (GppTipoarchivo) it.next();
					if(tipoarchivo.getTarVtipoarchivo().toLowerCase().contains(nombre)){
						tipoarchivosConsultados.add(tipoarchivo);			
					}
				}
			}
		}		
		return tipoarchivosConsultados;
	}
	
	public GppTipoarchivo getSeleccionarTipoarchivo(int idTipoarchivo){
		tipoarchivoService = new TipoarchivoService();
		tipoarchivos = tipoarchivoService.buscarTipoarchivos();
		if(tipoarchivos.size()>0){
			Iterator<Object> it = tipoarchivos.iterator();
			while(it.hasNext()){
				tipoarchivo = (GppTipoarchivo) it.next();
				if(tipoarchivo.getTarNidtipoarchivo() == idTipoarchivo){
					break;
				}
			}					
		}
		return tipoarchivo;
	}
	
	public Boolean getModificarTipoarchivo(Integer idTipoarchivo, String nombreTipoarchivo){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		tipoarchivoService = new TipoarchivoService();
		return tipoarchivoService.actualizarTipoarchivo(idTipoarchivo, nombreTipoarchivo, usuarioAutenticado);
	}
	
	public Boolean getCrearTipoarchivo(String nombreTipoarchivo){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		tipoarchivoService = new TipoarchivoService();
		return tipoarchivoService.crearTipoarchivo(nombreTipoarchivo, usuarioAutenticado);
	}
	
	public Boolean getEliminarTipoarchivo(Integer idTipoarchivo){
		tipoarchivoService = new TipoarchivoService();
		return tipoarchivoService.borrarTipoarchivo(idTipoarchivo);
	}
}