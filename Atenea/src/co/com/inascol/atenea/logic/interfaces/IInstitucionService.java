package co.com.inascol.atenea.logic.interfaces;

import java.util.List;

import co.com.inascol.atenea.entity.GppInstitucion;

public interface IInstitucionService {

	public boolean crearInstitucion(String nombreInstitucion);
	public boolean actualizarInstitucion(Integer idInstitucion, String nombreInstitucion);
	public boolean borrarInstitucion(Integer idInstitucion);
	public GppInstitucion buscarPorIdInstitucion(Integer idInstitucion);
	public List<Object> buscarInstituciones();
}