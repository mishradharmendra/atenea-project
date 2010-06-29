package co.com.inascol.atenea.managed.bean.delegate;

import java.util.List;

import co.com.inascol.atenea.entity.GppPerfilprof;
import co.com.inascol.atenea.logic.IdiomaService;
import co.com.inascol.atenea.logic.PerfilequivalenteService;
import co.com.inascol.atenea.logic.PerfilprofService;
import co.com.inascol.atenea.logic.interfaces.IIdiomaService;
import co.com.inascol.atenea.logic.interfaces.IPerfilequivalenteService;
import co.com.inascol.atenea.logic.interfaces.IPerfilprofService;

public class PerfilprofesionalDelegate {
	
	private IPerfilprofService perfilprofService;
	private IIdiomaService idiomaService;
	private IPerfilequivalenteService perfilequivalenteService;
	private List<Object> perfilesProfesionales;
	
	public PerfilprofesionalDelegate(){}
	
	public List<Object> getBuscarPerfilesProfesionalesPersona(Integer idPersona){
		perfilprofService = new PerfilprofService();
		perfilesProfesionales = perfilprofService.buscarPerfilesProfesionalesPersona(idPersona);
		return perfilesProfesionales;
	}
	
	public List<Object> getPerfilesProfesionalesEquivalente(){
		perfilequivalenteService = new PerfilequivalenteService();
		return perfilequivalenteService.buscarPerfilesEquivalentes();
	}
	
	public List<Object> getIdiomas(){
		idiomaService = new IdiomaService();
		return idiomaService.buscarIdiomas();
	}
	
	public Boolean getGuardarPerfil(GppPerfilprof perfilProfesional){
		perfilprofService = new PerfilprofService();
		return perfilprofService.crearPerfilProfesional(perfilProfesional.getPprVperfil(), perfilProfesional.getPprNnivelidi1(), perfilProfesional.getPprNnivelidi2(), perfilProfesional.getPprVherrasw(), perfilProfesional.getPprVmotorbd(), perfilProfesional.getPeqNidperfileq(), perfilProfesional.getPerNidpersona(), perfilProfesional.getIdiNididioma1(), perfilProfesional.getIdiNididioma2());
	}
	
	public Boolean getActualizarPerfil(GppPerfilprof perfilProfesional){
		perfilprofService = new PerfilprofService();
		return perfilprofService.actualizarPerfilProfesional(perfilProfesional.getPprNidperfilprof(), perfilProfesional.getPprVperfil(), perfilProfesional.getPprNnivelidi1(), perfilProfesional.getPprNnivelidi2(), perfilProfesional.getPprVherrasw(), perfilProfesional.getPprVmotorbd(), perfilProfesional.getPeqNidperfileq(), perfilProfesional.getPerNidpersona(), perfilProfesional.getIdiNididioma1(), perfilProfesional.getIdiNididioma2());		
	}
}