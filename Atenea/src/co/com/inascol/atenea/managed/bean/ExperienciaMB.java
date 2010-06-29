package co.com.inascol.atenea.managed.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.richfaces.event.UploadEvent;

import co.com.inascol.atenea.entity.GppCargoequivalente;
import co.com.inascol.atenea.entity.GppExperiencia;
import co.com.inascol.atenea.entity.GppMunicipio;
import co.com.inascol.atenea.managed.bean.delegate.ExperienciaDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;

public class ExperienciaMB {

	private ExperienciaDelegate experienciaDelegate;
	private Integer idExperiencia;
	private Integer idPersona;
	private List<Object> experienciasLaborales;
	private GppExperiencia experiencia;
	private Boolean estadoOperacion;
	
	public ExperienciaMB(){
		experienciaDelegate = new ExperienciaDelegate();
		experiencia = new GppExperiencia();
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

	public List<SelectItem> getMunicipios(){
		List<SelectItem> listadoMunicipios = new ArrayList<SelectItem>();
		List<Object> mpios = experienciaDelegate.getListaMunicipios();
		if(mpios.size()>0){
			Iterator<Object> it = mpios.iterator();
			while(it.hasNext()){
				GppMunicipio gppMunicipio = (GppMunicipio) it.next();
				listadoMunicipios.add(new SelectItem(gppMunicipio.getMunVidmunicipio(),gppMunicipio.getMunVmunicipio()));
			}
        }
		return listadoMunicipios;
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
	
	public String getAgregarExperiencia(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("ExperienciaMB");
		return ConstantesFaces.CREAR_EXPERIENCIA;
	}
	
	public String getSeleccionarExperiencia(){
		experiencia = experienciaDelegate.getSeleccionarExperiencia(experienciasLaborales, idExperiencia);
		return ConstantesFaces.MODIFICAR_EXPERIENCIA;
	}
	
	public String getCancelar(){
		setTabPanel();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("ExperienciaMB");
		return ConstantesFaces.CREAR_HV;
	}
	
	public String getGuardarExperiencia(){
		setTabPanel();
		estadoOperacion = false;
		estadoOperacion = experienciaDelegate.getGuardarExperiencia(experiencia);
		if(estadoOperacion==true){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("ExperienciaMB");
			return ConstantesFaces.ESTADO_OK;
		} else {
			return ConstantesFaces.ESTADO_ERROR;
		}
	}
	
	public String getBorrarExperiencia(){ 
		setTabPanel();
		estadoOperacion = false;
		estadoOperacion = experienciaDelegate.getBorrarExperiencia(idExperiencia);
		if(estadoOperacion==true){	
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("ExperienciaMB");
			return ConstantesFaces.ESTADO_OK;
		} else {
			return ConstantesFaces.ESTADO_ERROR;
		}
	}
	
	public String getActualizarExperiencia(){
		setTabPanel();
		estadoOperacion = false;
		estadoOperacion = experienciaDelegate.getActualizarExperiencia(experiencia);
		if(estadoOperacion==true){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("ExperienciaMB");
			return ConstantesFaces.ESTADO_OK;
		} else {
			return ConstantesFaces.ESTADO_ERROR;
		}			
	}
	
	public void getSubirCertificaciones(UploadEvent event) throws IOException {
		experienciaDelegate.getSubirCertificaciones(event);
	}

	public void setTabPanel(){
		( ( PersonaMB ) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).setTabPanel(ConstantesFaces.TAB_PANEL_EXPERIENCIA);
	}
}