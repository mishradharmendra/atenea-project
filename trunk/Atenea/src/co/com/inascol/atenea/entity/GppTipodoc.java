package co.com.inascol.atenea.entity;

import java.util.Date;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class GppTipodoc {

	private Integer tdcNidtipodoc;
	private String tdcVnombre;
	private String tdcVusucrea;
	private Date tdcDfeccrea;
	private String tdcVusumodifica;
	private Date tdcDfecmodifica;

	public GppTipodoc() {}

	public Integer getTdcNidtipodoc() {
		return this.tdcNidtipodoc;
	}
	public void setTdcNidtipodoc(Integer tdcNidtipodoc) {
		this.tdcNidtipodoc = tdcNidtipodoc;
	}
	public String getTdcVnombre() {
		return this.tdcVnombre;
	}
	public void setTdcVnombre(String tdcVnombre) {
		this.tdcVnombre = tdcVnombre;
	}
	public String getTdcVusucrea() {
		return this.tdcVusucrea;
	}
	public void setTdcVusucrea(String tdcVusucrea) {
		this.tdcVusucrea = tdcVusucrea;
	}
	public Date getTdcDfeccrea() {
		return this.tdcDfeccrea;
	}
	public void setTdcDfeccrea(Date tdcDfeccrea) {
		this.tdcDfeccrea = tdcDfeccrea;
	}
	public String getTdcVusumodifica() {
		return this.tdcVusumodifica;
	}
	public void setTdcVusumodifica(String tdcVusumodifica) {
		this.tdcVusumodifica = tdcVusumodifica;
	}
	public Date getTdcDfecmodifica() {
		return this.tdcDfecmodifica;
	}
	public void setTdcDfecmodifica(Date tdcDfecmodifica) {
		this.tdcDfecmodifica = tdcDfecmodifica;
	}
}