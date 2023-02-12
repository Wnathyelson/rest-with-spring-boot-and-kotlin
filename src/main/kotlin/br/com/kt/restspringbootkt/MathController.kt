package br.com.kt.restspringbootkt

import br.com.kt.restspringbootkt.exceptions.UnsupportedMathOperationException
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MathController {

    @RequestMapping(value=["/sum/{numberOne}/{numberTwo}"])
    fun sum(@PathVariable (value="numberOne") numberOne: String?,
            @PathVariable (value="numberTwo") numberTwo: String?
    ): Double{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
        throw UnsupportedMathOperationException("Please, insert a numeric value!")
        return convertToDouble(numberOne) + convertToDouble(numberTwo)
    }

    @RequestMapping(value = ["/sub/{numberOne}/{numberTwo}"])
    fun sub(@PathVariable (value = "numberOne") numberOne: String?,
            @PathVariable (value = "numberTwo") numberTwo: String?
    ): Double{
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
        throw UnsupportedMathOperationException("Please, insert a numeric value!")
        return convertToDouble(numberOne) - convertToDouble(numberTwo)
    }

    @RequestMapping(value=["/multi/{numberOne}/{numberTwo}"])
    fun multi(@PathVariable (value = "numberOne") numberOne: String?,
              @PathVariable (value = "numberTwo") numberTwo: String?
    ): Double{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
        throw UnsupportedMathOperationException("Please, insert a numeric value!")
        return  convertToDouble(numberOne) * convertToDouble(numberTwo)
    }

    @RequestMapping(value=["/divi/{numberOne}/{numberTwo}"])
    fun divi(@PathVariable (value = "numberOne") numberOne: String?,
              @PathVariable (value = "numberTwo") numberTwo: String?
    ): Double{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please, insert a numeric value!")
        return  convertToDouble(numberOne) / convertToDouble(numberTwo)
    }

    @RequestMapping(value=["/sqrt/{numberOne}"])
    fun sqrt(@PathVariable (value = "numberOne") numberOne: String?
    ): Double{
        if(!isNumeric(numberOne))
        throw UnsupportedMathOperationException("Please, insert a numeric value!")
        return  convertToDouble(numberOne) * convertToDouble(numberOne)
    }
    @RequestMapping(value=["/med/{numberOne}/{numberTwo}"])
    fun med(@PathVariable (value = "numberOne") numberOne: String?,
             @PathVariable (value = "numberTwo") numberTwo: String?
    ): Double{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
        throw UnsupportedMathOperationException("Please, insert a numeric value!")
        return  (convertToDouble(numberOne) + convertToDouble(numberTwo))/2
    }

    private fun convertToDouble(strNumber: String?): Double {
        if(strNumber.isNullOrBlank()) return 0.0
        val number = strNumber.replace(",".toRegex(),".")
        return if (isNumeric(number)) number.toDouble() else 0.0
    }

    private fun isNumeric(strNumber: String?): Boolean {
        if(strNumber.isNullOrBlank()) return false
        val number = strNumber.replace(",".toRegex(), ".")
        return number.matches(regex = """[-+]?[0-9]*\.?[0-9]+""".toRegex())
    }
}