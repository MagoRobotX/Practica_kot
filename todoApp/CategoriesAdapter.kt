package com.magorobot.androidmaster.todoApp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.magorobot.androidmaster.R

class CategoriesAdapter(private  val categories : List<TaskCategory>, private val onItemSelected:(Int) -> Unit):
    RecyclerView.Adapter<CategoriesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val View = LayoutInflater.from(parent.context).inflate(R.layout.item_task_category, parent, false)
            return CategoriesViewHolder(View)
    }

    override fun getItemCount() = categories.size

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.render(categories[position],onItemSelected)

    }

}