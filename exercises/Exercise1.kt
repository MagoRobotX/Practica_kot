package com.magorobot.practica1.exercises

/**
 * En el código inicial que se proporciona en el siguiente fragmento de codigo,
 * escribe un progrma que imprima el mesaje de resumen segun la cantidad de
 * notificaciones que recibiste. El mensaje debe incluir los siguiente:
 *
 * -La cantidad exacta de notificaciones cuando haya menos de 100
 * -99+ como cantidad de notificaciones cuando hay 100 o mas
 */

fun main() {
    val morningNotification = 51
    val everningNotification = 153
    printNotificationSummary(morningNotification)
    printNotificationSummary(everningNotification)
}
fun printNotificationSummary(numberOfMenssages: Int){
    if (numberOfMenssages >= 100){
        println("Your phone is blowing up! You have 99+ notifications ")
    }else{
        println("You have $numberOfMenssages notifications")
    }


}