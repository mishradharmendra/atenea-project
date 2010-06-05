package co.com.inascol.atenea.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.inascol.atenea.entity.GppNivelacademico;

public class GppNivelacademicoRowMapper implements RowMapper{

	private GppNivelacademico gppNivelacademico;
	
	public Object mapRow(ResultSet rs, int index) throws SQLException {
		gppNivelacademico = new GppNivelacademico();
		gppNivelacademico.setNacNidnivelac(rs.getInt("nac_nidnivelac"));
		gppNivelacademico.setNacVnivelac(rs.getString("nac_vnivelac"));
		gppNivelacademico.setNacVusucrea(rs.getString("nac_vusucrea"));
		gppNivelacademico.setNacDfeccrea(rs.getDate("nac_dfeccrea"));
		gppNivelacademico.setNacVusumodifica(rs.getString("nac_vusumodifica"));
		gppNivelacademico.setNacDfecmodifica(rs.getDate("nac_dfecmodifica"));
		return gppNivelacademico;
	}
}