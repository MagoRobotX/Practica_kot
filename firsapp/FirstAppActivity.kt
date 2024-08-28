package com.magorobot.androidmaster.firsapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.magorobot.androidmaster.R

class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)
        //Al arrancar la pantalla

        val btnStar = findViewById<AppCompatButton>(R.id.btnStar)
        val etName = findViewById<AppCompatEditText>(R.id.etName)

        btnStar.setOnClickListener {
            val name =etName.text.toString()

            if (name.isNotEmpty()){
              //Log.i("Mago", "Button Pulsado $name")
                val intent = Intent(this, ResulActivity::class.java)
                intent.putExtra("Extra_Name",name)
                startActivity(intent)
            }
        }
    }
}

