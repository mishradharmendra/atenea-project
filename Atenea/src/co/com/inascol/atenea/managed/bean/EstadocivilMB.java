package co.com.inascol.atenea.managed.bean;

import java.util.List;

import javax.faces.context.FacesContext;

import co.com.inascol.atenea.entity.GppEstadocivil;
import co.com.inascol.atenea.managed.bean.delegate.EstadocivilDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class EstadocivilMB {

	private EstadocivilDelegate estadocivilDelegate;
	private Integer idEstadocivil;
	private String nombreEstadocivil;
	private String estadoEstadocivil;
	private String controlNavegacion;
	private List<Object> estadociviles;
	private GppEstadocivil estadocivil;
	private Boolean estadoOperacion;
	
	public EstadocivilMB(){
		estadocivilDelegate = new EstadocivilDelegate();
		estadociviles = estadocivilDelegate.getListaEstadocivils();
	}
	
	public String getNombreEstadocivil() {
		return nombreEstadocivil;
	}
	public void setNombreEstadocivil(String nombreEstadocivil) {
		this.nombreEstadocivil = nombreEstadocivil;
	}
	public String getEstadoEstadocivil() {
		return estadoEstadocivil;
	}
	public void setEstadoEstadocivil(String estadoEstadocivil) {
		this.estadoEstadocivil = estadoEstadocivil;
	}
	public GppEstadocivil getEstadocivil() {
		return estadocivil;
	}
	public void setEstadocivil(GppEstadocivil estadocivil) {
		this.estadocivil = estadocivil;
	}
	public List<Object> getEstadociviles() {
		return estadociviles;
	}
	public void setEstadociviles(List<Object> estadociviles) {
		this.estadociviles = estadociviles;
	}
	public int getIdEstadocivil() {
		return idEstadocivil;
	}
	public void setIdEstadocivil(int idEstadocivil) {
		this.idEstadocivil = idEstadocivil;
	}
	public String getControlNavegacion() {
		return controlNavegacion;
	}
	public void setControlNavegacion(String controlNavegacion) {
		this.controlNavegacion = controlNavegacion;
	}

	public void getBuscarEstadocivilPorNombre() {
		estadociviles = estadocivilDelegate.getEstadocivilPorNombre(nombreEstadocivil);
	}
	
	public String getAgregarEstadocivil() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("EstadocivilMB");
		return ConstantesFaces.CREAR_ESTADOCIVIL;
	}	
	
	public String getCrearEstadocivil() {	
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvAgregarEstadoCivil")){
			estadoOperacion = estadocivilDelegate.getCrearEstadocivil(nombreEstadocivil);
			getResultadoOperacion(estadoOperacion);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("EstadocivilMB");
			}
			return ConstantesFaces.HOME_ESTADOCIVIL;
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}
	}
	
	public String getSeleccionarEstadocivil(){
		estadocivil = estadocivilDelegate.getSeleccionarEstadocivil(idEstadocivil);
		return ConstantesFaces.MODIFICAR_ESTADOCIVIL;
	}
	
	public String getSeleccionarEstadocivilDetalle(){
		estadocivil = estadocivilDelegate.getSeleccionarEstadocivil(idEstadocivil);
		return ConstantesFaces.DETALLE_ESTADOCIVIL;
	}
	
	public String getModificarEstadocivil(){
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvModificarEstadoCivil")){
			estadoOperacion = estadocivilDelegate.getModificarEstadocivil(estadocivil.getEscNidestadocivil(), estadocivil.getEscVestadocivil());
			getResultadoOperacion(estadoOperacion);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("EstadocivilMB");
			}
			return ConstantesFaces.HOME_ESTADOCIVIL;
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}
	}
	
	public String getEliminarEstadocivil(){
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvEliminarEstadoCivil")){
			estadoOperacion = estadocivilDelegate.getEliminarEstadocivil(idEstadocivil);
			getResultadoOperacion(estadoOperacion);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("EstadocivilMB");
			}
			return ConstantesFaces.HOME_ESTADOCIVIL;
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}
	}
	
	public String getCancelar(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("EstadocivilMB");
		return ConstantesFaces.HOME_ESTADOCIVIL;
	}
	
	public String getHomeEstadocivil(){
		getMenuSeleccionado();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("EstadocivilMB");
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PersonaMB");
		return ConstantesFaces.HOME_ESTADOCIVIL;
	}
	
	public void getHomePageValue(){
		((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).setHomePage(ConstantesFaces.HOME_ESTADOCIVIL);
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