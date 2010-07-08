package co.com.inascol.atenea.logic.interfaces;

import java.util.List;

import co.com.inascol.atenea.entity.GppCargoequivalente;
import co.com.inascol.atenea.entity.GppUsuario;

public interface ICargoequivalenteService {

	public boolean crearCargoEquivalente(String nombreCargoEquivalente, GppUsuario usuarioAutenticado);
	public boolean actualizarCargoEquivalente(Integer idCargoEquivalente, String nombreCargoEquivalente, GppUsuario usuarioAutenticado);
	public boolean borrarCargoEquivalente(Integer idCargoEquivalente);
	public GppCargoequivalente buscarCargoEquivalentePorId(Integer idCargoEquivalente);
	public List<Object> buscarCargosEquivalentes();
}
