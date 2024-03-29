package co.com.inascol.atenea.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.inascol.atenea.entity.GppExperiencia;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class GppExperienciaRowMapper implements RowMapper{

	private GppExperiencia gppExperiencia;
	
	public Object mapRow(ResultSet rs, int index) throws SQLException {
		gppExperiencia = new GppExperiencia();
		gppExperiencia.setExpNidexplaboral(rs.getInt("exp_nidexplaboral"));
		gppExperiencia.setExpVnomempresa(rs.getString("exp_vnomempresa"));
		gppExperiencia.setExpVtelempresa(rs.getString("exp_vtelempresa"));
		gppExperiencia.setExpVnomcontacto(rs.getString("exp_vnomcontacto"));
		gppExperiencia.setExpVemailcontacto(rs.getString("exp_vemailcontacto"));
		gppExperiencia.setExpVcargo(rs.getString("exp_vcargo"));
		gppExperiencia.setExpDfecingreso(rs.getDate("exp_dfecingreso"));
		gppExperiencia.setExpDfecretiro(rs.getDate("exp_dfecretiro"));
		gppExperiencia.setExpVherrasw(rs.getString("exp_vherrasw"));
		gppExperiencia.setExpVfuncionlogro(rs.getString("exp_vfuncionlogro"));
		gppExperiencia.setPerNidpersona(rs.getInt("per_nidpersona"));
		gppExperiencia.setDocNcertifica1(rs.getInt("doc_ncertifica1"));
		gppExperiencia.setDocNcertifica2(rs.getInt("doc_ncertifica2"));
		gppExperiencia.setMunVidmunicipio(rs.getInt("gpp_municipio_mun_vidmunicipio"));
		gppExperiencia.setCeqNidcargoeq(rs.getInt("ceq_nidcargoeq"));
		gppExperiencia.setExpVusucrea(rs.getString("exp_vusucrea"));
		gppExperiencia.setExpDfeccrea(rs.getDate("exp_dfeccrea"));		
		gppExperiencia.setExpVusumodifica(rs.getString("exp_vusumodifica"));
		gppExperiencia.setExpDfecmodifica(rs.getDate("exp_dfecmodifica"));				
		return gppExperiencia;
	}
}