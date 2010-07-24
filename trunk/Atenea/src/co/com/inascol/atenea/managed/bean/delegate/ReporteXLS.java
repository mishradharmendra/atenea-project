package co.com.inascol.atenea.managed.bean.delegate;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import co.com.inascol.atenea.entity.GppExperiencia;
import co.com.inascol.atenea.entity.GppFormacion;
import co.com.inascol.atenea.entity.GppInstitucion;
import co.com.inascol.atenea.entity.GppParametrizacion;
import co.com.inascol.atenea.entity.GppPersona;
import co.com.inascol.atenea.logic.ExperienciaService;
import co.com.inascol.atenea.logic.InstitucionService;
import co.com.inascol.atenea.logic.MunicipioService;
import co.com.inascol.atenea.logic.ParametrizacionService;
import co.com.inascol.atenea.logic.interfaces.IExperienciaService;
import co.com.inascol.atenea.logic.interfaces.IInstitucionService;
import co.com.inascol.atenea.logic.interfaces.IMunicipioService;
import co.com.inascol.atenea.logic.interfaces.IParametrizacionService;
import co.com.inascol.atenea.util.Calculos;

public class ReporteXLS {
	
	private IExperienciaService experienciaService;
	private IInstitucionService institucionService;
	private IMunicipioService municipioService;
	private IParametrizacionService parametrizacionService;
	private Boolean estadoOperacion;
	private SimpleDateFormat simpleDateFormat;
	
	public ReporteXLS(){
		experienciaService = new ExperienciaService();
		municipioService = new MunicipioService();
		parametrizacionService = new ParametrizacionService();
		institucionService = new InstitucionService();
	}
	
	public Boolean generarReporteXLSUpme(GppPersona persona){
		estadoOperacion = false;
		try{
			simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			HSSFWorkbook libro = new HSSFWorkbook();
			HSSFSheet hoja = libro.createSheet("Hoja_Vida");
			HSSFRow fila = hoja.createRow(0);
			HSSFCell celda = fila.createCell(0);
			HSSFRichTextString texto = new HSSFRichTextString();
					
			HSSFFont fuentePlantilla = libro.createFont();
			fuentePlantilla.setFontName("Arial Narrow");
			fuentePlantilla.setBoldweight((short)1000);
			fuentePlantilla.setFontHeightInPoints((short)11);
			
			HSSFFont fuenteContenido = libro.createFont();
			fuenteContenido.setFontName("Arial Narrow");
			fuenteContenido.setFontHeightInPoints((short)11);
			
			HSSFCellStyle estiloPlantilla = libro.createCellStyle();
			estiloPlantilla.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			estiloPlantilla.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			estiloPlantilla.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			estiloPlantilla.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			estiloPlantilla.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			estiloPlantilla.setFont(fuentePlantilla);
			
			HSSFCellStyle estiloPlantillaTitulo = libro.createCellStyle();
			estiloPlantillaTitulo.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			estiloPlantillaTitulo.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			estiloPlantillaTitulo.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			estiloPlantillaTitulo.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			estiloPlantillaTitulo.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			estiloPlantillaTitulo.setFont(fuentePlantilla);
			
			HSSFCellStyle estiloContenido = libro.createCellStyle();
			estiloContenido.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			estiloContenido.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			estiloContenido.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			estiloContenido.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			estiloPlantilla.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			estiloContenido.setFont(fuenteContenido);
			
			for (int i = 1; i <= 1000; i++) {
				fila = hoja.createRow(i);
				for (int j = 0; j <= 50; j++) {
					fila.createCell(j);
				}
			}
			
			for (int i = 1; i <= 6; i++) {
				fila = hoja.createRow(i);
				for (int j = 0; j <= 5; j++) {
					fila.createCell(j).setCellStyle(estiloPlantilla);
				}
			}

			// NOMBRES Y APELLIDOS
			fila = hoja.getRow(1);
			celda = fila.getCell(0);
			texto = new HSSFRichTextString("NOMBRES Y APELLIDOS:");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantilla);
			celda = fila.createCell(1);
			celda.setCellStyle(estiloPlantilla);
			hoja.addMergedRegion(new CellRangeAddress(1,1,0,1));
			//
			celda = fila.getCell(2);
			texto = new HSSFRichTextString(persona.getPerVnombres()+" "+persona.getPerVapellidos());
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja.addMergedRegion(new CellRangeAddress(1,1,2,5));
			
			// CARGO A OCUPAR
			fila = hoja.getRow(2);
			celda = fila.getCell(0);
			texto = new HSSFRichTextString("CARGO A OCUPAR:");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantilla);
			celda = fila.createCell(1);
			celda.setCellStyle(estiloPlantilla);
			hoja.addMergedRegion(new CellRangeAddress(2,2,0,1));
			//
			celda = fila.getCell(2);
			celda.setCellStyle(estiloContenido);
			hoja.addMergedRegion(new CellRangeAddress(2,2,2,5));
			
