package co.com.inascol.atenea.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.inascol.atenea.entity.GppUsuario;

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
		gppUsuario.setUsuVactivo(rs.getString("usu_vactivo"));
		return gppUsuario;
	}
}