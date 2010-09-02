package co.com.inascol.atenea.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.inascol.atenea.entity.GppDocumento;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcción de Software
 * Esp. Sistemas de Información Geográfica
 * Ing. Catastral y Geodesta
 */
public class GppDocumentoRowMapper implements RowMapper {

	private GppDocumento gppDocumento;
	
	public Object mapRow(ResultSet rs, int index) throws SQLException {
		gppDocumento = new GppDocumento();
		gppDocumento.setDocNiddocumento(rs.getInt("doc_niddocumento"));
		gppDocumento.setDocVnombre(rs.getString("doc_vnombre"));
		gppDocumento.setDocVarchivo(rs.getString("doc_varchivo"));
		gppDocumento.setDocVurlarchivo(rs.getString("doc_vurlarchivo"));
		gppDocumento.setDocDfecexpide(rs.getDate("doc_dfecexpide"));
		gppDocumento.setPerNidpersona(rs.getInt("per_nidpersona"));
		gppDocumento.setTarNidtipoarchivo(rs.getInt("tar_nidtipoarchivo"));
		gppDocumento.setDocVusucrea(rs.getString("doc_vusucrea"));
		gppDocumento.setDocDfeccrea(rs.getDate("doc_dfeccrea"));
		gppDocumento.setDocVusumodifica(rs.getString("doc_vusumodifica"));
		gppDocumento.setDocDfecmodifica(rs.getDate("doc_dfecmodifica"));		
		return gppDocumento;
	}
}