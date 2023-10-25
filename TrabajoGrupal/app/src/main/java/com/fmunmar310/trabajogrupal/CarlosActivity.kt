package com.fmunmar310.trabajogrupal



import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class CarlosActivity : AppCompatActivity() {
    private var calc = CalculoCarlos()
    private lateinit var numeros:MutableList<Button>
    private lateinit var operaciones:MutableList<Button>
    private lateinit var botonCE: Button
    private lateinit var mainTexto: TextView
    private lateinit var secondTexto: TextView
    private lateinit var igual:Button
    private lateinit var punto:Button
    private lateinit var borrar: Button
    private lateinit var volver:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initVariables()
        initListeners()

    }

    /**
     * Inicializa todas las variables de la MainActivity utilizando findViewById()
     */
    private fun initVariables(){
        numeros = crearListaNumeros()
        operaciones = crearListaOperaciones()
        botonCE = findViewById(R.id.ce)
        mainTexto = findViewById(R.id.textNumbers)
        secondTexto = findViewById(R.id.textMemoryNumbers)
        igual = findViewById(R.id.equal)
        punto = findViewById(R.id.point)
        borrar = findViewById(R.id.delete)
        volver = findViewById(R.id.back)
    }

    /**
     * Lee todos los botones que esten del 0 al 9
     * @return Una lista con todos los botones numericos
     */
    private fun crearListaNumeros():MutableList<Button>{
        val listButtons = mutableListOf<Button>()
        listButtons.add(findViewById(R.id.zero))
        listButtons.add(findViewById(R.id.one))
        listButtons.add(findViewById(R.id.two))
        listButtons.add(findViewById(R.id.three))
        listButtons.add(findViewById(R.id.four))
        listButtons.add(findViewById(R.id.five))
        listButtons.add(findViewById(R.id.six))
        listButtons.add(findViewById(R.id.seven))
        listButtons.add(findViewById(R.id.eight))
        listButtons.add(findViewById(R.id.nine))
        return listButtons
    }
    /**
     * Lee todos los botones que sean un tipo de operacion
     * @return Una lista con todos los botones de operaciones
     */
    private fun crearListaOperaciones():MutableList<Button>{
        val listButtons = mutableListOf<Button>()
        listButtons.add(findViewById(R.id.plus))
        listButtons.add(findViewById(R.id.minus))
        listButtons.add(findViewById(R.id.product))
        listButtons.add(findViewById(R.id.divide))
        return listButtons
    }

    /**
     * Define los listeners de todos los botones
     */
    private fun initListeners(){
        for (botonNum in numeros){
            botonNum.setOnClickListener { listenerNumeros(botonNum) }
        }
        for (botonOp in operaciones){
            botonOp.setOnClickListener { listenerOperaciones(botonOp) }
        }
        igual.setOnClickListener { listenerIgual() }
        botonCE.setOnClickListener { listenerBotonCE() }
        punto.setOnClickListener { listenerPunto() }
        borrar.setOnClickListener { listenerBorrar() }
        volver.setOnClickListener { listenerVolver() }
    }

    /**
     * Segun el boton numerico pulsado se añade al textView para que se muestre por pantalla
     * @param boton el boton numerico
     */
    private fun listenerNumeros(boton:Button){
        if (esOperacion(getTextViewText(mainTexto))){
            mainTexto.text=""
        }//si el textView tiene una operacion la borra
        if (calc.num1 == 0f && calc.esperandoA == "num1" && mainTexto.text == ""){
            mainTexto.text = boton.text
            secondTexto.text = boton.text
        }
        else if (mainTexto.text=="0"){
            mainTexto.text = boton.text
            secondTexto.text = boton.text
        }
        else {
            concatenarTextoATextView(mainTexto, boton.text.toString())//concatena los numeros al textView
            concatenarTextoATextView(secondTexto, boton.text.toString())
        }
    }

    /**
     * Refleja en los dos TextView la operacion pulsada, modifica el atributo operacion de la clase calc por la operacion pulsada
     * y si es necesario realiza la operacion
     * @param boton el boton pulsado con la operacion
     */
    private fun listenerOperaciones(boton: Button):Boolean{
        if (!esOperacion(getTextViewText(mainTexto))) {
            if (calc.esperandoA == "num1") {// si es la primera vez que se pulsa un boton de operacion
                if (mainTexto.text == ""){
                    mensajeError("Introduce un numero antes de introducir el operando")
                    return false
                }
                if (mainTexto.text.contains(".")){
                    if(mainTexto.text.last()=='.')concatenarTextoATextView(mainTexto, "0")
                    calc.num1Decimal = true
                }
                calc.num1 = getTextViewText(mainTexto).toFloat()
                mainTexto.text = boton.text
                calc.esperandoA = "num2"
            } else if (calc.esperandoA == "num2") { //si ya se ha pulsado antes algun boton de operacion
                calc.num2 = getTextViewText(mainTexto).toFloat()
                calc.operar()
                calc.num1 = calc.resultado
                if (calc.tieneDecimal(calc.num1)) calc.num1Decimal = true
                calc.num2 = 0f
                mainTexto.text = boton.text
            }
        }
        else{// si el ultimo boton pulsado es una operacion, si pulsas otra operacion se sustituye por la nueva pulsada
            mainTexto.text = boton.text
        }
        calc.operacion = getButtonText(boton)
        secondTexto.text = calc.concatenarNum1YOperacion()
        return true
    }

    /**
     * Realiza la operacion correspondiente dentro de la clase Calculo y la refleja por pantalla
     *
     */
    private fun listenerIgual(){
        if (esOperacion(getTextViewText(mainTexto))||getTextViewText(mainTexto)==""||calc.operacion=="")
            mensajeError("Introduce el operando y dos numeros antes de pulsar igual")
        else{
            calc.num2 = getTextViewText(mainTexto).toFloat()
            calc.operar()
            secondTexto.text = calc.concatenarTodo()
            mainTexto.text = calc.resultadotoString()
            calc.reset()
        }
    }

    /**
     * reinicio de todas las variables de la clase Calculo y de los TextView
     */
    private fun listenerBotonCE(){
        calc.reset() //reinicio todos los atributos del objeto calc
        mainTexto.text = ""
        secondTexto.text = "" //borro lo que haya en la pantalla
    }

    /**
     * añade un punto que permite usar numeros decimales
     */
    private fun listenerPunto(){
        if(mainTexto.text == ""){
            concatenarTextoATextView(mainTexto, "0")
            concatenarTextoATextView(secondTexto, "0")
        }

        if (!mainTexto.text.contains(".")) {
            concatenarTextoATextView(mainTexto, ".")
            concatenarTextoATextView(secondTexto, ".")
        }
        if (calc.esperandoA == "num1") calc.num1Decimal = true
        else calc.num2Decimal = true

    }

    /**
     * Borra un digito de los textView y del los numeros almacenados en la clase calc
     */
    private fun listenerBorrar(){
        if (secondTexto.text == ""|| mainTexto.text == "")
            mensajeError("No hay mas que borrar")
        else if(secondTexto.text.contains("="))
            mensajeError("No puedes borrar una operacion ya realizada")
        else {

            mainTexto.text = mainTexto.text.subSequence(0, mainTexto.text.lastIndex)
            if (secondTexto.text.length != 1) {
                if (esOperacion(secondTexto.text[secondTexto.text.lastIndex - 1].toString())) {
                    concatenarTextoATextView(mainTexto, calc.operacion)
                    calc.resetNum2()
                }
                if (esOperacion(secondTexto.text.last().toString())) {
                    concatenarTextoATextView(mainTexto, calc.num1toString())
                    calc.esperandoA = "num1"
                }
            }
            secondTexto.text = secondTexto.text.subSequence(0, secondTexto.text.lastIndex)
        }

    }

    /**
     * Detecta si el string es una operacion o no
     */
    private fun esOperacion(string: String):Boolean{
        for (operacion in operaciones) {
            if (string == operacion.text){
                return true
            }
        }
        return false
    }

    /**
     * devuelve el texto de un boton
     */
    private fun getButtonText(boton: Button):String{
        return boton.text.toString()
    }

    /**
     * devuelve el texto de un TextView
     */
    private fun getTextViewText(texto:TextView):String{
        return texto.text.toString()
    }

    /**
     * concatena un string al texto de un TextView
     */
    @SuppressLint("SetTextI18n")
    private fun concatenarTextoATextView(texto: TextView, string: String){
        texto.text = "${texto.text}${string}"
    }

    /**
     * muestra mensaje de error (toast)
     */
    private fun mensajeError(msg:String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
    private fun listenerVolver(){

    }
}