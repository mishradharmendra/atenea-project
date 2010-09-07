package co.com.inascol.atenea.managed.bean.delegate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import co.com.inascol.atenea.entity.GppPersona;
import co.com.inascol.atenea.logic.PersonaService;
import co.com.inascol.atenea.logic.ReporteService;
import co.com.inascol.atenea.logic.interfaces.IPersonaService;
import co.com.inascol.atenea.logic.interfaces.IReporteService;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcci�n de Software
 * Esp. Sistemas de Informaci�n Geogr�fica
 * Ing. Catastral y Geodesta
 */
public class ReporteDelegate {
	
	private IPersonaService personaService;	
	private List<Object> personas;
	private GppPersona persona;
	private IReporteService reporteService;
	private Boolean estadoOperacion;
	
	public List<Object> getBusquedaBasicaPersona(String nombrePersona, String identificacionPersona){
		personas = new ArrayList<Object>();
		personaService = new PersonaService();
		List<Object> criteriosBusqueda = new ArrayList<Object>();
		if(nombrePersona.equalsIgnoreCase("") && identificacionPersona.equalsIgnoreCase("")){
			personas = personaService.buscarPersonas();
		}else{		
			if(!nombrePersona.equalsIgnoreCase("") || !identificacionPersona.equalsIgnoreCase("")){
				personaService = new PersonaService();
				if(!nombrePersona.equalsIgnoreCase("") && !identificacionPersona.equalsIgnoreCase(""))
					criteriosBusqueda.add("DOS|");
				else
					criteriosBusqueda.add("UNO|");
				String apellidoPersona = "";
				String [] nombreApellido = nombrePersona.split("\\s+");
				if(!nombreApellido[0].equalsIgnoreCase("")){
					if(nombreApellido.length==1){
						nombrePersona = nombreApellido[0];
						apellidoPersona = nombreApellido[0];
						criteriosBusqueda.add("per_vnombres"+"|"+nombrePersona);
						criteriosBusqueda.add("per_vapellidos"+"|OR|"+apellidoPersona);
					}				
					else if(nombreApellido.length==2){
						nombrePersona = nombreApellido[0];
						apellidoPersona = nombreApellido[1];
						criteriosBusqueda.add("per_vnombres"+"|"+nombrePersona);
						criteriosBusqueda.add("per_vapellidos"+"|AND|"+apellidoPersona);
					}
					else if(nombreApellido.length==3){
						nombrePersona = nombreApellido[0];
						apellidoPersona = nombreApellido[1] + " " + nombreApellido[2];
						criteriosBusqueda.add("per_vnombres"+"|"+nombrePersona);
						criteriosBusqueda.add("per_vapellidos"+"|AND|"+apellidoPersona);
					}
					else if(nombreApellido.length==4){
						nombrePersona = nombreApellido[0] + " " + nombreApellido[1];
						apellidoPersona = nombreApellido[2] + " " + nombreApellido[3];
						criteriosBusqueda.add("per_vnombres"+"|"+nombrePersona);
						criteriosBusqueda.add("per_vapellidos"+"|AND|"+apellidoPersona);
					}
				}
				if(!identificacionPersona.equalsIgnoreCase(""))
					criteriosBusqueda.add("per_nidentificacion"+"|"+identificacionPersona);
				personas = personaService.buscarPersonaPorCriterios(criteriosBusqueda);
			}
		}
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
	public Boolean getCrearReporte(String tipoReporte, GppPersona personaSeleccionada){
		persona = personaSeleccionada;
		if(tipoReporte.equalsIgnoreCase("Depto-Fun-Publica")){
			reporteService = new ReporteService();
			estadoOperacion = reporteService.generarReporteXLSFUHV(persona);	
		}
		else if(tipoReporte.equalsIgnoreCase("INGEOMINAS")){
			reporteService = new ReporteService();
			estadoOperacion = reporteService.generarReporteXLSIngeominas(persona);
		}
		else if(tipoReporte.equalsIgnoreCase("UPME")){
			reporteService = new ReporteService();
			estadoOperacion = reporteService.generarReporteXLSUpme(persona);
		}
		else if(tipoReporte.equalsIgnoreCase("Formato_Formal")){
			reporteService = new ReporteService();
			estadoOperacion = reporteService.generarReporteXLSFormal(persona);
		}
		return estadoOperacion;
	}
}