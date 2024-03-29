package co.com.inascol.atenea.entity;

import java.util.Date;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class GppUsuariorol {

	private GppUsuariorolId id;
	private String urlVusucrea;
	private Date urlDfeccrea;

	public GppUsuariorol() {}

	public GppUsuariorolId getId() {
		return this.id;
	}
	public void setId(GppUsuariorolId id) {
		this.id = id;
	}
	public String getUrlVusucrea() {
		return this.urlVusucrea;
	}
	public void setUrlVusucrea(String urlVusucrea) {
		this.urlVusucrea = urlVusucrea;
	}
	public Date getUrlDfeccrea() {
		return this.urlDfeccrea;
	}
	public void setUrlDfeccrea(Date urlDfeccrea) {
		this.urlDfeccrea = urlDfeccrea;
	}
}