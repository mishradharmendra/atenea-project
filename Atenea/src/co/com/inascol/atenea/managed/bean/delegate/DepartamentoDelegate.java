package co.com.inascol.atenea.managed.bean.delegate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;

import co.com.inascol.atenea.entity.GppDepartamento;
import co.com.inascol.atenea.entity.GppUsuario;
import co.com.inascol.atenea.logic.DepartamentoService;
import co.com.inascol.atenea.logic.interfaces.IDepartamentoService;
/**
 * @author Guillermo Toro
 *
 */
public class DepartamentoDelegate {

	private IDepartamentoService departamentoService;
	private List<Object> departamentos;
	private GppDepartamento departamento;
	private GppUsuario usuarioAutenticado;
	
	public DepartamentoDelegate(){}
	
	public List<Object> getListaDeptos(){
		departamentoService = new DepartamentoService();
		departamentos = departamentoService.buscarDepartamentos();
		return departamentos;
	}
	
	public List<Object> getDeptoPorNombre(String nombreDepto){
		departamentoService = new DepartamentoService();
		departamentos = departamentoService.buscarDepartamentos();		
		List<Object> departamentosConsultados = new ArrayList<Object>();
		CharSequence nombre = nombreDepto.toLowerCase();
		if(departamentos.size()>0){
			if(nombreDepto.equalsIgnoreCase("")){
				departamentosConsultados = departamentos;
			} else {
				Iterator<Object> it = departamentos.iterator();
				while(it.hasNext()){
					departamento = (GppDepartamento) it.next();
					if(departamento.getDptVdepto().toLowerCase().contains(nombre)){
						departamentosConsultados.add(departamento);			
					}
				}
			}
		}		
		return departamentosConsultados;
	}
	
	public GppDepartamento getSeleccionarDepto(Integer idDepto){
		departamentoService = new DepartamentoService();
		departamentos = departamentoService.buscarDepartamentos();
		if(departamentos.size()>0){
			Iterator<Object> it = departamentos.iterator();
			while(it.hasNext()){
				departamento = (GppDepartamento) it.next();
				if(departamento.getDptNiddepto()==idDepto){
					break;
				}
			}					
		}
		return departamento;
	}
	
	public Boolean getModificarDepto(Integer idDepto, String nombreDepto, Integer idPais){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		departamentoService = new DepartamentoService();
		return departamentoService.actualizarDepartamento(idDepto, nombreDepto, idPais, usuarioAutenticado);
	}
	
	public Boolean getCrearDepto(String nombreDepto, Integer idPais){
		usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		departamentoService = new DepartamentoService();
		return departamentoService.crearDepartamento(nombreDepto, idPais, usuarioAutenticado);
	}
	
	public Boolean getEliminarDepto(Integer idDepto){
		departamentoService = new DepartamentoService();
		return departamentoService.borrarDepartamento(idDepto);
	}
}