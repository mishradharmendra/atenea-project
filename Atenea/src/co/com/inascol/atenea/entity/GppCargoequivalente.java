package co.com.inascol.atenea.entity;

import java.util.Date;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class GppCargoequivalente {

	private Integer ceqNidcargoeq;
	private String ceqVcargoeq;
	private String ceqVusucrea;
	private Date ceqDfeccrea;
	private String ceqVusumodifica;
	private Date ceqDfecmodifica;

	public GppCargoequivalente() {}

	public Integer getCeqNidcargoeq() {
		return this.ceqNidcargoeq;
	}
	public void setCeqNidcargoeq(Integer ceqNidcargoeq) {
		this.ceqNidcargoeq = ceqNidcargoeq;
	}
	public String getCeqVcargoeq() {
		return this.ceqVcargoeq;
	}
	public void setCeqVcargoeq(String ceqVcargoeq) {
		this.ceqVcargoeq = ceqVcargoeq;
	}
	public String getCeqVusucrea() {
		return this.ceqVusucrea;
	}
	public void setCeqVusucrea(String ceqVusucrea) {
		this.ceqVusucrea = ceqVusucrea;
	}
	public Date getCeqDfeccrea() {
		return this.ceqDfeccrea;
	}
	public void setCeqDfeccrea(Date ceqDfeccrea) {
		this.ceqDfeccrea = ceqDfeccrea;
	}
	public String getCeqVusumodifica() {
		return this.ceqVusumodifica;
	}
	public void setCeqVusumodifica(String ceqVusumodifica) {
		this.ceqVusumodifica = ceqVusumodifica;
	}
	public Date getCeqDfecmodifica() {
		return this.ceqDfecmodifica;
	}
	public void setCeqDfecmodifica(Date ceqDfecmodifica) {
		this.ceqDfecmodifica = ceqDfecmodifica;
	}
}