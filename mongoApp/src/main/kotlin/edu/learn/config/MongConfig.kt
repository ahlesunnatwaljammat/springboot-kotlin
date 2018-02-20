package edu.learn.config

import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoClients
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.PropertySource
import org.springframework.core.env.Environment

/**
 * Enable configuration if dont want to use embedded mongo db
 */
/*@Configuration*/
//@PropertySource( "classpath:mongo-datasource.properties")
class MongConfig : AbstractReactiveMongoConfiguration() {
    @Autowired
    lateinit var env: Environment

    override fun reactiveMongoClient(): MongoClient {
        //println("Mongo name: " + env.getRequiredProperty("mongo.name"))
        return MongoClients.create()
    }

    override fun getDatabaseName(): String {
        return "test"
    }
}