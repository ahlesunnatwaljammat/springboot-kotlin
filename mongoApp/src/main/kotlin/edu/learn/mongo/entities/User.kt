package edu.learn.mongo.entities

import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "users")
data class User (
    private val userId : String = UUID.randomUUID().toString(),
    private val username : String = "",
    private val password : String = ""
)