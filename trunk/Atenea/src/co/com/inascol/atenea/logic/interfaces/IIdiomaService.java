package co.com.inascol.atenea.logic.interfaces;

import java.util.List;

import co.com.inascol.atenea.entity.GppIdioma;

public interface IIdiomaService {

	public boolean crearIdioma( String nombreIdioma);
	public boolean actualizarIdioma(Integer idIdioma, String nombreIdioma);
	public boolean borrarIdioma(Integer idIdioma);
	public GppIdioma buscarPorIdIdioma(Integer idIdioma);
	public List<Object> buscarIdiomas();
}