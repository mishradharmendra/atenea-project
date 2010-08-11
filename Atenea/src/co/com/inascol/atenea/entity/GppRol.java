package co.com.inascol.atenea.entity;

import java.util.Date;
import java.util.List;
/**
 * @author Guillermo Toro
 *
 */
public class GppRol  {

	private Integer rolNidrol;
	private String rolVnombre;
	private String rolVdescripcion;
	private Boolean rolBactivo;
	private String rolVusucrea;
	private Date rolDfeccrea;
	private String rolVusumodifica;
	private Date rolDfecmodifica;
	private List <Object> servicios;
	private List <Object> gppServicios;
	
	public GppRol() {}

	public Integer getRolNidrol() {
		return this.rolNidrol;
	}
	public void setRolNidrol(Integer rolNidrol) {
		this.rolNidrol = rolNidrol;
	}
	public String getRolVnombre() {
		return this.rolVnombre;
	}
	public void setRolVnombre(String rolVnombre) {
		this.rolVnombre = rolVnombre;
	}
	public String getRolVdescripcion() {
		return this.rolVdescripcion;
	}
	public void setRolVdescripcion(String rolVdescripcion) {
		this.rolVdescripcion = rolVdescripcion;
	}
	public Boolean getRolBactivo() {
		return rolBactivo;
	}
	public void setRolBactivo(Boolean rolBactivo) {
		this.rolBactivo = rolBactivo;
	}
	public String getRolVusucrea() {
		return this.rolVusucrea;
	}
	public void setRolVusucrea(String rolVusucrea) {
		this.rolVusucrea = rolVusucrea;
	}
	public Date getRolDfeccrea() {
		return this.rolDfeccrea;
	}
	public void setRolDfeccrea(Date rolDfeccrea) {
		this.rolDfeccrea = rolDfeccrea;
	}
	public String getRolVusumodifica() {
		return this.rolVusumodifica;
	}
	public void setRolVusumodifica(String rolVusumodifica) {
		this.rolVusumodifica = rolVusumodifica;
	}
	public Date getRolDfecmodifica() {
		return this.rolDfecmodifica;
	}
	public void setRolDfecmodifica(Date rolDfecmodifica) {
		this.rolDfecmodifica = rolDfecmodifica;
	}
	public List<Object> getGppServicios() {
		return gppServicios;
	}
	public void setGppServicios(List<Object> gppServicios) {
		this.gppServicios = gppServicios;
	}
	public List<Object> getServicios() {
		return servicios;
	}
	public void setServicios(List<Object> servicios) {
		this.servicios = servicios;
	}
}