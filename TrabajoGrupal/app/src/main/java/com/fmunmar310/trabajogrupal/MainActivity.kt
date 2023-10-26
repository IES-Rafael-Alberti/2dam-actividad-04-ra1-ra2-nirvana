package com.fmunmar310.trabajogrupal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //boton para iniciar Calculadora Curro
        val buttonCurro = findViewById<Button>(R.id.btnCalcCurro)
        buttonCurro.setOnClickListener{
            val intent = Intent(this, CurroActivity::class.java)
            startActivity(intent)
        }
        //boton para iniciar Calculadora Carlos
        val buttonCarlos = findViewById<Button>(R.id.btnCalcCarlos)
        buttonCarlos.setOnClickListener{
            val intent = Intent(this, CarlosActivity::class.java)
            startActivity(intent)
        }
        //boton para iniciar Calculo Imc
        val buttonImc = findViewById<Button>(R.id.btnCalcIMC)
        buttonImc.setOnClickListener{
            val intent = Intent(this, Imc::class.java)
            startActivity(intent)
        }
        //boton para salir
        val buttonExit = findViewById<Button>(R.id.btnExit)
        buttonExit.setOnClickListener{
            finish()
        }
    }
}