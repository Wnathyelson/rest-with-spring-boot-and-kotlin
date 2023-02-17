package br.com.kt.restspringbootkt.services

import br.com.kt.restspringbootkt.data.vo.v1.PersonVO
import br.com.kt.restspringbootkt.exceptions.ResourceNotFoundException
import br.com.kt.restspringbootkt.mapper.DozerMapper
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

    fun findAllPerson(): List<PersonVO> {
        logger.info("Finding all persons!")
        val persons = personRepository.findAll()
        return DozerMapper.parseListObjects(persons, PersonVO::class.java)
    }

    fun findPersonById(id: Long): PersonVO {
        logger.info("Finding one person!")
        var person = personRepository.findById(id)
                .orElseThrow { ResourceNotFoundException("No records found for this id!") }
        return DozerMapper.parseObject(person, PersonVO::class.java)
    }

    fun create(person: PersonVO): PersonVO {
        logger.info("Creating one person with name ${person.firstName}")
        var entity: Person = DozerMapper.parseObject(person, Person::class.java)
        return DozerMapper.parseObject(personRepository.save(entity), PersonVO::class.java)
    }

    fun update(person: PersonVO) : PersonVO{
        logger.info("Updating one person with id ${person.id}")
        val entity= personRepository.findById(person.id)
                .orElseThrow{ResourceNotFoundException("No Records found for this id!")}
        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender
        return DozerMapper.parseObject(personRepository.save(entity), PersonVO::class.java)
    }

    fun deletePersonById(id: Long) {
        logger.info("Deleting one person with id $id}")
        val entity = personRepository.findById(id)
                .orElseThrow { ResourceNotFoundException("No records found for this id!") }
        personRepository.delete(entity)
    }
}