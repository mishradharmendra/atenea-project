package co.com.inascol.atenea.dao.utils;

import java.util.List;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcci�n de Software
 * Esp. Sistemas de Informaci�n Geogr�fica
 * Ing. Catastral y Geodesta
 */
public interface DAO {

	public boolean crear(Object obj);
	public boolean actualizar(Object obj);
	public boolean borrar(Object idObj);
	public Object buscarPorId(Object idObj);
	public List<Object> buscarTodos();
}