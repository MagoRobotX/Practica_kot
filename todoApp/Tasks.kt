package com.magorobot.androidmaster.todoApp

data class Tasks(val name:String, val category: TaskCategory,var isSelected:Boolean=false) {
}