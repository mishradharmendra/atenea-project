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
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class AutenticacionMB {

	private AutenticacionDelegate autenticacionDelegate;
	private String login;
	private Boolean estadoOperacion;
	private String resultadoOperacion;
	private String operacionBD;
	private String fullContextPath;
	private String servidor;
	private String puerto;
	private String aliasDocumentos;
	private String aliasReportes;
	private String urlDescargasDocumentos;
	private String urlDescargasReportes;
	private Boolean usuarioAutenticado;
	private String homePage;
	private String menuSeleccionado;
	
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
	public String getMenuSeleccionado() {
		return menuSeleccionado;
	}
	public void setMenuSeleccionado(String menuSeleccionado) {
		this.menuSeleccionado = menuSeleccionado;
	}
	public String getResultadoOperacion() {
		return resultadoOperacion;
	}
	public void setResultadoOperacion(String resultadoOperacion) {
		this.resultadoOperacion = resultadoOperacion;
	}
	public String getOperacionBD() {
		return operacionBD;
	}
	public void setOperacionBD(String operacionBD) {
		this.operacionBD = operacionBD;
	}
	public String getServidor() {
		return servidor;
	}
	public void setServidor(String servidor) {
		this.servidor = servidor;
	}
	public String getPuerto() {
		return puerto;
	}
	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}
	public String getAliasDocumentos() {
		return aliasDocumentos;
	}
	public void setAliasDocumentos(String aliasDocumentos) {
		this.aliasDocumentos = aliasDocumentos;
	}
	public String getAliasReportes() {
		return aliasReportes;
	}
	public void setAliasReportes(String aliasReportes) {
		this.aliasReportes = aliasReportes;
	}
	public Boolean getEstadoOperacion() {
		return estadoOperacion;
	}
	public void setEstadoOperacion(Boolean estadoOperacion) {
		this.estadoOperacion = estadoOperacion;
	}

	public void getLimpiarOperacion(){
		resultadoOperacion = "NINGUNO";
		operacionBD = "NINGUNA";
	}
	
	public String getVerificarPermisos(){
		estadoOperacion = false;
		estadoOperacion = autenticacionDelegate.getVerificarPermisos(login);
		if(estadoOperacion==true){
			usuarioAutenticado = true;
			menuSeleccionado = ConstantesFaces.MENU_HOJA_VIDA;
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

	public String getHomePageValue(){
		return getHomePage();
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
						if(rol.getRolBactivo()==true){
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
			}
		} catch (Exception ex){
			return false;
		}
		return false;
	}
}