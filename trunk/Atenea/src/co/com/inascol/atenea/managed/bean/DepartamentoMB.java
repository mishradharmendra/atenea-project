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
	private String idDepartamento;
	private String nombreDepartamento;
	private String estadoDepartamento;
	private String idPais;
	private String controlNavegacion;
	private List departamentos;
	private GppDepartamento departamento;
	
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
	public List getDepartamentos() {
		return departamentos;
	}
	public void setDepartamentos(List departamentos) {
		this.departamentos = departamentos;
	}
	public String getIdDepartamento() {
		return idDepartamento;
	}
	public void setIdDepartamento(String idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	public String getIdPais() {
		return idPais;
	}
	public void setIdPais(String idPais) {
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
		List paises = paisDelegate.getListaPaises();
		if(paises.size()>0){
			Iterator it = paises.iterator();
			while(it.hasNext()){
				GppPais gppPais = (GppPais) it.next();
				listadoPaises.add(new SelectItem(gppPais.getPaiVidpais(),gppPais.getPaiVpais()));
			}
        }
		return listadoPaises;
	}

	public String getAgregarDepto() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("DepartamentoMB");
		return ConstantesFaces.CREAR_DEPTO;
	}	
	
	public String getCrearDepto() {		
		departamentoDelegate.getCrearDepto(idDepartamento, nombreDepartamento, idPais);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("DepartamentoMB");
		return ConstantesFaces.HOME_DEPTO;
	}
	
	public String getSeleccionarDepto(){
		departamento = departamentoDelegate.getSeleccionarDepto(idDepartamento);
		return ConstantesFaces.DETALLE_DEPTO;
	}
	
	public String getModificarDepto(){
		departamentoDelegate.getModificarDepto(departamento.getDptViddepto(), departamento.getDptVdepto(), departamento.getPaiVidpais());
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("DepartamentoMB");
		return ConstantesFaces.HOME_DEPTO;
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