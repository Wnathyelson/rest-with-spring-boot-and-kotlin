package br.com.kt.restspringbootkt.services

import br.com.kt.restspringbootkt.exceptions.ResourceNotFoundException
import br.com.kt.restspringbootkt.model.Person
import br.com.kt.restspringbootkt.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PersonService {

    @Autowired
    private lateinit var personRepository: PersonRepository

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAllPerson(): List<Person> {
        logger.info("Finding all persons!")
        return personRepository.findAll()
    }

    fun findPersonById(id: Long): Person {
        logger.info("Finding one person!")

        return personRepository.findById(id)
                .orElseThrow { ResourceNotFoundException("No records found for this id!") }
    }

    fun create(person: Person): Person {
        logger.info("Creating one person with name ${person.firstName}")
        return personRepository.save(person)
    }

    fun update(person: Person) : Person{
        logger.info("Updating one person with id ${person.id}")
        val entity= personRepository.findById(person.id)
                .orElseThrow{ResourceNotFoundException("No Records found for this id!")}
        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender
        return personRepository.save(entity)
    }

    fun deletePersonById(id: Long) {
        logger.info("Deleting one person with id $id}")
        val entity = personRepository.findById(id)
                .orElseThrow { ResourceNotFoundException("No records found for this id!") }
        personRepository.delete(entity)
    }
}