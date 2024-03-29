package co.com.inascol.atenea.managed.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.richfaces.event.UploadEvent;

import co.com.inascol.atenea.entity.GppCargoequivalente;
import co.com.inascol.atenea.entity.GppDepartamento;
import co.com.inascol.atenea.entity.GppExperiencia;
import co.com.inascol.atenea.entity.GppMunicipio;
import co.com.inascol.atenea.entity.GppPais;
import co.com.inascol.atenea.entity.GppPersona;
import co.com.inascol.atenea.managed.bean.delegate.ExperienciaDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class ExperienciaMB {

	private ExperienciaDelegate experienciaDelegate;
	private Integer idExperiencia;
	private Integer idPersona;
	private List<Object> experienciasLaborales;
	private GppExperiencia experiencia;
	private Integer idPais;
	private Integer idDepto;
	private Integer idPaisExperiencia;
	private Integer idDeptoExperiencia;	
	private Boolean estadoOperacion;
	private Boolean fechaActual;
	private Boolean documentoCargadoCertificacion1;
	private Boolean documentoCargadoCertificacion2;
	
	public ExperienciaMB(){
		experienciaDelegate = new ExperienciaDelegate();
		experiencia = new GppExperiencia();
		documentoCargadoCertificacion1 = false;
		documentoCargadoCertificacion2 = false;
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") != null){
			idPersona = ( (PersonaMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).getPersona().getPerNidpersona();
			experienciasLaborales = experienciaDelegate.buscarFormacionesPersona(idPersona);
		}
	}
	
	public Integer getIdExperiencia() {
		return idExperiencia;
	}
	public void setIdExperiencia(Integer idExperiencia) {
		this.idExperiencia = idExperiencia;
	}
	public List<Object> getExperienciasLaborales() {
		return experienciasLaborales;
	}
	public void setExperienciasLaborales(List<Object> experienciasLaborales) {
		this.experienciasLaborales = experienciasLaborales;
	}		
	public Integer getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}
	public GppExperiencia getExperiencia() {
		return experiencia;
	}
	public void setExperiencia(GppExperiencia experiencia) {
		this.experiencia = experiencia;
	}
	public Boolean getFechaActual() {
		return fechaActual;
	}
	public void setFechaActual(Boolean fechaActual) {
		this.fechaActual = fechaActual;
	}
	public Integer getIdPais() {
		return idPais;
	}
	public void setIdPais(Integer idPais) {
		this.idPais = idPais;
	}
	public Integer getIdDepto() {
		return idDepto;
	}
	public void setIdDepto(Integer idDepto) {
		this.idDepto = idDepto;
	}
	public Integer getIdPaisExperiencia() {
		return idPaisExperiencia;
	}
	public void setIdPaisExperiencia(Integer idPaisExperiencia) {
		this.idPaisExperiencia = idPaisExperiencia;
	}
	public Integer getIdDeptoExperiencia() {
		return idDeptoExperiencia;
	}
	public void setIdDeptoExperiencia(Integer idDeptoExperiencia) {
		this.idDeptoExperiencia = idDeptoExperiencia;
	}
	public Boolean getEstadoOperacion() {
		return estadoOperacion;
	}
	public void setEstadoOperacion(Boolean estadoOperacion) {
		this.estadoOperacion = estadoOperacion;
	}
	public Boolean getDocumentoCargadoCertificacion1() {
		return documentoCargadoCertificacion1;
	}
	public void setDocumentoCargadoCertificacion1(
			Boolean documentoCargadoCertificacion1) {
		this.documentoCargadoCertificacion1 = documentoCargadoCertificacion1;
	}
	public Boolean getDocumentoCargadoCertificacion2() {
		return documentoCargadoCertificacion2;
	}
	public void setDocumentoCargadoCertificacion2(
			Boolean documentoCargadoCertificacion2) {
		this.documentoCargadoCertificacion2 = documentoCargadoCertificacion2;
	}

	public List<SelectItem> getPaises(){
		List<SelectItem> listadoPaises = new ArrayList<SelectItem>();
		List<Object> paises = experienciaDelegate.getListaPaises();
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
			List<Object> deptos = experienciaDelegate.getListaDepartamentos();
			if(deptos.size()>0){
				Iterator<Object> it = deptos.iterator();
				while(it.hasNext()){
					GppDepartamento gppDepartamento = (GppDepartamento) it.next();
					if(gppDepartamento.getPaiNidpais()==idPais){
						listadoDepartamentos.add(new SelectItem(gppDepartamento.getDptNiddepto(),gppDepartamento.getDptVdepto()));
					}
				}
	        }
		}else{
			List<Object> deptos = experienciaDelegate.getListaDepartamentos();
			if(deptos.size()>0){
				Iterator<Object> it = deptos.iterator();
				while(it.hasNext()){
					GppDepartamento gppDepartamento = (GppDepartamento) it.next();
					listadoDepartamentos.add(new SelectItem(gppDepartamento.getDptNiddepto(),gppDepartamento.getDptVdepto()));
				}
			}	
		}
		return listadoDepartamentos;
	}
	
	public List<SelectItem> getMunicipios(){
		List<SelectItem> listadoMunicipios = new ArrayList<SelectItem>();
		if(idPais!=null && idDepto!=null){
			List<Object> mpios = experienciaDelegate.getListaMunicipios();
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
			List<Object> mpios = experienciaDelegate.getListaMunicipios();
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
	
	public void getDeptos(ValueChangeEvent evento){
		if(evento.getNewValue()!=null){
			idPais = Integer.valueOf((String) evento.getNewValue());
			getDepartamentosPais();
		}else{
			idPais = 0;
			idPaisExperiencia = 0;
			experiencia.setMunVidmunicipio(0);
		}		
	}
	
	public void getMpios(ValueChangeEvent evento){
		if(evento.getNewValue()!=null){
			idDepto = Integer.valueOf((String) evento.getNewValue());
			getMunicipios();
		}else{
			idDepto = 0;
			idDeptoExperiencia = 0;
			experiencia.setMunVidmunicipio(0);
		}		
	}

	public void getFecha(ValueChangeEvent evento){
		if(evento.getNewValue()!=null){
			fechaActual = (Boolean) evento.getNewValue();
		}
	}
	
	public void getBuscarPaisyDepto(GppExperiencia experiencia){
		idPaisExperiencia = experienciaDelegate.getIdPais(experiencia);
		idDeptoExperiencia = experienciaDelegate.getIdDepto(experiencia);
	}
	
	public List<SelectItem> getCargosEquivalentes(){
		List<SelectItem> listadoCargos = new ArrayList<SelectItem>();
		List<Object> cargos = experienciaDelegate.getCargosEquivalentes();
		if(cargos.size()>0){
			Iterator<Object> it = cargos.iterator();
			while(it.hasNext()){
				GppCargoequivalente gppCargoequivalente = (GppCargoequivalente) it.next();
				listadoCargos.add(new SelectItem(gppCargoequivalente.getCeqNidcargoeq(), gppCargoequivalente.getCeqVcargoeq()));
			}
        }
		return listadoCargos;
	}
	
    public void validarEmail(FacesContext context, UIComponent validate, Object value){
        String email = (String) value;
        if(email.indexOf('@')==-1){
            ((UIInput)validate).setValid(false);
            FacesMessage msg = new FacesMessage("Ingrese una dirección de correo válida.");
            context.addMessage(validate.getClientId(context), msg);
        }
    }
	
	public String getAnterior(){
		( ( PersonaMB ) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).setTabPanel(ConstantesFaces.TAB_PANEL_FORMACION);
		return ConstantesFaces.CREAR_HV;
	}
	
	public String getSiguiente(){
		( ( PersonaMB ) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).setTabPanel(ConstantesFaces.TAB_PANEL_PERFIL);
		return ConstantesFaces.CREAR_HV;
	}
	
	public String getAnteriorDetalle(){
		( ( PersonaMB ) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).setTabPanel(ConstantesFaces.TAB_PANEL_FORMACION);
		return ConstantesFaces.DETALLE_HV;
	}
	
	public String getSiguienteDetalle(){
		( ( PersonaMB ) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).setTabPanel(ConstantesFaces.TAB_PANEL_PERFIL);
		return ConstantesFaces.DETALLE_HV;
	}
	
	public String getAgregarExperiencia(){
		setTabPanel();
		setTabPanelExperienciaAgregacion();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("ExperienciaMB");
		return ConstantesFaces.CREAR_HV;
	}
	
	public String getSeleccionarExperiencia(){
		experiencia = experienciaDelegate.getSeleccionarExperiencia(experienciasLaborales, idExperiencia);
		getBuscarPaisyDepto(experiencia);
		setTabPanel();
		setTabPanelExperienciaAgregacion();
		return ConstantesFaces.CREAR_HV;
	}
	
	public String getCancelar(){
		setTabPanel();
		setTabPanelExperienciaConsulta();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("ExperienciaMB");
		return ConstantesFaces.CREAR_HV;
	}
	
	public String getGuardarExperiencia(){
		getHomePageValueHV();
		setTabPanel();
		setTabPanelExperienciaConsulta();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvAgregarHojadeVida")){
			if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") != null){
				idPersona = ( (PersonaMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).getPersona().getPerNidpersona();
				experiencia.setPerNidpersona(idPersona);
				if(fechaActual==true){
					experiencia.setExpDfecretiro(null);
				}
				estadoOperacion = experienciaDelegate.getGuardarExperiencia(experiencia);
				getResultadoOperacion(estadoOperacion);
			}
			if(estadoOperacion==true){
				if(documentoCargadoCertificacion1==true){
					GppPersona persona = ( (PersonaMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).getPersona();
					experienciaDelegate.getGuardarCertificacion1(persona);
					documentoCargadoCertificacion1 = false;
				}
				if(documentoCargadoCertificacion2==true){
					GppPersona persona = ( (PersonaMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).getPersona();
					experienciaDelegate.getGuardarCertificacion2(persona);
					documentoCargadoCertificacion2 = false;
				}
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("ExperienciaMB");
			} 
			return ConstantesFaces.CREAR_HV;
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}				
	}
	
	public String getBorrarExperiencia(){
		getHomePageValueHV();
		setTabPanel();
		setTabPanelExperienciaConsulta();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvModificarHojadeVida")){
			estadoOperacion = experienciaDelegate.getBorrarExperiencia(idExperiencia);
			getResultadoOperacion(estadoOperacion);
			if(estadoOperacion==true){	
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("ExperienciaMB");
			} 
			return ConstantesFaces.CREAR_HV;
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}				
	}
	
	public String getActualizarExperiencia(){
		getHomePageValueHV();
		setTabPanel();
		setTabPanelExperienciaConsulta();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvModificarHojadeVida")){
			estadoOperacion = experienciaDelegate.getActualizarExperiencia(experiencia);
			getResultadoOperacion(estadoOperacion);
			if(estadoOperacion==true){
				if(documentoCargadoCertificacion1==true){
					GppPersona persona = ( (PersonaMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).getPersona();
					experienciaDelegate.getGuardarCertificacion1(persona);
					documentoCargadoCertificacion1 = false;
				}
				if(documentoCargadoCertificacion2==true){
					GppPersona persona = ( (PersonaMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).getPersona();
					experienciaDelegate.getGuardarCertificacion2(persona);
					documentoCargadoCertificacion2 = false;
				}
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("ExperienciaMB");
			} 
			return ConstantesFaces.CREAR_HV;
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}			
	}
	
	public void getSubirCertificaciones(UploadEvent event) throws IOException {
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") != null){
			GppPersona persona = ( (PersonaMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).getPersona();
			experienciaDelegate.getSubirCertificaciones(persona, event);
			experienciaDelegate.getGuardarCertificaciones(persona);
		}
	}
	
	public void getSubirCertificado1(UploadEvent event) throws IOException {
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") != null){
			GppPersona persona = ( (PersonaMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).getPersona();
			documentoCargadoCertificacion1 = true;
			experienciaDelegate.getSubirCertificado1(persona, event);
		}
	}

	public void getSubirCertificado2(UploadEvent event) throws IOException {
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") != null){
			GppPersona persona = ( (PersonaMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).getPersona();
			documentoCargadoCertificacion2 = true;
			experienciaDelegate.getSubirCertificado2(persona, event);
		}
	}

	public void setTabPanel(){
		( ( PersonaMB ) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).setTabPanel(ConstantesFaces.TAB_PANEL_EXPERIENCIA);
	}

	public void setTabPanelExperienciaAgregacion(){
		( ( PersonaMB ) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).setTabPanelExperiencia(ConstantesFaces.TAB_PANEL_EXPERIENCIA_AGREGAR);
	}
	
	public void setTabPanelExperienciaConsulta(){
		( ( PersonaMB ) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).setTabPanelExperiencia(ConstantesFaces.TAB_PANEL_EXPERIENCIA);
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