package edu.learn.webflux

import com.fasterxml.jackson.module.kotlin.KotlinModule
import edu.learn.webflux.jpa.entities.User
import edu.learn.webflux.jpa.repos.UserRepo
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@SpringBootApplication
class WebfluxApplication {
    private val log = LoggerFactory.getLogger(WebfluxApplication::class.java)


    @Bean
    fun addDefaultUser(userRepo : UserRepo) : CommandLineRunner {
        return CommandLineRunner {
            userRepo.save(User(username = "nabbasi",password = "x"))
            userRepo.save(User(username = "wahmed",password = "x"))
            userRepo.save(User(username = "fabbasi",password = "x"))
        }
    }

    @Bean
    fun allUsers(userRepo: UserRepo) = CommandLineRunner {
        log.info("Users found with findAll():")
        log.info("-------------------------------")
        userRepo.findAll().forEach { log.info(it.toString()) }
        log.info("")
    }
}

fun main(args: Array<String>) {
    //runApplication<WebfluxApplication>(*args)

    SpringApplication.run(WebfluxApplication::class.java, *args)
}

/**
 *  This dependency is use return Kotlin class as json
 *  <dependency>
 *      <groupId>com.fasterxml.jackson.module</groupId>
 *      <artifactId>jackson-module-kotlin</artifactId>
 *  </dependency>
 * Following configuration is optional
 */
/*
@Configuration
class KotlinModuleConfiguration {
    @Bean
    fun kotlinModule() : KotlinModule {
        return KotlinModule()
    }
}*/
