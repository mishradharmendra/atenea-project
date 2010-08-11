package co.com.inascol.atenea.logic.interfaces;

import java.util.List;

import co.com.inascol.atenea.entity.GppTituloequivalente;
import co.com.inascol.atenea.entity.GppUsuario;
/**
 * @author Guillermo Toro
 *
 */
public interface ITituloequivalenteService {

	public boolean crearTituloEquivalente(String nombreTituloEquivalente, GppUsuario usuarioAutenticado);
	public boolean actualizarTituloEquivalente(Integer idTituloEquivalente, String nombreTituloEquivalente, GppUsuario usuarioAutenticado);
	public boolean borrarTituloEquivalente(Integer idTituloEquivalente);
	public GppTituloequivalente buscarTituloEquivalentePorId(Integer idTituloEquivalente);
	public List<Object> buscarTitulosEquivalentes();
}