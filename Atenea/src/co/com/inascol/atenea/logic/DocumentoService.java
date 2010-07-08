package co.com.inascol.atenea.logic;

import java.util.Date;
import java.util.List;

import co.com.inascol.atenea.dao.GppDocumentoDAO;
import co.com.inascol.atenea.entity.GppDocumento;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.interfaces.IDocumentoService;

public class DocumentoService implements IDocumentoService{

	private Boolean estadoOperacion;
	private GppDocumentoDAO gppDocumentoDAO;
	private GppDocumento gppDocumento;
	private List<Object> gppDocumentos;
	
	public boolean actualizarDocumento(Integer idDocumento,
			String nombreDocumento, String nombreArchivo, String urlArchivo,
			Date fechaExpedicion, Integer idPersona, Integer idTipoArchivo, GppUsuario usuarioAutenticado) {
		estadoOperacion = false;
		try{			
			gppDocumentoDAO = new GppDocumentoDAO();
			gppDocumento = new GppDocumento();
			gppDocumento.setDocNiddocumento(idDocumento);
			gppDocumento.setDocVnombre(nombreDocumento);
			gppDocumento.setDocVarchivo(nombreArchivo);
			gppDocumento.setDocVurlarchivo(urlArchivo);
			gppDocumento.setDocDfecexpide(fechaExpedicion);
			gppDocumento.setPerNidpersona(idPersona);
			gppDocumento.setTarNidtipoarchivo(idTipoArchivo);
			gppDocumento.setDocVusumodifica(usuarioAutenticado.getUsuVlogin());
			gppDocumento.setDocDfecmodifica(new Date());	
			estadoOperacion = gppDocumentoDAO.actualizar(gppDocumento);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public boolean borrarDocumento(Integer idDocumento) {
		estadoOperacion = false;
		try{			
			gppDocumentoDAO = new GppDocumentoDAO();
			estadoOperacion = gppDocumentoDAO.borrar(idDocumento);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public GppDocumento buscarDocumentoPorId(Integer idDocumento) {
		gppDocumento = null;
		try{			
			gppDocumentoDAO = new GppDocumentoDAO();
			gppDocumento = (GppDocumento) gppDocumentoDAO.buscarPorId(idDocumento);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppDocumento;
	}

	public List<Object> buscarDocumentos() {
		gppDocumentos = null;
		try{			
			gppDocumentoDAO = new GppDocumentoDAO();
			gppDocumentos = gppDocumentoDAO.buscarTodos();
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppDocumentos;
	}

	public boolean crearDocumento(String nombreDocumento, String nombreArchivo,
			String urlArchivo, Date fechaExpedicion, Integer idPersona,
			Integer idTipoArchivo, GppUsuario usuarioAutenticado) {
		estadoOperacion = false;
		try{			
			gppDocumentoDAO = new GppDocumentoDAO();
			gppDocumento = new GppDocumento();
			gppDocumento.setDocVnombre(nombreDocumento);
			gppDocumento.setDocVarchivo(nombreArchivo);
			gppDocumento.setDocVurlarchivo(urlArchivo);
			gppDocumento.setDocDfecexpide(fechaExpedicion);
			gppDocumento.setPerNidpersona(idPersona);
			gppDocumento.setTarNidtipoarchivo(idTipoArchivo);
			gppDocumento.setDocVusucrea(usuarioAutenticado.getUsuVlogin());
			gppDocumento.setDocDfeccrea(new Date());	
			estadoOperacion = gppDocumentoDAO.crear(gppDocumento);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}
	
	public List<Object> buscarDocumentosPorPersona(Integer idPersona){
		try{			
			gppDocumentoDAO = new GppDocumentoDAO();
			gppDocumentos = gppDocumentoDAO.buscarDocumentosPorPersona(idPersona);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppDocumentos;
	}
}