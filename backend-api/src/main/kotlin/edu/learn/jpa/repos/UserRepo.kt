package edu.learn.jpa.repos

import edu.learn.jpa.entities.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.data.jpa.repository.Modifying
import org.springframework.transaction.annotation.Isolation
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

/*import javax.transaction.Transactional*/


interface UserRepo : GenericRepo<User, Long> {
    fun getUserByUsername(username: String): User
    fun findByUsernameStartingWith(username: String, pageable : Pageable): Page<User>
    fun findByUsernameEndingWith(username: String, pageable : Pageable): Page<User>
    fun findByPasswordContaining(username: String, pageable : Pageable): Page<User>

    @Query("select u from User u where u.username = ?1 and u.password = ?2")
    fun login(username: String, password: String) : User

    @Query("select u from #{#entityName} u where u.username = :username and u.password = :password")
    fun loginByParamName(@Param("username") username: String, password: String) : User

    @Transactional(readOnly = false, isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = [Exception::class])
    @Modifying
    @Query("update User u set u.username = ?1 where u.username = ?2")
    fun updateUsername(modifyUsername: String, originalUsername: String): Int
}