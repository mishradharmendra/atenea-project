package co.com.inascol.atenea.logic.interfaces;

import java.util.List;

import co.com.inascol.atenea.entity.GppEstadocivil;

public interface IEstadocivilService {

	public boolean crearEstadoCivil(String nombreEstadoCivil);
	public boolean actualizarEstadoCivil(Integer idEstadoCivil, String nombreEstadoCivil);
	public boolean borrarEstadoCivil(Integer idEstadoCivil);
	public GppEstadocivil buscarEstadoCivilPorId(Integer idEstadoCivil);
	public List<Object> buscarEstadosCiviles();
}