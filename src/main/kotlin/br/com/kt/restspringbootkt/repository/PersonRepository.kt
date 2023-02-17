package br.com.kt.restspringbootkt.repository

import br.com.kt.restspringbootkt.model.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<Person, Long?>