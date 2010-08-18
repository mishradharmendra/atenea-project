package co.com.inascol.atenea.managed.bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;

import co.com.inascol.atenea.entity.GppRol;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.managed.bean.delegate.UsuariorolDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;
/**
 * @author Guillermo Toro
 *
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
	public List<Object> getRoles() {
		List<Object> rolesActivos = new ArrayList<Object>();
		Iterator<Object> it = roles.iterator();
		while(it.hasNext()){
			GppRol rol = (GppRol) it.next();
			if(rol.getRolBactivo()==true)
				rolesActivos.add(rol);
		}
		return rolesActivos;
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
		if(getValidarPermisosServicio("srvModificarPermisos")){
			if(idsRoles==null){
				idsRoles = new ArrayList<Object>();
			}
			if(usuario.getGppRoles()!=null){
				Iterator<Object> itRolesAsignados = usuario.getGppRoles().iterator();
				while(itRolesAsignados.hasNext()){
					Integer idRolAsignado = ( (Integer) ( (GppRol) itRolesAsignados.next() ).getRolNidrol() );
					if(idsRoles.contains(idRolAsignado)==false){
						idsRoles.add(idRolAsignado);
					}
				}
			}		
			estadoOperacion = usuariorolDelegate.getModificarPermisos(usuario, idsRoles);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("UsuariorolMB");			
				return ConstantesFaces.ESTADO_OK;
			}else{
				return ConstantesFaces.ESTADO_ERROR;
			}
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}		
	}
	
	public String getModificarBorrarUsuarioRol(){
		return ConstantesFaces.MODIFICAR_BORRAR_USUARIOROL;
	}
	
	public String getBorrarRoles(){
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvModificarPermisos")){
			List<Object> idsRolesBorrar =  new ArrayList<Object>();
			if(idsRoles==null){
				idsRoles = new ArrayList<Object>();
			}
			if(usuario.getGppRoles()!=null){
				Iterator<Object> itGppRoles = usuario.getGppRoles().iterator();
				while(itGppRoles.hasNext()){
					Integer idRolAsignado = ((Integer) ((GppRol) itGppRoles.next()).getRolNidrol());
					idsRolesBorrar.add(idRolAsignado);
				}
				Iterator<Object> idsRolesSeleccionados = idsRoles.iterator();
				while(idsRolesSeleccionados.hasNext()){
					Integer idSeleccionado = (Integer) idsRolesSeleccionados.next();
					if(idsRolesBorrar.contains(idSeleccionado)==true){
						idsRolesBorrar.remove(idSeleccionado);
					}
				}
			}
			estadoOperacion = usuariorolDelegate.getModificarPermisos(usuario, idsRolesBorrar);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("UsuariorolMB");			
				return ConstantesFaces.ESTADO_OK;
			}else{
				return ConstantesFaces.ESTADO_ERROR;
			}
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}			
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
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("UsuariorolMB");
		return ConstantesFaces.HOME_USUARIOROL;
	}
	
	public void getHomePageValue(){
		((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).setHomePage(ConstantesFaces.HOME_USUARIOROL);
	}
	
	public Boolean getValidarPermisosServicio(String nombreServicio){
		return ((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).validarPermisosServicio(nombreServicio);
	}
}