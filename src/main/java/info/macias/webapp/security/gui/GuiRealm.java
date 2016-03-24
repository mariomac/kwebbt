package info.macias.webapp.security.gui;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.SimpleByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Authenticating realm for Console GUI users, which are logged through an HTTP form
 *
 * @author Mario Macias (http://github.com/mariomac)
 */
public class GuiRealm extends AuthenticatingRealm {
    public static final String REALM_NAME = "consoleRealm";

    /**
     * Returns true if the token is an instance of {@link org.apache.shiro.authc.UsernamePasswordToken}
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    /**
     * Checks the validity of the received {@link UsernamePasswordToken}
     * @see AuthenticatingRealm#doGetAuthenticationInfo(AuthenticationToken)
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userLogin = token.getUsername();
        String userPassword = String.copyValueOf(token.getPassword());

        // todo: implement your own user/pass check through a database
        if("user".equals(userLogin) && "user".equals(userPassword)) {
            return createAuthenticationInfo(token);
        } else {
            return null;
        }
    }

    private static AuthenticationInfo createAuthenticationInfo(UsernamePasswordToken token) {
        SimpleAuthenticationInfo authInfo = new SimpleAuthenticationInfo();
        authInfo.setCredentials(token.getCredentials());
        SimplePrincipalCollection principals = new SimplePrincipalCollection();
        principals.add(token.getPrincipal(), REALM_NAME);
        authInfo.setPrincipals(principals);
        return authInfo;
    }

}
