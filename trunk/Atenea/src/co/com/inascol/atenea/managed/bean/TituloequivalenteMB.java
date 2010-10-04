package co.com.inascol.atenea.managed.bean;

import java.util.List;

import javax.faces.context.FacesContext;

import co.com.inascol.atenea.entity.GppTituloequivalente;
import co.com.inascol.atenea.managed.bean.delegate.TituloequivalenteDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class TituloequivalenteMB {

	private TituloequivalenteDelegate tituloequivalenteDelegate;
	private Integer idTituloequivalente;
	private String nombreTitulo;
	private String estadoTituloequivalente;
	private String controlNavegacion;
	private List<Object> titulosequivalentes;
	private GppTituloequivalente tituloequivalente;
	private Boolean estadoOperacion;
	
	public TituloequivalenteMB(){
		tituloequivalenteDelegate = new TituloequivalenteDelegate();
		titulosequivalentes = tituloequivalenteDelegate.getListaTituloequivalentes();
	}
	
	public String getNombreTitulo() {
		return nombreTitulo;
	}		   
	public void setNombreTitulo(String nombreTitulo) {
		this.nombreTitulo = nombreTitulo;
	}
	public String getEstadoTituloequivalente() {
		return estadoTituloequivalente;
	}
	public void setEstadoTituloequivalente(String estadoTituloequivalente) {
		this.estadoTituloequivalente = estadoTituloequivalente;
	}
	public GppTituloequivalente getTituloequivalente() {
		return tituloequivalente;
	}
	public void setTituloequivalente(GppTituloequivalente tituloequivalente) {
		this.tituloequivalente = tituloequivalente;
	}
	public List<Object> getTitulosequivalentes() {
		return titulosequivalentes;
	}
	public void setTitulosequivalentes(List<Object> titulosequivalentes) {
		this.titulosequivalentes = titulosequivalentes;
	}
	public int getIdTituloequivalente() {
		return idTituloequivalente;
	}
	public void setIdTituloequivalente(int idTituloequivalente) {
		this.idTituloequivalente = idTituloequivalente;
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
	public void setIdTituloequivalente(Integer idTituloequivalente) {
		this.idTituloequivalente = idTituloequivalente;
	}

	public void getBuscarTituloequivalentePorNombre() {
		titulosequivalentes = tituloequivalenteDelegate.getTituloequivalentePorNombre(nombreTitulo);
	}

	public String getAgregarTituloequivalente() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("TituloequivalenteMB");
		return ConstantesFaces.CREAR_TITULOEQUIVALENTE;
	}	
	
	public String getCrearTituloequivalente() {
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvAgregarTituloEquivalente")){
			estadoOperacion = tituloequivalenteDelegate.getCrearTituloequivalente(nombreTitulo);
			getResultadoOperacion(estadoOperacion);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("TituloequivalenteMB");
			} 
			return ConstantesFaces.HOME_TITULOEQUIVALENTE;
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}				
	}
	
	public String getSeleccionarTituloequivalente(){
		tituloequivalente = tituloequivalenteDelegate.getSeleccionarTituloequivalente(idTituloequivalente);
		return ConstantesFaces.MODIFICAR_TITULOEQUIVALENTE;
	}

	public String getSeleccionarTituloequivalenteDetalle(){
		tituloequivalente = tituloequivalenteDelegate.getSeleccionarTituloequivalente(idTituloequivalente);
		return ConstantesFaces.DETALLE_TITULOEQUIVALENTE;
	}
	
	public String getModificarTituloequivalente(){
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvModificarTituloEquivalente")){
			estadoOperacion = tituloequivalenteDelegate.getModificarTituloequivalente(tituloequivalente.getTeqNidtituloeq(), tituloequivalente.getTeqVtituloeq());
			getResultadoOperacion(estadoOperacion);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("TituloequivalenteMB");
			} 
			return ConstantesFaces.HOME_TITULOEQUIVALENTE;
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}				
	}
	
	public String getEliminarTituloequivalente(){
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvEliminarTituloEquivalente")){
			estadoOperacion = tituloequivalenteDelegate.getEliminarTituloequivalente(idTituloequivalente);
			getResultadoOperacion(estadoOperacion);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("TituloequivalenteMB");
			} 
			return ConstantesFaces.HOME_TITULOEQUIVALENTE;
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}			
	}
	
	public String getCancelar(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("TituloequivalenteMB");
		return ConstantesFaces.HOME_TITULOEQUIVALENTE;
	}
	
	public String getHomeTituloequivalente(){
		getMenuSeleccionado();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("TituloequivalenteMB");
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PersonaMB");
		return ConstantesFaces.HOME_TITULOEQUIVALENTE;
	}
	
	public void getHomePageValue(){
		((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).setHomePage(ConstantesFaces.HOME_TITULOEQUIVALENTE);
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