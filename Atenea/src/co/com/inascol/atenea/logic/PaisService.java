package co.com.inascol.atenea.logic;

import java.util.Date;
import java.util.List;

import co.com.inascol.atenea.dao.GppPaisDAO;
import co.com.inascol.atenea.entity.GppPais;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.interfaces.IPaisService;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcción de Software
 * Esp. Sistemas de Información Geográfica
 * Ing. Catastral y Geodesta
 */
public class PaisService implements IPaisService {

	private Boolean estadoOperacion;
	private GppPaisDAO gppPaisDAO;
	private GppPais gppPais;
	private List<Object> gppPaiss;
	
	public boolean actualizarPais(Integer idPais, String nombrePais, GppUsuario usuarioAutenticado) {
		estadoOperacion = false;
		try{			
			gppPaisDAO = new GppPaisDAO();
			gppPais = new GppPais();
			gppPais.setPaiNidpais(idPais);
			gppPais.setPaiVpais(nombrePais);
			gppPais.setPaiVusumodifica(usuarioAutenticado.getUsuVlogin());
			gppPais.setPaiDfecmodifica(new Date());
			estadoOperacion = gppPaisDAO.actualizar(gppPais);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public boolean borrarPais(Integer idPais) {
		estadoOperacion = false;
		try{			
			gppPaisDAO = new GppPaisDAO();
			estadoOperacion = gppPaisDAO.borrar(idPais);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public List<Object> buscarPaises() {
		gppPaiss = null;
		try{			
			gppPaisDAO = new GppPaisDAO();
			gppPaiss = gppPaisDAO.buscarTodos();
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppPaiss;
	}

	public GppPais buscarPorIdPais(Integer idPais) {
		gppPais = null;
		try{			
			gppPaisDAO = new GppPaisDAO();
			gppPais = (GppPais) gppPaisDAO.buscarPorId(idPais);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppPais;
	}

	public boolean crearPais(String nombrePais, GppUsuario usuarioAutenticado) {
		estadoOperacion = false;
		try{			
			gppPaisDAO = new GppPaisDAO();
			gppPais = new GppPais();
			gppPais.setPaiVpais(nombrePais);
			gppPais.setPaiVusucrea(usuarioAutenticado.getUsuVlogin());
			gppPais.setPaiDfeccrea(new Date());
			estadoOperacion = gppPaisDAO.crear(gppPais);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}
}