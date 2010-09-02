package co.com.inascol.atenea.logic;

import java.util.Date;
import java.util.List;

import co.com.inascol.atenea.dao.GppIdiomaDAO;
import co.com.inascol.atenea.entity.GppIdioma;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.interfaces.IIdiomaService;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcción de Software
 * Esp. Sistemas de Información Geográfica
 * Ing. Catastral y Geodesta
 */
public class IdiomaService implements IIdiomaService {

	private Boolean estadoOperacion;
	private GppIdiomaDAO gppIdiomaDAO;
	private GppIdioma gppIdioma;
	private List<Object> gppIdiomas;
	
	public boolean actualizarIdioma(Integer idIdioma, String nombreIdioma, GppUsuario usuarioAutenticado) {
		estadoOperacion = false;
		try{			
			gppIdiomaDAO = new GppIdiomaDAO();
			gppIdioma = new GppIdioma();
			gppIdioma.setIdiNididioma(idIdioma);
			gppIdioma.setIdiVidioma(nombreIdioma);
			gppIdioma.setIdiVusumodifica(usuarioAutenticado.getUsuVlogin());
			gppIdioma.setIdiDfecmodifica(new Date());
			estadoOperacion = gppIdiomaDAO.actualizar(gppIdioma);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public boolean borrarIdioma(Integer idIdioma) {
		estadoOperacion = false;
		try{			
			gppIdiomaDAO = new GppIdiomaDAO();
			estadoOperacion = gppIdiomaDAO.borrar(idIdioma);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public List<Object> buscarIdiomas() {
		gppIdiomas = null;
		try{			
			gppIdiomaDAO = new GppIdiomaDAO();
			gppIdiomas = gppIdiomaDAO.buscarTodos();
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppIdiomas;
	}

	public GppIdioma buscarPorIdIdioma(Integer idIdioma) {
		gppIdioma = null;
		try{			
			gppIdiomaDAO = new GppIdiomaDAO();
			gppIdioma = (GppIdioma) gppIdiomaDAO.buscarPorId(idIdioma);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppIdioma;
	}

	public boolean crearIdioma(String nombreIdioma, GppUsuario usuarioAutenticado) {
		estadoOperacion = false;
		try{			
			gppIdiomaDAO = new GppIdiomaDAO();
			gppIdioma = new GppIdioma();
			gppIdioma.setIdiVidioma(nombreIdioma);
			gppIdioma.setIdiVusucrea(usuarioAutenticado.getUsuVlogin());
			gppIdioma.setIdiDfeccrea(new Date());
			estadoOperacion = gppIdiomaDAO.crear(gppIdioma);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}
}