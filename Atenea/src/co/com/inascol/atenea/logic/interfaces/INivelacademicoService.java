package co.com.inascol.atenea.logic.interfaces;

import java.util.List;

import co.com.inascol.atenea.entity.GppNivelacademico;
import co.com.inascol.atenea.entity.GppUsuario;
/**
 * @author Guillermo Toro
 *
 */
public interface INivelacademicoService {

	public boolean crearNivelAcademico(String nombreNivelAcademico, GppUsuario usuarioAutenticado);
	public boolean actualizarNivelAcademico(Integer idNivelAcademico, String nombreNivelAcademico, GppUsuario usuarioAutenticado);
	public boolean borrarNivelAcademico(Integer idNivelAcademico);
	public GppNivelacademico buscarPorIdNivelAcademico(Integer idNivelAcademico);
	public List<Object> buscarNivelesAcademicos();
}