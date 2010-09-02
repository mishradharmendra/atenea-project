package co.com.inascol.atenea.logic.interfaces;

import java.util.List;

import co.com.inascol.atenea.entity.GppServicio;
import co.com.inascol.atenea.entity.GppUsuario;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcción de Software
 * Esp. Sistemas de Información Geográfica
 * Ing. Catastral y Geodesta
 */
public interface IServicioService {

	public boolean crearServicio( String nombreServicio, String rutaServicio, GppUsuario usuarioAutenticado);
	public boolean actualizarServicio(Integer idServicio, String nombreServicio, String rutaServicio);
	public boolean borrarServicio(Integer idServicio);
	public GppServicio buscarPorIdServicio(Integer idServicio);
	public List<Object> buscarServicios();
}