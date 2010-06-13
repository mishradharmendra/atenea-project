package co.com.inascol.atenea.logic.interfaces;

import java.util.Date;
import java.util.List;

import co.com.inascol.atenea.entity.GppPersona;

public interface IPersonaService {

	public boolean crearPerson(String nombrePersona, String apellidoPersona, Integer numeroIdentificacion, String sexo, Date fechaNacimiento,
								String libretaMilitar, String celular, String email, String direccion, String telefono, String idMunicipio,
								Integer tipoDocumento, Integer idEstadoCivil);
	public boolean actualizarPersona(Integer idPersona, String nombrePersona, String apellidoPersona, Integer numeroIdentificacion, String sexo, Date fechaNacimiento,
										String libretaMilitar, String celular, String email, String direccion, String telefono, String idMunicipio,
										Integer tipoDocumento, Integer idEstadoCivil);
	public boolean borrarPersona(Integer idPersona);
	public GppPersona buscarPersonaPorId(Integer idPersona);
	public List<Object> buscarPersonas();
	public GppPersona buscarPersonaPorCedula(Integer numeroCedula);
}