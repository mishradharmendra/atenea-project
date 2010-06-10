package co.com.inascol.atenea.managed.bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import co.com.inascol.atenea.entity.GppTipoarchivo;
import co.com.inascol.atenea.managed.bean.delegate.TipoarchivoDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;


public class TipoarchivoMB {

	private TipoarchivoDelegate tipoarchivoDelegate;
	private int idTipoarchivo;
	private String nombreTipoarchivo;
	private String estadoTipoarchivo;
	private String controlNavegacion;
	private List tipoarchivos;
	private GppTipoarchivo tipoarchivo;
	
	public TipoarchivoMB(){
		tipoarchivoDelegate = new TipoarchivoDelegate();
		tipoarchivos = tipoarchivoDelegate.getListaTipoarchivos();
	}
	
	public String getNombreTipoarchivo() {
		return nombreTipoarchivo;
	}
	public void setNombreTipoarchivo(String nombreTipoarchivo) {
		this.nombreTipoarchivo = nombreTipoarchivo;
	}
	public String getEstadoTipoarchivo() {
		return estadoTipoarchivo;
	}
	public void setEstadoTipoarchivo(String estadoTipoarchivo) {
		this.estadoTipoarchivo = estadoTipoarchivo;
	}
	public GppTipoarchivo getTipoarchivo() {
		return tipoarchivo;
	}
	public void setTipoarchivo(GppTipoarchivo tipoarchivo) {
		this.tipoarchivo = tipoarchivo;
	}
	public List getTipoarchivos() {
		return tipoarchivos;
	}
	public void setTipoarchivos(List tipoarchivos) {
		this.tipoarchivos = tipoarchivos;
	}
	public int getIdTipoarchivo() {
		return idTipoarchivo;
	}
	public void setIdTipoarchivo(int idTipoarchivo) {
		this.idTipoarchivo = idTipoarchivo;
	}
	public String getControlNavegacion() {
		return controlNavegacion;
	}
	public void setControlNavegacion(String controlNavegacion) {
		this.controlNavegacion = controlNavegacion;
	}

	public void getBuscarTipoarchivoPorNombre() {
		tipoarchivos = tipoarchivoDelegate.getTipoarchivoPorNombre(nombreTipoarchivo);
	}
	

	public String getAgregarTipoarchivo() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("TipoarchivoMB");
		return ConstantesFaces.CREAR_TIPOARCHIVO;
	}	
	
	public String getCrearTipoarchivo() {		
		tipoarchivoDelegate.getCrearTipoarchivo(nombreTipoarchivo);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("TipoarchivoMB");
		return ConstantesFaces.HOME_TIPOARCHIVO;
	}
	
	public String getSeleccionarTipoarchivo(){
		tipoarchivo = tipoarchivoDelegate.getSeleccionarTipoarchivo(idTipoarchivo);
		return ConstantesFaces.DETALLE_TIPOARCHIVO;
	}
	
	public String getModificarTipoarchivo(){
		tipoarchivoDelegate.getModificarTipoarchivo(tipoarchivo.getTarNidtipoarchivo(), tipoarchivo.getTarVtipoarchivo());
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("TipoarchivoMB");
		return ConstantesFaces.HOME_TIPOARCHIVO;
	}
	
	public String getCancelar(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("TipoarchivoMB");
		return ConstantesFaces.HOME_TIPOARCHIVO;
	}
}