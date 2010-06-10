package co.com.inascol.atenea.managed.bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import co.com.inascol.atenea.entity.GppPerfilequivalente;
import co.com.inascol.atenea.managed.bean.delegate.PerfilequivalenteDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;


public class PerfilequivalenteMB {

	private PerfilequivalenteDelegate perfilequivalenteDelegate;
	private int idPerfilequivalente;
	private String nombrePerfil;
	private String estadoPerfilequivalente;
	private String controlNavegacion;
	private List perfilesequivalentes;
	private GppPerfilequivalente perfilequivalente;
	
	public PerfilequivalenteMB(){
		perfilequivalenteDelegate = new PerfilequivalenteDelegate();
		perfilesequivalentes = perfilequivalenteDelegate.getListaPerfilequivalentes();
	}
	
	public String getNombrePerfil() {
		return nombrePerfil;
	}		   
	public void setNombrePerfil(String nombrePerfil) {
		this.nombrePerfil = nombrePerfil;
	}
	public String getEstadoPerfilequivalente() {
		return estadoPerfilequivalente;
	}
	public void setEstadoPerfilequivalente(String estadoPerfilequivalente) {
		this.estadoPerfilequivalente = estadoPerfilequivalente;
	}
	public GppPerfilequivalente getPerfilequivalente() {
		return perfilequivalente;
	}
	public void setPerfilequivalente(GppPerfilequivalente perfilequivalente) {
		this.perfilequivalente = perfilequivalente;
	}
	public List getPerfilesequivalentes() {
		return perfilesequivalentes;
	}
	public void setPerfilesequivalentes(List perfilesequivalentes) {
		this.perfilesequivalentes = perfilesequivalentes;
	}
	public int getIdPerfilequivalente() {
		return idPerfilequivalente;
	}
	public void setIdPerfilequivalente(int idPerfilequivalente) {
		this.idPerfilequivalente = idPerfilequivalente;
	}
	public String getControlNavegacion() {
		return controlNavegacion;
	}
	public void setControlNavegacion(String controlNavegacion) {
		this.controlNavegacion = controlNavegacion;
	}

	public void getBuscarPerfilequivalentePorNombre() {
		perfilesequivalentes = perfilequivalenteDelegate.getPerfilequivalentePorNombre(nombrePerfil);
	}
	

	public String getAgregarPerfilequivalente() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PerfilequivalenteMB");
		return ConstantesFaces.CREAR_PERFILEQUIVALENTE;
	}	
	
	public String getCrearPerfilequivalente() {		
		perfilequivalenteDelegate.getCrearPerfilequivalente(nombrePerfil);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PerfilequivalenteMB");
		return ConstantesFaces.HOME_PERFILEQUIVALENTE;
	}
	
	public String getSeleccionarPerfilequivalente(){
		perfilequivalente = perfilequivalenteDelegate.getSeleccionarPerfilequivalente(idPerfilequivalente);
		return ConstantesFaces.DETALLE_PERFILEQUIVALENTE;
	}
	
	public String getModificarPerfilequivalente(){
		perfilequivalenteDelegate.getModificarPerfilequivalente(perfilequivalente.getPeqNidperfileq(), perfilequivalente.getPeqVperfileq());
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PerfilequivalenteMB");
		return ConstantesFaces.HOME_PERFILEQUIVALENTE;
	}
	
	public String getCancelar(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PerfilequivalenteMB");
		return ConstantesFaces.HOME_PERFILEQUIVALENTE;
	}
}