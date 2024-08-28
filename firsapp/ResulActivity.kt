package com.magorobot.androidmaster.firsapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.magorobot.androidmaster.R

class ResulActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resul)
        val tvResult =findViewById <TextView> (R.id.tvSerult)
        val name: String= intent.extras?.getString("Extra_Name").orEmpty()
        tvResult.text="hola $name"

    }
}