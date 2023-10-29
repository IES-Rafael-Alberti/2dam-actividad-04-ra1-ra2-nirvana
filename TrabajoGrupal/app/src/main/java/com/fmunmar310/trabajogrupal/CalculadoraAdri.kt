package com.fmunmar310.trabajogrupal

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.DecimalFormat

@Suppress("SpellCheckingInspection")
class CalculadoraAdri : AppCompatActivity() {

    /**
     * Comienzamos declarando las variables necesarias para poder utilizarlas
     * luego, con un lateinit:
     */

    private lateinit var mainbox: TextView
    private lateinit var detailbox: TextView

    // Una lista que contiene todos los botones del tipo número:
    private lateinit var btnN: ArrayList<Button>

    // Una lista que contiene todos los botones de operación:
    private lateinit var btnOp: ArrayList<Button>

    // Botón para borrar lo que haya en pantalla, un reseteo completo:
    private lateinit var btnC: Button

    // El botón igual, para mostrar los resultados:
    private lateinit var btnEq: Button

    // Botón para borrar uno a uno:
    private lateinit var btnCE: Button

    // Botón para acceder al menú y salir de mi calculadora

    private lateinit var btnExit: Button

    // Objeto de la clase calc:
    private lateinit var calc: CalcAdri

    // Para que los decimales solo lleguen hasta 3
    private val decimalformat = DecimalFormat("#.###")

    /**
     * Haremos un onCreate con el objeto calc, luego llamamos a initComponents y initListeners
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora_adri)

        // Creamos el objeto de la clase Calc:
        calc = CalcAdri()

        //Inicializamos las variables que corresponderán a cada componente
        // y les asignamos una función al evento que se programa de cada uno.
        initComponents()
        initListeners()
    }

    /**
     * Inicializamos las variables de los textviews y los botones que vamos a usar,
     * luego inicializamos intiBtnNum y initBtnOp, que son todos los botones de números y
     * todos los botones de operadores.
     */

    private fun initComponents() {
        mainbox = findViewById(R.id.mainbox)
        detailbox = findViewById(R.id.detailbox)

        btnC = findViewById(R.id.buttonC); btnC.setBackgroundColor(Color.parseColor("#FF0000"))
        btnCE = findViewById(R.id.buttonOpCE); btnCE.setBackgroundColor(Color.parseColor("#FFA500"))
        btnEq = findViewById(R.id.buttonOpEq); btnEq.setBackgroundColor(Color.parseColor("#00FF00"))
        btnExit = findViewById(R.id.buttonSalir); btnEq.setBackgroundColor(Color.parseColor("#0040FF"))


        mainbox.text = ""
        detailbox.text = ""

        initBtnNumList()
        initBtnOpList()
    }

    /**
     * Añadimos a una lista de botones de números todos los botones de tipo número
     */

    private fun initBtnNumList() {
        btnN = ArrayList()
        btnN.add(findViewById(R.id.buttonN0))
        btnN.add(findViewById(R.id.buttonN1))
        btnN.add(findViewById(R.id.buttonN2))
        btnN.add(findViewById(R.id.buttonN3))
        btnN.add(findViewById(R.id.buttonN4))
        btnN.add(findViewById(R.id.buttonN5))
        btnN.add(findViewById(R.id.buttonN6))
        btnN.add(findViewById(R.id.buttonN7))
        btnN.add(findViewById(R.id.buttonN8))
        btnN.add(findViewById(R.id.buttonN9))
        btnN.add(findViewById(R.id.buttonOpPoint))
    }

    /**
     * Añadimos a una lista de botones de números todos los botones de tipo operador
     */
    private fun initBtnOpList() {
        btnOp = ArrayList()
        btnOp.add(findViewById(R.id.buttonOpSum))
        btnOp.add(findViewById(R.id.buttonOpRest))
        btnOp.add(findViewById(R.id.buttonOpMult))
        btnOp.add(findViewById(R.id.buttonOpDiv))
    }

