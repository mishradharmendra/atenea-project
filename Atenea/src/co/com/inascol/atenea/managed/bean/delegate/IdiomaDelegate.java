package co.com.inascol.atenea.managed.bean.delegate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import co.com.inascol.atenea.entity.GppIdioma;
import co.com.inascol.atenea.logic.IdiomaService;
import co.com.inascol.atenea.logic.interfaces.IIdiomaService;

public class IdiomaDelegate {

	private IIdiomaService idiomaService;
	private List idiomas;
	private GppIdioma idioma;
	
	public IdiomaDelegate(){}
	
	public List getListaIdiomas(){
		idiomaService = new IdiomaService();
		idiomas = idiomaService.buscarIdiomas();
		return idiomas;
	}
	
	public List getIdiomaPorNombre(String nombreIdioma){
		idiomaService = new IdiomaService();
		idiomas = idiomaService.buscarIdiomas();		
		List idiomasConsultados = new ArrayList();
		if(idiomas.size()>0){
			if(nombreIdioma.equalsIgnoreCase("")){
				idiomasConsultados = idiomas;
			} else {
				Iterator it = idiomas.iterator();
				while(it.hasNext()){
					idioma = (GppIdioma) it.next();
					if(idioma.getIdiVidioma().equalsIgnoreCase(nombreIdioma)){
						idiomasConsultados.add(idioma);			
						break;
					}
				}
			}
		}		
		return idiomasConsultados;
	}
	
	public GppIdioma getSeleccionarIdioma(int idIdioma){
		idiomaService = new IdiomaService();
		idiomas = idiomaService.buscarIdiomas();
		if(idiomas.size()>0){
			Iterator it = idiomas.iterator();
			while(it.hasNext()){
				idioma = (GppIdioma) it.next();
				if(idioma.getIdiNididioma() == idIdioma){
					break;
				}
			}					
		}
		return idioma;
	}
	
	public boolean getModificarIdioma(int idIdioma, String nombreIdioma){
		idiomaService = new IdiomaService();
		return idiomaService.actualizarIdioma(idIdioma, nombreIdioma);
	}
	
	public boolean getCrearIdioma(String nombreIdioma){
		idiomaService = new IdiomaService();
		return idiomaService.crearIdioma(nombreIdioma);
	}
}