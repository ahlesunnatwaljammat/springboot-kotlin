package edu.learn.webflux.ws

import edu.learn.webflux.jpa.entities.User
import edu.learn.webflux.jpa.repos.UserRepo
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Flux
import java.util.stream.Stream

@RestController
@RequestMapping("/api/user")
class UserService (private val userRepo: UserRepo){
    @GetMapping(path = ["/all"], produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    fun getAllUsers() : Flux<MutableList<User>> {
        val users = this.userRepo.findAll()
        return Flux.just(users as MutableList<User>)
    }
}