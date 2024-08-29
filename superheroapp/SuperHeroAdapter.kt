package com.magorobot.androidmaster.superheroapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.magorobot.androidmaster.R

class SuperHeroAdapter(
    var superheroList: List<SuperheroItemsResponse> = emptyList(),
    private val onItemSelected: (String) -> Unit
) :
    RecyclerView.Adapter<SuperHeroViewHolder>() {
    @SuppressLint("NotifyDataSetChanged")
    fun updateList(superheroList: List<SuperheroItemsResponse>) {
        this.superheroList = superheroList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        return SuperHeroViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_superhero, parent, false)
        )
        /**
         * val layoutInflater = LayoutInflater.fom(paren.contex)
         * retun SuperheroViewHolder(layoutInflater.inflate.(R.id.item_superhero, parent, false))
         */

    }

    override fun onBindViewHolder(viewholder: SuperHeroViewHolder, position: Int) {
        /**   val item = superheroList position]
        viewholder.bind(item) **/
        viewholder.bind(superheroList[position], onItemSelected)
    }

    override fun getItemCount() = superheroList.size

}