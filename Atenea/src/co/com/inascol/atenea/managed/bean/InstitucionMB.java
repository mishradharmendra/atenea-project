package co.com.inascol.atenea.managed.bean;

import java.util.List;

import javax.faces.context.FacesContext;

import co.com.inascol.atenea.entity.GppInstitucion;
import co.com.inascol.atenea.managed.bean.delegate.InstitucionDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;


public class InstitucionMB {

	private InstitucionDelegate institucionDelegate;
	private Integer idInstitucion;
	private String nombreInstitucion;
	private String estadoInstitucion;
	private String controlNavegacion;
	private List<Object> instituciones;
	private GppInstitucion institucion;
	private Boolean estadoOperacion;
	
	public InstitucionMB(){
		institucionDelegate = new InstitucionDelegate();
		instituciones = institucionDelegate.getListaInstituciones();
	}
	
	public String getNombreInstitucion() {
		return nombreInstitucion;
	}
	public void setNombreInstitucion(String nombreInstitucion) {
		this.nombreInstitucion = nombreInstitucion;
	}
	public String getEstadoInstitucion() {
		return estadoInstitucion;
	}
	public void setEstadoInstitucion(String estadoInstitucion) {
		this.estadoInstitucion = estadoInstitucion;
	}
	public GppInstitucion getInstitucion() {
		return institucion;
	}
	public void setInstitucion(GppInstitucion institucion) {
		this.institucion = institucion;
	}
	public List<Object> getInstituciones() {
		return instituciones;
	}
	public void setInstitucions(List<Object> instituciones) {
		this.instituciones = instituciones;
	}
	public int getIdInstitucion() {
		return idInstitucion;
	}
	public void setIdInstitucion(int idInstitucion) {
		this.idInstitucion = idInstitucion;
	}
	public String getControlNavegacion() {
		return controlNavegacion;
	}
	public void setControlNavegacion(String controlNavegacion) {
		this.controlNavegacion = controlNavegacion;
	}

	public void getBuscarInstitucionPorNombre() {
		instituciones = institucionDelegate.getInstitucionPorNombre(nombreInstitucion);
	}

	public String getAgregarInstitucion() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("InstitucionMB");
		return ConstantesFaces.CREAR_INSTITUCION;
	}	
	
	public String getCrearInstitucion() {
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvAgregarInstitucion")){
			estadoOperacion = institucionDelegate.getCrearInstitucion(nombreInstitucion);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("InstitucionMB");
				return ConstantesFaces.ESTADO_OK;
			}else{
				return ConstantesFaces.ESTADO_ERROR;
			}
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}	
	}
	
	public String getSeleccionarInstitucion(){
		institucion = institucionDelegate.getSeleccionarInstitucion(idInstitucion);
		return ConstantesFaces.MODIFICAR_INSTITUCION;
	}
	
	public String getSeleccionarInstitucionDetalle(){
		institucion = institucionDelegate.getSeleccionarInstitucion(idInstitucion);
		return ConstantesFaces.DETALLE_INSTITUCION;
	}
	
	public String getModificarInstitucion(){
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvModificarInstitucion")){
			estadoOperacion = institucionDelegate.getModificarInstitucion(institucion.getInsNidinstitucion(), institucion.getInsVinstitucion());
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("InstitucionMB");
				return ConstantesFaces.ESTADO_OK;
			}else{
				return ConstantesFaces.ESTADO_ERROR;
			}
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}	
	}
	
	public String getEliminarInstitucion(){
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvEliminarInstitucion")){
			estadoOperacion = institucionDelegate.getEliminarInstitucion(idInstitucion);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("InstitucionMB");
				return ConstantesFaces.ESTADO_OK;
			}else{
				return ConstantesFaces.ESTADO_ERROR;
			}
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}				
	}
	
	public String getCancelar(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("InstitucionMB");
		return ConstantesFaces.HOME_INSTITUCION;
	}
	
	public String getHomeInstitucion(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("InstitucionMB");
		return ConstantesFaces.HOME_INSTITUCION;
	}
	
	public void getHomePageValue(){
		((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).setHomePage(ConstantesFaces.HOME_INSTITUCION);
	}
	
	public Boolean getValidarPermisosServicio(String nombreServicio){
		return ((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).validarPermisosServicio(nombreServicio);
	}
}