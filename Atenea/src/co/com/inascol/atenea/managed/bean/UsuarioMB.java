package co.com.inascol.atenea.managed.bean;

import java.util.List;

import javax.faces.context.FacesContext;

import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.managed.bean.delegate.UsuarioDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcción de Software
 * Esp. Sistemas de Información Geográfica
 * Ing. Catastral y Geodesta
 */
public class UsuarioMB {

	private UsuarioDelegate usuarioDelegate;
	private Integer idUsuario;
	private String nombreUsuario;
	private String loginUsuario;
	private String emailUsuario;
	private String telefonoUsuario;
	private Boolean estadoUsuario;
	private Boolean estadoOperacion;
	private List<Object> usuarios;
	private GppUsuario usuario;
	
	public UsuarioMB(){
		usuarioDelegate = new UsuarioDelegate();
		usuarios = usuarioDelegate.getListUsuarios();
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getLoginUsuario() {
		return loginUsuario;
	}
	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}
	public String getEmailUsuario() {
		return emailUsuario;
	}
	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}
	public String getTelefonoUsuario() {
		return telefonoUsuario;
	}
	public void setTelefonoUsuario(String telefonoUsuario) {
		this.telefonoUsuario = telefonoUsuario;
	}
	public Boolean getEstadoUsuario() {
		return estadoUsuario;
	}
	public void setEstadoUsuario(Boolean estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public List<Object> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Object> usuarios) {
		this.usuarios = usuarios;
	}
	public GppUsuario getUsuario() {
		return usuario;
	}
	public void setUsuario(GppUsuario usuario) {
		this.usuario = usuario;
	}

	public String getAgregarUsuario() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("UsuarioMB");
		return ConstantesFaces.CREAR_USUARIO;
	}
	
	public void getBuscarUsuarioPorNombre() {
		usuarios = usuarioDelegate.getUsuarioPorNombre(loginUsuario, nombreUsuario);
	}
	
	public String getCrearUsuario() {	
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvAgregarUsuario")){
			estadoUsuario = true;
			estadoOperacion = usuarioDelegate.getCrearUsuario(nombreUsuario, loginUsuario, emailUsuario, telefonoUsuario, estadoUsuario);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("UsuarioMB");
				return ConstantesFaces.ESTADO_OK;
			}else{
				return ConstantesFaces.ESTADO_ERROR;
			}
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}				
	}
	
	public String getSeleccionarUsuarioModificar(){
		usuario = usuarioDelegate.getSeleccionarUsuario(idUsuario);
		return ConstantesFaces.MODIFICAR_USUARIO;
	}
	
	public String getSeleccionarUsuarioDetalle(){
		usuario = usuarioDelegate.getSeleccionarUsuario(idUsuario);
		return ConstantesFaces.DETALLE_USUARIO;		
	}
	
	public String getModificarUsuario(){
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvModificarUsuario")){
			estadoOperacion = usuarioDelegate.getModificarUsuario(usuario.getUsuNidusuario(), usuario.getUsuVnombre(), usuario.getUsuVlogin(), usuario.getUsuVemail(), usuario.getUsuVtelefono(), usuario.getUsuBactivo());
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("UsuarioMB");
				return ConstantesFaces.ESTADO_OK;
			}else{
				return ConstantesFaces.ESTADO_ERROR;
			}
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}				
	}
	
	public String getEliminarUsuario(){
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvEliminarUsuario")){
			estadoOperacion = usuarioDelegate.getEliminarUsuario(idUsuario);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("UsuarioMB");
				return ConstantesFaces.ESTADO_OK;
			}else{
				return ConstantesFaces.ESTADO_ERROR;
			}
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}				
	}

	public String getCambiarEstadoUsuario(){
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvModificarUsuario")){
			usuario = usuarioDelegate.getSeleccionarUsuario(idUsuario);
			if(estadoUsuario==true){
				usuario.setUsuBactivo(false);
			} else {
				usuario.setUsuBactivo(true);
			}
			estadoUsuario = null;
			estadoOperacion = usuarioDelegate.getModificarUsuario(usuario.getUsuNidusuario(), usuario.getUsuVnombre(), usuario.getUsuVlogin(), usuario.getUsuVemail(), usuario.getUsuVtelefono(), usuario.getUsuBactivo());
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("UsuarioMB");
				return ConstantesFaces.ESTADO_OK;
			} else {
				return ConstantesFaces.ESTADO_ERROR;
			}
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}			
	}
	
	public String getCancelar(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("UsuarioMB");
		return ConstantesFaces.HOME_USUARIO;
	}
	
	public String getHomeUsuario(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("UsuarioMB");
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PersonaMB");
		return ConstantesFaces.HOME_USUARIO;
	}
	
	public void getHomePageValue(){
		((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).setHomePage(ConstantesFaces.HOME_USUARIO);
	}
	
	public Boolean getValidarPermisosServicio(String nombreServicio){
		return ((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).validarPermisosServicio(nombreServicio);
	}
}