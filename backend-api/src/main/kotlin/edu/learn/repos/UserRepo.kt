package edu.learn.repos

import edu.learn.entities.User
import org.springframework.data.repository.CrudRepository

interface UserRepo : CrudRepository<User, Long>