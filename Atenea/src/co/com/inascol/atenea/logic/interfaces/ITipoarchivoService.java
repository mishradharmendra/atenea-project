package co.com.inascol.atenea.logic.interfaces;

import java.util.List;

import co.com.inascol.atenea.entity.GppTipoarchivo;
import co.com.inascol.atenea.entity.GppUsuario;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcci�n de Software
 * Esp. Sistemas de Informaci�n Geogr�fica
 * Ing. Catastral y Geodesta
 */
public interface ITipoarchivoService {

	public boolean crearTipoarchivo(String nombreTipoarchivo, GppUsuario usuarioAutenticado);
	public boolean actualizarTipoarchivo(Integer idTipoarchivo, String nombreTipoarchivo, GppUsuario usuarioAutenticado);
	public boolean borrarTipoarchivo(Integer idTipoarchivo);
	public GppTipoarchivo buscarPorIdTipoarchivo(Integer idTipoarchivo);
	public List<Object> buscarTipoarchivos();
}