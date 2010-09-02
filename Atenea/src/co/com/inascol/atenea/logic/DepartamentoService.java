package co.com.inascol.atenea.logic;

import java.util.Date;
import java.util.List;

import co.com.inascol.atenea.dao.GppDepartamentoDAO;
import co.com.inascol.atenea.entity.GppDepartamento;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.interfaces.IDepartamentoService;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcción de Software
 * Esp. Sistemas de Información Geográfica
 * Ing. Catastral y Geodesta
 */
public class DepartamentoService implements IDepartamentoService {

	private Boolean estadoOperacion;
	private GppDepartamentoDAO gppDepartamentoDAO;
	private GppDepartamento gppDepartamento;
	private List<Object> gppDepartamentos;
	
	public boolean actualizarDepartamento(Integer idDepto, String nombreDepto, Integer idPais, GppUsuario usuarioAutenticado) {
		estadoOperacion = false;
		try{			
			gppDepartamentoDAO = new GppDepartamentoDAO();
			gppDepartamento = new GppDepartamento();
			gppDepartamento.setDptNiddepto(idDepto);
			gppDepartamento.setDptVdepto(nombreDepto);
			gppDepartamento.setPaiNidpais(idPais);
			gppDepartamento.setDptVusumodifica(usuarioAutenticado.getUsuVlogin());
			gppDepartamento.setDptDfecmodifica(new Date());
			estadoOperacion = gppDepartamentoDAO.actualizar(gppDepartamento);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public boolean borrarDepartamento(Integer idDepto) {
		estadoOperacion = false;
		try{			
			gppDepartamentoDAO = new GppDepartamentoDAO();
			estadoOperacion = gppDepartamentoDAO.borrar(idDepto);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public List<Object> buscarDepartamentos() {
		gppDepartamentos = null;
		try{			
			gppDepartamentoDAO = new GppDepartamentoDAO();
			gppDepartamentos = gppDepartamentoDAO.buscarTodos();
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppDepartamentos;
	}

	public GppDepartamento buscarPorIdDepartamento(Integer idDepto) {
		gppDepartamento = null;
		try{			
			gppDepartamentoDAO = new GppDepartamentoDAO();
			gppDepartamento = (GppDepartamento) gppDepartamentoDAO.buscarPorId(idDepto);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppDepartamento;
	}

	public boolean crearDepartamento(String nombreDepto, Integer idPais, GppUsuario usuarioAutenticado) {
		estadoOperacion = false;
		try{			
			gppDepartamentoDAO = new GppDepartamentoDAO();
			gppDepartamento = new GppDepartamento();
			gppDepartamento.setDptVdepto(nombreDepto);
			gppDepartamento.setPaiNidpais(idPais);
			gppDepartamento.setDptVusucrea(usuarioAutenticado.getUsuVlogin());
			gppDepartamento.setDptDfeccrea(new Date());
			estadoOperacion = gppDepartamentoDAO.crear(gppDepartamento);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}
}