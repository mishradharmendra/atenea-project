package co.com.inascol.atenea.logic;

import java.util.Date;
import java.util.List;

import co.com.inascol.atenea.dao.GppEstadocivilDAO;
import co.com.inascol.atenea.entity.GppEstadocivil;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.interfaces.IEstadocivilService;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public class EstadocivilService implements IEstadocivilService{

	private Boolean estadoOperacion;
	private GppEstadocivilDAO gppEstadocivilDAO;
	private GppEstadocivil gppEstadocivil;
	private List<Object> gppEstadosCiviles;
	
	public boolean actualizarEstadoCivil(Integer idEstadoCivil, String nombreEstadoCivil, GppUsuario usuarioAutenticado) {
		estadoOperacion = false;
		try{			
			gppEstadocivilDAO = new GppEstadocivilDAO();
			gppEstadocivil = new GppEstadocivil();
			gppEstadocivil.setEscNidestadocivil(idEstadoCivil);
			gppEstadocivil.setEscVestadocivil(nombreEstadoCivil);
			gppEstadocivil.setEscVusumodifica(usuarioAutenticado.getUsuVlogin());
			gppEstadocivil.setEscDfecmodifica(new Date());
			estadoOperacion = gppEstadocivilDAO.actualizar(gppEstadocivil);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public boolean borrarEstadoCivil(Integer idEstadoCivil) {
		estadoOperacion = false;
		try{			
			gppEstadocivilDAO = new GppEstadocivilDAO();
			estadoOperacion = gppEstadocivilDAO.borrar(idEstadoCivil);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public GppEstadocivil buscarEstadoCivilPorId(Integer idEstadoCivil) {
		gppEstadocivil = null;
		try{			
			gppEstadocivilDAO = new GppEstadocivilDAO();
			gppEstadocivil = (GppEstadocivil) gppEstadocivilDAO.buscarPorId(idEstadoCivil);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppEstadocivil;
	}

	public List<Object> buscarEstadosCiviles() {
		gppEstadosCiviles = null;
		try{			
			gppEstadocivilDAO = new GppEstadocivilDAO();
			gppEstadosCiviles = gppEstadocivilDAO.buscarTodos();
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppEstadosCiviles;
	}

	public boolean crearEstadoCivil(String nombreEstadoCivil, GppUsuario usuarioAutenticado) {
		estadoOperacion = false;
		try{			
			gppEstadocivilDAO = new GppEstadocivilDAO();
			gppEstadocivil = new GppEstadocivil();
			gppEstadocivil.setEscVestadocivil(nombreEstadoCivil);
			gppEstadocivil.setEscVusucrea(usuarioAutenticado.getUsuVlogin());
			gppEstadocivil.setEscDfeccrea(new Date());
			estadoOperacion = gppEstadocivilDAO.crear(gppEstadocivil);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}
}