package edu.learn.launcher

import edu.learn.jpa.entities.User
import edu.learn.jpa.repos.UserRepo
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EntityScan(basePackages = ["edu.learn.jpa.entities"])
@EnableJpaRepositories(basePackages = ["edu.learn.jpa.repos"])
class JPALauncher {
    private val log = LoggerFactory.getLogger(JPALauncher::class.java)


    @Bean
    fun addDefaultUser(userRepo : UserRepo) : CommandLineRunner {
        return CommandLineRunner {
            userRepo.save(User(username = "nabbasi",password = "x"))
            userRepo.save(User( username = "wahmed",password = "x"))
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

    SpringApplication.run(JPALauncher::class.java, *args)
}