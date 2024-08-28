
fun main(){
//Indice de 0 a 6 y tamaño 7
    val weeDays= arrayOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes","Sabado", "Domingo")
    //size para saber el tamaño de la ray
    println(weeDays.size)
    if(weeDays.size >=8){
        println(weeDays[7])
    }else{
        println("No hay mas Valores en el Array")
    }
    //Modificar valor
    weeDays[0] = "Hola Lunes"
    println(weeDays)
    //bucles para arrays
    for (position in weeDays.indices){
      //  println("He pasdo por aqui $position")
        println(weeDays[position])
    }
    // Meda la posicion y el valor
    for ((position, value) in weeDays.withIndex()){
        println("La posicion $position, contiene $value")
    }
    //SOlo para saber el valor dia
    for (weeDays in weeDays){
        println("Ahora es $weeDays")
    }

}