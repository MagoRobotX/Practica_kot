package com.magorobot.androidmaster.superheroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import androidx.core.view.isVisible
import com.magorobot.androidmaster.databinding.ActivityDetailSuperheroBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.roundToInt

class DetailSuperheroActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ID = "extra_id"
    }

    private lateinit var binding: ActivityDetailSuperheroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailSuperheroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id: String = intent.getStringExtra(EXTRA_ID).orEmpty()
        getSuperheroInformation(id)
    }

    private fun getSuperheroInformation(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val superheroDetail =
                getRetrofit().create(ApiService::class.java).getSuperheroDetail(id)

            if(superheroDetail.body() != null){
                runOnUiThread { createUI(superheroDetail.body()!!) }
            }
        }

    }

    private fun createUI(superhero: SuperHeroDatailResponse) {
        Picasso.get().load(superhero.image.url).into(binding.ivSuperheroe)
        binding.tvSuperName.text= superhero.name
        prepareStats(superhero.powerstats)
        binding.tvSuperBiografy.text=superhero.biography.fullname
        binding.tvSuperPublisher.text =superhero.biography.publisher

    }

    private fun prepareStats(powerstats: PowerStatusResponse) {

       /** val params=binding.viCombat.layoutParams
        params.height = powerstats.combat.toInt()
        binding.viCombat.layoutParams = params **/
        //updateHeight(binding.viewIntelligence, powerstats.intelligence.toInt())
        updateHeight(binding.viewIntelligence, powerstats.intelligence)
        updateHeight(binding.viewStrength, powerstats.strength)
        updateHeight(binding.viewSpeed, powerstats.speed)
        updateHeight(binding.viewDurability, powerstats.durability)
        updateHeight(binding.viewPower, powerstats.power)
        updateHeight(binding.viewCombat, powerstats.combat)

    }
     private fun updateHeight(view: View, stat:String){  //string era int
         val params=view. layoutParams
         //params.height =stat
         params.height =pxToDp(stat.toFloat())
         view.layoutParams=params
     }
    private fun pxToDp(px:Float):Int{
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, resources.displayMetrics).roundToInt()
    }


    private fun getRetrofit(): Retrofit {

        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}