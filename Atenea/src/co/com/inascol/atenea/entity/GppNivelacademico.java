package co.com.inascol.atenea.entity;

import java.util.Date;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class GppNivelacademico {

	private Integer nacNidnivelac;
	private String nacVnivelac;
	private String nacVusucrea;
	private Date nacDfeccrea;
	private String nacVusumodifica;
	private Date nacDfecmodifica;

	public GppNivelacademico() {}

	public Integer getNacNidnivelac() {
		return this.nacNidnivelac;
	}
	public void setNacNidnivelac(Integer nacNidnivelac) {
		this.nacNidnivelac = nacNidnivelac;
	}
	public String getNacVnivelac() {
		return this.nacVnivelac;
	}
	public void setNacVnivelac(String nacVnivelac) {
		this.nacVnivelac = nacVnivelac;
	}
	public String getNacVusucrea() {
		return this.nacVusucrea;
	}
	public void setNacVusucrea(String nacVusucrea) {
		this.nacVusucrea = nacVusucrea;
	}
	public Date getNacDfeccrea() {
		return this.nacDfeccrea;
	}
	public void setNacDfeccrea(Date nacDfeccrea) {
		this.nacDfeccrea = nacDfeccrea;
	}
	public String getNacVusumodifica() {
		return this.nacVusumodifica;
	}
	public void setNacVusumodifica(String nacVusumodifica) {
		this.nacVusumodifica = nacVusumodifica;
	}
	public Date getNacDfecmodifica() {
		return this.nacDfecmodifica;
	}
	public void setNacDfecmodifica(Date nacDfecmodifica) {
		this.nacDfecmodifica = nacDfecmodifica;
	}
}