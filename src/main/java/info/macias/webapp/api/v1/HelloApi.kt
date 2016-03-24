package info.macias.webapp.api.v1

import javax.inject.Singleton
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Singleton
@Path("/v1")
class HelloApi {
    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    fun hello(): String {
        return "hello, man\n"
    }
}