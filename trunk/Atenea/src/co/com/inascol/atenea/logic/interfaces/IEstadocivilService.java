package co.com.inascol.atenea.logic.interfaces;

import java.util.List;

import co.com.inascol.atenea.entity.GppEstadocivil;
import co.com.inascol.atenea.entity.GppUsuario;
/**
 * @author Guillermo Toro
 *
 */
public interface IEstadocivilService {

	public boolean crearEstadoCivil(String nombreEstadoCivil, GppUsuario usuarioAutenticado);
	public boolean actualizarEstadoCivil(Integer idEstadoCivil, String nombreEstadoCivil, GppUsuario usuarioAutenticado);
	public boolean borrarEstadoCivil(Integer idEstadoCivil);
	public GppEstadocivil buscarEstadoCivilPorId(Integer idEstadoCivil);
	public List<Object> buscarEstadosCiviles();
}