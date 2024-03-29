package co.com.inascol.atenea.logic.interfaces;

import co.com.inascol.atenea.entity.GppPersona;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construccion de Software
 * Esp. Sistemas de Informacion Geografica
 * Ing. Catastral y Geodesta
 */
public interface IReporteService {

	public Boolean generarReporteXLSFUHV(GppPersona persona);
	public Boolean generarReporteXLSIngeominas(GppPersona persona);
	public Boolean generarReporteXLSUpme(GppPersona persona);
	public Boolean generarReporteXLSFormal(GppPersona persona);
}