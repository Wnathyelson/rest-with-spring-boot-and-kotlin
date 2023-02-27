package br.com.kt.data.vo.v2

import java.util.Date

data class PersonVO (

    var id: Long = 0,
    var firstName: String = "",
    var lastName: String = "",
    var gender: String = "",
    var address: String = "",
    var birthDay: Date? = null
)