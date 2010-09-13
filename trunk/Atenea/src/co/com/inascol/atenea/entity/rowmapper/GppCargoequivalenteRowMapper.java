package co.com.inascol.atenea.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.inascol.atenea.entity.GppCargoequivalente;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class GppCargoequivalenteRowMapper implements RowMapper{

	private GppCargoequivalente gppCargoequivalente;
	
	public Object mapRow(ResultSet rs, int index) throws SQLException {
		gppCargoequivalente = new GppCargoequivalente();
		gppCargoequivalente.setCeqNidcargoeq(rs.getInt("ceq_nidcargoeq"));
		gppCargoequivalente.setCeqVcargoeq(rs.getString("ceq_vcargoeq"));
		gppCargoequivalente.setCeqVusucrea(rs.getString("ceq_vusucrea"));
		gppCargoequivalente.setCeqDfeccrea(rs.getDate("ceq_dfeccrea"));
		gppCargoequivalente.setCeqVusumodifica(rs.getString("ceq_vusumodifica"));
		gppCargoequivalente.setCeqDfecmodifica(rs.getDate("ceq_dfecmodifica"));
		return gppCargoequivalente;
	}
}