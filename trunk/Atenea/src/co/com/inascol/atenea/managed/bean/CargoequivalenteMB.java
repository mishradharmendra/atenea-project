package co.com.inascol.atenea.managed.bean;

import java.util.List;

import javax.faces.context.FacesContext;

import co.com.inascol.atenea.entity.GppCargoequivalente;
import co.com.inascol.atenea.managed.bean.delegate.CargoequivalenteDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class CargoequivalenteMB {

	private CargoequivalenteDelegate cargoequivalenteDelegate;
	private Integer idCargoequivalente;
	private String nombreCargo;
	private String estadoCargoequivalente;
	private String controlNavegacion;
	private List<Object> cargosequivalentes;
	private GppCargoequivalente cargoequivalente;
	private Boolean estadoOperacion;
	
	public CargoequivalenteMB(){
		cargoequivalenteDelegate = new CargoequivalenteDelegate();
		cargosequivalentes = cargoequivalenteDelegate.getListaCargoequivalentes();
	}
	
	public String getNombreCargo() {
		return nombreCargo;
	}		   
	public void setNombreCargo(String nombreCargo) {
		this.nombreCargo = nombreCargo;
	}
	public String getEstadoCargoequivalente() {
		return estadoCargoequivalente;
	}
	public void setEstadoCargoequivalente(String estadoCargoequivalente) {
		this.estadoCargoequivalente = estadoCargoequivalente;
	}
	public GppCargoequivalente getCargoequivalente() {
		return cargoequivalente;
	}
	public void setCargoequivalente(GppCargoequivalente cargoequivalente) {
		this.cargoequivalente = cargoequivalente;
	}
	public List<Object> getCargosequivalentes() {
		return cargosequivalentes;
	}
	public void setCargosequivalentes(List<Object> cargosequivalentes) {
		this.cargosequivalentes = cargosequivalentes;
	}
	public int getIdCargoequivalente() {
		return idCargoequivalente;
	}
	public void setIdCargoequivalente(int idCargoequivalente) {
		this.idCargoequivalente = idCargoequivalente;
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
	public void setIdCargoequivalente(Integer idCargoequivalente) {
		this.idCargoequivalente = idCargoequivalente;
	}
	public void getBuscarCargoequivalentePorNombre() {
		cargosequivalentes = cargoequivalenteDelegate.getCargoequivalentePorNombre(nombreCargo);
	}
	
	public String getAgregarCargoequivalente() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("CargoequivalenteMB");
		return ConstantesFaces.CREAR_CARGOEQUIVALENTE;
	}	
	
	public String getCrearCargoequivalente() {
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvAgregarCargoEquivalente")){
			estadoOperacion = cargoequivalenteDelegate.getCrearCargoequivalente(nombreCargo);
			getResultadoOperacion(estadoOperacion);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("CargoequivalenteMB");
			}
			return ConstantesFaces.HOME_CARGOEQUIVALENTE;
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}
	}
	
	public String getSeleccionarCargoequivalente(){
		cargoequivalente = cargoequivalenteDelegate.getSeleccionarCargoequivalente(idCargoequivalente);
		return ConstantesFaces.MODIFICAR_CARGOEQUIVALENTE;
	}
	
	public String getSeleccionarCargoequivalenteDetalle(){
		cargoequivalente = cargoequivalenteDelegate.getSeleccionarCargoequivalente(idCargoequivalente);
		return ConstantesFaces.DETALLE_CARGOEQUIVALENTE;
	}
	
	public String getModificarCargoequivalente(){
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvModificarCargoEquivalente")){
			estadoOperacion = cargoequivalenteDelegate.getModificarCargoequivalente(cargoequivalente.getCeqNidcargoeq(), cargoequivalente.getCeqVcargoeq());
			getResultadoOperacion(estadoOperacion);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("CargoequivalenteMB");
			}
			return ConstantesFaces.HOME_CARGOEQUIVALENTE;
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}
	}
	
	public String getEliminarCargoequivalente(){
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvEliminarCargoEquivalente")){
			estadoOperacion = cargoequivalenteDelegate.getEliminarCargoequivalente(idCargoequivalente);
			getResultadoOperacion(estadoOperacion);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("CargoequivalenteMB");
			}
			return ConstantesFaces.HOME_CARGOEQUIVALENTE;
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}
	}
	
	public String getCancelar(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("CargoequivalenteMB");
		return ConstantesFaces.HOME_CARGOEQUIVALENTE;
	}
	
	public String getHomeCargoequivalente(){
		getMenuSeleccionado();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("CargoequivalenteMB");
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PersonaMB");
		return ConstantesFaces.HOME_CARGOEQUIVALENTE;
	}
	
	public void getHomePageValue(){
		((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).setHomePage(ConstantesFaces.HOME_CARGOEQUIVALENTE);
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