package br.com.kt.controller

import br.com.kt.data.vo.v1.PersonVO
import br.com.kt.data.vo.v2.PersonVO as PersonVOV2
import br.com.kt.services.PersonService
import br.com.kt.util.MediaType
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PutMapping

@RestController
@RequestMapping("/api/person/v1")
class PersonController {

    @Autowired
    private lateinit var personService: PersonService

    @GetMapping(
            produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML])
    fun findAllPerson(): List<PersonVO> {
        return personService.findAllPerson()
    }

    @GetMapping(
            value = ["/{id}"],
            produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML])
    fun findPersonById(@PathVariable(value = "id") id: Long): PersonVO {
        return personService.findPersonById(id)
    }

    @PostMapping(
            produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML],
            consumes = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML])
    fun create(@RequestBody person: PersonVO): PersonVO {
        return personService.create(person)

    } @PostMapping(
            value = ["/v2"],
            produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML],
            consumes = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML])
    fun createV2(@RequestBody person: PersonVOV2): PersonVOV2 {
        return personService.createV2(person)
    }

    @PutMapping(
            produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML],
            consumes = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML])
    fun update(@RequestBody person: PersonVO): PersonVO {
        return personService.update(person)
    }

    @DeleteMapping(
            produces = [MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML])
    fun deletePersonById(@PathVariable(value = "id") id: Long) : ResponseEntity <*> {
        personService.deletePersonById(id)
        return ResponseEntity.noContent().build<Any>()
    }
}
