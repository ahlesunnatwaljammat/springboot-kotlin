package edu.learn.jpa.repos

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.data.repository.PagingAndSortingRepository
import java.io.Serializable

@NoRepositoryBean
interface GenericRepo<T,ID : Serializable> : JpaRepository<T,ID>, PagingAndSortingRepository<T,ID>