package br.com.kt.repository

import br.com.kt.model.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<Person, Long?>