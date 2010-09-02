package co.com.inascol.atenea.logic.interfaces;

import java.util.Date;
import java.util.List;

import co.com.inascol.atenea.entity.GppPersona;
import co.com.inascol.atenea.entity.GppUsuario;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcción de Software
 * Esp. Sistemas de Información Geográfica
 * Ing. Catastral y Geodesta
 */
public interface IPersonaService {

	public boolean crearPersona(String nombrePersona, String apellidoPersona, Integer numeroIdentificacion, String sexo, Date fechaNacimiento,
								String libretaMilitar, String celular, String email, String direccion, String telefono, Integer idMunicipio,
								Integer tipoDocumento, Integer idEstadoCivil, Integer idPaisResidencia, Integer idMunicipioResidencia, Boolean usuarioActivo, GppUsuario usuarioAutenticado);
	public boolean actualizarPersona(Integer idPersona, String nombrePersona, String apellidoPersona, Integer numeroIdentificacion, String sexo, Date fechaNacimiento,
										String libretaMilitar, String celular, String email, String direccion, String telefono, Integer idMunicipio,
										Integer tipoDocumento, Integer idEstadoCivil, Integer idPaisResidencia, Integer idMunicipioResidencia, Boolean usuarioActivo, GppUsuario usuarioAutenticado);
	public boolean borrarPersona(Integer idPersona);
	public GppPersona buscarPersonaPorId(Integer idPersona);
	public List<Object> buscarPersonas();
	public List<Object> buscarPersonaPorCriterios(List<Object> criteriosBusqueda);
	public List<Object> buscarPersonaPorCriteriosAvanzados(List<Object> criteriosBusqueda);
	public List<Object> buscarPersonaPorCriterioRapido(String criterioBusquedaRapida);
}