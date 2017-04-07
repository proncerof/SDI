package uo.sdi.presentation.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uo.sdi.dto.User;

/**
 * Servlet Filter implementation class UserFilter
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, 
						urlPatterns = { "/UserFilter/*" }, 
						initParams = { 
			@WebInitParam(name = "LoginParam", value = "/AnonymousFilter/index.xhtml"),
			@WebInitParam(name = "AdminParam", value = "/AdminFilter/principalAdministrador.xhtml")})
public class UserFilter implements Filter {

	// Necesitamos acceder a los parámetros de inicialización en
	// el método doFilter por lo que necesitamos la variable
	// config que se inicializará en init()
	FilterConfig config = null;

	public UserFilter() {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// Iniciamos la variable de instancia config
		config = fConfig;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// Si no es petición HTTP nada que hacer
		if (!(request instanceof HttpServletRequest)) {
			chain.doFilter(request, response);
			return;
		}
		// En el resto de casos se verifica que se haya hecho login previamente
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		User u = (User) session.getAttribute("user");
		if (u == null) {
			String loginForm = config.getInitParameter("LoginParam");
			// Si no hay login, redirección al formulario de login
			res.sendRedirect(req.getContextPath() + loginForm);
			return;
		} else
			if(u.getIsAdmin()){
				String loginForm = config.getInitParameter("AdminParam");
				// Si el usuario es un admmin, redireccion a principalAdmin
				res.sendRedirect(req.getContextPath() + loginForm);
				return;
			}
			chain.doFilter(request, response);
	}
}
