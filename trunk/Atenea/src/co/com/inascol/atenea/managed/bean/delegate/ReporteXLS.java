package co.com.inascol.atenea.managed.bean.delegate;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import co.com.inascol.atenea.entity.GppDepartamento;
import co.com.inascol.atenea.entity.GppEstadocivil;
import co.com.inascol.atenea.entity.GppExperiencia;
import co.com.inascol.atenea.entity.GppFormacion;
import co.com.inascol.atenea.entity.GppIdioma;
import co.com.inascol.atenea.entity.GppInstitucion;
import co.com.inascol.atenea.entity.GppMunicipio;
import co.com.inascol.atenea.entity.GppPais;
import co.com.inascol.atenea.entity.GppParametrizacion;
import co.com.inascol.atenea.entity.GppPerfilprof;
import co.com.inascol.atenea.entity.GppPersona;
import co.com.inascol.atenea.entity.GppTipodoc;
import co.com.inascol.atenea.logic.DepartamentoService;
import co.com.inascol.atenea.logic.EstadocivilService;
import co.com.inascol.atenea.logic.IdiomaService;
import co.com.inascol.atenea.logic.InstitucionService;
import co.com.inascol.atenea.logic.MunicipioService;
import co.com.inascol.atenea.logic.PaisService;
import co.com.inascol.atenea.logic.ParametrizacionService;
import co.com.inascol.atenea.logic.TipodocService;
import co.com.inascol.atenea.logic.interfaces.IDepartamentoService;
import co.com.inascol.atenea.logic.interfaces.IEstadocivilService;
import co.com.inascol.atenea.logic.interfaces.IIdiomaService;
import co.com.inascol.atenea.logic.interfaces.IInstitucionService;
import co.com.inascol.atenea.logic.interfaces.IMunicipioService;
import co.com.inascol.atenea.logic.interfaces.IPaisService;
import co.com.inascol.atenea.logic.interfaces.IParametrizacionService;
import co.com.inascol.atenea.logic.interfaces.ITipodocService;
import co.com.inascol.atenea.util.Calculos;
/**
 * @author Guillermo Toro
 *
 */
public class ReporteXLS {
	
	private IInstitucionService institucionService;
	private IMunicipioService municipioService;
	private IDepartamentoService departamentoService;
	private IPaisService paisService;
	private IParametrizacionService parametrizacionService;
	private IIdiomaService idiomaService;
	private ITipodocService tipodocService;
	private IEstadocivilService estadocivilService;
	private Boolean estadoOperacion;
	private SimpleDateFormat simpleDateFormat;
	
	public ReporteXLS(){
		municipioService = new MunicipioService();
		parametrizacionService = new ParametrizacionService();
		institucionService = new InstitucionService();
		paisService = new PaisService();
		departamentoService = new DepartamentoService();
		idiomaService = new IdiomaService();
		tipodocService = new TipodocService();
		estadocivilService = new EstadocivilService();
	}
	
	public Boolean generarReporteXLSUpme(GppPersona persona){
		estadoOperacion = false;
		try{
			simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
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
			estiloContenido.setAlignment(HSSFCellStyle.ALIGN_LEFT);
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
			String mpioDomicilio = "";
			if(persona.getMunNmpioresidencia()!=null)
				mpioDomicilio = "Municipio de " + municipioService.buscarPorIdMunicipio(persona.getMunNmpioresidencia()).getMunVmunicipio();
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
			if(persona.getPerVdireccion()!=null)
				texto = new HSSFRichTextString(persona.getPerVdireccion());
			else
				texto = new HSSFRichTextString("");
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
			texto = new HSSFRichTextString("");
			if(persona.getPerVmovil()!=null && persona.getPerVmovil()!=null){
				texto = new HSSFRichTextString(persona.getPerVtelefono()+" / "+persona.getPerVmovil());
			}else{
				if(persona.getPerVmovil()==null)
					texto = new HSSFRichTextString(persona.getPerVtelefono());
				if(persona.getPerVtelefono()==null)
					texto = new HSSFRichTextString(persona.getPerVmovil());
			}
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
				lugarFecha = "Municipio de " + municipioService.buscarPorIdMunicipio(persona.getMunNidmunicipio()).getMunVmunicipio() + ". Fecha: " + simpleDateFormat.format(persona.getPerDfecnacimiento());
			else
				lugarFecha = "Municipio de " + municipioService.buscarPorIdMunicipio(persona.getMunNidmunicipio()).getMunVmunicipio() + ". Fecha: Sin Fecha Registrada";			
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
			
			List<Object> experienciasLaborales = persona.getGppExperienciasLaborales();

			Integer filaPendiente = fila.getRowNum()+1;
			if(experienciasLaborales!=null){
				for (Integer i = filaPendiente; i <= (filaPendiente + experienciasLaborales.size()); i++) {
					fila = hoja.createRow(i);
					for (Integer j = 0; j <= 5; j++) {
						fila.createCell(j).setCellStyle(estiloPlantilla);
					}
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
			texto = new HSSFRichTextString("ACTIVIDAD DESEMPEÑADA");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulo);
			hoja.addMergedRegion(new CellRangeAddress(9,10,2,2));
			
			celda = fila.getCell(3);
			texto = new HSSFRichTextString("FECHA DE");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulo);
			hoja.addMergedRegion(new CellRangeAddress(9,9,3,4));
			
			celda = fila.getCell(5);
			texto = new HSSFRichTextString("DURACIÓN (Años y/o Fracción)");
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

			Double experienciaAnios = Double.valueOf(0);
			Double experienciaMeses = Double.valueOf(0);
			Integer filaInicio = fila.getRowNum()+2;
			if(experienciasLaborales!=null){
				Iterator<Object> itExperiencia = experienciasLaborales.iterator();
				filaPendiente = fila.getRowNum()+1;
				GppExperiencia experiencia = null;
				while(itExperiencia.hasNext()){
					experiencia = (GppExperiencia) itExperiencia.next();
					fila = hoja.getRow(filaPendiente);
					celda = fila.getCell(0);
					celda.setCellStyle(estiloContenido);
					celda = fila.getCell(1);
					celda.setCellStyle(estiloContenido);
					celda.setCellValue(experiencia.getExpVnomempresa());
					celda = fila.getCell(2);
					celda.setCellStyle(estiloContenido);
					if(experiencia.getExpVfuncionlogro()!=null)
						celda.setCellValue(experiencia.getExpVfuncionlogro());
					celda = fila.getCell(3);
					celda.setCellStyle(estiloContenido);
					celda.setCellValue(simpleDateFormat.format(experiencia.getExpDfecingreso()));
					celda = fila.getCell(4);
					celda.setCellStyle(estiloContenido);
					if(experiencia.getExpDfecretiro()==null)
						celda.setCellValue(simpleDateFormat.format(new Date())+" (Actual)");
					else
						celda.setCellValue(simpleDateFormat.format(experiencia.getExpDfecretiro()));
					celda = fila.getCell(5);
					celda.setCellStyle(estiloContenido);
					experienciaAnios = (Calculos.diferenciaFechasDias(experiencia.getExpDfecingreso(), experiencia.getExpDfecretiro()) / 365);
					experienciaMeses = experienciaMeses + (Calculos.diferenciaFechasDias(experiencia.getExpDfecingreso(), experiencia.getExpDfecretiro()) / 30);
					celda.setCellValue(experienciaAnios);
					celda.setCellStyle(estiloContenido);
					filaPendiente++;
				}
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
			hoja.addMergedRegion(new CellRangeAddress(fila.getRowNum(),fila.getRowNum()+1,0,3));
			
			celda = fila.getCell(4);
			celda.setCellStyle(estiloPlantillaTitulo);
			celda.setCellValue(experienciaMeses);
			hoja.addMergedRegion(new CellRangeAddress(fila.getRowNum(),fila.getRowNum()+1,4,4));
			
			celda = fila.getCell(5);
			texto = new HSSFRichTextString("Suma Experiencia Específica");
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
			if(rutaSalidaExportacion!=null){
				String nombreArchivo = "FORMATO_HV_UPME_"+persona.getPerNidentificacion()+".xls";		
				FileOutputStream formatoExportado = new FileOutputStream(rutaSalidaExportacion+nombreArchivo);
				libro.write(formatoExportado);
				formatoExportado.close();		
				estadoOperacion = true;
			}
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}
		
	public Boolean generarReporteXLSIngeominas(GppPersona persona){
		estadoOperacion = false;
		try{
			simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
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
			estiloPlantilla.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			estiloPlantilla.setFont(fuentePlantilla);
			
			HSSFCellStyle estiloContenido = libro.createCellStyle();
			estiloContenido.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			estiloContenido.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			estiloContenido.setBorderRight(HSSFCellStyle.BORDER_THIN);
			estiloContenido.setBorderTop(HSSFCellStyle.BORDER_THIN);
			estiloContenido.setFont(fuenteContenido);
			
			String rutaImagenes = "./report/reporte_ingeominas.png";
			InputStream imagen = ReporteXLS.class.getResourceAsStream(rutaImagenes);
		    byte[] bytes = IOUtils.toByteArray(imagen);
		    int pictureIdx = libro.addPicture(bytes, HSSFWorkbook.PICTURE_TYPE_PNG);
		    imagen.close();
			
		    CreationHelper helper = libro.getCreationHelper();
		    Drawing drawing = hoja.createDrawingPatriarch();
		    ClientAnchor anchor = helper.createClientAnchor();
		    anchor.setCol1(1);
		    anchor.setRow1(2);
		    Picture pict = drawing.createPicture(anchor, pictureIdx);
		    pict.resize();
		    
			for (int i = 0; i <= 1000; i++) {
				fila = hoja.createRow(i);
				for (int j = 0; j <= 50; j++) {
					fila.createCell(j);
				}
			}
			
			hoja.addMergedRegion(new CellRangeAddress(1,10,1,10));
			
			// TITULO
			fila = hoja.getRow(11);
			celda = fila.getCell(1);
			texto = new HSSFRichTextString("HOJA DE VIDA");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantilla);
			for (int i = 2; i <= 10 ; i++) {
				celda = fila.createCell(i);
				celda.setCellStyle(estiloPlantilla);
			}			
			hoja.addMergedRegion(new CellRangeAddress(11,11,1,10));
			//
			fila = hoja.getRow(12);
			celda = fila.getCell(1);
			texto = new HSSFRichTextString("PERSONAL PROFESIONAL PARTICIPANTE");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantilla);
			for (int i = 2; i <= 10 ; i++) {
				celda = fila.createCell(i);
				celda.setCellStyle(estiloPlantilla);
			}							
			hoja.addMergedRegion(new CellRangeAddress(12,12,1,10));

			for (int i = 15; i <= 22; i++) {
				fila = hoja.createRow(i);
				for (int j = 1; j <= 10; j++) {
					fila.createCell(j).setCellStyle(estiloContenido);
				}
			}
			
			// 
			fila = hoja.getRow(15);
			celda = fila.getCell(1);
			texto = new HSSFRichTextString("NOMBRE DEL PROPONENTE:");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			for (int i = 2; i <= 10 ; i++) {
				celda = fila.createCell(i);
				celda.setCellStyle(estiloContenido);
			}
			hoja.addMergedRegion(new CellRangeAddress(15,15,1,10));
			
			// DATOS 			
			fila = hoja.getRow(16);
			celda = fila.getCell(1);
			texto = new HSSFRichTextString("DATOS PERSONALES");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantilla);
			for (int i = 2; i <= 10; i++) {
				celda = fila.getCell(i);
				celda.setCellStyle(estiloPlantilla);				
			}
			hoja.addMergedRegion(new CellRangeAddress(16,16,1,10));
			
			// NOMBRES Y APELLIDOS
			fila = hoja.getRow(17);
			celda = fila.getCell(1);
			texto = new HSSFRichTextString("NOMBRES Y APELLIDOS: " + persona.getPerVnombres()+" "+persona.getPerVapellidos());
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			for (int i = 2; i <= 10; i++) {
				celda = fila.getCell(i);
				celda.setCellStyle(estiloContenido);				
			}
			hoja.addMergedRegion(new CellRangeAddress(17,17,1,10));
			
			// CARGO A OCUPAR
			fila = hoja.getRow(18);
			celda = fila.getCell(1);
			texto = new HSSFRichTextString("CARGO A OCUPAR:");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			for (int i = 2; i <= 10; i++) {
				celda = fila.getCell(i);
				celda.setCellStyle(estiloContenido);				
			}
			hoja.addMergedRegion(new CellRangeAddress(18,18,1,10));
			
			// DOMICILIO			
			fila = hoja.getRow(19);
			celda = fila.getCell(1);
			String mpioDomicilio = "";
			if(persona.getMunNmpioresidencia()!=null)
				mpioDomicilio = "Municipio de " + municipioService.buscarPorIdMunicipio(persona.getMunNmpioresidencia()).getMunVmunicipio();
			texto = new HSSFRichTextString("DOMICILIO: "+ mpioDomicilio);
			celda.setCellValue(texto);
			for (int i = 2; i <= 4; i++) {
				celda = fila.getCell(i);
				celda.setCellStyle(estiloContenido);				
			}
			hoja.addMergedRegion(new CellRangeAddress(19,19,1,4));
			
			// DIRECCIÓN
			celda = fila.getCell(5);
			String direccion = "";
			if(persona.getPerVdireccion()!=null)
				direccion = persona.getPerVdireccion(); 
			texto = new HSSFRichTextString("DIRECCIÓN:" + direccion);
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			for (int i = 6; i <= 10; i++) {
				celda = fila.getCell(i);
				celda.setCellStyle(estiloContenido);				
			}			
			hoja.addMergedRegion(new CellRangeAddress(19,19,5,10));
			
			// TELEFONO
			fila = hoja.getRow(20);
			celda = fila.getCell(1);
			String telefonos = "";
			if(persona.getPerVmovil()!=null && persona.getPerVmovil()!=null){
				telefonos = persona.getPerVtelefono()+" / "+persona.getPerVmovil();
			}else{
				if(persona.getPerVmovil()==null)
					telefonos = persona.getPerVtelefono();
				if(persona.getPerVtelefono()==null)
					telefonos = persona.getPerVmovil();
			}
			texto = new HSSFRichTextString("TELÉFONO:" + telefonos);		
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			for (int i = 2; i <= 4; i++) {
				celda = fila.getCell(i);
				celda.setCellStyle(estiloContenido);				
			}			
			hoja.addMergedRegion(new CellRangeAddress(20,20,1,4));

			// FAX
			celda = fila.getCell(5);
			texto = new HSSFRichTextString("FAX:");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			for (int i = 6; i <= 10; i++) {
				celda = fila.getCell(i);
				celda.setCellStyle(estiloContenido);				
			}				
			hoja.addMergedRegion(new CellRangeAddress(20,20,5,10));
			
			// CEDULA
			fila = hoja.getRow(21);
			celda = fila.getCell(1);
			texto = new HSSFRichTextString("CÉDULA No:" + persona.getPerNidentificacion().toString());
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			for (int i = 2; i <= 4; i++) {
				celda = fila.getCell(i);
				celda.setCellStyle(estiloContenido);				
			}	
			hoja.addMergedRegion(new CellRangeAddress(21,21,1,4));
			
			// PASAPORTE
			celda = fila.getCell(5);
			texto = new HSSFRichTextString("PASAPORTE:");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			for (int i = 6; i <= 10; i++) {
				celda = fila.getCell(i);
				celda.setCellStyle(estiloContenido);				
			}
			hoja.addMergedRegion(new CellRangeAddress(21,21,5,10));
			
			// LUGAR Y FECHA DE NACIMIENTO
			fila = hoja.getRow(22);
			celda = fila.getCell(1);
			String lugarFecha; 
			if(persona.getPerDfecnacimiento()!=null)
				lugarFecha = "Municipio de " + municipioService.buscarPorIdMunicipio(persona.getMunNidmunicipio()).getMunVmunicipio() + ". Fecha: " + simpleDateFormat.format(persona.getPerDfecnacimiento());
			else
				lugarFecha = "Municipio de " + municipioService.buscarPorIdMunicipio(persona.getMunNidmunicipio()).getMunVmunicipio() + ". Fecha: Sin Fecha Registrada";			
			texto = new HSSFRichTextString("LUGAR Y FECHA DE NACIMIENTO:" + lugarFecha);
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja.addMergedRegion(new CellRangeAddress(22,22,1,10));

			// EXPERIENCIA
			fila = hoja.getRow(23);
			celda = fila.getCell(1);
			texto = new HSSFRichTextString("EXPERIENCIA ESPECÍFICA");
			celda.setCellStyle(estiloPlantilla);		
			celda.setCellValue(texto);
			for (int i = 2; i <= 10; i++) {
				celda = fila.getCell(i);
				celda.setCellStyle(estiloPlantilla);				
			}
			hoja.addMergedRegion(new CellRangeAddress(23,23,1,10));

			Integer filaPendiente = fila.getRowNum()+1;

			fila = hoja.getRow(24);
			celda = fila.getCell(1);
			texto = new HSSFRichTextString("IDENTIFICACIÓN DEL PROYECTO");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja.addMergedRegion(new CellRangeAddress(24,26,1,1));
			
			celda = fila.getCell(2);
			texto = new HSSFRichTextString("EJECUCIÓN");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			celda = fila.getCell(3);
			celda.setCellStyle(estiloContenido);			
			hoja.addMergedRegion(new CellRangeAddress(24,25,2,3));
			
			celda = fila.getCell(4);
			texto = new HSSFRichTextString("LOCALIZACIÓN");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja.addMergedRegion(new CellRangeAddress(24,26,4,4));
			
			celda = fila.getCell(5);
			texto = new HSSFRichTextString("ENTIDAD");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			celda = fila.getCell(6);
			celda.setCellStyle(estiloContenido);			
			hoja.addMergedRegion(new CellRangeAddress(24,26,5,5));
			
			celda = fila.getCell(6);
			texto = new HSSFRichTextString("CARGO DESEMPEÑADO");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja.addMergedRegion(new CellRangeAddress(24,26,6,6));

			celda = fila.getCell(7);
			texto = new HSSFRichTextString("DURACIÓN (Meses)");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja.addMergedRegion(new CellRangeAddress(24,26,7,7));

			celda = fila.getCell(8);
			texto = new HSSFRichTextString("FECHA (AAAA/MM/DD)");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			celda = fila.getCell(9);
			celda.setCellStyle(estiloContenido);			
			hoja.addMergedRegion(new CellRangeAddress(24,25,8,9));

			celda = fila.getCell(10);
			texto = new HSSFRichTextString("DEDICACIÓN");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja.addMergedRegion(new CellRangeAddress(24,26,10,10));
			
			fila = hoja.getRow(26);
			celda = fila.getCell(2);
			texto = new HSSFRichTextString("CONTRATO");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			
			celda = fila.getCell(3);
			texto = new HSSFRichTextString("INSTITUCIÓN");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);

