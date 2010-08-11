package co.com.inascol.atenea.entity;

import java.util.Date;
/**
 * @author Guillermo Toro
 *
 */
public class GppFormacion {

	private Integer forNidformacion;
	private int perNidpersona;
	private String forVtitulo;
	private int nacNidnivelac;
	private int insNidinstitucion;
	private int teqNidtituloeq;
	private Date forDfecgrado;
	private Integer forNduracionmes;
	private String forVtarjetaprof;
	private Date forDfectarjeta;
	private Integer docNtarjetaprof;
	private Integer docNactagrado;
	private Integer docNidiploma;
	private String forVusucrea;
	private Date forDfeccrea;
	private String forVusumodifica;
	private Date forDfecmodifica;
	private GppInstitucion gppInstitucion;
	private GppNivelacademico gppNivelacademico;
	
	public GppFormacion() {}

	public Integer getForNidformacion() {
		return this.forNidformacion;
	}
	public void setForNidformacion(Integer forNidformacion) {
		this.forNidformacion = forNidformacion;
	}
	public int getPerNidpersona() {
		return this.perNidpersona;
	}
	public void setPerNidpersona(int perNidpersona) {
		this.perNidpersona = perNidpersona;
	}
	public String getForVtitulo() {
		return this.forVtitulo;
	}
	public void setForVtitulo(String forVtitulo) {
		this.forVtitulo = forVtitulo;
	}
	public int getNacNidnivelac() {
		return this.nacNidnivelac;
	}
	public void setNacNidnivelac(int nacNidnivelac) {
		this.nacNidnivelac = nacNidnivelac;
	}
	public int getInsNidinstitucion() {
		return this.insNidinstitucion;
	}
	public void setInsNidinstitucion(int insNidinstitucion) {
		this.insNidinstitucion = insNidinstitucion;
	}
	public int getTeqNidtituloeq() {
		return this.teqNidtituloeq;
	}
	public void setTeqNidtituloeq(int teqNidtituloeq) {
		this.teqNidtituloeq = teqNidtituloeq;
	}
	public Date getForDfecgrado() {
		return this.forDfecgrado;
	}
	public void setForDfecgrado(Date forDfecgrado) {
		this.forDfecgrado = forDfecgrado;
	}
	public Integer getForNduracionmes() {
		return this.forNduracionmes;
	}
	public void setForNduracionmes(Integer forNduracionmes) {
		this.forNduracionmes = forNduracionmes;
	}
	public String getForVtarjetaprof() {
		return this.forVtarjetaprof;
	}
	public void setForVtarjetaprof(String forVtarjetaprof) {
		this.forVtarjetaprof = forVtarjetaprof;
	}
	public Date getForDfectarjeta() {
		return this.forDfectarjeta;
	}
	public void setForDfectarjeta(Date forDfectarjeta) {
		this.forDfectarjeta = forDfectarjeta;
	}
	public Integer getDocNtarjetaprof() {
		return this.docNtarjetaprof;
	}
	public void setDocNtarjetaprof(Integer docNtarjetaprof) {
		this.docNtarjetaprof = docNtarjetaprof;
	}
	public Integer getDocNactagrado() {
		return this.docNactagrado;
	}
	public void setDocNactagrado(Integer docNactagrado) {
		this.docNactagrado = docNactagrado;
	}
	public Integer getDocNidiploma() {
		return this.docNidiploma;
	}
	public void setDocNidiploma(Integer docNidiploma) {
		this.docNidiploma = docNidiploma;
	}
	public String getForVusucrea() {
		return this.forVusucrea;
	}
	public void setForVusucrea(String forVusucrea) {
		this.forVusucrea = forVusucrea;
	}
	public Date getForDfeccrea() {
		return this.forDfeccrea;
	}
	public void setForDfeccrea(Date forDfeccrea) {
		this.forDfeccrea = forDfeccrea;
	}
	public String getForVusumodifica() {
		return this.forVusumodifica;
	}
	public void setForVusumodifica(String forVusumodifica) {
		this.forVusumodifica = forVusumodifica;
	}
	public Date getForDfecmodifica() {
		return this.forDfecmodifica;
	}
	public void setForDfecmodifica(Date forDfecmodifica) {
		this.forDfecmodifica = forDfecmodifica;
	}
	public GppInstitucion getGppInstitucion() {
		return gppInstitucion;
	}
	public void setGppInstitucion(GppInstitucion gppInstitucion) {
		this.gppInstitucion = gppInstitucion;
	}
	public GppNivelacademico getGppNivelacademico() {
		return gppNivelacademico;
	}
	public void setGppNivelacademico(GppNivelacademico gppNivelacademico) {
		this.gppNivelacademico = gppNivelacademico;
	}	
}