package edu.learn.config

import edu.learn.ws.UserJerseyRest
import org.glassfish.jersey.server.ResourceConfig
import org.springframework.context.annotation.Configuration
import javax.ws.rs.ApplicationPath

@Configuration
@ApplicationPath("/jersey")
class JerseyConfig : ResourceConfig() {
    init {
        register(UserJerseyRest::class.java)
    }
}