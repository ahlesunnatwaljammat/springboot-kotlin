package edu.learn.jpa.entities
import javax.persistence.*

@Entity
data class User (
    @Id @GeneratedValue
    var userId : Long = -1,
    var username : String = "",
    var password : String = ""
)