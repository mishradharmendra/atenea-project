package co.com.inascol.atenea.managed.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.richfaces.event.UploadEvent;

import co.com.inascol.atenea.entity.GppDepartamento;
import co.com.inascol.atenea.entity.GppEstadocivil;
import co.com.inascol.atenea.entity.GppMunicipio;
import co.com.inascol.atenea.entity.GppPais;
import co.com.inascol.atenea.entity.GppPersona;
import co.com.inascol.atenea.entity.GppTipodoc;
import co.com.inascol.atenea.managed.bean.delegate.PersonaDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;

public class PersonaMB {

	private PersonaDelegate personaDelegate;
	private Integer idPersona;
	private String nombrePersona;
	private String apellidoPersona;
	private String identificacionPersona;
	private String estadoPersona;
	private List<Object> personas;
	private String controlNavegacion;
	private GppPersona persona;
	private List<Object> formacionesAcademicas;
	private List<Object> experienciaLaboral;
	
	public PersonaMB(){
		personaDelegate = new PersonaDelegate();
		persona = new GppPersona();
	}

	public Integer getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}
	public String getNombrePersona() {
		return nombrePersona;
	}
	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}
	public String getApellidoPersona() {
		return apellidoPersona;
	}
	public void setApellidoPersona(String apellidoPersona) {
		this.apellidoPersona = apellidoPersona;
	}
	public List<Object> getPersonas() {
		return personas;
	}
	public void setPersonas(List<Object> personas) {
		this.personas = personas;
	}
	public String getControlNavegacion() {
		return controlNavegacion;
	}
	public void setControlNavegacion(String controlNavegacion) {
		this.controlNavegacion = controlNavegacion;
	}
	public GppPersona getPersona() {
		return persona;
	}
	public void setPersona(GppPersona persona) {
		this.persona = persona;
	}
	public String getIdentificacionPersona() {
		return identificacionPersona;
	}
	public void setIdentificacionPersona(String identificacionPersona) {
		this.identificacionPersona = identificacionPersona;
	}
	public String getEstadoPersona() {
		return estadoPersona;
	}
	public void setEstadoPersona(String estadoPersona) {
		this.estadoPersona = estadoPersona;
	}	
	public List<Object> getFormacionesAcademicas() {
		return formacionesAcademicas;
	}
	public void setFormacionesAcademicas(List<Object> formacionesAcademicas) {
		this.formacionesAcademicas = formacionesAcademicas;
	}
	public List<Object> getExperienciaLaboral() {
		return experienciaLaboral;
	}
	public void setExperienciaLaboral(List<Object> experienciaLaboral) {
		this.experienciaLaboral = experienciaLaboral;
	}

	public List<SelectItem> getTiposIdentificacion(){
		List<SelectItem> listadoTipos = new ArrayList<SelectItem>();
		List<Object> tiposIdentificacion = personaDelegate.getListaTipoIndentificacion();
		if(tiposIdentificacion.size()>0){
			Iterator<Object> it = tiposIdentificacion.iterator();
			while(it.hasNext()){
				GppTipodoc gTipodoc = (GppTipodoc) it.next();
				listadoTipos.add(new SelectItem(gTipodoc.getTdcNidtipodoc(),gTipodoc.getTdcVnombre()));
			}
        }
		return listadoTipos;
	}	
	
	public List<SelectItem> getEstadosCiviles(){
		List<SelectItem> listadoEstadosCiviles = new ArrayList<SelectItem>();
		List<Object> estadosCivilces = personaDelegate.getListaEstadosCiviles();
		if(estadosCivilces.size()>0){
			Iterator<Object> it = estadosCivilces.iterator();
			while(it.hasNext()){
				GppEstadocivil gppEstadocivil = (GppEstadocivil) it.next();
				listadoEstadosCiviles.add(new SelectItem(gppEstadocivil.getEscNidestadocivil(),gppEstadocivil.getEscVestadocivil()));
			}
        }
		return listadoEstadosCiviles;
	}	
	
	public List<SelectItem> getMunicipios(){
		List<SelectItem> listadoMunicipios = new ArrayList<SelectItem>();
		List<Object> mpios = personaDelegate.getListaMunicipios();
		if(mpios.size()>0){
			Iterator<Object> it = mpios.iterator();
			while(it.hasNext()){
				GppMunicipio gppMunicipio = (GppMunicipio) it.next();
				listadoMunicipios.add(new SelectItem(gppMunicipio.getMunVidmunicipio(),gppMunicipio.getMunVmunicipio()));
			}
        }
		return listadoMunicipios;
	}		
	
	public String getBuscarPersona(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PersonaMB");
		return ConstantesFaces.HOME_HV;
	}
	
	public String getBusquedaAvanzada(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PersonaMB");
		return ConstantesFaces.HOME_HV;
	}
	
	public String getAgregarHojaVida(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PersonaMB");		
		return ConstantesFaces.CREAR_HV;
	}

    public void getSubirDocumentoHojaVida(UploadEvent event) throws IOException {
    	personaDelegate.getSubirDocumentoHojaVida(event);
    }
		
	public String getGuardarPersona(){
		personaDelegate.getGuardarPersona(persona);
		idPersona = ( (GppPersona) personaDelegate.getBuscarPersonaPorCedula(persona.getPerNidentificacion()) ).getPerNidpersona();
		return ConstantesFaces.CREAR_HV;
	}
}