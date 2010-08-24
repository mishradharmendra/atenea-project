package co.com.inascol.atenea.managed.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

public class ExperienciaMB {

	private ExperienciaDelegate experienciaDelegate;
	private Integer idExperiencia;
	private Integer idPersona;
	private List<Object> experienciasLaborales;
	private GppExperiencia experiencia;
	private Integer idPais;
	private Integer idDepto;	
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
		}
	}
	
	public void getMpios(ValueChangeEvent evento){
		if(evento.getNewValue()!=null){
			idDepto = Integer.valueOf((String) evento.getNewValue());
			getMunicipios();
		}
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
				return ConstantesFaces.ESTADO_OK;
			} else {
				return ConstantesFaces.ESTADO_ERROR;
			}
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
			if(estadoOperacion==true){	
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("ExperienciaMB");
				return ConstantesFaces.ESTADO_OK;
			} else {
				return ConstantesFaces.ESTADO_ERROR;
			}
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
				return ConstantesFaces.ESTADO_OK;
			} else {
				return ConstantesFaces.ESTADO_ERROR;
			}
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
	
	public Boolean getValidarPermisosServicio(String nombreServicio){
		return ((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).validarPermisosServicio(nombreServicio);
	}
}