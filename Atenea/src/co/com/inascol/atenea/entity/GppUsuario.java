package co.com.inascol.atenea.entity;

import java.util.Date;
import java.util.List;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class GppUsuario {

	private Integer usuNidusuario;
	private String usuVnombre;
	private String usuVlogin;
	private Boolean usuBactivo;
	private String usuVemail;
	private String usuVtelefono;
	private String usuVusucrea;
	private Date usuDfeccrea;
	private String usuVusumodifica;
	private Date usuDfecmodifica;
	private List<Object> gppRoles;
	private List<Object> roles;
	
	public GppUsuario() {}

	public Integer getUsuNidusuario() {
		return this.usuNidusuario;
	}
	public void setUsuNidusuario(Integer usuNidusuario) {
		this.usuNidusuario = usuNidusuario;
	}
	public String getUsuVnombre() {
		return this.usuVnombre;
	}
	public void setUsuVnombre(String usuVnombre) {
		this.usuVnombre = usuVnombre;
	}
	public String getUsuVlogin() {
		return this.usuVlogin;
	}
	public void setUsuVlogin(String usuVlogin) {
		this.usuVlogin = usuVlogin;
	}
	public Boolean getUsuBactivo() {
		return usuBactivo;
	}
	public void setUsuBactivo(Boolean usuBactivo) {
		this.usuBactivo = usuBactivo;
	}
	public String getUsuVemail() {
		return this.usuVemail;
	}
	public void setUsuVemail(String usuVemail) {
		this.usuVemail = usuVemail;
	}
	public String getUsuVtelefono() {
		return this.usuVtelefono;
	}
	public void setUsuVtelefono(String usuVtelefono) {
		this.usuVtelefono = usuVtelefono;
	}
	public String getUsuVusucrea() {
		return this.usuVusucrea;
	}
	public void setUsuVusucrea(String usuVusucrea) {
		this.usuVusucrea = usuVusucrea;
	}
	public Date getUsuDfeccrea() {
		return this.usuDfeccrea;
	}
	public void setUsuDfeccrea(Date usuDfeccrea) {
		this.usuDfeccrea = usuDfeccrea;
	}
	public String getUsuVusumodifica() {
		return this.usuVusumodifica;
	}
	public void setUsuVusumodifica(String usuVusumodifica) {
		this.usuVusumodifica = usuVusumodifica;
	}
	public Date getUsuDfecmodifica() {
		return this.usuDfecmodifica;
	}
	public void setUsuDfecmodifica(Date usuDfecmodifica) {
		this.usuDfecmodifica = usuDfecmodifica;
	}
	public void setGppRoles(List<Object> gppRoles) {
		this.gppRoles = gppRoles;
	}
	public List<Object> getGppRoles() {
		return gppRoles;
	}
	public List<Object> getRoles() {
		return roles;
	}
	public void setRoles(List<Object> roles) {
		this.roles = roles;
	}
}