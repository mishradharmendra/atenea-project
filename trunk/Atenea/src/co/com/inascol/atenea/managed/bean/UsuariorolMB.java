package co.com.inascol.atenea.managed.bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

import co.com.inascol.atenea.entity.GppRol;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.managed.bean.delegate.UsuariorolDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class UsuariorolMB {

	private UsuariorolDelegate usuariorolDelegate;
	private Integer idUsuario;
	private String nombreUsuario;
	private String loginUsuario;
	private List<Object> usuarios;
	private GppUsuario usuario;
	private Boolean estadoOperacion;
	private Integer idRol;
	private List<Object> idsRoles;
	private List<Object> roles;
	
	public UsuariorolMB(){
		usuariorolDelegate = new UsuariorolDelegate();
		roles = usuariorolDelegate.getListaRoles();		
		usuarios = usuariorolDelegate.getListUsuarios();
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
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
	public Integer getIdRol() {
		return idRol;
	}
	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}
	public List<Object> getIdsRoles() {
		return idsRoles;
	}
	public void setIdsRoles(List<Object> idsRoles) {
		this.idsRoles = idsRoles;
	}
	public Boolean getEstadoOperacion() {
		return estadoOperacion;
	}
	public void setEstadoOperacion(Boolean estadoOperacion) {
		this.estadoOperacion = estadoOperacion;
	}

	public List<Object> getRoles() {
		List<Object> rolesActivos = new ArrayList<Object>();
		roles = usuariorolDelegate.getListaRoles();	
		if(roles!=null){
			Iterator<Object> itRol = roles.iterator();
			while(itRol.hasNext()){
				GppRol gppRol = (GppRol) itRol.next();
				if(gppRol.getRolBactivo()==true)
					rolesActivos.add(gppRol);
			}
			if(usuario.getGppRoles()!=null){
				Iterator<Object> itRolesAsignados = usuario.getGppRoles().iterator();
				while(itRolesAsignados.hasNext()){
					GppRol gppRolAsignado = (GppRol) itRolesAsignados.next();
					Iterator<Object> itRolesActivos = rolesActivos.iterator();
					while(itRolesActivos.hasNext()){
						GppRol gppRol = (GppRol) itRolesActivos.next();
						if(gppRolAsignado.getRolNidrol()==gppRol.getRolNidrol())
							gppRol.setRolBrolActivado(true);
					}
				}
			}
		}
		return rolesActivos;
	}
	
    public void validarEmail(FacesContext context, UIComponent validate, Object value){
        String email = (String) value;
        if(email.indexOf('@')==-1){
            ((UIInput)validate).setValid(false);
            FacesMessage msg = new FacesMessage("Ingrese una dirección de correo válida.");
            context.addMessage(validate.getClientId(context), msg);
        }
    }
    
	public void setRoles(List<Object> roles) {
		this.roles = roles;
	}

	public void getBuscarUsuarioPorNombre() {
		usuarios = usuariorolDelegate.getUsuarioPorNombre(loginUsuario, nombreUsuario);
	}
	
	public String getSeleccionarUsuarioModificar(){
		usuario = usuariorolDelegate.getSeleccionarUsuario(idUsuario);
		return ConstantesFaces.MODIFICAR_USUARIOROL;
	}
	
	public String getSeleccionarUsuarioDetalle(){
		usuario = usuariorolDelegate.getSeleccionarUsuario(idUsuario);
		return ConstantesFaces.DETALLE_USUARIOROL;		
	}
	
	public String getModificarPermisos(){
		getHomePageValue();
		estadoOperacion = false;
		List<Object> rolesAsignadosModiicados = new ArrayList<Object>();
		if(getValidarPermisosServicio("srvModificarPermisos")){
			if(idsRoles==null){
				idsRoles = new ArrayList<Object>();
			}
			if(usuario.getGppRoles()!=null){
				Iterator<Object> itRolesAsignados = usuario.getGppRoles().iterator();
				while(itRolesAsignados.hasNext()){
					Integer idRolAsignado = ( (Integer) ( (GppRol) itRolesAsignados.next() ).getRolNidrol() );
					rolesAsignadosModiicados.add(idRolAsignado);
				}		
			}	
			Iterator<Object> itIdsRoles = idsRoles.iterator();
			while(itIdsRoles.hasNext()){
				Integer idRolAsignado = (Integer) (itIdsRoles.next());
				if(rolesAsignadosModiicados.contains(idRolAsignado)==false){
					rolesAsignadosModiicados.add(idRolAsignado);
				}else{
					rolesAsignadosModiicados.remove(idRolAsignado);
				}
			}			
			estadoOperacion = usuariorolDelegate.getModificarPermisos(usuario, rolesAsignadosModiicados);
			getResultadoOperacion(estadoOperacion);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("UsuariorolMB");			
			}
			return ConstantesFaces.HOME_USUARIOROL;
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}		
	}
	
	public String getModificarBorrarUsuarioRol(){
		return ConstantesFaces.MODIFICAR_BORRAR_USUARIOROL;
	}
	
	public void getIdRolAsignar(){
		if(idsRoles==null)
			idsRoles = new ArrayList<Object>();
		if(idsRoles.contains(idRol)==false)
			idsRoles.add(idRol);
		else
			idsRoles.remove(idRol);
	}
	
	public String getCancelar(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("UsuariorolMB");
		return ConstantesFaces.HOME_USUARIOROL;
	}
	
	public String getHomeUsuariorol(){
		getMenuSeleccionado();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("UsuariorolMB");
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PersonaMB");
		return ConstantesFaces.HOME_USUARIOROL;
	}
	
	public void getHomePageValue(){
		((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).setHomePage(ConstantesFaces.HOME_USUARIOROL);
	}

	public void getMenuSeleccionado(){
		((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).setMenuSeleccionado(ConstantesFaces.MENU_ADMINISTRACION);		
	}

	public void getResultadoOperacion(Boolean resultadoOperacion){
		if(resultadoOperacion==true)
			((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).setResultadoOperacion("OK");
		else
			((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).setResultadoOperacion("ERROR");
		((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).setOperacionBD("BD");
	}

	public Boolean getValidarPermisosServicio(String nombreServicio){
		return ((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).validarPermisosServicio(nombreServicio);
	}
}