package co.com.inascol.atenea.logic.interfaces;

import java.util.List;

import co.com.inascol.atenea.entity.GppTipoarchivo;

public interface ITipoarchivoService {

	public boolean crearTipoarchivo(String nombreTipoarchivo);
	public boolean actualizarTipoarchivo(Integer idTipoarchivo, String nombreTipoarchivo);
	public boolean borrarTipoarchivo(Integer idTipoarchivo);
	public GppTipoarchivo buscarPorIdTipoarchivo(Integer idTipoarchivo);
	public List<Object> buscarTipoarchivos();
}