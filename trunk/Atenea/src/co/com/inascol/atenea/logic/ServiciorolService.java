package co.com.inascol.atenea.logic;

import java.util.Date;
import java.util.List;

import co.com.inascol.atenea.dao.GppServiciorolDAO;
import co.com.inascol.atenea.entity.GppServiciorolId;
import co.com.inascol.atenea.entity.GppServiciorol;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.interfaces.IServiciorolService;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class ServiciorolService implements IServiciorolService {

	private Boolean estadoOperacion;
	private GppServiciorolDAO gppServiciorolDAO;
	private GppServiciorol gppServiciorol;
	private GppServiciorolId gppServiciorolId;	
	private List<Object> gppServiciorols;
	
	public boolean actualizarServiciorol(Integer idServicio, Integer idRol, GppUsuario usuarioAutenticado) {
		estadoOperacion = false;
		try{			
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public boolean borrarServiciorol(Integer idServicio, Integer idRol) {
		estadoOperacion = false;
		try{
			gppServiciorolId = new GppServiciorolId();			
			gppServiciorolId.setSerNidservicio(idServicio);
			gppServiciorolId.setRolNidrol(idRol);		
			
			gppServiciorol = new GppServiciorol();
			gppServiciorol.setId(gppServiciorolId);
			
			gppServiciorolDAO = new GppServiciorolDAO();
			estadoOperacion = gppServiciorolDAO.borrar(gppServiciorol);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public List<Object> buscarServicioroles() {
		gppServiciorols = null;
		try{			
			gppServiciorolDAO = new GppServiciorolDAO();
			gppServiciorols = gppServiciorolDAO.buscarTodos();
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppServiciorols;
	}

	public GppServiciorol buscarPorIdServiciorol(Integer idServicio, Integer idRol) {
		gppServiciorol = null;
		try{
			gppServiciorolId = new GppServiciorolId();			
			gppServiciorolId.setSerNidservicio(idServicio);
			gppServiciorolId.setRolNidrol(idRol);
			
			gppServiciorol = new GppServiciorol();
			gppServiciorol.setId(gppServiciorolId);
			
			gppServiciorolDAO = new GppServiciorolDAO();
			gppServiciorol = (GppServiciorol) gppServiciorolDAO.buscarPorId(gppServiciorol);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppServiciorol;
	}

	public boolean crearServiciorol(Integer idServicio, Integer idRol, GppUsuario usuarioAutenticado) {
		estadoOperacion = false;
		try{			
			gppServiciorolId = new GppServiciorolId();
			gppServiciorolId.setSerNidservicio(idServicio);
			gppServiciorolId.setRolNidrol(idRol);
			
			gppServiciorol = new GppServiciorol();			
			gppServiciorol.setId(gppServiciorolId);
			gppServiciorol.setSrlVusucrea(usuarioAutenticado.getUsuVlogin());
			gppServiciorol.setSrlDfeccrea(new Date());
			
			gppServiciorolDAO = new GppServiciorolDAO();
			estadoOperacion = gppServiciorolDAO.crear(gppServiciorol);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}
}