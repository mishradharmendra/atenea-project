package co.com.inascol.atenea.managed.bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import co.com.inascol.atenea.entity.GppNivelacademico;
import co.com.inascol.atenea.managed.bean.delegate.NivelacademicoDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;


public class NivelacademicoMB {

	private NivelacademicoDelegate nivelacademicoDelegate;
	private int idNivelacademico;
	private String nombreNivelacademico;
	private String estadoNivelacademico;
	private String controlNavegacion;
	private List nivelesacademicos;
	private GppNivelacademico nivelacademico;
	
	public NivelacademicoMB(){
		nivelacademicoDelegate = new NivelacademicoDelegate();
		nivelesacademicos = nivelacademicoDelegate.getListaNivelacademicos();
	}
	
	public String getNombreNivelacademico() {
		return nombreNivelacademico;
	}
	public void setNombreNivelacademico(String nombreNivelacademico) {
		this.nombreNivelacademico = nombreNivelacademico;
	}
	public String getEstadoNivelacademico() {
		return estadoNivelacademico;
	}
	public void setEstadoNivelacademico(String estadoNivelacademico) {
		this.estadoNivelacademico = estadoNivelacademico;
	}
	public GppNivelacademico getNivelacademico() {
		return nivelacademico;
	}
	public void setNivelacademico(GppNivelacademico nivelacademico) {
		this.nivelacademico = nivelacademico;
	}
	public List getNivelesacademicos() {
		return nivelesacademicos;
	}
	public void setNivelesacademicos(List nivelesacademicos) {
		this.nivelesacademicos = nivelesacademicos;
	}
	public int getIdNivelacademico() {
		return idNivelacademico;
	}
	public void setIdNivelacademico(int idNivelacademico) {
		this.idNivelacademico = idNivelacademico;
	}
	public String getControlNavegacion() {
		return controlNavegacion;
	}
	public void setControlNavegacion(String controlNavegacion) {
		this.controlNavegacion = controlNavegacion;
	}

	public void getBuscarNivelacademicoPorNombre() {
		nivelesacademicos = nivelacademicoDelegate.getNivelacademicoPorNombre(nombreNivelacademico);
	}
	

	public String getAgregarNivelacademico() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("NivelacademicoMB");
		return ConstantesFaces.CREAR_NIVELACADEMICO;
	}	
	
	public String getCrearNivelacademico() {		
		nivelacademicoDelegate.getCrearNivelacademico(nombreNivelacademico);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("NivelacademicoMB");
		return ConstantesFaces.HOME_NIVELACADEMICO;
	}
	
	public String getSeleccionarNivelacademico(){
		nivelacademico = nivelacademicoDelegate.getSeleccionarNivelacademico(idNivelacademico);
		return ConstantesFaces.DETALLE_NIVELACADEMICO;
	}
	
	public String getModificarNivelacademico(){
		nivelacademicoDelegate.getModificarNivelacademico(nivelacademico.getNacNidnivelac(), nivelacademico.getNacVnivelac());
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("NivelacademicoMB");
		return ConstantesFaces.HOME_NIVELACADEMICO;
	}
	
	public String getCancelar(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("NivelacademicoMB");
		return ConstantesFaces.HOME_NIVELACADEMICO;
	}
	
	public String getHomeNivelacademico(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("NivelacademicoMB");
		return ConstantesFaces.HOME_NIVELACADEMICO;
	}
}