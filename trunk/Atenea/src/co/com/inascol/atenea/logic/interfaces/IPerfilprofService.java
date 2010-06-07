package co.com.inascol.atenea.logic.interfaces;

import java.util.List;

import co.com.inascol.atenea.entity.GppPerfilprof;

public interface IPerfilprofService {

	public boolean crearPerfilProfesional(String perfilProfesional, Integer nivelIdioma1, Integer nivelIdioma2, String herramientasSoftware,
											String motoresBD, Integer idPerfilEquivalente, Integer idPersona, Integer idIdioma1, Integer idIdioma2);
	public boolean actualizarPerfilProfesional(Integer idPerfilProfesional, String perfilProfesional, Integer nivelIdioma1, Integer nivelIdioma2, String herramientasSoftware,
												String motoresBD, Integer idPerfilEquivalente, Integer idPersona, Integer idIdioma1, Integer idIdioma2);
	public boolean borrarPerfilProfesional(Integer idPerfilProfesional);
	public GppPerfilprof buscarPerfilProfesionarlPorId(Integer idPerfilProfesional);
	public List<Object> buscarPerfilesProfesionales(); 
}