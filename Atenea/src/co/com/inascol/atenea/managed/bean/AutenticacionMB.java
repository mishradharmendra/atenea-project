package co.com.inascol.atenea.managed.bean;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import co.com.inascol.atenea.managed.bean.delegate.AutenticacionDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;

public class AutenticacionMB {

	private AutenticacionDelegate autenticacionDelegate;
	private String login;
	private String password;
	private Boolean estadoOperacion;
	private String fullContextPath;
	private Boolean usuarioAutenticado;
	
	public AutenticacionMB() throws Exception{
		autenticacionDelegate = new AutenticacionDelegate();
		getContextPath();
	}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}		
	public String getFullContextPath() {
		return fullContextPath;
	}
	public void setFullContextPath(String fullContextPath) {
		this.fullContextPath = fullContextPath;
	}
	public Boolean getUsuarioAutenticado() {
		return usuarioAutenticado;
	}
	public void setUsuarioAutenticado(Boolean usuarioAutenticado) {
		this.usuarioAutenticado = usuarioAutenticado;
	}

	public String getVerificarPermisos(){
		estadoOperacion = false;
		estadoOperacion = autenticacionDelegate.getVerificarPermisos(login, password);
		if(estadoOperacion==true){
			usuarioAutenticado = true;
			return ConstantesFaces.HOME_HV;
		}else{
			return ConstantesFaces.ESTADO_AUTENTICACION_ERROR;
		}		
	}
	
	public String getIniciarAplicacion(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("usuarioAutenticado");
		return ConstantesFaces.LOGIN;
	}
	
	public void getContextPath(){
		StringBuffer requestURL;
		requestURL = ( (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest() ).getRequestURL();
		fullContextPath = ( (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest() ).getServletPath();
		fullContextPath = (requestURL.toString()).split(fullContextPath)[0];
	}
}