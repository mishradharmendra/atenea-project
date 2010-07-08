package co.com.inascol.atenea.managed.bean.delegate;

import javax.faces.context.FacesContext;

import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.UsuarioService;
import co.com.inascol.atenea.logic.interfaces.IUsuarioService;

public class AutenticacionDelegate {
	
	private IUsuarioService usuarioService;
	private GppUsuario usuario;
	
	public AutenticacionDelegate(){}
	
	public Boolean getVerificarPermisos(String login){
		usuarioService = new UsuarioService();
		usuario = usuarioService.buscarPorLogin(login);
		if(usuario!=null){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioAutenticado", usuario);
			return true;
		}else{
			return false;
		}
	}
}