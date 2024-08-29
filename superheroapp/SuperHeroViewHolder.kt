package com.magorobot.androidmaster.superheroapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.magorobot.androidmaster.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

class SuperHeroViewHolder (view:View): RecyclerView.ViewHolder(view){
    private val binding =ItemSuperheroBinding.bind(view)

    fun bind (superheroItemsResponse: SuperheroItemsResponse, onItemSelected: (String) -> Unit){
        binding.tvSuperheroName.text = superheroItemsResponse.name
        binding.ivSuperImag

        Picasso.get().load(superheroItemsResponse.ImagenHeroe.url).into(binding.ivSuperImag)
        binding.root.setOnClickListener { onItemSelected(superheroItemsResponse.superheroId) }
    }
}