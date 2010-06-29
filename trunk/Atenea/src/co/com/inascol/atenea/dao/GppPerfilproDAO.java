package co.com.inascol.atenea.dao;

import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import co.com.inascol.atenea.dao.utils.DAO;
import co.com.inascol.atenea.dao.utils.TemplateManager;
import co.com.inascol.atenea.entity.GppPerfilprof;
import co.com.inascol.atenea.entity.rowmapper.GppPerfilprofRowMapper;

public class GppPerfilproDAO implements DAO{

	private GppPerfilprof gppPerfilprof;
	private GppPerfilprofRowMapper gppPerfilprofRowMapper;
	private List<Object> gppPerfilesprofesionales;
	private Boolean estadoOperation;	
	private String sentenciaSQL;
	private JdbcTemplate jdbcTemplate;
	
	public boolean actualizar(Object obj) {
		estadoOperation = false;
		try{
			gppPerfilprof = (GppPerfilprof) obj;			
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "update gpp_perfilprof " +
							"set ppr_vperfil = ?, " +
							"ppr_nnivelidi1 = ?, " +
							"ppr_nnivelidi2 = ?, " +
							"ppr_vherrasw = ?, " +
							"ppr_vmotorbd = ?, " +
							"peq_nidperfileq = ?, " +
							"per_nidpersona = ?, " +
							"idi_nididioma1 = ?, " +
							"idi_nididioma2 = ?, " +
							"ppr_vusumodifica = ?, " +
							"ppr_dfecmodifica = ? " +
							"where ppr_nidperfilprof = ?";	
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppPerfilprof.getPprVperfil(),
															gppPerfilprof.getPprNnivelidi1(),
															gppPerfilprof.getPprNnivelidi2(),
															gppPerfilprof.getPprVherrasw(),
															gppPerfilprof.getPprVmotorbd(),
															gppPerfilprof.getPeqNidperfileq(),
															gppPerfilprof.getPerNidpersona(),
															gppPerfilprof.getIdiNididioma1(),
															gppPerfilprof.getIdiNididioma2(),
															gppPerfilprof.getPprVusumodifica(),
															gppPerfilprof.getPprDfecmodifica(),
															gppPerfilprof.getPprNidperfilprof()},
															new int[] {Types.VARCHAR,
																		Types.INTEGER,
																		Types.INTEGER,																		
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
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return estadoOperation;
	}

	public boolean borrar(Object idObj) {
		estadoOperation = false;
		try{	
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "delete from gpp_perfilprof " +
							"where ppr_nidperfilprof = ? ";	
			jdbcTemplate.update(sentenciaSQL, new Object[] {idObj}, new int[] {Types.INTEGER});	
			estadoOperation = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return estadoOperation;
	}

	public Object buscarPorId(Object idObj) {
		gppPerfilprof = null;
		try{
			gppPerfilprofRowMapper = new GppPerfilprofRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_perfilprof where ppr_nidperfilprof = ?";
			gppPerfilprof = (GppPerfilprof) jdbcTemplate.queryForObject(sentenciaSQL, new Object[] {idObj}, gppPerfilprofRowMapper);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppPerfilprof;
	}

	public List<Object> buscarTodos() {
		gppPerfilesprofesionales = null;
		try{
			gppPerfilprofRowMapper = new GppPerfilprofRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_perfilprof order by ppr_nidperfilprof asc";
			gppPerfilesprofesionales = (List) jdbcTemplate.query(sentenciaSQL, gppPerfilprofRowMapper);
		} catch(Exception ex){
			ex.printStackTrace();
		}
		return gppPerfilesprofesionales;
	}

	public boolean crear(Object obj) {
		estadoOperation = false;
		try{
			gppPerfilprof = (GppPerfilprof) obj;			
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "insert into gpp_perfilprof (ppr_vperfil, ppr_nnivelidi1, ppr_nnivelidi2, ppr_vherrasw, ppr_vmotorbd, peq_nidperfileq, per_nidpersona, idi_nididioma1, idi_nididioma2, ppr_vusucrea,  ppr_dfeccrea) " +
							"values (?, ?, ?, ?, ?, ?, ? ,? ,? ,? ,?)";	
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppPerfilprof.getPprVperfil(),
															gppPerfilprof.getPprNnivelidi1(),
															gppPerfilprof.getPprNnivelidi2(),
															gppPerfilprof.getPprVherrasw(),
															gppPerfilprof.getPprVmotorbd(),
															gppPerfilprof.getPeqNidperfileq(),
															gppPerfilprof.getPerNidpersona(),
															gppPerfilprof.getIdiNididioma1(),
															gppPerfilprof.getIdiNididioma2(),
															gppPerfilprof.getPprVusucrea(),
															gppPerfilprof.getPprDfeccrea()},
															new int[] {Types.VARCHAR,
																		Types.INTEGER,
																		Types.INTEGER,																		
																		Types.VARCHAR,
																		Types.VARCHAR,
																		Types.INTEGER,
																		Types.INTEGER,
																		Types.INTEGER,
																		Types.INTEGER,
																		Types.VARCHAR,
																		Types.DATE});
			estadoOperation = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return estadoOperation;
	}
	
	public List<Object> buscarPerfilesPersona(Object idObj){
		gppPerfilesprofesionales = null;
		try{
			gppPerfilprofRowMapper = new GppPerfilprofRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_perfilprof where per_nidpersona = ?";
			gppPerfilesprofesionales = (List<Object>) jdbcTemplate.query(sentenciaSQL, new Object[] {idObj}, gppPerfilprofRowMapper);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppPerfilesprofesionales;
	}
}