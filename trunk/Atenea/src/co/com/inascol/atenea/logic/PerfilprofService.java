package co.com.inascol.atenea.logic;

import java.util.Date;
import java.util.List;

import co.com.inascol.atenea.dao.GppPerfilproDAO;
import co.com.inascol.atenea.entity.GppPerfilprof;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.interfaces.IPerfilprofService;
/**
 * @author Guillermo Toro
 *
 */
public class PerfilprofService implements IPerfilprofService{

	private Boolean estadoOperacion;
	private GppPerfilproDAO gppPerfilproDAO;
	private GppPerfilprof gppPerfilprof;
	private List<Object> gppPerfilesProfesionales;
	
	public boolean actualizarPerfilProfesional(Integer idPerfilProfesional,
												String perfilProfesional, Integer nivelIdioma1, Integer nivelIdioma2,
												String herramientasSoftware, String motoresBD,
												Integer idPerfilEquivalente, Integer idPersona, Integer idIdioma1,
												Integer idIdioma2, GppUsuario usuarioAutenticado) {
		estadoOperacion = false;
		try{
			gppPerfilproDAO = new GppPerfilproDAO();
			gppPerfilprof = new GppPerfilprof();
			gppPerfilprof.setPprNidperfilprof(idPerfilProfesional);
			gppPerfilprof.setPprVperfil(perfilProfesional);
			gppPerfilprof.setPprNnivelidi1(nivelIdioma1);
			gppPerfilprof.setPprNnivelidi2(nivelIdioma2);
			gppPerfilprof.setPprVherrasw(herramientasSoftware);
			gppPerfilprof.setPprVmotorbd(motoresBD);
			gppPerfilprof.setPeqNidperfileq(idPerfilEquivalente);
			gppPerfilprof.setPerNidpersona(idPersona);
			gppPerfilprof.setIdiNididioma1(idIdioma1);
			gppPerfilprof.setIdiNididioma2(idIdioma2);			
			gppPerfilprof.setPprVusumodifica(usuarioAutenticado.getUsuVlogin());
			gppPerfilprof.setPprDfecmodifica(new Date());
			estadoOperacion = gppPerfilproDAO.actualizar(gppPerfilprof);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;	
	}

	public boolean borrarPerfilProfesional(Integer idPerfilProfesional) {
		estadoOperacion = false;
		try{
			gppPerfilproDAO = new GppPerfilproDAO();
			estadoOperacion = gppPerfilproDAO.borrar(idPerfilProfesional);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;	
	}

	public List<Object> buscarPerfilesProfesionales() {
		gppPerfilesProfesionales = null;
		try{
			gppPerfilproDAO = new GppPerfilproDAO();
			gppPerfilesProfesionales = gppPerfilproDAO.buscarTodos();
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppPerfilesProfesionales;	
	}

	public GppPerfilprof buscarPerfilProfesionarlPorId(Integer idPerfilProfesional) {
		gppPerfilprof = null;
		try{
			gppPerfilproDAO = new GppPerfilproDAO();
			gppPerfilprof = (GppPerfilprof) gppPerfilproDAO.buscarPorId(idPerfilProfesional);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppPerfilprof;	
	}

	public boolean crearPerfilProfesional(String perfilProfesional,
											Integer nivelIdioma1, Integer nivelIdioma2,
											String herramientasSoftware, String motoresBD,
											Integer idPerfilEquivalente, Integer idPersona, Integer idIdioma1,
											Integer idIdioma2, GppUsuario usuarioAutenticado) {
		estadoOperacion = false;
		try{
			gppPerfilproDAO = new GppPerfilproDAO();
			gppPerfilprof = new GppPerfilprof();
			gppPerfilprof.setPprVperfil(perfilProfesional);
			gppPerfilprof.setPprNnivelidi1(nivelIdioma1);
			gppPerfilprof.setPprNnivelidi2(nivelIdioma2);
			gppPerfilprof.setPprVherrasw(herramientasSoftware);
			gppPerfilprof.setPprVmotorbd(motoresBD);
			gppPerfilprof.setPeqNidperfileq(idPerfilEquivalente);
			gppPerfilprof.setPerNidpersona(idPersona);
			gppPerfilprof.setIdiNididioma1(idIdioma1);
			gppPerfilprof.setIdiNididioma2(idIdioma2);			
			gppPerfilprof.setPprVusucrea(usuarioAutenticado.getUsuVlogin());
			gppPerfilprof.setPprDfeccrea(new Date());
			estadoOperacion = gppPerfilproDAO.crear(gppPerfilprof);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;	
	}

	public List<Object> buscarPerfilesProfesionalesPersona(Integer idPersona) {
		gppPerfilesProfesionales = null;
		try{
			gppPerfilproDAO = new GppPerfilproDAO();
			gppPerfilesProfesionales = (List<Object>) gppPerfilproDAO.buscarPerfilesPersona(idPersona);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppPerfilesProfesionales;
	}		
}