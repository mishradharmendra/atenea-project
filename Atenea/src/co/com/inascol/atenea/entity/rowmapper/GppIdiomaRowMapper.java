package co.com.inascol.atenea.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.inascol.atenea.entity.GppIdioma;
/**
 * @author Guillermo Toro
 *
 */
public class GppIdiomaRowMapper implements RowMapper{

	private GppIdioma gppIdioma;
	
	public Object mapRow(ResultSet rs, int index) throws SQLException {
		gppIdioma = new GppIdioma();
		gppIdioma.setIdiNididioma(rs.getInt("idi_nididioma"));		
		gppIdioma.setIdiVidioma(rs.getString("idi_vidioma"));
		gppIdioma.setIdiVusucrea(rs.getString("idi_vusucrea"));
		gppIdioma.setIdiDfeccrea(rs.getDate("idi_dfeccrea"));
		gppIdioma.setIdiVusumodifica(rs.getString("idi_vusumodifica"));
		gppIdioma.setIdiDfecmodifica(rs.getDate("idi_dfecmodifica"));
		return gppIdioma;
	}
}