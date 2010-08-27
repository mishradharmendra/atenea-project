package co.com.inascol.atenea.managed.bean;

import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import co.com.inascol.atenea.entity.GppRol;
import co.com.inascol.atenea.entity.GppServicio;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.managed.bean.delegate.AutenticacionDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;
/**
 * @author Guillermo Toro
 *
 */
public class AutenticacionMB {

	private AutenticacionDelegate autenticacionDelegate;
	private String login;
	private Boolean estadoOperacion;
	private String fullContextPath;
	private String servidor;
	private String puerto;
	private String aliasDocumentos;
	private String aliasReportes;
	private String urlDescargasDocumentos;
	private String urlDescargasReportes;
	private Boolean usuarioAutenticado;
	private String homePage;
	
	public AutenticacionMB() throws Exception{
		autenticacionDelegate = new AutenticacionDelegate();
		getContextPath();
		getContextPathHttpServer();
	}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
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
	public String getHomePage() {
		return homePage;
	}
	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}
	public String getUrlDescargasDocumentos() {
		return urlDescargasDocumentos;
	}
	public void setUrlDescargasDocumentos(String urlDescargasDocumentos) {
		this.urlDescargasDocumentos = urlDescargasDocumentos;
	}
	public String getUrlDescargasReportes() {
		return urlDescargasReportes;
	}
	public void setUrlDescargasReportes(String urlDescargasReportes) {
		this.urlDescargasReportes = urlDescargasReportes;
	}

	public String getVerificarPermisos(){
		estadoOperacion = false;
		estadoOperacion = autenticacionDelegate.getVerificarPermisos(login);
		if(estadoOperacion==true){
			usuarioAutenticado = true;
			return ConstantesFaces.HOME_HV;
		}else{
			return ConstantesFaces.ESTADO_AUTENTICACION_ERROR;
		}		
	}
	
	public String getIniciarAplicacion(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("usuarioAutenticado");
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("AutenticacionMB");
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PersonaMB");
		return ConstantesFaces.LOGIN;
	}
	
	public void getContextPath(){
		StringBuffer requestURL;
		requestURL = ( (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest() ).getRequestURL();
		fullContextPath = ( (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest() ).getServletPath();
		fullContextPath = (requestURL.toString()).split(fullContextPath)[0];
		
	}
	
	public void getContextPathHttpServer(){
		servidor = ( (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest() ).getServerName();
		puerto = autenticacionDelegate.getParametro(3);
		aliasDocumentos = autenticacionDelegate.getParametro(4);
		aliasReportes = autenticacionDelegate.getParametro(5);
		urlDescargasDocumentos = servidor + ":" + puerto + aliasDocumentos;
		urlDescargasReportes = servidor + ":" + puerto + aliasReportes;
	}

	public Boolean validarPermisosServicio(String nombreServicio){
		try{
			GppUsuario usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
			List<Object> roles = usuarioAutenticado.getGppRoles();
			if(roles!=null){
				if(roles.size()>0){
					Iterator<Object> itRoles = roles.iterator();
					while(itRoles.hasNext()){
						GppRol rol = (GppRol) itRoles.next();
						List<Object> servicios = rol.getGppServicios();
						if(servicios.size()>0){
							Iterator<Object> itServicios = servicios.iterator();
							while(itServicios.hasNext()){
								GppServicio servicio = (GppServicio) itServicios.next();
								if(servicio.getSerVnombre().equalsIgnoreCase(nombreServicio)){
									return true;
								}
							}
						}
					}
				}
			}
		} catch (Exception ex){
			return false;
		}
		return false;
	}
	
	public String getHomePageValue(){
		return getHomePage();
	}
}