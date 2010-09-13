package co.com.inascol.atenea.managed.bean;

import java.util.List;

import javax.faces.context.FacesContext;

import co.com.inascol.atenea.entity.GppTipoarchivo;
import co.com.inascol.atenea.managed.bean.delegate.TipoarchivoDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class TipoarchivoMB {

	private TipoarchivoDelegate tipoarchivoDelegate;
	private Integer idTipoarchivo;
	private String nombreTipoarchivo;
	private String estadoTipoarchivo;
	private String controlNavegacion;
	private List<Object> tipoarchivos;
	private GppTipoarchivo tipoarchivo;
	private Boolean estadoOperacion;
	
	public TipoarchivoMB(){
		tipoarchivoDelegate = new TipoarchivoDelegate();
		tipoarchivos = tipoarchivoDelegate.getListaTipoarchivos();
	}
	
	public String getNombreTipoarchivo() {
		return nombreTipoarchivo;
	}
	public void setNombreTipoarchivo(String nombreTipoarchivo) {
		this.nombreTipoarchivo = nombreTipoarchivo;
	}
	public String getEstadoTipoarchivo() {
		return estadoTipoarchivo;
	}
	public void setEstadoTipoarchivo(String estadoTipoarchivo) {
		this.estadoTipoarchivo = estadoTipoarchivo;
	}
	public GppTipoarchivo getTipoarchivo() {
		return tipoarchivo;
	}
	public void setTipoarchivo(GppTipoarchivo tipoarchivo) {
		this.tipoarchivo = tipoarchivo;
	}
	public List<Object> getTipoarchivos() {
		return tipoarchivos;
	}
	public void setTipoarchivos(List<Object> tipoarchivos) {
		this.tipoarchivos = tipoarchivos;
	}
	public int getIdTipoarchivo() {
		return idTipoarchivo;
	}
	public void setIdTipoarchivo(int idTipoarchivo) {
		this.idTipoarchivo = idTipoarchivo;
	}
	public String getControlNavegacion() {
		return controlNavegacion;
	}
	public void setControlNavegacion(String controlNavegacion) {
		this.controlNavegacion = controlNavegacion;
	}

	public void getBuscarTipoarchivoPorNombre() {
		tipoarchivos = tipoarchivoDelegate.getTipoarchivoPorNombre(nombreTipoarchivo);
	}
	
	public String getAgregarTipoarchivo() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("TipoarchivoMB");
		return ConstantesFaces.CREAR_TIPOARCHIVO;
	}	
	
	public String getCrearTipoarchivo() {
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvAgregarTipoArchivo")){
			estadoOperacion = tipoarchivoDelegate.getCrearTipoarchivo(nombreTipoarchivo);
			getResultadoOperacion(estadoOperacion);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("TipoarchivoMB");
			} 
			return ConstantesFaces.HOME_TIPOARCHIVO;
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}			
	}
	
	public String getSeleccionarTipoarchivo(){
		tipoarchivo = tipoarchivoDelegate.getSeleccionarTipoarchivo(idTipoarchivo);
		return ConstantesFaces.MODIFICAR_TIPOARCHIVO;
	}
	
	public String getSeleccionarTipoarchivoDetalle(){
		tipoarchivo = tipoarchivoDelegate.getSeleccionarTipoarchivo(idTipoarchivo);
		return ConstantesFaces.DETALLE_TIPOARCHIVO;
	}
	
	public String getModificarTipoarchivo(){
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvModificarTipoArchivo")){
			estadoOperacion = tipoarchivoDelegate.getModificarTipoarchivo(tipoarchivo.getTarNidtipoarchivo(), tipoarchivo.getTarVtipoarchivo());
			getResultadoOperacion(estadoOperacion);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("TipoarchivoMB");
			} 
			return ConstantesFaces.HOME_TIPOARCHIVO;
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}			
	}
	
	public String getEliminarTipoarchivo(){
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvEliminarTipoArchivo")){
			estadoOperacion = tipoarchivoDelegate.getEliminarTipoarchivo(idTipoarchivo);
			getResultadoOperacion(estadoOperacion);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("TipoarchivoMB");
			} 
			return ConstantesFaces.HOME_TIPOARCHIVO;
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}			
	}
	
	public String getCancelar(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("TipoarchivoMB");
		return ConstantesFaces.HOME_TIPOARCHIVO;
	}
	
	public String getHomeTipoarchivo(){
		getMenuSeleccionado();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("TipoarchivoMB");
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PersonaMB");
		return ConstantesFaces.HOME_TIPOARCHIVO;
	}
	
	public void getHomePageValue(){
		((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).setHomePage(ConstantesFaces.HOME_TIPOARCHIVO);
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