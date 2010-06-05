package co.com.inascol.atenea.logic.interfaces;

import java.util.List;

import co.com.inascol.atenea.entity.GppRol;

public interface IRolService {

	public boolean crearRol(String nombreRol, String descripcionRol, String activoRol);
	public boolean actualizarRol(Integer idRol, String nombreRol, String descripcionRol, String activoRol);
	public boolean borrarRol(Integer idRol);
	public GppRol buscarPorIdRol(Integer idRol);
	public List<Object> buscarRoles();
}