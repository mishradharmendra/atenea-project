package co.com.inascol.atenea.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.inascol.atenea.entity.GppPerfilprof;

public class GppPerfilprofRowMapper implements RowMapper{

	private GppPerfilprof gppPerfilprof;
	
	public Object mapRow(ResultSet rs, int index) throws SQLException {
		gppPerfilprof = new GppPerfilprof();
		gppPerfilprof.setPprNidperfilprof(rs.getInt("ppr_nidperfilprof"));
		gppPerfilprof.setPprVperfil(rs.getString("ppr_vperfil"));
		gppPerfilprof.setPprNnivelidi1(rs.getInt("ppr_nnivelidi1"));
		gppPerfilprof.setPprNnivelidi2(rs.getInt("ppr_nnivelidi2"));
		gppPerfilprof.setPprVherrasw(rs.getString("ppr_vherrasw"));
		gppPerfilprof.setPprVmotorbd(rs.getString("ppr_vmotorbd"));
		gppPerfilprof.setPeqNidperfileq(rs.getInt("peq_nidperfileq"));
		gppPerfilprof.setPerNidpersona(rs.getInt("per_nidpersona"));
		gppPerfilprof.setIdiNididioma1(rs.getInt("idi_nididioma1"));
		gppPerfilprof.setIdiNididioma2(rs.getInt("idi_nididioma2"));
		gppPerfilprof.setPprVusucrea(rs.getString("ppr_vusucrea"));
		gppPerfilprof.setPprDfeccrea(rs.getDate("ppr_dfeccrea"));
		gppPerfilprof.setPprVusumodifica(rs.getString("ppr_vusumodifica"));
		gppPerfilprof.setPprDfecmodifica(rs.getDate("ppr_dfecmodifica"));
		return gppPerfilprof;
	}
}
