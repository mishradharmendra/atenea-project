package co.com.inascol.atenea.entity;

// Generated 13/04/2010 04:01:21 PM by Hibernate Tools 3.3.0.GA

/**
 * GppServiciorolId generated by hbm2java
 */
public class GppServiciorolId implements java.io.Serializable {

	private int serNidservicio;
	private int rolNidrol;

	public GppServiciorolId() {
	}

	public GppServiciorolId(int serNidservicio, int rolNidrol) {
		this.serNidservicio = serNidservicio;
		this.rolNidrol = rolNidrol;
	}

	public int getSerNidservicio() {
		return this.serNidservicio;
	}

	public void setSerNidservicio(int serNidservicio) {
		this.serNidservicio = serNidservicio;
	}

	public int getRolNidrol() {
		return this.rolNidrol;
	}

	public void setRolNidrol(int rolNidrol) {
		this.rolNidrol = rolNidrol;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof GppServiciorolId))
			return false;
		GppServiciorolId castOther = (GppServiciorolId) other;

		return (this.getSerNidservicio() == castOther.getSerNidservicio())
				&& (this.getRolNidrol() == castOther.getRolNidrol());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getSerNidservicio();
		result = 37 * result + this.getRolNidrol();
		return result;
	}

}
