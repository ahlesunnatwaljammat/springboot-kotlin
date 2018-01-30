package edu.learn.config

import edu.learn.jersey.ws.UserJerseyRest
import org.glassfish.jersey.server.ResourceConfig
import org.springframework.context.annotation.Configuration

@Configuration
class JerseyConfig : ResourceConfig() {
    init {
        registerEndpoints()
    }

    private fun registerEndpoints() {
        register(GenericExceptionMapper())
        register(UserJerseyRest::class.java)
    }
}