package co.com.inascol.atenea.logic.interfaces;

import java.util.List;

import co.com.inascol.atenea.entity.GppUsuario;

public interface IUsuarioService {

	public boolean crearUsuario(String nombreUsuario, String loginUsuario, String emailUsuario, String telefonoUsuario, String activoUsuario, GppUsuario usuarioAutenticado);
	public boolean actualizarUsuario(Integer idUsuario, String nombreUsuario, String loginUsuario, String emailUsuario, String telefonoUsuario, String activoUsuario, GppUsuario usuarioAutenticado);
	public boolean borrarUsuario(Integer idUsuario);
	public GppUsuario buscarPorIdUsuario(Integer idUsuario);
	public List<Object> buscarUsuarios();
	public GppUsuario buscarPorLogin (String idObj);
}