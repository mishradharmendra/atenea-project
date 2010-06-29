package co.com.inascol.atenea.managed.bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import co.com.inascol.atenea.entity.GppMunicipio;
import co.com.inascol.atenea.entity.GppDepartamento;
import co.com.inascol.atenea.managed.bean.delegate.MunicipioDelegate;
import co.com.inascol.atenea.managed.bean.delegate.DepartamentoDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;


public class MunicipioMB {

	private MunicipioDelegate municipioDelegate;
    private DepartamentoDelegate departamentoDelegate;
    private String idMunicipio;
	private String nombreMunicipio;
	private String estadoMunicipio;
	private String idDepto;
	private String controlNavegacion;
	private List municipios;
	private GppMunicipio municipio;
	
	public MunicipioMB(){
		municipioDelegate = new MunicipioDelegate();
		municipios = municipioDelegate.getListaMunicipios();
	}
	
	public String getNombreMunicipio() {
		return nombreMunicipio;
	}
	public void setNombreMunicipio(String nombreMunicipio) {
		this.nombreMunicipio = nombreMunicipio;
	}
	public String getEstadoMunicipio() {
		return estadoMunicipio;
	}
	public void setEstadoMunicipio(String estadoMunicipio) {
		this.estadoMunicipio = estadoMunicipio;
	}
	public GppMunicipio getMunicipio() {
		return municipio;
	}
	public void setMunicipio(GppMunicipio municipio) {
		this.municipio = municipio;
	}
	public List getMunicipios() {
		return municipios;
	}
	public void setMunicipios(List municipios) {
		this.municipios = municipios;
	}
	public String getIdMunicipio() {
		return idMunicipio;
	}
	public void setIdMunicipio(String idMunicipio) {
		this.idMunicipio = idMunicipio;
	}
	public String getIdDepto() {
		return idDepto;
	}
	public void setIdDepto(String idDepto) {
		this.idDepto = idDepto;
	}
	public String getControlNavegacion() {
		return controlNavegacion;
	}
	public void setControlNavegacion(String controlNavegacion) {
		this.controlNavegacion = controlNavegacion;
	}

	public void getBuscarMunicipioPorNombre() {
		municipios = municipioDelegate.getMunicipioPorNombre(nombreMunicipio);
	}
	
	public List<SelectItem> getDepartamentos(){
		departamentoDelegate = new DepartamentoDelegate();
		List<SelectItem> listadoDepartamentos = new ArrayList<SelectItem>();
		List departamentos = departamentoDelegate.getListaDeptos();
		if(departamentos.size()>0){
			Iterator it = departamentos.iterator();
			while(it.hasNext()){
				GppDepartamento gppDepto = (GppDepartamento) it.next();
				listadoDepartamentos.add(new SelectItem(gppDepto.getDptViddepto(),gppDepto.getDptVdepto()));
			}
        }
		return listadoDepartamentos;
	}

	public String getAgregarMunicipio() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("MunicipioMB");
		return ConstantesFaces.CREAR_MUNICIPIO;
	}	
	
	public String getCrearMunicipio() {		
		municipioDelegate.getCrearMunicipio(idMunicipio, nombreMunicipio, idDepto);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("MunicipioMB");
		return ConstantesFaces.HOME_MUNICIPIO;
	}
	
	public String getSeleccionarMunicipio(){
		municipio = municipioDelegate.getSeleccionarMunicipio(idMunicipio);
		return ConstantesFaces.DETALLE_MUNICIPIO;
	}
	
	public String getModificarMunicipio(){
		municipioDelegate.getModificarMunicipio(municipio.getDptViddepto(), municipio.getMunVmunicipio(), municipio.getMunVidmunicipio());
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("MunicipioMB");
		return ConstantesFaces.HOME_MUNICIPIO;
	}
	
	public String getCancelar(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("MunicipioMB");
		return ConstantesFaces.HOME_MUNICIPIO;
	}

	public String getHomeMunicipio(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("MunicipioMB");
		return ConstantesFaces.HOME_MUNICIPIO;
	}
}