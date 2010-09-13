package co.com.inascol.atenea.managed.bean.delegate;

import javax.faces.context.FacesContext;

import co.com.inascol.atenea.entity.GppParametrizacion;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.ParametrizacionService;
import co.com.inascol.atenea.logic.UsuarioService;
import co.com.inascol.atenea.logic.interfaces.IParametrizacionService;
import co.com.inascol.atenea.logic.interfaces.IUsuarioService;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class AutenticacionDelegate {
	
	private IUsuarioService usuarioService;
	private IParametrizacionService parametrizacionService;
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
	
	public String getParametro(Integer idParametro){
		parametrizacionService = new ParametrizacionService();
		GppParametrizacion parametro = (GppParametrizacion) parametrizacionService.buscarPorIdParametrizacion(idParametro);
		if(parametro!=null)
			return parametro.getParVvalor();
		else
			return null;
	}
}