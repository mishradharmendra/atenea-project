package co.com.inascol.atenea.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.inascol.atenea.entity.GppFormacion;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class GppFormacionRowMapper implements RowMapper{

	private GppFormacion gppFormacion;
	
	public Object mapRow(ResultSet rs, int index) throws SQLException {
		gppFormacion = new GppFormacion();
		gppFormacion.setForNidformacion(rs.getInt("for_nidformacion"));
		gppFormacion.setForVtitulo(rs.getString("for_vtitulo"));
		gppFormacion.setForDfecgrado(rs.getDate("for_dfecgrado"));
		gppFormacion.setForNduracion(rs.getInt("for_nduracion"));
		gppFormacion.setForVunidaddurac(rs.getString("for_vunidaddurac"));
		gppFormacion.setForVtarjetaprof(rs.getString("for_vtarjetaprof"));
		gppFormacion.setForDfectarjeta(rs.getDate("for_dfectarjeta"));
		gppFormacion.setPerNidpersona(rs.getInt("per_nidpersona"));
		gppFormacion.setNacNidnivelac(rs.getInt("nac_nidnivelac"));
		gppFormacion.setInsNidinstitucion(rs.getInt("Ins_nidinstitucion"));
		gppFormacion.setTeqNidtituloeq(rs.getInt("teq_nidtituloeq"));
		gppFormacion.setDocNidiploma(rs.getInt("doc_nidiploma"));
		gppFormacion.setDocNactagrado(rs.getInt("doc_nactagrado"));
		gppFormacion.setDocNtarjetaprof(rs.getInt("doc_ntarjetaprof"));
		gppFormacion.setForVusucrea(rs.getString("for_vusucrea"));
		gppFormacion.setForDfeccrea(rs.getDate("for_dfeccrea"));
		gppFormacion.setForVusumodifica(rs.getString("for_vusumodifica"));
		gppFormacion.setForDfecmodifica(rs.getDate("for_dfecmodifica"));		
		return gppFormacion;
	}
}