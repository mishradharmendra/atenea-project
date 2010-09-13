package co.com.inascol.atenea.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.inascol.atenea.entity.GppPerfilequivalente;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class GppPerfilequivalenteRowMapper implements RowMapper{

	private GppPerfilequivalente gppPerfilequivalente;
	
	public Object mapRow(ResultSet rs, int index) throws SQLException {
		gppPerfilequivalente = new GppPerfilequivalente();
		gppPerfilequivalente.setPeqNidperfileq(rs.getInt("peq_nidperfileq"));
		gppPerfilequivalente.setPeqVperfileq(rs.getString("peq_vperfileq"));
		gppPerfilequivalente.setPeqVusucrea(rs.getString("peq_vusucrea"));
		gppPerfilequivalente.setPeqDfeccrea(rs.getDate("peq_dfeccrea"));
		gppPerfilequivalente.setPeqVusumodifica(rs.getString("peq_vusumodifica"));
		gppPerfilequivalente.setPeqDfecmodifica(rs.getDate("peq_dfecmodifica"));
		return gppPerfilequivalente;
	}
}