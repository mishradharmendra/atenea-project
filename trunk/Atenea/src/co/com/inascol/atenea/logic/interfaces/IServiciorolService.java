package co.com.inascol.atenea.logic.interfaces;

import java.util.List;

import co.com.inascol.atenea.entity.GppServiciorol;

public interface IServiciorolService {

	public boolean crearServiciorol(Integer idServicio, Integer idRol);
	public boolean actualizarServiciorol(Integer idServicio, Integer idRoll);
	public boolean borrarServiciorol(Integer idServicio, Integer idRol);
	public GppServiciorol buscarPorIdServiciorol(Integer idServicio, Integer idRol);
	public List<Object> buscarServicioroles();
}