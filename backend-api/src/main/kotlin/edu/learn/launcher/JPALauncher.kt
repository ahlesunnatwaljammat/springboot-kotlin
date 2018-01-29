package edu.learn.launcher

import edu.learn.jpa.entities.User
import edu.learn.jpa.repos.UserRepo
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
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
            userRepo.save(User(username = "fabbasi",password = "xx"))
            userRepo.save(User(username = "aabbasi",password = "x"))
            userRepo.save(User( username = "iahmed",password = "xxx"))
            userRepo.save(User(username = "sabbasi",password = "xxxx"))
        }
    }

    @Bean
    fun allUsers(userRepo: UserRepo) = CommandLineRunner {
        log.info("Users found with findAll():")
        log.info("-------------------------------")
        userRepo.findAll().forEach { log.info(it.toString()) }
        log.info("")

        log.info("Users found with findAll(Pageable):")
        log.info("-------------------------------")
        val page = PageRequest.of(0,5)
        userRepo.findAll(page).forEach{log.info(it.toString())}
        log.info("")

        log.info("Users found with findByUsernameStartingWith(Username,Pageable):")
        log.info("-------------------------------")
        userRepo.findByUsernameStartingWith("i", page).forEach{log.info(it.toString())}
        log.info("")

        log.info("Users found with findByUsernameStartingWith(Username,Pageable):")
        log.info("-------------------------------")
        userRepo.findByUsernameEndingWith("d", page).forEach{log.info(it.toString())}
        log.info("")

        log.info("Users found with findByPasswordContaining(Username,Pageable):")
        log.info("-------------------------------")
        userRepo.findByPasswordContaining("xx", page).forEach{log.info(it.toString())}
        log.info("")

        log.info("Users found with login(Username,Password):")
        log.info("-------------------------------")
        log.info(userRepo.login("aabbasi", "x")?.toString())
        log.info("")

        log.info("Users found with updateUsername(ModifyUsername,OriginalUsername):")
        log.info("-------------------------------")
        log.info(userRepo.updateUsername("arsalan.abbasi", "aabbasi")?.toString())
        log.info("")

        log.info("Users found with loginByParamName(Username,Password):")
        log.info("-------------------------------")
        log.info(userRepo.loginByParamName("arsalan.abbasi", "x")?.toString())
        log.info("")
    }
}

fun main(args: Array<String>) {
    //runApplication<WebfluxApplication>(*args)

    SpringApplication.run(JPALauncher::class.java, *args)
}