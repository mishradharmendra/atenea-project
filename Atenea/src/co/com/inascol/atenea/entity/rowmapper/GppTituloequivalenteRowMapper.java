package co.com.inascol.atenea.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.inascol.atenea.entity.GppTituloequivalente;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class GppTituloequivalenteRowMapper implements RowMapper{

	private GppTituloequivalente gppTituloequivalente;
	
	public Object mapRow(ResultSet rs, int index) throws SQLException {
		gppTituloequivalente = new GppTituloequivalente();
		gppTituloequivalente.setTeqNidtituloeq(rs.getInt("teq_nidtituloeq"));
		gppTituloequivalente.setTeqVtituloeq(rs.getString("teq_vtituloeq"));
		gppTituloequivalente.setTeqVusucrea(rs.getString("teq_vusucrea"));
		gppTituloequivalente.setTeqDfeccrea(rs.getDate("teq_dfeccrea"));
		gppTituloequivalente.setTeqVusumodifica(rs.getString("teq_vusumodifica"));
		gppTituloequivalente.setTeqDfecmodifica(rs.getDate("teq_dfecmodifica"));
		return gppTituloequivalente;
	}
}