package co.com.inascol.atenea.managed.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
import co.com.inascol.atenea.entity.GppPerfilequivalente;
import co.com.inascol.atenea.entity.GppPersona;
import co.com.inascol.atenea.entity.GppTipodoc;
import co.com.inascol.atenea.entity.GppTituloequivalente;
import co.com.inascol.atenea.managed.bean.delegate.PersonaDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcción de Software
 * Esp. Sistemas de Información Geográfica
 * Ing. Catastral y Geodesta
 */
public class PersonaMB {

	private PersonaDelegate personaDelegate;
	private Integer idPersona;
	private String nombrePersona;
	private String identificacionPersona;
	private String idPregrado;
	private String idEspecializacion;
	private String idMaestria;
	private String idPerfil;
	private String cargo;
	private String herramientas;
	private String bd;
	private String funciones;
	private String criterioBusquedaRapida;
	private Date fechaTarjetaProfesional;
	private List<Object> personas;
	private GppPersona persona;
	private List<Object> formacionesAcademicas;
	private List<Object> experienciaLaboral;
	private Boolean estadoOperacion;
	private String tabPanel;
	private String tabPanelFormacion;
	private String tabPanelExperiencia;
	private Integer idPais;
	private Integer idDepto;	
	private Integer idPaisResidencia;
	private Integer idDeptoResidencia;	
	private Boolean tabDeshabilitados;
	private Boolean documentoCargado;
	private Boolean estadoPersona;
	
