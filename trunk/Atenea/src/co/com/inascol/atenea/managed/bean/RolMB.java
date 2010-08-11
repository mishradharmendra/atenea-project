package co.com.inascol.atenea.managed.bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;

import co.com.inascol.atenea.entity.GppRol;
import co.com.inascol.atenea.entity.GppServicio;
import co.com.inascol.atenea.managed.bean.delegate.RolDelegate;
import co.com.inascol.atenea.managed.bean.delegate.ServicioDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;
/**
 * @author Guillermo Toro
 *
 */
public class RolMB {

	private RolDelegate rolDelegate;
	private ServicioDelegate servicioDelegate;
	private Integer idRol;
	private Integer idServicio;
	private String nombreRol;
	private String estadoRol;
	private Boolean activoRol;
	private String descripcionRol;
	private String controlNavegacion;
	private List<Object> roles;
	private List<Object> serviciosRoles;
	private Boolean estadoCheck;
	private GppRol rol;
	private GppServicio servicio;
	private Boolean estadoOperacion;
	
	public RolMB(){
		rolDelegate = new RolDelegate();
		roles = rolDelegate.getListaRols();
	}
	
	public String getNombreRol() {
		return nombreRol;
	}
	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}
	
	public String getDescripcionRol() {
		return descripcionRol;
	}
	public void setDescripcionRol(String descripcionRol) {
		this.descripcionRol = descripcionRol;
	}	
	public Boolean getActivoRol() {
		return activoRol;
	}
	public void setActivoRol(Boolean activoRol) {
		this.activoRol = activoRol;
	}
	public String getEstadoRol() {
		return estadoRol;
	}
	public void setEstadoRol(String estadoRol) {
		this.estadoRol = estadoRol;
	}
	public GppRol getRol() {
		return rol;
	}
	public void setRol(GppRol rol) {
		this.rol = rol;
	}
	public List<Object> getRoles() {
		return roles;
	}
	public void setRoles(List<Object> roles) {
		this.roles = roles;
	}
	public List<Object> getServiciosRoles() {
		return serviciosRoles;
	}
	public void setServiciosRoles(List<Object> serviciosRoles) {
		this.serviciosRoles = serviciosRoles;
	}	
	public Integer getIdRol() {
		return idRol;
	}
	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}
	public String getControlNavegacion() {
		return controlNavegacion;
	}
	public void setControlNavegacion(String controlNavegacion) {
		this.controlNavegacion = controlNavegacion;
	}
	public Integer getIdServicio() {
		return idServicio;
	}
	public void setIdServicio(Integer idServicio) {
		this.idServicio = idServicio;
	}
	public GppServicio getServicio() {
		return servicio;
	}
	public void setServicio(GppServicio servicio) {
		this.servicio = servicio;
	}
	public Boolean getEstadoCheck() {
		return estadoCheck;
	}
	public void setEstadoCheck(Boolean estadoCheck) {
		this.estadoCheck = estadoCheck;
	}

	public void getBuscarRolPorNombre() {
		roles = rolDelegate.getRolPorNombre(nombreRol);
	}
	
	public String getAgregarRol() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("RolMB");
		return ConstantesFaces.CREAR_ROL;
	}
	
	public String getCrearRol() {	
		getHomePageValue();
		activoRol = true;	
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvAgregarRol")){
			estadoOperacion = rolDelegate.getCrearRol(nombreRol, descripcionRol, activoRol, serviciosRoles);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("RolMB");
				return ConstantesFaces.ESTADO_OK;
			}else{
				return ConstantesFaces.ESTADO_ERROR;
			}
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}				
	}
	
	public String getSeleccionarRolModificar(){
		rol = rolDelegate.getSeleccionarRol(idRol);
		return ConstantesFaces.MODIFICAR_ROL;
	}
	
	public String getSeleccionarRolDetalle(){
		rol = rolDelegate.getSeleccionarRol(idRol);
		return ConstantesFaces.DETALLE_ROL;
	}
	
	public String getModificarBorrarRol() {
		return ConstantesFaces.MODIFICAR_BORRAR_ROL;
	}
	
	public String getModificarRol(){
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvModificarRol")){
			if(serviciosRoles==null){
				serviciosRoles = new ArrayList<Object>();
			}
			if(rol.getGppServicios()!=null){
				Iterator<Object> itServiciosAsignados = rol.getGppServicios().iterator();
				while(itServiciosAsignados.hasNext()){
					Integer idServicioAsignado = ( (Integer) ( (GppServicio) itServiciosAsignados.next() ).getSerNidservicio() );
					if(serviciosRoles.contains(idServicioAsignado)==false){
						serviciosRoles.add(idServicioAsignado);
					}
				}
			}
			rol.setServicios(serviciosRoles);
			estadoOperacion = rolDelegate.getModificarRol(rol.getRolNidrol(), rol.getRolVnombre(), rol.getRolVdescripcion(), rol.getRolBactivo(), rol.getServicios());
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("RolMB");
				return ConstantesFaces.ESTADO_OK;
			}else{
				return ConstantesFaces.ESTADO_ERROR;
			}
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}				
	}
	
	public String getBorrarServicios(){
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvModificarRol")){
			List<Object> idsAsignados = new ArrayList<Object>();
			if(serviciosRoles==null){
				serviciosRoles = new ArrayList<Object>();
			}
			if(rol.getGppServicios()!=null){
				Iterator<Object> itGppServicios = rol.getGppServicios().iterator();
				while(itGppServicios.hasNext()){
					Integer idAsignado = ( (Integer) ( (GppServicio) itGppServicios.next()).getSerNidservicio());
					idsAsignados.add(idAsignado);
				}
				Iterator<Object> itServiciosEliminados = serviciosRoles.iterator();
				while(itServiciosEliminados.hasNext()){
					Integer idServicioEliminado = (Integer) itServiciosEliminados.next();
					if(idsAsignados.contains(idServicioEliminado)==true){
						idsAsignados.remove(idServicioEliminado);
					}
				}
			}		
			rol.setServicios(idsAsignados);
			estadoOperacion = rolDelegate.getModificarRol(rol.getRolNidrol(), rol.getRolVnombre(), rol.getRolVdescripcion(), rol.getRolBactivo(), rol.getServicios());
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("RolMB");
				return ConstantesFaces.ESTADO_OK;
			}else{
				return ConstantesFaces.ESTADO_ERROR;
			}
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}				
	}
	
	public String getCambiarEstadoRol(){
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvModificarRol")){
			rol = rolDelegate.getSeleccionarRol(idRol);
			if(estadoCheck==true){
				rol.setRolBactivo(false);
			} else {
				rol.setRolBactivo(true);
			}
			estadoCheck = null;
			estadoOperacion = rolDelegate.getModificarRol(rol.getRolNidrol(), rol.getRolVnombre(), rol.getRolVdescripcion(), rol.getRolBactivo(), rol.getServicios());
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("RolMB");
				return ConstantesFaces.ESTADO_OK;
			} else {
				return ConstantesFaces.ESTADO_ERROR;
			}
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}				
	}
	
	public String getCancelar(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("RolMB");
		return ConstantesFaces.HOME_ROL;
	}
	
	public List<Object> getServicios(){
		servicioDelegate = new ServicioDelegate();
		List<Object> listadoServicios = servicioDelegate.getListaServicios();
		return listadoServicios;
	}	
	
	public void getIdServiciosAsignar(){
		if(serviciosRoles==null)
			serviciosRoles = new ArrayList<Object>();
		if(serviciosRoles.contains(idServicio)==false)
			serviciosRoles.add(idServicio);
		else
			serviciosRoles.remove(idServicio);
	}
	
	public String getHomeRol(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("RolMB");
		return ConstantesFaces.HOME_ROL;
	}
	
	public void getHomePageValue(){
		((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).setHomePage(ConstantesFaces.HOME_ROL);
	}
	
	public Boolean getValidarPermisosServicio(String nombreServicio){
		return ((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).validarPermisosServicio(nombreServicio);
	}
}