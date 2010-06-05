package co.com.inascol.atenea.logic.interfaces;

import java.util.List;

import co.com.inascol.atenea.entity.GppPais;

public interface IPaisService {

	public boolean crearPais(String idPais, String nombrePais);
	public boolean actualizarPais(String idPais, String nombrePais);
	public boolean borrarPais(String idPais);
	public GppPais buscarPorIdPais(String idPais);
	public List<Object> buscarPaises();
}