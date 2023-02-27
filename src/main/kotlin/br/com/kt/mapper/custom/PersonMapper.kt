package br.com.kt.mapper.custom

import br.com.kt.data.vo.v2.PersonVO
import br.com.kt.model.Person
import org.springframework.stereotype.Service
import java.util.Date

@Service
class PersonMapper {

    fun mapEntityToVO(person: Person): PersonVO{
        val vo = PersonVO()
        vo.id = person.id
        vo.firstName = person.firstName
        vo.lastName = person.lastName
        vo.gender = person.gender
        vo.address = person.address
        vo.birthDay = Date()
        return vo
    }
    fun mapVOToEntity(person: PersonVO): Person{
        val entity = Person()
        entity.id = person.id
        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.gender = person.gender
        entity.address = person.address
        //entity.birthDay = Date()
        return entity
    }
}