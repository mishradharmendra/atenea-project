package co.com.inascol.atenea.entity;

import java.util.Date;
import java.util.List;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class GppPersona {

	private Integer perNidpersona;
	private Integer munNidmunicipio;
	private String perVnombres;
	private String perVapellidos;
	private Integer tdcNidtipodoc;
	private Integer perNidentificacion;
	private String perVsexo;
	private Integer escNidestadocivil;
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
	private Integer paiNpaisresidencia;
	private Integer munNmpioresidencia;
	private Boolean perBactivo;
	private GppPerfilprof gppPerfilprofesional;
	private List<Object> gppFormaciones;
	private List<Object> gppCertificaciones;
	private List<Object> gppExperienciasLaborales;
	private Integer perNpuntaje;
	
	public GppPersona() {}

	public Integer getPerNidpersona() {
		return this.perNidpersona;
	}
	public void setPerNidpersona(Integer perNidpersona) {
		this.perNidpersona = perNidpersona;
	}
	public Integer getMunNidmunicipio() {
		return munNidmunicipio;
	}
	public void setMunNidmunicipio(Integer munNidmunicipio) {
		this.munNidmunicipio = munNidmunicipio;
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
	public Integer getTdcNidtipodoc() {
		return this.tdcNidtipodoc;
	}
	public void setTdcNidtipodoc(Integer tdcNidtipodoc) {
		this.tdcNidtipodoc = tdcNidtipodoc;
	}
	public Integer getPerNidentificacion() {
		return this.perNidentificacion;
	}
	public void setPerNidentificacion(Integer perNidentificacion) {
		this.perNidentificacion = perNidentificacion;
	}
	public String getPerVsexo() {
		return this.perVsexo;
	}
	public void setPerVsexo(String perVsexo) {
		this.perVsexo = perVsexo;
	}
	public Integer getEscNidestadocivil() {
		return this.escNidestadocivil;
	}
	public void setEscNidestadocivil(Integer escNidestadocivil) {
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
	public GppPerfilprof getGppPerfilprofesional() {
		return gppPerfilprofesional;
	}
	public void setGppPerfilprofesional(GppPerfilprof gppPerfilprofesional) {
		this.gppPerfilprofesional = gppPerfilprofesional;
	}
	public Integer getPaiNpaisresidencia() {
		return paiNpaisresidencia;
	}
	public void setPaiNpaisresidencia(Integer paiNpaisresidencia) {
		this.paiNpaisresidencia = paiNpaisresidencia;
	}
	public Integer getMunNmpioresidencia() {
		return munNmpioresidencia;
	}
	public void setMunNmpioresidencia(Integer munNmpioresidencia) {
		this.munNmpioresidencia = munNmpioresidencia;
	}
	public Boolean getPerBactivo() {
		return perBactivo;
	}
	public void setPerBactivo(Boolean perBactivo) {
		this.perBactivo = perBactivo;
	}
	public List<Object> getGppFormaciones() {
		return gppFormaciones;
	}
	public void setGppFormaciones(List<Object> gppFormaciones) {
		this.gppFormaciones = gppFormaciones;
	}
	public List<Object> getGppCertificaciones() {
		return gppCertificaciones;
	}
	public void setGppCertificaciones(List<Object> gppCertificaciones) {
		this.gppCertificaciones = gppCertificaciones;
	}
	public Integer getPerNpuntaje() {
		return perNpuntaje;
	}
	public void setPerNpuntaje(Integer perNpuntaje) {
		this.perNpuntaje = perNpuntaje;
	}
	public List<Object> getGppExperienciasLaborales() {
		return gppExperienciasLaborales;
	}
	public void setGppExperienciasLaborales(List<Object> gppExperienciasLaborales) {
		this.gppExperienciasLaborales = gppExperienciasLaborales;
	}
}