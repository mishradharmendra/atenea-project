package co.com.inascol.atenea.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

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