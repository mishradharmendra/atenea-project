package co.com.inascol.atenea.managed.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.richfaces.event.UploadEvent;

import co.com.inascol.atenea.entity.GppFormacion;
import co.com.inascol.atenea.entity.GppInstitucion;
import co.com.inascol.atenea.entity.GppNivelacademico;
import co.com.inascol.atenea.entity.GppPersona;
import co.com.inascol.atenea.entity.GppTituloequivalente;
import co.com.inascol.atenea.managed.bean.delegate.FormacionDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class FormacionMB {

	private FormacionDelegate formacionDelegate;
	private Integer idFormacion;
	private Integer idPersona;
	private List<Object> formacionesAcademicas;
	private GppFormacion formacion;
	private Boolean estadoOperacion;
	private Boolean documentoCargadoDiploma;
	private Boolean documentoCargadoActa;
	
	public FormacionMB(){
		formacionDelegate = new FormacionDelegate();
		formacion = new GppFormacion();
		documentoCargadoDiploma = false;
		documentoCargadoActa = false;
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") != null){
			idPersona = ( (PersonaMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).getPersona().getPerNidpersona();
			formacionesAcademicas = formacionDelegate.getBuscarFormacionesPersona(idPersona);		
		}				
	}
	
	public Integer getIdFormacion() {
		return idFormacion;
	}
	public void setIdFormacion(Integer idFormacion) {
		this.idFormacion = idFormacion;
	}
	public Integer getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}
	public List<Object> getFormacionesAcademicas() {
		return formacionesAcademicas;
	}
	public void setFormacionesAcademicas(List<Object> formacionesAcademicas) {
		this.formacionesAcademicas = formacionesAcademicas;
	}
	public GppFormacion getFormacion() {
		return formacion;
	}
	public void setFormacion(GppFormacion formacion) {
		this.formacion = formacion;
	}
	
	public List<SelectItem> getNivelesAcademicos(){
		List<SelectItem> listadoNivelesAcademicos = new ArrayList<SelectItem>();
		List<Object> nivelesAcademicos = formacionDelegate.getNivelesAcademicos();
		if(nivelesAcademicos.size()>0){
			Iterator<Object> it = nivelesAcademicos.iterator();
			while(it.hasNext()){
				GppNivelacademico gppNivelacademico = (GppNivelacademico) it.next();
				listadoNivelesAcademicos.add(new SelectItem(gppNivelacademico.getNacNidnivelac(),gppNivelacademico.getNacVnivelac()));
			}
        }
		return listadoNivelesAcademicos;
	}	
	
	public List<SelectItem> getInstituciones(){
		List<SelectItem> listadoInstituciones = new ArrayList<SelectItem>();
		List<Object> instituciones = formacionDelegate.getInstituciones();
		if(instituciones.size()>0){
			Iterator<Object> it = instituciones.iterator();
			while(it.hasNext()){
				GppInstitucion gppInstitucion = (GppInstitucion) it.next();
				listadoInstituciones.add(new SelectItem(gppInstitucion.getInsNidinstitucion(),gppInstitucion.getInsVinstitucion()));
			}
        }
		return listadoInstituciones;
	}	
	
	public List<SelectItem> getTitulosEquivalentes(){
		List<SelectItem> listadoTitulosEquivalentes = new ArrayList<SelectItem>();
		List<Object> instituciones = formacionDelegate.getTitulosEquivalentes();
		if(instituciones.size()>0){
			Iterator<Object> it = instituciones.iterator();
			while(it.hasNext()){
				GppTituloequivalente gppTituloequivalente = (GppTituloequivalente) it.next();
				listadoTitulosEquivalentes.add(new SelectItem(gppTituloequivalente.getTeqNidtituloeq(),gppTituloequivalente.getTeqVtituloeq()));
			}
        }
		return listadoTitulosEquivalentes;
	}
	
	public String getAnterior(){
		( ( PersonaMB ) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).setTabPanel(ConstantesFaces.TAB_PANEL_PERSONA);
		return ConstantesFaces.CREAR_HV;
	}
	
	public String getSiguiente(){
		( ( PersonaMB ) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).setTabPanel(ConstantesFaces.TAB_PANEL_EXPERIENCIA);
		return ConstantesFaces.CREAR_HV;
	}
	
	public String getAnteriorDetalle(){
		( ( PersonaMB ) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).setTabPanel(ConstantesFaces.TAB_PANEL_PERSONA);
		return ConstantesFaces.DETALLE_HV;
	}
	
	public String getSiguienteDetalle(){
		( ( PersonaMB ) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).setTabPanel(ConstantesFaces.TAB_PANEL_EXPERIENCIA);
		return ConstantesFaces.DETALLE_HV;
	}
	
	public String getAgregarFormacion(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("FormacionMB");
		setTabPanel();
		setTabPanelFormacionAgregacion();
		return ConstantesFaces.CREAR_HV;
	}
	
	public String getSeleccionarFormacion(){
		formacion = formacionDelegate.getSeleccionarFormacion(formacionesAcademicas, idFormacion);
		setTabPanel();
		setTabPanelFormacionAgregacion();
		return ConstantesFaces.CREAR_HV;
	}
	
	public String getCancelar(){
		setTabPanel();
		setTabPanelFormacionConsulta();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("FormacionMB");
		return ConstantesFaces.CREAR_HV;
	}
	
	public String getGuardarFormacion(){
		getHomePageValueHV();
		setTabPanel();
		setTabPanelFormacionConsulta();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvAgregarHojadeVida")){
			if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") != null){
				idPersona = ( (PersonaMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).getPersona().getPerNidpersona();						
				formacion.setPerNidpersona(idPersona);
				estadoOperacion = formacionDelegate.getGuardarFormacion(formacion);
				getResultadoOperacion(estadoOperacion);
			}
			if(estadoOperacion==true){
				if(documentoCargadoDiploma == true){
					GppPersona persona = ( (PersonaMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).getPersona();
					formacionDelegate.getGuardarDiploma(persona, formacion);
					documentoCargadoDiploma = false;
				}
				if(documentoCargadoActa == true){
					GppPersona persona = ( (PersonaMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).getPersona();
					formacionDelegate.getGuardarActa(persona, formacion);
					documentoCargadoActa = false;
				}
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("FormacionMB");
			} 
			return ConstantesFaces.CREAR_HV;
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}			
	}
	
	public String getBorrarFormacion(){
		getHomePageValueHV();
		setTabPanel();
		setTabPanelFormacionConsulta();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvModificarHojadeVida")){
			estadoOperacion = formacionDelegate.getBorrarFormacion(idFormacion);
			getResultadoOperacion(estadoOperacion);
			if(estadoOperacion==true){	
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("FormacionMB");
			} 
			return ConstantesFaces.CREAR_HV;
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}				
	}
	
	public String getActualizarFormacion(){
		getHomePageValueHV();
		setTabPanel();
		setTabPanelFormacionConsulta();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvModificarHojadeVida")){
			estadoOperacion = formacionDelegate.getActualizarFormacion(formacion);
			getResultadoOperacion(estadoOperacion);
			if(estadoOperacion==true){
				if(documentoCargadoDiploma == true){
					GppPersona persona = ( (PersonaMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).getPersona();
					formacionDelegate.getGuardarDiploma(persona, formacion);
					documentoCargadoDiploma = false;
				}
				if(documentoCargadoActa == true){
					GppPersona persona = ( (PersonaMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).getPersona();
					formacionDelegate.getGuardarActa(persona, formacion);
					documentoCargadoActa = false;
				}
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("FormacionMB");
			} 
			return ConstantesFaces.CREAR_HV;
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}			
	}
	
	public void getSubirDiploma(UploadEvent event) throws IOException {
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") != null){
			GppPersona persona = ( (PersonaMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).getPersona();
			documentoCargadoDiploma = true;
			formacionDelegate.getSubirDiploma(persona, event);
		}
	}
	
	public void getSubirActaGrado(UploadEvent event) throws IOException {
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") != null){
			GppPersona persona = ( (PersonaMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).getPersona();
			documentoCargadoActa = true;
			formacionDelegate.getSubirActaGrado(persona, event);
		}
	}

	public void getSubirSoportesAcademicos(UploadEvent event) throws IOException {
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") != null){
			GppPersona persona = ( (PersonaMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).getPersona();
			formacionDelegate.getSubirSoportesAcademicos(persona, event);
			formacionDelegate.getGuardarSoporte(persona);
		}
	}
		
	public void setTabPanel(){
		( ( PersonaMB ) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).setTabPanel(ConstantesFaces.TAB_PANEL_FORMACION);
	}

	public void setTabPanelFormacionAgregacion(){
		( ( PersonaMB ) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).setTabPanelFormacion(ConstantesFaces.TAB_PANEL_FORMACION_AGREGAR);
	}
	
	public void setTabPanelFormacionConsulta(){
		( ( PersonaMB ) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).setTabPanelFormacion(ConstantesFaces.TAB_PANEL_FORMACION);
	}
	
	public void getHomePageValueHV(){
		((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).setHomePage(ConstantesFaces.CREAR_HV);
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