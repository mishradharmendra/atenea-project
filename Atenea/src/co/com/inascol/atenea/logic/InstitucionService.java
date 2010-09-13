package co.com.inascol.atenea.logic;

import java.util.Date;
import java.util.List;

import co.com.inascol.atenea.dao.GppInstitucionDAO;
import co.com.inascol.atenea.entity.GppInstitucion;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.interfaces.IInstitucionService;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class InstitucionService implements IInstitucionService {

	private Boolean estadoOperacion;
	private GppInstitucionDAO gppInstitucionDAO;
	private GppInstitucion gppInstitucion;
	private List<Object> gppInstituciones;
	
	public boolean actualizarInstitucion(Integer idInstitucion, String nombreInstitucion, GppUsuario usuarioAutenticado) {
		estadoOperacion = false;
		try{			
			gppInstitucionDAO = new GppInstitucionDAO();
			gppInstitucion = new GppInstitucion();
			gppInstitucion.setInsNidinstitucion(idInstitucion);
			gppInstitucion.setInsVinstitucion(nombreInstitucion);
			gppInstitucion.setInsVusumodifica(usuarioAutenticado.getUsuVlogin());
			gppInstitucion.setInsDfecmodifica(new Date());
			estadoOperacion = gppInstitucionDAO.actualizar(gppInstitucion);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public boolean borrarInstitucion(Integer idInstitucion) {
		estadoOperacion = false;
		try{			
			gppInstitucionDAO = new GppInstitucionDAO();
			estadoOperacion = gppInstitucionDAO.borrar(idInstitucion);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public List<Object> buscarInstituciones() {
		gppInstituciones = null;
		try{			
			gppInstitucionDAO = new GppInstitucionDAO();
			gppInstituciones = gppInstitucionDAO.buscarTodos();
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppInstituciones;
	}

	public GppInstitucion buscarPorIdInstitucion(Integer idInstitucion) {
		gppInstitucion = null;
		try{			
			gppInstitucionDAO = new GppInstitucionDAO();
			gppInstitucion = (GppInstitucion) gppInstitucionDAO.buscarPorId(idInstitucion);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppInstitucion;
	}

	public boolean crearInstitucion(String nombreInstitucion, GppUsuario usuarioAutenticado) {
		estadoOperacion = false;
		try{			
			gppInstitucionDAO = new GppInstitucionDAO();
			gppInstitucion = new GppInstitucion();
			gppInstitucion.setInsVinstitucion(nombreInstitucion);
			gppInstitucion.setInsVusucrea(usuarioAutenticado.getUsuVlogin());
			gppInstitucion.setInsDfeccrea(new Date());
			estadoOperacion = gppInstitucionDAO.crear(gppInstitucion);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}
}