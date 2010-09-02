package co.com.inascol.atenea.logic.interfaces;

import java.util.List;

import co.com.inascol.atenea.entity.GppEstadocivil;
import co.com.inascol.atenea.entity.GppUsuario;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcción de Software
 * Esp. Sistemas de Información Geográfica
 * Ing. Catastral y Geodesta
 */
public interface IEstadocivilService {

	public boolean crearEstadoCivil(String nombreEstadoCivil, GppUsuario usuarioAutenticado);
	public boolean actualizarEstadoCivil(Integer idEstadoCivil, String nombreEstadoCivil, GppUsuario usuarioAutenticado);
	public boolean borrarEstadoCivil(Integer idEstadoCivil);
	public GppEstadocivil buscarEstadoCivilPorId(Integer idEstadoCivil);
	public List<Object> buscarEstadosCiviles();
}