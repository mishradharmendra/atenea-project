package co.com.inascol.atenea.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import co.com.inascol.atenea.dao.utils.DAO;
import co.com.inascol.atenea.dao.utils.TemplateManager;
import co.com.inascol.atenea.entity.GppNivelacademico;
import co.com.inascol.atenea.entity.rowmapper.GppNivelacademicoRowMapper;

public class GppNivelacademicoDAO implements DAO{
	
	private GppNivelacademico gppNivelacademico;
	private GppNivelacademicoRowMapper gppNivelacademicoRowMapper;
	private List<Object> gppNivelesacademicos;
	private Boolean estadoOperation;	
	private String sentenciaSQL;
	private JdbcTemplate jdbcTemplate;

	public boolean actualizar(Object obj) {
		estadoOperation = false;
		try{
			gppNivelacademico = (GppNivelacademico) obj;			
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "update gpp_nivelacademico " +
							"set nac_vnivelac = ?, " +
							"nac_vusumodifica = ?, " +
							"nac_dfecmodifica = ? " +							
							"where nac_nidnivelac = ?";	
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppNivelacademico.getNacVnivelac(),
															gppNivelacademico.getNacVusumodifica(),
															gppNivelacademico.getNacDfecmodifica(),
															gppNivelacademico.getNacNidnivelac()},
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
			sentenciaSQL = "delete from gpp_nivelacademico " +
							"where nac_nidnivelac = ? ";	
			jdbcTemplate.update(sentenciaSQL, new Object[] {idObj}, new int[] {Types.INTEGER});	
			estadoOperation = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return estadoOperation;
	}

	public Object buscarPorId(Object idObj) {
		gppNivelacademico = null;
		try{
			gppNivelacademicoRowMapper = new GppNivelacademicoRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_nivelacademico where nac_nidnivelac = ?";
			gppNivelacademico = (GppNivelacademico) jdbcTemplate.queryForObject(sentenciaSQL, new Object[] {idObj}, gppNivelacademicoRowMapper);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppNivelacademico;
	}

	public List<Object> buscarTodos() {
		gppNivelesacademicos = null;
		try{
			gppNivelacademicoRowMapper = new GppNivelacademicoRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_nivelacademico order by nac_vnivelac asc";
			gppNivelesacademicos = (List) jdbcTemplate.query(sentenciaSQL, gppNivelacademicoRowMapper);
		} catch(Exception ex){
			ex.printStackTrace();
		}
		return gppNivelesacademicos;
	}

	public boolean crear(Object obj) {
		estadoOperation = false;
		try{
			gppNivelacademico = (GppNivelacademico) obj;
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "insert into gpp_nivelacademico " +
							"(nac_vnivelac, nac_vusucrea, nac_dfeccrea) " +
							"values (?, ?, ?)";	
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppNivelacademico.getNacVnivelac(),
															gppNivelacademico.getNacVusucrea(),
															gppNivelacademico.getNacDfeccrea()},
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