package co.com.inascol.atenea.logic.interfaces;

import java.util.List;

import co.com.inascol.atenea.entity.GppParametrizacion;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcci�n de Software
 * Esp. Sistemas de Informaci�n Geogr�fica
 * Ing. Catastral y Geodesta
 */
public interface IParametrizacionService {

	public boolean crearParametrizacion( String nombreParam, String valorParam, String descripcionParam);
	public boolean actualizarParametrizacion(Integer idParam, String nombreParam, String valorParam, String descripcionParam);
	public boolean borrarParametrizacion(Integer idParam);
	public GppParametrizacion buscarPorIdParametrizacion(Integer idParam);
	public List<Object> buscarParametrizacion();
}