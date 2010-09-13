package co.com.inascol.atenea.managed.bean.delegate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;

import co.com.inascol.atenea.entity.GppTipodoc;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.TipodocService;
import co.com.inascol.atenea.logic.interfaces.ITipodocService;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class TipodocumentoDelegate {

	private ITipodocService tipodocService;
	private List<Object> tipodocs;
	private GppTipodoc tipodoc;	
	private GppUsuario usuarioAutenticado;
	
	public TipodocumentoDelegate(){}
	
	public List<Object> getListaTipodocs(){
		tipodocService = new TipodocService();
		tipodocs = tipodocService.buscarTiposDocumentos();
		return tipodocs;
	}
	
	public List<Object> getTipodocPorNombre(String nombreTipodoc){
		tipodocService = new TipodocService();
		tipodocs = tipodocService.buscarTiposDocumentos();		
		List<Object> tipodocsConsultados = new ArrayList<Object>();
		CharSequence nombre = nombreTipodoc.toLowerCase();
		if(tipodocs.size()>0){
			if(nombreTipodoc.equalsIgnoreCase("")){
				tipodocsConsultados = tipodocs;
			} else {
				Iterator<Object> it = tipodocs.iterator();
				while(it.hasNext()){
					tipodoc= (GppTipodoc) it.next();
					if(tipodoc.getTdcVnombre().toLowerCase().contains(nombre)){
						tipodocsConsultados.add(tipodoc);			
					}
				}
			}
		}		
		return tipodocsConsultados;
	}
	
	public GppTipodoc getSeleccionarTipodocumento(int idTipodoc){
		tipodocService = new TipodocService();
		tipodocs = tipodocService.buscarTiposDocumentos();
		if(tipodocs.size()>0){
			Iterator<Object> it = tipodocs.iterator();
			while(it.hasNext()){
				tipodoc = (GppTipodoc) it.next();
				if(tipodoc.getTdcNidtipodoc() == idTipodoc){
					break;
				}
			}					
		}
		return tipodoc;
	}
	
	public Boolean getModificarTipodocumento(Integer idTipodoc, String nombreTipodoc){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		tipodocService = new TipodocService();
		return tipodocService.actualizarTipoDocumento(idTipodoc, nombreTipodoc, usuarioAutenticado);
	}
	
	public Boolean getCrearTipodocumento(String nombreTipodoc){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		tipodocService = new TipodocService();
		return tipodocService.crearTipoDocumento(nombreTipodoc, usuarioAutenticado);
	}
	
	public Boolean getEliminarTipodoc(Integer idTipodoc){
		tipodocService = new TipodocService();
		return tipodocService.borrarTipoDocumento(idTipodoc);
	}
}