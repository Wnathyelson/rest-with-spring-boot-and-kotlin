package br.com.kt.restspringbootkt.services

import br.com.kt.restspringbootkt.model.Person
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {

    private val counter: AtomicLong = AtomicLong()

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findPersonById(id: Long): Person {
        logger.info("Finding one person!")
        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "Wellington"
        person.lastName = "Lima"
        person.gender = "Masculino"
        person.address = "STMPABR"
    return person

    }fun findAllPerson(): List<Person> {
        logger.info("Finding all persons!")
        val persons: MutableList<Person> = ArrayList()
        for (i in 0..7){
            val person = mockPerson(i)
            persons.add(person)
        }
        return persons
    }

    private fun mockPerson(i: Int): Person {

        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "First Name $i"
        person.lastName = "Last Name $i"
        person.gender = "Male"
        person.address = "Some Address in Brazil"

        return person
    }
}