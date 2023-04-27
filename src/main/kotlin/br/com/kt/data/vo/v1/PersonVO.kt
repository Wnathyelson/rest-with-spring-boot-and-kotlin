package br.com.kt.data.vo.v1

import com.github.dozermapper.core.Mapping
import org.springframework.hateoas.RepresentationModel


data class PersonVO (

    @Mapping("id")
    var key: Long = 0,
    var firstName: String = "",
    var lastName: String = "",
    var gender: String = "",
    var address: String = ""
) : RepresentationModel<PersonVO>()