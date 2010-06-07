package co.com.inascol.atenea.managed.bean.delegate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import co.com.inascol.atenea.entity.GppInstitucion;
import co.com.inascol.atenea.logic.InstitucionService;
import co.com.inascol.atenea.logic.interfaces.IInstitucionService;

public class InstitucionDelegate {

	private IInstitucionService institucionService;
	private List instituciones;
	private GppInstitucion institucion;
	
	public InstitucionDelegate(){}
	
	public List getListaInstituciones(){
		institucionService = new InstitucionService();
		instituciones = institucionService.buscarInstituciones();
		return instituciones;
	}
	
	public List getInstitucionPorNombre(String nombreInstitucion){
		institucionService = new InstitucionService();
		instituciones = institucionService.buscarInstituciones();		
		List institucionesConsultados = new ArrayList();
		if(instituciones.size()>0){
			if(nombreInstitucion.equalsIgnoreCase("")){
				institucionesConsultados = instituciones;
			} else {
				Iterator it = instituciones.iterator();
				while(it.hasNext()){
					institucion = (GppInstitucion) it.next();
					if(institucion.getInsVinstitucion().equalsIgnoreCase(nombreInstitucion)){
						institucionesConsultados.add(institucion);			
						break;
					}
				}
			}
		}		
		return institucionesConsultados;
	}
	
	public GppInstitucion getSeleccionarInstitucion(int idInstitucion){
		institucionService = new InstitucionService();
		instituciones = institucionService.buscarInstituciones();
		if(instituciones.size()>0){
			Iterator it = instituciones.iterator();
			while(it.hasNext()){
				institucion = (GppInstitucion) it.next();
				if(institucion.getInsNidinstitucion().equals(idInstitucion)){
					break;
				}
			}					
		}
		return institucion;
	}
	
	public boolean getModificarInstitucion(int idInstitucion, String nombreInstitucion){
		institucionService = new InstitucionService();
		return institucionService.actualizarInstitucion(idInstitucion, nombreInstitucion);
	}
	
	public boolean getCrearInstitucion(String nombreInstitucion){
		institucionService = new InstitucionService();
		return institucionService.crearInstitucion(nombreInstitucion);
	}	
}