package co.com.inascol.atenea.entity;

import java.util.Date;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class GppEstadocivil {

	private Integer escNidestadocivil;
	private String escVestadocivil;
	private String escVusucrea;
	private Date escDfeccrea;
	private String escVusumodifica;
	private Date escDfecmodifica;

	public GppEstadocivil() {}

	public Integer getEscNidestadocivil() {
		return this.escNidestadocivil;
	}
	public void setEscNidestadocivil(Integer escNidestadocivil) {
		this.escNidestadocivil = escNidestadocivil;
	}
	public String getEscVestadocivil() {
		return this.escVestadocivil;
	}
	public void setEscVestadocivil(String escVestadocivil) {
		this.escVestadocivil = escVestadocivil;
	}
	public String getEscVusucrea() {
		return this.escVusucrea;
	}
	public void setEscVusucrea(String escVusucrea) {
		this.escVusucrea = escVusucrea;
	}
	public Date getEscDfeccrea() {
		return this.escDfeccrea;
	}
	public void setEscDfeccrea(Date escDfeccrea) {
		this.escDfeccrea = escDfeccrea;
	}
	public String getEscVusumodifica() {
		return this.escVusumodifica;
	}
	public void setEscVusumodifica(String escVusumodifica) {
		this.escVusumodifica = escVusumodifica;
	}
	public Date getEscDfecmodifica() {
		return this.escDfecmodifica;
	}
	public void setEscDfecmodifica(Date escDfecmodifica) {
		this.escDfecmodifica = escDfecmodifica;
	}
}