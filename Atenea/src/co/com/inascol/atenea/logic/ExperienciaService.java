package co.com.inascol.atenea.logic;

import java.util.Date;
import java.util.List;

import co.com.inascol.atenea.dao.GppExperienciaDAO;
import co.com.inascol.atenea.entity.GppExperiencia;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.interfaces.IExperienciaService;
/**
 * @author Guillermo Toro
 *
 */
public class ExperienciaService implements IExperienciaService{

	private Boolean estadoOperacion;
	private GppExperienciaDAO gppExperienciaDAO;
	private GppExperiencia gppExperiencia;
	private List<Object> gppExperienciasLaborales;
	
	public boolean actualizarExperiencia(Integer idExperiencia,
			String nombreEmpresa, String telefonoEmpresa,
			String nombreContacto, String emailContacto, String nombreCargo,
			Date fechaIngreso, Date fechaRetiro, String herramientasSoftware,
			String funcionesLogros, Integer docCertificacion1,
			Integer docCertificacion2, Integer idMunicipio,
			Integer cargoEquivalente, Integer idPersona, GppUsuario usuarioAutenticado) {
		estadoOperacion = false;
		try{
			gppExperienciaDAO = new GppExperienciaDAO();
			gppExperiencia = new GppExperiencia();
			gppExperiencia.setExpNidexplaboral(idExperiencia);
			gppExperiencia.setExpVnomempresa(nombreEmpresa);
			gppExperiencia.setExpVtelempresa(telefonoEmpresa);
			gppExperiencia.setExpVnomcontacto(nombreContacto);
			gppExperiencia.setExpVemailcontacto(emailContacto);
			gppExperiencia.setExpVcargo(nombreCargo);
			gppExperiencia.setExpDfecingreso(fechaIngreso);
			gppExperiencia.setExpDfecretiro(fechaRetiro);
			gppExperiencia.setExpVherrasw(herramientasSoftware);
			gppExperiencia.setExpVfuncionlogro(funcionesLogros);
			gppExperiencia.setDocNcertifica1(docCertificacion1);
			gppExperiencia.setDocNcertifica2(docCertificacion2);
			gppExperiencia.setMunVidmunicipio(idMunicipio);
			gppExperiencia.setCeqNidcargoeq(cargoEquivalente);
			gppExperiencia.setPerNidpersona(idPersona);
			gppExperiencia.setExpVusumodifica(usuarioAutenticado.getUsuVlogin());
			gppExperiencia.setExpDfecmodifica(new Date());
			estadoOperacion = gppExperienciaDAO.actualizar(gppExperiencia);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public boolean borrarExperiencia(Integer idExperiencia) {
		estadoOperacion = false;
		try{
			gppExperienciaDAO = new GppExperienciaDAO();
			estadoOperacion = gppExperienciaDAO.borrar(idExperiencia);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public GppExperiencia buscarExperienciaPorId(Integer idExperiencia) {
		gppExperiencia = null;
		try{
			gppExperienciaDAO = new GppExperienciaDAO();
			gppExperiencia = (GppExperiencia) gppExperienciaDAO.buscarPorId(idExperiencia);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppExperiencia;
	}

	public List<Object> buscarExperienciasLaborales() {
		gppExperienciasLaborales = null;
		try{
			gppExperienciaDAO = new GppExperienciaDAO();
			gppExperienciasLaborales = gppExperienciaDAO.buscarTodos();
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppExperienciasLaborales;
	}

	public boolean crearExperiencia(String nombreEmpresa,
			String telefonoEmpresa, String nombreContacto,
			String emailContacto, String nombreCargo, Date fechaIngreso,
			Date fechaRetiro, String herramientasSoftware,
			String funcionesLogros, Integer docCertificacion1,
			Integer docCertificacion2, Integer idMunicipio,
			Integer cargoEquivalente, Integer idPersona, GppUsuario usuarioAutenticado) {
		estadoOperacion = false;
		try{
			gppExperienciaDAO = new GppExperienciaDAO();
			gppExperiencia = new GppExperiencia();
			gppExperiencia.setExpVnomempresa(nombreEmpresa);
			gppExperiencia.setExpVtelempresa(telefonoEmpresa);
			gppExperiencia.setExpVnomcontacto(nombreContacto);
			gppExperiencia.setExpVemailcontacto(emailContacto);
			gppExperiencia.setExpVcargo(nombreCargo);
			gppExperiencia.setExpDfecingreso(fechaIngreso);
			gppExperiencia.setExpDfecretiro(fechaRetiro);
			gppExperiencia.setExpVherrasw(herramientasSoftware);
			gppExperiencia.setExpVfuncionlogro(funcionesLogros);
			gppExperiencia.setDocNcertifica1(docCertificacion1);
			gppExperiencia.setDocNcertifica2(docCertificacion2);
			gppExperiencia.setMunVidmunicipio(idMunicipio);
			gppExperiencia.setCeqNidcargoeq(cargoEquivalente);
			gppExperiencia.setPerNidpersona(idPersona);
			gppExperiencia.setExpVusucrea(usuarioAutenticado.getUsuVlogin());
			gppExperiencia.setExpDfeccrea(new Date());
			estadoOperacion = gppExperienciaDAO.crear(gppExperiencia);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}
	
	public List<Object> buscarExperienciasPersona(Integer idPersona){
		gppExperienciasLaborales = null;
		try{
			gppExperienciaDAO =  new GppExperienciaDAO();
			gppExperienciasLaborales = gppExperienciaDAO.buscarExperienciasPersona(idPersona);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return gppExperienciasLaborales;
	}
}