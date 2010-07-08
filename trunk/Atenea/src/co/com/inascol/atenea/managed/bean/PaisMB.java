package co.com.inascol.atenea.managed.bean;

import java.util.List;

import javax.faces.context.FacesContext;

import co.com.inascol.atenea.entity.GppPais;
import co.com.inascol.atenea.managed.bean.delegate.PaisDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;


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

	public void getBuscarPaisPorNombre() {
		paises = paisDelegate.getPaisPorNombre(nombrePais);
	}

	public String getAgregarPais() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PaisMB");
		return ConstantesFaces.CREAR_PAIS;
	}	
	
	public String getCrearPais() {		
		estadoOperacion = false;
		estadoOperacion = paisDelegate.getCrearPais(nombrePais);
		if(estadoOperacion==true){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PaisMB");
			return ConstantesFaces.ESTADO_PA_OK;
		}else{
			return ConstantesFaces.ESTADO_PA_ERROR;
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
		estadoOperacion = false;
		estadoOperacion = paisDelegate.getModificarPais(pais.getPaiNidpais(), pais.getPaiVpais());
		if(estadoOperacion==true){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PaisMB");
			return ConstantesFaces.ESTADO_PA_OK;
		}else{
			return ConstantesFaces.ESTADO_PA_ERROR;
		}
	}
	
	public String getEliminarPais(){
		estadoOperacion = false;
		estadoOperacion = paisDelegate.getEliminarPais(idPais);
		if(estadoOperacion==true){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PaisMB");
			return ConstantesFaces.ESTADO_PA_OK;
		}else{
			return ConstantesFaces.ESTADO_PA_ERROR;
		}
	}

	public String getCancelar(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PaisMB");
		return ConstantesFaces.HOME_PAIS;
	}
	
	public String getHomePais(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PaisMB");
		return ConstantesFaces.HOME_PAIS;
	}
}