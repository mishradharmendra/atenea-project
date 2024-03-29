package co.com.inascol.atenea.entity;

import java.util.Date;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class GppPerfilequivalente {

	private Integer peqNidperfileq;
	private String peqVperfileq;
	private String peqVusucrea;
	private Date peqDfeccrea;
	private String peqVusumodifica;
	private Date peqDfecmodifica;

	public GppPerfilequivalente() {}

	public Integer getPeqNidperfileq() {
		return this.peqNidperfileq;
	}
	public void setPeqNidperfileq(Integer peqNidperfileq) {
		this.peqNidperfileq = peqNidperfileq;
	}
	public String getPeqVperfileq() {
		return this.peqVperfileq;
	}
	public void setPeqVperfileq(String peqVperfileq) {
		this.peqVperfileq = peqVperfileq;
	}
	public String getPeqVusucrea() {
		return this.peqVusucrea;
	}
	public void setPeqVusucrea(String peqVusucrea) {
		this.peqVusucrea = peqVusucrea;
	}
	public Date getPeqDfeccrea() {
		return this.peqDfeccrea;
	}
	public void setPeqDfeccrea(Date peqDfeccrea) {
		this.peqDfeccrea = peqDfeccrea;
	}
	public String getPeqVusumodifica() {
		return this.peqVusumodifica;
	}
	public void setPeqVusumodifica(String peqVusumodifica) {
		this.peqVusumodifica = peqVusumodifica;
	}
	public Date getPeqDfecmodifica() {
		return this.peqDfecmodifica;
	}
	public void setPeqDfecmodifica(Date peqDfecmodifica) {
		this.peqDfecmodifica = peqDfecmodifica;
	}
}