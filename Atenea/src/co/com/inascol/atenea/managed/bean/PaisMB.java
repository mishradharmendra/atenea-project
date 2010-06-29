package co.com.inascol.atenea.managed.bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import co.com.inascol.atenea.entity.GppPais;
import co.com.inascol.atenea.managed.bean.delegate.PaisDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;


public class PaisMB {

	private PaisDelegate paisDelegate;
	private String idPais;
	private String nombrePais;
	private String estadoPais;
	private String controlNavegacion;
	private List paises;
	private GppPais pais;
	
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
	public List getPaises() {
		return paises;
	}
	public void setPaiss(List paises) {
		this.paises = paises;
	}
	public String getIdPais() {
		return idPais;
	}
	public void setIdPais(String idPais) {
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
		paisDelegate.getCrearPais(idPais, nombrePais);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PaisMB");
		return ConstantesFaces.HOME_PAIS;
	}
	
	public String getSeleccionarPais(){
		pais = paisDelegate.getSeleccionarPais(idPais);
		return ConstantesFaces.DETALLE_PAIS;
	}
	
	public String getModificarPais(){
		paisDelegate.getModificarPais(pais.getPaiVidpais(), pais.getPaiVpais());
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PaisMB");
		return ConstantesFaces.HOME_PAIS;
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