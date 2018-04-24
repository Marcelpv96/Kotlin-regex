/**
 * Created by Marcelpv96 on 22/4/18.
 */

package regex

import java.io.File
import java.io.InputStream


fun ex1(input : String): Boolean {
    var expresion = Regex (pattern = "Nom:\\s*[A-Z][a-z]*\\s*[A-Z][a-z]*\\s*[A-Z][a-z]*\\s*" +
                            "email:\\s*[a-zA-Z]+@+[a-zA-Z]+\\.[a-zA-Z]+\\s*" +
                            "Telf:\\s*(\\p{Digit}{9}|\\+\\p{Digit}{11})"
                            )

    try {
        var result = expresion.matchEntire(input)!!.value
        return result.equals(input)
    }catch (e: KotlinNullPointerException){
        return false
    }
}

fun ex2(input : String): Boolean {
    var main_expresion = "\\s*Calc\\s*(\\p{Digit}+)\\s*(\\+|\\*|\\/|\\-)\\s*(\\p{Digit}+)\\s*"
    var sub_expresion = Regex(main_expresion)
    var expresion = Regex(pattern = "[" + main_expresion + ";]+")
    try {
        var given_expresions = expresion.matchEntire(input)!!.value.split(';').dropLast(1)
        for (expr in given_expresions) {
            if (!aux_ex2(sub_expresion.matchEntire(expr)!!.groupValues)) return false
        }
        return true
    } catch (e: KotlinNullPointerException) {
        return false
    }
}


fun aux_ex2(values: List<String>): Boolean {
    when{
        values[2].equals("+") -> println("El resultat de sumar "+values[1]+" i "+values[3]+" es : " + (Integer.parseInt(values[1])+Integer.parseInt(values[3])))
        values[2].equals("-") -> println("El resultat de restar "+values[1]+" i "+values[3]+" es : " + (Integer.parseInt(values[1])-Integer.parseInt(values[3])))
        values[2].equals("*") -> println("El resultat de multiplicar "+values[1]+" i "+values[3]+" es : " + (Integer.parseInt(values[1])*Integer.parseInt(values[3])))
        values[2].equals("/") -> println("El resultat de dividir "+values[1]+" i "+values[3]+" es : " + (Integer.parseInt(values[1])/Integer.parseInt(values[3])))
        else -> return false
    }
    return true
}


fun main(args : Array<String>){
    val inputStream: InputStream = File("ex2.txt").inputStream()
    val inputString = inputStream.bufferedReader().use { it.readText() }


    when {
        ex1(inputString) -> print("Es una expresió del tipus 1.")
        ex2(inputString) -> {}
        else -> print("Es una expresió incorrecta.")
    }
}
