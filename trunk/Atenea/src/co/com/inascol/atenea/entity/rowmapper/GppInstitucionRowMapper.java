package co.com.inascol.atenea.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.inascol.atenea.entity.GppInstitucion;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcci�n de Software
 * Esp. Sistemas de Informaci�n Geogr�fica
 * Ing. Catastral y Geodesta
 */
public class GppInstitucionRowMapper implements RowMapper{

	private GppInstitucion gppInstitucion;
	
	public Object mapRow(ResultSet rs, int index) throws SQLException {
		gppInstitucion = new GppInstitucion();
		gppInstitucion.setInsNidinstitucion(rs.getInt("ins_nidinstitucion"));
		gppInstitucion.setInsVinstitucion(rs.getString("ins_vinstitucion"));
		gppInstitucion.setInsVusucrea(rs.getString("ins_vusucrea"));
		gppInstitucion.setInsDfeccrea(rs.getDate("ins_dfeccrea"));
		gppInstitucion.setInsVusumodifica(rs.getString("ins_vusumodifica"));
		gppInstitucion.setInsDfecmodifica(rs.getDate("ins_dfecmodifica"));
		return gppInstitucion;
	}
}