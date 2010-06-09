package co.com.inascol.atenea.managed.bean.delegate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import co.com.inascol.atenea.entity.GppMunicipio;
import co.com.inascol.atenea.logic.MunicipioService;
import co.com.inascol.atenea.logic.interfaces.IMunicipioService;

public class MunicipioDelegate {

	private IMunicipioService municipioService;
	private List municipios;
	private GppMunicipio municipio;
	
	public MunicipioDelegate(){}
	
	public List getListaMunicipios(){
		municipioService = new MunicipioService();
		municipios = municipioService.buscarMunicipios();
		return municipios;
	}
	
	public List getMunicipioPorNombre(String nombreMunicipio){
		municipioService = new MunicipioService();
		municipios = municipioService.buscarMunicipios();		
		List municipiosConsultados = new ArrayList();
		if(municipios.size()>0){
			if(nombreMunicipio.equalsIgnoreCase("")){
				municipiosConsultados = municipios;
			} else {
				Iterator it = municipios.iterator();
				while(it.hasNext()){
					municipio = (GppMunicipio) it.next();
					if(municipio.getMunVmunicipio().equalsIgnoreCase(nombreMunicipio)){
						municipiosConsultados.add(municipio);			
						break;
					}
				}
			}
		}		
		return municipiosConsultados;
	}
	
	public GppMunicipio getSeleccionarMunicipio(String idMunicipio){
		municipioService = new MunicipioService();
		municipios = municipioService.buscarMunicipios();
		if(municipios.size()>0){
			Iterator it = municipios.iterator();
			while(it.hasNext()){
				municipio = (GppMunicipio) it.next();
				if(municipio.getMunVidmunicipio().equalsIgnoreCase(idMunicipio)){
					break;
				}
			}					
		}
		return municipio;
	}
	
	public boolean getModificarMunicipio(String idMunicipio, String nombreMunicipio, String idDepto){
		municipioService = new MunicipioService();
		return municipioService.actualizarMunicipio(idMunicipio, nombreMunicipio, idDepto);
	}
	
	public boolean getCrearMunicipio(String idMunicipio, String nombreMunicipio, String idDepto){
		municipioService = new MunicipioService();
		return municipioService.crearMunicipio(idMunicipio, nombreMunicipio, idDepto);
	}
}