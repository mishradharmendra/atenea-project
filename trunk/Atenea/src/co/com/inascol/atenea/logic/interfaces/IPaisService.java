package co.com.inascol.atenea.logic.interfaces;

import java.util.List;

import co.com.inascol.atenea.entity.GppPais;
import co.com.inascol.atenea.entity.GppUsuario;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcci�n de Software
 * Esp. Sistemas de Informaci�n Geogr�fica
 * Ing. Catastral y Geodesta
 */
public interface IPaisService {

	public boolean crearPais(String nombrePais, GppUsuario usuarioAutenticado);
	public boolean actualizarPais(Integer idPais, String nombrePais, GppUsuario usuarioAutenticado);
	public boolean borrarPais(Integer idPais);
	public GppPais buscarPorIdPais(Integer idPais);
	public List<Object> buscarPaises();
}