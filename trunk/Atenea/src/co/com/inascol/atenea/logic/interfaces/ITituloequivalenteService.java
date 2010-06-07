package co.com.inascol.atenea.logic.interfaces;

import java.util.List;

import co.com.inascol.atenea.entity.GppTituloequivalente;

public interface ITituloequivalenteService {

	public boolean crearTituloEquivalente(String nombreTituloEquivalente);
	public boolean actualizarTituloEquivalente(Integer idTituloEquivalente, String nombreTituloEquivalente);
	public boolean borrarTituloEquivalente(Integer idTituloEquivalente);
	public GppTituloequivalente buscarTituloEquivalentePorId(Integer idTituloEquivalente);
	public List<Object> buscarTitulosEquivalentes();
}