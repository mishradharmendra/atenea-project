package co.com.inascol.atenea.logic;

import java.util.Date;
import java.util.List;

import co.com.inascol.atenea.dao.GppUsuariorolDAO;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.entity.GppUsuariorolId;
import co.com.inascol.atenea.entity.GppUsuariorol;
import co.com.inascol.atenea.logic.interfaces.IUsuariorolService;
/**
 * @author Guillermo Toro
 *
 */
public class UsuariorolService implements IUsuariorolService {

	private Boolean estadoOperacion;
	private GppUsuariorolDAO gppUsuariorolDAO;
	private GppUsuariorolId gppUsuariorolId;	
	private List<Object> gppUsuarioroles;
	private GppUsuariorol gppUsuariorol;

	public boolean actualizarUsuariorol(Integer idUsuario, Integer idRol, GppUsuario usuarioAutenticado) {
		estadoOperacion = false;
		try{			
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public boolean borrarUsuariorol(Integer idUsuario, Integer idRol) {
		estadoOperacion = false;
		try{
			gppUsuariorolId = new GppUsuariorolId();			
			gppUsuariorolId.setUsuNidusuario(idUsuario);
			gppUsuariorolId.setRolNidrol(idRol);		
			
			gppUsuariorol = new GppUsuariorol();
			gppUsuariorol.setId(gppUsuariorolId);
			
			gppUsuariorolDAO = new GppUsuariorolDAO();
			estadoOperacion = gppUsuariorolDAO.borrar(gppUsuariorol);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public List<Object> buscarUsuarioroles() {
		gppUsuarioroles = null;
		try{			
			gppUsuariorolDAO = new GppUsuariorolDAO();
			gppUsuarioroles = gppUsuariorolDAO.buscarTodos();
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppUsuarioroles;
	}

	public GppUsuariorol buscarPorIdUsuariorol(Integer idUsuario, Integer idRol) {
		gppUsuariorol = null;
		try{
			gppUsuariorolId = new GppUsuariorolId();			
			gppUsuariorolId.setUsuNidusuario(idUsuario);
			gppUsuariorolId.setRolNidrol(idRol);
			
			gppUsuariorol = new GppUsuariorol();
			gppUsuariorol.setId(gppUsuariorolId);
			
			gppUsuariorolDAO = new GppUsuariorolDAO();
			gppUsuariorol = (GppUsuariorol) gppUsuariorolDAO.buscarPorId(gppUsuariorol);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppUsuariorol;
	}

	public boolean crearUsuariorol(Integer idUsuario, Integer idRol, GppUsuario usuarioAutenticado) {
		estadoOperacion = false;
		try{			
			gppUsuariorolId = new GppUsuariorolId();
			gppUsuariorolId.setUsuNidusuario(idUsuario);
			gppUsuariorolId.setRolNidrol(idRol);
			
			gppUsuariorol = new GppUsuariorol();			
			gppUsuariorol.setId(gppUsuariorolId);
			gppUsuariorol.setUrlVusucrea(usuarioAutenticado.getUsuVlogin());
			gppUsuariorol.setUrlDfeccrea(new Date());
			
			gppUsuariorolDAO = new GppUsuariorolDAO();
			estadoOperacion = gppUsuariorolDAO.crear(gppUsuariorol);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}
}