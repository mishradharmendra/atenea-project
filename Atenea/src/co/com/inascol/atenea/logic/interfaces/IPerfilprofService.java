package co.com.inascol.atenea.logic.interfaces;

import java.util.List;

import co.com.inascol.atenea.entity.GppPerfilprof;
import co.com.inascol.atenea.entity.GppUsuario;
/**
 * @author Guillermo Antonio Toro Bayona
 * memo.toro@gmail.com
 * Esp. Construcción de Software
 * Esp. Sistemas de Información Geográfica
 * Ing. Catastral y Geodesta
 */
public interface IPerfilprofService {

	public boolean crearPerfilProfesional(String perfilProfesional, Integer nivelIdioma1, Integer nivelIdioma2, String herramientasSoftware,
											String motoresBD, Integer idPerfilEquivalente, Integer idPersona, Integer idIdioma1, Integer idIdioma2, GppUsuario usuarioAutenticado);
	public boolean actualizarPerfilProfesional(Integer idPerfilProfesional, String perfilProfesional, Integer nivelIdioma1, Integer nivelIdioma2, String herramientasSoftware,
												String motoresBD, Integer idPerfilEquivalente, Integer idPersona, Integer idIdioma1, Integer idIdioma2, GppUsuario usuarioAutenticado);
	public boolean borrarPerfilProfesional(Integer idPerfilProfesional);
	public GppPerfilprof buscarPerfilProfesionarlPorId(Integer idPerfilProfesional);
	public List<Object> buscarPerfilesProfesionales();
	public List<Object> buscarPerfilesProfesionalesPersona(Integer idPersona);
}