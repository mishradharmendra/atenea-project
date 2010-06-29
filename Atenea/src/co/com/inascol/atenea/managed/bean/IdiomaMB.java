package co.com.inascol.atenea.managed.bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import co.com.inascol.atenea.entity.GppIdioma;
import co.com.inascol.atenea.managed.bean.delegate.IdiomaDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;


public class IdiomaMB {

	private IdiomaDelegate idiomaDelegate;
	private int idIdioma;
	private String nombreIdioma;
	private String estadoIdioma;
	private String controlNavegacion;
	private List idiomas;
	private GppIdioma idioma;
	
	public IdiomaMB(){
		idiomaDelegate = new IdiomaDelegate();
		idiomas = idiomaDelegate.getListaIdiomas();
	}
	
	public String getNombreIdioma() {
		return nombreIdioma;
	}
	public void setNombreIdioma(String nombreIdioma) {
		this.nombreIdioma = nombreIdioma;
	}
	public String getEstadoIdioma() {
		return estadoIdioma;
	}
	public void setEstadoIdioma(String estadoIdioma) {
		this.estadoIdioma = estadoIdioma;
	}
	public GppIdioma getIdioma() {
		return idioma;
	}
	public void setIdioma(GppIdioma idioma) {
		this.idioma = idioma;
	}
	public List getIdiomas() {
		return idiomas;
	}
	public void setIdiomas(List idiomas) {
		this.idiomas = idiomas;
	}
	public int getIdIdioma() {
		return idIdioma;
	}
	public void setIdIdioma(int idIdioma) {
		this.idIdioma = idIdioma;
	}
	public String getControlNavegacion() {
		return controlNavegacion;
	}
	public void setControlNavegacion(String controlNavegacion) {
		this.controlNavegacion = controlNavegacion;
	}

	public void getBuscarIdiomaPorNombre() {
		idiomas = idiomaDelegate.getIdiomaPorNombre(nombreIdioma);
	}
	

	public String getAgregarIdioma() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("IdiomaMB");
		return ConstantesFaces.CREAR_IDIOMA;
	}	
	
	public String getCrearIdioma() {		
		idiomaDelegate.getCrearIdioma(nombreIdioma);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("IdiomaMB");
		return ConstantesFaces.HOME_IDIOMA;
	}
	
	public String getSeleccionarIdioma(){
		idioma = idiomaDelegate.getSeleccionarIdioma(idIdioma);
		return ConstantesFaces.DETALLE_IDIOMA;
	}
	
	public String getModificarIdioma(){
		idiomaDelegate.getModificarIdioma(idioma.getIdiNididioma(), idioma.getIdiVidioma());
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("IdiomaMB");
		return ConstantesFaces.HOME_IDIOMA;
	}
	
	public String getCancelar(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("IdiomaMB");
		return ConstantesFaces.HOME_IDIOMA;
	}
	
	public String getHomeIdioma(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("IdiomaMB");
		return ConstantesFaces.HOME_IDIOMA;
	}
}