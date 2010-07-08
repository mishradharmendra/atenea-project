package co.com.inascol.atenea.managed.bean;

import java.util.List;

import javax.faces.context.FacesContext;

import co.com.inascol.atenea.entity.GppCargoequivalente;
import co.com.inascol.atenea.managed.bean.delegate.CargoequivalenteDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;


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

	public void getBuscarCargoequivalentePorNombre() {
		cargosequivalentes = cargoequivalenteDelegate.getCargoequivalentePorNombre(nombreCargo);
	}
	
	public String getAgregarCargoequivalente() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("CargoequivalenteMB");
		return ConstantesFaces.CREAR_CARGOEQUIVALENTE;
	}	
	
	public String getCrearCargoequivalente() {	
		estadoOperacion = false;
		estadoOperacion = cargoequivalenteDelegate.getCrearCargoequivalente(nombreCargo);
		if(estadoOperacion==true){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("CargoequivalenteMB");
			return ConstantesFaces.ESTADO_CE_OK;
		}else{
			return ConstantesFaces.ESTADO_CE_ERROR;
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
		estadoOperacion = false;
		estadoOperacion = cargoequivalenteDelegate.getModificarCargoequivalente(cargoequivalente.getCeqNidcargoeq(), cargoequivalente.getCeqVcargoeq());
		if(estadoOperacion==true){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("CargoequivalenteMB");
			return ConstantesFaces.ESTADO_CE_OK;
		}else{
			return ConstantesFaces.ESTADO_CE_ERROR;
		}
	}
	
	public String getEliminarCargoequivalente(){
		estadoOperacion = false;
		estadoOperacion = cargoequivalenteDelegate.getEliminarCargoequivalente(idCargoequivalente);
		if(estadoOperacion==true){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("CargoequivalenteMB");
			return ConstantesFaces.ESTADO_CE_OK;
		}else{
			return ConstantesFaces.ESTADO_CE_ERROR;
		}
	}
	
	public String getCancelar(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("CargoequivalenteMB");
		return ConstantesFaces.HOME_CARGOEQUIVALENTE;
	}
	
	public String getHomeCargoequivalente(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("CargoequivalenteMB");
		return ConstantesFaces.HOME_CARGOEQUIVALENTE;
	}
}