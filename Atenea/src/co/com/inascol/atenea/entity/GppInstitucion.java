package co.com.inascol.atenea.entity;

import java.util.Date;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class GppInstitucion {

	private Integer insNidinstitucion;
	private String insVinstitucion;
	private String insVusucrea;
	private Date insDfeccrea;
	private String insVusumodifica;
	private Date insDfecmodifica;

	public GppInstitucion() {}

	public Integer getInsNidinstitucion() {
		return this.insNidinstitucion;
	}
	public void setInsNidinstitucion(Integer insNidinstitucion) {
		this.insNidinstitucion = insNidinstitucion;
	}
	public String getInsVinstitucion() {
		return this.insVinstitucion;
	}
	public void setInsVinstitucion(String insVinstitucion) {
		this.insVinstitucion = insVinstitucion;
	}
	public String getInsVusucrea() {
		return this.insVusucrea;
	}
	public void setInsVusucrea(String insVusucrea) {
		this.insVusucrea = insVusucrea;
	}
	public Date getInsDfeccrea() {
		return this.insDfeccrea;
	}
	public void setInsDfeccrea(Date insDfeccrea) {
		this.insDfeccrea = insDfeccrea;
	}
	public String getInsVusumodifica() {
		return this.insVusumodifica;
	}
	public void setInsVusumodifica(String insVusumodifica) {
		this.insVusumodifica = insVusumodifica;
	}
	public Date getInsDfecmodifica() {
		return this.insDfecmodifica;
	}
	public void setInsDfecmodifica(Date insDfecmodifica) {
		this.insDfecmodifica = insDfecmodifica;
	}
}