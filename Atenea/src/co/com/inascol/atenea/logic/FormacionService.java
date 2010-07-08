package co.com.inascol.atenea.logic;

import java.util.Date;
import java.util.List;

import co.com.inascol.atenea.dao.GppFormacionDAO;
import co.com.inascol.atenea.entity.GppFormacion;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.interfaces.IFormacionService;

public class FormacionService implements IFormacionService{

	private Boolean estadoOperacion;
	private GppFormacionDAO gppFormacionDAO;
	private GppFormacion gppFormacion;
	private List<Object> gppFormaciones;
	
	public boolean actualizarFormacion(Integer idFormacion, String titulo,
										Date fechaGrado, Integer duracionMeses, String tarjetaProfesional,
										Date fechaTarjetaProfecional, Integer idPersona,
										Integer idNivelAcademico, Integer idInstitucion,
										Integer idTituloEquivalente, Integer idDocumentoTarjeta,
										Integer idActaGrado, Integer idDocumentoDiploma, GppUsuario usuarioAutenticado) {
		estadoOperacion = false;
		try{			
			gppFormacionDAO = new GppFormacionDAO();
			gppFormacion = new GppFormacion();
			gppFormacion.setForNidformacion(idFormacion);
			gppFormacion.setForVtitulo(titulo);
			gppFormacion.setForDfecgrado(fechaGrado);
			gppFormacion.setForNduracionmes(duracionMeses);
			gppFormacion.setForVtarjetaprof(tarjetaProfesional);
			gppFormacion.setForDfectarjeta(fechaTarjetaProfecional);
			gppFormacion.setPerNidpersona(idPersona);
			gppFormacion.setNacNidnivelac(idNivelAcademico);
			gppFormacion.setInsNidinstitucion(idInstitucion);
			gppFormacion.setTeqNidtituloeq(idTituloEquivalente);
			gppFormacion.setDocNidiploma(idDocumentoDiploma);
			gppFormacion.setDocNactagrado(idActaGrado);
			gppFormacion.setDocNtarjetaprof(idDocumentoTarjeta);
			gppFormacion.setForVusumodifica(usuarioAutenticado.getUsuVlogin());
			gppFormacion.setForDfecmodifica(new Date());
			estadoOperacion = gppFormacionDAO.actualizar(gppFormacion);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public boolean borrarFormacion(Integer idFormacion) {
		estadoOperacion = false;
		try{			
			gppFormacionDAO = new GppFormacionDAO();
			estadoOperacion = gppFormacionDAO.borrar(idFormacion);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public List<Object> buscarFormaciones() {
		gppFormaciones = null;
		try{			
			gppFormacionDAO = new GppFormacionDAO();
			gppFormaciones = gppFormacionDAO.buscarTodos();
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppFormaciones;
	}

	public GppFormacion buscarFormacionPorId(Integer idFormacion) {
		gppFormacion = null;
		try{			
			gppFormacionDAO = new GppFormacionDAO();
			gppFormacion = (GppFormacion) gppFormacionDAO.buscarPorId(idFormacion);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppFormacion;
	}

	public boolean crearFormacion(String titulo, Date fechaGrado,
									Integer duracionMeses, String tarjetaProfesional,
									Date fechaTarjetaProfecional, Integer idPersona,
									Integer idNivelAcademico, Integer idInstitucion,
									Integer idTituloEquivalente, Integer idDocumentoTarjeta,
									Integer idActaGrado, Integer idDocumentoDiploma, GppUsuario usuarioAutenticado) {
		estadoOperacion = false;
		try{			
			gppFormacionDAO = new GppFormacionDAO();
			gppFormacion = new GppFormacion();
			gppFormacion.setForVtitulo(titulo);
			gppFormacion.setForDfecgrado(fechaGrado);
			gppFormacion.setForNduracionmes(duracionMeses);
			gppFormacion.setForVtarjetaprof(tarjetaProfesional);
			gppFormacion.setForDfectarjeta(fechaTarjetaProfecional);
			gppFormacion.setPerNidpersona(idPersona);
			gppFormacion.setNacNidnivelac(idNivelAcademico);
			gppFormacion.setInsNidinstitucion(idInstitucion);
			gppFormacion.setTeqNidtituloeq(idTituloEquivalente);
			gppFormacion.setDocNidiploma(idDocumentoDiploma);
			gppFormacion.setDocNactagrado(idActaGrado);
			gppFormacion.setDocNtarjetaprof(idDocumentoTarjeta);
			gppFormacion.setForVusucrea(usuarioAutenticado.getUsuVlogin());
			gppFormacion.setForDfeccrea(new Date());
			estadoOperacion = gppFormacionDAO.crear(gppFormacion);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public List<Object> buscarFormacionPersona(Integer idPersona) {
		gppFormaciones = null;
		try{			
			gppFormacionDAO = new GppFormacionDAO();
			gppFormaciones = gppFormacionDAO.buscarFormacionesPersona(idPersona);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppFormaciones;
	}
}