package co.com.inascol.atenea.managed.bean.delegate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import co.com.inascol.atenea.entity.GppDepartamento;
import co.com.inascol.atenea.logic.DepartamentoService;
import co.com.inascol.atenea.logic.interfaces.IDepartamentoService;

public class DepartamentoDelegate {

	private IDepartamentoService departamentoService;
	private List departamentos;
	private GppDepartamento departamento;
	
	public DepartamentoDelegate(){}
	
	public List getListaDeptos(){
		departamentoService = new DepartamentoService();
		departamentos = departamentoService.buscarDepartamentos();
		return departamentos;
	}
	
	public List getDeptoPorNombre(String nombreDepto){
		departamentoService = new DepartamentoService();
		departamentos = departamentoService.buscarDepartamentos();		
		List departamentosConsultados = new ArrayList();
		if(departamentos.size()>0){
			if(nombreDepto.equalsIgnoreCase("")){
				departamentosConsultados = departamentos;
			} else {
				Iterator it = departamentos.iterator();
				while(it.hasNext()){
					departamento = (GppDepartamento) it.next();
					if(departamento.getDptVdepto().equalsIgnoreCase(nombreDepto)){
						departamentosConsultados.add(departamento);			
						break;
					}
				}
			}
		}		
		return departamentosConsultados;
	}
	
	public GppDepartamento getSeleccionarDepto(String idDepto){
		departamentoService = new DepartamentoService();
		departamentos = departamentoService.buscarDepartamentos();
		if(departamentos.size()>0){
			Iterator it = departamentos.iterator();
			while(it.hasNext()){
				departamento = (GppDepartamento) it.next();
				if(departamento.getDptViddepto().equalsIgnoreCase(idDepto)){
					break;
				}
			}					
		}
		return departamento;
	}
	
	public boolean getModificarDepto(String idDepto, String nombreDepto, String idPais){
		departamentoService = new DepartamentoService();
		return departamentoService.actualizarDepartamento(idDepto, nombreDepto, idPais);
	}
	
	public boolean getCrearDepto(String idDepto, String nombreDepto, String idPais){
		departamentoService = new DepartamentoService();
		return departamentoService.crearDepartamento(idDepto, nombreDepto, idPais);
	}
}