package co.com.inascol.atenea.managed.bean.delegate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import co.com.inascol.atenea.entity.GppNivelacademico;
import co.com.inascol.atenea.logic.NivelacademicoService;
import co.com.inascol.atenea.logic.interfaces.INivelacademicoService;

public class NivelacademicoDelegate {

	private INivelacademicoService nivelacademicoService;
	private List nivelesacademicos;
	private GppNivelacademico nivelacademico;
	
	public NivelacademicoDelegate(){}
	
	public List getListaNivelacademicos(){
		nivelacademicoService = new NivelacademicoService();
		nivelesacademicos = nivelacademicoService.buscarNivelesAcademicos();
		return nivelesacademicos;
	}
	
	public List getNivelacademicoPorNombre(String nombreNivelacademico){
		nivelacademicoService = new NivelacademicoService();
		nivelesacademicos = nivelacademicoService.buscarNivelesAcademicos();		
		List nivelesacademicosConsultados = new ArrayList();
		if(nivelesacademicos.size()>0){
			if(nombreNivelacademico.equalsIgnoreCase("")){
				nivelesacademicosConsultados = nivelesacademicos;
			} else {
				Iterator it = nivelesacademicos.iterator();
				while(it.hasNext()){
					nivelacademico = (GppNivelacademico) it.next();
					if(nivelacademico.getNacVnivelac().equalsIgnoreCase(nombreNivelacademico)){
						nivelesacademicosConsultados.add(nivelacademico);			
						break;
					}
				}
			}
		}		
		return nivelesacademicosConsultados;
	}
	
	public GppNivelacademico getSeleccionarNivelacademico(int idNivelacademico){
		nivelacademicoService = new NivelacademicoService();
		nivelesacademicos = nivelacademicoService.buscarNivelesAcademicos();
		if(nivelesacademicos.size()>0){
			Iterator it = nivelesacademicos.iterator();
			while(it.hasNext()){
				nivelacademico = (GppNivelacademico) it.next();
				if(nivelacademico.getNacNidnivelac().equals(idNivelacademico)){
					break;
				}
			}					
		}
		return nivelacademico;
	}
	
	public boolean getModificarNivelacademico(int idNivelacademico, String nombreNivelacademico){
		nivelacademicoService = new NivelacademicoService();
		return nivelacademicoService.actualizarNivelAcademico(idNivelacademico, nombreNivelacademico);
	}
	
	public boolean getCrearNivelacademico(String nombreNivelacademico){
		nivelacademicoService = new NivelacademicoService();
		return nivelacademicoService.crearNivelAcademico(nombreNivelacademico);
	}	
}