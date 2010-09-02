package co.com.inascol.atenea.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.inascol.atenea.entity.GppParametrizacion;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcción de Software
 * Esp. Sistemas de Información Geográfica
 * Ing. Catastral y Geodesta
 */
public class GppParametrizacionRowMapper implements RowMapper{

	private GppParametrizacion gppParametrizacion;
	
	public Object mapRow(ResultSet rs, int index) throws SQLException {
		gppParametrizacion = new GppParametrizacion();
		gppParametrizacion.setParNidparam(rs.getInt("par_nidparam"));		
		gppParametrizacion.setParVdescripcion(rs.getString("par_vdescripcion"));
		gppParametrizacion.setParVnombre(rs.getString("par_vnombre"));
		gppParametrizacion.setParVvalor(rs.getString("par_vvalor"));
		return gppParametrizacion;
	}
}