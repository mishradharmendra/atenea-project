package co.com.inascol.atenea.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.inascol.atenea.entity.GppUsuario;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcci�n de Software
 * Esp. Sistemas de Informaci�n Geogr�fica
 * Ing. Catastral y Geodesta
 */
public class GppUsuarioRowMapper implements RowMapper{

	private GppUsuario gppUsuario;
	
	public Object mapRow(ResultSet rs, int index) throws SQLException {
		gppUsuario = new GppUsuario();
		gppUsuario.setUsuNidusuario(rs.getInt("usu_nidusuario"));
		gppUsuario.setUsuVnombre(rs.getString("usu_vnombre"));
		gppUsuario.setUsuVlogin(rs.getString("usu_vlogin"));
		gppUsuario.setUsuVemail(rs.getString("usu_vemail"));
		gppUsuario.setUsuVtelefono(rs.getString("usu_vtelefono"));
		gppUsuario.setUsuVusucrea(rs.getString("usu_vusucrea"));		
		gppUsuario.setUsuDfeccrea(rs.getDate("usu_dfeccrea"));
		gppUsuario.setUsuVusumodifica(rs.getString("usu_vusumodifica"));
		gppUsuario.setUsuDfecmodifica(rs.getDate("usu_dfecmodifica"));
		gppUsuario.setUsuBactivo(rs.getBoolean("usu_vactivo"));
		return gppUsuario;
	}
}