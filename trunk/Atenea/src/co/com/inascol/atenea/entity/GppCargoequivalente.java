package co.com.inascol.atenea.entity;

// Generated 13/04/2010 04:01:21 PM by Hibernate Tools 3.3.0.GA

import java.util.Date;

/**
 * GppCargoequivalente generated by hbm2java
 */
public class GppCargoequivalente implements java.io.Serializable {

	private Integer ceqNidcargoeq;
	private String ceqVcargoeq;
	private String ceqVusucrea;
	private Date ceqDfeccrea;
	private String ceqVusumodifica;
	private Date ceqDfecmodifica;

	public GppCargoequivalente() {
	}

	public GppCargoequivalente(String ceqVcargoeq, String ceqVusucrea,
			Date ceqDfeccrea) {
		this.ceqVcargoeq = ceqVcargoeq;
		this.ceqVusucrea = ceqVusucrea;
		this.ceqDfeccrea = ceqDfeccrea;
	}

	public GppCargoequivalente(String ceqVcargoeq, String ceqVusucrea,
			Date ceqDfeccrea, String ceqVusumodifica, Date ceqDfecmodifica) {
		this.ceqVcargoeq = ceqVcargoeq;
		this.ceqVusucrea = ceqVusucrea;
		this.ceqDfeccrea = ceqDfeccrea;
		this.ceqVusumodifica = ceqVusumodifica;
		this.ceqDfecmodifica = ceqDfecmodifica;
	}

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
