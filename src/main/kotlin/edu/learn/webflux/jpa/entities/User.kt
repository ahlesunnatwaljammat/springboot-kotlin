package edu.learn.webflux.jpa.entities

import javax.persistence.*

@Entity
data class User (
    @Id @GeneratedValue(strategy =  GenerationType.AUTO)
    var userId : Long = 0,
    var username : String = "",
    var password : String = ""
)