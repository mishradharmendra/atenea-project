package co.com.inascol.atenea.logic.interfaces;

import java.util.List;

import co.com.inascol.atenea.entity.GppDepartamento;

public interface IDepartamentoService {

	public boolean crearDepartamento(String idDepto, String nombreDepto, String idPais);
	public boolean actualizarDepartamento(String idDepto, String nombreDepto, String idPais);
	public boolean borrarDepartamento(String idDepto);
	public GppDepartamento buscarPorIdDepartamento(String idDepto);
	public List<Object> buscarDepartamentos();
}