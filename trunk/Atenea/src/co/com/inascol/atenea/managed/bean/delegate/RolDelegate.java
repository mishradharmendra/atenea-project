package co.com.inascol.atenea.managed.bean.delegate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import co.com.inascol.atenea.entity.GppRol;
import co.com.inascol.atenea.logic.RolService;
import co.com.inascol.atenea.logic.interfaces.IRolService;

public class RolDelegate {

	private IRolService rolService;
	private List roles;
	private GppRol rol;
	
	public RolDelegate(){}
	
	public List getListaRols(){
		rolService = new RolService();
		roles = rolService.buscarRoles();
		return roles;
	}
	
	public List getRolPorNombre(String nombreRol){
		rolService = new RolService();
		roles = rolService.buscarRoles();		
		List rolesConsultados = new ArrayList();
		if(roles.size()>0){
			if(nombreRol.equalsIgnoreCase("")){
				rolesConsultados = roles;
			} else {
				Iterator it = roles.iterator();
				while(it.hasNext()){
					rol = (GppRol) it.next();
					if(rol.getRolVnombre().equalsIgnoreCase(nombreRol)){
						rolesConsultados.add(rol);			
						break;
					}
				}
			}
		}		
		return rolesConsultados;
	}
	
	public GppRol getSeleccionarRol(int idRol){
		rolService = new RolService();
		roles = rolService.buscarRoles();
		if(roles.size()>0){
			Iterator it = roles.iterator();
			while(it.hasNext()){
				rol = (GppRol) it.next();
				if(rol.getRolNidrol() == idRol){
					break;
				}
			}					
		}
		return rol;
	}
	
	public boolean getModificarRol(int idRol, String nombreRol, String descripcionRol, String activoRol){
		rolService = new RolService();
		return rolService.actualizarRol(idRol, nombreRol, descripcionRol, activoRol);
	}
	
	public boolean getCrearRol(String nombreRol, String descripcionRol, String activoRol, List serviciosRol){
		rolService = new RolService();
		return rolService.crearRol(nombreRol, descripcionRol, activoRol, serviciosRol);
	}
}