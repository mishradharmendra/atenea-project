package co.com.inascol.atenea.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import co.com.inascol.atenea.dao.utils.DAO;
import co.com.inascol.atenea.dao.utils.TemplateManager;
import co.com.inascol.atenea.entity.GppDepartamento;
import co.com.inascol.atenea.entity.rowmapper.GppDepartamentoRowMapper;
/**
 * @author Guillermo Toro
 *
 */
public class GppDepartamentoDAO implements DAO {
	
	private GppDepartamento gppDepartamento;
	private GppDepartamentoRowMapper gppDepartamentoRowMapper;
	private List<Object> gppDepartamentos;
	private Boolean estadoOperation;	
	private String sentenciaSQL;
	private JdbcTemplate jdbcTemplate;
	
	public boolean actualizar(Object obj) {
		estadoOperation = false;
		try{
			gppDepartamento = (GppDepartamento) obj;			
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "update gpp_departamento " +
							"set dpt_vdepto = ?, " +
							"pai_nidpais = ?, " +
							"dpt_vusumodifica = ?, " +
							"dpt_dfecmodifica = ? " +							
							"where dpt_niddepto = ?";	
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppDepartamento.getDptVdepto(),
															gppDepartamento.getPaiNidpais(),
															gppDepartamento.getDptVusumodifica(),
															gppDepartamento.getDptDfecmodifica(),
															gppDepartamento.getDptNiddepto()},
															new int[] {Types.VARCHAR,
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
			sentenciaSQL = "delete from gpp_departamento " +
							"where dpt_niddepto = ? ";	
			jdbcTemplate.update(sentenciaSQL, new Object[] {idObj}, new int[] {Types.INTEGER});	
			estadoOperation = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return estadoOperation;
	}

	public Object buscarPorId(Object idObj) {
		gppDepartamento = null;
		try{
			gppDepartamentoRowMapper = new GppDepartamentoRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_departamento where dpt_niddepto = ?";
			gppDepartamento = (GppDepartamento) jdbcTemplate.queryForObject(sentenciaSQL, new Object[] {idObj}, gppDepartamentoRowMapper);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppDepartamento;
	}

	public List<Object> buscarTodos() {
		gppDepartamentos = null;
		try{
			gppDepartamentoRowMapper = new GppDepartamentoRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_departamento order by dpt_vdepto asc";
			gppDepartamentos = (List) jdbcTemplate.query(sentenciaSQL, gppDepartamentoRowMapper);
		} catch(Exception ex){
			ex.printStackTrace();
		}
		return gppDepartamentos;
	}

	public boolean crear(Object obj) {
		estadoOperation = false;
		try{
			gppDepartamento = (GppDepartamento) obj;
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "insert into gpp_departamento " +
							"(dpt_vdepto, pai_nidpais, dpt_vusucrea, dpt_dfeccrea) " +
							"values (?, ?, ?, ?)";	
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppDepartamento.getDptVdepto(),
					 										gppDepartamento.getPaiNidpais(),
															gppDepartamento.getDptVusucrea(),
															gppDepartamento.getDptDfeccrea()},
															new int[] {Types.VARCHAR,
																		Types.INTEGER,
																		Types.VARCHAR,
																		Types.DATE});
			estadoOperation = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return estadoOperation;
	}
}