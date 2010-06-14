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
import co.com.inascol.atenea.entity.GppMunicipio;
import co.com.inascol.atenea.entity.GppNivelacademico;
import co.com.inascol.atenea.entity.GppTituloequivalente;
import co.com.inascol.atenea.managed.bean.delegate.FormacionDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;

public class FormacionMB {

	private FormacionDelegate formacionDelegate;
	private Integer idFormacion;
	private Integer idPersona;
	private List<Object> formacionesAcademicas;
	private GppFormacion formacion;
	
	public FormacionMB(){
		formacionDelegate = new FormacionDelegate();
		formacion = new GppFormacion();		
		formacionesAcademicas = formacionDelegate.getBuscarFormacionesPersona(idPersona);		
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
	
	public String getSeleccionarFormacion(){
		formacion = formacionDelegate.getSeleccionarFormacion(idFormacion);
		return ConstantesFaces.MODIFICAR_FORMACION;
	}
	
	public String getBorrarFormacion(){
		formacionDelegate.getBorrarFormacion(idFormacion);
		return ConstantesFaces.CREAR_HV;
	}

	public String getAgregarFormacion(){
		return ConstantesFaces.CREAR_FORMACION;
	}
	
	public String getGuardarFormacion(){
		idPersona = ( (PersonaMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PersonaMB") ).getIdPersona();		
		formacion.setPerNidpersona(idPersona);
		formacionDelegate.getGuardarFormacion(formacion);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("FormacionMB");
		return ConstantesFaces.CREAR_HV;
	}
	
	public void getSubirDiploma(UploadEvent event) throws IOException {
		formacionDelegate.getSubirDiploma(event);
	}
	
	public void getSubirActaGrado(UploadEvent event) throws IOException {
		formacionDelegate.getSubirActaGrado(event);
	}

	public void getSubirSoportesAcademicos(UploadEvent event) throws IOException {
		formacionDelegate.getSubirSoportesAcademicos(event);
	}
		
	public String getCancelar(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("FormacionMB");
		return ConstantesFaces.CREAR_HV;
	}
}