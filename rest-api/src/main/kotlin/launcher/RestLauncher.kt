package edu.learn.launcher

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["edu.learn"])
class RestLauncher : SpringBootServletInitializer() {
    init {
        println("Initializing application")
    }
}

fun main(args: Array<String>) {
    SpringApplicationBuilder(RestLauncher::class.java).run(*args)
}