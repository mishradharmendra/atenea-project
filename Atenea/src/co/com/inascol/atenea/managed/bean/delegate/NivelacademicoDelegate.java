package co.com.inascol.atenea.managed.bean.delegate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;

import co.com.inascol.atenea.entity.GppNivelacademico;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.NivelacademicoService;
import co.com.inascol.atenea.logic.interfaces.INivelacademicoService;
/**
 * @author Guillermo Toro
 *
 */
public class NivelacademicoDelegate {

	private INivelacademicoService nivelacademicoService;
	private List<Object> nivelesacademicos;
	private GppNivelacademico nivelacademico;
	private GppUsuario usuarioAutenticado;
	
	public NivelacademicoDelegate(){}
	
	public List<Object> getListaNivelacademicos(){
		nivelacademicoService = new NivelacademicoService();
		nivelesacademicos = nivelacademicoService.buscarNivelesAcademicos();
		return nivelesacademicos;
	}
	
	public List<Object> getNivelacademicoPorNombre(String nombreNivelacademico){
		nivelacademicoService = new NivelacademicoService();
		nivelesacademicos = nivelacademicoService.buscarNivelesAcademicos();		
		List<Object> nivelesacademicosConsultados = new ArrayList<Object>();
		CharSequence nombre = nombreNivelacademico.toLowerCase();
		if(nivelesacademicos.size()>0){
			if(nombreNivelacademico.equalsIgnoreCase("")){
				nivelesacademicosConsultados = nivelesacademicos;
			} else {
				Iterator<Object> it = nivelesacademicos.iterator();
				while(it.hasNext()){
					nivelacademico = (GppNivelacademico) it.next();
					if(nivelacademico.getNacVnivelac().toLowerCase().contains(nombre)){
						nivelesacademicosConsultados.add(nivelacademico);			
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
			Iterator<Object> it = nivelesacademicos.iterator();
			while(it.hasNext()){
				nivelacademico = (GppNivelacademico) it.next();
				if(nivelacademico.getNacNidnivelac().equals(idNivelacademico)){
					break;
				}
			}					
		}
		return nivelacademico;
	}
	
	public Boolean getModificarNivelacademico(Integer idNivelacademico, String nombreNivelacademico){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		nivelacademicoService = new NivelacademicoService();
		return nivelacademicoService.actualizarNivelAcademico(idNivelacademico, nombreNivelacademico, usuarioAutenticado);
	}
	
	public Boolean getCrearNivelacademico(String nombreNivelacademico){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		nivelacademicoService = new NivelacademicoService();
		return nivelacademicoService.crearNivelAcademico(nombreNivelacademico, usuarioAutenticado);
	}	
	
	public Boolean getEliminarNivelacademico(Integer idNivelacademico){
		nivelacademicoService = new NivelacademicoService();
		return nivelacademicoService.borrarNivelAcademico(idNivelacademico);
	}
}