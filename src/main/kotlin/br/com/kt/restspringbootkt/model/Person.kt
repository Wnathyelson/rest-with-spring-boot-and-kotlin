package br.com.kt.restspringbootkt.model

import jakarta.persistence.*

@Entity
@Table(name = "person_table")
data class Person (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "first_name", nullable = false)
    var firstName: String = "",

    @Column(name = "last_name", nullable = false)
    var lastName: String = "",

    @Column(nullable = false)
    var gender: String = "",

    @Column(nullable = false)
    var address: String = ""
)