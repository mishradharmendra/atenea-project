package co.com.inascol.atenea.logic;

import java.util.Date;
import java.util.List;

import co.com.inascol.atenea.dao.GppTituloequivalenteDAO;
import co.com.inascol.atenea.entity.GppTituloequivalente;
import co.com.inascol.atenea.logic.interfaces.ITituloequivalenteService;

public class TituloequivalenteService implements ITituloequivalenteService{

	private Boolean estadoOperacion;
	private GppTituloequivalenteDAO gppTituloequivalenteDAO;
	private GppTituloequivalente gppTituloequivalente;
	private List<Object> gppTitulosequivalentes;
	
	public boolean actualizarTituloEquivalente(Integer idTituloEquivalente,	String nombreTituloEquivalente) {
		estadoOperacion = false;
		try{
			gppTituloequivalenteDAO = new GppTituloequivalenteDAO();
			gppTituloequivalente = new GppTituloequivalente();
			gppTituloequivalente.setTeqNidtituloeq(idTituloEquivalente);
			gppTituloequivalente.setTeqVtituloeq(nombreTituloEquivalente);
			gppTituloequivalente.setTeqVusumodifica("MEMO");
			gppTituloequivalente.setTeqDfecmodifica(new Date());
			estadoOperacion = gppTituloequivalenteDAO.actualizar(gppTituloequivalente);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public boolean borrarTituloEquivalente(Integer idTituloEquivalente) {
		estadoOperacion = false;
		try{
			gppTituloequivalenteDAO = new GppTituloequivalenteDAO();
			estadoOperacion = gppTituloequivalenteDAO.borrar(idTituloEquivalente);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public GppTituloequivalente buscarTituloEquivalentePorId(Integer idTituloEquivalente) {
		gppTituloequivalente = null;
		try{
			gppTituloequivalenteDAO = new GppTituloequivalenteDAO();
			gppTituloequivalente = (GppTituloequivalente) gppTituloequivalenteDAO.buscarPorId(idTituloEquivalente);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppTituloequivalente;	
	}

	public List<Object> buscarTitulosEquivalentes() {
		gppTitulosequivalentes = null;
		try{
			gppTituloequivalenteDAO = new GppTituloequivalenteDAO();
			gppTitulosequivalentes = gppTituloequivalenteDAO.buscarTodos();
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppTitulosequivalentes;
	}	
	
	public boolean crearTituloEquivalente(String nombreTituloEquivalente) {
		estadoOperacion = false;
		try{
			gppTituloequivalenteDAO = new GppTituloequivalenteDAO();
			gppTituloequivalente = new GppTituloequivalente();
			gppTituloequivalente.setTeqVtituloeq(nombreTituloEquivalente);
			gppTituloequivalente.setTeqVusumodifica("MEMO");
			gppTituloequivalente.setTeqDfecmodifica(new Date());
			estadoOperacion = gppTituloequivalenteDAO.crear(gppTituloequivalente);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;	
	}
}