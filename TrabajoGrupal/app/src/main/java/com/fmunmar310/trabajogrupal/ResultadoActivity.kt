package com.fmunmar310.trabajogrupal

import android.annotation.SuppressLint
import android.icu.text.DecimalFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {
    private lateinit var personaRecibida: Persona

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)
        if (intent.hasExtra("persona")) { // Recibimos el objeto Persona de la activity anterior
            personaRecibida = intent.getSerializableExtra("persona") as Persona
        }
        val df = DecimalFormat("#.##")
        val result = findViewById<TextView>(R.id.resutlImc)
        result.text = df.format(personaRecibida.resultadoIMC).toString() // Mostramos el imc formateado
        val muestraVal = findViewById<TextView>(R.id.rangoImc)
        val imc = result.text.toString().toFloat()
        muestraVal.text= muestraValoracion(imc) // Se muestra la valoración del imc
        val foto = findViewById<ImageView>(R.id.fotoResult)
        foto.setImageResource(muestraFoto(imc)) // Se muestra la imagen en función de la valoración
        val buttonSalir = findViewById<Button>(R.id.salir)
        buttonSalir.setOnClickListener {
            finishAndRemoveTask()
    }
}

    /**
     * @param imc Recibe el imc calculado de la clase persona
     * @see Persona
     * @return Devuelve la valoración sobre el imc obtenido
     */
    private fun muestraValoracion(imc:Float):String{
    return when(imc){
        in 0f ..18.4f -> " Peso inferior al normal"
        in 18.5f .. 24.9f -> "Peso normal"
        in 25.0f..29.9f -> " Peso superior al normal"
        else -> " Usted tiene obesidad"
    }
    }
    /**
     * @param imc Recibe el imc calculado de la clase persona
     * @see Persona
     * @return Devuelve la imagen que se mostrará en función del imc obtenido
     */
private fun muestraFoto(imc:Float):Int{
    return when(imc){
        in 0f ..18.4f -> R.drawable.canijo
        in 18.5f .. 24.9f -> R.drawable.normal
        in 25.0f..29.9f -> R.drawable.gordo
        else -> R.drawable.obeso
    }
    }
}

