package co.com.inascol.atenea.entity;

// Generated 13/04/2010 04:01:21 PM by Hibernate Tools 3.3.0.GA

import java.util.Date;

/**
 * GppPerfilequivalente generated by hbm2java
 */
public class GppPerfilequivalente implements java.io.Serializable {

	private Integer peqNidperfileq;
	private String peqVperfileq;
	private String peqVusucrea;
	private Date peqDfeccrea;
	private String peqVusumodifica;
	private Date peqDfecmodifica;

	public GppPerfilequivalente() {
	}

	public GppPerfilequivalente(String peqVperfileq, String peqVusucrea,
			Date peqDfeccrea) {
		this.peqVperfileq = peqVperfileq;
		this.peqVusucrea = peqVusucrea;
		this.peqDfeccrea = peqDfeccrea;
	}

	public GppPerfilequivalente(String peqVperfileq, String peqVusucrea,
			Date peqDfeccrea, String peqVusumodifica, Date peqDfecmodifica) {
		this.peqVperfileq = peqVperfileq;
		this.peqVusucrea = peqVusucrea;
		this.peqDfeccrea = peqDfeccrea;
		this.peqVusumodifica = peqVusumodifica;
		this.peqDfecmodifica = peqDfecmodifica;
	}

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
