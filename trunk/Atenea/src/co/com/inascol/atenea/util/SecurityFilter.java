package co.com.inascol.atenea.util;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.com.inascol.atenea.entity.GppUsuario;

public class SecurityFilter implements Filter {
	/**
	 * Variable para capturar las exclusiones
	 */
	private String [] exclusions;
	/**
	 * Variable para cargar las exclusiones del archivos web.xml
	 */
	private String exclusionConfig;
	/**
	 * Metodo de destruccion del filtro
	 */
	public void destroy() {
		// TODO Auto-generated method stub		
	}
	/**
	 * Metodo de filtrado.
	 * @param request Peticion del servlet
	 * @param response Respuesta del servlet
	 * @param chain Direccionado del filtro
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {	
		/**
		 * Cast para las peticiones a peticiones HTTP.
		 */
		System.out.println("memo ");
		HttpServletRequest requestHttp = (HttpServletRequest) request;
		HttpServletResponse responseHttp = (HttpServletResponse) response;
		/**
		 * Captura del usuario en la sesion para verificar si hay sesion activa.
		 */
		GppUsuario usuarioAutenticado = (GppUsuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAutenticado");
		String uri = requestHttp.getRequestURI();
		boolean access = false;
		/**
		 * Si existe un usuario en la sesion.
		 */
		if(usuarioAutenticado!=null){
			for (int i = 0; i < exclusions.length; i++) {
				if(uri.endsWith(exclusions[i])){
					access = true;
					break;
				}
			}
		}else {
			access = false;
		}
		/**
		 * Acceso permitido
		 */
		if(access==true){
			chain.doFilter(request, response);
		}
		/**
		 * Acceso negado
		 */
		else{
			responseHttp.sendRedirect("../faces/comun/error_autenticacion.xhtml");
		}			
	}
	/**
	 * Metodo de inicializacion de filtrado
	 * @param filterConfig Configuracion del filtrado en el web.xml
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		exclusionConfig = filterConfig.getInitParameter("exclusions");
		/**
		 * Parseo por expresion regular de las exclusiones establecidas en el config. 
		 */
		exclusions = exclusionConfig.split("[ \n\t]*,[ \n\t]*");
	}
}