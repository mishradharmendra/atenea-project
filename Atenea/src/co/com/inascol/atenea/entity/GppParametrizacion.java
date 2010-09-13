package co.com.inascol.atenea.entity;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class GppParametrizacion {

	private Integer parNidparam;
	private String parVnombre;
	private String parVvalor;
	private String parVdescripcion;

	public GppParametrizacion() {}

	public Integer getParNidparam() {
		return this.parNidparam;
	}
	public void setParNidparam(Integer parNidparam) {
		this.parNidparam = parNidparam;
	}
	public String getParVnombre() {
		return this.parVnombre;
	}
	public void setParVnombre(String parVnombre) {
		this.parVnombre = parVnombre;
	}
	public String getParVvalor() {
		return this.parVvalor;
	}
	public void setParVvalor(String parVvalor) {
		this.parVvalor = parVvalor;
	}
	public String getParVdescripcion() {
		return this.parVdescripcion;
	}
	public void setParVdescripcion(String parVdescripcion) {
		this.parVdescripcion = parVdescripcion;
	}
}