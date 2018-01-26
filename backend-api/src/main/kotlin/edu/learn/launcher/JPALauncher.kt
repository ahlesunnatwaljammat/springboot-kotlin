package edu.learn.launcher

import edu.learn.entities.User
import edu.learn.repos.UserRepo
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EntityScan(basePackages = ["edu.learn.entities"])
@EnableJpaRepositories(basePackages = ["edu.learn.repos"])
class JPALauncher {
    private val log = LoggerFactory.getLogger(JPALauncher::class.java)


    /*@Bean
    fun addDefaultUser(userRepo : UserRepo) : CommandLineRunner {
        return CommandLineRunner {
            userRepo.save(User("nabbasi","x"))
            userRepo.save(User( "wahmed","x"))
            userRepo.save(User("fabbasi","x"))
        }
    }

    @Bean
    fun allUsers(userRepo: UserRepo) = CommandLineRunner {
        log.info("Users found with findAll():")
        log.info("-------------------------------")
        userRepo.findAll().forEach { log.info(it.toString()) }
        log.info("")
    }*/
}

fun main(args: Array<String>) {
    //runApplication<WebfluxApplication>(*args)

    SpringApplication.run(JPALauncher::class.java, *args)
}