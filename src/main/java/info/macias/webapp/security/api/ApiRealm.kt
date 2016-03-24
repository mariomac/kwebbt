package info.macias.webapp.security.api

import info.macias.webapp.security.api.ApiToken
import org.apache.shiro.authc.AuthenticationException
import org.apache.shiro.authc.AuthenticationInfo
import org.apache.shiro.authc.AuthenticationToken
import org.apache.shiro.authc.SimpleAuthenticationInfo
import org.apache.shiro.realm.AuthenticatingRealm
import org.apache.shiro.subject.SimplePrincipalCollection

/**
 * Realm for REST API clients that send their credentials as an HTTP header

 * @author Mario Macias (http://github.com/mariomac)
 */
class ApiRealm : AuthenticatingRealm() {

    init {
        setAuthenticationTokenClass(ApiToken::class.java)
    }

    /**
     * Checks the validity of the received [ApiToken].

     * @see AuthenticatingRealm.doGetAuthenticationInfo
     * @param authenticationToken
     * *
     * @return
     * *
     * @throws AuthenticationException
     */
    @Throws(AuthenticationException::class)
    override fun doGetAuthenticationInfo(authenticationToken: AuthenticationToken): AuthenticationInfo? {
        val apiToken = authenticationToken as ApiToken
        val apiKey = apiToken.remoteKeyUUID
        // TODO: use your own KEY validity comparator (e.g. accessing to the DB)
        if ("test" == apiKey) {
            val authInfo = SimpleAuthenticationInfo()
            authInfo.credentials = apiKey
            authInfo.principals = SimplePrincipalCollection(apiKey, REALM_NAME)
            return authInfo
        } else {
            return null
        }
    }

    companion object {
        private val REALM_NAME = "apiRealm"
    }
}

