package co.com.inascol.atenea.managed.bean.delegate;

import java.util.List;

import co.com.inascol.atenea.logic.PaisService;
import co.com.inascol.atenea.logic.interfaces.IPaisService;

public class PaisesDelegate {

	private IPaisService paisService;
	private List paises;
	
	public PaisesDelegate(){}
	
	public List getListaPaises(){
		paisService = new PaisService();
		paises = paisService.buscarPaises();
		return paises;
	}
}