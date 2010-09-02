package co.com.inascol.atenea.logic.interfaces;

import java.util.List;

import co.com.inascol.atenea.entity.GppIdioma;
import co.com.inascol.atenea.entity.GppUsuario;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcci�n de Software
 * Esp. Sistemas de Informaci�n Geogr�fica
 * Ing. Catastral y Geodesta
 */
public interface IIdiomaService {

	public boolean crearIdioma(String nombreIdioma, GppUsuario usuarioAutenticado);
	public boolean actualizarIdioma(Integer idIdioma, String nombreIdioma, GppUsuario usuarioAutenticado);
	public boolean borrarIdioma(Integer idIdioma);
	public GppIdioma buscarPorIdIdioma(Integer idIdioma);
	public List<Object> buscarIdiomas();
}