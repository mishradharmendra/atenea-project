package co.com.inascol.atenea.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcci�n de Software
 * Esp. Sistemas de Informaci�n Geogr�fica
 * Ing. Catastral y Geodesta
 */
public class Calculos {

	public static Double diferenciaFechasDias(Date fechaInicial, Date fechaFinal) {
		try {
			DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
			String fechaInicioString;
			String fechaFinalString;
			if(fechaInicial==null)
				fechaInicioString = df.format(new Date());
			else
				fechaInicioString = df.format(fechaInicial);
			if(fechaFinal==null)
				fechaFinalString = df.format(new Date());
			else
				fechaFinalString = df.format(fechaFinal);
			fechaInicial = df.parse(fechaInicioString);
			fechaFinal = df.parse(fechaFinalString);
		}catch (ParseException ex) {
			ex.printStackTrace();
		}
		long fechaInicialms = fechaInicial.getTime();
		long fechaFinalms = fechaFinal.getTime();
		long diferencia = fechaFinalms - fechaInicialms;
		double anios = (diferencia) / (1000 * 60 * 60 * 24);
		return (anios);
	}	
}