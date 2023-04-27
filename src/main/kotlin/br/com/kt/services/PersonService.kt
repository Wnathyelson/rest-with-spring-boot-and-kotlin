package br.com.kt.services

import br.com.kt.controller.PersonController
import br.com.kt.data.vo.v1.PersonVO
import br.com.kt.data.vo.v2.PersonVO as PersonVOV2
import br.com.kt.exceptions.ResourceNotFoundException
import br.com.kt.mapper.DozerMapper
import br.com.kt.mapper.custom.PersonMapper
import br.com.kt.model.Person
import br.com.kt.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PersonService {

    @Autowired
    private lateinit var personRepository: PersonRepository

    @Autowired
    private lateinit var mapper: PersonMapper

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAllPerson(): List<PersonVO> {
        logger.info("Finding all persons!")
        val persons = personRepository.findAll()
        val vos = DozerMapper.parseListObjects(persons, PersonVO::class.java)
        for(person in vos) {
            val withSelfRel = linkTo(PersonController:: class.java).slash(person.key).withSelfRel()
            person.add(withSelfRel)
        }
        return vos
    }

    fun findPersonById(id: Long): PersonVO {
        logger.info("Finding one person with ID $id!")
        var person = personRepository.findById(id)
                .orElseThrow { ResourceNotFoundException("No records found for this id!") }
        val personVO: PersonVO = DozerMapper.parseObject(person, PersonVO::class.java)
        val withSelfRel = linkTo(PersonController:: class.java).slash(personVO.key).withSelfRel()
        personVO.add(withSelfRel)
        return personVO
    }

    fun create(person: PersonVO): PersonVO {
        logger.info("Creating one person with name ${person.firstName}")
        var entity: Person = DozerMapper.parseObject(person, Person::class.java)
        val personVO: PersonVO = DozerMapper.parseObject(person, PersonVO::class.java)
        val withSelfRel = linkTo(PersonController:: class.java).slash(personVO.key).withSelfRel()
        personVO.add(withSelfRel)
        return personVO
    }

//    fun createV2(person: PersonVOV2): PersonVOV2 {
//        logger.info("Creating one person with name ${person.firstName}")
//        var entity: Person = mapper.mapVOToEntity(person)
//        return mapper.mapEntityToVO(personRepository.save(entity))
//    }

    fun update(person: PersonVO) : PersonVO {
        logger.info("Updating one person with id ${person.key}")
        val entity= personRepository.findById(person.key)
                .orElseThrow{ ResourceNotFoundException("No Records found for this id!") }
        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender
        val personVO: PersonVO = DozerMapper.parseObject(person, PersonVO::class.java)
        val withSelfRel = linkTo(PersonController:: class.java).slash(personVO.key).withSelfRel()
        personVO.add(withSelfRel)
        return personVO
    }

    fun deletePersonById(id: Long) {
        logger.info("Deleting one person with id $id}")
        val entity = personRepository.findById(id)
                .orElseThrow { ResourceNotFoundException("No records found for this id!") }
        personRepository.delete(entity)
    }
}