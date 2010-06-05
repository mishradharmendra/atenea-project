package co.com.inascol.atenea.managed.bean.delegate;

import java.util.List;

import co.com.inascol.atenea.logic.TipoarchivoService;
import co.com.inascol.atenea.logic.interfaces.ITipoarchivoService;

public class TipoarchivoDelegate {

	private ITipoarchivoService tipoarchivoService;
	
	public TipoarchivoDelegate(){}
	
	public List getListaTipoarchivos(){
		tipoarchivoService = new TipoarchivoService();
		return tipoarchivoService.buscarTipoarchivos();
	}
}