package co.com.inascol.atenea.managed.bean;

import java.util.List;

import javax.faces.context.FacesContext;

import co.com.inascol.atenea.entity.GppInstitucion;
import co.com.inascol.atenea.managed.bean.delegate.InstitucionDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
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
	public Boolean getEstadoOperacion() {
		return estadoOperacion;
	}
	public void setEstadoOperacion(Boolean estadoOperacion) {
		this.estadoOperacion = estadoOperacion;
	}
	public void setIdInstitucion(Integer idInstitucion) {
		this.idInstitucion = idInstitucion;
	}
	public void setInstituciones(List<Object> instituciones) {
		this.instituciones = instituciones;
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
			getResultadoOperacion(estadoOperacion);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("InstitucionMB");
			}
			return ConstantesFaces.HOME_INSTITUCION;
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
			getResultadoOperacion(estadoOperacion);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("InstitucionMB");
			}
			return ConstantesFaces.HOME_INSTITUCION;
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}	
	}
	
	public String getEliminarInstitucion(){
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvEliminarInstitucion")){
			estadoOperacion = institucionDelegate.getEliminarInstitucion(idInstitucion);
			getResultadoOperacion(estadoOperacion);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("InstitucionMB");
			}
			return ConstantesFaces.HOME_INSTITUCION;
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}				
	}
	
	public String getCancelar(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("InstitucionMB");
		return ConstantesFaces.HOME_INSTITUCION;
	}
	
	public String getHomeInstitucion(){
		getMenuSeleccionado();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("InstitucionMB");
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PersonaMB");
		return ConstantesFaces.HOME_INSTITUCION;
	}
	
	public void getHomePageValue(){
		((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).setHomePage(ConstantesFaces.HOME_INSTITUCION);
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