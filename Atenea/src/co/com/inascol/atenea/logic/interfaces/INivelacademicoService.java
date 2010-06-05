package co.com.inascol.atenea.logic.interfaces;

import java.util.List;

import co.com.inascol.atenea.entity.GppNivelacademico;

public interface INivelacademicoService {

	public boolean crearNivelAcademico(String nombreNivelAcademico);
	public boolean actualizarNivelAcademico(Integer idNivelAcademico, String nombreNivelAcademico);
	public boolean borrarNivelAcademico(Integer idNivelAcademico);
	public GppNivelacademico buscarPorIdNivelAcademico(Integer idNivelAcademico);
	public List<Object> buscarNivelesAcademicos();
}