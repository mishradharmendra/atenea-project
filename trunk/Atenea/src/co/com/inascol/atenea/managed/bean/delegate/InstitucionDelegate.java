package co.com.inascol.atenea.managed.bean.delegate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;

import co.com.inascol.atenea.entity.GppInstitucion;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.InstitucionService;
import co.com.inascol.atenea.logic.interfaces.IInstitucionService;
/**
 * @author Guillermo Toro
 *
 */
public class InstitucionDelegate {

	private IInstitucionService institucionService;
	private List<Object> instituciones;
	private GppInstitucion institucion;
	private GppUsuario usuarioAutenticado;
	
	public InstitucionDelegate(){}
	
	public List<Object> getListaInstituciones(){
		institucionService = new InstitucionService();
		instituciones = institucionService.buscarInstituciones();
		return instituciones;
	}
	
	public List<Object> getInstitucionPorNombre(String nombreInstitucion){
		institucionService = new InstitucionService();
		instituciones = institucionService.buscarInstituciones();		
		List<Object> institucionesConsultados = new ArrayList<Object>();
		CharSequence nombre = nombreInstitucion.toLowerCase();
		if(instituciones.size()>0){
			if(nombreInstitucion.equalsIgnoreCase("")){
				institucionesConsultados = instituciones;
			} else {
				Iterator<Object> it = instituciones.iterator();
				while(it.hasNext()){
					institucion = (GppInstitucion) it.next();
					if(institucion.getInsVinstitucion().toLowerCase().contains(nombre)){
						institucionesConsultados.add(institucion);			
					}
				}
			}
		}		
		return institucionesConsultados;
	}
	
	public GppInstitucion getSeleccionarInstitucion(Integer idInstitucion){
		institucionService = new InstitucionService();
		instituciones = institucionService.buscarInstituciones();
		if(instituciones.size()>0){
			Iterator<Object> it = instituciones.iterator();
			while(it.hasNext()){
				institucion = (GppInstitucion) it.next();
				if(institucion.getInsNidinstitucion() == idInstitucion){
					break;
				}
			}					
		}
		return institucion;
	}
	
	public Boolean getModificarInstitucion(Integer idInstitucion, String nombreInstitucion){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		institucionService = new InstitucionService();
		return institucionService.actualizarInstitucion(idInstitucion, nombreInstitucion, usuarioAutenticado);
	}
	
	public Boolean getCrearInstitucion(String nombreInstitucion){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		institucionService = new InstitucionService();
		return institucionService.crearInstitucion(nombreInstitucion, usuarioAutenticado);
	}	
	
	public Boolean getEliminarInstitucion(Integer idInstitucion){
		institucionService = new InstitucionService();
		return institucionService.borrarInstitucion(idInstitucion);
	}	
}