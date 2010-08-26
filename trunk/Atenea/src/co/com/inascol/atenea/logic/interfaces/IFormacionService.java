package co.com.inascol.atenea.logic.interfaces;

import java.util.Date;
import java.util.List;

import co.com.inascol.atenea.entity.GppFormacion;
import co.com.inascol.atenea.entity.GppUsuario;
/**
 * @author Guillermo Toro
 *
 */
public interface IFormacionService {

	public boolean crearFormacion(String titulo, Date fechaGrado, Integer duracion, String unidadDuracion, String tarjetaProfesional,
									Date fechaTarjetaProfecional, Integer idPersona, Integer idNivelAcademico, Integer idInstitucion, 
									Integer idTituloEquivalente, Integer idDocumentoTarjeta, Integer idActaGrado, Integer idDocumentoDiploma, GppUsuario usuarioAutenticado);
	public boolean actualizarFormacion(Integer idFormacion, String titulo, Date fechaGrado, Integer duracion, String unidadDuracion, String tarjetaProfesional,
										Date fechaTarjetaProfecional, Integer idPersona, Integer idNivelAcademico, Integer idInstitucion, 
										Integer idTituloEquivalente, Integer idDocumentoTarjeta, Integer idActaGrado, Integer idDocumentoDiploma, GppUsuario usuarioAutenticado);
	public boolean borrarFormacion(Integer idFormacion);
	public GppFormacion buscarFormacionPorId(Integer idFormacion);
	public List<Object> buscarFormaciones();
	public List<Object> buscarFormacionPersona(Integer idPersona);
}