package co.com.inascol.atenea.logic.interfaces;

import java.util.List;

import co.com.inascol.atenea.entity.GppNivelacademico;
import co.com.inascol.atenea.entity.GppUsuario;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public interface INivelacademicoService {

	public boolean crearNivelAcademico(String nombreNivelAcademico, GppUsuario usuarioAutenticado);
	public boolean actualizarNivelAcademico(Integer idNivelAcademico, String nombreNivelAcademico, GppUsuario usuarioAutenticado);
	public boolean borrarNivelAcademico(Integer idNivelAcademico);
	public GppNivelacademico buscarPorIdNivelAcademico(Integer idNivelAcademico);
	public List<Object> buscarNivelesAcademicos();
}