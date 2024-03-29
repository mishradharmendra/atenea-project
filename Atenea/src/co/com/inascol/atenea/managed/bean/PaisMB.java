package co.com.inascol.atenea.managed.bean;

import java.util.List;

import javax.faces.context.FacesContext;

import co.com.inascol.atenea.entity.GppPais;
import co.com.inascol.atenea.managed.bean.delegate.PaisDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class PaisMB {

	private PaisDelegate paisDelegate;
	private Integer idPais;
	private String nombrePais;
	private String estadoPais;
	private String controlNavegacion;
	private List<Object> paises;
	private GppPais pais;
	private Boolean estadoOperacion;
	
	public PaisMB(){
		paisDelegate = new PaisDelegate();
		paises = paisDelegate.getListaPaises();
	}
	
	public String getNombrePais() {
		return nombrePais;
	}
	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}
	public String getEstadoPais() {
		return estadoPais;
	}
	public void setEstadoPais(String estadoPais) {
		this.estadoPais = estadoPais;
	}
	public GppPais getPais() {
		return pais;
	}
	public void setPais(GppPais pais) {
		this.pais = pais;
	}
	public List<Object> getPaises() {
		return paises;
	}
	public void setPaiss(List<Object> paises) {
		this.paises = paises;
	}
	public Integer getIdPais() {
		return idPais;
	}
	public void setIdPais(Integer idPais) {
		this.idPais = idPais;
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
	public void setPaises(List<Object> paises) {
		this.paises = paises;
	}
	public void getBuscarPaisPorNombre() {
		paises = paisDelegate.getPaisPorNombre(nombrePais);
	}

	public String getAgregarPais() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PaisMB");
		return ConstantesFaces.CREAR_PAIS;
	}	
	
	public String getCrearPais() {		
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvAgregarPais")){
			estadoOperacion = paisDelegate.getCrearPais(nombrePais);
			getResultadoOperacion(estadoOperacion);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PaisMB");
			}
			return ConstantesFaces.HOME_PAIS;
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}			
	}
	
	public String getSeleccionarPais(){
		pais = paisDelegate.getSeleccionarPais(idPais);
		return ConstantesFaces.MODIFICAR_PAIS;
	}

	public String getSeleccionarPaisDetalle(){
		pais = paisDelegate.getSeleccionarPais(idPais);
		return ConstantesFaces.DETALLE_PAIS;
	}
	
	public String getModificarPais(){
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvModificarPais")){
			estadoOperacion = paisDelegate.getModificarPais(pais.getPaiNidpais(), pais.getPaiVpais());
			getResultadoOperacion(estadoOperacion);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PaisMB");
			}
			return ConstantesFaces.HOME_PAIS;
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}				
	}
	
	public String getEliminarPais(){
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvEliminarPais")){
			estadoOperacion = paisDelegate.getEliminarPais(idPais);
			getResultadoOperacion(estadoOperacion);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PaisMB");
			}
			return ConstantesFaces.HOME_PAIS;
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}		
	}

	public String getCancelar(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PaisMB");
		return ConstantesFaces.HOME_PAIS;
	}
	
	public String getHomePais(){
		getMenuSeleccionado();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PaisMB");
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PersonaMB");
		return ConstantesFaces.HOME_PAIS;
	}
	
	public void getHomePageValue(){
		((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).setHomePage(ConstantesFaces.HOME_PAIS);
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