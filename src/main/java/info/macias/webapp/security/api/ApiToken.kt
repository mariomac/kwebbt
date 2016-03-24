package info.macias.webapp.security.api

import org.apache.shiro.authc.AuthenticationToken

/**
 * Authentication token for REST API clients that send their credentials by means of an HTTP header

 * @author Mario Macias (http://github.com/mariomac)
 */
class ApiToken
/**
 * Instantiates the class from a remote API key value
 * @param remoteKeyUUID
 */
(val remoteKeyUUID: String) : AuthenticationToken {

    /**
     * Returns the same as getRemoteKeyUUID
     * @return
     */
    override fun getPrincipal(): Any {
        return remoteKeyUUID
    }

    /**
     * Returns the same as getRemoteKeyUUID
     * @return
     */
    override fun getCredentials(): Any {
        return remoteKeyUUID
    }
}
