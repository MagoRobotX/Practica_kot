package com.magorobot.androidmaster

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.magorobot.androidmaster.firsapp.FirstAppActivity
import com.magorobot.androidmaster.imccalculator.ImcActivity
import com.magorobot.androidmaster.superheroapp.SuperHeroListActivity
import com.magorobot.androidmaster.todoApp.TodoAppActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnSaludarApp = findViewById<Button>(R.id.btnSaludarApp)
        val btnImcApp =   findViewById<Button>(R.id.btnImcApp)
        val btnTodoApp =findViewById<Button>(R.id.btnTodoApp)
        val btnSUperHero = findViewById<Button>(R.id.btnSuperHero)

        btnSaludarApp.setOnClickListener { navigateToSaludarApp()}
        btnImcApp.setOnClickListener {navigateToImcApp()}
        btnTodoApp.setOnClickListener { navigateToTodoApp() }
        btnSUperHero.setOnClickListener { navigateToSuperHeroApp() }

    }

    private fun navigateToTodoApp() {
        val intent = Intent(this, TodoAppActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSaludarApp(){
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }

     private fun navigateToImcApp() {
        val intent = Intent(this, ImcActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToSuperHeroApp(){
        val intent = Intent(this, SuperHeroListActivity::class.java)
        startActivity(intent
        )
    }



}