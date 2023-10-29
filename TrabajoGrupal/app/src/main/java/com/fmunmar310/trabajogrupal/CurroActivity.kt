package com.fmunmar310.trabajogrupal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

/**
 * Main activity de nuestra calculadora
 */
class CurroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_curro)
        val textView = findViewById<TextView>(R.id.textView)
        var result = ""
        var operador: String
        val calculoCurro = CalculoCurro()

        val buttonSalir = findViewById<Button>(R.id.exit)
        buttonSalir.setOnClickListener {
            finishAndRemoveTask()
        }
        //botón del número 1, añade a la variable text el valor correspondiente
        val button1 = findViewById<Button>(R.id.num1)
        button1.setOnClickListener {
            result += "1"
            textView.text = result
        }

        //botón del número 2, añade a la variable text el valor correspondiente
        val button2 = findViewById<Button>(R.id.num2)
        button2.setOnClickListener{
            result += "2"
            textView.text = result
        }

        //botón del número 3, añade a la variable text el valor correspondiente
        val button3 = findViewById<Button>(R.id.num3)
        button3.setOnClickListener{
            result += "3"
            textView.text = result
        }

        //botón del número 4, añade a la variable text el valor correspondiente
        val button4 = findViewById<Button>(R.id.num4)
        button4.setOnClickListener{
            result += "4"
            textView.text = result
        }

        //botón del número 5, añade a la variable text el valor correspondiente
        val button5 = findViewById<Button>(R.id.num5)
        button5.setOnClickListener{
            result += "5"
            textView.text = result
        }

        // botón del número 6, añade a la variable text el valor correspondiente
        val button6 = findViewById<Button>(R.id.num6)
        button6.setOnClickListener{
            result += "6"
            textView.text = result
        }

        // botón del número 7, añade a la variable text el valor correspondiente
        val button7 = findViewById<Button>(R.id.num7)
        button7.setOnClickListener{
            result += "7"
            textView.text = result
        }

        // botón del número 8, añade a la variable text el valor correspondiente
        val button8 = findViewById<Button>(R.id.num8)
        button8.setOnClickListener{
            result += "8"
            textView.text = result
        }

        // botón del número 9, añade a la variable text el valor correspondiente

        val button9 = findViewById<Button>(R.id.num9)
        button9.setOnClickListener{
            result += "9"
            textView.text = result
        }

        // botón del número 0, añade a la variable text el valor correspondiente
        val button0 = findViewById<Button>(R.id.num0)
        button0.setOnClickListener{
            result += "0"
            textView.text = result
        }

        /* botón para añadir punto, añade a la variable text el valor correspondiente,
         al pulsar "." añadimos un cero delante si no hay nada introducido,  no es estrictamente
         necesario porque en la conversión a double se añade solo, pero de esta manera aparecerá
         en el textView y quedará mejor.
         */
        val buttonDot = findViewById<Button>(R.id.dot)
        buttonDot.setOnClickListener{
            result += if (result.isEmpty() || result.last() in arrayOf('+','-','/','*')){
                "0."
            } else{
                "."
            }
            textView.text = result
        }

        // botón para añadir suma como operación
        val buttonPlus = findViewById<Button>(R.id.plus)
        buttonPlus.setOnClickListener{
            if (compruebaTamText(result)) { // si no hay ningún número añadido lanza mensaje de error
                lanzarMensajeToast()
            }else {
                operador = "+"
                pulsaBoton(result, operador, calculoCurro) // llamada a la función pulsaBoton
                // realizamos el cálculo y lo mostramos con un formato determinado añadiendo el operador a la variable result
                result = formatear(calculoCurro.operacion()) + operador
                textView.text = result
            }
        }

        // botón para añadir resta como operación

        val buttonMinus = findViewById<Button>(R.id.minus)
        buttonMinus.setOnClickListener{
            if (compruebaTamText(result)) { // si no hay ningún número añadido lanza mensaje de error
                lanzarMensajeToast()
            }else {
                operador = "-"
                pulsaBoton(result, operador, calculoCurro) // llamada a la función pulsaBoton
                // realizamos el cálculo y lo mostramos con un formato determinado añadiendo el operador a la variable result
                result = formatear(calculoCurro.operacion()) + operador
                textView.text = result
            }
        }

        // botón para añadir multiplicación como operación
        val buttonMult = findViewById<Button>(R.id.multiply)
        buttonMult.setOnClickListener{
            if (compruebaTamText(result)) { // si no hay ningún número añadido lanza mensaje de error
                lanzarMensajeToast()
            }else {
                operador = "*"
                pulsaBoton(result, operador, calculoCurro) // llamada a la función pulsaBoton
                // realizamos el cálculo y lo mostramos con un formato determinado añadiendo el operador a la variable result
                result = formatear(calculoCurro.operacion()) + operador
                textView.text = result
            }
        }

        // botón para añadir división como operación
        val buttonDiv = findViewById<Button>(R.id.divide)
        buttonDiv.setOnClickListener{
            if (compruebaTamText(result)) { // si no hay ningún número añadido lanza mensaje de error
                lanzarMensajeToast()
            }else {
                operador = "/"
                pulsaBoton(result, operador, calculoCurro) // llamada a la función pulsaBoton
                // realizamos el cálculo y lo mostramos con un formato determinado añadiendo el operador a la variable result
                result = formatear(calculoCurro.operacion()) + operador
                textView.text = result
            }
        }

        // botón par borrar el último caracter añadido
        val buttonDel = findViewById<Button>(R.id.del)
        buttonDel.setOnClickListener{
            if(result.isEmpty()){ // Si no hay nada añadido a la variable text lanza mensaje de error
                errorBorrar()
            }else {
                var tempBorr: String  // variable que se usa para pasar de Double a text los atributos de la calse calculo
                if(calculoCurro.numUno){ // comprueba si se está añadiendo el primer número
                    tempBorr = calculoCurro.num1.toString() // se asigna el valor de num1 a tempBorr
                    tempBorr = tempBorr.substring(0,tempBorr.length-1) // se elimina el último caracter añadido
                    calculoCurro.num1 = tempBorr.toDouble() // se reasigna el valor a num1
                }else { // si ya ha sido añadido el primer número se realiza la misma operación con num2
                    tempBorr = calculoCurro.num2.toString()
                    tempBorr = tempBorr.substring(0, tempBorr.length - 1)
                    calculoCurro.num2 = tempBorr.toDouble()
                }
                result = result.substring(0, result.length - 1) // se elimina el valor de result
                textView.text = result
                if(tempBorr.isEmpty()){calculoCurro.numUno = true}
                //si tempBorr está vacío se indica que numUno es true
            }
        }

        // botón para resetear los valores a su valor inicial
        val buttonCe = findViewById<Button>(R.id.ce)
        buttonCe.setOnClickListener{
            result = ""
            calculoCurro.resetear()
            textView.text = result
        }

        // botón para obtener el resultado
        val buttonEqual = findViewById<Button>(R.id.equal)
        buttonEqual.setOnClickListener{
            if (compruebaTamText(result)) { // si no hay ningún número añadido lanza mensaje de error
                lanzarMensajeToast()
            }else {
                operador = "="
                pulsaBoton(result, operador, calculoCurro) // llamada a la función pulsaBoton
                // realizamos el cálculo y lo mostramos con un formato determinado añadiendo el operador a la variable result
                result = formatear(calculoCurro.operacion())
                textView.text = result
                calculoCurro.numUno = true
            }
        }
    }

    /**
     * @return devuelve un num Double con dos decimales
     */
    private fun formatear(num: Double): String {
        return String.format("%.2f", num)
    }

    /**
     * Función a la que llamamos cuando se pulsan los botones de operación o resultado
     */
    private fun pulsaBoton(cadena: String, oper: String, calculoCurro: CalculoCurro) {
        var lista: List<String>
        if (oper == "=") {
            for (i in cadena) {
                if (i in arrayOf('+','-','/','*')) {
                    lista = cadena.split(i)
                    calculoCurro.num1 = lista[0].toDouble()
                    calculoCurro.num2 = lista[1].toDouble()
                    calculoCurro.op = "$i"
                }
            }
        } else {
            if (calculoCurro.numUno) {
                calculoCurro.num1 = cadena.toDouble()
            } else {
                for (i in cadena) {
                    if (i in arrayOf('+','-','/','*')) {
                        lista = cadena.split(i)
                        calculoCurro.num1 = lista[0].toDouble()
                        calculoCurro.num2 = lista[1].toDouble()
                        calculoCurro.op = "$i"
                    }
                }
            }
        }
    }
    private fun compruebaTamText(text: String): Boolean {
        if (text.isEmpty()) {
            return true
        }
        return false
    }

    /**
     * Lanza mensaje de error, esta función se llama cuando no se han rellenado los datos correctamente
     * y se pulsa algún botón de operación
     */
    private fun lanzarMensajeToast() {
        Toast.makeText(this, "Error, faltan datos o son erróneos", Toast.LENGTH_SHORT).show()
    }

    /**
     * Se llama cuando se intenta borrar y ya no queda nada para borrar
     */
    private fun errorBorrar(){
        Toast.makeText(this, "No se puede borrar", Toast.LENGTH_SHORT).show()
    }
}

