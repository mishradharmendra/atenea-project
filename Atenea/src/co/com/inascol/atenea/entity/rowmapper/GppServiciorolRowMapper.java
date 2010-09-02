package co.com.inascol.atenea.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.inascol.atenea.entity.GppServiciorol;
import co.com.inascol.atenea.entity.GppServiciorolId;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcción de Software
 * Esp. Sistemas de Información Geográfica
 * Ing. Catastral y Geodesta
 */
public class GppServiciorolRowMapper implements RowMapper{

	private GppServiciorol gppServiciorol;
	private GppServiciorolId gppServiciorolId;
	
	public Object mapRow(ResultSet rs, int index) throws SQLException {
		gppServiciorol = new GppServiciorol();
		gppServiciorolId = new GppServiciorolId();
		gppServiciorolId.setRolNidrol(rs.getInt("rol_nidrol"));
		gppServiciorolId.setSerNidservicio(rs.getInt("ser_nidservicio"));
		gppServiciorol.setId(gppServiciorolId);
		gppServiciorol.setSrlVusucrea(rs.getString("srl_vusucrea"));
		gppServiciorol.setSrlDfeccrea(rs.getDate("srl_dfeccrea"));
		return gppServiciorol;
	}
}