package co.com.inascol.atenea.managed.bean;

import java.util.List;

import javax.faces.context.FacesContext;

import co.com.inascol.atenea.entity.GppServicio;
import co.com.inascol.atenea.managed.bean.delegate.ServicioDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;


public class ServicioMB {

	private ServicioDelegate servicioDelegate;
	private Integer idServicio;
	private String nombreServicio;
	private String estadoServicio;
	private String rutaServicio;
	private String controlNavegacion;
	private List<Object> servicios;
	private GppServicio servicio;
	
	public ServicioMB(){
		servicioDelegate = new ServicioDelegate();
		servicios = servicioDelegate.getListaServicios();
	}
	
	public String getNombreServicio() {
		return nombreServicio;
	}
	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}
	public String getRutaServicio() {
		return rutaServicio;
	}
	public void setRutaServicio(String rutaServicio) {
		this.rutaServicio = rutaServicio;
	}	
	public String getEstadoServicio() {
		return estadoServicio;
	}
	public void setEstadoServicio(String estadoServicio) {
		this.estadoServicio = estadoServicio;
	}
	public GppServicio getServicio() {
		return servicio;
	}
	public void setServicio(GppServicio servicio) {
		this.servicio = servicio;
	}
	public List<Object> getServicios() {
		return servicios;
	}
	public void setServicios(List<Object> servicios) {
		this.servicios = servicios;
	}
	public Integer getIdServicio() {
		return idServicio;
	}
	public void setIdServicio(Integer idServicio) {
		this.idServicio = idServicio;
	}
	public String getControlNavegacion() {
		return controlNavegacion;
	}
	public void setControlNavegacion(String controlNavegacion) {
		this.controlNavegacion = controlNavegacion;
	}

	public void getBuscarServicioPorNombre() {
		servicios = servicioDelegate.getServicioPorNombre(nombreServicio);
	}
	

	public String getAgregarServicio() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("ServicioMB");
		return ConstantesFaces.CREAR_SERVICIO;
	}	
	
	public String getCrearServicio() {		
		servicioDelegate.getCrearServicio(nombreServicio, rutaServicio);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("ServicioMB");
		return ConstantesFaces.HOME_SERVICIO;
	}
	
	public String getSeleccionarServicio(){
		servicio = servicioDelegate.getSeleccionarServicio(idServicio);
		return ConstantesFaces.DETALLE_SERVICIO;
	}
	
	public String getModificarServicio(){
		servicioDelegate.getModificarServicio(servicio.getSerNidservicio(), servicio.getSerVnombre(), servicio.getSerVruta());
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("ServicioMB");
		return ConstantesFaces.HOME_SERVICIO;
	}
	
	public String getCancelar(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("ServicioMB");
		return ConstantesFaces.HOME_SERVICIO;
	}
	
	public String getHomeServicio(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("ServicioMB");
		return ConstantesFaces.HOME_SERVICIO;
	}
}