package co.com.inascol.atenea.logic.interfaces;

import java.util.List;

import co.com.inascol.atenea.entity.GppTipodoc;
import co.com.inascol.atenea.entity.GppUsuario;
/**
 * @author Guillermo Toro
 *
 */
public interface ITipodocService {

	public boolean crearTipoDocumento(String nombreTipoDocumento, GppUsuario usuarioAutenticado);
	public boolean actualizarTipoDocumento(Integer idTipoDocumento, String nombreTipoDocumento, GppUsuario usuarioAutenticado);
	public boolean borrarTipoDocumento(Integer idTipoDocumento);
	public GppTipodoc buscarTipoDocumentoPorId(Integer idTipoDocumento);
	public List<Object> buscarTiposDocumentos();
}