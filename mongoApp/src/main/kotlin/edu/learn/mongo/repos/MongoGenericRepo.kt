package edu.learn.mongo.repos;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.data.repository.reactive.ReactiveCrudRepository

@NoRepositoryBean
interface MongoGenericRepo<T, ID> : ReactiveCrudRepository<T, ID>, ReactiveMongoRepository<T, ID>