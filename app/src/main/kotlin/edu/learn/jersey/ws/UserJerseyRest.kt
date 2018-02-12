package edu.learn.jersey.ws

import edu.learn.jpa.entities.User
import edu.learn.jpa.repos.UserRepo
import org.glassfish.jersey.server.ManagedAsync
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Component
import java.net.URI
import javax.ws.rs.*
import javax.ws.rs.container.AsyncResponse
import javax.ws.rs.container.Suspended
import javax.ws.rs.core.Response

/**
 * this service can be acess via http://noman:8999/app/jersey/users/nabbasi
 * /app - servlet context
 * /jersey - endpoint of jersey rest service
 */
@Component
@Path("/users")
class UserJerseyRest {

    @Autowired
    lateinit var userRepo: UserRepo

    @GET
    @Produces("application/json")
    @Path("/user/{username}")
    fun getBook(@PathParam("username") username: String) : User {
        return User(1,"n",Thread.currentThread().name)
    }

    @GET
    @Produces("application/json")
    @Path("/userasync/{username}")
    @ManagedAsync
    fun getBookAsync(@Suspended asyncResponse : AsyncResponse, @PathParam("username") username: String) {
        val page = PageRequest.of(0,2)
        asyncResponse.resume(this.userRepo.findByPasswordContaining("xxx", page).content)
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    fun addBook(user: User): Response {
        userRepo.save(user)
        return Response.created(URI.create("/" + user.userId)).build()
    }

    @DELETE
    @Path("/{id}")
    fun deleteBook(@PathParam("id") id: String): Response {
        userRepo.delete(User(id.toLong()))
        return Response.ok().build()
    }
}
