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
		estadoOperacion = false;
		estadoOperacion = departamentoDelegate.getCrearDepto(nombreDepartamento, idPais);
		if(estadoOperacion==true){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("DepartamentoMB");
			return ConstantesFaces.ESTADO_DT_OK;
		}else{
			return ConstantesFaces.ESTADO_DT_ERROR;
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
		estadoOperacion = false;
		estadoOperacion = departamentoDelegate.getModificarDepto(departamento.getDptNiddepto(), departamento.getDptVdepto(), departamento.getPaiNidpais());
		if(estadoOperacion==true){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("DepartamentoMB");
			return ConstantesFaces.ESTADO_DT_OK;
		}else{
			return ConstantesFaces.ESTADO_DT_ERROR;
		}
	}
	
	public String getEliminarDepto(){
		estadoOperacion = false;
		estadoOperacion = departamentoDelegate.getEliminarDepto(idDepartamento);
		if(estadoOperacion==true){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("DepartamentoMB");
			return ConstantesFaces.ESTADO_DT_OK;
		}else{
			return ConstantesFaces.ESTADO_DT_ERROR;
		}
	}
	
	public String getCancelar(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("DepartamentoMB");
		return ConstantesFaces.HOME_DEPTO;
	}
	
	public String getHomeDepartamento(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("DepartamentoMB");
		return ConstantesFaces.HOME_DEPTO;
	}
}