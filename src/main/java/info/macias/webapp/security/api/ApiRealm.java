package info.macias.webapp.security.api;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.subject.SimplePrincipalCollection;

/**
 * Realm for REST API clients that send their credentials as an HTTP header
 *
 * @author Mario Macias (http://github.com/mariomac)
 */
public class ApiRealm extends AuthenticatingRealm {
    private final static String REALM_NAME = "apiRealm";

    /**
     * Default constructor.
     */
    public ApiRealm() {
        setAuthenticationTokenClass(ApiToken.class);
    }

    /**
     * Checks the validity of the received {@link ApiToken}.
     *
     * @see AuthenticatingRealm#doGetAuthenticationInfo(AuthenticationToken)
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        ApiToken apiToken = (ApiToken) authenticationToken;
        String apiKey = apiToken.getRemoteKeyUUID();
        // TODO: use your own KEY validity comparator (e.g. accessing to the DB)
        if("test".equals(apiKey)) {
            SimpleAuthenticationInfo authInfo = new SimpleAuthenticationInfo();
            authInfo.setCredentials(apiKey);
            authInfo.setPrincipals(new SimplePrincipalCollection(apiKey, REALM_NAME));
            return authInfo;
        } else {
            return null;
        }
    }
}