    /**
     *
     */
    private fun initListeners() {
        for (i in 0..<btnN.count()) {
            btnN[i].setOnClickListener { btnNumClicked(i) }
        }

        for (i in 0..<btnOp.count()) {
            btnOp[i].setOnClickListener { btnOperClicked(i) }
        }

        btnC.setOnClickListener { btnC() }
        btnCE.setOnClickListener { borrarDigito() }
        btnEq.setOnClickListener { btnEqual() }
        btnExit.setOnClickListener{btnEx()}

    }

    /**
     * Esta función borrará los últimos dígitos del número actual en función del estado de la calculadora.
     */
    private fun borrarDigito() {
        if (calc.localizadorNum) { // Si es true, nos centramos en el numTemp1
            // Si la string no está vacía, podremos quitarle caracteres
            if (calc.Temp1.isNotEmpty()) {
                // Aquí borrará el último dígito de numTemp1, con una
                // substring que excluirá el último caracter
                calc.Temp1 = calc.Temp1.substring(0, calc.Temp1.length - 1)
            } else { // Si la string está vacia, significa que ya no hay nada que borrar
                errMsg("No hay dígitos para borrar")
            }
        } else { // Si el false, nos centramos en el numTemp2
            // Si la string no está vacía, podremos quitarle caracteres
            if (calc.Temp2.isNotEmpty()) {
                // Aquí borrará el último dígito de numTemp2, con una
                // substring que excluirá el último caracter
                calc.Temp2 = calc.Temp2.substring(0, calc.Temp2.length - 1)
            } else {
                // Si la string está vacia, empezaremos a borrar el simbolo de
                // operación y luego el primer número hasta que nos quedemos sin
                // dígitos, donde aparecerá el mensaje de error de la parte anterior
                // del código

                // Hacemos que sea un simbolo de operador vacío, valiendonos de la
                // lógica de la fun calcular y de la fun operadorTxt.
                calc.op = 4
                calc.localizadorNum = true // Una vez el simbolo esté borrado, pasaremos
                // al primer número, por lo que se aplicará el código
                // anterior (el primer if de esta funcion)
            }
        }
        if (calc.localizadorNum) { // Si es el primer número, refrescará el primer número
            printValue(calc.Temp1, calc.Temp1 + calc.opPrint() + calc.Temp2)
        } else { // Si es el segundo número, refrescará el segundo número
            printValue(calc.Temp2, calc.Temp1 + calc.opPrint() + calc.Temp2)
        }
    }

    /**
     * Agrega el dígito pulsado en el número correspondiente del objeto calc.
     *
     * @param num dígito pulsado del 0 al 9 o punto decimal (10)
     */
    private fun btnNumClicked(num: Int) {
        calc.controlDeDigitos(num)
        //Mostramos info actualizada en los TextView de la app
        if (calc.localizadorNum) {
            printValue(calc.Temp1, calc.Temp1)
        } else {
            printValue(calc.Temp2, calc.Temp1 + calc.opPrint() + calc.Temp2)
        }
    }

