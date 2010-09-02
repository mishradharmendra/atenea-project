package co.com.inascol.atenea.logic.interfaces;

import java.util.List;

import co.com.inascol.atenea.entity.GppInstitucion;
import co.com.inascol.atenea.entity.GppUsuario;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcción de Software
 * Esp. Sistemas de Información Geográfica
 * Ing. Catastral y Geodesta
 */
public interface IInstitucionService {

	public boolean crearInstitucion(String nombreInstitucion, GppUsuario usuarioAutenticado);
	public boolean actualizarInstitucion(Integer idInstitucion, String nombreInstitucion, GppUsuario usuarioAutenticado);
	public boolean borrarInstitucion(Integer idInstitucion);
	public GppInstitucion buscarPorIdInstitucion(Integer idInstitucion);
	public List<Object> buscarInstituciones();
}