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
	
	public List<SelectItem> getDuraciones(){
		List<SelectItem> listadoDuraciones = new ArrayList<SelectItem>();
		for (int i = 1; i <= 20; i++) {
			listadoDuraciones.add(new SelectItem(i));
		}		
		return listadoDuraciones;
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
		return ConstantesFaces.CREAR_FORMACION;
	}
	
	public String getSeleccionarFormacion(){
		formacion = formacionDelegate.getSeleccionarFormacion(formacionesAcademicas, idFormacion);
		return ConstantesFaces.MODIFICAR_FORMACION;
	}
	
	public String getCancelar(){
		setTabPanel();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("FormacionMB");
		return ConstantesFaces.CREAR_HV;
	}
	
	public String getGuardarFormacion(){
		setTabPanel();
		estadoOperacion = false;
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") != null){
			idPersona = ( (PersonaMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).getPersona().getPerNidpersona();						
			formacion.setPerNidpersona(idPersona);
			estadoOperacion = formacionDelegate.getGuardarFormacion(formacion);
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
			return ConstantesFaces.ESTADO_OK;
		} else {
			return ConstantesFaces.ESTADO_ERROR;
		}	
	}
	
	public String getBorrarFormacion(){
		setTabPanel();
		estadoOperacion = false;
		estadoOperacion = formacionDelegate.getBorrarFormacion(idFormacion);
		if(estadoOperacion==true){	
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("FormacionMB");
			return ConstantesFaces.ESTADO_OK;
		} else {
			return ConstantesFaces.ESTADO_ERROR;
		}
	}
	
	public String getActualizarFormacion(){
		setTabPanel();
		estadoOperacion = false;			
		estadoOperacion = formacionDelegate.getActualizarFormacion(formacion);
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
			return ConstantesFaces.ESTADO_OK;
		} else {
			return ConstantesFaces.ESTADO_ERROR;
		}				
	}
	
	public void getSubirDiploma(UploadEvent event) throws IOException {
		documentoCargadoDiploma = true;
		formacionDelegate.getSubirDiploma(event);
	}
	
	public void getSubirActaGrado(UploadEvent event) throws IOException {
		documentoCargadoActa = true;
		formacionDelegate.getSubirActaGrado(event);
	}

	public void getSubirSoportesAcademicos(UploadEvent event) throws IOException {
		formacionDelegate.getSubirSoportesAcademicos(event);
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") != null){
			GppPersona persona = ( (PersonaMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).getPersona();
			formacionDelegate.getGuardarSoporte(persona);
		}
	}
		
	public void setTabPanel(){
		( ( PersonaMB ) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).setTabPanel(ConstantesFaces.TAB_PANEL_FORMACION);
	}
}