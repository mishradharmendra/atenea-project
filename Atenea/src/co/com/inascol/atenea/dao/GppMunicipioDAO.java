package co.com.inascol.atenea.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import co.com.inascol.atenea.dao.utils.DAO;
import co.com.inascol.atenea.dao.utils.TemplateManager;
import co.com.inascol.atenea.entity.GppMunicipio;
import co.com.inascol.atenea.entity.rowmapper.GppMunicipioRowMapper;

public class GppMunicipioDAO implements DAO{

	private GppMunicipio gppMunicipio;
	private GppMunicipioRowMapper gppMunicipioRowMapper;
	private List<Object> gppMunicipios;
	private Boolean estadoOperation;	
	private String sentenciaSQL;
	private JdbcTemplate jdbcTemplate;
	
	public boolean actualizar(Object obj) {
		estadoOperation = false;
		try{
			gppMunicipio = (GppMunicipio) obj;			
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "update gpp_municipio " +
							"set mun_vmunicipio = ?, " +
							"dpt_viddepto = ?, " +
							"mun_vusumodifica = ?, " +
							"mun_dfecmodifica = ? " +							
							"where mun_vidmunicipio = ?";	
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppMunicipio.getMunVmunicipio(),
															gppMunicipio.getDptViddepto(),
															gppMunicipio.getMunVusumodifica(),
															gppMunicipio.getMunDfecmodifica(),
															gppMunicipio.getMunVidmunicipio()},
															new int[] {Types.VARCHAR,
																		Types.VARCHAR,
																		Types.VARCHAR,																		
																		Types.DATE,
																		Types.VARCHAR});	
			estadoOperation = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return estadoOperation;
	}

	public boolean borrar(Object idObj) {
		estadoOperation = false;
		try{	
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "delete from gpp_municipio " +
							"where mun_vidmunicipio = ? ";	
			jdbcTemplate.update(sentenciaSQL, new Object[] {idObj}, new int[] {Types.VARCHAR});	
			estadoOperation = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return estadoOperation;
	}

	public Object buscarPorId(Object idObj) {
		gppMunicipio = null;
		try{
			gppMunicipioRowMapper = new GppMunicipioRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_municipio where mun_vidmunicipio = ?";
			gppMunicipio = (GppMunicipio) jdbcTemplate.queryForObject(sentenciaSQL, new Object[] {idObj}, gppMunicipioRowMapper);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppMunicipio;
	}

	public List<Object> buscarTodos() {
		gppMunicipios = null;
		try{
			gppMunicipioRowMapper = new GppMunicipioRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_municipio order by mun_vmunicipio asc";
			gppMunicipios = (List) jdbcTemplate.query(sentenciaSQL, gppMunicipioRowMapper);
		} catch(Exception ex){
			ex.printStackTrace();
		}
		return gppMunicipios;
	}

	public boolean crear(Object obj) {
		estadoOperation = false;
		try{
			gppMunicipio = (GppMunicipio) obj;
			
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "insert into gpp_municipio " +
							"(mun_vidmunicipio, mun_vmunicipio, dpt_viddepto, mun_vusucrea, mun_dfeccrea, mun_vusumodifica, mun_dfecmodifica) " +
							"values (?, ?, ?, ?, ?, ?, ?)";	
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppMunicipio.getMunVidmunicipio(),
															gppMunicipio.getMunVmunicipio(),
															gppMunicipio.getDptViddepto(),
															gppMunicipio.getMunVusucrea(),
															gppMunicipio.getMunDfeccrea(),
															gppMunicipio.getMunVusumodifica(),
															gppMunicipio.getMunDfecmodifica()},
															new int[] {Types.VARCHAR,
																		Types.VARCHAR,
																		Types.VARCHAR,																		
																		Types.VARCHAR,
																		Types.DATE,
																		Types.VARCHAR,
																		Types.DATE});
			estadoOperation = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return estadoOperation;
	}
}