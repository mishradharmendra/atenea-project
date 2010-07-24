package co.com.inascol.atenea.managed.bean;

import java.util.List;

import javax.faces.context.FacesContext;

import co.com.inascol.atenea.entity.GppPerfilequivalente;
import co.com.inascol.atenea.managed.bean.delegate.PerfilequivalenteDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;


public class PerfilequivalenteMB {

	private PerfilequivalenteDelegate perfilequivalenteDelegate;
	private Integer idPerfilequivalente;
	private String nombrePerfil;
	private String estadoPerfilequivalente;
	private String controlNavegacion;
	private List<Object> perfilesequivalentes;
	private GppPerfilequivalente perfilequivalente;
	private Boolean estadoOperacion;
	
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
	public List<Object> getPerfilesequivalentes() {
		return perfilesequivalentes;
	}
	public void setPerfilesequivalentes(List<Object> perfilesequivalentes) {
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
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvAgregarPerfilEquivalente")){
			estadoOperacion = perfilequivalenteDelegate.getCrearPerfilequivalente(nombrePerfil);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PerfilequivalenteMB");
				return ConstantesFaces.ESTADO_OK;
			}else{
				return ConstantesFaces.ESTADO_ERROR;	
			}
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}				
	}
	
	public String getSeleccionarPerfilequivalente(){
		perfilequivalente = perfilequivalenteDelegate.getSeleccionarPerfilequivalente(idPerfilequivalente);
		return ConstantesFaces.MODIFICAR_PERFILEQUIVALENTE;
	}

	public String getSeleccionarPerfilequivalenteDetalle(){
		perfilequivalente = perfilequivalenteDelegate.getSeleccionarPerfilequivalente(idPerfilequivalente);
		return ConstantesFaces.DETALLE_PERFILEQUIVALENTE;
	}
	
	public String getModificarPerfilequivalente(){
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvModificarPerfilEquivalente")){
			estadoOperacion = perfilequivalenteDelegate.getModificarPerfilequivalente(perfilequivalente.getPeqNidperfileq(), perfilequivalente.getPeqVperfileq());
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PerfilequivalenteMB");
				return ConstantesFaces.ESTADO_OK;
			}else{
				return ConstantesFaces.ESTADO_ERROR;	
			}
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}				
	}
	
	public String getEliminarPerfilequivalente(){
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvEliminarPerfilEquivalente")){
			estadoOperacion = perfilequivalenteDelegate.getEliminarPerfilequivalente(idPerfilequivalente);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PerfilequivalenteMB");
				return ConstantesFaces.ESTADO_OK;
			}else{
				return ConstantesFaces.ESTADO_ERROR;	
			}
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}				
	}
	
	public String getCancelar(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PerfilequivalenteMB");
		return ConstantesFaces.HOME_PERFILEQUIVALENTE;
	}
	
	public String getHomePerfilequivalente(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PerfilequivalenteMB");
		return ConstantesFaces.HOME_PERFILEQUIVALENTE;
	}
	
	public void getHomePageValue(){
		((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).setHomePage(ConstantesFaces.HOME_PERFILEQUIVALENTE);
	}
	
	public Boolean getValidarPermisosServicio(String nombreServicio){
		return ((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).validarPermisosServicio(nombreServicio);
	}
}