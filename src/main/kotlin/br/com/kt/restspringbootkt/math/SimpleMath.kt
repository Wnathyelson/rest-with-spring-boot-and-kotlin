package br.com.kt.restspringbootkt.math

class SimpleMath {

    fun sum( numberOne: Double, numberTwo: Double) = numberOne + numberTwo

    fun sub( numberOne: Double, numberTwo: Double) = numberOne - numberTwo

    fun divi( numberOne: Double, numberTwo: Double) = numberOne / numberTwo

    fun multi( numberOne: Double, numberTwo: Double) = numberOne * numberTwo

    fun sqrt(number: Double) = Math.sqrt(number)

    fun mean( numberOne: Double, numberTwo: Double) = (numberOne + numberTwo) / 2
}