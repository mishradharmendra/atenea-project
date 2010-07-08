package co.com.inascol.atenea.logic.interfaces;

import java.util.List;

import co.com.inascol.atenea.entity.GppPerfilequivalente;
import co.com.inascol.atenea.entity.GppUsuario;

public interface IPerfilequivalenteService {

	public boolean crearPerfilEquivalente(String nombrePerfilEquivalente, GppUsuario usuarioAutenticado);
	public boolean actualizarPerfilEquivalente(Integer idPerfilEquivalente, String nombrePerfilEquivalente, GppUsuario usuarioAutenticado);
	public boolean borrarPerfilEquivalente(Integer idPerfilEquivalente);
	public GppPerfilequivalente buscarPerfilEquivalentePorId(Integer idPerfilEquivalente);
	public List<Object> buscarPerfilesEquivalentes();
}