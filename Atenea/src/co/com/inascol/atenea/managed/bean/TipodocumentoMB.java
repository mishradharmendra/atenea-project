package co.com.inascol.atenea.managed.bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import co.com.inascol.atenea.entity.GppTipodoc;
import co.com.inascol.atenea.managed.bean.delegate.TipodocumentoDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;


public class TipodocumentoMB {

	private TipodocumentoDelegate tipodocDelegate;
	private int idTipodoc;
	private String nombreTipodoc;
	private String estadoTipodoc;
	private String controlNavegacion;
	private List tipodocs;
	private GppTipodoc tipodoc;
	
	public TipodocumentoMB(){
		tipodocDelegate = new TipodocumentoDelegate();
		tipodocs = tipodocDelegate.getListaTipodocs();
	}
	
	public String getNombreTipodoc() {
		return nombreTipodoc;
	}
	public void setNombreTipodoc(String nombreTipodoc) {
		this.nombreTipodoc = nombreTipodoc;
	}
	public String getEstadoTipodoc() {
		return estadoTipodoc;
	}
	public void setEstadoTipodoc(String estadoTipodoc) {
		this.estadoTipodoc = estadoTipodoc;
	}
	public GppTipodoc getTipodoc() {
		return tipodoc;
	}
	public void setTipodocumento(GppTipodoc tipodoc) {
		this.tipodoc = tipodoc;
	}
	public List getTipodocs() {
		return tipodocs;
	}
	public void setTipodocs(List tipodocs) {
		this.tipodocs = tipodocs;
	}
	public int getIdTipodoc() {
		return idTipodoc;
	}
	public void setIdTipodoc(int idTipodoc) {
		this.idTipodoc = idTipodoc;
	}
	public String getControlNavegacion() {
		return controlNavegacion;
	}
	public void setControlNavegacion(String controlNavegacion) {
		this.controlNavegacion = controlNavegacion;
	}

	public void getBuscarTipodocPorNombre() {
		tipodocs = tipodocDelegate.getTipodocPorNombre(nombreTipodoc);
	}
	

	public String getAgregarTipodoc() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("TipodocumentoMB");
		return ConstantesFaces.CREAR_TIPODOCUMENTO;
	}	
	
	public String getCrearTipodoc() {		
		tipodocDelegate.getCrearTipodocumento(nombreTipodoc);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("TipodocumentoMB");
		return ConstantesFaces.HOME_TIPODOCUMENTO;
	}
	
	public String getSeleccionarTipodoc(){
		tipodoc = tipodocDelegate.getSeleccionarTipodocumento(idTipodoc);
		return ConstantesFaces.DETALLE_TIPODOCUMENTO;
	}
	
	public String getModificarTipodoc(){
		tipodocDelegate.getModificarTipodocumento(tipodoc.getTdcNidtipodoc(), tipodoc.getTdcVnombre());
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("TipodocumentoMB");
		return ConstantesFaces.HOME_TIPODOCUMENTO;
	}
	
	public String getCancelar(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("TipodocumentoMB");
		return ConstantesFaces.HOME_TIPODOCUMENTO;
	}
}