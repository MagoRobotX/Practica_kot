package com.magorobot.androidmaster.todoApp

import android.content.res.ColorStateList
import android.graphics.Paint
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.magorobot.androidmaster.R

class TasksViewHolder (view: View): RecyclerView.ViewHolder(view) {
    private val tvTasks: TextView =view.findViewById(R.id.tvTasks)
    private val cvTasks: CheckBox = view.findViewById(R.id.cbTasks)

    fun render(Tasks:Tasks){
        if(Tasks.isSelected){
            tvTasks.paintFlags=tvTasks.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }else{
            tvTasks.paintFlags=tvTasks.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
        cvTasks.isChecked = Tasks.isSelected
        tvTasks.text = Tasks.name
        val color =when (Tasks.category){
            TaskCategory.Bussines -> R.color.bussines_category
            TaskCategory.Other -> R.color.other_category
            TaskCategory.Personal -> R.color.peronal_category
       /** when(Tasks.category){
            TaskCategory.Bussines -> ColorStateList.valueOf((
                    ContextCompat.getColor(cvTasks.context, R.color.bussines_category)
                    )) **/
        }
        cvTasks.buttonTintList =ColorStateList.valueOf(
        ContextCompat.getColor(cvTasks.context,color))
    }
}