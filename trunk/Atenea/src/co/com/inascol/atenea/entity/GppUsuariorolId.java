package co.com.inascol.atenea.entity;

// Generated 13/04/2010 04:01:21 PM by Hibernate Tools 3.3.0.GA

/**
 * GppUsuariorolId generated by hbm2java
 */
public class GppUsuariorolId {

	private int rolNidrol;
	private int usuNidusuario;

	public GppUsuariorolId() {}

	public int getRolNidrol() {
		return this.rolNidrol;
	}

	public void setRolNidrol(int rolNidrol) {
		this.rolNidrol = rolNidrol;
	}

	public int getUsuNidusuario() {
		return this.usuNidusuario;
	}

	public void setUsuNidusuario(int usuNidusuario) {
		this.usuNidusuario = usuNidusuario;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof GppUsuariorolId))
			return false;
		GppUsuariorolId castOther = (GppUsuariorolId) other;

		return (this.getRolNidrol() == castOther.getRolNidrol())
				&& (this.getUsuNidusuario() == castOther.getUsuNidusuario());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getRolNidrol();
		result = 37 * result + this.getUsuNidusuario();
		return result;
	}

}
