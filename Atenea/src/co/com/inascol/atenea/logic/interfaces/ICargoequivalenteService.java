package co.com.inascol.atenea.logic.interfaces;

import java.util.List;

import co.com.inascol.atenea.entity.GppCargoequivalente;
import co.com.inascol.atenea.entity.GppUsuario;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcci�n de Software
 * Esp. Sistemas de Informaci�n Geogr�fica
 * Ing. Catastral y Geodesta
 */
public interface ICargoequivalenteService {

	public boolean crearCargoEquivalente(String nombreCargoEquivalente, GppUsuario usuarioAutenticado);
	public boolean actualizarCargoEquivalente(Integer idCargoEquivalente, String nombreCargoEquivalente, GppUsuario usuarioAutenticado);
	public boolean borrarCargoEquivalente(Integer idCargoEquivalente);
	public GppCargoequivalente buscarCargoEquivalentePorId(Integer idCargoEquivalente);
	public List<Object> buscarCargosEquivalentes();
}