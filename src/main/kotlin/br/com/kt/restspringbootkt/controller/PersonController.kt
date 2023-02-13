package br.com.kt.restspringbootkt.controller

import br.com.kt.restspringbootkt.converters.NumberConverter
import br.com.kt.restspringbootkt.exceptions.UnsupportedMathOperationException
import br.com.kt.restspringbootkt.model.Person
import br.com.kt.restspringbootkt.services.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/person")
class PersonController {

    @Autowired
    private lateinit var personService: PersonService

    @GetMapping("/{id}")
    fun findPersonById(@PathVariable(value = "id") id:Long): Person {
        return personService.findPersonById(id)
    }

    @GetMapping
    fun findAllPerson(): List<Person> {
        return personService.findAllPerson()
    }
}
