package info.macias.webapp.security

import java.io.IOException
import javax.servlet.*
import javax.servlet.http.HttpServletResponse

/**
 * Filter that denies all the accesses. This is done to enhance security, restricting access to all the URLs
 * that are not specified in the shiro.ini [urls] section

 * @author Mario Macias (http://github.com/mariomac)
 */
class DenyAllFilter : Filter {
    @Throws(ServletException::class)
    override fun init(filterConfig: FilterConfig) {

    }

    @Throws(IOException::class, ServletException::class)
    override fun doFilter(servletRequest: ServletRequest, servletResponse: ServletResponse, filterChain: FilterChain) {
        val hr = servletResponse as HttpServletResponse
        hr.sendError(HttpServletResponse.SC_FORBIDDEN, "Access to this URL is forbidden for ALL the users")
    }

    override fun destroy() {

    }
}