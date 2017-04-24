package uo.sdi.rest.filters;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.User;
import uo.sdi.infrastructure.Factories;

/**
 * Servlet Filter implementation class UserFilter
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, urlPatterns = { "/rest/*" })
public class UserRestFilter implements Filter {

	// Necesitamos acceder a los parámetros de inicialización en
	// el método doFilter por lo que necesitamos la variable
	// config que se inicializará en init()
	FilterConfig config = null;

	public UserRestFilter() {
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

		String basicHeader = req.getHeader("Authorization");
		String id = req.getPathInfo().split("/")[3];

		String decoded = null;


		decoded = basicHeader.replace("Basic ", "");

		decoded = new String(DatatypeConverter.parseBase64Binary(decoded));
		
		String login = decoded.split(":")[0];
		String password = decoded.split(":")[1];

		User u;
		try {
			u = Factories.services.getUserService().findLoggableUser(login,
					password);
		} catch (BusinessException e) {
			u = null;
			e.printStackTrace();
		}

		if (u == null) {
			res.setStatus(401);

		} else {

		}

		chain.doFilter(request, response);
	}
}
