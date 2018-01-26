package edu.learn.launcher

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@ComponentScan(basePackages = ["edu.learn","edu.learn.ws"])
@EntityScan(basePackages = ["edu.learn.jpa.entities"])
@EnableJpaRepositories(basePackages = ["edu.learn.jpa.repos"])
class App : SpringBootServletInitializer(){
}

fun main(args: Array<String>) {
    //runApplication<App>()
    //SpringApplication.run(App::class.java,*args)
    SpringApplicationBuilder(App::class.java).run(*args)
}