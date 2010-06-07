package co.com.inascol.atenea.logic.interfaces;

import java.util.List;

import co.com.inascol.atenea.entity.GppTipodoc;

public interface ITipodocService {

	public boolean crearTipoDocumento(String nombreTipoDocumento);
	public boolean actualizarTipoDocumento(Integer idTipoDocumento, String nombreTipoDocumento);
	public boolean borrarTipoDocumento(Integer idTipoDocumento);
	public GppTipodoc buscarTipoDocumentoPorId(Integer idTipoDocumento);
	public List<Object> buscarTiposDocumentos();
}