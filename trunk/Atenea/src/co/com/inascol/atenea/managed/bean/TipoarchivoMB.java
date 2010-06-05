package co.com.inascol.atenea.managed.bean;

import java.util.List;

import co.com.inascol.atenea.managed.bean.delegate.TipoarchivoDelegate;


public class TipoarchivoMB {

	private TipoarchivoDelegate tipoarchivoDelegate;
	private List tipoarchivos;
	
	public TipoarchivoMB(){
		tipoarchivoDelegate = new TipoarchivoDelegate();
		setTipoarchivos(tipoarchivoDelegate.getListaTipoarchivos());
	}

	public List getTipoarchivo() {
		return tipoarchivos;
	}

	public void setTipoarchivos(List tipoarchivos) {
		this.tipoarchivos = tipoarchivos;
	}	
}