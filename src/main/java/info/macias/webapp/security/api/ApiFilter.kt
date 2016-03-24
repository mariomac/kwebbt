package info.macias.webapp.security.api

import org.apache.shiro.authc.AuthenticationException
import org.apache.shiro.authc.AuthenticationToken
import org.apache.shiro.web.filter.authc.AuthenticatingFilter
import org.slf4j.LoggerFactory
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Filters HTTP requests from REST clients, by means of an API Key specified as a 'X-ApiKey' header.

 * @author Mario Macias (http://github.com/mariomac)
 */
class ApiFilter : AuthenticatingFilter() {

    /**
     * Starts the credentials creation and login process.
     * This method is called before doing login, not after failure.

     * For more info, see [AuthenticatingFilter.onAccessDenied]

     * @param request
     * *
     * @param response
     * *
     * @return
     * *
     * @throws Exception
     */
    @Throws(Exception::class)
    override fun onAccessDenied(request: ServletRequest, response: ServletResponse): Boolean {
        val token = createToken(request, response)
        try {
            val subject = getSubject(request, response)
            subject.login(token)
            return onLoginSuccess(token, subject, request, response)
        } catch (e: AuthenticationException) {
            return onLoginFailure(token, e, request, response)
        }

    }

    /**
     * Returns a [ApiToken] as created from the HTTP request, which will be processed by the
     * available authentication realms.

     * @param request
     * *
     * @param response
     * *
     * @return
     */
    override fun createToken(request: ServletRequest, response: ServletResponse): AuthenticationToken {
        val req = request as HttpServletRequest
        val resp = response as HttpServletResponse
        val apiKey = req.getHeader(HEADER_API_KEY)
        return ApiToken(apiKey)
    }

    companion object {
        private val HEADER_API_KEY = "X-ApiKey"

        private val log = LoggerFactory.getLogger(ApiFilter::class.java)
    }
}