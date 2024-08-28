package com.magorobot.androidmaster.todoApp

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.magorobot.androidmaster.R

class CategoriesViewHolder (View : View) :RecyclerView.ViewHolder(View){
    private val tvCategoryName: TextView = View.findViewById(R.id.tvCategoryName)
    private val divider:View =View.findViewById(R.id.divider)
    private val viewContainer:CardView= View.findViewById(R.id.viewContainer)

    fun render(taskCategory: TaskCategory, onItemSelected: (Int) -> Unit){

        val color = if (taskCategory.isSelected){
            R.color.background_card
        }else{
            R.color.background_disabled
        }
        viewContainer.setCardBackgroundColor(ContextCompat.getColor(viewContainer.context, color))
        itemView.setOnClickListener{onItemSelected(layoutPosition)}
        when(taskCategory){
            TaskCategory.Bussines -> {
                tvCategoryName.text ="Negocios"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.bussines_category)
                )
            }
            TaskCategory.Other -> {
                tvCategoryName.text ="Otros"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.other_category)
                )
            }
            TaskCategory.Personal -> {
                tvCategoryName.text ="Personal"
                divider.setBackgroundColor(ContextCompat.getColor(divider.context, R.color.peronal_category)
                )
            }
        }

    }

}