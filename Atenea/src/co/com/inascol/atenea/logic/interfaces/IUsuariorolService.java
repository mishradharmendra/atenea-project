package co.com.inascol.atenea.logic.interfaces;

import java.util.List;

import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.entity.GppUsuariorol;

public interface IUsuariorolService {

	public boolean crearUsuariorol(Integer idUsuario, Integer idRol, GppUsuario usuarioAutenticado);
	public boolean actualizarUsuariorol(Integer idUsuario, Integer idRol, GppUsuario usuarioAutenticado);
	public boolean borrarUsuariorol(Integer idUsuario, Integer idRol);
	public GppUsuariorol buscarPorIdUsuariorol(Integer idUsuario, Integer idRol);	
	public List<Object> buscarUsuarioroles();
}