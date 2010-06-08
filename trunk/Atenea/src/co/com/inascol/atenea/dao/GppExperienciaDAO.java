package co.com.inascol.atenea.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import co.com.inascol.atenea.dao.utils.DAO;
import co.com.inascol.atenea.dao.utils.TemplateManager;
import co.com.inascol.atenea.entity.GppExperiencia;
import co.com.inascol.atenea.entity.rowmapper.GppExperienciaRowMapper;

public class GppExperienciaDAO implements DAO{

	private GppExperiencia gppExperiencia;
	private GppExperienciaRowMapper gppExperienciaRowMapper;
	private List<Object> gppExperienciasLaborales;
	private Boolean estadoOperation;	
	private String sentenciaSQL;
	private JdbcTemplate jdbcTemplate;
	
	public boolean actualizar(Object obj) {
		estadoOperation = false;
		try{
			gppExperiencia = (GppExperiencia) obj;
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "update gpp_experiencia " +
							"set exp_vnomempresa = ?, " +
							"exp_vtelempresa = ?, " +
							"exp_vnomcontacto = ?, " +
							"exp_vemailcontacto = ?, " +
							"exp_vcargo = ?, " +
							"exp_dfecingreso = ?, " +
							"exp_dfecretiro = ?, " +
							"exp_vherrasw = ?, " +
							"exp_vfuncionlogro = ?, " +
							"doc_ncertifica1 = ?, " +
							"doc_ncertifica2 = ?, " +
							"gpp_municipio_mun_vidmunicipio = ?, " +
							"ceq_nidcargoeq = ?, " +
							"exp_vusumodifica = ?, " +
							"exp_dfecmodifica = ? " +
							"where exp_nidexplaboral = ?";
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppExperiencia.getExpVnomempresa(),
															gppExperiencia.getExpVtelempresa(),
															gppExperiencia.getExpVnomcontacto(),
															gppExperiencia.getExpVemailcontacto(),
															gppExperiencia.getExpVcargo(),
															gppExperiencia.getExpDfecingreso(),
															gppExperiencia.getExpDfecretiro(),
															gppExperiencia.getExpVherrasw(),
															gppExperiencia.getExpVfuncionlogro(),
															gppExperiencia.getDocNcertifica1(),
															gppExperiencia.getDocNcertifica2(),
															gppExperiencia.getMunVidmunicipio(),
															gppExperiencia.getCeqNidcargoeq(),
															gppExperiencia.getExpVusumodifica(),
															gppExperiencia.getExpDfecmodifica(),
															gppExperiencia.getExpNidexplaboral()},
															new int[]{Types.VARCHAR,
																		Types.VARCHAR,
																		Types.VARCHAR,
																		Types.VARCHAR,
																		Types.VARCHAR,
																		Types.DATE,
																		Types.DATE,
																		Types.VARCHAR,
																		Types.VARCHAR,
																		Types.INTEGER,
																		Types.INTEGER,
																		Types.INTEGER,
																		Types.INTEGER,
																		Types.VARCHAR,
																		Types.DATE,
																		Types.INTEGER});
			estadoOperation = true;			
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperation;
	}

	public boolean borrar(Object idObj) {
		estadoOperation = false;
		try{
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "delete from gpp_experiencia where exp_nidexplaboral = ?";
			jdbcTemplate.update(sentenciaSQL, new Object[]{idObj}, new int[]{Types.INTEGER});
			estadoOperation = true;			
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperation;
	}

	public Object buscarPorId(Object idObj) {
		gppExperiencia = null;
		try{
			gppExperienciaRowMapper = new GppExperienciaRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_experiencia where exp_nidexplaboral = ?";
			gppExperiencia = (GppExperiencia) jdbcTemplate.queryForObject(sentenciaSQL, new Object[] {idObj}, gppExperienciaRowMapper);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppExperiencia;		
	}

	public List<Object> buscarTodos() {
		gppExperienciasLaborales = null;
		try{
			gppExperienciaRowMapper = new GppExperienciaRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_experiencia order by exp_nidexplaboral";
			gppExperienciasLaborales = (List) jdbcTemplate.query(sentenciaSQL, gppExperienciaRowMapper);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppExperienciasLaborales;	
	}

	public boolean crear(Object obj) {
		estadoOperation = false;
		try{
			gppExperiencia = (GppExperiencia) obj;
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "insert into gpp_experiencia " +
							"(exp_vnomempresa, exp_vtelempresa, exp_vnomcontacto, exp_vemailcontacto, exp_vcargo, exp_dfecingreso, exp_dfecretiro, exp_vherrasw, exp_vfuncionlogro, doc_ncertifica1, doc_ncertifica2, gpp_municipio_mun_vidmunicipio, ceq_nidcargoeq, exp_vusucrea, exp_dfeccrea) " +
							"values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppExperiencia.getExpVnomempresa(),
															gppExperiencia.getExpVtelempresa(),
															gppExperiencia.getExpVnomcontacto(),
															gppExperiencia.getExpVemailcontacto(),
															gppExperiencia.getExpVcargo(),
															gppExperiencia.getExpDfecingreso(),
															gppExperiencia.getExpDfecretiro(),
															gppExperiencia.getExpVherrasw(),
															gppExperiencia.getExpVfuncionlogro(),
															gppExperiencia.getDocNcertifica1(),
															gppExperiencia.getDocNcertifica2(),
															gppExperiencia.getMunVidmunicipio(),
															gppExperiencia.getCeqNidcargoeq(),
															gppExperiencia.getExpVusucrea(),
															gppExperiencia.getExpDfeccrea()},
															new int[]{Types.VARCHAR,
																		Types.VARCHAR,
																		Types.VARCHAR,
																		Types.VARCHAR,
																		Types.VARCHAR,
																		Types.DATE,
																		Types.DATE,
																		Types.VARCHAR,
																		Types.VARCHAR,
																		Types.INTEGER,
																		Types.INTEGER,
																		Types.INTEGER,
																		Types.INTEGER,
																		Types.VARCHAR,
																		Types.DATE});
			estadoOperation = true;			
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperation;
	}
}