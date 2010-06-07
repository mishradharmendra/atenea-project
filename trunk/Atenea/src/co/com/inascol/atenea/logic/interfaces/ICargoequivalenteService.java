package co.com.inascol.atenea.logic.interfaces;

import java.util.List;

import co.com.inascol.atenea.entity.GppCargoequivalente;

public interface ICargoequivalenteService {

	public boolean crearCargoEquivalente(String nombreCargoEquivalente);
	public boolean actualizarCargoEquivalente(Integer idCargoEquivalente, String nombreCargoEquivalente);
	public boolean borrarCargoEquivalente(Integer idCargoEquivalente);
	public GppCargoequivalente buscarCargoEquivalentePorId(Integer idCargoEquivalente);
	public List<Object> buscarCargosEquivalentes();
}
