package co.com.inascol.atenea.logic.interfaces;

import java.util.Date;
import java.util.List;

import co.com.inascol.atenea.entity.GppDocumento;

public interface IDocumentoService {

	public boolean crearDocumento(String nombreDocumento, String nombreArchivo, String urlArchivo, Date fechaExpedicion, Integer idPersona,
									Integer idTipoArchivo);
	public boolean actualizarDocumento(Integer idDocumento, String nombreDocumento, String nombreArchivo, String urlArchivo, 
										Date fechaExpedicion, Integer idPersona, Integer idTipoArchivo);
	public boolean borrarDocumento(Integer idDocumento);
	public GppDocumento buscarDocumentoPorId(Integer idDocumento);
	public List<Object> buscarDocumentos();
}