			celda = fila.getCell(8);
			texto = new HSSFRichTextString("INICIACIÓN");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			
			celda = fila.getCell(9);
			texto = new HSSFRichTextString("TERMINACIÓN");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			
			List<Object> experienciasLaborales = persona.getGppExperienciasLaborales();
			
			filaPendiente = fila.getRowNum()+1;
			if(experienciasLaborales!=null){
				for (Integer i = filaPendiente; i <= (filaPendiente + experienciasLaborales.size()); i++) {
					fila = hoja.createRow(i);
					for (Integer j = 1; j <= 10; j++) {
						fila.createCell(j).setCellStyle(estiloContenido);
					}
				}
			}
			
			Double experienciaMeses = Double.valueOf(0);
			if(experienciasLaborales!=null){
				Iterator<Object> itExperiencia = experienciasLaborales.iterator();
				GppExperiencia experiencia = null;
				while(itExperiencia.hasNext()){
					experiencia = (GppExperiencia) itExperiencia.next();
					fila = hoja.getRow(filaPendiente);
					celda = fila.getCell(3);
					celda.setCellStyle(estiloContenido);
					celda.setCellValue(experiencia.getExpVnomempresa());
					celda = fila.getCell(4);
					celda.setCellStyle(estiloContenido);
					celda.setCellValue(municipioService.buscarPorIdMunicipio(experiencia.getMunVidmunicipio()).getMunVmunicipio());
					celda = fila.getCell(6);
					celda.setCellStyle(estiloContenido);
					celda.setCellValue(experiencia.getExpVcargo());
					celda = fila.getCell(7);
					celda.setCellStyle(estiloContenido);
					experienciaMeses = (Calculos.diferenciaFechasDias(experiencia.getExpDfecingreso(), experiencia.getExpDfecretiro()) / 30);
					celda.setCellValue(experienciaMeses);				
					celda = fila.getCell(8);
					celda.setCellStyle(estiloContenido);
					celda.setCellValue(simpleDateFormat.format(experiencia.getExpDfecingreso()));
					celda = fila.getCell(9);
					celda.setCellStyle(estiloContenido);
					if(experiencia.getExpDfecretiro()==null)
						celda.setCellValue(simpleDateFormat.format(new Date())+" (Actual)");
					else
						celda.setCellValue(simpleDateFormat.format(experiencia.getExpDfecretiro()));
					filaPendiente++;
				}
			}
			// ACADÉMICO
			fila = hoja.getRow(filaPendiente);
			celda = fila.getCell(1);
			texto = new HSSFRichTextString("NIVEL ACADÉMICO");
			celda.setCellStyle(estiloPlantilla);		
			celda.setCellValue(texto);
			for (int i = 2; i <= 10; i++) {
				celda = fila.getCell(i);
				celda.setCellStyle(estiloPlantilla);				
			}
			hoja.addMergedRegion(new CellRangeAddress(filaPendiente,filaPendiente,1,10));
			
			filaPendiente = filaPendiente+1;
			for (Integer i = filaPendiente; i <= (filaPendiente+1); i++) {
				fila = hoja.createRow(i);
				for (Integer j = 1; j <= 10; j++) {
					fila.createCell(j).setCellStyle(estiloContenido);
				}
			}
			
			fila = hoja.getRow(filaPendiente);
			celda = fila.getCell(1);
			texto = new HSSFRichTextString("TÍTULO");
			celda.setCellStyle(estiloContenido);
			celda.setCellValue(texto);
			hoja.addMergedRegion(new CellRangeAddress(fila.getRowNum(),fila.getRowNum()+1,1,2));
			
			celda = fila.getCell(3);
			celda.setCellStyle(estiloContenido);
			texto = new HSSFRichTextString("INSTITUCIÓN");
			celda.setCellValue(texto);
			hoja.addMergedRegion(new CellRangeAddress(fila.getRowNum(),fila.getRowNum()+1,3,4));
			
			celda = fila.getCell(5);
			texto = new HSSFRichTextString("CIUDAD/PAÍS");
			celda.setCellStyle(estiloContenido);
			celda.setCellValue(texto);
			hoja.addMergedRegion(new CellRangeAddress(fila.getRowNum(),fila.getRowNum()+1,5,6));
			
			celda = fila.getCell(7);
			celda.setCellStyle(estiloContenido);
			texto = new HSSFRichTextString("DURACIÓN (Años)");
			celda.setCellValue(texto);
			hoja.addMergedRegion(new CellRangeAddress(fila.getRowNum(),fila.getRowNum()+1,7,8));
			
			celda = fila.getCell(9);
			celda.setCellStyle(estiloContenido);
			texto = new HSSFRichTextString("FECHA DE GRADO (MM - AAAA)");
			celda.setCellValue(texto);
			hoja.addMergedRegion(new CellRangeAddress(fila.getRowNum(),fila.getRowNum()+1,9,10));
			
			fila = hoja.getRow(filaPendiente+2);
			celda = fila.getCell(9);
			celda.setCellStyle(estiloContenido);
			texto = new HSSFRichTextString("Mes");
			celda.setCellValue(texto);
			
			celda = fila.getCell(10);
			celda.setCellStyle(estiloContenido);
			texto = new HSSFRichTextString("Año");
			celda.setCellValue(texto);

			List<Object> formaciones = persona.getGppFormaciones();
			if(formaciones!=null){
				filaPendiente = filaPendiente+1;
				for (Integer i = filaPendiente; i <= (filaPendiente + formaciones.size()); i++) {
					fila = hoja.createRow(i);
					for (Integer j = 1; j <= 10; j++) {
						fila.createCell(j).setCellStyle(estiloContenido);
					}
				}
			}

			GppFormacion formacion = null;
			if(formaciones!=null){
				Iterator<Object> it = formaciones.iterator();
				filaPendiente = filaPendiente + 1;
				while(it.hasNext()){
					formacion = (GppFormacion) it.next();
					fila = hoja.getRow(filaPendiente);
					celda = fila.getCell(1);
					celda.setCellStyle(estiloContenido);
					celda.setCellValue(formacion.getForVtitulo());
					hoja.addMergedRegion(new CellRangeAddress(fila.getRowNum(),fila.getRowNum(),1,2));
					celda = fila.getCell(3);
					celda.setCellStyle(estiloContenido);
					GppInstitucion institucion = institucionService.buscarPorIdInstitucion(formacion.getInsNidinstitucion());
					if(institucion!=null)
						celda.setCellValue(institucion.getInsVinstitucion());
					hoja.addMergedRegion(new CellRangeAddress(fila.getRowNum(),fila.getRowNum(),3,4));
					celda = fila.getCell(5);
					celda.setCellStyle(estiloContenido);
					hoja.addMergedRegion(new CellRangeAddress(fila.getRowNum(),fila.getRowNum(),5,6));				
					celda = fila.getCell(7);
					celda.setCellStyle(estiloContenido);
					if(formacion.getForNduracionmes()!=null)
						celda.setCellValue(formacion.getForNduracionmes());
					hoja.addMergedRegion(new CellRangeAddress(fila.getRowNum(),fila.getRowNum(),7,8));
					if(formacion.getForDfecgrado()!=null){
						celda = fila.getCell(9);
						celda.setCellStyle(estiloContenido);
						simpleDateFormat = new SimpleDateFormat("MM");	
						celda.setCellValue(simpleDateFormat.format(formacion.getForDfecgrado()));
						celda = fila.getCell(10);
						celda.setCellStyle(estiloContenido);
						simpleDateFormat = new SimpleDateFormat("yyyy");	
						celda.setCellValue(simpleDateFormat.format(formacion.getForDfecgrado()));
					}
					filaPendiente++;
				}
			}
			
			for (int i = 1; i <= 10; i++) {
				hoja.autoSizeColumn(i,true);	
			}
			
