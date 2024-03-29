package co.com.inascol.atenea.entity;

import java.util.Date;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class GppTituloequivalente  {

	private Integer teqNidtituloeq;
	private String teqVtituloeq;
	private String teqVusucrea;
	private Date teqDfeccrea;
	private String teqVusumodifica;
	private Date teqDfecmodifica;

	public GppTituloequivalente() {}

	public Integer getTeqNidtituloeq() {
		return this.teqNidtituloeq;
	}
	public void setTeqNidtituloeq(Integer teqNidtituloeq) {
		this.teqNidtituloeq = teqNidtituloeq;
	}
	public String getTeqVtituloeq() {
		return this.teqVtituloeq;
	}
	public void setTeqVtituloeq(String teqVtituloeq) {
		this.teqVtituloeq = teqVtituloeq;
	}
	public String getTeqVusucrea() {
		return this.teqVusucrea;
	}
	public void setTeqVusucrea(String teqVusucrea) {
		this.teqVusucrea = teqVusucrea;
	}
	public Date getTeqDfeccrea() {
		return this.teqDfeccrea;
	}
	public void setTeqDfeccrea(Date teqDfeccrea) {
		this.teqDfeccrea = teqDfeccrea;
	}
	public String getTeqVusumodifica() {
		return this.teqVusumodifica;
	}
	public void setTeqVusumodifica(String teqVusumodifica) {
		this.teqVusumodifica = teqVusumodifica;
	}
	public Date getTeqDfecmodifica() {
		return this.teqDfecmodifica;
	}
	public void setTeqDfecmodifica(Date teqDfecmodifica) {
		this.teqDfecmodifica = teqDfecmodifica;
	}
}