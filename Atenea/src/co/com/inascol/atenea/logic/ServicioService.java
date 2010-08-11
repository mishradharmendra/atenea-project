package co.com.inascol.atenea.logic;

import java.util.Date;
import java.util.List;

import co.com.inascol.atenea.dao.GppServicioDAO;
import co.com.inascol.atenea.entity.GppServicio;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.interfaces.IServicioService;
/**
 * @author Guillermo Toro
 *
 */
public class ServicioService implements IServicioService {

	private Boolean estadoOperacion;
	private GppServicioDAO gppServicioDAO;
	private GppServicio gppServicio;
	private List<Object> gppServicios;
	
	public ServicioService(){}

	public boolean actualizarServicio(Integer idServicio, String nombreServicio, String rutaServicio) {
		estadoOperacion = false;
		try{			
			gppServicioDAO = new GppServicioDAO();
			gppServicio = new GppServicio();
			gppServicio.setSerNidservicio(idServicio);
			gppServicio.setSerVnombre(nombreServicio);
			gppServicio.setSerVruta(rutaServicio);
			gppServicio.setSerDfeccrea(new Date());
			estadoOperacion = gppServicioDAO.actualizar(gppServicio);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public boolean borrarServicio(Integer idServicio) {
		estadoOperacion = false;
		try{			
			gppServicioDAO = new GppServicioDAO();
			estadoOperacion = gppServicioDAO.borrar(idServicio);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public List<Object> buscarServicios() {
		gppServicios = null;
		try{			
			gppServicioDAO = new GppServicioDAO();
			gppServicios = gppServicioDAO.buscarTodos();
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppServicios;
	}

	public GppServicio buscarPorIdServicio(Integer idServicio) {
		gppServicio = null;
		try{			
			gppServicioDAO = new GppServicioDAO();
			gppServicio = (GppServicio) gppServicioDAO.buscarPorId(idServicio);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppServicio;
	}

	public boolean crearServicio(String nombreServicio, String rutaServicio, GppUsuario usuarioAutenticado) {
		estadoOperacion = false;
		try{			
			gppServicioDAO = new GppServicioDAO();
			gppServicio = new GppServicio();
			gppServicio.setSerVnombre(nombreServicio);
			gppServicio.setSerVruta(rutaServicio);
			gppServicio.setSerVusucrea(usuarioAutenticado.getUsuVlogin());
			gppServicio.setSerDfeccrea(new Date());
			estadoOperacion = gppServicioDAO.crear(gppServicio);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}
}