package co.com.inascol.atenea.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.inascol.atenea.entity.GppTipoarchivo;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class GppTipoarchivoRowMapper implements RowMapper{

	private GppTipoarchivo gppTipoarchivo;
	
	public Object mapRow(ResultSet rs, int index) throws SQLException {
		gppTipoarchivo = new GppTipoarchivo();
		gppTipoarchivo.setTarNidtipoarchivo(rs.getInt("tar_nidtipoarchivo"));
		gppTipoarchivo.setTarVtipoarchivo(rs.getString("tar_vtipoarchivo"));
		gppTipoarchivo.setTarVusucrea(rs.getString("tar_vusucrea"));
		gppTipoarchivo.setTarDfeccrea(rs.getDate("tar_dfeccrea"));
		gppTipoarchivo.setTarVusumodifica(rs.getString("tar_vusumodifica"));
		gppTipoarchivo.setTarDfecmodifica(rs.getDate("tar_dfecmodifica"));
		return gppTipoarchivo;
	}
}