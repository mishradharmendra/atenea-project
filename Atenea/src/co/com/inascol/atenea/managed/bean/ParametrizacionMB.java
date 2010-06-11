package co.com.inascol.atenea.managed.bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import co.com.inascol.atenea.entity.GppParametrizacion;
import co.com.inascol.atenea.managed.bean.delegate.ParametrizacionDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;


public class ParametrizacionMB {

	private ParametrizacionDelegate parametrizacionDelegate;
	private int idParametrizacion;
	private String nombreParametrizacion;
	private String valorParametrizacion;
	private String descripcionParametrizacion;
	private String controlNavegacion;
	private List parametrizaciones;
	private GppParametrizacion parametrizacion;
	
	public ParametrizacionMB(){
		parametrizacionDelegate = new ParametrizacionDelegate();
		parametrizaciones = parametrizacionDelegate.getListaParametrizacions();
	}
	
	public String getNombreParametrizacion() {
		return nombreParametrizacion;
	}
	public void setNombreParametrizacion(String nombreParametrizacion) {
		this.nombreParametrizacion = nombreParametrizacion;
	}
	public String getDescripcionParametrizacion() {
		return descripcionParametrizacion;
	}
	public void setDescripcionParametrizacion(String descripcionParametrizacion) {
		this.descripcionParametrizacion = descripcionParametrizacion;
	}	
	public String getValorParametrizacion() {
		return valorParametrizacion;
	}
	public void setValorParametrizacion(String valorParametrizacion) {
		this.valorParametrizacion = valorParametrizacion;
	}
	public GppParametrizacion getParametrizacion() {
		return parametrizacion;
	}
	public void setParametrizacion(GppParametrizacion parametrizacion) {
		this.parametrizacion = parametrizacion;
	}
	public List getParametrizaciones() {
		return parametrizaciones;
	}
	public void setParametrizaciones(List parametrizacionse) {
		this.parametrizaciones = parametrizaciones;
	}
	public int getIdParametrizacion() {
		return idParametrizacion;
	}
	public void setIdParametrizacion(int idParametrizacion) {
		this.idParametrizacion = idParametrizacion;
	}
	public String getControlNavegacion() {
		return controlNavegacion;
	}
	public void setControlNavegacion(String controlNavegacion) {
		this.controlNavegacion = controlNavegacion;
	}

	public void getBuscarParametrizacionPorNombre() {
		parametrizaciones = parametrizacionDelegate.getParametrizacionPorNombre(nombreParametrizacion);
	}
	

	public String getAgregarParametrizacion() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("ParametrizacionMB");
		return ConstantesFaces.CREAR_PARAMETRIZACION;
	}	
	
	public String getCrearParametrizacion() {		
		parametrizacionDelegate.getCrearParametrizacion(nombreParametrizacion, valorParametrizacion, descripcionParametrizacion); 
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("ParametrizacionMB");
		return ConstantesFaces.HOME_PARAMETRIZACION;
	}
	
	public String getSeleccionarParametrizacion(){
		parametrizacion = parametrizacionDelegate.getSeleccionarParametrizacion(idParametrizacion);
		return ConstantesFaces.DETALLE_PARAMETRIZACION;
	}
	
	public String getModificarParametrizacion(){
		parametrizacion.setParVvalor(valorParametrizacion);
		parametrizacionDelegate.getModificarParametrizacion(parametrizacion.getParNidparam(), parametrizacion.getParVnombre(),parametrizacion.getParVvalor(), parametrizacion.getParVdescripcion());
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("ParametrizacionMB");
		return ConstantesFaces.HOME_PARAMETRIZACION;
	}
	
	public String getCancelar(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("ParametrizacionMB");
		return ConstantesFaces.HOME_PARAMETRIZACION;
	}
}