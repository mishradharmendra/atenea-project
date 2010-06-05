package co.com.inascol.atenea.logic;

import java.util.Date;
import java.util.List;

import co.com.inascol.atenea.dao.GppMunicipioDAO;
import co.com.inascol.atenea.entity.GppMunicipio;
import co.com.inascol.atenea.logic.interfaces.IMunicipioService;

public class MunicipioService implements IMunicipioService{

	private Boolean estadoOperacion;
	private GppMunicipioDAO gppMunicipioDAO;
	private GppMunicipio gppMunicipio;
	private List<Object> gppMunicipios;
	
	public MunicipioService(){}
	
	public boolean actualizarMunicipio(String idMunicipio, String nombreMunicipio, String idDepto) {
		estadoOperacion = false;
		try{			
			gppMunicipioDAO = new GppMunicipioDAO();
			gppMunicipio = new GppMunicipio();
			gppMunicipio.setMunVidmunicipio(idMunicipio);
			gppMunicipio.setMunVmunicipio(nombreMunicipio);
			gppMunicipio.setDptViddepto(idDepto);
			gppMunicipio.setMunVusumodifica("memo");
			gppMunicipio.setMunDfecmodifica(new Date());
			estadoOperacion = gppMunicipioDAO.actualizar(gppMunicipio);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public boolean borrarMunicipio(String idMunicipio) {
		estadoOperacion = false;
		try{			
			gppMunicipioDAO = new GppMunicipioDAO();
			estadoOperacion = gppMunicipioDAO.borrar(idMunicipio);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public List<Object> buscarMunicipios() {
		gppMunicipios = null;
		try{			
			gppMunicipioDAO = new GppMunicipioDAO();
			gppMunicipios = gppMunicipioDAO.buscarTodos();
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppMunicipios;
	}

	public GppMunicipio buscarPorIdMunicipio(String idMunicipio) {
		gppMunicipio = null;
		try{			
			gppMunicipioDAO = new GppMunicipioDAO();
			gppMunicipio = (GppMunicipio) gppMunicipioDAO.buscarPorId(idMunicipio);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppMunicipio;
	}

	public boolean crearMunicipio(String idMunicipio, String nombreMunicipio, String idDepto) {
		estadoOperacion = false;
		try{			
			gppMunicipioDAO = new GppMunicipioDAO();
			gppMunicipio = new GppMunicipio();
			gppMunicipio.setMunVidmunicipio(idMunicipio);
			gppMunicipio.setMunVmunicipio(nombreMunicipio);
			gppMunicipio.setDptViddepto(idDepto);
			gppMunicipio.setMunVusucrea("memo");
			gppMunicipio.setMunDfeccrea(new Date());
			estadoOperacion = gppMunicipioDAO.crear(gppMunicipio);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}
}