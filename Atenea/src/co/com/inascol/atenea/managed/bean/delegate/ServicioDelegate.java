package co.com.inascol.atenea.managed.bean.delegate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;

import co.com.inascol.atenea.entity.GppServicio;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.ServicioService;
import co.com.inascol.atenea.logic.interfaces.IServicioService;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcción de Software
 * Esp. Sistemas de Información Geográfica
 * Ing. Catastral y Geodesta
 */
public class ServicioDelegate {

        private IServicioService servicioService;
        private List<Object> servicios;
        private GppServicio servicio;
        private GppUsuario usuarioAutenticado;
        
        public ServicioDelegate(){}
        
        public List<Object> getListaServicios(){
                servicioService = new ServicioService();
                servicios = servicioService.buscarServicios();
                return servicios;
        }
        
        public List<Object> getServicioPorNombre(String nombreServicio){
                servicioService = new ServicioService();
                servicios = servicioService.buscarServicios();          
                List<Object> serviciosConsultados = new ArrayList<Object>();
                CharSequence nombre = nombreServicio;
                if(servicios.size()>0){
                        if(nombreServicio.equalsIgnoreCase("")){
                                serviciosConsultados = servicios;
                        } else {
                                Iterator<Object> it = servicios.iterator();
                                while(it.hasNext()){
                                        servicio = (GppServicio) it.next();
                                        if(servicio.getSerVnombre().contains(nombre)){
                                                serviciosConsultados.add(servicio);                     
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
                        Iterator<Object> it = servicios.iterator();
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
                usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
                servicioService = new ServicioService();
                return servicioService.crearServicio(nombreServicio, rutaServicio, usuarioAutenticado);
        }
}