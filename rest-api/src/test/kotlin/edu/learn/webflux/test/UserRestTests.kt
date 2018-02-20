package edu.learn.webflux.test

import edu.learn.jpa.repos.UserRepo
import edu.learn.webflux.ws.UserRest
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.reactive.server.WebTestClient


@RunWith(SpringRunner::class)
@SpringBootTest( classes = [UserRest::class],webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@ComponentScan(basePackages = ["edu.learn.webflux.ws"])
@EnableJpaRepositories(basePackages = ["edu.learn.jpa.repos"])
@EntityScan(basePackages = ["edu.learn.jpa.entities"])
@EnableAutoConfiguration //Added to resolve : missing ReactiveWebServerFactory bean.
class UserRestTests {

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @Autowired
    lateinit var webTestClient : WebTestClient

	@Autowired
	lateinit var userRepo: UserRepo

	@Test
	fun call_service_by_testRestTemplate() {
		val response  = testRestTemplate.getForObject("/api/users/hello/nabbasi", String::class.java)
        Assert.assertEquals("Hello nabbasi by spring rest",response)
	}

    @Test
    fun call_service_by_webTestClient() {
        val response = webTestClient.get().uri("/api/users/hello/nabbasi")
                .accept(MediaType.TEXT_PLAIN)
                .exchange()
                .expectStatus().isOk
                .expectBody(String::class.java)
                .returnResult()
        println(response.responseBody)
        Assert.assertEquals("Hello nabbasi by spring rest", response.responseBody)
    }

    /*@Test
    fun bindController() {
        val client = WebTestClient.bindToController(UserRest())
                .build()
                .get()
                .uri("/api/users/hello/nabbasi")
                .exchange()
                .expectBody(String::class.java)
                .returnResult()

        Assert.assertEquals("Hello nabbasi by spring rest", client.responseBody)
    }*/

}