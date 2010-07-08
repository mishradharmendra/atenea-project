package co.com.inascol.atenea.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.inascol.atenea.entity.GppMunicipio;

public class GppMunicipioRowMapper implements RowMapper{

	private GppMunicipio gppMunicipio;
	
	public Object mapRow(ResultSet rs, int index) throws SQLException {
		gppMunicipio = new GppMunicipio();
		gppMunicipio.setMunNidmunicipio(rs.getInt("mun_nidmunicipio"));
		gppMunicipio.setMunVmunicipio(rs.getString("mun_vmunicipio"));
		gppMunicipio.setDptNiddepto(rs.getInt("dpt_niddepto"));
		gppMunicipio.setMunVusucrea(rs.getString("mun_vusucrea"));
		gppMunicipio.setMunDfeccrea(rs.getDate("mun_dfeccrea"));
		gppMunicipio.setMunVusumodifica(rs.getString("mun_vusumodifica"));
		gppMunicipio.setMunDfecmodifica(rs.getDate("mun_dfecmodifica"));
		return gppMunicipio;
	}
}