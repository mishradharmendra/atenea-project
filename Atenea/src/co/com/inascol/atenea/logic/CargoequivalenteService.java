package co.com.inascol.atenea.logic;

import java.util.Date;
import java.util.List;

import co.com.inascol.atenea.dao.GppCargoequivalenteDAO;
import co.com.inascol.atenea.entity.GppCargoequivalente;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.interfaces.ICargoequivalenteService;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcción de Software
 * Esp. Sistemas de Información Geográfica
 * Ing. Catastral y Geodesta
 */
public class CargoequivalenteService implements ICargoequivalenteService {
	
	private Boolean estadoOperacion;
	private GppCargoequivalenteDAO gppCargoequivalenteDAO;
	private GppCargoequivalente gppCargoequivalente;
	private List<Object> gppCargosequivalentes;
	
	public boolean actualizarCargoEquivalente(Integer idCargoEquivalente, String nombreCargoEquivalente, GppUsuario usuarioAutenticado) {
		estadoOperacion = false;
		try{
			gppCargoequivalenteDAO = new GppCargoequivalenteDAO();
			gppCargoequivalente = new GppCargoequivalente();
			gppCargoequivalente.setCeqNidcargoeq(idCargoEquivalente);
			gppCargoequivalente.setCeqVcargoeq(nombreCargoEquivalente);
			gppCargoequivalente.setCeqVusumodifica(usuarioAutenticado.getUsuVlogin());
			gppCargoequivalente.setCeqDfecmodifica(new Date());
			estadoOperacion = gppCargoequivalenteDAO.actualizar(gppCargoequivalente);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;	
	}

	public boolean borrarCargoEquivalente(Integer idCargoEquivalente) {
		estadoOperacion = false;
		try{
			gppCargoequivalenteDAO = new GppCargoequivalenteDAO();
			estadoOperacion = gppCargoequivalenteDAO.borrar(idCargoEquivalente);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;	
	}

	public GppCargoequivalente buscarCargoEquivalentePorId(Integer idCargoEquivalente) {
		gppCargoequivalente = null;
		try{
			gppCargoequivalenteDAO = new GppCargoequivalenteDAO();
			gppCargoequivalente = (GppCargoequivalente) gppCargoequivalenteDAO.buscarPorId(idCargoEquivalente);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppCargoequivalente;	
	}

	public List<Object> buscarCargosEquivalentes() {
		gppCargosequivalentes = null;
		try{
			gppCargoequivalenteDAO = new GppCargoequivalenteDAO();
			gppCargosequivalentes = gppCargoequivalenteDAO.buscarTodos();
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppCargosequivalentes;	
	}

	public boolean crearCargoEquivalente(String nombreCargoEquivalente, GppUsuario usuarioAutenticado) {
		estadoOperacion = false;
		try{
			gppCargoequivalenteDAO = new GppCargoequivalenteDAO();
			gppCargoequivalente = new GppCargoequivalente();
			gppCargoequivalente.setCeqVcargoeq(nombreCargoEquivalente);
			gppCargoequivalente.setCeqVusucrea(usuarioAutenticado.getUsuVlogin());
			gppCargoequivalente.setCeqDfeccrea(new Date());
			estadoOperacion = gppCargoequivalenteDAO.crear(gppCargoequivalente);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;	
	}
}