			String rutaSalidaExportacion = ( (GppParametrizacion) parametrizacionService.buscarPorIdParametrizacion(2) ).getParVvalor();
			if(rutaSalidaExportacion!=null){
				String nombreArchivo = "FORMATO_HV_INGEOMINAS_"+persona.getPerNidentificacion()+".xls";		
				FileOutputStream formatoExportado = new FileOutputStream(rutaSalidaExportacion+nombreArchivo);
				libro.write(formatoExportado);
				formatoExportado.close();		
				estadoOperacion = true;
			}
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}
	
	public Boolean generarReporteXLSFUHV(GppPersona persona){
		estadoOperacion = false;
		try{
			HSSFWorkbook libro = new HSSFWorkbook();
			HSSFSheet hoja1 = libro.createSheet("Pág._1");
			HSSFRow fila = hoja1.createRow(0);
			HSSFCell celda = fila.createCell(0);
			HSSFRichTextString texto = new HSSFRichTextString();
					
			HSSFFont fuentePlantilla = libro.createFont();
			fuentePlantilla.setFontName("Arial");
			fuentePlantilla.setBoldweight((short)1000);
			fuentePlantilla.setFontHeightInPoints((short)9);
			
			HSSFFont fuenteContenido = libro.createFont();
			fuenteContenido.setFontName("Arial");
			fuenteContenido.setItalic(true);
			fuenteContenido.setFontHeightInPoints((short)6);

			HSSFFont fuenteRelleno = libro.createFont();
			fuenteRelleno.setFontName("Arial");
			fuenteRelleno.setFontHeightInPoints((short)9);
			fuenteRelleno.setColor(IndexedColors.WHITE.getIndex());

			HSSFFont fuenteTitulo = libro.createFont();
			fuenteTitulo.setFontName("Arial");
			fuenteTitulo.setFontHeightInPoints((short)9);
			
			HSSFCellStyle estiloPlantillaTitulos = libro.createCellStyle();
			estiloPlantillaTitulos.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			estiloPlantillaTitulos.setFont(fuentePlantilla);
			
			HSSFCellStyle estiloPlantillaRelleno = libro.createCellStyle();
			estiloPlantillaRelleno.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			estiloPlantillaRelleno.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			estiloPlantillaRelleno.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			estiloPlantillaRelleno.setWrapText(true);
			estiloPlantillaRelleno.setFont(fuenteRelleno);

			HSSFCellStyle estiloPlantillaRelleno2 = libro.createCellStyle();
			estiloPlantillaRelleno2.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			estiloPlantillaRelleno2.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
			estiloPlantillaRelleno2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			estiloPlantillaRelleno2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			estiloPlantillaRelleno2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			estiloPlantillaRelleno2.setBorderRight(HSSFCellStyle.BORDER_THIN);
			estiloPlantillaRelleno2.setBorderTop(HSSFCellStyle.BORDER_THIN);			
			estiloPlantillaRelleno2.setWrapText(true);
			estiloPlantillaRelleno2.setFont(fuenteContenido);
			
			HSSFCellStyle estiloContenidoTitulos = libro.createCellStyle();
			estiloContenidoTitulos.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			estiloContenidoTitulos.setFont(fuenteContenido);
			
			HSSFCellStyle estiloTitulos = libro.createCellStyle();
			estiloTitulos.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			estiloTitulos.setFont(fuenteTitulo);
			
			HSSFCellStyle estiloContenido = libro.createCellStyle();
			estiloContenido.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			estiloContenido.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			estiloContenido.setBorderRight(HSSFCellStyle.BORDER_THIN);
			estiloContenido.setBorderTop(HSSFCellStyle.BORDER_THIN);
			estiloContenido.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			estiloContenido.setWrapText(true);
			estiloContenido.setFont(fuenteContenido);
					
			HSSFCellStyle estiloArriba = libro.createCellStyle();
			estiloArriba.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
			HSSFCellStyle estiloAbajo = libro.createCellStyle();
			estiloAbajo.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
			HSSFCellStyle estiloIzq = libro.createCellStyle();
			estiloIzq.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
			HSSFCellStyle estiloDer = libro.createCellStyle();
			estiloDer.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
			
			for (Integer i = 0; i <= 1000; i++) {
				fila = hoja1.createRow(i);
				for (Integer j = 0; j <= 60; j++) {
					fila.createCell(j);
				}
			}
			
			String rutaImagenes = "./report/escudo.png";
			InputStream imagen = ReporteXLS.class.getResourceAsStream(rutaImagenes);
		    byte[] bytes = IOUtils.toByteArray(imagen);
		    int pictureIdx = libro.addPicture(bytes, HSSFWorkbook.PICTURE_TYPE_PNG);
		    imagen.close();
			
		    CreationHelper helper = libro.getCreationHelper();
		    Drawing drawing = hoja1.createDrawingPatriarch();
		    ClientAnchor anchor = helper.createClientAnchor();
		    anchor.setCol1(4);
		    anchor.setRow1(1);
		    Picture pict = drawing.createPicture(anchor, pictureIdx);
		    pict.resize();
			
			
			// ENCABEZADO
			Integer numFila = 1;
			Integer numColumna = 1;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("FORMATO ÚNICO");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloTitulos);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+54));
			// 
			numFila += 1;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("HOJA DE VIDA");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+54));
			//
			numFila += 1;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("Persona Natural");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloTitulos);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+54));
			// 
			numFila += 1;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("(Leyes 190 de 1995, 489 y 443 de 1998)");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloTitulos);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+54));
			
			for (int i = 1; i <= 55; i++) {
				fila = hoja1.getRow(0);
				celda = fila.getCell(i);
				celda.setCellStyle(estiloArriba);
			}
			for (int i = 1; i <= 55; i++) {
				fila = hoja1.getRow(5);
				celda = fila.getCell(i);
				celda.setCellStyle(estiloAbajo);
			}
			for (int i = 0; i <= 5; i++) {
				fila = hoja1.getRow(i);
				celda = fila.getCell(0);
				celda.setCellStyle(estiloDer);
			}
			for (int i = 0; i <= 5; i++) {
				fila = hoja1.getRow(i);
				celda = fila.getCell(56);
				celda.setCellStyle(estiloIzq);
			}
			
			// 
			numFila += 3;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("1. DATOS PERSONALES");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaRelleno);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+16));
			// 
			numFila += 2;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("PRIMER APELLIDO");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenidoTitulos);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+16));
			// 
			numColumna = 18;
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("SEGUNDO APELLIDO (O DE CASADA)");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenidoTitulos);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+16));
			// 
			numColumna = 35;
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("NOMBRES");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenidoTitulos);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+20));
			for (int i = 1; i <= 55; i++) {
				celda = fila.getCell(i);
				celda.setCellStyle(estiloContenido);				
			}
			// 
			String [] nombreApellido = persona.getPerVapellidos().split("\\s+");
			numFila += 1;
			numColumna = 1;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString(nombreApellido[0]);
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+16));
			// 
			numColumna = 18;
			celda = fila.getCell(numColumna);
			if(nombreApellido.length>=2)
				texto = new HSSFRichTextString(nombreApellido[1]);
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+16));
			// 
			numColumna = 35;
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString(persona.getPerVnombres());
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+20));	
			for (int i = 1; i <= 55; i++) {
				celda = fila.getCell(i);
				celda.setCellStyle(estiloContenido);				
			}
			// 
			numFila += 1;
			numColumna = 1;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("DOCUMENTO DE IDENTIFICACIÓN");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+22));
			// 
			numColumna = 24;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("SEXO");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+5));
			// 
			numColumna = 30;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("NACIONALIDAD");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+12));
			// 
			numColumna = 43;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("PAÍS");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+12));
			for (int i = 1; i <= 55; i++) {
				celda = fila.getCell(i);
				celda.setCellStyle(estiloContenido);				
			}
			// 
			numFila += 1;
			numColumna = 1;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("C.C.");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 3;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			if(persona.getTdcNidtipodoc()==1)
				texto = new HSSFRichTextString("X");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			// 
			numColumna = 4;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("C.E.");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 6;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			if(persona.getTdcNidtipodoc()==3)
				texto = new HSSFRichTextString("X");
			else
				texto = new HSSFRichTextString("");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			// 
			numColumna = 7;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("PAS");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 9;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			if(persona.getTdcNidtipodoc()==7)				
				texto = new HSSFRichTextString("X");
			else
				texto = new HSSFRichTextString("");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			// 
			numColumna = 10;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("No.");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+2));
			// 
			numColumna = 13;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString(persona.getPerNidentificacion().toString());
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+10));
			// 
			numColumna = 24;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("F");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 26;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			if(persona.getPerVsexo().equalsIgnoreCase("M"))
				texto = new HSSFRichTextString("X");
			else
				texto = new HSSFRichTextString("");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			// 
			numColumna = 27;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("M");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 29;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			if(persona.getPerVsexo().equalsIgnoreCase("H"))
				texto = new HSSFRichTextString("X");
			else
				texto = new HSSFRichTextString("");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			// 
			numColumna = 30;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("COL");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+2));
			// 
			numColumna = 33;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			if(persona.getPaiNpaisresidencia()==1)
				texto = new HSSFRichTextString("X");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 35;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("EXTRANJERO");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+6));
			// 
			numColumna = 42;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			if(persona.getPaiNpaisresidencia()>1)
				texto = new HSSFRichTextString("X");
			else
				texto = new HSSFRichTextString("");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			//
			GppMunicipio mpio = municipioService.buscarPorIdMunicipio(persona.getMunNidmunicipio());
			GppDepartamento depto = departamentoService.buscarPorIdDepartamento(mpio.getDptNiddepto());
			GppPais pais = paisService.buscarPorIdPais(depto.getPaiNidpais());
			GppMunicipio mpioResidencia = null;
			GppDepartamento deptoResidencia = null;
			GppPais paisResidencia = null;
			if(persona.getMunNmpioresidencia()!=null){
				mpioResidencia = municipioService.buscarPorIdMunicipio(persona.getMunNmpioresidencia());
				deptoResidencia = departamentoService.buscarPorIdDepartamento(mpioResidencia.getDptNiddepto());
				paisResidencia = paisService.buscarPorIdPais(persona.getPaiNpaisresidencia());
			}
			numColumna = 43;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			if(pais.getPaiVpais()!=null)
				texto = new HSSFRichTextString(pais.getPaiVpais());
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+12));
			for (int i = 1; i <= 55; i++) {
				celda = fila.getCell(i);
				celda.setCellStyle(estiloContenido);				
			}
			// 
			numFila +=1;
			numColumna = 1;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("LIBRETA MILITAR");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			celda = fila.getCell(55);
			celda.setCellStyle(estiloContenido);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+54));
			// 
			numFila +=1;
			numColumna = 1;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("PRIMERA CLASE");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+7));			
			// 
			numColumna = 9;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+4));
			// 
			numColumna = 14;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("SEGUNDA CLASE");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+7));
			// 
			numColumna = 22;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 24;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("NÚMERO");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+6));
			// 
			numColumna = 31;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			if(persona.getPerVlibretamilitar()!=null)
				texto = new HSSFRichTextString(persona.getPerVlibretamilitar());
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+10));
			// 
			numColumna = 42;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("DM");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+2));
			// 
			numColumna = 45;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			celda = fila.getCell(55);
			celda.setCellStyle(estiloContenido);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+10));			
			// 
			numFila += 1;
			numColumna = 1;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("FECHA Y LUGAR DE NACIMIENTO");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+25));
			// 
			numColumna = 27;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("DIRECCIÓN DE CORRESPONDENCIA");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);	
			celda = fila.getCell(55);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+28));	
			// 
			numFila += 1;
			numColumna = 1;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("FECHA");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+5));
			// 
			numColumna = 7;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("DÍA");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+2));
			// 
			numColumna = 10;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			simpleDateFormat = new SimpleDateFormat("dd");
			if(persona.getPerDfecnacimiento()!=null)
				texto = new HSSFRichTextString(simpleDateFormat.format(persona.getPerDfecnacimiento()));
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+2));
			// 
			numColumna = 13;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("MES");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+2));
			// 
			numColumna = 16;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			simpleDateFormat = new SimpleDateFormat("MM");
			if(persona.getPerDfecnacimiento()!=null)
				texto = new HSSFRichTextString(simpleDateFormat.format(persona.getPerDfecnacimiento()));
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+2));
			// 
			numColumna = 19;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("AÑO");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+2));
			// 
			numColumna = 22;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			simpleDateFormat = new SimpleDateFormat("yyyy");
			if(persona.getPerDfecnacimiento()!=null)
				texto = new HSSFRichTextString(simpleDateFormat.format(persona.getPerDfecnacimiento()));
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+4));
			// 
			numColumna = 27;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString(persona.getPerVdireccion());
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);	
			celda = fila.getCell(55);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+28));
			// 
			numFila += 1;
			numColumna = 1;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("PAÍS");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+5));
			// 
			numColumna = 7;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			if(pais.getPaiVpais()!=null)
				texto = new HSSFRichTextString(pais.getPaiVpais());
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+19));			
			// 
			numColumna = 27;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("PAÍS");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+2));
			// 
			numColumna = 30;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			if(paisResidencia.getPaiVpais()!=null)
				texto = new HSSFRichTextString(paisResidencia.getPaiVpais());
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+10));			
			// 
			numColumna = 41;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("DEPTO");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+3));
			// 
			numColumna = 45;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			if(deptoResidencia.getDptVdepto()!=null)
				texto = new HSSFRichTextString(deptoResidencia.getDptVdepto());
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			celda = fila.getCell(55);
			celda.setCellStyle(estiloContenido);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+10));			
			// 
			numFila += 1;
			numColumna = 1;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("DEPTO");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+5));
			// 
			numColumna = 7;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			if(depto.getDptVdepto()!=null)
				texto = new HSSFRichTextString(depto.getDptVdepto());
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);	
			celda = fila.getCell(54);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+19));
			// 
			numColumna = 27;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("MUNICIPIO");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+4));
			// 
			numColumna = 32;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			if(mpioResidencia.getMunVmunicipio()!=null)
				texto = new HSSFRichTextString(mpioResidencia.getMunVmunicipio());
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);	
			celda = fila.getCell(55);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+23));			
			// 
			numFila += 1;
			numColumna = 1;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("MUNICIPIO");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+5));
			// 
			numColumna = 7;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			if(mpio.getMunVmunicipio()!=null)
				texto = new HSSFRichTextString(mpio.getMunVmunicipio());
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+19));
			// 
			numColumna = 27;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("TELÉFONO");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+4));
			// 
			numColumna = 32;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("");
			if(persona.getPerVmovil()!=null && persona.getPerVmovil()!=null){
				texto = new HSSFRichTextString(persona.getPerVtelefono()+" / "+persona.getPerVmovil());
			}else{
				if(persona.getPerVmovil()==null)
					texto = new HSSFRichTextString(persona.getPerVtelefono());
				if(persona.getPerVtelefono()==null)
					texto = new HSSFRichTextString(persona.getPerVmovil());
			}
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+8));
			// 
			numColumna = 41;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("EMAIL");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+2));
			// 
			numColumna = 44;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			if(persona.getPerVemail()!=null)
				texto = new HSSFRichTextString(persona.getPerVemail());
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);		
			celda = fila.getCell(55);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+11));
			//
			for (int i = 1; i <= 55; i++) {
				fila = hoja1.getRow(8);
				celda = fila.getCell(i);
				celda.setCellStyle(estiloAbajo);
			}			
			for (int i = 1; i <= 55; i++) {
				fila = hoja1.getRow(20);
				celda = fila.getCell(i);
				celda.setCellStyle(estiloArriba);
			}
			for (int i = 9; i <= 19; i++) {
				fila = hoja1.getRow(i);
				celda = fila.getCell(0);
				celda.setCellStyle(estiloDer);
			}
			for (int i = 9; i <= 19; i++) {
				fila = hoja1.getRow(i);
				celda = fila.getCell(56);
				celda.setCellStyle(estiloIzq);
			}
			
			// 
			numFila += 2;
			numColumna = 1;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("2. FORMACIÓN ACADÉMICA");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaRelleno);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+20));
			// 
			numFila += 2;
			numColumna = 1;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("EDUCACIÓN BÁSICA Y MEDIA");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			celda = fila.getCell(numColumna+54);
			celda.setCellStyle(estiloContenido);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+54));						
			// 
			numFila += 1;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("MARQUE CON UNA X EL ÚLTIMO GRADO APROBADO (LOS GRADOS DE 1o. A 6o. DE BACHILLERATO, EQUIVALEN A LOS GRADOS 6o. A 11o. DE EDUCACIÓN BÁSICA SECUNDARIA Y MEDIA).");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			celda = fila.getCell(55);
			celda.setCellStyle(estiloContenido);
			fila = hoja1.getRow(numFila+1);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila+1,numColumna,numColumna+54));
			for (int i = 1; i <= 55; i++) {
				celda = fila.getCell(i);
				celda.setCellStyle(estiloContenido);
			}
			// 
			numFila += 3;
			numColumna = 5;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("EDUCACIÓN BÁSICA");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaRelleno2);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+21));						
			// 
			numColumna = 27;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("TÍTULO OBTENIDO");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+9));			
			//
			List<Object> formaciones = persona.getGppFormaciones();
			GppFormacion formacion = null;
			Boolean cursoBachillerato = false;
			if(formaciones!=null){
				if(formaciones.size()>0){
					Iterator<Object> itFormaciones = formaciones.iterator(); 
					while(itFormaciones.hasNext()){
						formacion = (GppFormacion) itFormaciones.next();
						if(formacion.getNacNidnivelac()==1){
							cursoBachillerato = false;
							break;
						}
						if(formacion.getNacNidnivelac()>=3 && formacion.getNacNidnivelac()<=9)
							cursoBachillerato = true;
					}
				}
			}
			numColumna = 37;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			if(formacion!=null && cursoBachillerato==false)
				texto = new HSSFRichTextString(formacion.getForVtitulo());
			else{
				if(cursoBachillerato==true)
					texto = new HSSFRichTextString("Bachiller");
			}
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);	
			celda = fila.getCell(50);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+13));			
			// 
			numFila += 1;
			numColumna = 5;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("PRIMARIA");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaRelleno2);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+9));						
			// 
			numColumna = 15;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("SECUNDARIA");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaRelleno2);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+7));			
			// 
			numColumna = 23;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("MEDIA");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaRelleno2);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+3));			
			// 
			numColumna = 27;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("FECHA DE GRADO");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaRelleno2);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+23));			
			// 
			numFila += 1;
			numColumna = 5;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("1o");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));			
			// 
			numColumna = 7;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("2o");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 9;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("3o");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 11;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("4o");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 13;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("5o");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 15;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("6o");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 17;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("7o");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 19;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("8o");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 21;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("9o");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 23;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("10o");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 25;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("11o");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			celda = fila.getCell(26);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 31;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("MES");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			celda = fila.getCell(33);
			celda.setCellStyle(estiloContenido);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+2));
			// 
			numColumna = 34;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			if(formacion!=null && cursoBachillerato==false){
				simpleDateFormat = new SimpleDateFormat("MM");
				texto = new HSSFRichTextString(simpleDateFormat.format(formacion.getForDfecgrado()));
			}
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);	
			celda = fila.getCell(36);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+2));			
			// 
			numColumna = 40;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("AÑO");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+2));
			// 
			numColumna = 43;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			if(formacion!=null && cursoBachillerato==false){
				simpleDateFormat = new SimpleDateFormat("yyyy");
				texto = new HSSFRichTextString(simpleDateFormat.format(formacion.getForDfecgrado()));
			}
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			celda = fila.getCell(47);
			celda.setCellStyle(estiloContenido);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+4));
			//
			for (int i = 5; i <= 50; i++) {
				fila = hoja1.getRow(26);
				celda = fila.getCell(i);
				celda.setCellStyle(estiloAbajo);
			}			
			for (int i = 5; i <= 50; i++) {
				fila = hoja1.getRow(30);
				celda = fila.getCell(i);
				celda.setCellStyle(estiloArriba);
			}
			for (int i = 27; i <= 29; i++) {
				fila = hoja1.getRow(i);
				celda = fila.getCell(4);
				celda.setCellStyle(estiloDer);
			}
			for (int i = 27; i <= 29; i++) {
				fila = hoja1.getRow(i);
				celda = fila.getCell(51);
				celda.setCellStyle(estiloIzq);
			}
			// 
			numFila += 2;
			numColumna = 1;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("EDUCACIÓN SUPERIOR (PREGRADO Y POSTGRADO)");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);		
			celda = fila.getCell(55);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+54));				
			// 
			numFila += 1;
			numColumna = 1;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("DILIGENCIE ESTE PUNTO EN ESTRICTO ORDEN CRONOLÓGICO, EN MODALIDAD ACADÉMICA ESCRIBA:");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);	
			celda = fila.getCell(55);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+54));				
			// 
			numFila += 1;
			numColumna = 1;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("TC");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));	
			// 
			numColumna = 3;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("(TÉCNICA).");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+8));
			// 
			numColumna = 12;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("TL");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 14;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("(TECNOLÓGICA),");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+11));
			// 
			numColumna = 26;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("TE");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 28;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("(TECNOLÓGICA ESPECIALIZADA),");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+14));
			// 
			numColumna = 43;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("UN");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 45;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("(UNIVERSITARIA)");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			celda = fila.getCell(55);
			celda.setCellStyle(estiloContenido);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+10));
			// 
			numFila += 1;
			numColumna = 1;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("ES");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);	
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 3;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("(ESPECIALIZACIÓN),");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+8));
			// 
			numColumna = 12;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString(" MG");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);		
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 14;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("(MAESTRÍA O MAGÍSTER),");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+11));
			// 
			numColumna = 26;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("DOC");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);	
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 28;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("(DOCTORADO O PHD),");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			celda = fila.getCell(42);
			celda.setCellStyle(estiloContenido);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+14));
			// 
			numFila += 1;
			numColumna = 1;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("RELACIONE AL FRENTE EL NÚMERO DE LA TARJETA PROFESIONAL (SI ÉSTA HA SIDO PREVISTA EN UNA LEY).");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+54));		
			// 
			numFila += 1;
			numColumna = 1;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("MODALIDAD ACADÉMICA");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaRelleno2);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila+1,numColumna,numColumna+6));			
			// 
			numColumna = 8;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("N° DE SEMESTRES APROBADOS");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaRelleno2);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila+1,numColumna,numColumna+7));			
			// 
			numColumna = 16;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("GRADUADO");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaRelleno2);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+5));
			// 
			numColumna = 22;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("NOMBRE DE LOS ESTUDIOS O TÍTULOS OBTENIDOS");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaRelleno2);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila+1,numColumna,numColumna+15));
			// 
			numColumna = 38;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("TERMINACIÓN");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaRelleno2);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+6));			
			// 
			numColumna = 45;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("N° DE TARJETA PROFESIONAL");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaRelleno2);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila+1,numColumna,numColumna+10));
			// 
			numFila += 1;
			numColumna = 16;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("SI");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaRelleno2);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+2));
			// 
			numColumna = 19;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("NO");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaRelleno2);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+2));			
			// 
			numColumna = 38;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("MES");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaRelleno2);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+2));
			// 
			numColumna = 41;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("AÑO");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaRelleno2);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+3));
			
			// formaciones academicas
			int filaFormaciones = numFila + 1;
			int contadorControl = 1;
			formaciones = persona.getGppFormaciones();
			formacion = null;
			if(formaciones!=null){
				if(formaciones.size()>0){
					Iterator<Object> itFormaciones = formaciones.iterator();
					while(itFormaciones.hasNext()){
						formacion = (GppFormacion) itFormaciones.next();
						if(formacion.getNacNidnivelac()>=2 && formacion.getNacNidnivelac()<=9 && contadorControl<=5){
							numFila = filaFormaciones;
							numColumna = 1;
							fila = hoja1.getRow(numFila);
							celda = fila.getCell(numColumna);
							if(formacion.getNacNidnivelac()==2)
								texto = new HSSFRichTextString("TE");
							else if(formacion.getNacNidnivelac()==3)
								texto = new HSSFRichTextString("UN");
							else if(formacion.getNacNidnivelac()==4)
								texto = new HSSFRichTextString("ES");
							else if(formacion.getNacNidnivelac()==5 || formacion.getNacNidnivelac()==6)
								texto = new HSSFRichTextString("MG");
							else if(formacion.getNacNidnivelac()==7)
								texto = new HSSFRichTextString("DOC");
							else if(formacion.getNacNidnivelac()==8)
								texto = new HSSFRichTextString("TL");
							else if(formacion.getNacNidnivelac()==9)
								texto = new HSSFRichTextString("TE");	
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+6));			
							// 
							numColumna = 8;
							fila = hoja1.getRow(numFila);
							celda = fila.getCell(numColumna);
							if(formacion.getForNduracionmes()!=null)
								texto = new HSSFRichTextString(String.valueOf(formacion.getForNduracionmes()*2));
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+7));			
							// 
							numColumna = 16;
							fila = hoja1.getRow(numFila);
							celda = fila.getCell(numColumna);
							if(formacion.getForDfecgrado()!=null)
								texto = new HSSFRichTextString("X");
							else
								texto = new HSSFRichTextString("");
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+2));
							// 
							numColumna = 19;
							fila = hoja1.getRow(numFila);
							celda = fila.getCell(numColumna);
							if(formacion.getForDfecgrado()==null)
								texto = new HSSFRichTextString("X");
							else
								texto = new HSSFRichTextString("");
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+2));		
							// 
							numColumna = 22;
							fila = hoja1.getRow(numFila);
							celda = fila.getCell(numColumna);
							texto = new HSSFRichTextString(formacion.getForVtitulo());
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+15));
							// 
							numColumna = 38;
							celda = fila.getCell(numColumna);
							if(formacion.getForDfecgrado()!=null){
								simpleDateFormat = new SimpleDateFormat("MM");
								texto = new HSSFRichTextString(simpleDateFormat.format(formacion.getForDfecgrado()));
							}
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+2));
							// 
							numColumna = 41;
							fila = hoja1.getRow(numFila);
							celda = fila.getCell(numColumna);
							if(formacion.getForDfecgrado()!=null){
								simpleDateFormat = new SimpleDateFormat("yyyy");
								texto = new HSSFRichTextString(simpleDateFormat.format(formacion.getForDfecgrado()));
							}
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+3));	
							// 
							numColumna = 45;
							fila = hoja1.getRow(numFila);
							celda = fila.getCell(numColumna);
							if(formacion.getForVtarjetaprof()!=null)
								texto = new HSSFRichTextString(formacion.getForVtarjetaprof());
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+10));
							filaFormaciones++;
							contadorControl++;
						}
					}
				}
			}
			for (int i = 1; i <= (6-contadorControl); i++) {
				numFila = filaFormaciones;
				numColumna = 1;
				fila = hoja1.getRow(numFila);
				celda = fila.getCell(numColumna);
				celda.setCellStyle(estiloContenido);			
				hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+6));			
				// 
				numColumna = 8;
				fila = hoja1.getRow(numFila);
				celda = fila.getCell(numColumna);
				celda.setCellStyle(estiloContenido);			
				hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+7));			
				// 
				numColumna = 16;
				fila = hoja1.getRow(numFila);
				celda = fila.getCell(numColumna);
				celda.setCellStyle(estiloContenido);			
				hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+2));
				// 
				numColumna = 19;
				fila = hoja1.getRow(numFila);
				celda = fila.getCell(numColumna);
				celda.setCellStyle(estiloContenido);			
				hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+2));		
				// 
				numColumna = 22;
				fila = hoja1.getRow(numFila);
				celda = fila.getCell(numColumna);
				celda.setCellStyle(estiloContenido);			
				hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+15));
				// 
				numColumna = 38;
				celda = fila.getCell(numColumna);
				celda.setCellStyle(estiloContenido);			
				hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+2));
				// 
				numColumna = 41;
				fila = hoja1.getRow(numFila);
				celda = fila.getCell(numColumna);
				celda.setCellStyle(estiloContenido);			
				hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+3));	
				// 
				numColumna = 45;
				fila = hoja1.getRow(numFila);
				celda = fila.getCell(numColumna);
				celda.setCellStyle(estiloContenido);			
				hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+10));
				filaFormaciones++;
			}
			for (int i = 38; i <= 42; i++) {
				fila = hoja1.getRow(i);
				celda = fila.getCell(55);
				celda.setCellStyle(estiloContenido);
			}
			// 
			numFila+= 2;
			numColumna = 1;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("ESPECIFIQUE LOS IDIOMAS DIFERENTES AL ESPAÑOL QUE: HABLA , LEE, ESCRIBE DE FORMA, REGULAR (R), BIEN (B) O MUY BIEN (MB)");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);	
			celda = fila.getCell(55);
			celda.setCellStyle(estiloContenido);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila+1,numColumna,numColumna+54));
			fila = hoja1.getRow(numFila+1);
			for (int i = 1; i <= 55; i++) {
				celda = fila.getCell(i);
				celda.setCellStyle(estiloContenido);
			}
			// 
			numFila+= 2;
			numColumna = 13;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("IDIOMA");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaRelleno2);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila+1,numColumna,numColumna+12));
			// 
			numColumna = 26;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("LO HABLA");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaRelleno2);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+5));
			// 
			numColumna = 32;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("LO LEE");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaRelleno2);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+5));
			// 
			numColumna = 38;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("LO ESCRIBE");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaRelleno2);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+5));						
			// 
			numFila+= 1;
			numColumna = 26;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("R");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaRelleno2);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 28;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("B");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaRelleno2);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));			
			// 
			numColumna = 30;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("MB");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaRelleno2);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 32;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("R");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaRelleno2);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 34;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("B");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaRelleno2);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 36;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("MB");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaRelleno2);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 38;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("R");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaRelleno2);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 40;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("B");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaRelleno2);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 42;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("MB");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaRelleno2);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			GppPerfilprof perfil = null;
			GppIdioma idioma1 = null;
			GppIdioma idioma2 = null; 
			if(persona.getGppPerfilprofesional()!=null){
				perfil = persona.getGppPerfilprofesional();
				if(perfil.getIdiNididioma1()!=null)
					idioma1 = idiomaService.buscarPorIdIdioma(perfil.getIdiNididioma1());
				if(perfil.getIdiNididioma2()!=null)
					idioma2 = idiomaService.buscarPorIdIdioma(perfil.getIdiNididioma2());
			}
			numFila+= 1;
			numColumna = 13;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("");
			if(idioma1!=null)
				texto = new HSSFRichTextString(idioma1.getIdiVidioma());
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+12));
			// 
			numColumna = 26;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			if(perfil!=null){
				if(perfil.getPprNnivelidi1()<35)
					texto = new HSSFRichTextString("X");
				else
					texto = new HSSFRichTextString("");
			}else{
				texto = new HSSFRichTextString("");
			}
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 28;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			if(perfil!=null){
				if(perfil.getPprNnivelidi1()>35 && perfil.getPprNnivelidi1()<70)
					texto = new HSSFRichTextString("X");
				else
					texto = new HSSFRichTextString("");
			}else{
				texto = new HSSFRichTextString("");
			}				
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));			
			// 
			numColumna = 30;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			if(perfil!=null){
				if(perfil.getPprNnivelidi1()>70)
					texto = new HSSFRichTextString("X");
				else
					texto = new HSSFRichTextString("");
			}else{
				texto = new HSSFRichTextString("");
			}			
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 32;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			if(perfil!=null){
				if(perfil.getPprNnivelidi1()<35)
					texto = new HSSFRichTextString("X");
				else
					texto = new HSSFRichTextString("");
			}else{
				texto = new HSSFRichTextString("");
			}					
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 34;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			if(perfil!=null){
				if(perfil.getPprNnivelidi1()>35 && perfil.getPprNnivelidi1()<70)
					texto = new HSSFRichTextString("X");
				else
					texto = new HSSFRichTextString("");
			}else{
				texto = new HSSFRichTextString("");
			}				
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 36;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			if(perfil!=null){
				if(perfil.getPprNnivelidi1()>70)
					texto = new HSSFRichTextString("X");
				else
					texto = new HSSFRichTextString("");
			}else{
				texto = new HSSFRichTextString("");
			}								
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 38;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			if(perfil!=null){
				if(perfil.getPprNnivelidi1()<35)
					texto = new HSSFRichTextString("X");
				else
					texto = new HSSFRichTextString("");
			}else{
				texto = new HSSFRichTextString("");
			}						
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 40;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			if(perfil!=null){
				if(perfil.getPprNnivelidi1()>35 && perfil.getPprNnivelidi1()<70)
					texto = new HSSFRichTextString("X");
				else
					texto = new HSSFRichTextString("");
			}else{
				texto = new HSSFRichTextString("");
			}					
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 42;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			if(perfil!=null){
				if(perfil.getPprNnivelidi1()>70)
					texto = new HSSFRichTextString("X");
				else
					texto = new HSSFRichTextString("");
			}else{
				texto = new HSSFRichTextString("");
			}					
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			celda = fila.getCell(43);
			celda.setCellStyle(estiloContenido);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numFila+= 1;
			numColumna = 13;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			if(idioma2!=null)
				texto = new HSSFRichTextString(idioma2.getIdiVidioma());
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+12));
			// 
			numColumna = 26;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			if(perfil!=null){
				if(perfil.getPprNnivelidi2()<35)
					texto = new HSSFRichTextString("X");
				else
					texto = new HSSFRichTextString("");
			}else{
				texto = new HSSFRichTextString("");
			}						
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 28;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			if(perfil!=null){
				if(perfil.getPprNnivelidi2()>35 && perfil.getPprNnivelidi2()<70)
					texto = new HSSFRichTextString("X");
				else
					texto = new HSSFRichTextString("");
			}else{
				texto = new HSSFRichTextString("");
			}					
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));			
			// 
			numColumna = 30;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			if(perfil!=null){			
				if(perfil.getPprNnivelidi2()>70)
					texto = new HSSFRichTextString("X");
				else
					texto = new HSSFRichTextString("");
			}else{
				texto = new HSSFRichTextString("");
			}					
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 32;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			if(perfil!=null){	
				if(perfil.getPprNnivelidi2()<35)
					texto = new HSSFRichTextString("X");
				else
					texto = new HSSFRichTextString("");
			}else{
				texto = new HSSFRichTextString("");
			}							
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 34;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			if(perfil!=null){	
				if(perfil.getPprNnivelidi2()>35 && perfil.getPprNnivelidi2()<70)
					texto = new HSSFRichTextString("X");
				else
					texto = new HSSFRichTextString("");
			}else{
				texto = new HSSFRichTextString("");
			}					
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 36;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			if(perfil!=null){	
				if(perfil.getPprNnivelidi2()>70)
					texto = new HSSFRichTextString("X");
				else
					texto = new HSSFRichTextString("");
			}else{
				texto = new HSSFRichTextString("");
			}						
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 38;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			if(perfil!=null){
				if(perfil.getPprNnivelidi2()<35)
					texto = new HSSFRichTextString("X");
				else
					texto = new HSSFRichTextString("");
			}else{
				texto = new HSSFRichTextString("");
			}					
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 40;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			if(perfil!=null){
				if(perfil.getPprNnivelidi2()>35 && perfil.getPprNnivelidi2()<70)
					texto = new HSSFRichTextString("X");
				else
					texto = new HSSFRichTextString("");
			}else{
				texto = new HSSFRichTextString("");
			}						
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			// 
			numColumna = 42;
			fila = hoja1.getRow(numFila);
			celda = fila.getCell(numColumna);
			if(perfil!=null){
				if(perfil.getPprNnivelidi2()>70)
					texto = new HSSFRichTextString("X");
				else
					texto = new HSSFRichTextString("");
			}else{
				texto = new HSSFRichTextString("");
			}						
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			celda = fila.getCell(43);
			celda.setCellStyle(estiloContenido);
			hoja1.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			//
			for (int i = 1; i <= 55; i++) {
				fila = hoja1.getRow(22);
				celda = fila.getCell(i);
				celda.setCellStyle(estiloAbajo);
			}			
			for (int i = 1; i <= 55; i++) {
				fila = hoja1.getRow(51);
				celda = fila.getCell(i);
				celda.setCellStyle(estiloArriba);
			}
			for (int i = 23; i <= 50; i++) {
				fila = hoja1.getRow(i);
				celda = fila.getCell(0);
				celda.setCellStyle(estiloDer);
			}
			for (int i = 23; i <= 50; i++) {
				fila = hoja1.getRow(i);
				celda = fila.getCell(56);
				celda.setCellStyle(estiloIzq);
			}
			
			// hoja 2	
			
			if(persona.getGppExperienciasLaborales()!=null){
				List<Object> experiencias = persona.getGppExperienciasLaborales();
				if(experiencias.size()>0){
					Iterator<Object> itExperiencias = experiencias.iterator(); 
					GppExperiencia experiencia = null;
					Double tamanio = Double.valueOf(experiencias.size());
					Double paginasExperiencia = tamanio / 4; 
					if(paginasExperiencia==0)
						paginasExperiencia = Double.valueOf(1);
					else{
						if(paginasExperiencia - paginasExperiencia.intValue()>0) 
							paginasExperiencia++;
					}
							
					for (int k = 1; k <= paginasExperiencia; k++) {
						HSSFSheet hoja2 = libro.createSheet("Pág._2_"+k);
						fila = hoja2.createRow(0);
						celda = fila.createCell(0);
						texto = new HSSFRichTextString();
			
						for (Integer i = 0; i <= 1000; i++) {
							fila = hoja2.createRow(i);
							for (Integer j = 0; j <= 60; j++) {
								fila.createCell(j);
							}
						}
						
						// ENCABEZADO
						numFila = 1;
						numColumna = 1;
						fila = hoja2.getRow(numFila);
						celda = fila.getCell(numColumna);
						texto = new HSSFRichTextString("FORMATO ÚNICO");
						celda.setCellValue(texto);
						celda.setCellStyle(estiloTitulos);
						hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+54));
						// 
						numFila += 1;
						fila = hoja2.getRow(numFila);
						celda = fila.getCell(numColumna);
						texto = new HSSFRichTextString("HOJA DE VIDA");
						celda.setCellValue(texto);
						celda.setCellStyle(estiloPlantillaTitulos);
						hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+54));
						//
						numFila += 1;
						fila = hoja2.getRow(numFila);
						celda = fila.getCell(numColumna);
						texto = new HSSFRichTextString("Persona Natural");
						celda.setCellValue(texto);
						celda.setCellStyle(estiloTitulos);
						hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+54));
						// 
						numFila += 1;
						fila = hoja2.getRow(numFila);
						celda = fila.getCell(numColumna);
						texto = new HSSFRichTextString("(Leyes 190 de 1995, 489 y 443 de 1998)");
						celda.setCellValue(texto);
						celda.setCellStyle(estiloTitulos);
						hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+54));
						//
						for (int i = 1; i <= 55; i++) {
							fila = hoja2.getRow(0);
							celda = fila.getCell(i);
							celda.setCellStyle(estiloArriba);
						}
						for (int i = 1; i <= 55; i++) {
							fila = hoja2.getRow(5);
							celda = fila.getCell(i);
							celda.setCellStyle(estiloAbajo);
						}
						for (int i = 0; i <= 5; i++) {
							fila = hoja2.getRow(i);
							celda = fila.getCell(0);
							celda.setCellStyle(estiloDer);
						}
						for (int i = 0; i <= 5; i++) {
							fila = hoja2.getRow(i);
							celda = fila.getCell(56);
							celda.setCellStyle(estiloIzq);
						}
						
						// 
						numFila += 3;
						numColumna = 1;
						fila = hoja2.getRow(numFila);
						celda = fila.getCell(numColumna);
						texto = new HSSFRichTextString("3. EXPERIENCIA LABORAL");
						celda.setCellValue(texto);
						celda.setCellStyle(estiloPlantillaRelleno);
						hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+20));
						// 
						numFila += 2;
						fila = hoja2.getRow(numFila);
						celda = fila.getCell(numColumna);
						texto = new HSSFRichTextString("RELACIONE SU EXPERIENCIA LABORAL O DE PRESTACIÓN DE SERVICIOS EN ESTRICTO ORDEN CRONOLÓGICO COMENZANDO POR EL ACTUAL.");
						celda.setCellValue(texto);
						celda.setCellStyle(estiloContenido);	
						celda = fila.getCell(55);
						celda.setCellStyle(estiloContenido);			
						hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila+1,numColumna,numColumna+54));
						for (int i = 1; i <= 55; i++) {
							celda = fila.getCell(i);
							celda.setCellStyle(estiloContenido);
						}
						contadorControl = 0;
						numFila += 1;
						while(itExperiencias.hasNext()){
							if(contadorControl<=3){
								contadorControl++;
								experiencia = (GppExperiencia) itExperiencias.next();
								numFila += 1;
								numColumna = 1;
								fila = hoja2.getRow(numFila);
								celda = fila.getCell(numColumna);
								if(contadorControl==1)
									texto = new HSSFRichTextString("EMPLEO ACTUAL O CONTRATO VIGENTE");
								else
									texto = new HSSFRichTextString("EMPLEO O CONTRATO ANTERIOR");
								celda.setCellValue(texto);
								celda.setCellStyle(estiloPlantillaRelleno2);			
								hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+54));			
								// 
								numFila += 1;
								numColumna = 1;
								fila = hoja2.getRow(numFila);
								celda = fila.getCell(numColumna);
								texto = new HSSFRichTextString("EMPRESA O ENTIDAD");
								celda.setCellValue(texto);
								celda.setCellStyle(estiloContenido);			
								hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+31));
								// 
								numColumna = 33;
								fila = hoja2.getRow(numFila);
								celda = fila.getCell(numColumna);
								texto = new HSSFRichTextString("PÚBLICA");
								celda.setCellValue(texto);
								celda.setCellStyle(estiloContenido);			
								hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+3));			
								// 
								numColumna = 37;
								fila = hoja2.getRow(numFila);
								celda = fila.getCell(numColumna);
								texto = new HSSFRichTextString("PRIVADA");
								celda.setCellValue(texto);
								celda.setCellStyle(estiloContenido);			
								hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+3));			
								// 
								numColumna = 41;
								fila = hoja2.getRow(numFila);
								celda = fila.getCell(numColumna);
								texto = new HSSFRichTextString("PAÍS");
								celda.setCellValue(texto);
								celda.setCellStyle(estiloContenido);			
								hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+14));			
								// 
								numFila += 1;
								numColumna = 1;
								fila = hoja2.getRow(numFila);
								celda = fila.getCell(numColumna);
								texto = new HSSFRichTextString(experiencia.getExpVnomempresa());
								celda.setCellValue(texto);
								celda.setCellStyle(estiloContenido);			
								hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+31));
								// 
								numColumna = 33;
								fila = hoja2.getRow(numFila);
								celda = fila.getCell(numColumna);
								texto = new HSSFRichTextString("");
								celda.setCellValue(texto);
								celda.setCellStyle(estiloContenido);			
								hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+3));			
								// 
								numColumna = 37;
								fila = hoja2.getRow(numFila);
								celda = fila.getCell(numColumna);
								texto = new HSSFRichTextString("");
								celda.setCellValue(texto);
								celda.setCellStyle(estiloContenido);			
								hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+3));			
								// 
								pais = null;
								depto = null;
								mpio = null;
								mpio = municipioService.buscarPorIdMunicipio(experiencia.getMunVidmunicipio());
								depto = departamentoService.buscarPorIdDepartamento(mpio.getDptNiddepto());
								pais = paisService.buscarPorIdPais(depto.getPaiNidpais());
								numColumna = 41;
								fila = hoja2.getRow(numFila);
								celda = fila.getCell(numColumna);
								if(pais.getPaiVpais()!=null)
									texto = new HSSFRichTextString(pais.getPaiVpais());
								celda.setCellValue(texto);
								celda.setCellStyle(estiloContenido);			
								hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+14));			
								// 
								numFila += 1;
								numColumna = 1;
								fila = hoja2.getRow(numFila);
								celda = fila.getCell(numColumna);
								texto = new HSSFRichTextString("DEPARTAMENTO");
								celda.setCellValue(texto);
								celda.setCellStyle(estiloContenido);			
								hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+18));	
								// 
								numColumna = 20;
								fila = hoja2.getRow(numFila);
								celda = fila.getCell(numColumna);
								texto = new HSSFRichTextString("MUNICIPIO");
								celda.setCellValue(texto);
								celda.setCellStyle(estiloContenido);			
								hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+17));			
								// 
								numColumna = 38;
								fila = hoja2.getRow(numFila);
								celda = fila.getCell(numColumna);
								texto = new HSSFRichTextString("CORREO ELECTRÓNICO DE LA ENTIDAD");
								celda.setCellValue(texto);
								celda.setCellStyle(estiloContenido);			
								hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+17));			
								// 
								numFila += 1;
								numColumna = 1;
								fila = hoja2.getRow(numFila);
								celda = fila.getCell(numColumna);
								if(depto.getDptVdepto()!=null)
									texto = new HSSFRichTextString(depto.getDptVdepto());
								celda.setCellValue(texto);
								celda.setCellStyle(estiloContenido);			
								hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+18));	
								// 
								numColumna = 20;
								fila = hoja2.getRow(numFila);
								celda = fila.getCell(numColumna);
								if(mpio.getMunVmunicipio()!=null)
									texto = new HSSFRichTextString(mpio.getMunVmunicipio());
								celda.setCellValue(texto);
								celda.setCellStyle(estiloContenido);			
								hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+17));			
								// 
								numColumna = 38;
								fila = hoja2.getRow(numFila);
								celda = fila.getCell(numColumna);
								if(experiencia.getExpVemailcontacto()!=null)
									texto = new HSSFRichTextString(experiencia.getExpVemailcontacto());
								celda.setCellValue(texto);
								celda.setCellStyle(estiloContenido);			
								hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+17));			
								// 
								numFila += 1;
								numColumna = 1;
								fila = hoja2.getRow(numFila);
								celda = fila.getCell(numColumna);
								texto = new HSSFRichTextString("TELÉFONOS");
								celda.setCellValue(texto);
								celda.setCellStyle(estiloContenido);			
								hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+18));	
								// 
								numColumna = 20;
								fila = hoja2.getRow(numFila);
								celda = fila.getCell(numColumna);
								texto = new HSSFRichTextString("FECHA DE INGRESO");
								celda.setCellValue(texto);
								celda.setCellStyle(estiloContenido);			
								hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+17));			
								// 
								numColumna = 38;
								fila = hoja2.getRow(numFila);
								celda = fila.getCell(numColumna);
								texto = new HSSFRichTextString("FECHA DE RETIRO");
								celda.setCellValue(texto);
								celda.setCellStyle(estiloContenido);			
								hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+17));			
								// 
								numFila += 1;
								numColumna = 1;
								fila = hoja2.getRow(numFila);
								celda = fila.getCell(numColumna);
								if(experiencia.getExpVtelempresa()!=null)
									texto = new HSSFRichTextString(experiencia.getExpVtelempresa());
								celda.setCellValue(texto);
								celda.setCellStyle(estiloContenido);			
								hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+18));	
								// 
								numColumna = 20;
								fila = hoja2.getRow(numFila);
								celda = fila.getCell(numColumna);
								texto = new HSSFRichTextString("DÍA");
								celda.setCellValue(texto);
								celda.setCellStyle(estiloContenido);			
								hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
								// 
								simpleDateFormat = new SimpleDateFormat("dd");
								numColumna = 22;
								fila = hoja2.getRow(numFila);
								celda = fila.getCell(numColumna);
								if(experiencia.getExpDfecingreso()!=null)
									texto = new HSSFRichTextString(simpleDateFormat.format(experiencia.getExpDfecingreso()));
								else
									texto = new HSSFRichTextString("");
								celda.setCellValue(texto);
								celda.setCellStyle(estiloContenido);			
								hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+2));			
								// 
								numColumna = 25;
								fila = hoja2.getRow(numFila);
								celda = fila.getCell(numColumna);
								texto = new HSSFRichTextString("MES");
								celda.setCellValue(texto);
								celda.setCellStyle(estiloContenido);			
								hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+2));	
								// 
								simpleDateFormat = new SimpleDateFormat("MM");
								numColumna = 28;
								fila = hoja2.getRow(numFila);
								celda = fila.getCell(numColumna);
								if(experiencia.getExpDfecingreso()!=null)
									texto = new HSSFRichTextString(simpleDateFormat.format(experiencia.getExpDfecingreso()));
								else
									texto = new HSSFRichTextString("");
								celda.setCellValue(texto);
								celda.setCellStyle(estiloContenido);			
								hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
								// 
								numColumna = 30;
								fila = hoja2.getRow(numFila);
								celda = fila.getCell(numColumna);
								texto = new HSSFRichTextString("AÑO");
								celda.setCellValue(texto);
								celda.setCellStyle(estiloContenido);			
								hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+2));			
								// 
								simpleDateFormat = new SimpleDateFormat("yyyy");
								numColumna = 33;
								fila = hoja2.getRow(numFila);
								celda = fila.getCell(numColumna);
								if(experiencia.getExpDfecingreso()!=null)
									texto = new HSSFRichTextString(simpleDateFormat.format(experiencia.getExpDfecingreso()));
								else
									texto = new HSSFRichTextString("");
								celda.setCellValue(texto);
								celda.setCellStyle(estiloContenido);			
								hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+4));			
								// 
								numColumna = 38;
								fila = hoja2.getRow(numFila);
								celda = fila.getCell(numColumna);
								texto = new HSSFRichTextString("DÍA");
								celda.setCellValue(texto);
								celda.setCellStyle(estiloContenido);			
								hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
								//
								simpleDateFormat = new SimpleDateFormat("dd");
								numColumna = 40;
								fila = hoja2.getRow(numFila);
								celda = fila.getCell(numColumna);
								if(experiencia.getExpDfecretiro()!=null)
									texto = new HSSFRichTextString(simpleDateFormat.format(experiencia.getExpDfecretiro()));
								else
									texto = new HSSFRichTextString("");						
								celda.setCellValue(texto);
								celda.setCellStyle(estiloContenido);			
								hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+2));			
								// 
								numColumna = 43;
								fila = hoja2.getRow(numFila);
								celda = fila.getCell(numColumna);
								texto = new HSSFRichTextString("MES");
								celda.setCellValue(texto);
								celda.setCellStyle(estiloContenido);			
								hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+2));	
								// 
								simpleDateFormat = new SimpleDateFormat("MM");
								numColumna = 46;
								fila = hoja2.getRow(numFila);
								celda = fila.getCell(numColumna);
								if(experiencia.getExpDfecretiro()!=null)
									texto = new HSSFRichTextString(simpleDateFormat.format(experiencia.getExpDfecretiro()));
								else
									texto = new HSSFRichTextString("");		
								celda.setCellValue(texto);
								celda.setCellStyle(estiloContenido);			
								hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
								// 
								numColumna = 48;
								fila = hoja2.getRow(numFila);
								celda = fila.getCell(numColumna);
								texto = new HSSFRichTextString("AÑO");
								celda.setCellValue(texto);
								celda.setCellStyle(estiloContenido);			
								hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+2));			
								// 
								simpleDateFormat = new SimpleDateFormat("yyyy");
								numColumna = 51;
								fila = hoja2.getRow(numFila);
								celda = fila.getCell(numColumna);
								if(experiencia.getExpDfecretiro()!=null)
									texto = new HSSFRichTextString(simpleDateFormat.format(experiencia.getExpDfecretiro()));
								else
									texto = new HSSFRichTextString("");		
								celda.setCellValue(texto);
								celda.setCellStyle(estiloContenido);			
								hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+4));			
								// 
								numFila += 1;
								numColumna = 1;
								fila = hoja2.getRow(numFila);
								celda = fila.getCell(numColumna);
								texto = new HSSFRichTextString("CARGO O CONTRATO ACTUAL");
								celda.setCellValue(texto);
								celda.setCellStyle(estiloContenido);			
								hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+18));	
								// 
								numColumna = 20;
								fila = hoja2.getRow(numFila);
								celda = fila.getCell(numColumna);
								texto = new HSSFRichTextString("DEPENDENCIA");
								celda.setCellValue(texto);
								celda.setCellStyle(estiloContenido);			
								hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+17));			
								// 
								numColumna = 38;
								fila = hoja2.getRow(numFila);
								celda = fila.getCell(numColumna);
								texto = new HSSFRichTextString("DIRECCIÓN");
								celda.setCellValue(texto);
								celda.setCellStyle(estiloContenido);			
								hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+17));			
								// 
								numFila += 1;
								numColumna = 1;
								fila = hoja2.getRow(numFila);
								celda = fila.getCell(numColumna);
								texto = new HSSFRichTextString(experiencia.getExpVcargo());
								celda.setCellValue(texto);
								celda.setCellStyle(estiloContenido);			
								hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+18));	
								// 
								numColumna = 20;
								fila = hoja2.getRow(numFila);
								celda = fila.getCell(numColumna);
								texto = new HSSFRichTextString("");
								celda.setCellValue(texto);
								celda.setCellStyle(estiloContenido);			
								hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+17));			
								// 
								numColumna = 38;
								fila = hoja2.getRow(numFila);
								celda = fila.getCell(numColumna);
								texto = new HSSFRichTextString("");
								celda.setCellValue(texto);
								celda.setCellStyle(estiloContenido);			
								hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+17));	
							}else{
								break;
							}
						}
						for (int i = 1; i <= (4-contadorControl); i++) {
							numFila += 1;
							numColumna = 1;
							fila = hoja2.getRow(numFila);
							celda = fila.getCell(numColumna);
							if(contadorControl==0)
								texto = new HSSFRichTextString("EMPLEO ACTUAL O CONTRATO VIGENTE");
							else
								texto = new HSSFRichTextString("EMPLEO O CONTRATO ANTERIOR");
							celda.setCellValue(texto);
							celda.setCellStyle(estiloPlantillaRelleno2);			
							hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+54));			
							// 
							numFila += 1;
							numColumna = 1;
							fila = hoja2.getRow(numFila);
							celda = fila.getCell(numColumna);
							texto = new HSSFRichTextString("EMPRESA O ENTIDAD");
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+31));
							// 
							numColumna = 33;
							fila = hoja2.getRow(numFila);
							celda = fila.getCell(numColumna);
							texto = new HSSFRichTextString("PÚBLICA");
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+3));			
							// 
							numColumna = 37;
							fila = hoja2.getRow(numFila);
							celda = fila.getCell(numColumna);
							texto = new HSSFRichTextString("PRIVADA");
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+3));			
							// 
							numColumna = 41;
							fila = hoja2.getRow(numFila);
							celda = fila.getCell(numColumna);
							texto = new HSSFRichTextString("PAÍS");
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+14));			
							// 
							numFila += 1;
							numColumna = 1;
							fila = hoja2.getRow(numFila);
							celda = fila.getCell(numColumna);
							texto = new HSSFRichTextString("");
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+31));
							// 
							numColumna = 33;
							fila = hoja2.getRow(numFila);
							celda = fila.getCell(numColumna);
							texto = new HSSFRichTextString("");
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+3));			
							// 
							numColumna = 37;
							fila = hoja2.getRow(numFila);
							celda = fila.getCell(numColumna);
							texto = new HSSFRichTextString("");
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+3));			
							// 
							numColumna = 41;
							fila = hoja2.getRow(numFila);
							celda = fila.getCell(numColumna);
							texto = new HSSFRichTextString("");
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+14));			
							// 
							numFila += 1;
							numColumna = 1;
							fila = hoja2.getRow(numFila);
							celda = fila.getCell(numColumna);
							texto = new HSSFRichTextString("DEPARTAMENTO");
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+18));	
							// 
							numColumna = 20;
							fila = hoja2.getRow(numFila);
							celda = fila.getCell(numColumna);
							texto = new HSSFRichTextString("MUNICIPIO");
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+17));			
							// 
							numColumna = 38;
							fila = hoja2.getRow(numFila);
							celda = fila.getCell(numColumna);
							texto = new HSSFRichTextString("CORREO ELECTRÓNICO DE LA ENTIDAD");
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+17));			
							// 
							numFila += 1;
							numColumna = 1;
							fila = hoja2.getRow(numFila);
							celda = fila.getCell(numColumna);
							texto = new HSSFRichTextString("");
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+18));	
							// 
							numColumna = 20;
							fila = hoja2.getRow(numFila);
							celda = fila.getCell(numColumna);
							texto = new HSSFRichTextString("");
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+17));			
							// 
							numColumna = 38;
							fila = hoja2.getRow(numFila);
							celda = fila.getCell(numColumna);
							texto = new HSSFRichTextString("");
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+17));			
							// 
							numFila += 1;
							numColumna = 1;
							fila = hoja2.getRow(numFila);
							celda = fila.getCell(numColumna);
							texto = new HSSFRichTextString("TELÉFONOS");
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+18));	
							// 
							numColumna = 20;
							fila = hoja2.getRow(numFila);
							celda = fila.getCell(numColumna);
							texto = new HSSFRichTextString("FECHA DE INGRESO");
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+17));			
							// 
							numColumna = 38;
							fila = hoja2.getRow(numFila);
							celda = fila.getCell(numColumna);
							texto = new HSSFRichTextString("FECHA DE RETIRO");
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+17));			
							// 
							numFila += 1;
							numColumna = 1;
							fila = hoja2.getRow(numFila);
							celda = fila.getCell(numColumna);
							texto = new HSSFRichTextString("");
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+18));	
							// 
							numColumna = 20;
							fila = hoja2.getRow(numFila);
							celda = fila.getCell(numColumna);
							texto = new HSSFRichTextString("DÍA");
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
							// 
							numColumna = 22;
							fila = hoja2.getRow(numFila);
							celda = fila.getCell(numColumna);
							texto = new HSSFRichTextString("");
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+2));			
							// 
							numColumna = 25;
							fila = hoja2.getRow(numFila);
							celda = fila.getCell(numColumna);
							texto = new HSSFRichTextString("MES");
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+2));	
							// 
							numColumna = 28;
							fila = hoja2.getRow(numFila);
							celda = fila.getCell(numColumna);
							texto = new HSSFRichTextString("");
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
							// 
							numColumna = 30;
							fila = hoja2.getRow(numFila);
							celda = fila.getCell(numColumna);
							texto = new HSSFRichTextString("AÑO");
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+2));			
							// 
							numColumna = 33;
							fila = hoja2.getRow(numFila);
							celda = fila.getCell(numColumna);
							texto = new HSSFRichTextString("");
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+4));			
							// 
							numColumna = 38;
							fila = hoja2.getRow(numFila);
							celda = fila.getCell(numColumna);
							texto = new HSSFRichTextString("DÍA");
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
							//
							numColumna = 40;
							fila = hoja2.getRow(numFila);
							celda = fila.getCell(numColumna);
							texto = new HSSFRichTextString("");						
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+2));			
							// 
							numColumna = 43;
							fila = hoja2.getRow(numFila);
							celda = fila.getCell(numColumna);
							texto = new HSSFRichTextString("MES");
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+2));	
							// 
							numColumna = 46;
							fila = hoja2.getRow(numFila);
							celda = fila.getCell(numColumna);
							texto = new HSSFRichTextString("");		
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
							// 
							numColumna = 48;
							fila = hoja2.getRow(numFila);
							celda = fila.getCell(numColumna);
							texto = new HSSFRichTextString("AÑO");
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+2));			
							// 
							numColumna = 51;
							fila = hoja2.getRow(numFila);
							celda = fila.getCell(numColumna);
							texto = new HSSFRichTextString("");		
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+4));			
							// 
							numFila += 1;
							numColumna = 1;
							fila = hoja2.getRow(numFila);
							celda = fila.getCell(numColumna);
							texto = new HSSFRichTextString("CARGO O CONTRATO ACTUAL");
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+18));	
							// 
							numColumna = 20;
							fila = hoja2.getRow(numFila);
							celda = fila.getCell(numColumna);
							texto = new HSSFRichTextString("DEPENDENCIA");
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+17));			
							// 
							numColumna = 38;
							fila = hoja2.getRow(numFila);
							celda = fila.getCell(numColumna);
							texto = new HSSFRichTextString("DIRECCIÓN");
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+17));			
							// 
							numFila += 1;
							numColumna = 1;
							fila = hoja2.getRow(numFila);
							celda = fila.getCell(numColumna);
							texto = new HSSFRichTextString("");
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+18));	
							// 
							numColumna = 20;
							fila = hoja2.getRow(numFila);
							celda = fila.getCell(numColumna);
							texto = new HSSFRichTextString("");
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+17));			
							// 
							numColumna = 38;
							fila = hoja2.getRow(numFila);
							celda = fila.getCell(numColumna);
							texto = new HSSFRichTextString("");
							celda.setCellValue(texto);
							celda.setCellStyle(estiloContenido);			
							hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+17));	
						}
						
						for (int i = 10; i <= 46; i++) {
							fila = hoja2.getRow(i);
							celda = fila.getCell(55);
							celda.setCellStyle(estiloContenido);
						}
						
						// 
						numFila += 1;
						numColumna = 1;
						fila = hoja2.getRow(numFila);
						celda = fila.getCell(numColumna);
						texto = new HSSFRichTextString("NOTA: SI QUIERE ADICIONAR MÁS EXPERIENCIA LABORAL, IMPRIMA O COPEE NUEVAMENTE ESTA HOJA");
						celda.setCellValue(texto);
						celda.setCellStyle(estiloContenido);			
						hoja2.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+54));
						//
						for (int i = 1; i <= 55; i++) {
							fila = hoja2.getRow(8);
							celda = fila.getCell(i);
							celda.setCellStyle(estiloAbajo);
						}
						for (int i = 1; i <= 55; i++) {
							fila = hoja2.getRow(48);
							celda = fila.getCell(i);
							celda.setCellStyle(estiloArriba);
						}
						for (int i = 9; i <= 47; i++) {
							fila = hoja2.getRow(i);
							celda = fila.getCell(0);
							celda.setCellStyle(estiloDer);
						}
						for (int i = 9; i <= 47; i++) {
							fila = hoja2.getRow(i);
							celda = fila.getCell(56);
							celda.setCellStyle(estiloIzq);
						}
						for (Integer i = 0; i <= 1000; i++) {
							hoja2.setColumnWidth(i, 410);
						}
					}
				}
			}
			
			// hoja 3
			
			HSSFSheet hoja3 = libro.createSheet("Pág._3");
			fila = hoja3.createRow(0);
			celda = fila.createCell(0);
			texto = new HSSFRichTextString();

			for (Integer i = 0; i <= 1000; i++) {
				fila = hoja3.createRow(i);
				for (Integer j = 0; j <= 60; j++) {
					fila.createCell(j);
				}
			}
			
			// ENCABEZADO
			numFila = 1;
			numColumna = 1;
			fila = hoja3.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("FORMATO ÚNICO");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloTitulos);
			hoja3.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+54));
			// 
			numFila += 1;
			fila = hoja3.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("HOJA DE VIDA");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaTitulos);
			hoja3.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+54));
			//
			numFila += 1;
			fila = hoja3.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("Persona Natural");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloTitulos);
			hoja3.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+54));
			// 
			numFila += 1;
			fila = hoja3.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("(Leyes 190 de 1995, 489 y 443 de 1998)");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloTitulos);
			hoja3.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+54));
			//
			for (int i = 1; i <= 55; i++) {
				fila = hoja3.getRow(0);
				celda = fila.getCell(i);
				celda.setCellStyle(estiloArriba);
			}
			for (int i = 1; i <= 55; i++) {
				fila = hoja3.getRow(5);
				celda = fila.getCell(i);
				celda.setCellStyle(estiloAbajo);
			}
			for (int i = 0; i <= 5; i++) {
				fila = hoja3.getRow(i);
				celda = fila.getCell(0);
				celda.setCellStyle(estiloDer);
			}
			for (int i = 0; i <= 5; i++) {
				fila = hoja3.getRow(i);
				celda = fila.getCell(56);
				celda.setCellStyle(estiloIzq);
			}
			//
			numFila += 3;
			numColumna = 1;
			fila = hoja3.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("4. TIEMPO TOTAL DE EXPERIENCIA");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaRelleno);
			hoja3.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+25));
			// 
			numFila += 2;
			fila = hoja3.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("INDIQUE EL TIEMPO DE SU EXPERIENCIA LABORAL EN NÚMERO DE AÑOS Y MESES.");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);		
			celda = fila.getCell(55);
			celda.setCellStyle(estiloContenido);
			hoja3.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+54));
			// 
			numFila += 2;
			numColumna = 13;
			fila = hoja3.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("OCUPACIÓN");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja3.addMergedRegion(new CellRangeAddress(numFila,numFila+1,numColumna,numColumna+21));
			// 
			numColumna = 35;
			fila = hoja3.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("TIEMPO DE EXPERIENCIA");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			celda = fila.getCell(45);
			celda.setCellStyle(estiloContenido);
			hoja3.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+10));
			// 
			numFila +=1;
			numColumna = 35;
			fila = hoja3.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("AÑOS");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja3.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+4));
			// 
			numColumna = 40;
			fila = hoja3.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("MESES");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);	
			celda = fila.getCell(45);
			celda.setCellStyle(estiloContenido);			
			hoja3.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+5));			
			// 
			numFila +=1;
			numColumna = 13;
			fila = hoja3.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("SERVIDOR PÚBLICO");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja3.addMergedRegion(new CellRangeAddress(numFila,numFila+1,numColumna,numColumna+21));	
			// 
			numColumna = 35;
			fila = hoja3.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja3.addMergedRegion(new CellRangeAddress(numFila,numFila+1,numColumna,numColumna+4));
			// 
			numColumna = 40;
			fila = hoja3.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			celda = fila.getCell(45);
			celda.setCellStyle(estiloContenido);			
			hoja3.addMergedRegion(new CellRangeAddress(numFila,numFila+1,numColumna,numColumna+5));		
			// 
			numFila +=2;
			numColumna = 13;
			fila = hoja3.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("EMPLEADO DEL SECTOR PRIVADO");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja3.addMergedRegion(new CellRangeAddress(numFila,numFila+1,numColumna,numColumna+21));	
			// 
			numColumna = 35;
			fila = hoja3.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja3.addMergedRegion(new CellRangeAddress(numFila,numFila+1,numColumna,numColumna+4));
			// 
			numColumna = 40;
			fila = hoja3.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			celda = fila.getCell(45);
			celda.setCellStyle(estiloContenido);			
			hoja3.addMergedRegion(new CellRangeAddress(numFila,numFila+1,numColumna,numColumna+5));	
			// 
			numFila +=2;
			numColumna = 13;
			fila = hoja3.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("TRABAJADOR INDEPENDIENTE");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja3.addMergedRegion(new CellRangeAddress(numFila,numFila+1,numColumna,numColumna+21));	
			// 
			numColumna = 35;
			fila = hoja3.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja3.addMergedRegion(new CellRangeAddress(numFila,numFila+1,numColumna,numColumna+4));
			// 
			numColumna = 40;
			fila = hoja3.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			celda = fila.getCell(45);
			celda.setCellStyle(estiloContenido);			
			hoja3.addMergedRegion(new CellRangeAddress(numFila,numFila+1,numColumna,numColumna+5));	
			// 
			numFila +=2;
			numColumna = 13;
			fila = hoja3.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("TOTAL TIEMPO EXPERIENCIA");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja3.addMergedRegion(new CellRangeAddress(numFila,numFila+1,numColumna,numColumna+21));	
			// 
			List<Object> experiencias = persona.getGppExperienciasLaborales();
			GppExperiencia experiencia = null;
			Double tiempoExperiencia = Double.valueOf("0");
			Integer anios = 0;
			Double meses = Double.valueOf("0");
			if(experiencias!=null){
				if(experiencias.size()>0){
					Iterator<Object> itExperiencias = experiencias.iterator();
					while(itExperiencias.hasNext()){
						experiencia = (GppExperiencia) itExperiencias.next();
						tiempoExperiencia += Calculos.diferenciaFechasDias(experiencia.getExpDfecingreso(), experiencia.getExpDfecretiro());
					}
				}
				tiempoExperiencia = tiempoExperiencia/365;
				anios = tiempoExperiencia.intValue();
				meses = (tiempoExperiencia - tiempoExperiencia.intValue())*12;
			}
			numColumna = 35;
			fila = hoja3.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString(anios.toString());
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			hoja3.addMergedRegion(new CellRangeAddress(numFila,numFila+1,numColumna,numColumna+4));
			// 
			numColumna = 40;
			fila = hoja3.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString(String.valueOf(meses.intValue()));
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);	
			celda = fila.getCell(45);
			celda.setCellStyle(estiloContenido);			
			hoja3.addMergedRegion(new CellRangeAddress(numFila,numFila+1,numColumna,numColumna+5));
			fila = hoja3.getRow(numFila+1);
			for (int i = 13; i <= 45; i++) {
				celda = fila.getCell(i);
				celda.setCellStyle(estiloContenido);
			}
			//
			for (int i = 1; i <= 55; i++) {
				fila = hoja3.getRow(8);
				celda = fila.getCell(i);
				celda.setCellStyle(estiloAbajo);
			}
			for (int i = 1; i <= 55; i++) { 
				fila = hoja3.getRow(22);
				celda = fila.getCell(i);
				celda.setCellStyle(estiloArriba);
			}
			for (int i = 9; i <= 21; i++) {
				fila = hoja3.getRow(i);
				celda = fila.getCell(0);
				celda.setCellStyle(estiloDer);
			}
			for (int i = 9; i <= 21; i++) {
				fila = hoja3.getRow(i);
				celda = fila.getCell(56);
				celda.setCellStyle(estiloIzq);
			}
			// 
			numFila += 4;
			numColumna = 1;
			fila = hoja3.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("5. FIRMA DEL SERVIDOR PÚBLICO O CONTRATISTA");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaRelleno);
			hoja3.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+36));
			// 
			numFila += 2;
			numColumna = 1;
			fila = hoja3.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("ANIFIESTO BAJO LA GRAVEDAD DEL JURAMENTO QUE SI________NO________ME ENCUENTRO DENTRO DE LAS CAUSALES DE INHABILIDAD E INCOMPATIBILIDAD DEL ORDEN CONSTITUCIONAL O LEGAL, PARA EJERCER CARGOS EMPLEOS PÚBLICOS O PARA CELEBRAR CONTRATOS DE PRESTACIÓN DE SERVICIOS CON LA ADMINISTRACIÓN PÚBLICA.");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			celda = fila.getCell(55);
			celda.setCellStyle(estiloContenido);
			hoja3.addMergedRegion(new CellRangeAddress(numFila,numFila+1,numColumna,numColumna+54));
			fila = hoja3.getRow(numFila+1);
			for (int i = 1; i <= 55; i++) {
				celda = fila.getCell(i);
				celda.setCellStyle(estiloContenido);
			}
			
			// 
			numFila += 3;
			numColumna = 1;
			fila = hoja3.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("PARA TODOS LOS EFECTOS LEGALES, CERTIFICO QUE LOS DATOS POR MI ANOTADOS EN EL PRESENTE FORMATO ÚNICO DE HOJA DE VIDA, SON VERACES, (ARTÍCULO 5o DE LA LEY 190/95).");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			celda = fila.getCell(55);
			celda.setCellStyle(estiloContenido);
			hoja3.addMergedRegion(new CellRangeAddress(numFila,numFila+1,numColumna,numColumna+54));
			fila = hoja3.getRow(numFila+1);
			for (int i = 1; i <= 55; i++) {
				celda = fila.getCell(i);
				celda.setCellStyle(estiloContenido);
			}
			// 
			numFila += 2;
			numColumna = 1;
			fila = hoja3.getRow(numFila);
			celda = fila.getCell(numColumna);
			celda.setCellStyle(estiloContenido);			
			hoja3.addMergedRegion(new CellRangeAddress(numFila,numFila+4,numColumna,numColumna+54));
			for (int i = 28; i <= 32; i++) {
				celda = fila.getCell(55);
				celda.setCellStyle(estiloContenido);	
			}
			fila = hoja3.getRow(32);			
			for (int j = 1; j <= 55; j++) {
				celda = fila.getCell(j);
				celda.setCellStyle(estiloContenido);	
			}
			// 
			numFila += 5;
			numColumna = 16;
			fila = hoja3.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("FIRMA DEL SERVIDOR PÚBLICO O CONTRATISTA");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);	
			celda = fila.getCell(38);
			celda.setCellStyle(estiloContenido);
			hoja3.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+22));
			//
			for (int i = 1; i <= 55; i++) {
				fila = hoja3.getRow(24);
				celda = fila.getCell(i);
				celda.setCellStyle(estiloAbajo);
			}
			for (int i = 1; i <= 55; i++) {
				fila = hoja3.getRow(36);
				celda = fila.getCell(i);
				celda.setCellStyle(estiloArriba);
			}
			for (int i = 25; i <= 35; i++) {
				fila = hoja3.getRow(i);
				celda = fila.getCell(0);
				celda.setCellStyle(estiloDer);
			}
			for (int i = 25; i <= 35; i++) {
				fila = hoja3.getRow(i);
				celda = fila.getCell(56);
				celda.setCellStyle(estiloIzq);
			}
			// 
			numFila += 2;
			numColumna = 1;
			fila = hoja3.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("6. OBSERVACIONES DEL JEFFE DE RECURSOS HUMANOS Y/O CONTRATOS");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantillaRelleno);
			hoja3.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+54));
			// 
			numFila += 2;
			numColumna = 1;
			fila = hoja3.getRow(numFila);
			celda = fila.getCell(numColumna);
			celda.setCellStyle(estiloContenido);
			hoja3.addMergedRegion(new CellRangeAddress(numFila,numFila+4,numColumna,numColumna+54));
			// 
			numFila += 5;
			numColumna = 1;
			fila = hoja3.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("CERTIFICO QUE LA INFORMACIÓN AQUÍ SUMINISTRADA HA SIDO CONSTATADA FRENTE A LOS DOCUMENTOS QUE HAN SIDO PRESENTADOS COMO SOPORTE.");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja3.addMergedRegion(new CellRangeAddress(numFila,numFila+1,numColumna,numColumna+54));
			// 
			numFila += 2;
			numColumna = 1;
			fila = hoja3.getRow(numFila);
			celda = fila.getCell(numColumna);
			celda.setCellStyle(estiloContenido);
			hoja3.addMergedRegion(new CellRangeAddress(numFila,numFila+3,numColumna,numColumna+54));
			
			fila = hoja3.getRow(numFila+3);
			for (int i = 1; i <= 55; i++) {
				celda = fila.getCell(i);
				celda.setCellStyle(estiloContenido);	
			}			
			for (int j = 37; j <= 47; j++) {
				fila = hoja3.getRow(j);	
				celda = fila.getCell(55);
				celda.setCellStyle(estiloContenido);	
			}				
			// 
			numFila += 4;
			numColumna = 24;
			fila = hoja3.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("NOMBRE Y FIRMA DEL JEFE DE PERSONAL O DE CONTRATOS");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			celda = fila.getCell(55);
			celda.setCellStyle(estiloContenido);
			hoja3.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+31));
			//
			for (int i = 1; i <= 55; i++) {
				fila = hoja3.getRow(38);
				celda = fila.getCell(i);
				celda.setCellStyle(estiloAbajo);
			}
			for (int i = 1; i <= 55; i++) {
				fila = hoja3.getRow(51);
				celda = fila.getCell(i);
				celda.setCellStyle(estiloArriba);
			}
			for (int i = 39; i <= 50; i++) {
				fila = hoja3.getRow(i);
				celda = fila.getCell(0);
				celda.setCellStyle(estiloDer);
			}
			for (int i = 39; i <= 50; i++) {
				fila = hoja3.getRow(i);
				celda = fila.getCell(56);
				celda.setCellStyle(estiloIzq);
			}
			// 
			numFila += 2;
			numColumna = 1;
			fila = hoja3.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("LÍNEA GRATUITA DE ATENCIÓN AL CLIENTE N° 018000917770 PÁGINA WEB: www.dafp.gov.co");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			celda = fila.getCell(55);
			celda.setCellStyle(estiloContenido);
			hoja3.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+54));
			
			for (Integer i = 0; i <= 1000; i++) {
				hoja1.setColumnWidth(i, 410);
				hoja3.setColumnWidth(i, 410);
			}
			
			String rutaSalidaExportacion = ( (GppParametrizacion) parametrizacionService.buscarPorIdParametrizacion(2) ).getParVvalor();
			if(rutaSalidaExportacion!=null){
				String nombreArchivo = "FORMATO_HV_FUHV_"+persona.getPerNidentificacion()+".xls";		
				FileOutputStream formatoExportado = new FileOutputStream(rutaSalidaExportacion+nombreArchivo);
				libro.write(formatoExportado);
				formatoExportado.close();		
				estadoOperacion = true;
			}
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}		

	public Boolean generarReporteFormal(GppPersona persona){
		estadoOperacion = false;
		try{
			HSSFWorkbook libro = new HSSFWorkbook();
			HSSFSheet hoja = libro.createSheet("Pág._1");
			HSSFRow fila = hoja.createRow(0);
			HSSFCell celda = fila.createCell(0);
			HSSFRichTextString texto = new HSSFRichTextString();
					
			HSSFFont fuentePlantilla = libro.createFont();
			fuentePlantilla.setFontName("Arial");
			fuentePlantilla.setBoldweight((short)1000);
			fuentePlantilla.setFontHeightInPoints((short)13);

			HSSFFont fuentePlantilla2 = libro.createFont();
			fuentePlantilla2.setFontName("Arial");
			fuentePlantilla2.setBoldweight((short)1000);
			fuentePlantilla2.setItalic(true);
			fuentePlantilla2.setFontHeightInPoints((short)10);
			
			HSSFFont fuenteContenido = libro.createFont();
			fuenteContenido.setFontName("Arial");
			fuenteContenido.setFontHeightInPoints((short)10);
	
			HSSFFont fuenteTitulo = libro.createFont();
			fuenteTitulo.setFontName("Arial");
			fuenteTitulo.setBoldweight((short)5000);
			fuenteTitulo.setFontHeightInPoints((short)15);
			
			HSSFCellStyle estiloPlantilla = libro.createCellStyle();
			estiloPlantilla.setWrapText(true);
			estiloPlantilla.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);
			estiloPlantilla.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			estiloPlantilla.setWrapText(true);
			estiloPlantilla.setFont(fuentePlantilla);

			HSSFCellStyle estiloPlantilla2 = libro.createCellStyle();
			estiloPlantilla2.setWrapText(true);
			estiloPlantilla2.setFont(fuentePlantilla2);
			
			HSSFCellStyle estiloTitulos = libro.createCellStyle();
			estiloTitulos.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			estiloTitulos.setFont(fuenteTitulo);
			
			HSSFCellStyle estiloContenido = libro.createCellStyle();
			estiloContenido.setWrapText(true);
			estiloContenido.setFont(fuenteContenido);
					
			for (Integer i = 0; i <= 1000; i++) {
				fila = hoja.createRow(i);
				for (Integer j = 0; j <= 20; j++) {
					fila.createCell(j);
				}
			} 

			Integer numFila = 2;
			Integer numColumna = 2;
			fila = hoja.getRow(numFila);
			celda = fila.getCell(numColumna);
			if(persona.getPerVdireccion()!=null)
				texto = new HSSFRichTextString("Dirección: "+persona.getPerVdireccion());
			else
				texto = new HSSFRichTextString("Dirección: ");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			//
			numColumna += 1;
			celda = fila.getCell(numColumna);
			if(persona.getPerVtelefono()!=null)
				texto = new HSSFRichTextString("Telefono: "+persona.getPerVtelefono());
			else
				texto = new HSSFRichTextString("Telefono: ");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			//
			numFila += 1;
			numColumna = 2;
			fila = hoja.getRow(numFila);
			celda = fila.getCell(numColumna);
			if(persona.getPerVmovil()!=null)
				texto = new HSSFRichTextString("Celular: "+persona.getPerVmovil());
			else
				texto = new HSSFRichTextString("Celular: ");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			//
			numColumna += 1;
			celda = fila.getCell(numColumna);
			if(persona.getPerVemail()!=null)
				texto = new HSSFRichTextString("E-Mail: "+persona.getPerVemail());
			else
				texto = new HSSFRichTextString("E-Mail: ");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
						
			numFila += 2;
			numColumna = 0;
			fila = hoja.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString(persona.getPerVnombres().toUpperCase()+" "+persona.getPerVapellidos().toUpperCase());
			celda.setCellValue(texto);
			celda.setCellStyle(estiloTitulos);
			hoja.addMergedRegion(new CellRangeAddress(numFila,numFila+1,numColumna,numColumna+3));
			
			//
			String carreras = "";
			List<Object> formaciones = persona.getGppFormaciones();
			if(formaciones!=null){
				Iterator<Object> itFormaciones = formaciones.iterator();
				Integer control = 1;
				while(itFormaciones.hasNext()){
					GppFormacion formacion = (GppFormacion) itFormaciones.next();
					if(formacion.getNacNidnivelac()>=3 && formacion.getNacNidnivelac()<=8){
						if(control==1)
							carreras = "";
						else
							carreras += " - ";
						carreras += formacion.getForVtitulo();
						control++;
					}
				}
			}
			numFila += 3;
			numColumna = 0;
			fila = hoja.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString(carreras);
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantilla);
			hoja.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+3));			

			// 
			numFila += 4;
			Integer filaInicio = numFila;
			numColumna += 1;
			fila = hoja.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("Edad:");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantilla2);
			//			
			numColumna += 1;
			fila = hoja.getRow(numFila);
			celda = fila.getCell(numColumna);
			String edad = "";
			if(persona.getPerDfecnacimiento()!=null){
				Double edadDouble = Calculos.diferenciaFechasDias(persona.getPerDfecnacimiento(), new Date())/365;
				edad = String.valueOf(edadDouble.intValue());
			}
			texto = new HSSFRichTextString(edad);
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			//			
			numFila +=1;
			numColumna = 1;
			fila = hoja.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("Lugar y Fecha de Nacimiento:");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantilla2);
			//			
			numColumna += 1;
			fila = hoja.getRow(numFila);
			celda = fila.getCell(numColumna);
			String lugarFecha = "";
			GppMunicipio mpio = null;
			simpleDateFormat = new SimpleDateFormat("dd/MM/yyy");
			if(persona.getPerDfecnacimiento()!=null){
				mpio = municipioService.buscarPorIdMunicipio(persona.getMunNidmunicipio());
				if(mpio!=null)
					lugarFecha = "Municpio: "+mpio.getMunVmunicipio()+". Fecha de Nacimiento: "+simpleDateFormat.format(persona.getPerDfecnacimiento());
				else
					lugarFecha = "Municpio: Sin Municipio Registrado. Fecha de Nacimiento: "+simpleDateFormat.format(persona.getPerDfecnacimiento());
			}else{
				mpio = municipioService.buscarPorIdMunicipio(persona.getMunNidmunicipio());
				if(mpio!=null)
					lugarFecha = "Municpio: "+mpio.getMunVmunicipio()+". Fecha de Nacimiento: Sin Fecha Registrada";
				else
					lugarFecha = "Municpio: Sin Municipio Registrado. Fecha de Nacimiento: Sin Fecha Registrada";
				
			}
			texto = new HSSFRichTextString(lugarFecha);
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);						
			//			
			numFila +=1;
			numColumna = 1;
			fila = hoja.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("Nacionalidad:");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantilla2);
			//
			mpio = municipioService.buscarPorIdMunicipio(persona.getMunNidmunicipio());
			GppDepartamento depto = departamentoService.buscarPorIdDepartamento(mpio.getDptNiddepto());
			GppPais pais = paisService.buscarPorIdPais(depto.getPaiNidpais());
			numColumna += 1;
			fila = hoja.getRow(numFila);
			celda = fila.getCell(numColumna);
			if(pais!=null)
				texto = new HSSFRichTextString(pais.getPaiVpais());
			else
				texto = new HSSFRichTextString("");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);				
			//			
			numFila +=1;
			numColumna = 1;
			fila = hoja.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("Tipo de Identificación:");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantilla2);
			//			
			GppTipodoc tipoDocumento = tipodocService.buscarTipoDocumentoPorId(persona.getTdcNidtipodoc());			
			numColumna += 1;
			fila = hoja.getRow(numFila);
			celda = fila.getCell(numColumna);
			if(tipoDocumento!=null)
				texto = new HSSFRichTextString(tipoDocumento.getTdcVnombre());
			else
				texto = new HSSFRichTextString("");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);			
			//			
			numFila +=1;
			numColumna = 1;
			fila = hoja.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("Documento de Identidad:");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantilla2);
			//			
			numColumna += 1;
			fila = hoja.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString(persona.getPerNidentificacion().toString());
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);					
			//
			Integer contadorPregrados = 0;
			if(formaciones!=null){
				Iterator<Object> itFormaciones = formaciones.iterator();
				while(itFormaciones.hasNext()){
					GppFormacion formacion = (GppFormacion) itFormaciones.next();
					if(formacion.getNacNidnivelac()==3){
						contadorPregrados++;
					}
				}
			}
			//			
			numFila +=1;
			numColumna = 1;
			fila = hoja.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("Estado Civil:");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantilla2);
			//			
			GppEstadocivil estadoCivil = estadocivilService.buscarEstadoCivilPorId(persona.getEscNidestadocivil());
			numColumna += 1;
			fila = hoja.getRow(numFila);
			celda = fila.getCell(numColumna);
			if(estadoCivil!=null)
				texto = new HSSFRichTextString(estadoCivil.getEscVestadocivil());
			else
				texto = new HSSFRichTextString("");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);	
			//
			Integer contadorEstudios = 0;
			if(formaciones!=null){
				Iterator<Object> itFormaciones = formaciones.iterator();
				while(itFormaciones.hasNext()){
					GppFormacion formacion = (GppFormacion) itFormaciones.next();
					if(formacion.getNacNidnivelac()==3){
						contadorEstudios++;
					}
				}
			}
			//
			numFila +=1;
			numColumna = 1;
			fila = hoja.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("Matrícula Profesional:");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantilla2);
			if(contadorPregrados==0)
				hoja.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna));
			else
				hoja.addMergedRegion(new CellRangeAddress(numFila,numFila+contadorPregrados-1,numColumna,numColumna));
			//
			String pregradoTarjeta = "";
			if(formaciones!=null){
				Iterator<Object> itFormaciones = formaciones.iterator();
				numColumna += 1;
				while(itFormaciones.hasNext()){
					GppFormacion formacion = (GppFormacion) itFormaciones.next();
					if(formacion.getNacNidnivelac()==3){
						pregradoTarjeta = formacion.getForVtitulo()+": "+formacion.getForVtarjetaprof();
						fila = hoja.getRow(numFila);
						celda = fila.getCell(numColumna);
						texto = new HSSFRichTextString(pregradoTarjeta);
						celda.setCellValue(texto);
						celda.setCellStyle(estiloContenido);
						numFila += 1;
					}
				}
			}
			//
			Integer filaFin = numFila-1;
			numFila = filaInicio;
			numColumna = 0;
			fila = hoja.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("Información Personal");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantilla);
			hoja.addMergedRegion(new CellRangeAddress(numFila,filaFin,numColumna,numColumna));
			//
			numFila = filaFin;
			numFila += 3;
			filaInicio = numFila;
			//			
			numColumna += 1;
			fila = hoja.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("Fecha");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantilla2);
			//			
			numColumna += 1;
			fila = hoja.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("Título");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantilla2);
			//
			if(formaciones!=null){
				numFila += 1;
				Iterator<Object> itFormaciones = formaciones.iterator();
				simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
				while(itFormaciones.hasNext()){
					numColumna = 1;
					GppFormacion formacion = (GppFormacion) itFormaciones.next();
					numColumna = 1;
					fila = hoja.getRow(numFila);
					celda = fila.getCell(numColumna);
					texto = new HSSFRichTextString(simpleDateFormat.format(formacion.getForDfecgrado()));
					celda.setCellValue(texto);
					celda.setCellStyle(estiloContenido);
					//			
					numColumna += 1;
					fila = hoja.getRow(numFila);
					celda = fila.getCell(numColumna);
					texto = new HSSFRichTextString(formacion.getForVtitulo());
					celda.setCellValue(texto);
					celda.setCellStyle(estiloContenido);
					numFila += 1;
				}
			}			
			//			
			numFila += 1;
			numColumna = 1;
			fila = hoja.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("Herramientas de Software");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantilla2);
			//			
			GppPerfilprof perfil = persona.getGppPerfilprofesional();
			numFila += 1;
			numColumna = 1;
			fila = hoja.getRow(numFila);
			celda = fila.getCell(numColumna);
			String herramientas = "";
			if(perfil!=null)
				if(perfil.getPprVherrasw()!=null)
					herramientas = perfil.getPprVherrasw();
			texto = new HSSFRichTextString(herramientas);
			celda.setCellValue(texto);
			celda.setCellStyle(estiloContenido);
			hoja.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
			
			//
			numColumna = 0;
			filaFin = numFila;
			numFila = filaInicio;
			fila = hoja.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("Educación");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantilla);
			hoja.addMergedRegion(new CellRangeAddress(numFila,filaFin,numColumna,numColumna));
			
			//
			List<Object> experiencias = persona.getGppExperienciasLaborales();
			numFila = filaFin;
			numFila += 3;
			filaInicio = numFila;
			numColumna = 1;
			fila = hoja.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("Fecha");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantilla2);
			//			
			numColumna += 1;
			fila = hoja.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("Empresa");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantilla2);
			//			
			numColumna += 1;
			fila = hoja.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("Ciudad");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantilla2);
			
			numFila += 1;
			numColumna = 0;
			if(experiencias!=null){
				Iterator<Object> itExperiencias = experiencias.iterator();
				simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
				while(itExperiencias.hasNext()){
					GppExperiencia experiencia = (GppExperiencia) itExperiencias.next();
					String fechas = "";
					numColumna += 1;
					fila = hoja.getRow(numFila);
					celda = fila.getCell(numColumna);
					if(experiencia.getExpDfecretiro()!=null)
						fechas = simpleDateFormat.format(experiencia.getExpDfecingreso()) + "-" + simpleDateFormat.format(experiencia.getExpDfecretiro());
					else
						fechas = simpleDateFormat.format(experiencia.getExpDfecingreso()) +" - Actual";
					texto = new HSSFRichTextString(fechas);
					celda.setCellValue(texto);
					celda.setCellStyle(estiloContenido);
					//			
					numColumna += 1;
					fila = hoja.getRow(numFila);
					celda = fila.getCell(numColumna);
					texto = new HSSFRichTextString(experiencia.getExpVnomempresa());
					celda.setCellValue(texto);
					celda.setCellStyle(estiloContenido);
					//
					mpio = municipioService.buscarPorIdMunicipio(experiencia.getMunVidmunicipio());
					numColumna += 1;
					fila = hoja.getRow(numFila);
					celda = fila.getCell(numColumna);
					if(mpio!=null)
						texto = new HSSFRichTextString(mpio.getMunVmunicipio());
					else
						texto = new HSSFRichTextString("");
					celda.setCellValue(texto);
					celda.setCellStyle(estiloContenido);
					//
					numFila +=1;
					numColumna = 1;
					fila = hoja.getRow(numFila);
					celda = fila.getCell(numColumna);
					texto = new HSSFRichTextString("Logros Laborales:");
					celda.setCellValue(texto);
					celda.setCellStyle(estiloPlantilla2);
					//
					numColumna += 1;
					fila = hoja.getRow(numFila);
					celda = fila.getCell(numColumna);
					texto = new HSSFRichTextString(experiencia.getExpVfuncionlogro());
					celda.setCellValue(texto);
					celda.setCellStyle(estiloContenido);
					hoja.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+1));
					numFila += 2;
					numColumna = 0;
				}
			}
			//
			filaFin = numFila-2;
			numFila = filaInicio;
			fila = hoja.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("Experiencia Profesional");
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantilla);
			if(numFila>filaFin)
				hoja.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna));
			else
				hoja.addMergedRegion(new CellRangeAddress(numFila,filaFin,numColumna,numColumna));
			//
			numFila = filaFin;
			numFila += 5;
			numColumna = 0;
			fila = hoja.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString(persona.getPerVnombres() + " " + persona.getPerVapellidos());
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantilla);	
			hoja.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+3));
			
			numFila += 1;
			numColumna = 0;
			fila = hoja.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString("C.C. "+persona.getPerNidentificacion().toString());
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantilla);					
			hoja.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna+3));

			//
			numFila += 4;
			numColumna = 3;
			fila = hoja.getRow(numFila);
			celda = fila.getCell(numColumna);
			texto = new HSSFRichTextString(persona.getPerVnombres() + " " + persona.getPerVapellidos());
			celda.setCellValue(texto);
			celda.setCellStyle(estiloPlantilla2);	
			hoja.addMergedRegion(new CellRangeAddress(numFila,numFila,numColumna,numColumna));
			
			numColumna = 3;
			formaciones = persona.getGppFormaciones();
			if(formaciones!=null){
				Iterator<Object> itFormaciones = formaciones.iterator();
				while(itFormaciones.hasNext()){
					GppFormacion formacion = (GppFormacion) itFormaciones.next();
					if(formacion.getNacNidnivelac()>=3 && formacion.getNacNidnivelac()<=8){
						numFila += 1;
						fila = hoja.getRow(numFila);
						celda = fila.getCell(numColumna);
						texto = new HSSFRichTextString(formacion.getForVtitulo());
						celda.setCellValue(texto);
						celda.setCellStyle(estiloContenido);
					}
				}
			}			
			for (int i = 0; i <= 100; i++) {
				hoja.autoSizeColumn(i,true);	
			}
			
			String rutaSalidaExportacion = ( (GppParametrizacion) parametrizacionService.buscarPorIdParametrizacion(2) ).getParVvalor();
			if(rutaSalidaExportacion!=null){
				String nombreArchivo = "FORMATO_HV_"+persona.getPerNidentificacion()+".xls";		
				FileOutputStream formatoExportado = new FileOutputStream(rutaSalidaExportacion+nombreArchivo);
				libro.write(formatoExportado);
				formatoExportado.close();		
				estadoOperacion = true;
			}			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return estadoOperacion;
	}
}