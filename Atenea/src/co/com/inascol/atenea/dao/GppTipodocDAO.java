package co.com.inascol.atenea.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import co.com.inascol.atenea.dao.utils.DAO;
import co.com.inascol.atenea.dao.utils.TemplateManager;
import co.com.inascol.atenea.entity.GppTipodoc;
import co.com.inascol.atenea.entity.rowmapper.GppTipodocRowMapper;

public class GppTipodocDAO implements DAO{

	private GppTipodoc gppTipodoc;
	private GppTipodocRowMapper gppTipodocRowMapper;
	private List<Object> gppTipoDocumentos;
	private Boolean estadoOperation;	
	private String sentenciaSQL;
	private JdbcTemplate jdbcTemplate;
	
	public boolean actualizar(Object obj) {
		estadoOperation = false;
		try{
			gppTipodoc = (GppTipodoc) obj;			
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "update gpp_tipodoc " +
							"set tdc_vnombre = ?, " +
							"tdc_vusumodifica = ?, " +
							"tdc_dfecmodifica = ? " +							
							"where tdc_nidtipodoc = ?";	
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppTipodoc.getTdcVnombre(),
															gppTipodoc.getTdcVusumodifica(),
															gppTipodoc.getTdcDfecmodifica(),
															gppTipodoc.getTdcNidtipodoc()},
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
			sentenciaSQL = "delete from gpp_tipodoc " +
							"where tdc_nidtipodoc = ? ";	
			jdbcTemplate.update(sentenciaSQL, new Object[] {idObj}, new int[] {Types.INTEGER});	
			estadoOperation = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return estadoOperation;
	}

	public Object buscarPorId(Object idObj) {
		gppTipodoc = null;
		try{
			gppTipodocRowMapper = new GppTipodocRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_tipodoc where tdc_nidtipodoc = ?";
			gppTipodoc = (GppTipodoc) jdbcTemplate.queryForObject(sentenciaSQL, new Object[] {idObj}, gppTipodocRowMapper);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppTipodoc;
	}

	public List<Object> buscarTodos() {
		gppTipoDocumentos = null;
		try{
			gppTipodocRowMapper = new GppTipodocRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_tipodoc order by tdc_vnombre asc";
			gppTipoDocumentos = (List) jdbcTemplate.query(sentenciaSQL, gppTipodocRowMapper);
		} catch(Exception ex){
			ex.printStackTrace();
		}
		return gppTipoDocumentos;
	}

	public boolean crear(Object obj) {
		estadoOperation = false;
		try{
			gppTipodoc = (GppTipodoc) obj;			
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "insert into gpp_tipodoc " +
							"(tdc_vnombre, tdc_vusucrea, tdc_dfeccrea) " +
							"values (?, ?, ?)";	
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppTipodoc.getTdcVnombre(),
															gppTipodoc.getTdcVusucrea(),
															gppTipodoc.getTdcDfeccrea()},
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