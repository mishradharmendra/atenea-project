package co.com.inascol.atenea.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.inascol.atenea.entity.GppPais;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class GppPaisRowMapper implements RowMapper{

	private GppPais gppPais;
	
	public Object mapRow(ResultSet rs, int index) throws SQLException {
		gppPais = new GppPais();
		gppPais.setPaiNidpais(rs.getInt("pai_nidpais"));
		gppPais.setPaiVpais(rs.getString("pai_vpais"));
		gppPais.setPaiVusucrea(rs.getString("pai_vusucrea"));
		gppPais.setPaiDfeccrea(rs.getDate("pai_dfeccrea"));
		gppPais.setPaiVusumodifica(rs.getString("pai_vusumodifica"));
		gppPais.setPaiDfecmodifica(rs.getDate("pai_dfecmodifica"));
		return gppPais;
	}
}