package co.com.inascol.atenea.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import co.com.inascol.atenea.dao.utils.DAO;
import co.com.inascol.atenea.dao.utils.TemplateManager;
import co.com.inascol.atenea.entity.GppTituloequivalente;
import co.com.inascol.atenea.entity.rowmapper.GppTituloequivalenteRowMapper;

public class GppTituloequivalenteDAO implements DAO{

	private GppTituloequivalente gppTituloequivalente;
	private GppTituloequivalenteRowMapper gppTituloequivalenteRowMapper;
	private List<Object> gppTitulosEquivalentes;
	private Boolean estadoOperation;	
	private String sentenciaSQL;
	private JdbcTemplate jdbcTemplate;
	
	public boolean actualizar(Object obj) {
		estadoOperation = false;
		try{
			gppTituloequivalente = (GppTituloequivalente) obj;			
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "update gpp_tituloequivalente " +
							"set teq_vtituloeq = ?, " +
							"teq_vusumodifica = ?, " +
							"teq_dfecmodifica = ? " +							
							"where teq_nidtituloeq = ?";	
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppTituloequivalente.getTeqVtituloeq(),
															gppTituloequivalente.getTeqVusumodifica(),
															gppTituloequivalente.getTeqDfecmodifica(),
															gppTituloequivalente.getTeqNidtituloeq()},
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
			sentenciaSQL = "delete from gpp_tituloequivalente " +
							"where teq_nidtituloeq = ? ";	
			jdbcTemplate.update(sentenciaSQL, new Object[] {idObj}, new int[] {Types.INTEGER});	
			estadoOperation = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return estadoOperation;
	}

	public Object buscarPorId(Object idObj) {
		gppTituloequivalente = null;
		try{
			gppTituloequivalenteRowMapper = new GppTituloequivalenteRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_tituloequivalente where teq_nidtituloeq = ?";
			gppTituloequivalente = (GppTituloequivalente) jdbcTemplate.queryForObject(sentenciaSQL, new Object[] {idObj}, gppTituloequivalenteRowMapper);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppTituloequivalente;
	}

	public List<Object> buscarTodos() {
		gppTitulosEquivalentes = null;
		try{
			gppTituloequivalenteRowMapper = new GppTituloequivalenteRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_tituloequivalente order by teq_vtituloeq asc";
			gppTitulosEquivalentes = (List) jdbcTemplate.query(sentenciaSQL, gppTituloequivalenteRowMapper);
		} catch(Exception ex){
			ex.printStackTrace();
		}
		return gppTitulosEquivalentes;
	}

	public boolean crear(Object obj) {
		estadoOperation = false;
		try{
			gppTituloequivalente = (GppTituloequivalente) obj;
			
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "insert into gpp_tituloequivalente " +
							"(teq_vtituloeq, teq_vusucrea, teq_dfeccrea) " +
							"values (?, ?, ?)";	
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppTituloequivalente.getTeqVtituloeq(),
															gppTituloequivalente.getTeqVusumodifica(),
															gppTituloequivalente.getTeqDfecmodifica()},
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