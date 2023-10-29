package com.fmunmar310.trabajogrupal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider

class Imc : AppCompatActivity() {
    private lateinit var persona: Persona
    private lateinit var hombreButton: CardView
    private lateinit var mujerButton: CardView
    private lateinit var textAltura: TextView
    private lateinit var barritaAltura: RangeSlider
    private lateinit var textPeso:TextView
    private lateinit var masPeso: FloatingActionButton
    private lateinit var menosPeso: FloatingActionButton
    private lateinit var textEdad: TextView
    private lateinit var masEdad:FloatingActionButton
    private lateinit var menosEdad:FloatingActionButton
    private lateinit var calcular: Button
    private lateinit var salir:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)
        initVariables()
        initListeners()
    }
    private fun initVariables(){
        persona = Persona()
        hombreButton = findViewById(R.id.hombre)
        mujerButton = findViewById(R.id.mujer)
        textAltura = findViewById(R.id.muestracm)
        barritaAltura = findViewById(R.id.marcaAltura)
        textPeso = findViewById(R.id.muestraPeso)
        menosPeso = findViewById(R.id.menos_peso)
        masPeso = findViewById(R.id.mas_peso)
        textEdad = findViewById(R.id.muestraEdad)
        menosEdad = findViewById(R.id.menos_edad)
        masEdad = findViewById(R.id.mas_edad)
        calcular = findViewById(R.id.calculoImc)
        salir = findViewById(R.id.salir)
    }
    private fun initListeners(){
        hombreButton.setOnClickListener { hombreListener() }
        mujerButton.setOnClickListener { mujerListener() }
        barritaAltura.addOnChangeListener { _, value, _ ->  barritaListener(value)}
        menosPeso.setOnClickListener { menosPesoListener() }
        masPeso.setOnClickListener { masPesoListener() }
        menosEdad.setOnClickListener { menosEdadListener() }
        masEdad.setOnClickListener { masEdadListener() }
        calcular.setOnClickListener { calcularListener() }
        salir.setOnClickListener { salirListener() }
    }
    private fun hombreListener(){
        if (persona.sexo == "mujer"){
            mujerButton.setCardBackgroundColor(getColor(R.color.sin_pulsar))
        }
        persona.sexo = "hombre"
        hombreButton.setCardBackgroundColor(getColor(R.color.pulsado))
    }
    private fun mujerListener(){
        if (persona.sexo == "hombre"){
            hombreButton.setCardBackgroundColor(getColor(R.color.sin_pulsar))
        }
        persona.sexo = "mujer"
        mujerButton.setCardBackgroundColor(getColor(R.color.pulsado))
    }
    private fun barritaListener(value:Float){
        persona.altura = value
        textAltura.text = persona.alturaEnCm()
    }
    private fun menosPesoListener(){
        persona.peso = textViewtoInt(textPeso)
        persona.decrementarPeso()
        textPeso.text = persona.peso.toString()
    }
    private fun masPesoListener(){
        persona.peso = textViewtoInt(textPeso)
        persona.incrementarPeso()
        textPeso.text = persona.peso.toString()
    }
    private fun menosEdadListener(){
        persona.edad = textViewtoInt(textEdad)
        persona.decrementarEdad()
        textEdad.text = persona.edad.toString()
    }
    private fun masEdadListener(){
        persona.edad = textViewtoInt(textEdad)
        persona.incrementarEdad()
        textEdad.text = persona.edad.toString()
    }
    private fun calcularListener(){
        if (persona.todosLosDatos()){
            mensajeError("Necesitas cumplimentar todos los datos")
        }else{
            persona.calculaImc()
            val intent = Intent(this, ResultadoActivity::class.java)
            intent.putExtra("persona", persona)
            startActivity(intent)
        }
    }
    private fun salirListener(){
        finishAndRemoveTask()
    }
    private fun textViewtoInt(textView: TextView):Int{
        return textView.text.toString().toInt()
    }
    private fun mensajeError(msg:String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}