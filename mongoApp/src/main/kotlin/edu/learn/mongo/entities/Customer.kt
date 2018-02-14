package edu.learn.mongo.entities

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "customers")
data class Customer (
    @Id private val customerId : Long = -1,
    private val firstName : String = "",
    private val lastName : String = ""
)