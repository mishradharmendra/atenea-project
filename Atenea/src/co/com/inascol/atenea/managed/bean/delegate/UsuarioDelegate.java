package co.com.inascol.atenea.managed.bean.delegate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;

import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.UsuarioService;
import co.com.inascol.atenea.logic.interfaces.IUsuarioService;
/**
 * @author Guillermo Toro
 *
 */
public class UsuarioDelegate {

	private IUsuarioService usuarioService;
	private List<Object> usuarios;
	private GppUsuario usuario;
	private GppUsuario usuarioAutenticado;
	
	public UsuarioDelegate(){}
	
	public List<Object> getListUsuarios(){
		usuarioService = new UsuarioService();
		return usuarioService.buscarUsuarios();
	}
	
	public List<Object> getUsuarioPorNombre(String loginUsuario, String nombreUsuario){
		usuarioService = new UsuarioService();
		usuarios = usuarioService.buscarUsuarios();
		List<Object> usuariosConsultados = new ArrayList<Object>();
		CharSequence nombre = nombreUsuario.toLowerCase();
		if(usuarios.size()>0){
			if(loginUsuario.equalsIgnoreCase("") && nombreUsuario.equalsIgnoreCase("")){
				usuariosConsultados = usuarios;
			} else {
				Iterator<Object> it = usuarios.iterator();
				while(it.hasNext()){
					usuario = (GppUsuario) it.next();
					if(loginUsuario.equalsIgnoreCase("")){
						if(usuario.getUsuVnombre().toLowerCase().contains(nombre)){
							usuariosConsultados.add(usuario);
						}
					}
					if(nombreUsuario.equalsIgnoreCase("")){
						if(usuario.getUsuVlogin().equalsIgnoreCase(loginUsuario)){
							usuariosConsultados.add(usuario);
						}						
					}
					if(!nombreUsuario.equalsIgnoreCase("") && !loginUsuario.equalsIgnoreCase("")){
						if(usuario.getUsuVlogin().equalsIgnoreCase(loginUsuario) && usuario.getUsuVnombre().toLowerCase().contains(nombre)){
							usuariosConsultados.add(usuario);
						}
					}
				}
			}
		}		
		return usuariosConsultados;
	}
	
	public GppUsuario getSeleccionarUsuario(Integer idUsuario){
		usuarioService = new UsuarioService();
		usuario = (GppUsuario) usuarioService.buscarPorIdUsuario(idUsuario);
		return usuario;
	}
	
	public Boolean getCrearUsuario(String nombreUsuario, String loginUsuario, String emailUsuario, String telefonoUsuario, Boolean estadoUsuario){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		usuarioService = new UsuarioService();
		return usuarioService.crearUsuario(nombreUsuario, loginUsuario, emailUsuario, telefonoUsuario, estadoUsuario, usuarioAutenticado);
	}
	
	public Boolean getModificarUsuario(Integer idUsuario, String nombreUsuario, String loginUsuario, String emailUsuario, String telefonoUsuario, Boolean estadoUsuario){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		usuarioService = new UsuarioService();
		return usuarioService.actualizarUsuario(idUsuario, nombreUsuario, loginUsuario, emailUsuario, telefonoUsuario, estadoUsuario, usuarioAutenticado);
	}
	
	public Boolean getEliminarUsuario(Integer idUsuario){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		usuarioService = new UsuarioService();
		return usuarioService.borrarUsuario(idUsuario);
	}
}