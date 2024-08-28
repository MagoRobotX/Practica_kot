package com.magorobot.practica1.sintaxis
/** Practica 1 **/

const val age: Int = 23

fun main(){
    /**
    //llamar a funciones
    ejemplosNumericos()
    variasblesBooleanas()
    alfanumericas()
    **/

    showMyNombre(nombre = "luis")
    showMyEdad(currentEdad = 13)
    add(25, 76)
    val mySubtract= subtract(100, 40)
    println(mySubtract)
}
fun showMyNombre(nombre: String){
    println("Me llamo $nombre")
}
//Aseguramos un balor a mostrar en funciones
fun showMyEdad(currentEdad: Int= 40){
    println("Tengo $currentEdad Años")
}
fun add(firstNumber: Int, secondNumber: Int){
    println(firstNumber + secondNumber)

}
//devolver la resta
fun subtract(firstNumber: Int, secondNumber: Int): Int {
   return firstNumber - secondNumber
}
//para opereciones pequenas queno se senecite muchos procesos
fun subtractCool(firstNumber: Int,secondNumber: Int) = firstNumber + secondNumber

fun alfanumericas(){
    /**  Variables Alfanumericas **/

    //Char caracteres
    val charEjemplo1:Char = 'e'
    val charEjemplo2:Char ='2'
    val charEjemplo3:Char ='@'

    //String
    val stringEjemplo1:String ="Practiga MagoRobot"
    val stringEjemplo2:String ="4"
    val stringEjemplo3:String ="34"
    //concatena
    println(stringEjemplo2+stringEjemplo3)
    //Suma los numero del string ejem1 y 2
    println(stringEjemplo2.toInt()+stringEjemplo3.toInt())

    var stringConcatenada: String = " Hola Mago"
    //poner signo de $ para concatenar en ele texto
    stringConcatenada = "HOla Me llamo Mago $stringEjemplo3 y tengo $age años"
    println(stringConcatenada)
    val ejemplo01234:String = age.toString()
    println(ejemplo01234)

}

fun variasblesBooleanas(){

    /** Variables Boleanas **/

    //Boolean
    val boleanaEjemplo:Boolean = true
    val boleanaEjemplo2:Boolean = false

    println("ejemplo Booleano")
    println(boleanaEjemplo2)


}

fun ejemplosNumericos(){
    println("Hola munDo")

    // Variables Int

    var age2: Int=32
    /**
    println(age2)
    age2=23
    println(age2)
     **/

    // variables long
    val ejem:Long = 45
    //Variables float
    val floatEjemp:Float = 3.1416f
    //Double
    var doubleEjem:Double =3.141635676

    println("Sumas")
    println(age + age2)
    println("Resta")
    println(age -age2)
    println("Multiplicar")
    println(age *age2)
    println("Dividir")
    println(age /age2)
    println("Modulo")
    println(age %age2)

    //Sumar int float
    println(age +floatEjemp)

    // Convertir un tipo Float a Entero Int
    // var ejemploSuma: Float =age + floatEjemp
    var ejemploSuma: Int = age + floatEjemp.toInt()
}