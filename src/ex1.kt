/**
 * Created by Marcelpv96 on 22/4/18.
 */

package regex;

fun ex1(input : String){
    var expresion = Regex ("[A-Z]*")
    var result = expresion.matchEntire(input)!!.value
    println(result.equals(input))
}

fun main(args : Array<String>){
    ex1("HOLA")
}
