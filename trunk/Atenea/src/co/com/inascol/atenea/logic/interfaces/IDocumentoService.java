package co.com.inascol.atenea.logic.interfaces;

import java.util.Date;
import java.util.List;

import co.com.inascol.atenea.entity.GppDocumento;
import co.com.inascol.atenea.entity.GppUsuario;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcción de Software
 * Esp. Sistemas de Información Geográfica
 * Ing. Catastral y Geodesta
 */
public interface IDocumentoService {

	public boolean crearDocumento(String nombreDocumento, String nombreArchivo, String urlArchivo, Date fechaExpedicion, Integer idPersona,
									Integer idTipoArchivo, GppUsuario usuarioAutenticado);
	public boolean actualizarDocumento(Integer idDocumento, String nombreDocumento, String nombreArchivo, String urlArchivo, 
										Date fechaExpedicion, Integer idPersona, Integer idTipoArchivo, GppUsuario usuarioAutenticado);
	public boolean borrarDocumento(Integer idDocumento);
	public GppDocumento buscarDocumentoPorId(Integer idDocumento);
	public List<Object> buscarDocumentos();
	public List<Object> buscarDocumentosPorPersona(Integer idDocumento);
}