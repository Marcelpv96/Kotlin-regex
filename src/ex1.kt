/**
 * Created by Marcelpv96 on 22/4/18.
 */

package regex;

fun ex1(input : String){
    var expresion = Regex (
                            pattern = "Nom:\\s*[A-Z][a-z]*\\s*[A-Z][a-z]*\\s*[A-Z][a-z]*\\s*" +
                            "email:\\s*[a-zA-Z]+@+[a-zA-Z]+\\.[a-zA-Z]+\\s*" +
                            "number:\\s*(\\p{Digit}{9}|\\+\\p{Digit}{11})"
                            )

    try {
        var result = expresion.matchEntire(input)!!.value
        println(result.equals(input))
    }catch (e: KotlinNullPointerException){
        println("false")
    }

}

fun main(args : Array<String>){
    ex1("Nom: Marcel Porta Valles     email: marcel@porta.com           number: +36660853339")
}
