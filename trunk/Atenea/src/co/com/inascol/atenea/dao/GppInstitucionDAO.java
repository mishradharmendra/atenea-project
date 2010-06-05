package co.com.inascol.atenea.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import co.com.inascol.atenea.dao.utils.DAO;
import co.com.inascol.atenea.dao.utils.TemplateManager;
import co.com.inascol.atenea.entity.GppInstitucion;
import co.com.inascol.atenea.entity.rowmapper.GppInstitucionRowMapper;

public class GppInstitucionDAO implements DAO{

	private GppInstitucion gppInstitucion;
	private GppInstitucionRowMapper gppInstitucionRowMapper;
	private List<Object> gppInstituciones;
	private Boolean estadoOperation;	
	private String sentenciaSQL;
	private JdbcTemplate jdbcTemplate;
	
	public GppInstitucionDAO(){}
	
	public boolean actualizar(Object obj) {
		estadoOperation = false;
		try{
			gppInstitucion = (GppInstitucion) obj;			
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "update gpp_institucion " +
							"set ins_vinstitucion = ?, " +
							"ins_vusumodifica = ?, " +
							"ins_dfecmodifica = ? " +							
							"where ins_nidinstitucion = ?";	
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppInstitucion.getInsVinstitucion(),
															gppInstitucion.getInsVusumodifica(),
															gppInstitucion.getInsDfecmodifica(),
															gppInstitucion.getInsNidinstitucion()},
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
			sentenciaSQL = "delete from gpp_institucion " +
							"where ins_nidinstitucion = ? ";	
			jdbcTemplate.update(sentenciaSQL, new Object[] {idObj}, new int[] {Types.INTEGER});	
			estadoOperation = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return estadoOperation;
	}

	public Object buscarPorId(Object idObj) {
		gppInstitucion = null;
		try{
			gppInstitucionRowMapper = new GppInstitucionRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_institucion where ins_nidinstitucion = ?";
			gppInstitucion = (GppInstitucion) jdbcTemplate.queryForObject(sentenciaSQL, new Object[] {idObj}, gppInstitucionRowMapper);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppInstitucion;
	}

	public List<Object> buscarTodos() {
		gppInstituciones = null;
		try{
			gppInstitucionRowMapper = new GppInstitucionRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_institucion order by ins_vinstitucion asc";
			gppInstituciones = (List) jdbcTemplate.query(sentenciaSQL, gppInstitucionRowMapper);
		} catch(Exception ex){
			ex.printStackTrace();
		}
		return gppInstituciones;
	}

	public boolean crear(Object obj) {
		estadoOperation = false;
		try{
			gppInstitucion = (GppInstitucion) obj;
			
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "insert into gpp_institucion " +
							"(ins_vinstitucion, ins_vusucrea, ins_dfeccrea) " +
							"values (?, ?, ?)";	
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppInstitucion.getInsVinstitucion(),
															gppInstitucion.getInsVusucrea(),
															gppInstitucion.getInsDfeccrea()},
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