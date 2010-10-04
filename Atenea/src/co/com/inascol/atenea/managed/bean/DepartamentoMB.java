package co.com.inascol.atenea.managed.bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import co.com.inascol.atenea.entity.GppDepartamento;
import co.com.inascol.atenea.entity.GppPais;
import co.com.inascol.atenea.managed.bean.delegate.DepartamentoDelegate;
import co.com.inascol.atenea.managed.bean.delegate.PaisDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class DepartamentoMB {

	private DepartamentoDelegate departamentoDelegate;
	private PaisDelegate paisDelegate;
	private Integer idDepartamento;
	private String nombreDepartamento;
	private String estadoDepartamento;
	private Integer idPais;
	private String controlNavegacion;
	private List<Object> departamentos;
	private GppDepartamento departamento;
	private Boolean estadoOperacion;
	
	public DepartamentoMB(){
		departamentoDelegate = new DepartamentoDelegate();
		departamentos = departamentoDelegate.getListaDeptos();
	}
	
	public String getNombreDepartamento() {
		return nombreDepartamento;
	}
	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}
	public String getEstadoDepartamento() {
		return estadoDepartamento;
	}
	public void setEstadoDepartamento(String estadoDepartamento) {
		this.estadoDepartamento = estadoDepartamento;
	}
	public GppDepartamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(GppDepartamento departamento) {
		this.departamento = departamento;
	}
	public List<Object> getDepartamentos() {
		return departamentos;
	}
	public void setDepartamentos(List<Object> departamentos) {
		this.departamentos = departamentos;
	}
	public Integer getIdDepartamento() {
		return idDepartamento;
	}
	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	public Integer getIdPais() {
		return idPais;
	}
	public void setIdPais(Integer idPais) {
		this.idPais = idPais;
	}
	public String getControlNavegacion() {
		return controlNavegacion;
	}
	public void setControlNavegacion(String controlNavegacion) {
		this.controlNavegacion = controlNavegacion;
	}
	public Boolean getEstadoOperacion() {
		return estadoOperacion;
	}
	public void setEstadoOperacion(Boolean estadoOperacion) {
		this.estadoOperacion = estadoOperacion;
	}
	public void getBuscarDeptoPorNombre() {
		departamentos = departamentoDelegate.getDeptoPorNombre(nombreDepartamento);
	}
	
	public List<SelectItem> getPaises(){
		paisDelegate = new PaisDelegate();
		List<SelectItem> listadoPaises = new ArrayList<SelectItem>();
		List<Object> paises = paisDelegate.getListaPaises();
		if(paises.size()>0){
			Iterator<Object> it = paises.iterator();
			while(it.hasNext()){
				GppPais gppPais = (GppPais) it.next();
				listadoPaises.add(new SelectItem(gppPais.getPaiNidpais(),gppPais.getPaiVpais()));
			}
        }
		return listadoPaises;
	}

	public String getAgregarDepto() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("DepartamentoMB");
		return ConstantesFaces.CREAR_DEPTO;
	}	
	
	public String getCrearDepto() {	
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvAgregarDepartamento")){
			estadoOperacion = departamentoDelegate.getCrearDepto(nombreDepartamento, idPais);
			getResultadoOperacion(estadoOperacion);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("DepartamentoMB");
			}
			return ConstantesFaces.HOME_DEPTO;
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}
	}
	
	public String getSeleccionarDepto(){
		departamento = departamentoDelegate.getSeleccionarDepto(idDepartamento);
		return ConstantesFaces.MODIFICAR_DEPTO;
	}
	
	public String getSeleccionarDeptoDetalle(){
		departamento = departamentoDelegate.getSeleccionarDepto(idDepartamento);
		return ConstantesFaces.DETALLE_DEPTO;
	}
	
	public String getModificarDepto(){
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvModificarDepartamento")){
			estadoOperacion = departamentoDelegate.getModificarDepto(departamento.getDptNiddepto(), departamento.getDptVdepto(), departamento.getPaiNidpais());
			getResultadoOperacion(estadoOperacion);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("DepartamentoMB");
			}
			return ConstantesFaces.HOME_DEPTO;
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}
	}
	
	public String getEliminarDepto(){
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvEliminarDepartamento")){
			estadoOperacion = departamentoDelegate.getEliminarDepto(idDepartamento);
			getResultadoOperacion(estadoOperacion);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("DepartamentoMB");
			}
			return ConstantesFaces.HOME_DEPTO;
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}		
	}
	
	public String getCancelar(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("DepartamentoMB");
		return ConstantesFaces.HOME_DEPTO;
	}
	
	public String getHomeDepartamento(){
		getMenuSeleccionado();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("DepartamentoMB");
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("PersonaMB");
		return ConstantesFaces.HOME_DEPTO;
	}
	
	public void getHomePageValue(){
		((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).setHomePage(ConstantesFaces.HOME_DEPTO);
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