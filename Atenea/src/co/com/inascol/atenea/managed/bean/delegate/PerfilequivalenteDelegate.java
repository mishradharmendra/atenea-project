package co.com.inascol.atenea.managed.bean.delegate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import co.com.inascol.atenea.entity.GppPerfilequivalente;
import co.com.inascol.atenea.logic.PerfilequivalenteService;
import co.com.inascol.atenea.logic.interfaces.IPerfilequivalenteService;

public class PerfilequivalenteDelegate {

	private IPerfilequivalenteService perfilequivalenteService;
	private List perfilequivalentes;
	private GppPerfilequivalente perfilequivalente;
	
	public PerfilequivalenteDelegate(){}
	
	public List getListaPerfilequivalentes(){
		perfilequivalenteService = new PerfilequivalenteService();
		perfilequivalentes = perfilequivalenteService.buscarPerfilesEquivalentes();
		return perfilequivalentes;
	}
	
	public List getPerfilequivalentePorNombre(String nombrePerfilequivalente){
		perfilequivalenteService = new PerfilequivalenteService();
		perfilequivalentes = perfilequivalenteService.buscarPerfilesEquivalentes();		
		List perfilequivalentesConsultados = new ArrayList();
		if(perfilequivalentes.size()>0){
			if(nombrePerfilequivalente.equalsIgnoreCase("")){
				perfilequivalentesConsultados = perfilequivalentes;
			} else {
				Iterator it = perfilequivalentes.iterator();
				while(it.hasNext()){
					perfilequivalente = (GppPerfilequivalente) it.next();
					if(perfilequivalente.getPeqVperfileq().equalsIgnoreCase(nombrePerfilequivalente)){
						perfilequivalentesConsultados.add(perfilequivalente);			
						break;
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
			Iterator it = perfilequivalentes.iterator();
			while(it.hasNext()){
				perfilequivalente = (GppPerfilequivalente) it.next();
				if(perfilequivalente.getPeqNidperfileq()== idPerfilequivalente){
					break;
				}
			}					
		}
		return perfilequivalente;
	}
	
	public boolean getModificarPerfilequivalente(int idPerfilequivalente, String nombrePerfilequivalente){
		perfilequivalenteService = new PerfilequivalenteService();
		return perfilequivalenteService.actualizarPerfilEquivalente(idPerfilequivalente, nombrePerfilequivalente);
	}
	
	public boolean getCrearPerfilequivalente(String nombrePerfilequivalente){
		perfilequivalenteService = new PerfilequivalenteService();
		return perfilequivalenteService.crearPerfilEquivalente(nombrePerfilequivalente);
	}
}