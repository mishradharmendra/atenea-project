package co.com.inascol.atenea.entity;

import java.util.Date;
/**
 * @author Guillermo Toro
 *
 */
public class GppIdioma {

	private Integer idiNididioma;
	private String idiVidioma;
	private String idiVusucrea;
	private Date idiDfeccrea;
	private String idiVusumodifica;
	private Date idiDfecmodifica;

	public GppIdioma() {}

	public Integer getIdiNididioma() {
		return this.idiNididioma;
	}
	public void setIdiNididioma(Integer idiNididioma) {
		this.idiNididioma = idiNididioma;
	}
	public String getIdiVidioma() {
		return this.idiVidioma;
	}
	public void setIdiVidioma(String idiVidioma) {
		this.idiVidioma = idiVidioma;
	}
	public String getIdiVusucrea() {
		return this.idiVusucrea;
	}
	public void setIdiVusucrea(String idiVusucrea) {
		this.idiVusucrea = idiVusucrea;
	}
	public Date getIdiDfeccrea() {
		return this.idiDfeccrea;
	}
	public void setIdiDfeccrea(Date idiDfeccrea) {
		this.idiDfeccrea = idiDfeccrea;
	}
	public String getIdiVusumodifica() {
		return this.idiVusumodifica;
	}
	public void setIdiVusumodifica(String idiVusumodifica) {
		this.idiVusumodifica = idiVusumodifica;
	}
	public Date getIdiDfecmodifica() {
		return this.idiDfecmodifica;
	}
	public void setIdiDfecmodifica(Date idiDfecmodifica) {
		this.idiDfecmodifica = idiDfecmodifica;
	}
}