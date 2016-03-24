package info.macias.webapp.security;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Filter that denies all the accesses. This is done to enhance security, restricting access to all the URLs
 * that are not specified in the shiro.ini [urls] section
 *
 * @author Mario Macias (http://github.com/mariomac)
 */
public class DenyAllFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletResponse hr = (HttpServletResponse) servletResponse;
		hr.sendError(HttpServletResponse.SC_FORBIDDEN, "Access to this URL is forbidden for ALL the users");
	}

	@Override
	public void destroy() {

	}
}
