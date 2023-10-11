package com.fmunmar310.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

/**
 * Main activity de nuestra calculadora
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.textView)

        /**
         * @param result variable que vamos a mostrar por el textview
         * @param operador variable que nos dará la operación a realizar
         * @param num1 variable de número 1 de la operación
         * @param num2 variable de número 2 de la operación
         */
        var result = " "
        var operador=""
        var num1 = 0.0
        var num2 = 0.0

        /**
         * @param variable que usaremos para crear nuestro cálculo
         * @see Calculo para más información
         */
        var calculo = Calculo(num1,num2,operador)

        /**
         * botón del número 1
         */
        val button1 = findViewById<Button>(R.id.num1)
        button1.setOnClickListener(View.OnClickListener {
            result+="1"
            textView.text = result})
        /**
         * botón del número 2
         */
        val button2 = findViewById<Button>(R.id.num2)
        button2.setOnClickListener(View.OnClickListener {
            result+="2"
            textView.text = result})
        /**
         * botón del número 3
         */
        val button3 = findViewById<Button>(R.id.num3)
        button3.setOnClickListener(View.OnClickListener {
            result+="3"
            textView.text = result})
        /**
         * botón del número 4
         */
        val button4 = findViewById<Button>(R.id.num4)
        button4.setOnClickListener(View.OnClickListener {
            result+="4"
            textView.text = result})
        /**
         * botón del número 5
         */
        val button5 = findViewById<Button>(R.id.num5)
        button5.setOnClickListener(View.OnClickListener {
            result+="5"
            textView.text = result})
        val button6 = findViewById<Button>(R.id.num6)
        /**
         * botón del número 6
         */
        button6.setOnClickListener(View.OnClickListener {
            result+="6"
            textView.text = result})
        /**
         * botón del número 7
         */
        val button7 = findViewById<Button>(R.id.num7)
        button7.setOnClickListener(View.OnClickListener {
            result+="7"
            textView.text = result})
        /**
         * botón del número 8
         */
        val button8 = findViewById<Button>(R.id.num8)
        button8.setOnClickListener(View.OnClickListener {
            result+="8"
            textView.text = result})
        /**
         * botón del número 9
         */
        val button9 = findViewById<Button>(R.id.num9)
        button9.setOnClickListener(View.OnClickListener {
            result+="9"
            textView.text = result})
        /**
         * botón del número 0
         */
        val button0 = findViewById<Button>(R.id.num0)
        button0.setOnClickListener(View.OnClickListener {
            result+="0"
            textView.text = result})
        /**
         * botón para añadir punto
         */
        val buttonDot = findViewById<Button>(R.id.dot)
        buttonDot.setOnClickListener(View.OnClickListener {
            result+="."
            textView.text = result})
        /**
         * botón para añadir suma como operación, si operador ya tiene un valor asignado realizará primero la operación designada
         * y luego cambiará el valor de la variable operador. Si no hay un operador asignado primero se comprueba si ya hay num1 añadido,
         * en caso negativo añade num1, en caso positivo realiza la operación y traslada el valor de la misma a num1.
         * Al final de cada operación reseteamos el valor de num2 y de operador.
         */
        val buttonPlus = findViewById<Button>(R.id.plus)
        buttonPlus.setOnClickListener(View.OnClickListener {
            if (operador == "") {
                operador = "+"
                if (num1 == 0.0) {
                    num1 = result.toDouble()
                    textView.text = result
                    result = " "
                } else {
                    num2 = result.toDouble()
                    textView.text = result
                    calculo = Calculo(num1, num2, operador)
                    result = calculo.operacion(operador).toString()
                    textView.text = result
                    num1 = result.toDouble()
                    num2 = 0.0
                    result = ""
                }
            }else{
                num2 = result.toDouble()
                textView.text = result
                calculo = Calculo(num1, num2, operador)
                result = calculo.operacion(operador).toString()
                textView.text = result
                num1 = result.toDouble()
                num2 = 0.0
                result = ""
                operador="+"
            }
        })
        /**
         * botón para añadir resta como operación, si operador ya tiene un valor asignado realizará primero la operación designada
         * y luego cambiará el valor de la variable operador. Si no hay un operador asignado primero se comprueba si ya hay num1 añadido,
         * en caso negativo añade num1, en caso positivo realiza la operación y traslada el valor de la misma a num1.
         * Al final de cada operación reseteamos el valor de num2 y de operador.
         */
        val buttonMinus = findViewById<Button>(R.id.minus)
        buttonMinus.setOnClickListener(View.OnClickListener {
            if (operador == "") {
                operador = "-"
                if (num1 == 0.0) {
                    num1 = result.toDouble()
                    textView.text = result
                    result = " "
                } else {
                    num2 = result.toDouble()
                    textView.text = result
                    calculo = Calculo(num1, num2, operador)
                    result = calculo.operacion(operador).toString()
                    textView.text = result
                    num1 = result.toDouble()
                    num2 = 0.0
                    result = " "
                }
            }else{
                num2 = result.toDouble()
                textView.text = result
                calculo = Calculo(num1, num2, operador)
                result = calculo.operacion(operador).toString()
                textView.text = result
                num1 = result.toDouble()
                num2 = 0.0
                result = " "
                operador="-"
            }
        })
        /**
         * botón para añadir multiplicación como operación, si operador ya tiene un valor asignado realizará primero la operación designada
         * y luego cambiará el valor de la variable operador. Si no hay un operador asignado primero se comprueba si ya hay num1 añadido,
         * en caso negativo añade num1, en caso positivo realiza la operación y traslada el valor de la misma a num1.
         * Al final de cada operación reseteamos el valor de num2 y de operador.
         */
        val buttonMult = findViewById<Button>(R.id.multiply)
        buttonMult.setOnClickListener(View.OnClickListener {
            if (operador == ""){
                operador = "*"
                if (num1 == 0.0) {
                    num1=result.toDouble()
                    textView.text = result
                    result=" "
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
            }else{
                num2 = result.toDouble()
                textView.text = result
                calculo = Calculo(num1,num2,operador)
                result=calculo.operacion(operador).toString()
                textView.text = result
                num1 = result.toDouble()
                num2 = 0.0
                result=""
                operador="*"
            }
        })
        /**
         * botón para añadir división como operación, si operador ya tiene un valor asignado realizará primero la operación designada
         * y luego cambiará el valor de la variable operador. Si no hay un operador asignado primero se comprueba si ya hay num1 añadido,
         * en caso negativo añade num1, en caso positivo realiza la operación y traslada el valor de la misma a num1.
         * Al final de cada operación reseteamos el valor de num2 y de operador.
         */
        val buttonDiv = findViewById<Button>(R.id.divide)
        buttonDiv.setOnClickListener(View.OnClickListener {
            if(operador==""){
            operador = "/"
            if (num1 == 0.0) {
                num1=result.toDouble()
                textView.text = result
                result=" "
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
        }else{
                num2 = result.toDouble()
                textView.text = result
                calculo = Calculo(num1,num2,operador)
                result=calculo.operacion(operador).toString()
                textView.text = result
                num1 = result.toDouble()
                num2 = 0.0
                result=""
                operador="/"
            }
        })/**
         * botón para resetear los valores a su valor inicial
         */
        val buttonCe = findViewById<Button>(R.id.ce)
        buttonCe.setOnClickListener(View.OnClickListener {
            result = ""
            num1 = 0.0
            num2 = 0.0
            textView.text = result
        })
        /**
         * botón para obtener el resultado, se crea el objeto cálculo con los valores num1, num2 y operación y se llama al método operación del mismo.
         * @see Calculo
         */
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