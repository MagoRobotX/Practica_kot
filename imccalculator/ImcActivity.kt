package com.magorobot.androidmaster.imccalculator

import android.content.Intent
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.KeyEventDispatcher.Component
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import com.magorobot.androidmaster.R
import com.magorobot.practica1.sintaxis.result

class ImcActivity : AppCompatActivity() {
    // Variables para controlar la selección de género
    private var isManSelected: Boolean = true
    private var isWomenSelected: Boolean = false

    // Variables para almacenar el peso , edad y la altura actuales
    private var currentWeight: Int = 40
    private var age: Int = 18
    private var currentHeight: Int=120

    // Declaración de vistas (UI components)
    private lateinit var viewMan: CardView
    private lateinit var viewWomen: CardView
    private lateinit var rsHeight: RangeSlider
    private lateinit var atHeight: TextView
    private lateinit var btnSubtraction: FloatingActionButton
    private lateinit var btnAddiction: FloatingActionButton
    private lateinit var tvWeight: TextView
    private lateinit var btnAddAge: FloatingActionButton
    private lateinit var btnSubAge: FloatingActionButton
    private lateinit var tvAge: TextView
    private lateinit var btnCualculate:Button

    companion object{
        const val IMC_KEY="IMC_RESULT"
    }

    // Método que se llama al crear la actividad
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()  // Método para configurar el diseño de la interfaz
        setContentView(R.layout.activity_imc)  // Asocia la actividad con su layout XML
        initComponents()  // Inicializa los componentes de la interfaz
        initListeners()   // Configura los listeners para manejar eventos
        initUi()          // Configura la UI inicial (por ejemplo, colores, valores iniciales)
    }

    // Método para inicializar las vistas (UI components)
    private fun initComponents() {
        viewMan = findViewById(R.id.viewMan)
        viewWomen = findViewById(R.id.viewWomen)
        atHeight = findViewById(R.id.atHeight)
        rsHeight = findViewById(R.id.rsHeight)
        btnSubtraction = findViewById(R.id.btnSubtraction)
        btnAddiction = findViewById(R.id.btnAddition)
        tvWeight = findViewById(R.id.tvWeight)
        btnSubAge=findViewById(R.id.btnSubAge)
        btnAddAge=findViewById(R.id.btnAddAge)
        tvAge=findViewById(R.id.tvAge)
        btnCualculate=findViewById(R.id.btnCalculate)
        // Inicialización de más vistas, si es necesario
    }

    // Método para configurar los listeners que manejan eventos de interacción del usuario
    private fun initListeners() {
        // Listener para el click en la vista de hombre
        viewMan.setOnClickListener {
            setGenderColor()  // Cambia los colores según el género seleccionado
            camnbioColor()    // Alterna la selección de género
        }
        // Listener para el click en la vista de mujer
        viewWomen.setOnClickListener {
            setGenderColor()  // Cambia los colores según el género seleccionado
            camnbioColor()    // Alterna la selección de género
        }
        // Listener para el cambio de valor en el slider de altura
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")  // Formato para mostrar la altura con 2 decimales
            currentHeight= df.format(value).toInt()
            atHeight.text = "$currentHeight cm"  // Actualiza el texto de la altura
        }
        // Listener para el botón de restar peso
        btnSubtraction.setOnClickListener {
            currentWeight -= 1  // Disminuye el peso actual
            setWeight()         // Actualiza la vista con el nuevo peso
        }
        // Listener para el botón de sumar peso
        btnAddiction.setOnClickListener {
            currentWeight += 1  // Aumenta el peso actual
            setWeight()         // Actualiza la vista con el nuevo peso
        }
        // Listener para el botón de aumentar edad
        btnAddAge.setOnClickListener {
            age += 1    // Aumenta la edad
            setAge()    // Actualiza la vista con la nueva edad
        }
        // Listener para el botón de disminuir edad
        btnSubAge.setOnClickListener {
            age -= 1    // Disminuye la edad
            setAge()    // Actualiza la vista con la nueva edad
        }
        //Button para calular el IMC
        btnCualculate.setOnClickListener {
            val result=calcuIMC()
            navigateTResult(result)
        }
    }

   // Método para navegar a la actividad de resultados del IMC
    private fun navigateTResult(result: Double) {
    val intent = Intent(this, ResultImcActivity::class.java) // Crea un Intent para iniciar ResultImcActivity
    intent.putExtra(IMC_KEY, result) // Añade el valor del IMC al Intent utilizando IMC_KEY como clave
    startActivity(intent) // Inicia la actividad ResultImcActivity con el Intent creado
}

    //Metodo para calcular el IMC
    private fun calcuIMC():Double {
        val df=DecimalFormat("#.##") // Crea un formato decimal para limitar el número de decimales a 2
        val imc=currentWeight/(currentHeight.toDouble()/100 *  currentHeight.toDouble()/100)  // Calcula el IMC basado en el peso y altura actual
        return  df.format(imc).toDouble() // Formatea el IMC a 2 decimales y lo convierte a Double para devolverlo
        // result = df.format(imc).toDouble() // Línea comentada que formatea y asigna el IMC a una variable llamada result
    // Log.i("MagoRobot", "El IMC es $result") // Línea comentada que registra el IMC en el log para depuración
    }

    // Método para actualizar la edad en la interfaz
    private fun setAge() {
        tvAge.text = age.toString()  // Convierte la edad a texto y la muestra
    }

    // Método para actualizar el peso en la interfaz
    private fun setWeight() {
        tvWeight.text = currentWeight.toString()  // Convierte el peso a texto y lo muestra
    }

    // Método que alterna la selección de género
    private fun camnbioColor() {
        isManSelected = !isManSelected         // Cambia el estado de selección del hombre
        isWomenSelected = !isWomenSelected     // Cambia el estado de selección de la mujer
    }

    // Método que ajusta los colores según el género seleccionado
    private fun setGenderColor() {
        viewMan.setCardBackgroundColor(getBackgroundColor(isManSelected))  // Establece el color de fondo del CardView de hombre
        viewWomen.setCardBackgroundColor(getBackgroundColor(isWomenSelected))  // Establece el color de fondo del CardView de mujer
    }

    // Método que retorna el color de fondo adecuado según si el componente está seleccionado
    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {
        val colorReference = if (isSelectedComponent) {
            R.color.btnOn  // Color cuando el componente está seleccionado
        } else {
            R.color.btnOff  // Color cuando el componente no está seleccionado
        }
        return ContextCompat.getColor(this, colorReference)  // Retorna el color según la referencia
    }

    // Método que inicializa la interfaz de usuario con los valores y estados iniciales
    private fun initUi() {
        setGenderColor()  // Ajusta los colores según el género seleccionado inicialmente
        setWeight()       // Muestra el peso inicial
        setAge()          // Muestra la edad inicial
    }
}

