package co.com.inascol.atenea.managed.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
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
	private List<Object> personas;
	private String controlNavegacion;
	private GppPersona persona;
	private List<Object> formacionesAcademicas;
	private List<Object> experienciaLaboral;
	private Boolean estadoOperacion;
	private String tabPanel;
	private Integer idPais;
	private Integer idDepto;	
	private Boolean tabDeshabilitados;
	private Boolean documentoCargado;
	private Boolean estadoPersona;
	
	public PersonaMB(){
		personaDelegate = new PersonaDelegate();		
		persona = new GppPersona();
		tabDeshabilitados = true;
		documentoCargado = false;
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
	public String getTabPanel() {
		return tabPanel;
	}
	public void setTabPanel(String tabPanel) {
		this.tabPanel = tabPanel;
	}
	public Boolean getTabDeshabilitados() {
		return tabDeshabilitados;
	}
	public void setTabDeshabilitados(Boolean tabDeshabilitados) {
		this.tabDeshabilitados = tabDeshabilitados;
	}
	public Boolean getEstadoPersona() {
		return estadoPersona;
	}
	public void setEstadoPersona(Boolean estadoPersona) {
		this.estadoPersona = estadoPersona;
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
		List<Object> estadosCiviles = personaDelegate.getListaEstadosCiviles();
		if(estadosCiviles.size()>0){
			Iterator<Object> it = estadosCiviles.iterator();
			while(it.hasNext()){
				GppEstadocivil gppEstadocivil = (GppEstadocivil) it.next();
				listadoEstadosCiviles.add(new SelectItem(gppEstadocivil.getEscNidestadocivil(),gppEstadocivil.getEscVestadocivil()));
			}
        }
		return listadoEstadosCiviles;
	}	
	
	public List<SelectItem> getPaises(){
		List<SelectItem> listadoPaises = new ArrayList<SelectItem>();
		List<Object> paises = personaDelegate.getListaPaises();
		if(paises.size()>0){
			Iterator<Object> it = paises.iterator();
			while(it.hasNext()){
				GppPais gppPais= (GppPais) it.next();
				listadoPaises.add(new SelectItem(gppPais.getPaiNidpais(),gppPais.getPaiVpais()));
			}
        }
		return listadoPaises;
	}
	
	public List<SelectItem> getDepartamentosPais(){
		List<SelectItem> listadoDepartamentos = new ArrayList<SelectItem>();		
		if(idPais!=null){
			List<Object> deptos = personaDelegate.getListaDepartamentos();
			if(deptos.size()>0){
				Iterator<Object> it = deptos.iterator();
				while(it.hasNext()){
					GppDepartamento gppDepartamento = (GppDepartamento) it.next();
					if(gppDepartamento.getPaiNidpais()==idPais){
						listadoDepartamentos.add(new SelectItem(gppDepartamento.getDptNiddepto(),gppDepartamento.getDptVdepto()));
					}
				}
	        }
		}
		return listadoDepartamentos;
	}
	
	public List<SelectItem> getMunicipiosDepto(){
		List<SelectItem> listadoMunicipios = new ArrayList<SelectItem>();
		if(idPais!=null && idDepto!=null){
			List<Object> mpios = personaDelegate.getListaMunicipios();
			if(mpios.size()>0){
				Iterator<Object> it = mpios.iterator();
				while(it.hasNext()){
					GppMunicipio gppMunicipio = (GppMunicipio) it.next();
					if(gppMunicipio.getDptNiddepto()==idDepto){
						listadoMunicipios.add(new SelectItem(gppMunicipio.getMunNidmunicipio(),gppMunicipio.getMunVmunicipio()));
					}
				}
	        }
		}
		return listadoMunicipios;
	}		

	public List<SelectItem> getMunicipios(){
		List<SelectItem> listadoMunicipios = new ArrayList<SelectItem>();
		if(idPais!=null && idDepto!=null){
			List<Object> mpios = personaDelegate.getListaMunicipios();
			if(mpios.size()>0){
				Iterator<Object> it = mpios.iterator();
				while(it.hasNext()){
					GppMunicipio gppMunicipio = (GppMunicipio) it.next();
					if(gppMunicipio.getDptNiddepto()==idDepto){
						listadoMunicipios.add(new SelectItem(gppMunicipio.getMunNidmunicipio(),gppMunicipio.getMunVmunicipio()));
					}
				}
	        }
		}
		else{
			List<Object> mpios = personaDelegate.getListaMunicipios();
			if(mpios.size()>0){
				Iterator<Object> it = mpios.iterator();
				while(it.hasNext()){
					GppMunicipio gppMunicipio = (GppMunicipio) it.next();
					listadoMunicipios.add(new SelectItem(gppMunicipio.getMunNidmunicipio(),gppMunicipio.getMunVmunicipio()));
		        }
			}
		}
		return listadoMunicipios;
	}		
	
	public List<SelectItem> getMunicipiosResidencia(){
		List<SelectItem> listadoMunicipios = new ArrayList<SelectItem>();
		List<Object> mpios = personaDelegate.getListaMunicipios();
		if(mpios.size()>0){
			Iterator<Object> it = mpios.iterator();
			while(it.hasNext()){
				GppMunicipio gppMunicipio = (GppMunicipio) it.next();
				listadoMunicipios.add(new SelectItem(gppMunicipio.getMunNidmunicipio(),gppMunicipio.getMunVmunicipio()));
	        }
		}
		return listadoMunicipios;
	}
	
	public void getDeptos(ValueChangeEvent evento){
		idPais = Integer.valueOf((String) evento.getNewValue());
		getDepartamentosPais();
	}
	
	public void getMpios(ValueChangeEvent evento){
		idDepto = Integer.valueOf((String) evento.getNewValue());
		getMunicipios();
	}
	
	public String getSiguiente(){
		tabPanel = ConstantesFaces.TAB_PANEL_FORMACION;
		return ConstantesFaces.CREAR_HV;
	}
	
	public String getSiguienteDetalle(){
		tabPanel = ConstantesFaces.TAB_PANEL_FORMACION;
		return ConstantesFaces.DETALLE_HV;
	}
	
	public String getHomeHojaVida(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PersonaMB");
		getLimpiarSession();
		return ConstantesFaces.HOME_HV; 
	}
	
	public String getBusquedaBasicaPersona(){
		personas = personaDelegate.getBusquedaBasicaPersona(nombrePersona, apellidoPersona, identificacionPersona, estadoPersona);
		return ConstantesFaces.HOME_HV;
	}
	
	public String getBusquedaAvanzada(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PersonaMB");
		return ConstantesFaces.HOME_HV;
	}
	
	public String getAgregarHojaVida(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PersonaMB");
		getLimpiarSession();
		tabDeshabilitados = true;
		return ConstantesFaces.CREAR_HV;
	}
	
	public String getSeleccionarPersona(){
		setTabPanel();
		persona = personaDelegate.getSeleccionarPersona(personas, idPersona);
		getLimpiarSession();
		tabDeshabilitados = false;
		return ConstantesFaces.CREAR_HV;		
	}
	
	public String getSeleccionarPersonaDetalle(){
		setTabPanel();
		persona = personaDelegate.getSeleccionarPersona(personas, idPersona);
		getLimpiarSession();
		tabDeshabilitados = false;
		return ConstantesFaces.DETALLE_HV;		
	}
	
	public String getCambiarEstadoPersona(){
		persona = personaDelegate.getSeleccionarPersona(personas, idPersona);
		estadoOperacion = false;
		if(estadoPersona==true){
			persona.setPerBactivo(false);
		} else {
			persona.setPerBactivo(true);
		}
		estadoPersona = null;
		estadoOperacion = personaDelegate.getActualizarPersona(persona);
		if(estadoOperacion==true){
			return ConstantesFaces.ESTADO_HV_OK;
		} else {
			return ConstantesFaces.ESTADO_HV_ERROR;
		}
	}
	
	public String getGuardarPersona(){
		setTabPanel();
		estadoOperacion = false;
		estadoOperacion = personaDelegate.getGuardarPersona(persona);
		if(estadoOperacion==true){
			personas = (List<Object>) personaDelegate.getBusquedaBasicaPersona("" , "", persona.getPerNidentificacion().toString(), null);
			if(personas.size()==1){
				persona = (GppPersona) personas.get(0);
				tabDeshabilitados = false;
				if(documentoCargado==true){
					personaDelegate.getGuardarHojaVida(persona);
					documentoCargado=false;
				}				
			}
			return ConstantesFaces.ESTADO_OK;
		} else {
			return ConstantesFaces.ESTADO_ERROR;
		}
	}	
	
	public String getActualizarPersona(){
		setTabPanel();
		estadoOperacion = false;
		estadoOperacion = personaDelegate.getActualizarPersona(persona);
		if(estadoOperacion==true){
			if(documentoCargado==true){
				personaDelegate.getGuardarHojaVida(persona);
				documentoCargado=false;
			}
			return ConstantesFaces.ESTADO_OK;
		} else {
			return ConstantesFaces.ESTADO_ERROR;
		}		
	}

    public void getSubirDocumentoHojaVida(UploadEvent event) throws IOException {
    	documentoCargado = true;
    	personaDelegate.getSubirDocumentoHojaVida(event);
    }
	
	public void getLimpiarSession(){		
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("FormacionMB");
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("DocumentoMB");
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("ExperienciaMB");
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PerfilprofesionalMB");
	}
	
	public void setTabPanel(){
		tabPanel = ConstantesFaces.TAB_PANEL_PERSONA;
	}
}