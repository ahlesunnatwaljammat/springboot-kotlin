package edu.learn.mongo.repos

import edu.learn.mongo.entities.Customer
import org.springframework.data.mongodb.repository.Query
import reactor.core.publisher.Mono


interface CustomerRepo : MongoGenericRepo<Customer, Long> {
    @Query("{ 'firstname': ?0, 'lastname': ?1}")
    fun findByFirstnameAndLastname(firstname: String, lastname: String): Mono<Customer>
}