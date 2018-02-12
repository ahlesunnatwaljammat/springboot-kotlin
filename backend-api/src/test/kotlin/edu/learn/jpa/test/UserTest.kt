package edu.learn.jpa.test

import edu.learn.jpa.entities.User
import edu.learn.jpa.repos.UserRepo
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import kotlin.test.assertNotNull
import kotlin.test.assertSame


@RunWith(SpringRunner::class)
@SpringBootTest(classes = [UserTest::class])
class UserTest : GenericJpaTest() {

    @Autowired
    lateinit var userRepo: UserRepo
    val saveUser = User(-1, "nabbasi-test","pwd1-test")

    @Test
    fun User_pass1(){

        val user1 = this.entityManager.persist(saveUser)
        assertThat(user1.username).isEqualTo("nabbasi-test")


        val user2 = this.userRepo.save(saveUser)
        assertSame(user2, saveUser)
    }

    @Test
    fun User_pass2() {
        assertNotNull(this.userRepo.findAll())
    }

    @Test
    fun User_pass3() {
        this.userRepo.delete(saveUser)
        assertThat(this.userRepo.findAll().size).isEqualTo(0)
    }
}