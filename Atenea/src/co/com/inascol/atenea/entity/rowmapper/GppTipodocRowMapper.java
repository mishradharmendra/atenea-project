package co.com.inascol.atenea.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.inascol.atenea.entity.GppTipodoc;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcción de Software
 * Esp. Sistemas de Información Geográfica
 * Ing. Catastral y Geodesta
 */
public class GppTipodocRowMapper implements RowMapper{
	
	private GppTipodoc gppTipodoc;

	public Object mapRow(ResultSet rs, int index) throws SQLException {
		gppTipodoc = new GppTipodoc();
		gppTipodoc.setTdcNidtipodoc(rs.getInt("tdc_nidtipodoc"));
		gppTipodoc.setTdcVnombre(rs.getString("tdc_vnombre"));
		gppTipodoc.setTdcVusucrea(rs.getString("tdc_vusucrea"));
		gppTipodoc.setTdcDfeccrea(rs.getDate("tdc_dfeccrea"));
		gppTipodoc.setTdcVusumodifica(rs.getString("tdc_vusumodifica"));
		gppTipodoc.setTdcDfecmodifica(rs.getDate("tdc_dfecmodifica"));
		return gppTipodoc;
	}
}