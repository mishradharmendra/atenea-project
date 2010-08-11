package co.com.inascol.atenea.managed.bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import co.com.inascol.atenea.entity.GppIdioma;
import co.com.inascol.atenea.entity.GppPerfilequivalente;
import co.com.inascol.atenea.entity.GppPerfilprof;
import co.com.inascol.atenea.managed.bean.delegate.PerfilprofesionalDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;
/**
 * @author Guillermo Toro
 *
 */
public class PerfilprofesionalMB {

	private PerfilprofesionalDelegate perfilprofesionalDelegate;
	private Integer idPerfilProfesional;
	private Integer idPersona;
	private GppPerfilprof perfilProfesional;
	private List<Object> perfilesProfesionales;
	private Boolean estadoOperacion;
	
	public PerfilprofesionalMB(){
		perfilprofesionalDelegate = new PerfilprofesionalDelegate();
		perfilProfesional = new GppPerfilprof();
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") != null){
			idPersona = ( (PersonaMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).getPersona().getPerNidpersona();
			perfilesProfesionales = perfilprofesionalDelegate.getBuscarPerfilesProfesionalesPersona(idPersona);
			if(perfilesProfesionales.size()==1){
				perfilProfesional = (GppPerfilprof) perfilesProfesionales.get(0);	
			}
		}			
	}

	public Integer getIdPerfilProfesional() {
		return idPerfilProfesional;
	}
	public void setIdPerfilProfesional(Integer idPerfilProfesional) {
		this.idPerfilProfesional = idPerfilProfesional;
	}
	public Integer getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}
	public GppPerfilprof getPerfilProfesional() {
		return perfilProfesional;
	}
	public void setPerfilProfesional(GppPerfilprof perfilProfesional) {
		this.perfilProfesional = perfilProfesional;
	}	
	public void setPerfilesProfesionales(List<Object> perfilesProfesionales) {
		this.perfilesProfesionales = perfilesProfesionales;
	}
	
	public List<SelectItem> getPerfilesProfesionales(){
		List<SelectItem> listadoPerfilesProfesionales = new ArrayList<SelectItem>();
		List<Object> perfilesEquivalente = perfilprofesionalDelegate.getPerfilesProfesionalesEquivalente();
		if(perfilesEquivalente.size()>0){
			Iterator<Object> it = perfilesEquivalente.iterator();
			while(it.hasNext()){
				GppPerfilequivalente gppPerfilequivalente = (GppPerfilequivalente) it.next();
				listadoPerfilesProfesionales.add(new SelectItem(gppPerfilequivalente.getPeqNidperfileq(),gppPerfilequivalente.getPeqVperfileq()));
			}
        }
		return listadoPerfilesProfesionales;
	}	

	public List<SelectItem> getIdiomas(){
		List<SelectItem> listadoIdiomas  = new ArrayList<SelectItem>();
		List<Object> idiomas = perfilprofesionalDelegate.getIdiomas();
		if(idiomas.size()>0){
			Iterator<Object> it = idiomas.iterator();
			while(it.hasNext()){
				GppIdioma gppIdioma = (GppIdioma) it.next();
				listadoIdiomas.add(new SelectItem(gppIdioma.getIdiNididioma(),gppIdioma.getIdiVidioma()));
			}
        }
		return listadoIdiomas;
	}
	
	public String getAnterior(){
		( ( PersonaMB ) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).setTabPanel(ConstantesFaces.TAB_PANEL_EXPERIENCIA);
		return ConstantesFaces.CREAR_HV;
	}
	
	public String getSiguiente(){
		( ( PersonaMB ) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).setTabPanel(ConstantesFaces.TAB_PANEL_SOPORTES);
		return ConstantesFaces.CREAR_HV;
	}
	
	public String getAnteriorDetalle(){
		( ( PersonaMB ) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).setTabPanel(ConstantesFaces.TAB_PANEL_EXPERIENCIA);
		return ConstantesFaces.DETALLE_HV;
	}
	
	public String getSiguienteDetalle(){
		( ( PersonaMB ) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).setTabPanel(ConstantesFaces.TAB_PANEL_SOPORTES);
		return ConstantesFaces.DETALLE_HV;
	}
	public String getGuardarPerfil(){
		getHomePageValueHV();
		setTabPanel();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvAgregarPerfilProfesional")){
			if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") != null){
				idPersona = ( (PersonaMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).getPersona().getPerNidpersona();
				perfilProfesional.setPerNidpersona(idPersona);
				estadoOperacion = perfilprofesionalDelegate.getGuardarPerfil(perfilProfesional);
			}
			if(estadoOperacion==true){
				perfilesProfesionales = perfilprofesionalDelegate.getBuscarPerfilesProfesionalesPersona(idPersona);
				if(perfilesProfesionales.size()==1){
					perfilProfesional = (GppPerfilprof) perfilesProfesionales.get(0);	
				}			
				return ConstantesFaces.ESTADO_OK;
			} else {
				return ConstantesFaces.ESTADO_ERROR;
			}
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}			
	}
	
	public String getActualizarPerfil(){
		getHomePageValueHV();
		setTabPanel();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvModificarPerfilProfesional")){			
			estadoOperacion = perfilprofesionalDelegate.getActualizarPerfil(perfilProfesional);
			if(estadoOperacion==true){		
				return ConstantesFaces.ESTADO_OK;
			} else {
				return ConstantesFaces.ESTADO_ERROR;
			}	
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}		
	}
	
	public void setTabPanel(){
		( ( PersonaMB ) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).setTabPanel(ConstantesFaces.TAB_PANEL_PERFIL);
	}
	
	public void getHomePageValueHV(){
		((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).setHomePage(ConstantesFaces.CREAR_HV);
	}
	
	public Boolean getValidarPermisosServicio(String nombreServicio){
		return ((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).validarPermisosServicio(nombreServicio);
	}
}