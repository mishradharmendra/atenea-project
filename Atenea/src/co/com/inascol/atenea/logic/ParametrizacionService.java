package co.com.inascol.atenea.logic;

import java.util.List;

import co.com.inascol.atenea.dao.GppParametrizacionDAO;
import co.com.inascol.atenea.entity.GppParametrizacion;
import co.com.inascol.atenea.logic.interfaces.IParametrizacionService;
/**
 * @author Guillermo Toro
 *
 */
public class ParametrizacionService implements IParametrizacionService {

	private Boolean estadoOperacion;
	private GppParametrizacionDAO gppParametrizacionDAO;
	private GppParametrizacion gppParametrizacion;
	private List<Object> gppParametrizacions;
	
	public boolean actualizarParametrizacion(Integer idParam, String nombreParam, String valorParam, String descripcionParam) {
		estadoOperacion = false;
		try{			
			gppParametrizacionDAO = new GppParametrizacionDAO();
			gppParametrizacion = new GppParametrizacion();
			gppParametrizacion.setParNidparam(idParam);
			gppParametrizacion.setParVnombre(nombreParam);			
			gppParametrizacion.setParVvalor(valorParam);
			gppParametrizacion.setParVdescripcion(descripcionParam);
			estadoOperacion = gppParametrizacionDAO.actualizar(gppParametrizacion);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public boolean borrarParametrizacion(Integer idParam) {
		estadoOperacion = false;
		try{			
			gppParametrizacionDAO = new GppParametrizacionDAO();
			estadoOperacion = gppParametrizacionDAO.borrar(idParam);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public List<Object> buscarParametrizacion() {
		gppParametrizacions = null;
		try{			
			gppParametrizacionDAO = new GppParametrizacionDAO();
			gppParametrizacions = gppParametrizacionDAO.buscarTodos();
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppParametrizacions;
	}

	public GppParametrizacion buscarPorIdParametrizacion(Integer idParam) {
		gppParametrizacion = null;
		try{			
			gppParametrizacionDAO = new GppParametrizacionDAO();
			gppParametrizacion = (GppParametrizacion) gppParametrizacionDAO.buscarPorId(idParam);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppParametrizacion;
	}

	public boolean crearParametrizacion(String nombreParam, String valorParam, String descripcionParam) {
		estadoOperacion = false;
		try{			
			gppParametrizacionDAO = new GppParametrizacionDAO();
			gppParametrizacion = new GppParametrizacion();
			gppParametrizacion.setParVnombre(nombreParam);
			gppParametrizacion.setParVvalor(valorParam);
			gppParametrizacion.setParVdescripcion(descripcionParam);
			estadoOperacion = gppParametrizacionDAO.crear(gppParametrizacion);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}
}