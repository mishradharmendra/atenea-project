package co.com.inascol.atenea.logic;

import co.com.inascol.atenea.entity.GppPersona;
import co.com.inascol.atenea.logic.interfaces.IReporteService;

public class ReporteService extends ReporteXLS implements IReporteService{

	public Boolean generarReporteXLSFormal(GppPersona persona) {
		return this.generarReporteFormal(persona);
	}

	public Boolean generarReporteXLSFUHV(GppPersona persona) {
		return this.generarReporteFUHV(persona);
	}

	public Boolean generarReporteXLSIngeominas(GppPersona persona) {
		return this.generarReporteIngeominas(persona);
	}

	public Boolean generarReporteXLSUpme(GppPersona persona) {
		return this.generarReporteUpme(persona);
	}
}