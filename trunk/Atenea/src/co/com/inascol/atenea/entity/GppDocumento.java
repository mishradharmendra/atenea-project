package co.com.inascol.atenea.entity;

// Generated 13/04/2010 04:01:21 PM by Hibernate Tools 3.3.0.GA

import java.util.Date;

/**
 * GppDocumento generated by hbm2java
 */
public class GppDocumento {

	private Integer docNiddocumento;
	private int perNidpersona;
	private int tarNidtipoarchivo;
	private String docVnombre;
	private String docVarchivo;
	private String docVurlarchivo;
	private Date docDfecexpide;
	private String docVusucrea;
	private Date docDfeccrea;
	private String docVusumodifica;
	private Date docDfecmodifica;

	public GppDocumento() {}

	public Integer getDocNiddocumento() {
		return this.docNiddocumento;
	}

	public void setDocNiddocumento(Integer docNiddocumento) {
		this.docNiddocumento = docNiddocumento;
	}

	public int getPerNidpersona() {
		return this.perNidpersona;
	}

	public void setPerNidpersona(int perNidpersona) {
		this.perNidpersona = perNidpersona;
	}

	public int getTarNidtipoarchivo() {
		return this.tarNidtipoarchivo;
	}

	public void setTarNidtipoarchivo(int tarNidtipoarchivo) {
		this.tarNidtipoarchivo = tarNidtipoarchivo;
	}

	public String getDocVnombre() {
		return this.docVnombre;
	}

	public void setDocVnombre(String docVnombre) {
		this.docVnombre = docVnombre;
	}

	public String getDocVarchivo() {
		return this.docVarchivo;
	}

	public void setDocVarchivo(String docVarchivo) {
		this.docVarchivo = docVarchivo;
	}

	public String getDocVurlarchivo() {
		return this.docVurlarchivo;
	}

	public void setDocVurlarchivo(String docVurlarchivo) {
		this.docVurlarchivo = docVurlarchivo;
	}

	public Date getDocDfecexpide() {
		return this.docDfecexpide;
	}

	public void setDocDfecexpide(Date docDfecexpide) {
		this.docDfecexpide = docDfecexpide;
	}

	public String getDocVusucrea() {
		return this.docVusucrea;
	}

	public void setDocVusucrea(String docVusucrea) {
		this.docVusucrea = docVusucrea;
	}

	public Date getDocDfeccrea() {
		return this.docDfeccrea;
	}

	public void setDocDfeccrea(Date docDfeccrea) {
		this.docDfeccrea = docDfeccrea;
	}

	public String getDocVusumodifica() {
		return this.docVusumodifica;
	}

	public void setDocVusumodifica(String docVusumodifica) {
		this.docVusumodifica = docVusumodifica;
	}

	public Date getDocDfecmodifica() {
		return this.docDfecmodifica;
	}

	public void setDocDfecmodifica(Date docDfecmodifica) {
		this.docDfecmodifica = docDfecmodifica;
	}

}