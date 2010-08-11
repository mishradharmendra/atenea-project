package co.com.inascol.atenea.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import co.com.inascol.atenea.dao.utils.DAO;
import co.com.inascol.atenea.dao.utils.TemplateManager;
import co.com.inascol.atenea.entity.GppRol;
import co.com.inascol.atenea.dao.GppServiciorolDAO;
import co.com.inascol.atenea.entity.GppServiciorol;
import co.com.inascol.atenea.entity.GppServiciorolId;
import co.com.inascol.atenea.entity.rowmapper.GppRolRowMapper;
/**
 * @author Guillermo Toro
 *
 */
public class GppRolDAO implements DAO {
	
	private GppRol gppRol;
	private GppRolRowMapper gppRolRowMapper;
	private List<Object> gppRols;
	private Boolean estadoOperation;	
	private String sentenciaSQL;
	private JdbcTemplate jdbcTemplate;
	
	public boolean actualizar(Object obj) {
		estadoOperation = false;
		try{
			gppRol = (GppRol) obj;			
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "update gpp_rol " +
							"set rol_vnombre = ?, " +
							"rol_vdescripcion = ?, " +
							"rol_vusumodifica = ?, " +
							"rol_dfecmodifica = ?, " +							
							"rol_vactivo = ? " +							
							"where rol_nidrol = ?";	
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppRol.getRolVnombre(),
															gppRol.getRolVdescripcion(),
															gppRol.getRolVusumodifica(),
															gppRol.getRolDfecmodifica(),
															gppRol.getRolBactivo(),
															gppRol.getRolNidrol()},
															new int[] {Types.VARCHAR,
																		Types.VARCHAR,
																		Types.VARCHAR,
																		Types.DATE,
																		Types.VARCHAR,
																		Types.INTEGER});
			sentenciaSQL = "select ser_nidservicio from gpp_serviciorol where rol_nidrol = ? ";
			List<Object> idsRegistrados = jdbcTemplate.queryForList(sentenciaSQL, new Object[]{gppRol.getRolNidrol()},new int[] {Types.INTEGER}, Integer.class);
			if(gppRol.getServicios()!=null){
				if(gppRol.getServicios().size()>0){
					Iterator<Object> idsNuevos = gppRol.getServicios().iterator();
					GppServiciorolDAO gppServiciorolDAO = new GppServiciorolDAO();
					while(idsNuevos.hasNext()){
						Integer idNuevo = (Integer) idsNuevos.next();
						if(idsRegistrados.contains(idNuevo)==false){
							GppServiciorolId gppServiciorolId= new GppServiciorolId();
							gppServiciorolId.setRolNidrol(gppRol.getRolNidrol());
							gppServiciorolId.setSerNidservicio(idNuevo);
							GppServiciorol gppServiciorol = new GppServiciorol();
							gppServiciorol.setId(gppServiciorolId);
							gppServiciorol.setSrlDfeccrea(new Date());
							gppServiciorol.setSrlVusucrea(gppRol.getRolVusumodifica());
							estadoOperation = gppServiciorolDAO.crear(gppServiciorol);							
						}
					}
					Iterator<Object> idsViejos = idsRegistrados.iterator();
					while(idsViejos.hasNext()){
						Integer idViejo = (Integer) idsViejos.next();
						if(gppRol.getServicios().contains(idViejo)==false){
							GppServiciorolId gppServiciorolId= new GppServiciorolId();
							gppServiciorolId.setRolNidrol(gppRol.getRolNidrol());
							gppServiciorolId.setSerNidservicio(idViejo);
							GppServiciorol gppServiciorol = new GppServiciorol();
							gppServiciorol.setId(gppServiciorolId);
							gppServiciorol.setSrlDfeccrea(new Date());
							gppServiciorol.setSrlVusucrea(gppRol.getRolVusumodifica());
							estadoOperation = gppServiciorolDAO.borrar(gppServiciorol);	
						}
					}
				}
			}
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
			sentenciaSQL = "delete from gpp_rol " +
							"where rol_nidrol = ? ";	
			jdbcTemplate.update(sentenciaSQL, new Object[] {idObj}, new int[] {Types.VARCHAR});	
			estadoOperation = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return estadoOperation;
	}

	public Object buscarPorId(Object idObj) {
		gppRol = null;
		try{
			gppRolRowMapper = new GppRolRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_rol where rol_nidrol = ?";
			gppRol = (GppRol) jdbcTemplate.queryForObject(sentenciaSQL, new Object[] {idObj}, gppRolRowMapper);
			GppServiciorolDAO gppServiciorol = new GppServiciorolDAO(); 
			List <Object> servicioRoles = gppServiciorol.buscarTodosServiciosRoles(Integer.valueOf(gppRol.getRolNidrol()));
			if(servicioRoles.size()>0){
				Iterator<Object> it = servicioRoles.iterator();
				GppServicioDAO servicioDAO = new GppServicioDAO();
				List<Object> gppServicios = new ArrayList<Object>();
				while(it.hasNext()){
					GppServiciorol servicioRol = (GppServiciorol) it.next();
					gppServicios.add(servicioDAO.buscarPorId(servicioRol.getId().getSerNidservicio()));
				}
				gppRol.setGppServicios(gppServicios);
			}
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppRol;
	}

	public List<Object> buscarTodos() {
		gppRols = null;
		try{
			gppRolRowMapper = new GppRolRowMapper();
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "select * from gpp_rol order by rol_vnombre asc";
			gppRols = (List) jdbcTemplate.query(sentenciaSQL, gppRolRowMapper);
		} catch(Exception ex){
			ex.printStackTrace();
		}
		return gppRols;
	}

	public boolean crear(Object obj) {
		estadoOperation = false;
		try{
			gppRol = (GppRol) obj;
			jdbcTemplate = TemplateManager.getInstance().getJDBCTemplate();
			sentenciaSQL = "insert into gpp_rol " +
							"(rol_vnombre, rol_vdescripcion, rol_vusucrea, rol_dfeccrea, rol_vactivo) "+
							"values (?, ?, ?, ?, ?)";	
			jdbcTemplate.update(sentenciaSQL, new Object[]{gppRol.getRolVnombre(),
					 										gppRol.getRolVdescripcion(),
															gppRol.getRolVusucrea(),
															gppRol.getRolDfeccrea(),
															gppRol.getRolBactivo()},
															new int[] {Types.VARCHAR,
																		Types.VARCHAR,
																		Types.VARCHAR,
																		Types.DATE,
																		Types.VARCHAR});
			sentenciaSQL = "select rol_nidrol from gpp_rol where rol_vnombre = ? ";
			Integer gppIdRol = jdbcTemplate.queryForInt(sentenciaSQL, new Object[]{gppRol.getRolVnombre()},	new int[] {Types.VARCHAR});
			if(gppRol.getServicios()!=null){
				Iterator<Object> it = gppRol.getServicios().iterator();
				GppServiciorolDAO gppServiciorolDAO = new GppServiciorolDAO();
				while(it.hasNext()){ 
					Integer idServicio =  (Integer) it.next();
					GppServiciorolId gppServiciorolId= new GppServiciorolId();
					gppServiciorolId.setRolNidrol(gppIdRol);
					gppServiciorolId.setSerNidservicio(idServicio);
					GppServiciorol gppServiciorol = new GppServiciorol();
					gppServiciorol.setId(gppServiciorolId);
					gppServiciorol.setSrlDfeccrea(new Date());
					gppServiciorol.setSrlVusucrea(gppRol.getRolVusucrea());
					estadoOperation = gppServiciorolDAO.crear(gppServiciorol);
				}
			}else{
				System.out.println("Rol Sin Servicios.");
			}	
			estadoOperation = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return estadoOperation;
	}
}