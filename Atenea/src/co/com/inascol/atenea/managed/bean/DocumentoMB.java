package co.com.inascol.atenea.managed.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.richfaces.event.UploadEvent;

import co.com.inascol.atenea.entity.GppDocumento;
import co.com.inascol.atenea.entity.GppPersona;
import co.com.inascol.atenea.entity.GppTipoarchivo;
import co.com.inascol.atenea.managed.bean.delegate.DocumentoDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;

public class DocumentoMB {
	
	private DocumentoDelegate documentoDelegate;
	private Integer idDocumentoSoporte;
	private List<Object> soportes;
	private GppDocumento documento;
	private Integer idPersona;
	private Boolean estadoOperacion;	
	private String urlDescargaArchivo;
	
	public DocumentoMB(){
		documentoDelegate = new DocumentoDelegate();	
		documento = new GppDocumento();
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB")!=null){
			idPersona = ( (PersonaMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).getPersona().getPerNidpersona();
			soportes = documentoDelegate.getSoportesPorIdPersona(idPersona);
		}
	}
	
	public Integer getIdDocumentoSoporte() {
		return idDocumentoSoporte;
	}
	public void setIdDocumentoSoporte(Integer idDocumentoSoporte) {
		this.idDocumentoSoporte = idDocumentoSoporte;
	}
	public List<Object> getSoportes() {
		return soportes;
	}
	public void setSoportes(List<Object> soportes) {
		this.soportes = soportes;
	}
	public GppDocumento getDocumento() {
		return documento;
	}
	public void setDocumento(GppDocumento documento) {
		this.documento = documento;
	}
	public Integer getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}
	public String getUrlDescargaArchivo() {
		return urlDescargaArchivo;
	}
	public void setUrlDescargaArchivo(String urlDescargaArchivo) {
		this.urlDescargaArchivo = urlDescargaArchivo;
	}

	public List<SelectItem> getTiposArchivos(){
		List<SelectItem> listadoTipos = new ArrayList<SelectItem>();
		List<Object> tipos = documentoDelegate.getListaTiposArchivos();
		if(tipos.size()>0){
			Iterator<Object> it = tipos.iterator();
			while(it.hasNext()){
				GppTipoarchivo gppTipoarchivo = (GppTipoarchivo) it.next();
				listadoTipos.add(new SelectItem(gppTipoarchivo.getTarNidtipoarchivo(), gppTipoarchivo.getTarVtipoarchivo()));
			}
        }
		return listadoTipos;
	}
	
	public String getAnterior(){
		( ( PersonaMB ) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).setTabPanel(ConstantesFaces.TAB_PANEL_PERFIL);
		return ConstantesFaces.CREAR_HV;
	}
	
	public String getGuardarSoporte(){
		setTabPanel();
		estadoOperacion = false;
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB")!=null){
			GppPersona persona = ( (PersonaMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).getPersona();
			documento.setPerNidpersona(persona.getPerNidpersona());
			estadoOperacion = documentoDelegate.getGuardarSoporte(documento , persona);
		}
		if(estadoOperacion==true){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("DocumentoMB");
			return ConstantesFaces.ESTADO_OK;
		} else {
			return ConstantesFaces.ESTADO_ERROR;
		}
	}
	
	public String getBorrarSoporte(){
		setTabPanel();
		estadoOperacion = false;
		estadoOperacion = documentoDelegate.getBorrarSoporte(idDocumentoSoporte);
		if(estadoOperacion==true){				
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("DocumentoMB");
			return ConstantesFaces.ESTADO_OK;
		} else {
			return ConstantesFaces.ESTADO_ERROR;
		}
	}
	
	public void getSubirSoporte(UploadEvent event) throws IOException {
		documentoDelegate.getSubirSoporte(event);
	}
	
	public void setTabPanel(){
		( ( PersonaMB ) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).setTabPanel(ConstantesFaces.TAB_PANEL_SOPORTES);
	}
}