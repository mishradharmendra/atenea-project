package co.com.inascol.atenea.logic;

import java.util.Date;
import java.util.List;

import co.com.inascol.atenea.dao.GppTipodocDAO;
import co.com.inascol.atenea.entity.GppTipodoc;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.interfaces.ITipodocService;
/**
 * @author Guillermo Toro
 *
 */
public class TipodocService implements ITipodocService{

	private Boolean estadoOperacion;
	private GppTipodocDAO gppTipodocDAO;
	private GppTipodoc gppTipodoc;
	private List<Object> gppTipoDocumentos;
	
	public boolean actualizarTipoDocumento(Integer idTipoDocumento,	String nombreTipoDocumento, GppUsuario usuarioAutenticado) {
		estadoOperacion = false;
		try{			
			gppTipodocDAO = new GppTipodocDAO();
			gppTipodoc = new GppTipodoc();
			gppTipodoc.setTdcNidtipodoc(idTipoDocumento);
			gppTipodoc.setTdcVnombre(nombreTipoDocumento);
			gppTipodoc.setTdcVusumodifica(usuarioAutenticado.getUsuVlogin());
			gppTipodoc.setTdcDfecmodifica(new Date());
			estadoOperacion = gppTipodocDAO.actualizar(gppTipodoc);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public boolean borrarTipoDocumento(Integer idTipoDocumento) {
		estadoOperacion = false;
		try{			
			gppTipodocDAO = new GppTipodocDAO();
			estadoOperacion = gppTipodocDAO.borrar(idTipoDocumento);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public GppTipodoc buscarTipoDocumentoPorId(Integer idTipoDocumento) {
		gppTipodoc = null;
		try{			
			gppTipodocDAO = new GppTipodocDAO();
			gppTipodoc = (GppTipodoc) gppTipodocDAO.buscarPorId(idTipoDocumento);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppTipodoc;
	}

	public List<Object> buscarTiposDocumentos() {
		gppTipoDocumentos = null;
		try{			
			gppTipodocDAO = new GppTipodocDAO();
			gppTipoDocumentos = gppTipodocDAO.buscarTodos();
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppTipoDocumentos;
	}

	public boolean crearTipoDocumento(String nombreTipoDocumento, GppUsuario usuarioAutenticado) {
		estadoOperacion = false;
		try{			
			gppTipodocDAO = new GppTipodocDAO();
			gppTipodoc = new GppTipodoc();
			gppTipodoc.setTdcVnombre(nombreTipoDocumento);
			gppTipodoc.setTdcVusucrea(usuarioAutenticado.getUsuVlogin());
			gppTipodoc.setTdcDfeccrea(new Date());
			estadoOperacion = gppTipodocDAO.crear(gppTipodoc);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}
}