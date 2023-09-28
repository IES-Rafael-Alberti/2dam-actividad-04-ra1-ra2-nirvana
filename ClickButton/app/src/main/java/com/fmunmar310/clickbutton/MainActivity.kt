package com.fmunmar310.clickbutton

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var clicks = 0
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener(View.OnClickListener {
            clicks++
            when(clicks){
                1->{button.text = "Has hecho click una vez"
                button.textSize = 24f }
                2->{button.text = "Has hecho click dos veces"
                    button.textSize = 24f}
                3,4,5->{button.text = "Has hecho click $clicks veces"
                    button.textSize = 24f}
                6,7,8,9,10->{button.text = "Has hecho click varias  veces ($clicks)!"
                    button.textSize = 22f }
                11->{button.text = "Te has pasado de clicks!"
                    button.isEnabled = false
                    Toast.makeText(this, "El botón ha sido deshabilitado", Toast.LENGTH_SHORT).show()}
            }
        })
    }
}