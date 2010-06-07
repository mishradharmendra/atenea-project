package co.com.inascol.atenea.logic.interfaces;

import java.util.List;

import co.com.inascol.atenea.entity.GppPerfilequivalente;

public interface IPerfilequivalenteService {

	public boolean crearPerfilEquivalente(String nombrePerfilEquivalente);
	public boolean actualizarPerfilEquivalente(Integer idPerfilEquivalente, String nombrePerfilEquivalente);
	public boolean borrarPerfilEquivalente(Integer idPerfilEquivalente);
	public GppPerfilequivalente buscarPerfilEquivalentePorId(Integer idPerfilEquivalente);
	public List<Object> buscarPerfilesEquivalentes();
}