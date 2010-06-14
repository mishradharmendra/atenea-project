package co.com.inascol.atenea.managed.bean.delegate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import co.com.inascol.atenea.entity.GppServicio;
import co.com.inascol.atenea.logic.ServicioService;
import co.com.inascol.atenea.logic.interfaces.IServicioService;

public class ServicioDelegate {

	private IServicioService servicioService;
	private List servicios;
	private GppServicio servicio;
	
	public ServicioDelegate(){}
	
	public List getListaServicios(){
		servicioService = new ServicioService();
		servicios = servicioService.buscarServicios();
		return servicios;
	}
	
	public List getServicioPorNombre(String nombreServicio){
		servicioService = new ServicioService();
		servicios = servicioService.buscarServicios();		
		List serviciosConsultados = new ArrayList();
		if(servicios.size()>0){
			if(nombreServicio.equalsIgnoreCase("")){
				serviciosConsultados = servicios;
			} else {
				Iterator it = servicios.iterator();
				while(it.hasNext()){
					servicio = (GppServicio) it.next();
					if(servicio.getSerVnombre().equalsIgnoreCase(nombreServicio)){
						serviciosConsultados.add(servicio);			
						break;
					}
				}
			}
		}		
		return serviciosConsultados;
	}
	
	public GppServicio getSeleccionarServicio(int idServicio){
		servicioService = new ServicioService();
		servicios = servicioService.buscarServicios();
		if(servicios.size()>0){
			Iterator it = servicios.iterator();
			while(it.hasNext()){
				servicio = (GppServicio) it.next();
				if(servicio.getSerNidservicio() == idServicio){
					break;
				}
			}					
		}
		return servicio;
	}
	
	public boolean getModificarServicio(int idServicio, String nombreServicio, String rutaServicio){
		servicioService = new ServicioService();
		return servicioService.actualizarServicio(idServicio, nombreServicio, rutaServicio);
	}
	
	public boolean getCrearServicio(String nombreServicio, String rutaServicio){
		servicioService = new ServicioService();
		return servicioService.crearServicio(nombreServicio, rutaServicio);
	}
}