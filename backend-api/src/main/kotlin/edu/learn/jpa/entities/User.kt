package edu.learn.jpa.entities
import javax.persistence.*

@Entity
data class User (
    var username : String = "",
    var password : String = "",
    @Id @GeneratedValue
    var userId : Long = -1
)