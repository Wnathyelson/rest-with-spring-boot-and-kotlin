package br.com.kt.restspringbootkt.controller

import br.com.kt.restspringbootkt.converters.NumberConverter
import br.com.kt.restspringbootkt.exceptions.ResourceNotFoundException
import br.com.kt.restspringbootkt.math.SimpleMath
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MathController {

    private val simpleMath: SimpleMath = SimpleMath()

    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw ResourceNotFoundException("Please, insert a numeric value!")
        return simpleMath.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["/sub/{numberOne}/{numberTwo}"])
    fun sub(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw ResourceNotFoundException("Please, insert a numeric value!")
        return simpleMath.sub(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["/multi/{numberOne}/{numberTwo}"])
    fun multi(@PathVariable(value = "numberOne") numberOne: String?,
              @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw ResourceNotFoundException("Please, insert a numeric value!")
        return simpleMath.multi(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["/divi/{numberOne}/{numberTwo}"])
    fun divi(@PathVariable(value = "numberOne") numberOne: String?,
             @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw ResourceNotFoundException("Please, insert a numeric value!")
        return simpleMath.divi(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["/sqrt/{number}"])
    fun sqrt(@PathVariable(value = "number") number: String?
    ): Double {
        if (!NumberConverter.isNumeric(number))
            throw ResourceNotFoundException("Please, insert a numeric value!")
        return simpleMath.sqrt(NumberConverter.convertToDouble(number))
    }

    @RequestMapping(value = ["/mean/{numberOne}/{numberTwo}"])
    fun mean(@PathVariable(value = "numberOne") numberOne: String?,
             @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw ResourceNotFoundException("Please, insert a numeric value!")
        return simpleMath.mean(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }
}