    /**
     * Agrega la operación para realizar el cálculo
     *
     */
    private fun btnOperClicked(num: Int) {
        if (calc.localizadorNum) {
            //Tratamiento de la operación cuando estamos introduciendo el primer número.

            if (calc.nCalc > 0 && calc.Temp1 == "") {
                //Si hay un cálculo anterior y el num1 aún está vacío, el resultado anterior es el num1 del siguiente cálculo.
                calc.n1 = calc.resultado
                calc.Temp1 = decimalformat.format(calc.resultado).toString()
            } else {
                //Sino, asignamos num1 del objeto calc convirtiendo los dígitos introducidos a float.
                //Además, si existe algún problema o cuando si se pulsa un operador sin introducir número antes, lo capturamos y usamos el valor 0.
                try {
                    calc.n1 = calc.Temp1.toFloat()
                } catch (e: NumberFormatException) {
                    calc.n1 = 0F
                    calc.Temp1 = "0"
                }
            }
            //Asignamos el operador al objeto calc, mostramos info en pantalla y actualizamos las características necesarias de calc para indicar que pasamos al estado de introducir el segundo número.
            calc.op = num
            printValue(calc.opPrint(), calc.Temp1 + calc.opPrint())
            calc.Temp2 = ""
            calc.localizadorNum = false
        } else if (calc.Temp2 == "") {
            //Si se introduce una operación y aún no existe el segundo número la nueva operación debe reemplazar la operación anterior.
            calc.op = num
            //Mostramos en pantalla la actualización del operador.
            printValue(calc.opPrint(), calc.Temp1 + calc.opPrint())
        } else {
            //Tratamiento de la operación cuando estamos introduciendo el segundo número.
            //Convertimos la cadena de dígitos en el número 2 y realizamos el cálculo.
            //Si existe algún problema en la conversión la controlamos asignando el valor 0.
            calc.n2 = try {
                calc.Temp2.toFloat()
            } catch (e: NumberFormatException) {
                0f
            }
            calc.calculos()

            //Mostramos en pantalla el resultado del cálculo como detalle y la operación en la pantalla principal.
            printValue(
                calc.opPrint(num),
                decimalformat.format(calc.resultado).toString() + calc.opPrint(num)
            )

            //Actualizamos las características necesarias del objeto calc, ya que vamos a seguir en el estado de introducir solo un segundo número, ya que el primer número y la operación es asignado como el resultado del cálculo realizado y la nueva operación introducida.
            calc.n1 = calc.resultado
            calc.op = num
            calc.n2 = 0f
            calc.Temp1 = decimalformat.format(calc.n1).toString()
            calc.Temp2 = ""
        }
    }

    /**
     * Reiniciar los valores del objeto calc cuando se pulsa el botón C
     */
    private fun btnC() {
        //Mostramos en pantalla y detalle la cadena de caracteres vacía.
        printValue("", "")
        //Inicializamos las características del objeto calc.
        calc.resetCalc()
    }

    /**
     * Aquí nos hará la operación deaseada al pulsar el boton "="
     */
    private fun btnEqual() {
        if (!calc.localizadorNum && calc.Temp2 != "") {
            //Si estamos introduciendo el segundo número, lo actualizamos convirtiendo la cadena de dígitos y calculamos la operación.
            calc.n2 = try {
                calc.Temp2.toFloat()
            } catch (e: NumberFormatException) {
                0f
            }
            calc.calculos()

            //Mostramos en pantalla el resultado y en detalle toda la operación (num1 + num2 = result) formateando a 2 posiciones decimales.
            printValue(
                decimalformat.format(calc.resultado).toString(),
                decimalformat.format(calc.n1).toString() + calc.opPrint() + decimalformat.format(
                    calc.n2
                ).toString() + "=" + decimalformat.format(calc.resultado).toString()
            )

            //Inicializamos las características del objeto calc, excepto el número de cálculos.
            calc.resetCalc(resetNCalc = false, resetResultado = false)
        } else {
            errMsg("Debe introducir 2 números y una operación para mostrar un resultado")
        }
    }

    /**
     * Mostraremos la info por pantalla de lo que hagamos en la calculadora
     *
     * @param main info a mostrar en txtPantalla
     * @param detail info a mostrar en txtDetalle
     */
    private fun printValue(main: String, detail: String) {
        mainbox.text = getString(R.string.OutputMainbox, main)
        detailbox.text = getString(R.string.OutputDetailbox, detail)
    }

    /**
     * Mostraremos un toast para indicar un error:
     */
    private fun errMsg(msj: String) {
        Toast.makeText(this, msj, Toast.LENGTH_SHORT).show()
    }
    private fun btnEx(){
        finishAndRemoveTask()
    }
}
