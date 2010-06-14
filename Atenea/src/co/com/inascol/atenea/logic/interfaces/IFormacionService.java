package co.com.inascol.atenea.logic.interfaces;

import java.util.Date;
import java.util.List;

import co.com.inascol.atenea.entity.GppFormacion;

public interface IFormacionService {

	public boolean crearFormacion(String titulo, Date fechaGrado, Integer duracionMeses, String tarjetaProfesional,
									Date fechaTarjetaProfecional, Integer idPersona, Integer idNivelAcademico, Integer idInstitucion, 
									Integer idTituloEquivalente, Integer idDocumentoTarjeta, Integer idActaGrado, Integer idDocumentoDiploma);
	public boolean actualizarFormacion(Integer idFormacion, String titulo, Date fechaGrado, Integer duracionMeses, String tarjetaProfesional,
										Date fechaTarjetaProfecional, Integer idPersona, Integer idNivelAcademico, Integer idInstitucion, 
										Integer idTituloEquivalente, Integer idDocumentoTarjeta, Integer idActaGrado, Integer idDocumentoDiploma);
	public boolean borrarFormacion(Integer idFormacion);
	public GppFormacion buscarFormacionPorId(Integer idFormacion);
	public List<Object> buscarFormaciones();
	public List<Object> buscarFormacionPersona(Integer idPersona);
}