package edu.learn.test

import edu.learn.mongo.repos.UserRepo
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.assertj.core.api.Assertions.assertThat
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [UserMongoTest::class])
@ComponentScan(basePackages = ["edu.learn"])
@EnableReactiveMongoRepositories(basePackages = ["edu.learn.mongo.repos"])
@EnableAutoConfiguration
class UserMongoTest {

    @Autowired
    lateinit var userRepo : UserRepo

    @Test
    fun findAllUser(){
        val stream = this.userRepo.findAll().toStream()
        stream.forEach { println(it) }
       assertThat(this.userRepo.findAll())
    }
}