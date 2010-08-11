package co.com.inascol.atenea.logic.interfaces;

import java.util.List;

import co.com.inascol.atenea.entity.GppServiciorol;
import co.com.inascol.atenea.entity.GppUsuario;
/**
 * @author Guillermo Toro
 *
 */
public interface IServiciorolService {

	public boolean crearServiciorol(Integer idServicio, Integer idRol, GppUsuario usuarioAutenticado);
	public boolean actualizarServiciorol(Integer idServicio, Integer idRoll, GppUsuario usuarioAutenticado);
	public boolean borrarServiciorol(Integer idServicio, Integer idRol);
	public GppServiciorol buscarPorIdServiciorol(Integer idServicio, Integer idRol);
	public List<Object> buscarServicioroles();
}