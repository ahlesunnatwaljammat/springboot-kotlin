package edu.learn.ws

import edu.learn.jpa.entities.User
import edu.learn.jpa.repos.UserRepo
import org.springframework.stereotype.Component
import java.net.URI
import javax.ws.rs.*
import javax.ws.rs.core.Response


@Component
@Path("/jersey/users")
class UserJerseyRest(private val userRepo: UserRepo) {

    @GET
    @Produces("application/json")
    @Path("/{username}")
    fun getBook(@PathParam("username") username: String): User {
        return userRepo.getUserByUsername(username)
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
        userRepo.delete(User(id!!.toLong()))
        return Response.ok().build()
    }
}
