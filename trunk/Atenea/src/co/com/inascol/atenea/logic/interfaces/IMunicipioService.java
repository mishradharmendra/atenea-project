package co.com.inascol.atenea.logic.interfaces;

import java.util.List;

import co.com.inascol.atenea.entity.GppMunicipio;
import co.com.inascol.atenea.entity.GppUsuario;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcción de Software
 * Esp. Sistemas de Información Geográfica
 * Ing. Catastral y Geodesta
 */
public interface IMunicipioService {

	public boolean crearMunicipio(String nombreMunicipio, Integer idDepto, GppUsuario usuarioAutenticado);
	public boolean actualizarMunicipio(Integer idMunicipio, String nombreMunicipio, Integer idDepto, GppUsuario usuarioAutenticado);
	public boolean borrarMunicipio(Integer idMunicipio);
	public GppMunicipio buscarPorIdMunicipio(Integer idMunicipio);
	public List<Object> buscarMunicipios();
}