package co.com.inascol.atenea.managed.bean;

import java.util.List;

import javax.faces.context.FacesContext;

import co.com.inascol.atenea.entity.GppTituloequivalente;
import co.com.inascol.atenea.managed.bean.delegate.TituloequivalenteDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;


public class TituloequivalenteMB {

	private TituloequivalenteDelegate tituloequivalenteDelegate;
	private Integer idTituloequivalente;
	private String nombreTitulo;
	private String estadoTituloequivalente;
	private String controlNavegacion;
	private List<Object> titulosequivalentes;
	private GppTituloequivalente tituloequivalente;
	private Boolean estadoOperacion;
	
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
	public List<Object> getTitulosequivalentes() {
		return titulosequivalentes;
	}
	public void setTitulosequivalentes(List<Object> titulosequivalentes) {
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
		estadoOperacion = false;
		estadoOperacion = tituloequivalenteDelegate.getCrearTituloequivalente(nombreTitulo);
		if(estadoOperacion==true){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("TituloequivalenteMB");
			return ConstantesFaces.ESTADO_TE_OK;
		} else {
			return ConstantesFaces.ESTADO_TE_ERROR;
		}
	}
	
	public String getSeleccionarTituloequivalente(){
		tituloequivalente = tituloequivalenteDelegate.getSeleccionarTituloequivalente(idTituloequivalente);
		return ConstantesFaces.MODIFICAR_TITULOEQUIVALENTE;
	}

	public String getSeleccionarTituloequivalenteDetalle(){
		tituloequivalente = tituloequivalenteDelegate.getSeleccionarTituloequivalente(idTituloequivalente);
		return ConstantesFaces.DETALLE_TITULOEQUIVALENTE;
	}
	
	public String getModificarTituloequivalente(){
		estadoOperacion = false;
		estadoOperacion = tituloequivalenteDelegate.getModificarTituloequivalente(tituloequivalente.getTeqNidtituloeq(), tituloequivalente.getTeqVtituloeq());
		if(estadoOperacion==true){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("TituloequivalenteMB");
			return ConstantesFaces.ESTADO_TE_OK;
		} else {
			return ConstantesFaces.ESTADO_TE_ERROR;
		}
	}
	
	public String getEliminarTituloequivalente(){
		estadoOperacion = false;
		estadoOperacion = tituloequivalenteDelegate.getEliminarTituloequivalente(idTituloequivalente);
		if(estadoOperacion==true){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("TituloequivalenteMB");
			return ConstantesFaces.ESTADO_TE_OK;
		} else {
			return ConstantesFaces.ESTADO_TE_ERROR;
		}
	}
	
	public String getCancelar(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("TituloequivalenteMB");
		return ConstantesFaces.HOME_TITULOEQUIVALENTE;
	}
	
	public String getHomeTituloequivalente(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("TituloequivalenteMB");
		return ConstantesFaces.HOME_TITULOEQUIVALENTE;
	}	
}