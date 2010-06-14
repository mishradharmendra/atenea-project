package co.com.inascol.atenea.managed.bean.delegate;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import co.com.inascol.atenea.entity.GppPersona;
import co.com.inascol.atenea.logic.DepartamentoService;
import co.com.inascol.atenea.logic.DocumentoService;
import co.com.inascol.atenea.logic.EstadocivilService;
import co.com.inascol.atenea.logic.ExperienciaService;
import co.com.inascol.atenea.logic.FormacionService;
import co.com.inascol.atenea.logic.MunicipioService;
import co.com.inascol.atenea.logic.PaisService;
import co.com.inascol.atenea.logic.PersonaService;
import co.com.inascol.atenea.logic.TipodocService;
import co.com.inascol.atenea.logic.interfaces.IDepartamentoService;
import co.com.inascol.atenea.logic.interfaces.IDocumentoService;
import co.com.inascol.atenea.logic.interfaces.IEstadocivilService;
import co.com.inascol.atenea.logic.interfaces.IMunicipioService;
import co.com.inascol.atenea.logic.interfaces.IPaisService;
import co.com.inascol.atenea.logic.interfaces.IPersonaService;
import co.com.inascol.atenea.logic.interfaces.ITipodocService;

public class PersonaDelegate {

	private IPersonaService personaService;
	private IPaisService iPaisService;
	private ITipodocService tipodocService;
	private IDepartamentoService departamentoService;
	private IMunicipioService municipioService;
	private IEstadocivilService estadocivilService;
	private IDocumentoService documentoService;
	private List<Object> personas;
	private String urlArchivo;
	private String nombreArchivo;
	
	public PersonaDelegate(){}
	
	public List<Object> getListaPersonas(){
		personaService = new PersonaService();
		personas = personaService.buscarPersonas();
		return personas;
	}
	
	public List<Object> getListaPaises(){
		iPaisService = new PaisService();
		return iPaisService.buscarPaises();
	}
	
	public List<Object> getListaDepartamentos(){
		departamentoService = new DepartamentoService();
		return departamentoService.buscarDepartamentos();
	}
	
	public List<Object> getListaMunicipios(){
		municipioService = new MunicipioService();
		return municipioService.buscarMunicipios();
	}
	
	public List<Object> getListaTipoIndentificacion(){
		tipodocService = new TipodocService();
		return tipodocService.buscarTiposDocumentos();
	}
	
	public List<Object> getListaEstadosCiviles(){
		estadocivilService = new EstadocivilService();
		return estadocivilService.buscarEstadosCiviles();
	}	
	
	public boolean getGuardarPersona(GppPersona persona){
		personaService = new PersonaService();
		return personaService.crearPerson(persona.getPerVnombres(), persona.getPerVapellidos(), persona.getPerNidentificacion(), persona.getPerVsexo(), persona.getPerDfecnacimiento(), persona.getPerVlibretamilitar(), persona.getPerVmovil(), persona.getPerVemail(), persona.getPerVdireccion(), persona.getPerVtelefono(), persona.getMunVidmunicipio(), persona.getTdcNidtipodoc(), persona.getEscNidestadocivil());
	}
	
	public GppPersona getBuscarPersonaPorCedula(Integer numeroCedula){
		personaService = new PersonaService();
		return personaService.buscarPersonaPorCedula(numeroCedula);
	}
	
	public void getSubirDocumentoHojaVida(UploadEvent event) throws IOException {
	    if (event != null) {
	        UploadItem item = event.getUploadItem();
	        File file = item.getFile();
	        nombreArchivo = item.getFileName();
	        urlArchivo = "/home/memo/TEMP/" + System.currentTimeMillis() + "_" + nombreArchivo;
	        FileInputStream fis = new FileInputStream(file.getPath());
	        BufferedInputStream bis = new BufferedInputStream(fis);
	        FileOutputStream fos = new FileOutputStream(urlArchivo);
	        BufferedOutputStream bos = new BufferedOutputStream(fos);
	        try {
	            byte[] array = new byte[100];
	            int leidos = bis.read(array);
	            while (leidos > 0) {
	                bos.write(array, 0, leidos);
	                leidos = bis.read(array);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            bis.close();
	            bos.close();
	        }
	    }
	}
}