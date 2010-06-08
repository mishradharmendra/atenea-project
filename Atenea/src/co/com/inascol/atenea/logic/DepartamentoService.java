package co.com.inascol.atenea.logic;

import java.util.Date;
import java.util.List;

import co.com.inascol.atenea.dao.GppDepartamentoDAO;
import co.com.inascol.atenea.entity.GppDepartamento;
import co.com.inascol.atenea.logic.interfaces.IDepartamentoService;

public class DepartamentoService implements IDepartamentoService {

	private Boolean estadoOperacion;
	private GppDepartamentoDAO gppDepartamentoDAO;
	private GppDepartamento gppDepartamento;
	private List<Object> gppDepartamentos;
	
	public boolean actualizarDepartamento(String idDepto, String nombreDepto, String idPais) {
		estadoOperacion = false;
		try{			
			gppDepartamentoDAO = new GppDepartamentoDAO();
			gppDepartamento = new GppDepartamento();
			gppDepartamento.setDptViddepto(idDepto);
			gppDepartamento.setDptVdepto(nombreDepto);
			gppDepartamento.setPaiVidpais(idPais);
			gppDepartamento.setDptVusumodifica("memo");
			gppDepartamento.setDptDfecmodifica(new Date());
			estadoOperacion = gppDepartamentoDAO.actualizar(gppDepartamento);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public boolean borrarDepartamento(String idDepto) {
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

	public GppDepartamento buscarPorIdDepartamento(String idDepto) {
		gppDepartamento = null;
		try{			
			gppDepartamentoDAO = new GppDepartamentoDAO();
			gppDepartamento = (GppDepartamento) gppDepartamentoDAO.buscarPorId(idDepto);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppDepartamento;
	}

	public boolean crearDepartamento(String idDepto, String nombreDepto, String idPais) {
		estadoOperacion = false;
		try{			
			gppDepartamentoDAO = new GppDepartamentoDAO();
			gppDepartamento = new GppDepartamento();
			gppDepartamento.setDptViddepto(idDepto);
			gppDepartamento.setDptVdepto(nombreDepto);
			gppDepartamento.setPaiVidpais(idPais);
			gppDepartamento.setDptVusucrea("memo");
			gppDepartamento.setDptDfeccrea(new Date());
			estadoOperacion = gppDepartamentoDAO.crear(gppDepartamento);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}
}