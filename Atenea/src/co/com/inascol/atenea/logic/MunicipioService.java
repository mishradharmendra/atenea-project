package co.com.inascol.atenea.logic;

import java.util.Date;
import java.util.List;

import co.com.inascol.atenea.dao.GppMunicipioDAO;
import co.com.inascol.atenea.entity.GppMunicipio;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.interfaces.IMunicipioService;

public class MunicipioService implements IMunicipioService{

	private Boolean estadoOperacion;
	private GppMunicipioDAO gppMunicipioDAO;
	private GppMunicipio gppMunicipio;
	private List<Object> gppMunicipios;
	
	public boolean actualizarMunicipio(Integer idMunicipio, String nombreMunicipio, Integer idDepto, GppUsuario usuarioAutenticado) {
		estadoOperacion = false;
		try{			
			gppMunicipioDAO = new GppMunicipioDAO();
			gppMunicipio = new GppMunicipio();
			gppMunicipio.setMunNidmunicipio(idMunicipio);
			gppMunicipio.setMunVmunicipio(nombreMunicipio);
			gppMunicipio.setDptNiddepto(idDepto);
			gppMunicipio.setMunVusumodifica(usuarioAutenticado.getUsuVlogin());
			gppMunicipio.setMunDfecmodifica(new Date());
			estadoOperacion = gppMunicipioDAO.actualizar(gppMunicipio);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public boolean borrarMunicipio(Integer idMunicipio) {
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

	public GppMunicipio buscarPorIdMunicipio(Integer idMunicipio) {
		gppMunicipio = null;
		try{			
			gppMunicipioDAO = new GppMunicipioDAO();
			gppMunicipio = (GppMunicipio) gppMunicipioDAO.buscarPorId(idMunicipio);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppMunicipio;
	}

	public boolean crearMunicipio(String nombreMunicipio, Integer idDepto, GppUsuario usuarioAutenticado) {
		estadoOperacion = false;
		try{			
			gppMunicipioDAO = new GppMunicipioDAO();
			gppMunicipio = new GppMunicipio();
			gppMunicipio.setMunVmunicipio(nombreMunicipio);
			gppMunicipio.setDptNiddepto(idDepto);
			gppMunicipio.setMunVusucrea(usuarioAutenticado.getUsuVlogin());
			gppMunicipio.setMunDfeccrea(new Date());
			estadoOperacion = gppMunicipioDAO.crear(gppMunicipio);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}
}