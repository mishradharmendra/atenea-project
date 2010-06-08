package co.com.inascol.atenea.logic;

import java.util.Date;
import java.util.List;

import co.com.inascol.atenea.dao.GppPaisDAO;
import co.com.inascol.atenea.entity.GppPais;
import co.com.inascol.atenea.logic.interfaces.IPaisService;

public class PaisService implements IPaisService {

	private Boolean estadoOperacion;
	private GppPaisDAO gppPaisDAO;
	private GppPais gppPais;
	private List<Object> gppPaiss;
	
	public boolean actualizarPais(String idPais, String nombrePais) {
		estadoOperacion = false;
		try{			
			gppPaisDAO = new GppPaisDAO();
			gppPais = new GppPais();
			gppPais.setPaiVidpais(idPais);
			gppPais.setPaiVpais(nombrePais);
			gppPais.setPaiVidpais(idPais);
			gppPais.setPaiVusumodifica("ANGIE");
			gppPais.setPaiDfecmodifica(new Date());
			estadoOperacion = gppPaisDAO.actualizar(gppPais);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public boolean borrarPais(String idPais) {
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

	public GppPais buscarPorIdPais(String idPais) {
		gppPais = null;
		try{			
			gppPaisDAO = new GppPaisDAO();
			gppPais = (GppPais) gppPaisDAO.buscarPorId(idPais);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppPais;
	}

	public boolean crearPais(String idPais, String nombrePais) {
		estadoOperacion = false;
		try{			
			gppPaisDAO = new GppPaisDAO();
			gppPais = new GppPais();
			gppPais.setPaiVidpais(idPais);
			gppPais.setPaiVpais(nombrePais);
			gppPais.setPaiVusucrea("MI MEMO");
			gppPais.setPaiDfeccrea(new Date());
			estadoOperacion = gppPaisDAO.crear(gppPais);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}
}