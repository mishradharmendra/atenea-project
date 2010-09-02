package co.com.inascol.atenea.logic.interfaces;

import java.util.List;

import co.com.inascol.atenea.entity.GppPerfilequivalente;
import co.com.inascol.atenea.entity.GppUsuario;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcci�n de Software
 * Esp. Sistemas de Informaci�n Geogr�fica
 * Ing. Catastral y Geodesta
 */
public interface IPerfilequivalenteService {

	public boolean crearPerfilEquivalente(String nombrePerfilEquivalente, GppUsuario usuarioAutenticado);
	public boolean actualizarPerfilEquivalente(Integer idPerfilEquivalente, String nombrePerfilEquivalente, GppUsuario usuarioAutenticado);
	public boolean borrarPerfilEquivalente(Integer idPerfilEquivalente);
	public GppPerfilequivalente buscarPerfilEquivalentePorId(Integer idPerfilEquivalente);
	public List<Object> buscarPerfilesEquivalentes();
}