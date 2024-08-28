package com.magorobot.practica1.sintaxis

fun main(){
    mutableList()
}

fun mutableList() {
    val weeDays:MutableList<String> = mutableListOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes","Sabado", "Domingo")
    println(weeDays)
    //weeDays.add("hola")
    weeDays.add(0, "gjaja")
    println(weeDays)
    if ((weeDays.isEmpty())){
        //no voy a pintar nada por k no hay
    }else{
        weeDays.forEach{ println(it) }
    }
    if (weeDays.isNotEmpty()){
        weeDays.forEach { println(it) }
    }
}

fun inmutablesList(){

    val readOnly:List<String> = listOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes","Sabado", "Domingo")
    println(readOnly.size)
    //las los soniguales
    //println(readOnly.toString())
    println(readOnly)
    //println(readOnly[0])
    println(readOnly.last())
   // println(readOnly.first())
    //filtrar
    //imprimira las k tenga la letra a Minuscula de la lista
    val example = readOnly.filter { it.contains("a") }
    println(example)
    //Imprimira lista  weeDay son dias de la semana remplazando  it para tener idea de lo k va a imprimir k son los dias de la semana
    readOnly.forEach {weeDay -> println(weeDay)  }
}