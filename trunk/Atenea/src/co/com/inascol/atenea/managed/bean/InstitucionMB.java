package co.com.inascol.atenea.managed.bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import co.com.inascol.atenea.entity.GppInstitucion;
import co.com.inascol.atenea.managed.bean.delegate.InstitucionDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;


public class InstitucionMB {

	private InstitucionDelegate institucionDelegate;
	private int idInstitucion;
	private String nombreInstitucion;
	private String estadoInstitucion;
	private String controlNavegacion;
	private List instituciones;
	private GppInstitucion institucion;
	
	public InstitucionMB(){
		institucionDelegate = new InstitucionDelegate();
		instituciones = institucionDelegate.getListaInstituciones();
	}
	
	public String getNombreInstitucion() {
		return nombreInstitucion;
	}
	public void setNombreInstitucion(String nombreInstitucion) {
		this.nombreInstitucion = nombreInstitucion;
	}
	public String getEstadoInstitucion() {
		return estadoInstitucion;
	}
	public void setEstadoInstitucion(String estadoInstitucion) {
		this.estadoInstitucion = estadoInstitucion;
	}
	public GppInstitucion getInstitucion() {
		return institucion;
	}
	public void setInstitucion(GppInstitucion institucion) {
		this.institucion = institucion;
	}
	public List getInstituciones() {
		return instituciones;
	}
	public void setInstitucions(List instituciones) {
		this.instituciones = instituciones;
	}
	public int getIdInstitucion() {
		return idInstitucion;
	}
	public void setIdInstitucion(int idInstitucion) {
		this.idInstitucion = idInstitucion;
	}
	public String getControlNavegacion() {
		return controlNavegacion;
	}
	public void setControlNavegacion(String controlNavegacion) {
		this.controlNavegacion = controlNavegacion;
	}

	public void getBuscarInstitucionPorNombre() {
		instituciones = institucionDelegate.getInstitucionPorNombre(nombreInstitucion);
	}
	

	public String getAgregarInstitucion() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("InstitucionMB");
		return ConstantesFaces.CREAR_INSTITUCION;
	}	
	
	public String getCrearInstitucion() {		
		institucionDelegate.getCrearInstitucion(nombreInstitucion);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("InstitucionMB");
		return ConstantesFaces.HOME_INSTITUCION;
	}
	
	public String getSeleccionarInstitucion(){
		institucion = institucionDelegate.getSeleccionarInstitucion(idInstitucion);
		return ConstantesFaces.DETALLE_INSTITUCION;
	}
	
	public String getModificarInstitucion(){
		institucionDelegate.getModificarInstitucion(institucion.getInsNidinstitucion(), institucion.getInsVinstitucion());
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("InstitucionMB");
		return ConstantesFaces.HOME_INSTITUCION;
	}
	
	public String getCancelar(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("InstitucionMB");
		return ConstantesFaces.HOME_INSTITUCION;
	}
	
	public String getHomeInstitucion(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("InstitucionMB");
		return ConstantesFaces.HOME_INSTITUCION;
	}
}