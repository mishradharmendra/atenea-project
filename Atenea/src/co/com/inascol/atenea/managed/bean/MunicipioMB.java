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
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class MunicipioMB {

	private MunicipioDelegate municipioDelegate;
    private DepartamentoDelegate departamentoDelegate;
    private Integer idMunicipio;
	private String nombreMunicipio;
	private String estadoMunicipio;
	private Integer idDepto;
	private String controlNavegacion;
	private List<Object> municipios;
	private GppMunicipio municipio;
	private Boolean estadoOperacion;
	
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
	public List<Object> getMunicipios() {
		return municipios;
	}
	public void setMunicipios(List<Object> municipios) {
		this.municipios = municipios;
	}
	public Integer getIdMunicipio() {
		return idMunicipio;
	}
	public void setIdMunicipio(Integer idMunicipio) {
		this.idMunicipio = idMunicipio;
	}
	public Integer getIdDepto() {
		return idDepto;
	}
	public void setIdDepto(Integer idDepto) {
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
		List<Object> departamentos = departamentoDelegate.getListaDeptos();
		if(departamentos.size()>0){
			Iterator<Object> it = departamentos.iterator();
			while(it.hasNext()){
				GppDepartamento gppDepto = (GppDepartamento) it.next();
				listadoDepartamentos.add(new SelectItem(gppDepto.getDptNiddepto(),gppDepto.getDptVdepto()));
			}
        }
		return listadoDepartamentos;
	}

	public String getAgregarMunicipio() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("MunicipioMB");
		return ConstantesFaces.CREAR_MUNICIPIO;
	}	
	
	public String getCrearMunicipio() {
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvAgregarMunicipio")){
			estadoOperacion = municipioDelegate.getCrearMunicipio(nombreMunicipio, idDepto);
			getResultadoOperacion(estadoOperacion);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("MunicipioMB");
			}
			return ConstantesFaces.HOME_MUNICIPIO;
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}
	}
	
	public String getSeleccionarMunicipio(){
		municipio = municipioDelegate.getSeleccionarMunicipio(nombreMunicipio);
		return ConstantesFaces.MODIFICAR_MUNICIPIO;
	}
	
	public String getSeleccionarMunicipioDetalle(){
		municipio = municipioDelegate.getSeleccionarMunicipio(nombreMunicipio);
		return ConstantesFaces.DETALLE_MUNICIPIO;
	}
	
	public String getModificarMunicipio(){
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvModificarMunicipio")){
			estadoOperacion = municipioDelegate.getModificarMunicipio(municipio.getMunNidmunicipio(), municipio.getMunVmunicipio(), municipio.getDptNiddepto());
			getResultadoOperacion(estadoOperacion);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("MunicipioMB");
			}
			return ConstantesFaces.HOME_MUNICIPIO;
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}
	}
	
	public String getEliminarMunicipio(){
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvEliminarMunicipio")){
			estadoOperacion = municipioDelegate.getEliminarMunicipio(idMunicipio);
			getResultadoOperacion(estadoOperacion);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("MunicipioMB");
			}
			return ConstantesFaces.HOME_MUNICIPIO;
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}	
	}
	
	public String getCancelar(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("MunicipioMB");
		return ConstantesFaces.HOME_MUNICIPIO;
	}

	public String getHomeMunicipio(){
		getMenuSeleccionado();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("MunicipioMB");
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PersonaMB");
		return ConstantesFaces.HOME_MUNICIPIO;
	}
	
	public void getHomePageValue(){
		((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).setHomePage(ConstantesFaces.HOME_MUNICIPIO);
	}

	public void getMenuSeleccionado(){
		((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).setMenuSeleccionado(ConstantesFaces.MENU_ADMINISTRACION);		
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