package co.com.inascol.atenea.entity;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class GppServiciorolId  {

	private int serNidservicio;
	private int rolNidrol;

	public GppServiciorolId() {}

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
}