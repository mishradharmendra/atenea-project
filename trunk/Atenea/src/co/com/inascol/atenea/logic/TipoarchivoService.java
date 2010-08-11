package co.com.inascol.atenea.logic;

import java.util.Date;
import java.util.List;

import co.com.inascol.atenea.dao.GppTipoarchivoDAO;
import co.com.inascol.atenea.entity.GppTipoarchivo;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.interfaces.ITipoarchivoService;
/**
 * @author Guillermo Toro
 *
 */
public class TipoarchivoService implements ITipoarchivoService {

	private Boolean estadoOperacion;
	private GppTipoarchivoDAO gppTipoarchivoDAO;
	private GppTipoarchivo gppTipoarchivo;
	private List<Object> gppTipoarchivos;

	public boolean actualizarTipoarchivo(Integer idTipoarchivo, String nombreTipoarchivo, GppUsuario usuarioAutenticado) {
		estadoOperacion = false;
		try{			
			gppTipoarchivoDAO = new GppTipoarchivoDAO();
			gppTipoarchivo = new GppTipoarchivo();
			gppTipoarchivo.setTarNidtipoarchivo(idTipoarchivo);
			gppTipoarchivo.setTarVtipoarchivo(nombreTipoarchivo);
			gppTipoarchivo.setTarVusumodifica(usuarioAutenticado.getUsuVlogin());
			gppTipoarchivo.setTarDfecmodifica(new Date());
			estadoOperacion = gppTipoarchivoDAO.actualizar(gppTipoarchivo);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public boolean borrarTipoarchivo(Integer idTipoarchivo) {
		estadoOperacion = false;
		try{			
			gppTipoarchivoDAO = new GppTipoarchivoDAO();
			estadoOperacion = gppTipoarchivoDAO.borrar(idTipoarchivo);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public List<Object> buscarTipoarchivos() {
		gppTipoarchivos = null;
		try{			
			gppTipoarchivoDAO = new GppTipoarchivoDAO();
			gppTipoarchivos = gppTipoarchivoDAO.buscarTodos();
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppTipoarchivos;
	}

	public GppTipoarchivo buscarPorIdTipoarchivo(Integer idTipoarchivo) {
		gppTipoarchivo = null;
		try{			
			gppTipoarchivoDAO = new GppTipoarchivoDAO();
			gppTipoarchivo = (GppTipoarchivo) gppTipoarchivoDAO.buscarPorId(idTipoarchivo);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppTipoarchivo;
	}

	public boolean crearTipoarchivo(String nombreTipoarchivo, GppUsuario usuarioAutenticado) {
		estadoOperacion = false;
		try{			
			gppTipoarchivoDAO = new GppTipoarchivoDAO();
			gppTipoarchivo = new GppTipoarchivo();
			gppTipoarchivo.setTarVtipoarchivo(nombreTipoarchivo);
			gppTipoarchivo.setTarVusucrea(usuarioAutenticado.getUsuVlogin());
			gppTipoarchivo.setTarDfeccrea(new Date());
			estadoOperacion = gppTipoarchivoDAO.crear(gppTipoarchivo);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}
}