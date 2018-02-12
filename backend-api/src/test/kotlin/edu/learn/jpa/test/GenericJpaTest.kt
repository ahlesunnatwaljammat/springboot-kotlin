package edu.learn.jpa.test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.data.repository.NoRepositoryBean

@DataJpaTest
@EnableJpaRepositories(basePackages = ["edu.learn.jpa.repos"])
@EntityScan(basePackages = ["edu.learn.jpa.entities"])
@NoRepositoryBean
class GenericJpaTest {
    @Autowired
    lateinit var entityManager: TestEntityManager
}