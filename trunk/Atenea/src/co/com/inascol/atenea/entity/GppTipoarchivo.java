package co.com.inascol.atenea.entity;

import java.util.Date;
/**
 * @author Guillermo Toro
 *
 */
public class GppTipoarchivo {

	private Integer tarNidtipoarchivo;
	private String tarVtipoarchivo;
	private String tarVusucrea;
	private Date tarDfeccrea;
	private String tarVusumodifica;
	private Date tarDfecmodifica;

	public GppTipoarchivo() {}

	public Integer getTarNidtipoarchivo() {
		return this.tarNidtipoarchivo;
	}
	public void setTarNidtipoarchivo(Integer tarNidtipoarchivo) {
		this.tarNidtipoarchivo = tarNidtipoarchivo;
	}
	public String getTarVtipoarchivo() {
		return this.tarVtipoarchivo;
	}
	public void setTarVtipoarchivo(String tarVtipoarchivo) {
		this.tarVtipoarchivo = tarVtipoarchivo;
	}
	public String getTarVusucrea() {
		return this.tarVusucrea;
	}
	public void setTarVusucrea(String tarVusucrea) {
		this.tarVusucrea = tarVusucrea;
	}
	public Date getTarDfeccrea() {
		return this.tarDfeccrea;
	}
	public void setTarDfeccrea(Date tarDfeccrea) {
		this.tarDfeccrea = tarDfeccrea;
	}
	public String getTarVusumodifica() {
		return this.tarVusumodifica;
	}
	public void setTarVusumodifica(String tarVusumodifica) {
		this.tarVusumodifica = tarVusumodifica;
	}
	public Date getTarDfecmodifica() {
		return this.tarDfecmodifica;
	}
	public void setTarDfecmodifica(Date tarDfecmodifica) {
		this.tarDfecmodifica = tarDfecmodifica;
	}
}