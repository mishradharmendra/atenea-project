package co.com.inascol.atenea.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.inascol.atenea.entity.GppServicio;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcción de Software
 * Esp. Sistemas de Información Geográfica
 * Ing. Catastral y Geodesta
 */
public class GppServicioRowMapper implements RowMapper{

	private GppServicio gppServicio;
	
	public Object mapRow(ResultSet rs, int index) throws SQLException {
		gppServicio = new GppServicio();
		gppServicio.setSerNidservicio(rs.getInt("ser_nidservicio"));		
		gppServicio.setSerVnombre(rs.getString("ser_vnombre"));
		gppServicio.setSerVruta(rs.getString("ser_vruta"));
		gppServicio.setSerVusucrea(rs.getString("ser_vusucrea"));
		gppServicio.setSerDfeccrea(rs.getDate("ser_dfeccrea"));
		return gppServicio;
	}
}