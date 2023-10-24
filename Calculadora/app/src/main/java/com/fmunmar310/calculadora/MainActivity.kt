package com.fmunmar310.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

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
        var result = ""
        var operador = ""


        /**
         * @param calculo variable que usaremos para crear nuestro cálculo
         * @see Calculo para más información
         */
        var calculo = Calculo()

        //botón del número 1, añade a la variable text el valor correspondiente
        val button1 = findViewById<Button>(R.id.num1)
        button1.setOnClickListener(View.OnClickListener {
            result += "1"
            textView.text = result
        })

        //botón del número 2, añade a la variable text el valor correspondiente
        val button2 = findViewById<Button>(R.id.num2)
        button2.setOnClickListener(View.OnClickListener {
            result += "2"
            textView.text = result
        })

        //botón del número 3, añade a la variable text el valor correspondiente
        val button3 = findViewById<Button>(R.id.num3)
        button3.setOnClickListener(View.OnClickListener {
            result += "3"
            textView.text = result
        })

        //botón del número 4, añade a la variable text el valor correspondiente
        val button4 = findViewById<Button>(R.id.num4)
        button4.setOnClickListener(View.OnClickListener {
            result += "4"
            textView.text = result
        })

        //botón del número 5, añade a la variable text el valor correspondiente
        val button5 = findViewById<Button>(R.id.num5)
        button5.setOnClickListener(View.OnClickListener {
            result += "5"
            textView.text = result
        })
        val button6 = findViewById<Button>(R.id.num6)

        // botón del número 6, añade a la variable text el valor correspondiente
        button6.setOnClickListener(View.OnClickListener {
            result += "6"
            textView.text = result
        })

        // botón del número 7, añade a la variable text el valor correspondiente
        val button7 = findViewById<Button>(R.id.num7)
        button7.setOnClickListener(View.OnClickListener {
            result += "7"
            textView.text = result
        })

        // botón del número 8, añade a la variable text el valor correspondiente
        val button8 = findViewById<Button>(R.id.num8)
        button8.setOnClickListener(View.OnClickListener {
            result += "8"
            textView.text = result
        })

        // botón del número 9, añade a la variable text el valor correspondiente

        val button9 = findViewById<Button>(R.id.num9)
        button9.setOnClickListener(View.OnClickListener {
            result += "9"
            textView.text = result
        })

        // botón del número 0, añade a la variable text el valor correspondiente
        val button0 = findViewById<Button>(R.id.num0)
        button0.setOnClickListener(View.OnClickListener {
            result += "0"
            textView.text = result
        })

        // botón para añadir punto, añade a la variable text el valor correspondiente
        val buttonDot = findViewById<Button>(R.id.dot)
        buttonDot.setOnClickListener(View.OnClickListener {
            result += "."
            textView.text = result
        })

          // botón para añadir suma como operación
        val buttonPlus = findViewById<Button>(R.id.plus)
        buttonPlus.setOnClickListener(View.OnClickListener {
            if (compruebaTamañoText(result)) { // si no hay ningún número añadido lanza mensaje de error
                lanzarMensajeToast()
            }else {
                operador = "+"
                pulsaBoton(result, operador, calculo) // llamada a la función pulsaBoton
                // realizamos el cálculo y lo mostramos con un formato determinado añadiendo el operador a la variable result
                result = formatear(calculo.operacion()) + operador
                textView.text = result
            }

        })

          // botón para añadir resta como operación

        val buttonMinus = findViewById<Button>(R.id.minus)
        buttonMinus.setOnClickListener(View.OnClickListener {
            if (compruebaTamañoText(result)) { // si no hay ningún número añadido lanza mensaje de error
                lanzarMensajeToast()
            }else {
                operador = "-"
                pulsaBoton(result, operador, calculo) // llamada a la función pulsaBoton
                // realizamos el cálculo y lo mostramos con un formato determinado añadiendo el operador a la variable result
                result = formatear(calculo.operacion()) + operador
                textView.text = result
            }

        })

          // botón para añadir multiplicación como operación

        val buttonMult = findViewById<Button>(R.id.multiply)
        buttonMult.setOnClickListener(View.OnClickListener {
            if (compruebaTamañoText(result)) { // si no hay ningún número añadido lanza mensaje de error
                lanzarMensajeToast()
            }else {
                operador = "*"
                pulsaBoton(result, operador, calculo) // llamada a la función pulsaBoton
                // realizamos el cálculo y lo mostramos con un formato determinado añadiendo el operador a la variable result
                result = formatear(calculo.operacion()) + operador
                textView.text = result
            }

        })

          // botón para añadir división como operación
        val buttonDiv = findViewById<Button>(R.id.divide)
        buttonDiv.setOnClickListener(View.OnClickListener {
            if (compruebaTamañoText(result)) { // si no hay ningún número añadido lanza mensaje de error
                lanzarMensajeToast()
            }else {
                operador = "/"
                pulsaBoton(result, operador, calculo) // llamada a la función pulsaBoton
                // realizamos el cálculo y lo mostramos con un formato determinado añadiendo el operador a la variable result
                result = formatear(calculo.operacion()) + operador
                textView.text = result
            }
        })

        // botón par borrar el último caracter añadido
        val buttonDel = findViewById<Button>(R.id.del)
        buttonDel.setOnClickListener(View.OnClickListener {
            if(result.length < 1){ // Si no hay nada añadido a la variable text lanza mensaje de error
                errorBorrar()
            }else {
                var tempBorr = "" // variable que se usa para pasar de Double a text los atributos de la calse calculo
                if(calculo.numUno){ // comprueba si se está añadiendo el primer número
                    tempBorr = calculo.num1.toString() // se asigna el valor de num1 a tempBorr
                    tempBorr = tempBorr.substring(0,tempBorr.length-1) // se elimina el último caracter añadido
                    calculo.num1 = tempBorr.toDouble() // se reasigna el valor a num1
                }else { // si ya ha sido añadido el primer número se realiza la misma operación con num2
                    tempBorr = calculo.num2.toString()
                    tempBorr = tempBorr.substring(0, tempBorr.length - 1)
                    calculo.num2 = tempBorr.toDouble()
                    }
                result = result.substring(0, result.length - 1) // se elimina el valor de result
                textView.text = result
                if(tempBorr.isEmpty()){calculo.numUno = true}
            //si tempBorr está vacío se indica que numUno es true
            }
        })

        // botón para resetear los valores a su valor inicial
        val buttonCe = findViewById<Button>(R.id.ce)
        buttonCe.setOnClickListener(View.OnClickListener {
            result = ""
            calculo.resetear()
            textView.text = result
        })

        // botón para obtener el resultado

        val buttonEqual = findViewById<Button>(R.id.equal)
        buttonEqual.setOnClickListener(View.OnClickListener {
            if (compruebaTamañoText(result)) { // si no hay ningún número añadido lanza mensaje de error
                lanzarMensajeToast()
            }else {
                operador = "="
                pulsaBoton(result, operador, calculo) // llamada a la función pulsaBoton
                // realizamos el cálculo y lo mostramos con un formato determinado añadiendo el operador a la variable result
                result = formatear(calculo.operacion())
                textView.text = result
                calculo.numUno = true
            }
        })
    }

    fun formatear(num: Double): String {
        return String.format("%.2f", num)
    }


    fun pulsaBoton(cadena: String, oper: String, calculo: Calculo) {
            var lista = listOf<String>()
            if (oper == "=") {
                for (i in cadena) {
                    if (i == '+' || i == '-' || i == '*' || i == '/') {
                        lista = cadena.split(i)
                        calculo.num1 = lista[0].toDouble()
                        calculo.num2 = lista[1].toDouble()
                        calculo.op = "$i"
                    }
                }
            } else {
                if (calculo.numUno) {
                    calculo.num1 = cadena.toDouble()
                } else {
                    for (i in cadena) {
                        if (i == '+' || i == '-' || i == '*' || i == '/') {
                            lista = cadena.split(i)
                            calculo.num1 = lista[0].toDouble()
                            calculo.num2 = lista[1].toDouble()
                            calculo.op = "$i"
                        }
                    }
                }
            }
        }
    fun compruebaTamañoText(text: String): Boolean {
        if (text.isEmpty()) {
            return true
        }
        return false
    }
    fun lanzarMensajeToast() {
        Toast.makeText(this, "Error, faltan datos o son erróneos", Toast.LENGTH_SHORT).show()
    }
    fun errorBorrar(){
        Toast.makeText(this, "No se puede borrar", Toast.LENGTH_SHORT).show()

    }
}

