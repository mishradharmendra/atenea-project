package co.com.inascol.atenea.logic.interfaces;

import java.util.List;

import co.com.inascol.atenea.entity.GppMunicipio;

public interface IMunicipioService {

	public boolean crearMunicipio(String idMunicipio, String nombreMunicipio, String idDepto);
	public boolean actualizarMunicipio(String idMunicipio, String nombreMunicipio, String idDepto);
	public boolean borrarMunicipio(String idMunicipio);
	public GppMunicipio buscarPorIdMunicipio(String idMunicipio);
	public List<Object> buscarMunicipios();
}