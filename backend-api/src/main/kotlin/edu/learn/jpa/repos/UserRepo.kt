package edu.learn.jpa.repos

import edu.learn.jpa.entities.User
import org.springframework.data.repository.CrudRepository

interface UserRepo : CrudRepository<User, Long>