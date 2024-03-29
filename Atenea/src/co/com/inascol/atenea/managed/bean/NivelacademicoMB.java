package co.com.inascol.atenea.managed.bean;

import java.util.List;

import javax.faces.context.FacesContext;

import co.com.inascol.atenea.entity.GppNivelacademico;
import co.com.inascol.atenea.managed.bean.delegate.NivelacademicoDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class NivelacademicoMB {

	private NivelacademicoDelegate nivelacademicoDelegate;
	private Integer idNivelacademico;
	private String nombreNivelacademico;
	private String estadoNivelacademico;
	private String controlNavegacion;
	private List<Object> nivelesacademicos;
	private GppNivelacademico nivelacademico;
	private Boolean estadoOperacion;
	
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
	public List<Object> getNivelesacademicos() {
		return nivelesacademicos;
	}
	public void setNivelesacademicos(List<Object> nivelesacademicos) {
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
	public Boolean getEstadoOperacion() {
		return estadoOperacion;
	}
	public void setEstadoOperacion(Boolean estadoOperacion) {
		this.estadoOperacion = estadoOperacion;
	}
	public void setIdNivelacademico(Integer idNivelacademico) {
		this.idNivelacademico = idNivelacademico;
	}

	public void getBuscarNivelacademicoPorNombre() {
		nivelesacademicos = nivelacademicoDelegate.getNivelacademicoPorNombre(nombreNivelacademico);
	}
	
	public String getAgregarNivelacademico() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("NivelacademicoMB");
		return ConstantesFaces.CREAR_NIVELACADEMICO;
	}	
	
	public String getCrearNivelacademico() {	
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvAgregarNivelesAcademicos")){
			estadoOperacion = nivelacademicoDelegate.getCrearNivelacademico(nombreNivelacademico);
			getResultadoOperacion(estadoOperacion);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("NivelacademicoMB");
			}
			return ConstantesFaces.HOME_NIVELACADEMICO;
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}			
	}
	
	public String getSeleccionarNivelacademico(){
		nivelacademico = nivelacademicoDelegate.getSeleccionarNivelacademico(idNivelacademico);
		return ConstantesFaces.MODIFICAR_NIVELACADEMICO;
	}
	
	public String getSeleccionarNivelacademicoDetalle(){
		nivelacademico = nivelacademicoDelegate.getSeleccionarNivelacademico(idNivelacademico);
		return ConstantesFaces.DETALLE_NIVELACADEMICO;
	}
	
	public String getModificarNivelacademico(){
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvModificarNivelesAcademicos")){
			estadoOperacion = nivelacademicoDelegate.getModificarNivelacademico(nivelacademico.getNacNidnivelac(), nivelacademico.getNacVnivelac());
			getResultadoOperacion(estadoOperacion);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("NivelacademicoMB");
			}
			return ConstantesFaces.HOME_NIVELACADEMICO;
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}			
	}
	
	public String getEliminarNivelacademico(){
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvEliminarNivelesAcademicos")){
			estadoOperacion = nivelacademicoDelegate.getEliminarNivelacademico(idNivelacademico);
			getResultadoOperacion(estadoOperacion);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("NivelacademicoMB");
			}
			return ConstantesFaces.HOME_NIVELACADEMICO;
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}			
	}
	
	public String getCancelar(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("NivelacademicoMB");
		return ConstantesFaces.HOME_NIVELACADEMICO;
	}
	
	public String getHomeNivelacademico(){
		getMenuSeleccionado();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("NivelacademicoMB");
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PersonaMB");
		return ConstantesFaces.HOME_NIVELACADEMICO;
	}
	
	public void getHomePageValue(){
		((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).setHomePage(ConstantesFaces.HOME_NIVELACADEMICO);
	}

	public void getMenuSeleccionado(){
		((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).setMenuSeleccionado(ConstantesFaces.MENU_ADMINISTRACION);		
	}

	public void getResultadoOperacion(Boolean resultadoOperacion){
		if(resultadoOperacion==true)
			((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).setResultadoOperacion("OK");
		else
			((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).setResultadoOperacion("ERROR");
		((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).setOperacionBD("BD");
	}
	
	public Boolean getValidarPermisosServicio(String nombreServicio){
		return ((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).validarPermisosServicio(nombreServicio);
	}
}