	public PersonaMB(){
		personaDelegate = new PersonaDelegate();		
		persona = new GppPersona();
		tabDeshabilitados = true;
		documentoCargado = false;
		tabPanelFormacion = ConstantesFaces.TAB_PANEL_FORMACION;
		tabPanelExperiencia = ConstantesFaces.TAB_PANEL_EXPERIENCIA;
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
	public List<Object> getPersonas() {
		return personas;
	}
	public void setPersonas(List<Object> personas) {
		this.personas = personas;
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
	public String getTabPanelFormacion() {
		return tabPanelFormacion;
	}
	public void setTabPanelFormacion(String tabPanelFormacion) {
		this.tabPanelFormacion = tabPanelFormacion;
	}
	public String getTabPanelExperiencia() {
		return tabPanelExperiencia;
	}
	public void setTabPanelExperiencia(String tabPanelExperiencia) {
		this.tabPanelExperiencia = tabPanelExperiencia;
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
	public String getIdPregrado() {
		return idPregrado;
	}
	public void setIdPregrado(String idPregrado) {
		this.idPregrado = idPregrado;
	}
	public String getIdEspecializacion() {
		return idEspecializacion;
	}
	public void setIdEspecializacion(String idEspecializacion) {
		this.idEspecializacion = idEspecializacion;
	}
	public String getIdMaestria() {
		return idMaestria;
	}
	public void setIdMaestria(String idMaestria) {
		this.idMaestria = idMaestria;
	}
	public String getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(String idPerfil) {
		this.idPerfil = idPerfil;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getHerramientas() {
		return herramientas;
	}
	public void setHerramientas(String herramientas) {
		this.herramientas = herramientas;
	}
	public String getBd() {
		return bd;
	}
	public void setBd(String bd) {
		this.bd = bd;
	}
	public String getFunciones() {
		return funciones;
	}
	public void setFunciones(String funciones) {
		this.funciones = funciones;
	}
	public Date getFechaTarjetaProfesional() {
		return fechaTarjetaProfesional;
	}
	public void setFechaTarjetaProfesional(Date fechaTarjetaProfesional) {
		this.fechaTarjetaProfesional = fechaTarjetaProfesional;
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
	public String getCriterioBusquedaRapida() {
		return criterioBusquedaRapida;
	}
	public void setCriterioBusquedaRapida(String criterioBusquedaRapida) {
		this.criterioBusquedaRapida = criterioBusquedaRapida;
	}
	public Boolean getEstadoOperacion() {
		return estadoOperacion;
	}
	public void setEstadoOperacion(Boolean estadoOperacion) {
		this.estadoOperacion = estadoOperacion;
	}
	public Integer getIdPaisResidencia() {
		return idPaisResidencia;
	}
	public void setIdPaisResidencia(Integer idPaisResidencia) {
		this.idPaisResidencia = idPaisResidencia;
	}
	public Integer getIdDeptoResidencia() {
		return idDeptoResidencia;
	}
	public void setIdDeptoResidencia(Integer idDeptoResidencia) {
		this.idDeptoResidencia = idDeptoResidencia;
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
	
	public List<SelectItem> getDeptosPaisResidencia(){
		List<SelectItem> listadoDepartamentos = new ArrayList<SelectItem>();		
		if(idPaisResidencia!=null){
			List<Object> deptos = personaDelegate.getListaDepartamentos();
			if(deptos.size()>0){
				Iterator<Object> it = deptos.iterator();
				while(it.hasNext()){
					GppDepartamento gppDepartamento = (GppDepartamento) it.next();
					if(gppDepartamento.getPaiNidpais()==idPaisResidencia){
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

	public List<SelectItem> getMunicipiosResidencia(){
		List<SelectItem> listadoMunicipios = new ArrayList<SelectItem>();
		if(idPaisResidencia!=null && idDeptoResidencia!=null){
			List<Object> mpios = personaDelegate.getListaMunicipios();
			if(mpios.size()>0){
				Iterator<Object> it = mpios.iterator();
				while(it.hasNext()){
					GppMunicipio gppMunicipio = (GppMunicipio) it.next();
					if(gppMunicipio.getDptNiddepto()==idDeptoResidencia){
						listadoMunicipios.add(new SelectItem(gppMunicipio.getMunNidmunicipio(),gppMunicipio.getMunVmunicipio()));
					}
				}
	        }
		}
		return listadoMunicipios;
	}

	public List<SelectItem> getTitulosEquivalentes(){
		List<SelectItem> listadoTitulosEquivalentes = new ArrayList<SelectItem>();
		List<Object> instituciones = personaDelegate.getTitulosEquivalentes();
		if(instituciones.size()>0){
			Iterator<Object> it = instituciones.iterator();
			while(it.hasNext()){
				GppTituloequivalente gppTituloequivalente = (GppTituloequivalente) it.next();
				listadoTitulosEquivalentes.add(new SelectItem(gppTituloequivalente.getTeqNidtituloeq(),gppTituloequivalente.getTeqVtituloeq()));
			}
        }
		return listadoTitulosEquivalentes;
	}	
	
	public List<SelectItem> getPerfilesProfesionales(){
		List<SelectItem> listadoPerfilesProfesionales = new ArrayList<SelectItem>();
		List<Object> perfilesEquivalente = personaDelegate.getPerfilesProfesionalesEquivalente();
		if(perfilesEquivalente.size()>0){
			Iterator<Object> it = perfilesEquivalente.iterator();
			while(it.hasNext()){
				GppPerfilequivalente gppPerfilequivalente = (GppPerfilequivalente) it.next();
				listadoPerfilesProfesionales.add(new SelectItem(gppPerfilequivalente.getPeqNidperfileq(),gppPerfilequivalente.getPeqVperfileq()));
			}
        }
		return listadoPerfilesProfesionales;
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
			getMunicipiosDepto();
		}
	}
	
	public void getDeptosResidencia(ValueChangeEvent evento){
		if(evento.getNewValue()!=null){
			idPaisResidencia = Integer.valueOf((Integer) evento.getNewValue());
			getDeptosPaisResidencia();
		}
	}
	
	public void getMpiosResidencia(ValueChangeEvent evento){
		if(evento.getNewValue()!=null){
			idDeptoResidencia = Integer.valueOf((Integer)evento.getNewValue());
			getMunicipiosResidencia();
		}
	}
	
	public void getLibreta(ValueChangeEvent evento){
		if(evento.getNewValue()!=null){
			persona.setPerVsexo((String) evento.getNewValue());
		}
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
		personas = personaDelegate.getBusquedaBasicaPersona(nombrePersona, identificacionPersona);
		criterioBusquedaRapida = "";
		return ConstantesFaces.HOME_HV;
	}
	
	public String getBusquedaAvanzada(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PersonaMB");
		return ConstantesFaces.AVANZADA_HV;
	}
	
	public String getBusquedaRapidaPersona(){
		personas = personaDelegate.getBusquedaRapidaPersona(criterioBusquedaRapida);
		nombrePersona = "";
		identificacionPersona = "";
		return ConstantesFaces.HOME_HV;		
	}
	
	public String getBusquedaAvanzadaPersona(){
		personas = personaDelegate.getBusquedaAvanzadaPersona(nombrePersona, identificacionPersona, idPregrado, fechaTarjetaProfesional, idEspecializacion, idMaestria, cargo, bd, herramientas, funciones, idPerfil);
		return ConstantesFaces.AVANZADA_HV;		
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
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvModificarHojadeVida")){
			persona = personaDelegate.getSeleccionarPersona(personas, idPersona);
			if(estadoPersona==true){
				persona.setPerBactivo(false);
			} else {
				persona.setPerBactivo(true);
			}
			estadoPersona = null;
			estadoOperacion = personaDelegate.getActualizarPersona(persona);
			if(estadoOperacion==true){
				return ConstantesFaces.ESTADO_OK;
			} else {
				return ConstantesFaces.ESTADO_ERROR;
			}
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}			
	}
	
	public String getCambiarEstadoPersonaAvanzada(){
		getHomePageValueAvanzada();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvModificarHojadeVida")){
			persona = personaDelegate.getSeleccionarPersona(personas, idPersona);
			if(estadoPersona==true){
				persona.setPerBactivo(false);
			} else {
				persona.setPerBactivo(true);
			}
			estadoPersona = null;
			estadoOperacion = personaDelegate.getActualizarPersona(persona);
			if(estadoOperacion==true){
				return ConstantesFaces.ESTADO_OK;
			} else {
				return ConstantesFaces.ESTADO_ERROR;
			}
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}			
	}
	
//	public String getGuardarPersona(){
//		getHomePageValueHV();
//		setTabPanel();
//		estadoOperacion = false;
//		if(getValidarPermisosServicio("srvAgregarHojadeVida")){	
//			estadoOperacion = personaDelegate.getGuardarPersona(persona);
//			if(estadoOperacion==true){
//				personas = (List<Object>) personaDelegate.getBusquedaBasicaPersona("" , persona.getPerNidentificacion().toString());
//				if(personas.size()==1){
//					persona = (GppPersona) personas.get(0);
//					tabDeshabilitados = false;
//				}
//				return ConstantesFaces.ESTADO_OK;
//			} else {
//				return ConstantesFaces.ESTADO_ERROR;
//			}
//		}else{
//			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
//		}				
//	}	
	
	public String getGuardarPersona(){
		getHomePageValueHV();
		setTabPanel();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvAgregarHojadeVida")){	
			estadoOperacion = personaDelegate.getGuardarPersona(persona);
			if(estadoOperacion==true){
				personas = (List<Object>) personaDelegate.getBusquedaBasicaPersona("" , persona.getPerNidentificacion().toString());
				if(personas.size()==1){
					persona = (GppPersona) personas.get(0);
					tabDeshabilitados = false;
				}
				return ConstantesFaces.CREAR_HV;
			} else {
				return ConstantesFaces.ESTADO_ERROR;
			}
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}				
	}
	
	public String getActualizarPersona(){
		getHomePageValueHV();
		setTabPanel();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvModificarHojadeVida")){	
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
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}			
	}

    public void getSubirDocumentoHojaVida(UploadEvent event) throws IOException {
    	documentoCargado = true;
    	personaDelegate.getSubirDocumentoHojaVida(persona, event);
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
	
	public void getHomePageValue(){
		((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).setHomePage(ConstantesFaces.HOME_HV);
	}

	public void getHomePageValueAvanzada(){
		((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).setHomePage(ConstantesFaces.AVANZADA_HV);
	}
	
	public void getHomePageValueHV(){
		((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).setHomePage(ConstantesFaces.CREAR_HV);
	}
	
	public Boolean getValidarPermisosServicio(String nombreServicio){
		return ((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).validarPermisosServicio(nombreServicio);
	}
}