package br.com.kt.restspringbootkt.controller

import br.com.kt.restspringbootkt.model.Person
import br.com.kt.restspringbootkt.services.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/person")
class PersonController {

    @Autowired
    private lateinit var personService: PersonService

    @RequestMapping(method = [RequestMethod.GET],
            produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findAllPerson(): List<Person> {
        return personService.findAllPerson()
    }

    @RequestMapping(value = ["/{id}"], method = [RequestMethod.GET],
            produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findPersonById(@PathVariable(value = "id") id: Long): Person {
        return personService.findPersonById(id)
    }

    @RequestMapping(method = [RequestMethod.POST],
            produces = [MediaType.APPLICATION_JSON_VALUE],
            consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun create(@RequestBody person: Person): Person {
        return personService.create(person)
    }

    @RequestMapping(method = [RequestMethod.PUT],
            produces = [MediaType.APPLICATION_JSON_VALUE],
            consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun update(@RequestBody person: Person): Person {
        return personService.update(person)
    }

    @RequestMapping(method = [RequestMethod.DELETE],
            produces = [MediaType.APPLICATION_JSON_VALUE])
    fun deletePersonById(@PathVariable(value = "id") id: Long) {
        personService.deletePersonById(id)
    }
}
