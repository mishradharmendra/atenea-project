package co.com.inascol.atenea.managed.bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import co.com.inascol.atenea.entity.GppTituloequivalente;
import co.com.inascol.atenea.managed.bean.delegate.TituloequivalenteDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;


public class TituloequivalenteMB {

	private TituloequivalenteDelegate tituloequivalenteDelegate;
	private int idTituloequivalente;
	private String nombreTitulo;
	private String estadoTituloequivalente;
	private String controlNavegacion;
	private List titulosequivalentes;
	private GppTituloequivalente tituloequivalente;
	
	public TituloequivalenteMB(){
		tituloequivalenteDelegate = new TituloequivalenteDelegate();
		titulosequivalentes = tituloequivalenteDelegate.getListaTituloequivalentes();
	}
	
	public String getNombreTitulo() {
		return nombreTitulo;
	}		   
	public void setNombreTitulo(String nombreTitulo) {
		this.nombreTitulo = nombreTitulo;
	}
	public String getEstadoTituloequivalente() {
		return estadoTituloequivalente;
	}
	public void setEstadoTituloequivalente(String estadoTituloequivalente) {
		this.estadoTituloequivalente = estadoTituloequivalente;
	}
	public GppTituloequivalente getTituloequivalente() {
		return tituloequivalente;
	}
	public void setTituloequivalente(GppTituloequivalente tituloequivalente) {
		this.tituloequivalente = tituloequivalente;
	}
	public List getTitulosequivalentes() {
		return titulosequivalentes;
	}
	public void setTitulosequivalentes(List titulosequivalentes) {
		this.titulosequivalentes = titulosequivalentes;
	}
	public int getIdTituloequivalente() {
		return idTituloequivalente;
	}
	public void setIdTituloequivalente(int idTituloequivalente) {
		this.idTituloequivalente = idTituloequivalente;
	}
	public String getControlNavegacion() {
		return controlNavegacion;
	}
	public void setControlNavegacion(String controlNavegacion) {
		this.controlNavegacion = controlNavegacion;
	}

	public void getBuscarTituloequivalentePorNombre() {
		titulosequivalentes = tituloequivalenteDelegate.getTituloequivalentePorNombre(nombreTitulo);
	}
	

	public String getAgregarTituloequivalente() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("TituloequivalenteMB");
		return ConstantesFaces.CREAR_TITULOEQUIVALENTE;
	}	
	
	public String getCrearTituloequivalente() {		
		tituloequivalenteDelegate.getCrearTituloequivalente(nombreTitulo);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("TituloequivalenteMB");
		return ConstantesFaces.HOME_TITULOEQUIVALENTE;
	}
	
	public String getSeleccionarTituloequivalente(){
		tituloequivalente = tituloequivalenteDelegate.getSeleccionarTituloequivalente(idTituloequivalente);
		return ConstantesFaces.DETALLE_TITULOEQUIVALENTE;
	}
	
	public String getModificarTituloequivalente(){
		tituloequivalenteDelegate.getModificarTituloequivalente(tituloequivalente.getTeqNidtituloeq(), tituloequivalente.getTeqVtituloeq());
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("TituloequivalenteMB");
		return ConstantesFaces.HOME_TITULOEQUIVALENTE;
	}
	
	public String getCancelar(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("TituloequivalenteMB");
		return ConstantesFaces.HOME_TITULOEQUIVALENTE;
	}
}