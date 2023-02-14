package br.com.kt.restspringbootkt.repository

import br.com.kt.restspringbootkt.model.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : JpaRepository<Person, Long?>