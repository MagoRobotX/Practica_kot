package com.magorobot.practica1.sintaxis

fun main(){
    // getMonth(5)
    //getTrimester(6)
    getSemester(4)
   // result("igo")

}
//poco recomendable tener mucho cuidado con la bariable Any
fun result(value: Any) {
    when(value){
        is Int -> value + value
        is String -> println(value)
        is Boolean ->if (value) println("Hola")
    }
}

fun getSemester(month: Int) = when(month) {
       in 1..6 -> println("Primer Semestre")
        in 7..9->  "Segundo Semestre"
        in 10..12 ->  "Cuarto"
        !in 1..12 ->  "No Existe"
         else-> ("No existe")
        /**
        in 1..6 -> return "Primer Semestre"
        in 7..9-> return "Segundo Semestre"
        in 10..12 -> return "Cuarto"
        !in 1..12 -> return "No Existe"
         else-> return("No existe")
        **/

   }


/**
//Rangos
fun getSemester(month: Int) {
    when(month) {
        in 1..6 -> println("Primer Semestre")
        in 7..9-> println("Segundo Semestre")
        in 10..12 -> println("Cuarto")
        !in 1..12 -> println("No Existe")
       // else-> println("No existe")
    }

} **/

fun getTrimester(month: Int) {
    when(month) {
        1, 2, 3 -> println("Primer trimestre")
        4, 5, 6 -> println("Segundo Trimestre")
        7, 8, 9 -> println("Cuarto")
        else-> println("No existe")
    }

}

fun getMonth(month:Int){
/**
    if (month ==1){
        println("Enero")
    }else if(month == 2){
        println("Febrero")
    }else if(month == 3){
        println("Marzo")
    }else if(month == 4){
        println("Abril")
    }
    else{
        println("Dato no correcto")
    }
    **/
    when(month){
        1-> println("Enero")
        2-> println("Febrero")
        3-> println("Marzo")
        4->{
            println("Abril")
            println("Mayo")
        }
        else -> println("No existe este mes")
    }

}

