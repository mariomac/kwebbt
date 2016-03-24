package info.macias.webapp.security.api;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * Authentication token for REST API clients that send their credentials by means of an HTTP header
 *
 * @author Mario Macias (http://github.com/mariomac)
 */
public class ApiToken implements AuthenticationToken {

    private String remoteKeyUUID;

    /**
     * Instantiates the class from a remote API key value
     * @param remoteKeyUUID
     */
    public ApiToken(String remoteKeyUUID) {
        this.remoteKeyUUID = remoteKeyUUID;
    }

    public final String getRemoteKeyUUID() {
        return remoteKeyUUID;
    }

    /**
     * Returns the same as getRemoteKeyUUID
     * @return
     */
    @Override
    public Object getPrincipal() {
        return getRemoteKeyUUID();
    }

    /**
     * Returns the same as getRemoteKeyUUID
     * @return
     */
    @Override
    public Object getCredentials() {
        return getRemoteKeyUUID();
    }
}
