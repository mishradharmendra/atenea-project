package co.com.inascol.atenea.logic;

import java.util.Date;
import java.util.List;

import co.com.inascol.atenea.dao.GppUsuarioDAO;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.interfaces.IUsuarioService;
/**
 * @author Guillermo Toro
 *
 */
public class UsuarioService implements IUsuarioService {

	private Boolean estadoOperacion;
	private GppUsuarioDAO gppUsuarioDAO;
	private GppUsuario gppUsuario;
	private List<Object> gppUsuarios;

	public boolean actualizarUsuario(Integer idUsuario, String nombreUsuario, String loginUsuario, String emailUsuario, String telefonoUsuario, Boolean activoUsuario, GppUsuario usuarioAutenticado) {
		estadoOperacion = false;
		try{			
			gppUsuarioDAO = new GppUsuarioDAO();
			gppUsuario = new GppUsuario();
			gppUsuario.setUsuNidusuario(idUsuario);
			gppUsuario.setUsuVnombre(nombreUsuario);
			gppUsuario.setUsuVlogin(loginUsuario);
			gppUsuario.setUsuVemail(emailUsuario);
			gppUsuario.setUsuVtelefono(telefonoUsuario);
			gppUsuario.setUsuVusumodifica(usuarioAutenticado.getUsuVlogin());
			gppUsuario.setUsuDfecmodifica(new Date());
			gppUsuario.setUsuBactivo(activoUsuario);
			estadoOperacion = gppUsuarioDAO.actualizar(gppUsuario);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public boolean borrarUsuario(Integer idUsuario) {
		estadoOperacion = false;
		try{			
			gppUsuarioDAO = new GppUsuarioDAO();
			estadoOperacion = gppUsuarioDAO.borrar(idUsuario);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public List<Object> buscarUsuarios() {
		gppUsuarios = null;
		try{			
			gppUsuarioDAO = new GppUsuarioDAO();
			gppUsuarios = gppUsuarioDAO.buscarTodos();
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppUsuarios;
	}

	public GppUsuario buscarPorIdUsuario(Integer idUsuario) {
		gppUsuario = null;
		try{			
			gppUsuarioDAO = new GppUsuarioDAO();
			gppUsuario = (GppUsuario) gppUsuarioDAO.buscarPorId(idUsuario);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppUsuario;
	}

	public GppUsuario buscarPorLogin(String loginUsuario) {
		gppUsuario = null;
		try{			
			gppUsuarioDAO = new GppUsuarioDAO();
			gppUsuario = (GppUsuario) gppUsuarioDAO.buscarPorLogin(loginUsuario);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppUsuario;
	}
	
	public boolean crearUsuario(String nombreUsuario, String loginUsuario, String emailUsuario, String telefonoUsuario, Boolean activoUsuario, GppUsuario usuarioAutenticado) {
		estadoOperacion = false;
		try{			
			gppUsuarioDAO = new GppUsuarioDAO();
			gppUsuario = new GppUsuario();
			gppUsuario.setUsuVnombre(nombreUsuario);
			gppUsuario.setUsuVlogin(loginUsuario);
			gppUsuario.setUsuVemail(emailUsuario);
			gppUsuario.setUsuVtelefono(telefonoUsuario);
			gppUsuario.setUsuVusucrea(usuarioAutenticado.getUsuVlogin());
			gppUsuario.setUsuDfeccrea(new Date());
			gppUsuario.setUsuBactivo(activoUsuario);			
			estadoOperacion = gppUsuarioDAO.crear(gppUsuario);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}
}