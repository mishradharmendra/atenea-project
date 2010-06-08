package co.com.inascol.atenea.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import co.com.inascol.atenea.dao.utils.DAO;
import co.com.inascol.atenea.dao.utils.TemplateManager;
import co.com.inascol.atenea.entity.GppPerfilequivalente;
import co.com.inascol.atenea.entity.rowmapper.GppPerfilequivalenteRowMapper;

public class GppPerfilequivalenteDAO implements DAO{
	
	private GppPerfilequivalente gppPerfilequivalente;
	private GppPerfilequivalenteRowMapper gppPerfilequivalenteRowMapper;
	private List<Object> gppPerfilesEquivalentes;
	private Boolean estadoOperation;	
	private String sentenciaSQL;
	private JdbcTemplate jdbcTemplate;
	
	public boolean actualizar(Object obj) {
		estadoOperation = false;
		try{
			gppPerfilequivalente = (GppPerfilequivalente) obj;			
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "update gpp_perfilequivalente " +
							"set peq_vperfileq = ?, " +
							"peq_vusumodifica = ?, " +
							"peq_dfecmodifica = ? " +							
							"where peq_nidperfileq = ?";	
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppPerfilequivalente.getPeqVperfileq(),
															gppPerfilequivalente.getPeqVusumodifica(),
															gppPerfilequivalente.getPeqDfecmodifica(),
															gppPerfilequivalente.getPeqNidperfileq()},
															new int[] {Types.VARCHAR,
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
			sentenciaSQL = "delete from gpp_perfilequivalente " +
							"where peq_nidperfileq = ? ";	
			jdbcTemplate.update(sentenciaSQL, new Object[] {idObj}, new int[] {Types.INTEGER});	
			estadoOperation = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return estadoOperation;
	}

	public Object buscarPorId(Object idObj) {
		gppPerfilequivalente = null;
		try{
			gppPerfilequivalenteRowMapper = new GppPerfilequivalenteRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_perfilequivalente where peq_nidperfileq = ?";
			gppPerfilequivalente = (GppPerfilequivalente) jdbcTemplate.queryForObject(sentenciaSQL, new Object[] {idObj}, gppPerfilequivalenteRowMapper);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppPerfilequivalente;
	}

	public List<Object> buscarTodos() {
		gppPerfilesEquivalentes = null;
		try{
			gppPerfilequivalenteRowMapper = new GppPerfilequivalenteRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_perfilequivalente order by peq_vperfileq asc";
			gppPerfilesEquivalentes = (List) jdbcTemplate.query(sentenciaSQL, gppPerfilequivalenteRowMapper);
		} catch(Exception ex){
			ex.printStackTrace();
		}
		return gppPerfilesEquivalentes;
	}

	public boolean crear(Object obj) {
		estadoOperation = false;
		try{
			gppPerfilequivalente = (GppPerfilequivalente) obj;
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "insert into gpp_perfilequivalente " +
							"(peq_vperfileq, peq_vusucrea, peq_dfeccrea)" +
							"values (?, ?, ?)";	
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppPerfilequivalente.getPeqVperfileq(),
															gppPerfilequivalente.getPeqVusucrea(),
															gppPerfilequivalente.getPeqDfeccrea()},
															new int[] {Types.VARCHAR,
																		Types.VARCHAR,
																		Types.DATE});
			estadoOperation = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return estadoOperation;
	}
}