package co.com.inascol.atenea.managed.bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import co.com.inascol.atenea.entity.GppEstadocivil;
import co.com.inascol.atenea.managed.bean.delegate.EstadocivilDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;


public class EstadocivilMB {

	private EstadocivilDelegate estadocivilDelegate;
	private int idEstadocivil;
	private String nombreEstadocivil;
	private String estadoEstadocivil;
	private String controlNavegacion;
	private List estadociviles;
	private GppEstadocivil estadocivil;
	
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
	public List getEstadociviles() {
		return estadociviles;
	}
	public void setEstadociviles(List estadociviles) {
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
		estadocivilDelegate.getCrearEstadocivil(nombreEstadocivil);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("EstadocivilMB");
		return ConstantesFaces.HOME_ESTADOCIVIL;
	}
	
	public String getSeleccionarEstadocivil(){
		estadocivil = estadocivilDelegate.getSeleccionarEstadocivil(idEstadocivil);
		return ConstantesFaces.DETALLE_ESTADOCIVIL;
	}
	
	public String getModificarEstadocivil(){
		estadocivilDelegate.getModificarEstadocivil(estadocivil.getEscNidestadocivil(), estadocivil.getEscVestadocivil());
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("EstadocivilMB");
		return ConstantesFaces.HOME_ESTADOCIVIL;
	}
	
	public String getCancelar(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("EstadocivilMB");
		return ConstantesFaces.HOME_ESTADOCIVIL;
	}
}