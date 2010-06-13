package co.com.inascol.atenea.logic;

import java.util.Date;
import java.util.List;

import co.com.inascol.atenea.dao.GppPersonaDAO;
import co.com.inascol.atenea.entity.GppPersona;
import co.com.inascol.atenea.logic.interfaces.IPersonaService;

public class PersonaService implements IPersonaService{

	private Boolean estadoOperacion;
	private GppPersonaDAO gppPersonaDAO;
	private GppPersona gppPersona;
	private List<Object> gppPersonas;
	
	public boolean actualizarPersona(Integer idPersona, String nombrePersona,
			String apellidoPersona, Integer numeroIdentificacion, String sexo,
			Date fechaNacimiento, String libretaMilitar, String celular,
			String email, String direccion, String telefono,
			String idMunicipio, Integer tipoDocumento, Integer idEstadoCivil) {
		estadoOperacion = false;
		try{			
			gppPersonaDAO = new GppPersonaDAO();
			gppPersona = new GppPersona();
			gppPersona.setPerNidpersona(idPersona);
			gppPersona.setPerVnombres(nombrePersona);
			gppPersona.setPerVapellidos(apellidoPersona);
			gppPersona.setPerNidentificacion(numeroIdentificacion);
			gppPersona.setPerVsexo(sexo);
			gppPersona.setPerDfecnacimiento(fechaNacimiento);
			gppPersona.setPerVlibretamilitar(libretaMilitar);
			gppPersona.setPerVmovil(celular);
			gppPersona.setPerVemail(email);
			gppPersona.setPerVdireccion(direccion);
			gppPersona.setPerVtelefono(telefono);
			gppPersona.setMunVidmunicipio(idMunicipio);
			gppPersona.setTdcNidtipodoc(tipoDocumento);
			gppPersona.setEscNidestadocivil(idEstadoCivil);
			gppPersona.setPerVusumodifica("Memo");
			gppPersona.setPerDfecmodifica(new Date());
			estadoOperacion = gppPersonaDAO.actualizar(gppPersona);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public boolean borrarPersona(Integer idPersona) {
		estadoOperacion = false;
		try{			
			gppPersonaDAO = new GppPersonaDAO();
			estadoOperacion = gppPersonaDAO.borrar(idPersona);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public GppPersona buscarPersonaPorId(Integer idPersona) {
		gppPersona = null;
		try{			
			gppPersonaDAO = new GppPersonaDAO();
			gppPersona = (GppPersona) gppPersonaDAO.buscarPorId(idPersona);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppPersona;
	}

	public List<Object> buscarPersonas() {
		gppPersonas = null;
		try{			
			gppPersonaDAO = new GppPersonaDAO();
			gppPersonas = gppPersonaDAO.buscarTodos();
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return gppPersonas;
	}

	public boolean crearPerson(String nombrePersona, String apellidoPersona,
			Integer numeroIdentificacion, String sexo, Date fechaNacimiento,
			String libretaMilitar, String celular, String email,
			String direccion, String telefono, String idMunicipio,
			Integer tipoDocumento, Integer idEstadoCivil) {
		estadoOperacion = false;
		try{			
			gppPersonaDAO = new GppPersonaDAO();
			gppPersona = new GppPersona();
			gppPersona.setPerVnombres(nombrePersona);
			gppPersona.setPerVapellidos(apellidoPersona);
			gppPersona.setPerNidentificacion(numeroIdentificacion);
			gppPersona.setPerVsexo(sexo);
			gppPersona.setPerDfecnacimiento(fechaNacimiento);
			gppPersona.setPerVlibretamilitar(libretaMilitar);
			gppPersona.setPerVmovil(celular);
			gppPersona.setPerVemail(email);
			gppPersona.setPerVdireccion(direccion);
			gppPersona.setPerVtelefono(telefono);
			gppPersona.setMunVidmunicipio(idMunicipio);
			gppPersona.setTdcNidtipodoc(tipoDocumento);
			gppPersona.setEscNidestadocivil(idEstadoCivil);
			gppPersona.setPerVusucrea("Memo");
			gppPersona.setPerDfeccrea(new Date());
			estadoOperacion = gppPersonaDAO.crear(gppPersona);
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return estadoOperacion;
	}

	public GppPersona buscarPersonaPorCedula(Integer numeroCedula) {
		gppPersonaDAO = new GppPersonaDAO();
		gppPersona = gppPersonaDAO.buscarPersonaPorCedula(numeroCedula);
		return gppPersona;
	}		
}