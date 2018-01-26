package edu.learn.launcher

import edu.learn.entities.User
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

@SpringBootApplication
class RestLauncher : SpringBootServletInitializer() {
    init {
        println("Initializing application")
    }
}

fun main(args: Array<String>) {
    SpringApplicationBuilder(RestLauncher::class.java).run(*args)
}