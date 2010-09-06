package co.com.inascol.atenea.managed.bean;

import java.util.List;

import javax.faces.context.FacesContext;

import co.com.inascol.atenea.entity.GppIdioma;
import co.com.inascol.atenea.managed.bean.delegate.IdiomaDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcción de Software
 * Esp. Sistemas de Información Geográfica
 * Ing. Catastral y Geodesta
 */
public class IdiomaMB {

	private IdiomaDelegate idiomaDelegate;
	private Integer idIdioma;
	private String nombreIdioma;
	private String estadoIdioma;
	private String controlNavegacion;
	private List<Object> idiomas;
	private GppIdioma idioma;
	private Boolean estadoOperacion;
	
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
	public List<Object> getIdiomas() {
		return idiomas;
	}
	public void setIdiomas(List<Object> idiomas) {
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
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvAgregarIdioma")){
			estadoOperacion = idiomaDelegate.getCrearIdioma(nombreIdioma);
			getResultadoOperacion(estadoOperacion);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("IdiomaMB");
			}
			return ConstantesFaces.HOME_IDIOMA;
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}			
	}
	
	public String getSeleccionarIdioma(){
		idioma = idiomaDelegate.getSeleccionarIdioma(idIdioma);
		return ConstantesFaces.MODIFICAR_IDIOMA;
	}
	
	public String getSeleccionarIdiomaDetalle(){
		idioma = idiomaDelegate.getSeleccionarIdioma(idIdioma);
		return ConstantesFaces.DETALLE_IDIOMA;
	}
	
	public String getModificarIdioma(){
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvModificarIdioma")){
			estadoOperacion = idiomaDelegate.getModificarIdioma(idioma.getIdiNididioma(), idioma.getIdiVidioma());
			getResultadoOperacion(estadoOperacion);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("IdiomaMB");
			}
			return ConstantesFaces.HOME_IDIOMA;
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}				
	}
	
	public String getEliminarIdioma(){
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvEliminarIdioma")){
			estadoOperacion = idiomaDelegate.getEliminarIdioma(idIdioma);
			getResultadoOperacion(estadoOperacion);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("IdiomaMB");
			}
			return ConstantesFaces.HOME_IDIOMA;
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}				
	}
	
	public String getCancelar(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("IdiomaMB");
		return ConstantesFaces.HOME_IDIOMA;
	}
	
	public String getHomeIdioma(){
		getMenuSeleccionado();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("IdiomaMB");
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PersonaMB");
		return ConstantesFaces.HOME_IDIOMA;
	}
	
	public void getHomePageValue(){
		((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).setHomePage(ConstantesFaces.HOME_IDIOMA);
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