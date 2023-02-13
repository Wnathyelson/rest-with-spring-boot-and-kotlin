package br.com.kt.restspringbootkt.services

import br.com.kt.restspringbootkt.model.Person
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {

    private val counter: AtomicLong = AtomicLong()

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findById(id: Long): Person {
        logger.info("Finding one person!")
        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "Wellington"
        person.lastName = "Lima"
        person.gender = "Masculino"
        person.address = "STMPABR"
    return person
    }
}