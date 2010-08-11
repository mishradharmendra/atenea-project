package co.com.inascol.atenea.managed.bean.delegate;
/**
 * @author Guillermo Toro
 *
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;

import co.com.inascol.atenea.entity.GppRol;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.RolService;
import co.com.inascol.atenea.logic.interfaces.IRolService;

public class RolDelegate {

	private IRolService rolService;
	private List<Object> roles;
	private GppRol rol;
	private GppUsuario usuarioAutenticado;
	
	public RolDelegate(){}
	
	public List<Object> getListaRols(){
		rolService = new RolService();
		roles = rolService.buscarRoles();
		return roles;
	}
	
	public List<Object> getRolPorNombre(String nombreRol){
		rolService = new RolService();
		roles = rolService.buscarRoles();		
		List<Object> rolesConsultados = new ArrayList<Object>();
		CharSequence nombre = nombreRol;
		if(roles.size()>0){
			if(nombreRol.equalsIgnoreCase("")){
				rolesConsultados = roles;
			} else {
				Iterator<Object> it = roles.iterator();
				while(it.hasNext()){
					rol = (GppRol) it.next();
					if(rol.getRolVnombre().contains(nombre)){
						rolesConsultados.add(rol);			
					}
				}
			}
		}		
		return rolesConsultados;
	}
	
	public GppRol getSeleccionarRol(Integer idRol){
		rolService = new RolService();
		rol = rolService.buscarPorIdRol(idRol);
		return rol;
	}
	
	public Boolean getModificarRol(Integer idRol, String nombreRol, String descripcionRol, Boolean activoRol, List<Object> serviciosRol){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		rolService = new RolService();
		return rolService.actualizarRol(idRol, nombreRol, descripcionRol, activoRol, serviciosRol, usuarioAutenticado);
	}
	
	public Boolean getCrearRol(String nombreRol, String descripcionRol, Boolean activoRol, List<Object> serviciosRol){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		rolService = new RolService();
		return rolService.crearRol(nombreRol, descripcionRol, activoRol, serviciosRol, usuarioAutenticado);
	}
}