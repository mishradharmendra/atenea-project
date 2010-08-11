package co.com.inascol.atenea.entity;

import java.util.Date;
/**
 * @author Guillermo Toro
 *
 */
public class GppServiciorol {

	private GppServiciorolId id;
	private String srlVusucrea;
	private Date srlDfeccrea;

	public GppServiciorol() {}

	public GppServiciorolId getId() {
		return this.id;
	}
	public void setId(GppServiciorolId id) {
		this.id = id;
	}
	public String getSrlVusucrea() {
		return this.srlVusucrea;
	}
	public void setSrlVusucrea(String srlVusucrea) {
		this.srlVusucrea = srlVusucrea;
	}
	public Date getSrlDfeccrea() {
		return this.srlDfeccrea;
	}
	public void setSrlDfeccrea(Date srlDfeccrea) {
		this.srlDfeccrea = srlDfeccrea;
	}
}