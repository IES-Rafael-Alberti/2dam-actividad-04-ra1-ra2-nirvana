package com.fmunmar310.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.textView)
        var result = ""
        var operacion=""
        var calculo = Calculo()
        var num1 = 0.0
        var num2 = 0.0
        val button1 = findViewById<Button>(R.id.num1)
        button1.setOnClickListener(View.OnClickListener {
            result+="1"
            textView.text = result })
        val button2 = findViewById<Button>(R.id.num2)
        button2.setOnClickListener(View.OnClickListener {
            result+="2"
            textView.text = result})
        val button3 = findViewById<Button>(R.id.num3)
        button3.setOnClickListener(View.OnClickListener {
            result+="3"
            textView.text = result})
        val button4 = findViewById<Button>(R.id.num4)
        button4.setOnClickListener(View.OnClickListener {
            result+="4"
            textView.text = result})
        val button5 = findViewById<Button>(R.id.num5)
        button5.setOnClickListener(View.OnClickListener {
            result+="5"
            textView.text = result})
        val button6 = findViewById<Button>(R.id.num6)
        button6.setOnClickListener(View.OnClickListener {
            result+="6"
            textView.text = result})
        val button7 = findViewById<Button>(R.id.num7)
        button7.setOnClickListener(View.OnClickListener {
            result+="7"
            textView.text = result})
        val button8 = findViewById<Button>(R.id.num8)
        button8.setOnClickListener(View.OnClickListener {
            result+="8"
            textView.text = result})
        val button9 = findViewById<Button>(R.id.num9)
        button9.setOnClickListener(View.OnClickListener {
            result+="9"
            textView.text = result})
        val button0 = findViewById<Button>(R.id.num0)
        button0.setOnClickListener(View.OnClickListener {
            result+="0"
            textView.text = result})
        val buttonPlus = findViewById<Button>(R.id.plus)
        buttonPlus.setOnClickListener(View.OnClickListener {
            num1=result.toDouble()
            operacion="+"
            calculo.num1=num1
            calculo.num2=num2
            calculo.op=operacion
            result = calculo.operacion(calculo).toString()
            textView.text = result
            result =""
           })
        val buttonMinus = findViewById<Button>(R.id.minus)
        val buttonMult = findViewById<Button>(R.id.multiply)
        val buttonDiv = findViewById<Button>(R.id.divide)
        val buttonCe = findViewById<Button>(R.id.ce)
        val buttonDot = findViewById<Button>(R.id.dot)
        val buttonEqual = findViewById<Button>(R.id.equal)
        buttonEqual.setOnClickListener(View.OnClickListener {
            num2=result.toDouble()
            operacion="+"
            calculo.num1=num1
            calculo.num2=num2
            calculo.op=operacion
            result = calculo.operacion(calculo).toString()
            textView.text = result
            result =""
        })

    }
}