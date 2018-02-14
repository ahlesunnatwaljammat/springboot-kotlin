package learn.launcher

import edu.learn.mongo.repos.CustomerRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import edu.learn.mongo.entities.Customer
import edu.learn.mongo.entities.User
import edu.learn.mongo.repos.UserRepo
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.mongodb.config.EnableMongoAuditing
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories
import java.util.*


@SpringBootApplication
@ComponentScan(basePackages = ["edu.learn"])
@EnableReactiveMongoRepositories(basePackages = ["edu.learn.mongo.repos"])
@EnableMongoAuditing
class MongoLauncher {
    @Autowired
    lateinit var customerRepo: CustomerRepo

    @Autowired
    lateinit var userRepo: UserRepo

    @Bean
    fun initData() : CommandLineRunner {
        return CommandLineRunner {
            this.customerRepo.save(Customer(5,"Noman","Abbasi")).subscribe()

            this.customerRepo.saveAll(
                    Arrays.asList(Customer(1, "Walter", "White"),
                            Customer(2, "Skyler", "White"),
                            Customer(3, "Saul", "Goodman"),
                            Customer(4, "Jesse", "Pinkman")
                    )
            ).subscribe()

            this.customerRepo.findAll().toStream().forEach { println(it) }
            this.customerRepo.deleteAll().subscribe()
            println("Customer : After delete ...")
            this.customerRepo.findAll().toStream().forEach { println(it) }

            println("=================================================")
            this.userRepo.insert(User(username = "nabbasi", password = "x1")).subscribe()

            val list = mutableListOf<User>()
            list.add(User(username = "aabbasi", password = "x2"))
            list.add(User(username = "fabbasi", password = "x3"))
            this.userRepo.insert(list).subscribe()

            this.userRepo.findAll().toStream().forEach { println(it) }
            this.userRepo.deleteAll().subscribe()
            println("User : After delete ...")
            this.userRepo.findAll().toStream().forEach { println(it) }

        }
    }
}

fun main(args: Array<String>) {
    runApplication<MongoLauncher>(*args)
}