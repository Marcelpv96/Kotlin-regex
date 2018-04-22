/**
 * Created by Marcelpv96 on 22/4/18.
 */

package regex;

import java.io.File
import java.io.InputStream

fun ex1(input : String): Boolean {
    var expresion = Regex (
                            pattern = "Nom:\\s*[A-Z][a-z]*\\s*[A-Z][a-z]*\\s*[A-Z][a-z]*\\s*" +
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


fun main(args : Array<String>){
    val inputStream: InputStream = File("ex1.txt").inputStream()
    val inputString = inputStream.bufferedReader().use { it.readText() }

    when {
        ex1(inputString) -> print("Es una expresió del tipus 1.")
        else -> print("Es una expresió incorrecta.")
    }
}
