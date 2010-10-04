package co.com.inascol.atenea.managed.bean;

import java.util.List;

import javax.faces.context.FacesContext;

import co.com.inascol.atenea.entity.GppParametrizacion;
import co.com.inascol.atenea.managed.bean.delegate.ParametrizacionDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class ParametrizacionMB {

	private ParametrizacionDelegate parametrizacionDelegate;
	private Integer idParametrizacion;
	private String nombreParametrizacion;
	private String valorParametrizacion;
	private String descripcionParametrizacion;
	private String controlNavegacion;
	private List<Object> parametrizaciones;
	private GppParametrizacion parametrizacion;
	private Boolean estadoOperacion;
	
	public ParametrizacionMB(){
		parametrizacionDelegate = new ParametrizacionDelegate();
		parametrizaciones = parametrizacionDelegate.getListaParametrizacions();
	}
	
	public String getNombreParametrizacion() {
		return nombreParametrizacion;
	}
	public void setNombreParametrizacion(String nombreParametrizacion) {
		this.nombreParametrizacion = nombreParametrizacion;
	}
	public String getDescripcionParametrizacion() {
		return descripcionParametrizacion;
	}
	public void setDescripcionParametrizacion(String descripcionParametrizacion) {
		this.descripcionParametrizacion = descripcionParametrizacion;
	}	
	public String getValorParametrizacion() {
		return valorParametrizacion;
	}
	public void setValorParametrizacion(String valorParametrizacion) {
		this.valorParametrizacion = valorParametrizacion;
	}
	public GppParametrizacion getParametrizacion() {
		return parametrizacion;
	}
	public void setParametrizacion(GppParametrizacion parametrizacion) {
		this.parametrizacion = parametrizacion;
	}
	public List<Object> getParametrizaciones() {
		return parametrizaciones;
	}
	public void setParametrizaciones(List<Object> parametrizaciones) {
		this.parametrizaciones = parametrizaciones;
	}
	public int getIdParametrizacion() {
		return idParametrizacion;
	}
	public void setIdParametrizacion(int idParametrizacion) {
		this.idParametrizacion = idParametrizacion;
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
	public void setIdParametrizacion(Integer idParametrizacion) {
		this.idParametrizacion = idParametrizacion;
	}
	public void getBuscarParametrizacionPorNombre() {
		parametrizaciones = parametrizacionDelegate.getParametrizacionPorNombre(nombreParametrizacion);
	}

	public String getAgregarParametrizacion() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("ParametrizacionMB");
		return ConstantesFaces.CREAR_PARAMETRIZACION;
	}	
	
	public String getCrearParametrizacion() {
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvAgregarParametrizacion")){
			estadoOperacion = parametrizacionDelegate.getCrearParametrizacion(nombreParametrizacion, valorParametrizacion, descripcionParametrizacion);
			getResultadoOperacion(estadoOperacion);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("ParametrizacionMB");
			}
			return ConstantesFaces.HOME_PARAMETRIZACION;
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}			
	}
	
	public String getSeleccionarParametrizacion(){
		parametrizacion = parametrizacionDelegate.getSeleccionarParametrizacion(idParametrizacion);
		return ConstantesFaces.MODIFICAR_PARAMETRIZACION;
	}

	public String getSeleccionarParametrizacionDetalle(){
		parametrizacion = parametrizacionDelegate.getSeleccionarParametrizacion(idParametrizacion);
		return ConstantesFaces.DETALLE_PARAMETRIZACION;
	}
	
	public String getModificarParametrizacion(){
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvModificarParametrizacion")){
			estadoOperacion = parametrizacionDelegate.getModificarParametrizacion(parametrizacion.getParNidparam(), parametrizacion.getParVnombre(),parametrizacion.getParVvalor(), parametrizacion.getParVdescripcion());
			getResultadoOperacion(estadoOperacion);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("ParametrizacionMB");
			}
			return ConstantesFaces.HOME_PARAMETRIZACION;
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}				
	}
	
	public String getCancelar(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("ParametrizacionMB");
		return ConstantesFaces.HOME_PARAMETRIZACION;
	}
	
	public String getHomeParametrizacion(){
		getMenuSeleccionado();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("ParametrizacionMB");
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PersonaMB");
		return ConstantesFaces.HOME_PARAMETRIZACION;
	}
	
	public void getHomePageValue(){
		((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).setHomePage(ConstantesFaces.HOME_PARAMETRIZACION);
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