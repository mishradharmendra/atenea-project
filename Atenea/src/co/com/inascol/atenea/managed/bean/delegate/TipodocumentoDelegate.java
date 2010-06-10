package co.com.inascol.atenea.managed.bean.delegate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import co.com.inascol.atenea.entity.GppTipodoc;
import co.com.inascol.atenea.logic.TipodocService;
import co.com.inascol.atenea.logic.interfaces.ITipodocService;

public class TipodocumentoDelegate {

	private ITipodocService tipodocService;
	private List tipodocs;
	private GppTipodoc tipodoc;
	
	public TipodocumentoDelegate(){}
	
	public List getListaTipodocs(){
		tipodocService = new TipodocService();
		tipodocs = tipodocService.buscarTiposDocumentos();
		return tipodocs;
	}
	
	public List getTipodocPorNombre(String nombreTipodoc){
		tipodocService = new TipodocService();
		tipodocs = tipodocService.buscarTiposDocumentos();		
		List tipodocsConsultados = new ArrayList();
		if(tipodocs.size()>0){
			if(nombreTipodoc.equalsIgnoreCase("")){
				tipodocsConsultados = tipodocs;
			} else {
				Iterator it = tipodocs.iterator();
				while(it.hasNext()){
					tipodoc= (GppTipodoc) it.next();
					if(tipodoc.getTdcVnombre().equalsIgnoreCase(nombreTipodoc)){
						tipodocsConsultados.add(tipodoc);			
						break;
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
			Iterator it = tipodocs.iterator();
			while(it.hasNext()){
				tipodoc = (GppTipodoc) it.next();
				if(tipodoc.getTdcNidtipodoc() == idTipodoc){
					break;
				}
			}					
		}
		return tipodoc;
	}
	
	public boolean getModificarTipodocumento(int idTipodoc, String nombreTipodoc){
		tipodocService = new TipodocService();
		return tipodocService.actualizarTipoDocumento(idTipodoc, nombreTipodoc);
	}
	
	public boolean getCrearTipodocumento(String nombreTipodoc){
		tipodocService = new TipodocService();
		return tipodocService.crearTipoDocumento(nombreTipodoc);
	}
}