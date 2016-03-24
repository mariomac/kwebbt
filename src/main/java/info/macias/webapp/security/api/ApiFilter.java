package info.macias.webapp.security.api;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Filters HTTP requests from REST clients, by means of an API Key specified as a 'X-ApiKey' header.
 *
 * @author Mario Macias (http://github.com/mariomac)
 */
public class ApiFilter extends AuthenticatingFilter {
    private static final String HEADER_API_KEY = "X-ApiKey";

    private static final Logger log = LoggerFactory.getLogger(ApiFilter.class);

    /**
     * Starts the credentials creation and login process.
     * This method is called before doing login, not after failure.
     *
     * For more info, see {@link AuthenticatingFilter#onAccessDenied(ServletRequest, ServletResponse)}
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        AuthenticationToken token = createToken(request,response);
        try {
            Subject subject = getSubject(request, response);
            subject.login(token);
            return onLoginSuccess(token, subject, request, response);
        } catch (AuthenticationException e) {
            return onLoginFailure(token, e, request, response);
        }
    }

    /**
     * Returns a {@link ApiToken} as created from the HTTP request, which will be processed by the
     * available authentication realms.
     *
     * @param request
     * @param response
     * @return
     */
    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String apiKey = req.getHeader(HEADER_API_KEY);
        return new ApiToken(apiKey);
    }
}

