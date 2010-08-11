package co.com.inascol.atenea.logic.interfaces;

import java.util.List;

import co.com.inascol.atenea.entity.GppRol;
import co.com.inascol.atenea.entity.GppUsuario;
/**
 * @author Guillermo Toro
 *
 */
public interface IRolService {

	public boolean crearRol(String nombreRol, String descripcionRol, Boolean activoRol, List <Object> listaServicios, GppUsuario usuarioAutenticado);
	public boolean actualizarRol(Integer idRol, String nombreRol, String descripcionRol, Boolean activoRol, List <Object> listaServicios, GppUsuario usuarioAutenticado);
	public boolean borrarRol(Integer idRol);
	public GppRol buscarPorIdRol(Integer idRol);
	public List<Object> buscarRoles();
}