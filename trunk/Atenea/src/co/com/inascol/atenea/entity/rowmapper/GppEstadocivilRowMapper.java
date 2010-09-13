package co.com.inascol.atenea.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.inascol.atenea.entity.GppEstadocivil;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class GppEstadocivilRowMapper implements RowMapper{

	private GppEstadocivil gppEstadocivil;
	
	public Object mapRow(ResultSet rs, int index) throws SQLException {
		gppEstadocivil = new GppEstadocivil();
		gppEstadocivil.setEscNidestadocivil(rs.getInt("esc_nidestadocivil"));
		gppEstadocivil.setEscVestadocivil(rs.getString("esc_vestadocivil"));
		gppEstadocivil.setEscVusucrea(rs.getString("esc_vusucrea"));
		gppEstadocivil.setEscDfeccrea(rs.getDate("esc_dfeccrea"));
		gppEstadocivil.setEscVusumodifica(rs.getString("esc_vusumodifica"));
		gppEstadocivil.setEscDfecmodifica(rs.getDate("esc_dfecmodifica"));
		return gppEstadocivil;
	}
}