package co.com.inascol.atenea.managed.bean.delegate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import co.com.inascol.atenea.entity.GppTipoarchivo;
import co.com.inascol.atenea.logic.TipoarchivoService;
import co.com.inascol.atenea.logic.interfaces.ITipoarchivoService;

public class TipoarchivoDelegate {

	private ITipoarchivoService tipoarchivoService;
	private List tipoarchivos;
	private GppTipoarchivo tipoarchivo;
	
	public TipoarchivoDelegate(){}
	
	public List getListaTipoarchivos(){
		tipoarchivoService = new TipoarchivoService();
		tipoarchivos = tipoarchivoService.buscarTipoarchivos();
		return tipoarchivos;
	}
	
	public List getTipoarchivoPorNombre(String nombreTipoarchivo){
		tipoarchivoService = new TipoarchivoService();
		tipoarchivos = tipoarchivoService.buscarTipoarchivos();		
		List tipoarchivosConsultados = new ArrayList();
		if(tipoarchivos.size()>0){
			if(nombreTipoarchivo.equalsIgnoreCase("")){
				tipoarchivosConsultados = tipoarchivos;
			} else {
				Iterator it = tipoarchivos.iterator();
				while(it.hasNext()){
					tipoarchivo = (GppTipoarchivo) it.next();
					if(tipoarchivo.getTarVtipoarchivo().equalsIgnoreCase(nombreTipoarchivo)){
						tipoarchivosConsultados.add(tipoarchivo);			
						break;
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
			Iterator it = tipoarchivos.iterator();
			while(it.hasNext()){
				tipoarchivo = (GppTipoarchivo) it.next();
				if(tipoarchivo.getTarNidtipoarchivo() == idTipoarchivo){
					break;
				}
			}					
		}
		return tipoarchivo;
	}
	
	public boolean getModificarTipoarchivo(int idTipoarchivo, String nombreTipoarchivo){
		tipoarchivoService = new TipoarchivoService();
		return tipoarchivoService.actualizarTipoarchivo(idTipoarchivo, nombreTipoarchivo);
	}
	
	public boolean getCrearTipoarchivo(String nombreTipoarchivo){
		tipoarchivoService = new TipoarchivoService();
		return tipoarchivoService.crearTipoarchivo(nombreTipoarchivo);
	}
}