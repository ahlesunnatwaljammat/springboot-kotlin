package edu.learn.entities
import javax.persistence.*

@Entity
data class User (
    var username : String = "",
    var password : String = "",
    @Id @GeneratedValue
    var userId : Long = -1
)