package co.com.inascol.atenea.managed.bean;

import java.util.List;

import javax.faces.context.FacesContext;

import co.com.inascol.atenea.entity.GppTipodoc;
import co.com.inascol.atenea.managed.bean.delegate.TipodocumentoDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class TipodocumentoMB {

	private TipodocumentoDelegate tipodocDelegate;
	private Integer idTipodoc;
	private String nombreTipodoc;
	private String estadoTipodoc;
	private String controlNavegacion;
	private List<Object> tipodocs;
	private GppTipodoc tipodoc;
	private Boolean estadoOperacion;
	
	public TipodocumentoMB(){
		tipodocDelegate = new TipodocumentoDelegate();
		tipodocs = tipodocDelegate.getListaTipodocs();
	}
	
	public String getNombreTipodoc() {
		return nombreTipodoc;
	}
	public void setNombreTipodoc(String nombreTipodoc) {
		this.nombreTipodoc = nombreTipodoc;
	}
	public String getEstadoTipodoc() {
		return estadoTipodoc;
	}
	public void setEstadoTipodoc(String estadoTipodoc) {
		this.estadoTipodoc = estadoTipodoc;
	}
	public GppTipodoc getTipodoc() {
		return tipodoc;
	}
	public void setTipodocumento(GppTipodoc tipodoc) {
		this.tipodoc = tipodoc;
	}
	public List<Object> getTipodocs() {
		return tipodocs;
	}
	public void setTipodocs(List<Object> tipodocs) {
		this.tipodocs = tipodocs;
	}
	public int getIdTipodoc() {
		return idTipodoc;
	}
	public void setIdTipodoc(int idTipodoc) {
		this.idTipodoc = idTipodoc;
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
	public void setIdTipodoc(Integer idTipodoc) {
		this.idTipodoc = idTipodoc;
	}
	public void setTipodoc(GppTipodoc tipodoc) {
		this.tipodoc = tipodoc;
	}
	public void getBuscarTipodocPorNombre() {
		tipodocs = tipodocDelegate.getTipodocPorNombre(nombreTipodoc);
	}
	
	public String getAgregarTipodoc() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("TipodocumentoMB");
		return ConstantesFaces.CREAR_TIPODOCUMENTO;
	}	
	
	public String getCrearTipodoc() {
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvAgregarTipoDocumento")){
			estadoOperacion = tipodocDelegate.getCrearTipodocumento(nombreTipodoc);
			getResultadoOperacion(estadoOperacion);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("TipodocumentoMB");
			} 
			return ConstantesFaces.HOME_TIPODOCUMENTO;
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}			
	}
	
	public String getSeleccionarTipodoc(){
		tipodoc = tipodocDelegate.getSeleccionarTipodocumento(idTipodoc);
		return ConstantesFaces.MODIFICAR_TIPODOCUMENTO;
	}

	public String getSeleccionarTipodocDetalle(){
		tipodoc = tipodocDelegate.getSeleccionarTipodocumento(idTipodoc);
		return ConstantesFaces.DETALLE_TIPODOCUMENTO;
	}
	
	public String getModificarTipodoc(){
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvModificarTipoDocumento")){
			estadoOperacion = tipodocDelegate.getModificarTipodocumento(tipodoc.getTdcNidtipodoc(), tipodoc.getTdcVnombre());
			getResultadoOperacion(estadoOperacion);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("TipodocumentoMB");
			} 
			return ConstantesFaces.HOME_TIPODOCUMENTO;
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}			
	}
	
	public String getEliminarTipodoc(){
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvEliminarTipoDocumento")){
			estadoOperacion = tipodocDelegate.getEliminarTipodoc(idTipodoc);
			getResultadoOperacion(estadoOperacion);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("TipodocumentoMB");
			} 
			return ConstantesFaces.HOME_TIPODOCUMENTO;
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}				
	}
	
	public String getCancelar(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("TipodocumentoMB");
		return ConstantesFaces.HOME_TIPODOCUMENTO;
	}
	
	public String getHomeTipodocumento(){
		getMenuSeleccionado();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("TipodocumentoMB");
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PersonaMB");
		return ConstantesFaces.HOME_TIPODOCUMENTO;
	}
	
	public void getHomePageValue(){
		((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).setHomePage(ConstantesFaces.HOME_TIPODOCUMENTO);
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