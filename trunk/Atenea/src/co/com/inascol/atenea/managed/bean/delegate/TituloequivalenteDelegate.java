package co.com.inascol.atenea.managed.bean.delegate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import co.com.inascol.atenea.entity.GppTituloequivalente;
import co.com.inascol.atenea.logic.TituloequivalenteService;
import co.com.inascol.atenea.logic.interfaces.ITituloequivalenteService;

public class TituloequivalenteDelegate {

	private ITituloequivalenteService tituloequivalenteService;
	private List tituloequivalentes;
	private GppTituloequivalente tituloequivalente;
	
	public TituloequivalenteDelegate(){}
	
	public List getListaTituloequivalentes(){
		tituloequivalenteService = new TituloequivalenteService();
		tituloequivalentes = tituloequivalenteService.buscarTitulosEquivalentes();
		return tituloequivalentes;
	}
	
	public List getTituloequivalentePorNombre(String nombreTituloequivalente){
		tituloequivalenteService = new TituloequivalenteService();
		tituloequivalentes = tituloequivalenteService.buscarTitulosEquivalentes();		
		List tituloequivalentesConsultados = new ArrayList();
		if(tituloequivalentes.size()>0){
			if(nombreTituloequivalente.equalsIgnoreCase("")){
				tituloequivalentesConsultados = tituloequivalentes;
			} else {
				Iterator it = tituloequivalentes.iterator();
				while(it.hasNext()){
					tituloequivalente = (GppTituloequivalente) it.next();
					if(tituloequivalente.getTeqVtituloeq().equalsIgnoreCase(nombreTituloequivalente)){
						tituloequivalentesConsultados.add(tituloequivalente);			
						break;
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
			Iterator it = tituloequivalentes.iterator();
			while(it.hasNext()){
				tituloequivalente = (GppTituloequivalente) it.next();
				if(tituloequivalente.getTeqNidtituloeq()== idTituloequivalente){
					break;
				}
			}					
		}
		return tituloequivalente;
	}
	
	public boolean getModificarTituloequivalente(int idTituloequivalente, String nombreTituloequivalente){
		tituloequivalenteService = new TituloequivalenteService();
		return tituloequivalenteService.actualizarTituloEquivalente(idTituloequivalente, nombreTituloequivalente);
	}
	
	public boolean getCrearTituloequivalente(String nombreTituloequivalente){
		tituloequivalenteService = new TituloequivalenteService();
		return tituloequivalenteService.crearTituloEquivalente(nombreTituloequivalente);
	}
}