			// DOMICILIO			
			fila = hoja.getRow(3);
			celda = fila.getCell(0);
			texto = new HSSFRichTextString("DOMICILIO:");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantilla);
			celda = fila.getCell(1);
			celda.setCellStyle(estiloPlantilla);
			hoja.addMergedRegion(new CellRangeAddress(3,3,0,1));
			//
			String mpioDomicilio = "Municipio de " + municipioService.buscarPorIdMunicipio(persona.getMunNmpioresidencia()).getMunVmunicipio();
			celda = fila.getCell(2);
			texto = new HSSFRichTextString(mpioDomicilio);
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			
			// DIRECCIÓN
			celda = fila.getCell(3);
			texto = new HSSFRichTextString("DIRECCIÓN:");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantilla);
			//
			celda = fila.getCell(4);
			texto = new HSSFRichTextString(persona.getPerVdireccion());
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja.addMergedRegion(new CellRangeAddress(3,3,4,5));
			
			// TELEFONO
			fila = hoja.getRow(4);
			celda = fila.getCell(0);
			texto = new HSSFRichTextString("TELÉFONO:");		
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantilla);
			hoja.addMergedRegion(new CellRangeAddress(4,4,0,1));
			//
			celda = fila.getCell(2);
			texto = new HSSFRichTextString(persona.getPerVtelefono()+" / "+persona.getPerVmovil());		
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja.addMergedRegion(new CellRangeAddress(4,4,4,5));
			
			// FAX
			celda = fila.getCell(3);
			texto = new HSSFRichTextString("FAX:");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantilla);
			//
			celda = fila.getCell(4);
			celda.setCellStyle(estiloContenido);
			hoja.addMergedRegion(new CellRangeAddress(5,5,4,5));
			
			// CEDULA
			fila = hoja.getRow(5);
			celda = fila.getCell(0);
			texto = new HSSFRichTextString("CÉDULA No:");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantilla);
			celda = fila.getCell(1);
			celda.setCellStyle(estiloPlantilla);
			hoja.addMergedRegion(new CellRangeAddress(5,5,0,1));
			//
			celda = fila.getCell(2);
			texto = new HSSFRichTextString(persona.getPerNidentificacion().toString());
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			
			// PASAPORTE
			celda = fila.getCell(3);
			texto = new HSSFRichTextString("PASAPORTE:");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantilla);
			//
			celda = fila.getCell(4);
			celda.setCellStyle(estiloContenido);
			hoja.addMergedRegion(new CellRangeAddress(5,5,4,5));
			
			// LUGAR Y FECHA DE NACIMIENTO
			fila = hoja.getRow(6);
			celda = fila.getCell(0);
			texto = new HSSFRichTextString("LUGAR Y FECHA DE NACIMIENTO:");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantilla);
			celda = fila.getCell(1);
			celda.setCellStyle(estiloPlantilla);
			hoja.addMergedRegion(new CellRangeAddress(6,6,0,1));
			//
			String lugarFecha; 
			if(persona.getPerDfecnacimiento()!=null)
				lugarFecha = "Municipio de " + municipioService.buscarPorIdMunicipio(persona.getMunNmpioresidencia()).getMunVmunicipio() + ". Fecha: " + simpleDateFormat.format(persona.getPerDfecnacimiento());
			else
				lugarFecha = "Municipio de " + municipioService.buscarPorIdMunicipio(persona.getMunNmpioresidencia()).getMunVmunicipio() + ". Fecha: Sin Fecha Registrada";			
			celda = fila.getCell(2);
			texto = new HSSFRichTextString(lugarFecha);
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja.addMergedRegion(new CellRangeAddress(6,6,2,5));
			
			// EXPERIENCIA
			fila = hoja.getRow(8);
			celda = fila.getCell(0);
			texto = new HSSFRichTextString("EXPERIENCIA ESPECÍFICA");
			celda.setCellStyle(estiloPlantillaTitulo);		
			celda.setCellValue(texto);
			celda = fila.getCell(1);
			celda.setCellStyle(estiloPlantillaTitulo);
			celda = fila.getCell(2);
			celda.setCellStyle(estiloPlantillaTitulo);
			celda = fila.getCell(3);
			celda.setCellStyle(estiloPlantillaTitulo);
			celda = fila.getCell(4);
			celda.setCellStyle(estiloPlantillaTitulo);	
			celda = fila.getCell(5);
			celda.setCellStyle(estiloPlantillaTitulo);
			hoja.addMergedRegion(new CellRangeAddress(8,8,0,5));
			
			List<Object> experienciasLaborales = experienciaService.buscarExperienciasPersona(persona.getPerNidpersona());
			
			Integer filaPendiente = fila.getRowNum()+1;
			for (Integer i = filaPendiente; i <= (filaPendiente + experienciasLaborales.size()); i++) {
				fila = hoja.createRow(i);
				for (Integer j = 0; j <= 5; j++) {
					fila.createCell(j).setCellStyle(estiloPlantilla);
				}
			}
			
			fila = hoja.getRow(9);
			celda = fila.getCell(0);
			texto = new HSSFRichTextString("NOMBRE DEL PROYECTO");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulo);
			hoja.addMergedRegion(new CellRangeAddress(9,10,0,0));
			
			celda = fila.getCell(1);
			texto = new HSSFRichTextString("ENTIDAD");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulo);
			hoja.addMergedRegion(new CellRangeAddress(9,10,1,1));
			
			celda = fila.getCell(2);
			texto = new HSSFRichTextString("Actividad Desempeñada");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulo);
			hoja.addMergedRegion(new CellRangeAddress(9,10,2,2));
			
			celda = fila.getCell(3);
			texto = new HSSFRichTextString("FECHA DE");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulo);
			hoja.addMergedRegion(new CellRangeAddress(9,9,3,4));
			
			celda = fila.getCell(5);
			texto = new HSSFRichTextString("Duración (años y/o fracción)");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulo);
			hoja.addMergedRegion(new CellRangeAddress(9,10,5,5));
			
			fila = hoja.getRow(10);
			celda = fila.getCell(3);
			texto = new HSSFRichTextString("Iniciación");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulo);
			
			celda = fila.getCell(4);
			texto = new HSSFRichTextString("Terminación");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulo);
			
			Iterator<Object> itExperiencia = experienciasLaborales.iterator();
			filaPendiente = fila.getRowNum()+1;
			Integer filaInicio = fila.getRowNum()+2; 
			GppExperiencia experiencia = null;
			while(itExperiencia.hasNext()){
				experiencia = (GppExperiencia) itExperiencia.next();
				fila = hoja.getRow(filaPendiente);
				celda = fila.getCell(1);
				celda.setCellStyle(estiloContenido);
				celda.setCellValue(experiencia.getExpVnomempresa());
				celda = fila.getCell(2);
				celda.setCellStyle(estiloContenido);
				celda.setCellValue(experiencia.getExpVfuncionlogro());
				celda = fila.getCell(3);
				celda.setCellStyle(estiloContenido);
				if(experiencia.getExpDfecingreso()!=null)
					celda.setCellValue(simpleDateFormat.format(experiencia.getExpDfecingreso()));
				celda = fila.getCell(4);
				celda.setCellStyle(estiloContenido);
				if(experiencia.getExpDfecretiro()==null)
					celda.setCellValue(simpleDateFormat.format(new Date())+" (Actual)");
				else
					celda.setCellValue(simpleDateFormat.format(experiencia.getExpDfecretiro()));
				celda = fila.getCell(5);
				celda.setCellStyle(estiloContenido);
				celda.setCellValue(Calculos.diferenciaFechasMes(experiencia.getExpDfecingreso(), experiencia.getExpDfecretiro()));
				celda.setCellStyle(estiloContenido);
				filaPendiente++;
			}
			
			for (Integer i = filaPendiente; i <= (filaPendiente+1); i++) {
				fila = hoja.createRow(i);
				for (Integer j = 0; j <= 5; j++) {
					fila.createCell(j).setCellStyle(estiloPlantilla);
				}
			}
			
			fila = hoja.getRow(filaPendiente);
			celda = fila.getCell(0);
			texto = new HSSFRichTextString("TOTAL EXPERIENCIA ESPECÍFICA EN MESES");
			celda.setCellStyle(estiloPlantilla);
			celda.setCellValue(texto);
			hoja.addMergedRegion(new CellRangeAddress(fila.getRowNum(),fila.getRowNum()+1,0,4));
			
			celda = fila.getCell(5);
			texto = new HSSFRichTextString("Suma experiencia específica");
			celda.setCellStyle(estiloPlantillaTitulo);
			celda.setCellValue(texto);
			hoja.addMergedRegion(new CellRangeAddress(fila.getRowNum(),fila.getRowNum()+1,5,5));
			
			fila = hoja.getRow(fila.getRowNum()+2);
			celda = fila.createCell(5);
			celda.setCellStyle(estiloPlantillaTitulo);
			celda.setCellType(HSSFCell.CELL_TYPE_FORMULA);
			String formula = hoja.getSheetName()+"!F"+filaInicio+":F"+(filaPendiente);
			celda.setCellFormula("SUM("+formula+")");
			
			for (int i = 0; i <= 5; i++) {
				hoja.autoSizeColumn(i,true);	
			}
			
			String rutaSalidaExportacion = ( (GppParametrizacion) parametrizacionService.buscarPorIdParametrizacion(2) ).getParVvalor();
			String nombreArchivo = "FORMATO_HV_UPME_"+persona.getPerNidentificacion()+".xls";		
			FileOutputStream formatoExportado = new FileOutputStream(rutaSalidaExportacion+nombreArchivo);
			libro.write(formatoExportado);
			formatoExportado.close();		
			estadoOperacion = true;
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}
	
	public Boolean generarReporteXLSIngeominas(GppPersona persona){
		estadoOperacion = false;
		try{
			simpleDateFormat = new SimpleDateFormat("MM-yyyy");
			HSSFWorkbook libro = new HSSFWorkbook();
			HSSFSheet hoja = libro.createSheet("Formato_No._6_Pág._1");
			HSSFRow fila = hoja.createRow(0);
			HSSFCell celda = fila.createCell(0);
			HSSFRichTextString texto = new HSSFRichTextString();
					
			HSSFFont fuentePlantilla = libro.createFont();
			fuentePlantilla.setFontName("Arial");
			fuentePlantilla.setBoldweight((short)1000);
			fuentePlantilla.setFontHeightInPoints((short)11);
			
			HSSFFont fuenteContenido = libro.createFont();
			fuenteContenido.setFontName("Arial");
			fuenteContenido.setFontHeightInPoints((short)11);
			
			HSSFCellStyle estiloPlantillaTitulos = libro.createCellStyle();
			estiloPlantillaTitulos.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			estiloPlantillaTitulos.setFont(fuentePlantilla);
			
			HSSFCellStyle estiloContenidoTitulos = libro.createCellStyle();
			estiloContenidoTitulos.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			estiloContenidoTitulos.setFont(fuenteContenido);
			
			HSSFCellStyle estiloContenido = libro.createCellStyle();
			estiloContenido.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			estiloContenido.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			estiloContenido.setBorderRight(HSSFCellStyle.BORDER_THIN);
			estiloContenido.setBorderTop(HSSFCellStyle.BORDER_THIN);
			estiloContenido.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			estiloContenido.setFont(fuenteContenido);
			
			for (Integer i = 1; i <= 1000; i++) {
				fila = hoja.createRow(i);
				for (Integer j = 0; j <= 50; j++) {
					fila.createCell(j);
				}
			}
			
			// ENCABEZADO
			fila = hoja.getRow(0);
			celda = fila.getCell(0);
			texto = new HSSFRichTextString("MINISTERIO DE MÍNAS Y ENERGÍA");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);
			hoja.addMergedRegion(new CellRangeAddress(0,0,0,5));
			//
			fila = hoja.getRow(1);
			celda = fila.getCell(0);
			texto = new HSSFRichTextString("INSTITUTO COLOMBIANO DE GEOLOGÍA Y MINERÍA - INGEOMINAS");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);
			hoja.addMergedRegion(new CellRangeAddress(1,1,0,5));
			//
			fila = hoja.getRow(3);
			celda = fila.getCell(0);
			texto = new HSSFRichTextString("PROCESO DE LICITACIÓN XXX DE XXXX");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);
			hoja.addMergedRegion(new CellRangeAddress(3,3,0,5));
			//
			fila = hoja.getRow(4);
			celda = fila.getCell(0);
			texto = new HSSFRichTextString("OBJETO:");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);
			hoja.addMergedRegion(new CellRangeAddress(4,4,0,5));
			//
			fila = hoja.getRow(6);
			celda = fila.getCell(0);
			texto = new HSSFRichTextString("ANEXO 6");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);
			hoja.addMergedRegion(new CellRangeAddress(6,6,0,5));
			//
			fila = hoja.getRow(7);
			celda = fila.getCell(0);
			texto = new HSSFRichTextString("INFORMACIÓN DEL PERSONAL PROFESIONAL");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);
			hoja.addMergedRegion(new CellRangeAddress(7,7,0,5));	
			//
			fila = hoja.getRow(9);
			celda = fila.getCell(0);
			texto = new HSSFRichTextString("Página 1 de 2");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);
			//
			fila = hoja.getRow(11);
			celda = fila.getCell(0);
			texto = new HSSFRichTextString("NOMBRE:");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			//
			celda = fila.getCell(1);
			texto = new HSSFRichTextString(persona.getPerVnombres()+" "+persona.getPerVapellidos());
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja.addMergedRegion(new CellRangeAddress(11,11,1,2));			
			//
			celda = fila.getCell(3);
			texto = new HSSFRichTextString("PROFESIÓN:");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			//
			celda = fila.getCell(4);
			texto = new HSSFRichTextString();
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja.addMergedRegion(new CellRangeAddress(11,11,4,5));
			//
			fila = hoja.getRow(13);
			celda = fila.getCell(0);
			texto = new HSSFRichTextString("CARGO POR OCUPAR EN EL PROYECTO:");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);	
			hoja.addMergedRegion(new CellRangeAddress(13,13,0,2));
			//
			fila = hoja.getRow(15);
			celda = fila.getCell(0);
			texto = new HSSFRichTextString("EDUCACIÓN SUPERIOR");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);	
			hoja.addMergedRegion(new CellRangeAddress(15,15,0,5));
			//
			fila = hoja.getRow(16);
			celda = fila.getCell(0);
			texto = new HSSFRichTextString("PREGRADO");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);	
			hoja.addMergedRegion(new CellRangeAddress(16,16,0,5));
			//
			fila = hoja.getRow(17);
			celda = fila.getCell(0);
			texto = new HSSFRichTextString("No. DE");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);	
			//
			celda = fila.getCell(1);
			texto = new HSSFRichTextString("ESTABLECIMIENTO");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);	
			//
			celda = fila.getCell(2);
			texto = new HSSFRichTextString("TITULO");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);	
			//
			celda = fila.getCell(3);
			texto = new HSSFRichTextString("FECHA DE GRADO");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);	
			//
			celda = fila.getCell(4);
			texto = new HSSFRichTextString("DOCUMENTO PROFESIONAL (1)");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);
			hoja.addMergedRegion(new CellRangeAddress(fila.getRowNum(),fila.getRowNum(),4,5));
			//
			fila = hoja.getRow(18);
			celda = fila.getCell(0);
			texto = new HSSFRichTextString("ORDEN");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);	
			//
			celda = fila.getCell(1);
			texto = new HSSFRichTextString("EDUCATÍVO");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);	
			//
			celda = fila.getCell(2);
			texto = new HSSFRichTextString("OBTENIDO");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);	
			//
			celda = fila.getCell(3);
			texto = new HSSFRichTextString("(mes - año)");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);	
			//
			celda = fila.getCell(4);
			texto = new HSSFRichTextString("No.");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);	
			//
			celda = fila.getCell(5);
			texto = new HSSFRichTextString("Fecha");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);	
			
			List<Object> formaciones = persona.getGppFormaciones();
			
			Integer filaPendiente = fila.getRowNum()+1;
			for (Integer i = filaPendiente; i <= (filaPendiente + formaciones.size()); i++) {
			fila = hoja.getRow(i);
				for (Integer j = 0; j <= 5; j++) {
					fila.getCell(j).setCellStyle(estiloContenidoTitulos);
				}
			}
			
			GppFormacion formacion = null;
			Integer noOrden = 1;
			Iterator<Object> it = formaciones.iterator();
			while(it.hasNext()){
				formacion = (GppFormacion) it.next();
				if(formacion.getNacNidnivelac()==3){
					fila = hoja.getRow(filaPendiente);
					celda = fila.getCell(0);
					celda.setCellStyle(estiloContenido);
					celda.setCellValue(noOrden);
					celda = fila.getCell(1);
					celda.setCellStyle(estiloContenido);
					celda.setCellValue( ((GppInstitucion)institucionService.buscarPorIdInstitucion(formacion.getInsNidinstitucion())).getInsVinstitucion());
					celda = fila.getCell(2);
					celda.setCellStyle(estiloContenido);
					celda.setCellValue(formacion.getForVtitulo());
					celda = fila.getCell(3);
					celda.setCellStyle(estiloContenido);
					if(formacion.getForDfecgrado()!=null)
						celda.setCellValue(simpleDateFormat.format(formacion.getForDfecgrado()));
					celda = fila.getCell(4);
					celda.setCellStyle(estiloContenido);
					celda.setCellValue(formacion.getForVtarjetaprof());
					celda = fila.getCell(5);
					celda.setCellStyle(estiloContenido);
					if(formacion.getForDfectarjeta()!=null)
						celda.setCellValue(simpleDateFormat.format(formacion.getForDfectarjeta()));
					celda.setCellStyle(estiloContenido);
					filaPendiente++;
					noOrden++;
				}
			}
			
			//
			filaPendiente = fila.getRowNum()+2;
			fila = hoja.getRow(filaPendiente);
			celda = fila.getCell(0);
			texto = new HSSFRichTextString("POSTGRADOS");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);	
			hoja.addMergedRegion(new CellRangeAddress(filaPendiente,filaPendiente,0,5));
			//
			filaPendiente = filaPendiente+1;
			fila = hoja.getRow(filaPendiente);
			celda = fila.getCell(0);
			texto = new HSSFRichTextString("No. DE");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);	
			//
			celda = fila.getCell(1);
			texto = new HSSFRichTextString("ESTABLECIMIENTO");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);	
			//
			celda = fila.getCell(2);
			texto = new HSSFRichTextString("TÍTULO");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);	
			//
			celda = fila.getCell(3);
			texto = new HSSFRichTextString("FECHA DE GRADO");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);	
			//
			celda = fila.getCell(4);
			texto = new HSSFRichTextString("TIEMPO DE DEDICACIÓN");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);	
			hoja.addMergedRegion(new CellRangeAddress(filaPendiente,filaPendiente,4,5));
			//
			filaPendiente = filaPendiente +1;
			fila = hoja.getRow(filaPendiente);
			celda = fila.getCell(0);
			texto = new HSSFRichTextString("ORDEN");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);	
			//
			celda = fila.getCell(1);
			texto = new HSSFRichTextString("EDUCATIVO");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);	
			//
			celda = fila.getCell(2);
			texto = new HSSFRichTextString("OBTENIDO");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);	
			//
			celda = fila.getCell(3);
			texto = new HSSFRichTextString("(mes - año)");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);	
			//
			celda = fila.getCell(4);
			texto = new HSSFRichTextString("Completo");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);	
			//
			celda = fila.getCell(5);
			texto = new HSSFRichTextString("Parcial");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);
			
			filaPendiente = fila.getRowNum()+1;
			for (Integer i = filaPendiente; i <= (filaPendiente + formaciones.size()); i++) {
			fila = hoja.getRow(i);
				for (Integer j = 0; j <= 5; j++) {
					fila.getCell(j).setCellStyle(estiloContenidoTitulos);
				}
			}
			
			formacion = null;
			noOrden = 1;
			it = formaciones.iterator();
			while(it.hasNext()){
				formacion = (GppFormacion) it.next();
				if(formacion.getNacNidnivelac()!=3){					
					fila = hoja.getRow(filaPendiente);
					celda = fila.getCell(0);
					celda.setCellStyle(estiloContenido);
					celda.setCellValue(noOrden);
					celda = fila.getCell(1);
					celda.setCellStyle(estiloContenido);
					celda.setCellValue( ((GppInstitucion)institucionService.buscarPorIdInstitucion(formacion.getInsNidinstitucion())).getInsVinstitucion());
					celda = fila.getCell(2);
					celda.setCellStyle(estiloContenido);
					celda.setCellValue(formacion.getForVtitulo());
					celda = fila.getCell(3);
					celda.setCellStyle(estiloContenido);
					if(formacion.getForDfecgrado()!=null)
						celda.setCellValue(simpleDateFormat.format(formacion.getForDfecgrado()));
					filaPendiente++;
					noOrden++;
				}
			}
			
			filaPendiente = fila.getRowNum()+3;
			//
			fila = hoja.getRow(filaPendiente);
			celda = fila.getCell(0);
			texto = new HSSFRichTextString("EXPERIENCIA ESPECÍFICA COMO FUNCIONARIO EN ENTIDADES OFICIALES (Sólo como profesional. Relacionar en orden cronológico)");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);	
			hoja.addMergedRegion(new CellRangeAddress(filaPendiente,filaPendiente,0,5));
			//
			filaPendiente = filaPendiente +2;
			fila = hoja.getRow(filaPendiente);
			celda = fila.getCell(0);
			texto = new HSSFRichTextString("No.");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);
			//			
			celda = fila.getCell(1);
			texto = new HSSFRichTextString("RAZÓN SOCIAL");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);			
			//			
			celda = fila.getCell(3);
			texto = new HSSFRichTextString("DESCRIPCIÓN DE");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);
			celda = fila.getCell(4);
			texto = new HSSFRichTextString("PERÍODO LABORADO");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);
			hoja.addMergedRegion(new CellRangeAddress(filaPendiente,filaPendiente,4,5));
			//
			filaPendiente = filaPendiente +1;
			fila = hoja.getRow(filaPendiente);
			celda = fila.getCell(0);
			texto = new HSSFRichTextString("DE");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);
			//			
			celda = fila.getCell(1);
			texto = new HSSFRichTextString("DE LA ENTIDAD OFICIAL");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);			
			//			
			celda = fila.getCell(2);
			texto = new HSSFRichTextString("CARGO DESEMPEÑADO");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);
			//
			celda = fila.getCell(3);
			texto = new HSSFRichTextString("LAS FUNCIONES");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);
			//
			celda = fila.getCell(4);
			texto = new HSSFRichTextString("INICIA / TERMINA");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);
			//
			celda = fila.getCell(5);
			texto = new HSSFRichTextString("DURACIÓN");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);		
			//
			filaPendiente = filaPendiente +1;
			fila = hoja.getRow(filaPendiente);
			celda = fila.getCell(0);
			texto = new HSSFRichTextString("ORDEN");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);
			//			
			celda = fila.getCell(3);
			texto = new HSSFRichTextString("REALIZADAS");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);
			//
			celda = fila.getCell(4);
			texto = new HSSFRichTextString("(mes - año)");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);
			//
			celda = fila.getCell(5);
			texto = new HSSFRichTextString("(meses)");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);	
			
			List<Object> experiencias = experienciaService.buscarExperienciasPersona(persona.getPerNidpersona());
			
			filaPendiente = fila.getRowNum()+1;
			for (Integer i = filaPendiente; i <= (filaPendiente + experiencias.size()); i++) {
			fila = hoja.getRow(i);
				for (Integer j = 0; j <= 5; j++) {
					fila.getCell(j).setCellStyle(estiloContenidoTitulos);
				}
			}
					
			GppExperiencia experiencia = null;
			noOrden = 1;
			it = experiencias.iterator();
			while(it.hasNext()){
				experiencia = (GppExperiencia) it.next();
				fila = hoja.getRow(filaPendiente);
				celda = fila.getCell(0);
				celda.setCellStyle(estiloContenido);
				celda.setCellValue(noOrden);
				celda = fila.getCell(1);
				celda.setCellStyle(estiloContenido);
				celda.setCellValue(experiencia.getExpVnomempresa());
				celda = fila.getCell(2);
				celda.setCellStyle(estiloContenido);
				celda.setCellValue(experiencia.getExpVcargo());
				celda = fila.getCell(3);
				celda.setCellStyle(estiloContenido);
				celda.setCellValue(experiencia.getExpVfuncionlogro());
				celda = fila.getCell(4);
				celda.setCellStyle(estiloContenido);
				if(experiencia.getExpDfecretiro()==null)
					celda.setCellValue(simpleDateFormat.format(experiencia.getExpDfecingreso())+" / "+simpleDateFormat.format(new Date()) +" (Actual)");
				else
					celda.setCellValue(simpleDateFormat.format(experiencia.getExpDfecingreso())+" / "+simpleDateFormat.format(experiencia.getExpDfecretiro()));
				celda = fila.getCell(5);
				celda.setCellStyle(estiloContenido);
				celda.setCellValue(Calculos.diferenciaFechasMes(experiencia.getExpDfecingreso(), experiencia.getExpDfecretiro()));
				filaPendiente++;
				noOrden++;
			}
			
			//
			filaPendiente = filaPendiente+2;
			fila = hoja.getRow(filaPendiente);
			celda = fila.getCell(0);
			texto = new HSSFRichTextString("FIRMA DEL PROFESIONAL:");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);
			hoja.addMergedRegion(new CellRangeAddress(filaPendiente,filaPendiente,0,1));
			//
			filaPendiente = filaPendiente+2;
			fila = hoja.getRow(filaPendiente);
			celda = fila.getCell(0);
			texto = new HSSFRichTextString("(1) Diligenciar únicamente si la profesión esta reglamentada, consignando el número del documento (matrícula o tarjeta) y la fecha a partir de la cual puede ejercer legalmente.");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja.addMergedRegion(new CellRangeAddress(filaPendiente,filaPendiente,0,5));    
			
			//
			filaPendiente = filaPendiente+2;
			fila = hoja.getRow(filaPendiente);
			celda = fila.getCell(0);
			texto = new HSSFRichTextString("NOTAS:");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			//
			celda = fila.getCell(1);
			texto = new HSSFRichTextString("1. El contenido del presente formulario no podrá ser modificado o alterado y deberá ser diligenciado en su totalidad.");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja.addMergedRegion(new CellRangeAddress(filaPendiente,filaPendiente,1,5)); 
			//
			filaPendiente = filaPendiente+1;
			fila = hoja.getRow(filaPendiente);
			celda = fila.getCell(1);
			texto = new HSSFRichTextString("2. La información incluída en el presente formulario es de la responsabilidad del proponente, y deberá allegarse al mismo la documentación que la soporte.");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja.addMergedRegion(new CellRangeAddress(filaPendiente,filaPendiente,1,5)); 
			//
			filaPendiente = filaPendiente+1;
			fila = hoja.getRow(filaPendiente);
			celda = fila.getCell(1);
			texto = new HSSFRichTextString("3. La firma del profesional en este formulario será considerada igualmente como carta de intención.");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja.addMergedRegion(new CellRangeAddress(filaPendiente,filaPendiente,1,5)); 
			
			for (Integer i = 0; i <= 5; i++) {
				hoja.autoSizeColumn(i,true);	
			}

			String rutaSalidaExportacion = ( (GppParametrizacion) parametrizacionService.buscarPorIdParametrizacion(2) ).getParVvalor();
			String nombreArchivo = "FORMATO_HV_INGEOMINAS_"+persona.getPerNidentificacion()+".xls";		
			FileOutputStream formatoExportado = new FileOutputStream(rutaSalidaExportacion+nombreArchivo);
			libro.write(formatoExportado);
			formatoExportado.close();		
			estadoOperacion = true;
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}
}