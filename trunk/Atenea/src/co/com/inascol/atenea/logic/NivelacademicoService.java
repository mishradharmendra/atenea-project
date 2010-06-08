package co.com.inascol.atenea.logic;

import java.util.Date;
import java.util.List;

import co.com.inascol.atenea.dao.GppNivelacademicoDAO;
import co.com.inascol.atenea.entity.GppNivelacademico;
import co.com.inascol.atenea.logic.interfaces.INivelacademicoService;

public class NivelacademicoService implements INivelacademicoService {

	private Boolean estadoOperacion;
	private GppNivelacademicoDAO gppNivelacademicoDAO;
	private GppNivelacademico gppNivelacademico;
	private List<Object> gppNivelesacademicos;
	
	public boolean actualizarNivelAcademico(Integer idNivelAcademico, String nombreNivelAcademico) {
		estadoOperacion = false;
		try{			
			gppNivelacademicoDAO = new GppNivelacademicoDAO();
			gppNivelacademico = new GppNivelacademico();
			gppNivelacademico.setNacNidnivelac(idNivelAcademico);
			gppNivelacademico.setNacVnivelac(nombreNivelAcademico);
			gppNivelacademico.setNacVusumodifica("memo");
			gppNivelacademico.setNacDfecmodifica(new Date());
			estadoOperacion = gppNivelacademicoDAO.actualizar(gppNivelacademico);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public boolean borrarNivelAcademico(Integer idNivelAcademico) {
		estadoOperacion = false;
		try{			
			gppNivelacademicoDAO = new GppNivelacademicoDAO();
			estadoOperacion = gppNivelacademicoDAO.borrar(idNivelAcademico);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public List<Object> buscarNivelesAcademicos() {
		gppNivelesacademicos = null;
		try{			
			gppNivelacademicoDAO = new GppNivelacademicoDAO();
			gppNivelesacademicos = gppNivelacademicoDAO.buscarTodos();
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppNivelesacademicos;
	}

	public GppNivelacademico buscarPorIdNivelAcademico(Integer idNivelAcademico) {
		gppNivelacademico = null;
		try{			
			gppNivelacademicoDAO = new GppNivelacademicoDAO();
			gppNivelacademico = (GppNivelacademico) gppNivelacademicoDAO.buscarPorId(idNivelAcademico);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppNivelacademico;
	}

	public boolean crearNivelAcademico(String nombreNivelAcademico) {
		estadoOperacion = false;
		try{			
			gppNivelacademicoDAO = new GppNivelacademicoDAO();
			gppNivelacademico = new GppNivelacademico();
			gppNivelacademico.setNacVnivelac(nombreNivelAcademico);
			gppNivelacademico.setNacVusucrea("memo");
			gppNivelacademico.setNacDfeccrea(new Date());
			estadoOperacion = gppNivelacademicoDAO.crear(gppNivelacademico);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}
}