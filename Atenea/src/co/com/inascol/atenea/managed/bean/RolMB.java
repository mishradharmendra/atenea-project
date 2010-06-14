package co.com.inascol.atenea.managed.bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIForm;
import javax.faces.component.UISelectBoolean;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import co.com.inascol.atenea.entity.GppPais;
import co.com.inascol.atenea.entity.GppRol;
import co.com.inascol.atenea.entity.GppServicio;
import co.com.inascol.atenea.managed.bean.delegate.PaisDelegate;
import co.com.inascol.atenea.managed.bean.delegate.RolDelegate;
import co.com.inascol.atenea.managed.bean.delegate.ServicioDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;


public class RolMB {

	private RolDelegate rolDelegate;
	private ServicioDelegate servicioDelegate;
	private int idRol;
	private String nombreRol;
	private String estadoRol;
	private String activoRol;
	private String descripcionRol;
	private String controlNavegacion;
	private List roles;
	private List serviciosRoles;
	private List servicios;
	private GppRol rol;
	private GppServicio servicio;
	
	public RolMB(){
		rolDelegate = new RolDelegate();
		roles = rolDelegate.getListaRols();
	}
	
	public String getNombreRol() {
		return nombreRol;
	}
	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}
	
	public String getDescripcionRol() {
		return descripcionRol;
	}
	public void setDescripcionRol(String descripcionRol) {
		this.descripcionRol = descripcionRol;
	}	
	public String getActivoRol() {
		return activoRol;
	}
	public void setActivoRol(String activoRol) {
		this.activoRol = activoRol;
	}	
	public String getEstadoRol() {
		return estadoRol;
	}
	public void setEstadoRol(String estadoRol) {
		this.estadoRol = estadoRol;
	}
	public GppRol getRol() {
		return rol;
	}
	public void setRol(GppRol rol) {
		this.rol = rol;
	}
	public List getRoles() {
		return roles;
	}
	public void setRoles(List roles) {
		this.roles = roles;
	}
	public List getServiciosRoles() {
		return serviciosRoles;
	}
	public void setServiciosRoles(List serviciosRoles) {
		this.serviciosRoles = serviciosRoles;
	}	
	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	public String getControlNavegacion() {
		return controlNavegacion;
	}
	public void setControlNavegacion(String controlNavegacion) {
		this.controlNavegacion = controlNavegacion;
	}
	public void getBuscarRolPorNombre() {
		roles = rolDelegate.getRolPorNombre(nombreRol);
	}
	public String getAgregarRol() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("RolMB");
		return ConstantesFaces.CREAR_ROL;
	}	
	public String getCrearRol() {	
		activoRol = "S";
		rolDelegate.getCrearRol(nombreRol, descripcionRol, activoRol, serviciosRoles);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("RolMB");
		return ConstantesFaces.HOME_ROL;
	}
	public String getSeleccionarRol(){
		rol = rolDelegate.getSeleccionarRol(idRol);
		return ConstantesFaces.DETALLE_ROL;
	}
	
	public String getModificarRol(){
		rolDelegate.getModificarRol(rol.getRolNidrol(), rol.getRolVnombre(), rol.getRolVdescripcion(), rol.getRolVactivo());
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("RolMB");
		return ConstantesFaces.HOME_ROL;
	}
	
	public String getCancelar(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("RolMB");
		return ConstantesFaces.HOME_ROL;
	}
	
	public List getServicios(){
		servicioDelegate = new ServicioDelegate();
		List listadoServicios = servicioDelegate.getListaServicios();
		return listadoServicios;
	}	
	
	public void  validateFunctions(FacesContext context, UIComponent component, Object value) {
	      String id = component.getClientId(context);
	      UIComponent parent = component;
	      while (!(parent instanceof UIForm)) parent = parent.getParent();
	      String formId = parent.getClientId(context);
	 
	      String dataTableId = (String) component.getAttributes().get("tablaServicioRol");
	      Integer a = (Integer) component.getAttributes().get("showpages");
	      int showpages = a == null ? 0 : a.intValue();      
	 
	      // find the component with the given ID
	 
	      UIData data = (UIData) component.findComponent(dataTableId);
		int count = data.getRowCount();
		System.out.println(count);
		boolean checked = false;
		Iterator it = servicios.iterator();
		for (int i=0; i < count; i++) {
			GppServicio gppServicio = (GppServicio) it.next();
			data.setRowIndex(i);
			UISelectBoolean box = (UISelectBoolean)data.findComponent("id_"+gppServicio.getSerNidservicio().toString());
			value = box.getValue();
			if (value instanceof Boolean) {
					checked |= ((Boolean)value).booleanValue();
			}
		}
		if (!checked) {
			FacesMessage message = new FacesMessage(
		"Validation Error. ", "At least one checkbox must be selected. ");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
	}
}