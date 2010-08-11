package co.com.inascol.atenea.managed.bean;

import java.util.List;

import javax.faces.context.FacesContext;

import co.com.inascol.atenea.entity.GppPersona;
import co.com.inascol.atenea.managed.bean.delegate.ReporteDelegate;
import co.com.inascol.atenea.util.ConstantesFaces;
/**
 * @author Guillermo Toro
 *
 */
public class ReporteMB {

	private ReporteDelegate reporteDelegate;
	private GppPersona persona;
	private Integer idPersona;
	private String nombrePersona;
	private String identificacionPersona;
	private Boolean estadoPersona;
	private String tipoReporte;
	private Boolean estadoOperacion;
	private List<Object> personas;
	
	public ReporteMB(){
		reporteDelegate = new ReporteDelegate();
	}

	public GppPersona getPersona() {
		return persona;
	}
	public void setPersona(GppPersona persona) {
		this.persona = persona;
	}
	public ReporteDelegate getReporteDelegate() {
		return reporteDelegate;
	}
	public void setReporteDelegate(ReporteDelegate reporteDelegate) {
		this.reporteDelegate = reporteDelegate;
	}	
	
	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public String getIdentificacionPersona() {
		return identificacionPersona;
	}

	public void setIdentificacionPersona(String identificacionPersona) {
		this.identificacionPersona = identificacionPersona;
	}

	public Boolean getEstadoPersona() {
		return estadoPersona;
	}

	public void setEstadoPersona(Boolean estadoPersona) {
		this.estadoPersona = estadoPersona;
	}

	public String getTipoReporte() {
		return tipoReporte;
	}

	public void setTipoReporte(String tipoReporte) {
		this.tipoReporte = tipoReporte;
	}

	public List<Object> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Object> personas) {
		this.personas = personas;
	}

	public String getHomeReporte(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("ReporteMB");
		return ConstantesFaces.REPORTE_HOME;
	}
	
	public String getBusquedaBasicaPersona(){
		personas = reporteDelegate.getBusquedaBasicaPersona(nombrePersona, identificacionPersona);
		return ConstantesFaces.REPORTE_HOME;
	}
	
	public String getSeleccionarPersonaReporte(){
		persona = reporteDelegate.getSeleccionarPersona(personas, idPersona);
		return ConstantesFaces.REPORTE_DETALLE;		
	}
	
	public String getCrearReporte(){
		getHomePageValue();
		estadoOperacion = false;
		if(getValidarPermisosServicio("srvCrearReporte")){	
			estadoOperacion  = reporteDelegate.getCrearReporte(tipoReporte, persona);
			if(estadoOperacion==true){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("ReporteMB");
				return ConstantesFaces.ESTADO_OK;
			}else{
				return ConstantesFaces.ESTADO_ERROR;
			}
		}else{
			return ConstantesFaces.ESTADO_PERMISOS_ERROR;
		}			
	}
	
	public void getHomePageValue(){
		((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).setHomePage(ConstantesFaces.REPORTE_HOME);
	}
	
	public Boolean getValidarPermisosServicio(String nombreServicio){
		return ((AutenticacionMB) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("AutenticacionMB")).validarPermisosServicio(nombreServicio);
	}
}