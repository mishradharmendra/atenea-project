package co.com.inascol.atenea.entity;

import java.util.Date;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class GppDepartamento {

	private Integer dptNiddepto;
	private Integer paiNidpais;
	private String dptVdepto;
	private String dptVusucrea;
	private Date dptDfeccrea;
	private String dptVusumodifica;
	private Date dptDfecmodifica;

	public GppDepartamento() {}

	public Integer getDptNiddepto() {
		return dptNiddepto;
	}
	public void setDptNiddepto(Integer dptNiddepto) {
		this.dptNiddepto = dptNiddepto;
	}
	public Integer getPaiNidpais() {
		return paiNidpais;
	}
	public void setPaiNidpais(Integer paiNidpais) {
		this.paiNidpais = paiNidpais;
	}
	public String getDptVdepto() {
		return this.dptVdepto;
	}
	public void setDptVdepto(String dptVdepto) {
		this.dptVdepto = dptVdepto;
	}
	public String getDptVusucrea() {
		return this.dptVusucrea;
	}
	public void setDptVusucrea(String dptVusucrea) {
		this.dptVusucrea = dptVusucrea;
	}
	public Date getDptDfeccrea() {
		return this.dptDfeccrea;
	}
	public void setDptDfeccrea(Date dptDfeccrea) {
		this.dptDfeccrea = dptDfeccrea;
	}
	public String getDptVusumodifica() {
		return this.dptVusumodifica;
	}
	public void setDptVusumodifica(String dptVusumodifica) {
		this.dptVusumodifica = dptVusumodifica;
	}
	public Date getDptDfecmodifica() {
		return this.dptDfecmodifica;
	}
	public void setDptDfecmodifica(Date dptDfecmodifica) {
		this.dptDfecmodifica = dptDfecmodifica;
	}
}