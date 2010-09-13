package co.com.inascol.atenea.logic;

import java.util.Date;
import java.util.List;

import co.com.inascol.atenea.dao.GppPerfilequivalenteDAO;
import co.com.inascol.atenea.entity.GppPerfilequivalente;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.interfaces.IPerfilequivalenteService;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class PerfilequivalenteService implements IPerfilequivalenteService{

	private Boolean estadoOperacion;
	private GppPerfilequivalenteDAO gppPerfilequivalenteDAO;
	private GppPerfilequivalente gppPerfilequivalente;
	private List<Object> gppPerfilesEquivalentes;
	
	public boolean actualizarPerfilEquivalente(Integer idPerfilEquivalente, String nombrePerfilEquivalente, GppUsuario usuarioAutenticado) {
		estadoOperacion = false;
		try{			
			gppPerfilequivalenteDAO = new GppPerfilequivalenteDAO();
			gppPerfilequivalente = new GppPerfilequivalente();
			gppPerfilequivalente.setPeqNidperfileq(idPerfilEquivalente);
			gppPerfilequivalente.setPeqVperfileq(nombrePerfilEquivalente);
			gppPerfilequivalente.setPeqVusumodifica(usuarioAutenticado.getUsuVlogin());
			gppPerfilequivalente.setPeqDfecmodifica(new Date());
			estadoOperacion = gppPerfilequivalenteDAO.actualizar(gppPerfilequivalente);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public boolean borrarPerfilEquivalente(Integer idPerfilEquivalente) {
		estadoOperacion = false;
		try{			
			gppPerfilequivalenteDAO = new GppPerfilequivalenteDAO();
			estadoOperacion = gppPerfilequivalenteDAO.borrar(idPerfilEquivalente);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public GppPerfilequivalente buscarPerfilEquivalentePorId(Integer idPerfilEquivalente) {
		gppPerfilequivalente = null;
		try{			
			gppPerfilequivalenteDAO = new GppPerfilequivalenteDAO();
			gppPerfilequivalente = (GppPerfilequivalente) gppPerfilequivalenteDAO.buscarPorId(idPerfilEquivalente);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppPerfilequivalente;
	}

	public List<Object> buscarPerfilesEquivalentes() {
		gppPerfilesEquivalentes = null;
		try{			
			gppPerfilequivalenteDAO = new GppPerfilequivalenteDAO();
			gppPerfilesEquivalentes = gppPerfilequivalenteDAO.buscarTodos();
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppPerfilesEquivalentes;
	}

	public boolean crearPerfilEquivalente(String nombrePerfilEquivalente, GppUsuario usuarioAutenticado) {
		estadoOperacion = false;
		try{			
			gppPerfilequivalenteDAO = new GppPerfilequivalenteDAO();
			gppPerfilequivalente = new GppPerfilequivalente();
			gppPerfilequivalente.setPeqVperfileq(nombrePerfilEquivalente);
			gppPerfilequivalente.setPeqVusucrea(usuarioAutenticado.getUsuVlogin());
			gppPerfilequivalente.setPeqDfeccrea(new Date());
			estadoOperacion = gppPerfilequivalenteDAO.crear(gppPerfilequivalente);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}	
}