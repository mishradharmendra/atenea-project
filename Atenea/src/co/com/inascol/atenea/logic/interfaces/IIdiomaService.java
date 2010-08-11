package co.com.inascol.atenea.logic.interfaces;

import java.util.List;

import co.com.inascol.atenea.entity.GppIdioma;
import co.com.inascol.atenea.entity.GppUsuario;
/**
 * @author Guillermo Toro
 *
 */
public interface IIdiomaService {

	public boolean crearIdioma(String nombreIdioma, GppUsuario usuarioAutenticado);
	public boolean actualizarIdioma(Integer idIdioma, String nombreIdioma, GppUsuario usuarioAutenticado);
	public boolean borrarIdioma(Integer idIdioma);
	public GppIdioma buscarPorIdIdioma(Integer idIdioma);
	public List<Object> buscarIdiomas();
}