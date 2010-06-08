package co.com.inascol.atenea.logic;

import java.util.Date;
import java.util.List;

import co.com.inascol.atenea.dao.GppRolDAO;
import co.com.inascol.atenea.entity.GppRol;
import co.com.inascol.atenea.logic.interfaces.IRolService;

public class RolService implements IRolService {

	private Boolean estadoOperacion;
	private GppRolDAO gppRolDAO;
	private GppRol gppRol;
	private List<Object> gppRols;
	
	public boolean actualizarRol(Integer idRol, String nombreRol, String descripcionRol, String activoRol) {
		estadoOperacion = false;
		try{			
			gppRolDAO = new GppRolDAO();
			gppRol = new GppRol();
			gppRol.setRolNidrol(idRol);
			gppRol.setRolVnombre(nombreRol);
			gppRol.setRolVdescripcion(descripcionRol);
			gppRol.setRolVusumodifica("mi memo");
			gppRol.setRolDfecmodifica(new Date());
			gppRol.setRolVactivo(activoRol);
			estadoOperacion = gppRolDAO.actualizar(gppRol);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public boolean borrarRol(Integer idRol) {
		estadoOperacion = false;
		try{			
			gppRolDAO = new GppRolDAO();
			estadoOperacion = gppRolDAO.borrar(idRol);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public List<Object> buscarRoles() {
		gppRols = null;
		try{			
			gppRolDAO = new GppRolDAO();
			gppRols = gppRolDAO.buscarTodos();
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppRols;
	}

	public GppRol buscarPorIdRol(Integer idRol) {
		gppRol = null;
		try{			
			gppRolDAO = new GppRolDAO();
			gppRol = (GppRol) gppRolDAO.buscarPorId(idRol);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppRol;
	}

	public boolean crearRol(String nombreRol, String descripcionRol, String activoRol, List <Object> listaServicios) {
		estadoOperacion = false;
		try{			
			gppRolDAO = new GppRolDAO();
			gppRol = new GppRol();
			gppRol.setRolVnombre(nombreRol);
			gppRol.setRolVdescripcion(descripcionRol);
			gppRol.setRolVusucrea("mi memo crea");
			gppRol.setRolDfeccrea(new Date());
			gppRol.setRolVactivo(activoRol);
			gppRol.setRolServicios(listaServicios);
			estadoOperacion = gppRolDAO.crear(gppRol);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}
}