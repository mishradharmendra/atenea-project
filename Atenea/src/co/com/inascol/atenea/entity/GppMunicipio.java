package co.com.inascol.atenea.entity;

import java.util.Date;
/**
 * @author Guillermo Toro
 *
 */
public class GppMunicipio {

	private Integer munNidmunicipio;
	private Integer dptNiddepto;
	private String munVmunicipio;
	private String munVusucrea;
	private Date munDfeccrea;
	private String munVusumodifica;
	private Date munDfecmodifica;

	public GppMunicipio() {}

	public Integer getMunNidmunicipio() {
		return munNidmunicipio;
	}
	public void setMunNidmunicipio(Integer munNidmunicipio) {
		this.munNidmunicipio = munNidmunicipio;
	}
	public Integer getDptNiddepto() {
		return dptNiddepto;
	}
	public void setDptNiddepto(Integer dptNiddepto) {
		this.dptNiddepto = dptNiddepto;
	}
	public String getMunVmunicipio() {
		return this.munVmunicipio;
	}
	public void setMunVmunicipio(String munVmunicipio) {
		this.munVmunicipio = munVmunicipio;
	}
	public String getMunVusucrea() {
		return this.munVusucrea;
	}
	public void setMunVusucrea(String munVusucrea) {
		this.munVusucrea = munVusucrea;
	}
	public Date getMunDfeccrea() {
		return this.munDfeccrea;
	}
	public void setMunDfeccrea(Date munDfeccrea) {
		this.munDfeccrea = munDfeccrea;
	}
	public String getMunVusumodifica() {
		return this.munVusumodifica;
	}
	public void setMunVusumodifica(String munVusumodifica) {
		this.munVusumodifica = munVusumodifica;
	}
	public Date getMunDfecmodifica() {
		return this.munDfecmodifica;
	}
	public void setMunDfecmodifica(Date munDfecmodifica) {
		this.munDfecmodifica = munDfecmodifica;
	}
}