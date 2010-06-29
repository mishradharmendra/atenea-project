package co.com.inascol.atenea.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import co.com.inascol.atenea.entity.GppPersona;

public class GppPersonaRowMapper implements RowMapper{

	GppPersona gppPersona;

	public Object mapRow(ResultSet rs, int index) throws SQLException {
		gppPersona = new GppPersona();
		gppPersona.setPerNidpersona(rs.getInt("per_nidpersona"));
		gppPersona.setPerVnombres(rs.getString("per_vnombres"));
		gppPersona.setPerVapellidos(rs.getString("per_vapellidos"));
		gppPersona.setPerNidentificacion(rs.getInt("per_nidentificacion"));
		gppPersona.setPerVsexo(rs.getString("per_vsexo"));
		gppPersona.setPerDfecnacimiento(rs.getDate("per_dfecnacimiento"));
		gppPersona.setPerVlibretamilitar(rs.getString("per_vlibretamilitar"));
		gppPersona.setPerVmovil(rs.getString("per_vmovil"));
		gppPersona.setPerVemail(rs.getString("per_vemail"));
		gppPersona.setPerVdireccion(rs.getString("per_vdireccion"));
		gppPersona.setPerVtelefono(rs.getString("per_vtelefono"));
		gppPersona.setMunVidmunicipio(rs.getString("gpp_municipio_mun_vidmunicipio"));
		gppPersona.setTdcNidtipodoc(rs.getInt("tdc_nidtipodoc"));
		gppPersona.setEscNidestadocivil(rs.getInt("esc_nidestadocivil"));
		gppPersona.setPerVusucrea(rs.getString("per_vusucrea"));
		gppPersona.setPerDfeccrea(rs.getDate("per_dfeccrea"));
		gppPersona.setPerVusumodifica(rs.getString("per_vusumodifica"));
		gppPersona.setPerDfecmodifica(rs.getDate("per_dfecmodifica"));
		return gppPersona;
	}
}