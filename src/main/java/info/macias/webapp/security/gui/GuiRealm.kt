package info.macias.webapp.security.gui

import org.apache.shiro.authc.*
import org.apache.shiro.realm.AuthenticatingRealm
import org.apache.shiro.subject.SimplePrincipalCollection

/**
 * Authenticating realm for Console GUI users, which are logged through an HTTP form

 * @author Mario Macias (http://github.com/mariomac)
 */
class GuiRealm : AuthenticatingRealm() {

    /**
     * Returns true if the token is an instance of [org.apache.shiro.authc.UsernamePasswordToken]
     * @param token
     * *
     * @return
     */
    override fun supports(token: AuthenticationToken?): Boolean {
        return token is UsernamePasswordToken
    }

    /**
     * Checks the validity of the received [UsernamePasswordToken]
     * @see AuthenticatingRealm.doGetAuthenticationInfo
     * @param authenticationToken
     * *
     * @return
     * *
     * @throws AuthenticationException
     */
    @Throws(AuthenticationException::class)
    override fun doGetAuthenticationInfo(authenticationToken: AuthenticationToken): AuthenticationInfo? {
        val token = authenticationToken as UsernamePasswordToken
        val userLogin = token.username
        val userPassword = String(token.password)

        // todo: implement your own user/pass check through a database
        if ("user" == userLogin && "user" == userPassword) {
            return createAuthenticationInfo(token)
        } else {
            return null
        }
    }

    companion object {
        val REALM_NAME = "consoleRealm"

        private fun createAuthenticationInfo(token: UsernamePasswordToken): AuthenticationInfo {
            val authInfo = SimpleAuthenticationInfo()
            authInfo.credentials = token.credentials
            val principals = SimplePrincipalCollection()
            principals.add(token.principal, REALM_NAME)
            authInfo.principals = principals
            return authInfo
        }
    }

}