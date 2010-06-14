package co.com.inascol.atenea.managed.bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import co.com.inascol.atenea.entity.GppIdioma;
import co.com.inascol.atenea.entity.GppPais;
import co.com.inascol.atenea.entity.GppPerfilequivalente;
import co.com.inascol.atenea.entity.GppPerfilprof;
import co.com.inascol.atenea.managed.bean.delegate.PerfilprofesionalDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;

public class PerfilprofesionalMB {

	private PerfilprofesionalDelegate perfilprofesionalDelegate;
	private Integer idPerfilProfesional;
	private Integer idPersona;
	private GppPerfilprof perfilProfesional;
	
	public PerfilprofesionalMB(){
		perfilprofesionalDelegate = new PerfilprofesionalDelegate();
		perfilProfesional = new GppPerfilprof();
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
	
	public String getGuardarPerfil(){
		idPersona = ( (PersonaMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).getIdPersona();
		perfilProfesional.setPerNidpersona(idPersona);
		perfilprofesionalDelegate.getGuardarPerfil(perfilProfesional);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PerfilprofesionalMB");
		return ConstantesFaces.CREAR_HV;
	}

	public String getCancelar(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PerfilprofesionalMB");
		return ConstantesFaces.CREAR_HV;	
	}	
}