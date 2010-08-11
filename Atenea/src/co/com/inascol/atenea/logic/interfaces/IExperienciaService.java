package co.com.inascol.atenea.logic.interfaces;

import java.util.Date;
import java.util.List;

import co.com.inascol.atenea.entity.GppExperiencia;
import co.com.inascol.atenea.entity.GppUsuario;
/**
 * @author Guillermo Toro
 *
 */
public interface IExperienciaService {

	public boolean crearExperiencia(String nombreEmpresa, String telefonoEmpresa, String nombreContacto, String emailContacto,
									String nombreCargo, Date fechaIngreso, Date fechaRetiro, String herramientasSoftware, String funcionesLogros,
									Integer docCertificacion1, Integer docCertificacion2, Integer idMunicipio, Integer cargoEquivalente, Integer idPersona, GppUsuario usuarioAutenticado);
	public boolean actualizarExperiencia(Integer idExperiencia, String nombreEmpresa, String telefonoEmpresa, String nombreContacto, String emailContacto,
											String nombreCargo, Date fechaIngreso, Date fechaRetiro, String herramientasSoftware, String funcionesLogros,
											Integer docCertificacion1, Integer docCertificacion2, Integer idMunicipio, Integer cargoEquivalente, Integer idPersona, GppUsuario usuarioAutenticado);
	public boolean borrarExperiencia(Integer idExperiencia);
	public GppExperiencia buscarExperienciaPorId(Integer idExperiencia);
	public List<Object> buscarExperienciasLaborales();
	public List<Object> buscarExperienciasPersona(Integer idPersona);
}