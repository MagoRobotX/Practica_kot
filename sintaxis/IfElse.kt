package com.magorobot.practica1.sintaxis

/**
Funcion If Else
**/

fun main(){

    ifAnimado()
    ifBoolean()
    ifInt()

}
//If normal
fun ifBasico(){

    val name = "Mago"

    if (name == "lui"){

        println("Colocastes vien el nombre Mago")
    }
    else{
        println("No es el nombre correcto")
    }
}
//else If
fun ifAnimado() {

    val animal = "Dog"

    if (animal == "Dog") {
        println("Es un Perrito ")
    } else if (animal == "Cat") {
        println("Ees un gato")
    } else if (animal == "Bird") {
        println("es un Pajaro")
    } else {
        println("No es un Animal")
    }
}
// IfBoolean
fun ifBoolean(){
    var soyFeliz: Boolean = false
    // SIn nada == true
    //con ! al principio sera == false
    if (!soyFeliz){
      println("Estoy triste")
    }
}

// comparacion multiple
fun ifInt(){
    var age = 24
    var permiso = true
    if (age >= 18 && permiso ){

        println("Ya puede tomar Cerveza")

    }
    else{

        println("Aun es menor de edad")
    }
}
// comparacion Or
fun ifMultipleOr(){
    var pet = "Cat"
    //var imHappy= true
    //if (pet=="Dog" || (pet=="Cat" && imHappy))
    if (pet=="Dog" || pet=="Cat"){
        println("Es un animal")
    }

}