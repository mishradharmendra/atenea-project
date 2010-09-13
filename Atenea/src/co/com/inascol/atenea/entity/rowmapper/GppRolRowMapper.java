package co.com.inascol.atenea.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.inascol.atenea.entity.GppRol;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class GppRolRowMapper implements RowMapper{

	private GppRol gppRol;
	
	public Object mapRow(ResultSet rs, int index) throws SQLException {
		gppRol = new GppRol();
		gppRol.setRolNidrol(rs.getInt("rol_nidrol"));
		gppRol.setRolVnombre(rs.getString("rol_vnombre"));
		gppRol.setRolVdescripcion(rs.getString("rol_vdescripcion"));
		gppRol.setRolVusucrea(rs.getString("rol_vusucrea"));		
		gppRol.setRolDfeccrea(rs.getDate("rol_dfeccrea"));
		gppRol.setRolVusumodifica(rs.getString("rol_vusumodifica"));
		gppRol.setRolDfecmodifica(rs.getDate("rol_dfecmodifica"));
		gppRol.setRolBactivo(rs.getBoolean("rol_vactivo"));
		return gppRol;
	}
}