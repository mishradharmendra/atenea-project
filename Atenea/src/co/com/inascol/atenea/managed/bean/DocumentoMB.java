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
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcción de Software
 * Esp. Sistemas de Información Geográfica
 * Ing. Catastral y Geodesta
 */
public class DocumentoMB {
	
	private DocumentoDelegate documentoDelegate;
	private Integer idDocumentoSoporte;
	private List<Object> soportes;
	private List<Object> hojasDeVida;
	private GppDocumento documento;
	private Integer idPersona;
	private Boolean estadoOperacion;	
	private String urlDescargaArchivo;
	private Boolean documentoCargado;
	
	public DocumentoMB(){
		documentoDelegate = new DocumentoDelegate();	
		documento = new GppDocumento();
		documentoCargado = false;
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB")!=null){
			idPersona = ( (PersonaMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).getPersona().getPerNidpersona();
			soportes = documentoDelegate.getSoportesPorIdPersona(idPersona);
			hojasDeVida = documentoDelegate.getHojasDeVidaPersona(idPersona);
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
	public List<Object> getHojasDeVida() {
		return hojasDeVida;
	}
	public void setHojasDeVida(List<Object> hojasDeVida) {
		this.hojasDeVida = hojasDeVida;
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
	
	public String getAnteriorDetalle(){
		( ( PersonaMB ) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).setTabPanel(ConstantesFaces.TAB_PANEL_PERFIL);
		return ConstantesFaces.DETALLE_HV;
	}
	
	public String getGuardarSoporte(){
		getHomePageValueHV();
		setTabPanel();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvAgregarHojadeVida")){
			if(documentoCargado == true){
				documentoCargado = false;
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
			}else{
				System.out.println("Documento No Cargado.");
				return ConstantesFaces.ESTADO_ERROR;
			}
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}
	}
	
	public String getBorrarSoporte(){
		getHomePageValueHV();
		setTabPanel();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvModificarHojadeVida")){
			estadoOperacion = documentoDelegate.getBorrarSoporte(idDocumentoSoporte);
			if(estadoOperacion==true){				
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("DocumentoMB");
				return ConstantesFaces.ESTADO_OK;
			} else {
				return ConstantesFaces.ESTADO_ERROR;
			}
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}			
	}
	
	public void getSubirSoporte(UploadEvent event) throws IOException {
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") != null){
			GppPersona persona = ( (PersonaMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).getPersona();
			documentoCargado = true;
			documentoDelegate.getSubirSoporte(persona, event);
		}
	}
	
	public void setTabPanel(){
		( ( PersonaMB ) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PersonaMB") ).setTabPanel(ConstantesFaces.TAB_PANEL_SOPORTES);
	}
	
	public void getHomePageValueHV(){
		((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).setHomePage(ConstantesFaces.CREAR_HV);
	}
	
	public Boolean getValidarPermisosServicio(String nombreServicio){
		return ((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).validarPermisosServicio(nombreServicio);
	}
}