package co.com.inascol.atenea.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.inascol.atenea.entity.GppDepartamento;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcción de Software
 * Esp. Sistemas de Información Geográfica
 * Ing. Catastral y Geodesta
 */
public class GppDepartamentoRowMapper implements RowMapper{

	private GppDepartamento gppDepartamento;
	
	public Object mapRow(ResultSet rs, int index) throws SQLException {
		gppDepartamento = new GppDepartamento();
		gppDepartamento.setDptNiddepto(rs.getInt("dpt_niddepto"));
		gppDepartamento.setDptVdepto(rs.getString("dpt_vdepto"));
		gppDepartamento.setPaiNidpais(rs.getInt("pai_nidpais"));
		gppDepartamento.setDptVusucrea(rs.getString("dpt_vusucrea"));
		gppDepartamento.setDptDfeccrea(rs.getDate("dpt_dfeccrea"));
		gppDepartamento.setDptVusumodifica(rs.getString("dpt_vusumodifica"));
		gppDepartamento.setDptDfecmodifica(rs.getDate("dpt_dfecmodifica"));
		return gppDepartamento;
	}
}