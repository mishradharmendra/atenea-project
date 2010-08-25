package co.com.inascol.atenea.managed.bean.delegate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;

import co.com.inascol.atenea.entity.GppRol;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.RolService;
import co.com.inascol.atenea.logic.UsuarioService;
import co.com.inascol.atenea.logic.UsuariorolService;
import co.com.inascol.atenea.logic.interfaces.IRolService;
import co.com.inascol.atenea.logic.interfaces.IUsuarioService;
import co.com.inascol.atenea.logic.interfaces.IUsuariorolService;
/**
 * @author Guillermo Toro
 *
 */
public class UsuariorolDelegate {

	private IUsuariorolService usuariorolService;
	private IRolService rolService;
	private IUsuarioService usuarioService;
	private GppUsuario usuarioAutenticado;
	private GppUsuario usuario;
	private List<Object> usuarios;
	private Boolean estadoOperacion;
	
	public List<Object> getListaRoles(){
		rolService = new RolService();
		return rolService.buscarRoles();
	}
	
	public List<Object> getListUsuarios(){
		usuarioService = new UsuarioService();
		return usuarioService.buscarUsuarios();
	}
	
	public List<Object> getUsuarioPorNombre(String loginUsuario, String nombreUsuario){
		usuarioService = new UsuarioService();
		usuarios = usuarioService.buscarUsuarios();
		List<Object> usuariosConsultados = new ArrayList<Object>();
		CharSequence nombre = nombreUsuario.toLowerCase();
		CharSequence login = loginUsuario.toLowerCase();
		if(usuarios.size()>0){
			if(loginUsuario.equalsIgnoreCase("") && nombreUsuario.equalsIgnoreCase("")){
				usuariosConsultados = usuarios;
			} else {
				Iterator<Object> it = usuarios.iterator();
				while(it.hasNext()){
					usuario = (GppUsuario) it.next();
					if(!nombreUsuario.equalsIgnoreCase("") && !loginUsuario.equalsIgnoreCase("")){
						if(usuario.getUsuVlogin().toLowerCase().contains(login) && usuario.getUsuVnombre().toLowerCase().contains(nombre)){
							usuariosConsultados.add(usuario);
						}
					}else{
						if(loginUsuario.equalsIgnoreCase("")){
							if(usuario.getUsuVnombre().toLowerCase().contains(nombre)){
								usuariosConsultados.add(usuario);
							}
						}
						if(nombreUsuario.equalsIgnoreCase("")){
							if(usuario.getUsuVlogin().toLowerCase().contains(login)){
								usuariosConsultados.add(usuario);
							}						
						}
					}
				}
			}
		}		
		return usuariosConsultados;
	}
	
	public Boolean getModificarPermisos(GppUsuario usuario, List<Object> idRolesNuevos){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		usuarioService = new UsuarioService();
		usuariorolService = new UsuariorolService();
		Integer operacionesSatisfactorias = 0;
		if(usuario.getGppRoles()==null){
			usuario.setGppRoles(new ArrayList<Object>());
		}
		List<Object> idsRolesViejos = new ArrayList<Object>();
		Iterator<Object> itRolesViejos = usuario.getGppRoles().iterator();
		while(itRolesViejos.hasNext()){
			GppRol rol = (GppRol) itRolesViejos.next();
			idsRolesViejos.add(rol.getRolNidrol());
		}
		Iterator<Object> itIdRolesNuevos = idRolesNuevos.iterator();
		while(itIdRolesNuevos.hasNext()){
			Integer idRolNuevo = (Integer) itIdRolesNuevos.next();
			if(idsRolesViejos.contains(idRolNuevo)==false){
				estadoOperacion = usuariorolService.crearUsuariorol(usuario.getUsuNidusuario(), idRolNuevo, usuarioAutenticado);
				if(estadoOperacion==false)
					operacionesSatisfactorias++;
			}
		}	
		Iterator<Object> itIdRolesViejos = idsRolesViejos.iterator();
		while(itIdRolesViejos.hasNext()){
			Integer idRolViejo = (Integer) itIdRolesViejos.next();
			if(idRolesNuevos.contains(idRolViejo)==false){
				estadoOperacion = usuariorolService.borrarUsuariorol(usuario.getUsuNidusuario(), idRolViejo);
				if(estadoOperacion==false)
					operacionesSatisfactorias++;
			}
		}			
		if(operacionesSatisfactorias==0)
			return true;
		else
			return false;
	}
	
	public GppUsuario getSeleccionarUsuario(Integer idUsuario){
		usuarioService = new UsuarioService();
		usuario = (GppUsuario) usuarioService.buscarPorIdUsuario(idUsuario);
		return usuario;
	}
}