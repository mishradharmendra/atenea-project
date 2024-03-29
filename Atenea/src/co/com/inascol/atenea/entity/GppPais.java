package co.com.inascol.atenea.entity;

import java.util.Date;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class GppPais {

	private Integer paiNidpais;
	private String paiVpais;
	private String paiVusucrea;
	private Date paiDfeccrea;
	private String paiVusumodifica;
	private Date paiDfecmodifica;

	public GppPais() {}

	public Integer getPaiNidpais() {
		return paiNidpais;
	}
	public void setPaiNidpais(Integer paiNidpais) {
		this.paiNidpais = paiNidpais;
	}
	public String getPaiVpais() {
		return this.paiVpais;
	}
	public void setPaiVpais(String paiVpais) {
		this.paiVpais = paiVpais;
	}
	public String getPaiVusucrea() {
		return this.paiVusucrea;
	}
	public void setPaiVusucrea(String paiVusucrea) {
		this.paiVusucrea = paiVusucrea;
	}
	public Date getPaiDfeccrea() {
		return this.paiDfeccrea;
	}
	public void setPaiDfeccrea(Date paiDfeccrea) {
		this.paiDfeccrea = paiDfeccrea;
	}
	public String getPaiVusumodifica() {
		return this.paiVusumodifica;
	}
	public void setPaiVusumodifica(String paiVusumodifica) {
		this.paiVusumodifica = paiVusumodifica;
	}
	public Date getPaiDfecmodifica() {
		return this.paiDfecmodifica;
	}
	public void setPaiDfecmodifica(Date paiDfecmodifica) {
		this.paiDfecmodifica = paiDfecmodifica;
	}
}