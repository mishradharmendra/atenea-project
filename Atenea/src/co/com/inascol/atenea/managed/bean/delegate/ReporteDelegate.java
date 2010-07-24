package co.com.inascol.atenea.managed.bean.delegate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import co.com.inascol.atenea.entity.GppPersona;
import co.com.inascol.atenea.logic.PersonaService;
import co.com.inascol.atenea.logic.interfaces.IPersonaService;

public class ReporteDelegate {
	
	private IPersonaService personaService;	
	private List<Object> personas;
	private GppPersona persona;
	private ReporteXLS reporteXLS;
	private ReportePDF reportePDF;
	private Boolean estadoOperacion;
	
	public List<Object> getBusquedaBasicaPersona(String nombrePersona, String apellidoPersona, String identificacionPersona, Boolean estadoPersona){
		personaService = new PersonaService();
		List<Object> criteriosBusqueda = new ArrayList<Object>();							
		if(!nombrePersona.equalsIgnoreCase(""))
			criteriosBusqueda.add("per_vnombres"+"|"+nombrePersona);
		if(!apellidoPersona.equalsIgnoreCase("")) 
			criteriosBusqueda.add("per_vapellidos"+"|"+apellidoPersona);
		if(!identificacionPersona.equalsIgnoreCase(""))
			criteriosBusqueda.add("per_nidentificacion"+"|"+identificacionPersona);
		if(estadoPersona!=null){
			criteriosBusqueda.add("per_vactivo"+"|"+estadoPersona);
		}
		personas = personaService.buscarPersonaPorCriterios(criteriosBusqueda);
		return personas;
	}
	
	public GppPersona getSeleccionarPersona(List<Object> personas, Integer idPersona){
		if(personas.size()>0){
			Iterator<Object> it = personas.iterator();
			while(it.hasNext()){
				persona = (GppPersona) it.next();
				if(persona.getPerNidpersona()==idPersona){
					break;
				}
			}		
		}
		return persona;
	}
	public Boolean getCrearReporte(String tipoReporte, GppPersona persona){
		this.persona = persona;
		if(tipoReporte.equalsIgnoreCase("Depto-Fun-Publica")){
			reportePDF = new ReportePDF();
			estadoOperacion = reporteXLS.generarReporteXLSUpme(this.persona);	
		}
		else if(tipoReporte.equalsIgnoreCase("INGEOMINAS")){
			reporteXLS = new ReporteXLS();
			estadoOperacion = reporteXLS.generarReporteXLSIngeominas(this.persona);
		}
		else if(tipoReporte.equalsIgnoreCase("UPME")){
			reporteXLS = new ReporteXLS();
			estadoOperacion = reporteXLS.generarReporteXLSUpme(this.persona);
		}
		return estadoOperacion;
	}
}