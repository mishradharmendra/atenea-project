package co.com.inascol.atenea.entity;

import java.util.Date;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class GppServicio  {

	private Integer serNidservicio;
	private String serVnombre;
	private String serVruta;
	private String serVusucrea;
	private Date serDfeccrea;
	private Boolean serBservicioActivado;
	
	public GppServicio() {}

	public GppServicio(String serVusucrea, Date serDfeccrea) {
		this.serVusucrea = serVusucrea;
		this.serDfeccrea = serDfeccrea;
	}
	public GppServicio(String serVnombre, String serVruta, String serVusucrea,
			Date serDfeccrea) {
		this.serVnombre = serVnombre;
		this.serVruta = serVruta;
		this.serVusucrea = serVusucrea;
		this.serDfeccrea = serDfeccrea;
	}
	public Integer getSerNidservicio() {
		return this.serNidservicio;
	}
	public void setSerNidservicio(Integer serNidservicio) {
		this.serNidservicio = serNidservicio;
	}
	public String getSerVnombre() {
		return this.serVnombre;
	}
	public void setSerVnombre(String serVnombre) {
		this.serVnombre = serVnombre;
	}
	public String getSerVruta() {
		return this.serVruta;
	}
	public void setSerVruta(String serVruta) {
		this.serVruta = serVruta;
	}
	public String getSerVusucrea() {
		return this.serVusucrea;
	}
	public void setSerVusucrea(String serVusucrea) {
		this.serVusucrea = serVusucrea;
	}
	public Date getSerDfeccrea() {
		return this.serDfeccrea;
	}
	public void setSerDfeccrea(Date serDfeccrea) {
		this.serDfeccrea = serDfeccrea;
	}
	public Boolean getSerBservicioActivado() {
		return serBservicioActivado;
	}
	public void setSerBservicioActivado(Boolean serBservicioActivado) {
		this.serBservicioActivado = serBservicioActivado;
	}	
}