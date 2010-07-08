package co.com.inascol.atenea.logic.interfaces;

import java.util.List;

import co.com.inascol.atenea.entity.GppDepartamento;
import co.com.inascol.atenea.entity.GppUsuario;

public interface IDepartamentoService {

	public boolean crearDepartamento(String nombreDepto, Integer idPais, GppUsuario usuarioAutenticado);
	public boolean actualizarDepartamento(Integer idDepto, String nombreDepto, Integer idPais, GppUsuario usuarioAutenticado);
	public boolean borrarDepartamento(Integer idDepto);
	public GppDepartamento buscarPorIdDepartamento(Integer idDepto);
	public List<Object> buscarDepartamentos();
}