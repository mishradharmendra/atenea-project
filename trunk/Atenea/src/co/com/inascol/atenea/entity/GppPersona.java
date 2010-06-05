package co.com.inascol.atenea.entity;

// Generated 13/04/2010 04:01:21 PM by Hibernate Tools 3.3.0.GA

import java.util.Date;

/**
 * GppPersona generated by hbm2java
 */
public class GppPersona implements java.io.Serializable {

	private Integer perNidpersona;
	private String gppMunicipioMunVidmunicipio;
	private String perVnombres;
	private String perVapellidos;
	private int tdcNidtipodoc;
	private int perNidentificacion;
	private String perVsexo;
	private int escNidestadocivil;
	private Date perDfecnacimiento;
	private String perVlibretamilitar;
	private String perVmovil;
	private String perVemail;
	private String perVdireccion;
	private String perVtelefono;
	private String perVusucrea;
	private Date perDfeccrea;
	private String perVusumodifica;
	private Date perDfecmodifica;

	public GppPersona() {
	}

	public GppPersona(String gppMunicipioMunVidmunicipio, String perVnombres,
			String perVapellidos, int tdcNidtipodoc, int perNidentificacion,
			String perVsexo, int escNidestadocivil, String perVusucrea,
			Date perDfeccrea) {
		this.gppMunicipioMunVidmunicipio = gppMunicipioMunVidmunicipio;
		this.perVnombres = perVnombres;
		this.perVapellidos = perVapellidos;
		this.tdcNidtipodoc = tdcNidtipodoc;
		this.perNidentificacion = perNidentificacion;
		this.perVsexo = perVsexo;
		this.escNidestadocivil = escNidestadocivil;
		this.perVusucrea = perVusucrea;
		this.perDfeccrea = perDfeccrea;
	}

	public GppPersona(String gppMunicipioMunVidmunicipio, String perVnombres,
			String perVapellidos, int tdcNidtipodoc, int perNidentificacion,
			String perVsexo, int escNidestadocivil, Date perDfecnacimiento,
			String perVlibretamilitar, String perVmovil, String perVemail,
			String perVdireccion, String perVtelefono, String perVusucrea,
			Date perDfeccrea, String perVusumodifica, Date perDfecmodifica) {
		this.gppMunicipioMunVidmunicipio = gppMunicipioMunVidmunicipio;
		this.perVnombres = perVnombres;
		this.perVapellidos = perVapellidos;
		this.tdcNidtipodoc = tdcNidtipodoc;
		this.perNidentificacion = perNidentificacion;
		this.perVsexo = perVsexo;
		this.escNidestadocivil = escNidestadocivil;
		this.perDfecnacimiento = perDfecnacimiento;
		this.perVlibretamilitar = perVlibretamilitar;
		this.perVmovil = perVmovil;
		this.perVemail = perVemail;
		this.perVdireccion = perVdireccion;
		this.perVtelefono = perVtelefono;
		this.perVusucrea = perVusucrea;
		this.perDfeccrea = perDfeccrea;
		this.perVusumodifica = perVusumodifica;
		this.perDfecmodifica = perDfecmodifica;
	}

	public Integer getPerNidpersona() {
		return this.perNidpersona;
	}

	public void setPerNidpersona(Integer perNidpersona) {
		this.perNidpersona = perNidpersona;
	}

	public String getGppMunicipioMunVidmunicipio() {
		return this.gppMunicipioMunVidmunicipio;
	}

	public void setGppMunicipioMunVidmunicipio(
			String gppMunicipioMunVidmunicipio) {
		this.gppMunicipioMunVidmunicipio = gppMunicipioMunVidmunicipio;
	}

	public String getPerVnombres() {
		return this.perVnombres;
	}

	public void setPerVnombres(String perVnombres) {
		this.perVnombres = perVnombres;
	}

	public String getPerVapellidos() {
		return this.perVapellidos;
	}

	public void setPerVapellidos(String perVapellidos) {
		this.perVapellidos = perVapellidos;
	}

	public int getTdcNidtipodoc() {
		return this.tdcNidtipodoc;
	}

	public void setTdcNidtipodoc(int tdcNidtipodoc) {
		this.tdcNidtipodoc = tdcNidtipodoc;
	}

	public int getPerNidentificacion() {
		return this.perNidentificacion;
	}

	public void setPerNidentificacion(int perNidentificacion) {
		this.perNidentificacion = perNidentificacion;
	}

	public String getPerVsexo() {
		return this.perVsexo;
	}

	public void setPerVsexo(String perVsexo) {
		this.perVsexo = perVsexo;
	}

	public int getEscNidestadocivil() {
		return this.escNidestadocivil;
	}

	public void setEscNidestadocivil(int escNidestadocivil) {
		this.escNidestadocivil = escNidestadocivil;
	}

	public Date getPerDfecnacimiento() {
		return this.perDfecnacimiento;
	}

	public void setPerDfecnacimiento(Date perDfecnacimiento) {
		this.perDfecnacimiento = perDfecnacimiento;
	}

	public String getPerVlibretamilitar() {
		return this.perVlibretamilitar;
	}

	public void setPerVlibretamilitar(String perVlibretamilitar) {
		this.perVlibretamilitar = perVlibretamilitar;
	}

	public String getPerVmovil() {
		return this.perVmovil;
	}

	public void setPerVmovil(String perVmovil) {
		this.perVmovil = perVmovil;
	}

	public String getPerVemail() {
		return this.perVemail;
	}

	public void setPerVemail(String perVemail) {
		this.perVemail = perVemail;
	}

	public String getPerVdireccion() {
		return this.perVdireccion;
	}

	public void setPerVdireccion(String perVdireccion) {
		this.perVdireccion = perVdireccion;
	}

	public String getPerVtelefono() {
		return this.perVtelefono;
	}

	public void setPerVtelefono(String perVtelefono) {
		this.perVtelefono = perVtelefono;
	}

	public String getPerVusucrea() {
		return this.perVusucrea;
	}

	public void setPerVusucrea(String perVusucrea) {
		this.perVusucrea = perVusucrea;
	}

	public Date getPerDfeccrea() {
		return this.perDfeccrea;
	}

	public void setPerDfeccrea(Date perDfeccrea) {
		this.perDfeccrea = perDfeccrea;
	}

	public String getPerVusumodifica() {
		return this.perVusumodifica;
	}

	public void setPerVusumodifica(String perVusumodifica) {
		this.perVusumodifica = perVusumodifica;
	}

	public Date getPerDfecmodifica() {
		return this.perDfecmodifica;
	}

	public void setPerDfecmodifica(Date perDfecmodifica) {
		this.perDfecmodifica = perDfecmodifica;
	}

}
