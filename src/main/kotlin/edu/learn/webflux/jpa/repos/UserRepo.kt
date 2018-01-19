package edu.learn.webflux.jpa.repos

import edu.learn.webflux.jpa.entities.User
import org.springframework.data.repository.CrudRepository

interface UserRepo : CrudRepository<User, Long>