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
        var result = " "
        var operador=""
        var num1 = 0.0
        var num2 = 0.0
        var calculo = Calculo(num1,num2,operador)
        val button1 = findViewById<Button>(R.id.num1)
        button1.setOnClickListener(View.OnClickListener {
            result+="1"
            textView.text = result})
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
        val buttonDot = findViewById<Button>(R.id.dot)
        buttonDot.setOnClickListener(View.OnClickListener {
            result+="."
            textView.text = result})
        val buttonPlus = findViewById<Button>(R.id.plus)
        buttonPlus.setOnClickListener(View.OnClickListener {
            operador = "+"
            if (num1 == 0.0) {
                num1 = result.toDouble()
                textView.text = result
                result=" "
            }else if(result == "0"){
                result = result.substring(1)
            }
            else{
                num2 = result.toDouble()
                textView.text = result
                calculo = Calculo(num1,num2,operador)
                result=calculo.operacion(operador).toString()
                textView.text = result
                num1 = result.toDouble()
                num2 = 0.0
                result=""
            }
           })
        val buttonMinus = findViewById<Button>(R.id.minus)
        buttonMinus.setOnClickListener(View.OnClickListener {
            operador = "-"
            if (num1 == 0.0) {
                num1=result.toDouble()
                textView.text = result
                result=" "
            }else if(result == "0"){
                result = result.substring(1)
            }
            else{
                num2 = result.toDouble()
                textView.text = result
                calculo = Calculo(num1,num2,operador)
                result=calculo.operacion(operador).toString()
                textView.text = result
                num1 = result.toDouble()
                num2 = 0.0
                result=" "
            }
        })
        val buttonMult = findViewById<Button>(R.id.multiply)
        buttonMult.setOnClickListener(View.OnClickListener {
            operador = "*"
            if (num1 == 0.0) {
                num1=result.toDouble()
                textView.text = result
                result=" "
            }else if(result == "0"){
                result = result.substring(1)
            }
            else{
                num2 = result.toDouble()
                textView.text = result
                calculo = Calculo(num1,num2,operador)
                result=calculo.operacion(operador).toString()
                textView.text = result
                num1 = result.toDouble()
                num2 = 0.0
                result=""
            }
        })
        val buttonDiv = findViewById<Button>(R.id.divide)
        buttonDiv.setOnClickListener(View.OnClickListener {
            operador = "/"
            if (num1 == 0.0) {
                num1=result.toDouble()
                textView.text = result
                result=" "
            }else if(result == "0"){
                result = result.substring(1)
            }
            else{
                num2 = result.toDouble()
                textView.text = result
                calculo = Calculo(num1,num2,operador)
                result=calculo.operacion(operador).toString()
                textView.text = result
                num1 = result.toDouble()
                num2 = 0.0
                result=""
            }
        })
        val buttonCe = findViewById<Button>(R.id.ce)
        buttonCe.setOnClickListener(View.OnClickListener {
            result = ""
            num1 = 0.0
            num2 = 0.0
            textView.text = result
        })
        val buttonEqual = findViewById<Button>(R.id.equal)
        buttonEqual.setOnClickListener(View.OnClickListener {
            num2=result.toDouble()
            textView.text = result
            calculo = Calculo(num1,num2,operador)
            result = calculo.operacion(operador).toString()
            textView.text = result
            num1 = result.toDouble()
            num2 = 0.0
            result="0"
        })
    }
}