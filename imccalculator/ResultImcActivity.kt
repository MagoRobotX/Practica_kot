package com.magorobot.androidmaster.imccalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.magorobot.androidmaster.R
import com.magorobot.androidmaster.imccalculator.ImcActivity.Companion.IMC_KEY

class ResultImcActivity : AppCompatActivity() {
    private lateinit var tvResult: TextView
    private lateinit var tvIMC:TextView
    private lateinit var tvDescription:TextView
    private lateinit var btnRecalculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result_imc)
        // Obtiene el valor de IMC pasado desde la actividad anterior, si no existe, asigna -1.0
        val result:Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0

        initComponents() // Inicializa los componentes de la interfaz
        initUI(result) // Configura la interfaz de usuario basada en el resultado del IMC
        iniListeners() // Inicializa los listeners para los eventos de la interfaz
        }
    // Método para configurar los listeners de los eventos de la interfaz
    private fun iniListeners() {
        // Establece un listener para el botón de recalcular
        btnRecalculate.setOnClickListener {
            onBackPressed() // Regresa a la actividad anterior cuando se presiona el botón de recalcular
        }
    }
    // Método para configurar la interfaz de usuario en función del resultado del IMC
    private fun initUI(result: Double) {
        tvIMC.text =result.toString() // Asigna el valor del IMC al TextView tvIMC
        when (result) {
            in 0.00..18.50 ->{ //Bajo peso
                tvResult.text = getString(R.string.title_bajo_peso) // Asigna el texto de "Bajo peso" al TextView tvResult
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.Bajo_Peso))  // Cambia el color del texto de tvResult
               // tvIMC
                tvDescription.text = getString(R.string.description_bajo_peso) // Asigna la descripción de "Bajo peso" a tvDescription
            }
            in 18.51..24.99 ->{// Peso Normal
                tvResult.text =getString(R.string.title_peso_normal)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.Peso_Normal))
               // tvIMC
                tvDescription.text =getString(R.string.description_peso_normal)
            }
            in 25.00..29.99 ->{ //Sobrepeso
                tvResult.text = getString(R.string.title_sobrepreso)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.Sobrepeso))
               // tvIMC
                tvDescription.text = getString(R.string.description_sobrepeso)
            }
            in 30.00.. 99.00 ->{//Obesidad
                tvResult.text = getString(R.string.title_obesidad)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.Obesidad))
              //  tvIMC
                tvDescription.text = getString(R.string.description_obesidad)
            }else ->{ //Error
                tvResult.text = getString(R.string.error) // Asigna el texto de "Error" al TextView tvResult
                tvIMC.text = getString(R.string.error) // Asigna el texto de "Error" al TextView tvIMC
                tvDescription.text = getString(R.string.error) // Asigna el texto de "Error" a tvDescription

            }
        }
    }

   // Método para inicializar los componentes de la interfaz vinculándolos con los elementos del layout
    private fun initComponents() {
        tvResult = findViewById(R.id.tvResult) // Vincula tvResult con el TextView correspondiente en el layout
        tvIMC = findViewById(R.id.tvIMC) // Vincula tvIMC con el TextView correspondiente en el layout
        tvDescription = findViewById(R.id.tvDescription) // Vincula tvDescription con el TextView correspondiente en el layout
        btnRecalculate = findViewById(R.id.btnRecalculate) // Vincula btnRecalculate con el Button correspondiente en el layout
    }

}
