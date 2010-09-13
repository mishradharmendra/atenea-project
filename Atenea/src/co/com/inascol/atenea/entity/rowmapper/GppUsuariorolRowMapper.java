package co.com.inascol.atenea.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.inascol.atenea.entity.GppUsuariorol;
import co.com.inascol.atenea.entity.GppUsuariorolId;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class GppUsuariorolRowMapper implements RowMapper{

	private GppUsuariorol gppUsuariorol;
	private GppUsuariorolId gppUsuariorolId;
	
	public Object mapRow(ResultSet rs, int index) throws SQLException {
		gppUsuariorol = new GppUsuariorol();
		gppUsuariorolId = new GppUsuariorolId();
		gppUsuariorolId.setRolNidrol(rs.getInt("rol_nidrol"));
		gppUsuariorolId.setUsuNidusuario(rs.getInt("usu_nidusuario"));
		gppUsuariorol.setId(gppUsuariorolId);
		gppUsuariorol.setUrlVusucrea(rs.getString("url_vusucrea"));
		gppUsuariorol.setUrlDfeccrea(rs.getDate("url_dfeccrea"));
		return gppUsuariorol;
	}
}