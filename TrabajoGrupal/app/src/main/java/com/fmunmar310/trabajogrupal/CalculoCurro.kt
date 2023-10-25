package com.fmunmar310.trabajogrupal

/**
 * Este es la clase cálculo que vamos a usar en la calculadora
 */
class CalculoCurro (){ // constructor principal que permite crear la clase sin valores
    var num1: Double
    var num2:Double
    var op:String
    init{
        this.num1 = 0.0
        this.num2 = 0.0
        this.op = ""
    }

    var numUno = true // Este atributo nos permite diferencias si ya hay un primer número añadido
    constructor(num1:Double,num2:Double,op:String):this(){ // constructor por parámetros
        this.num1 = num1
        this.num2 = num2
        this.op = op
    }
    /**
     * Función que utilizaremos para realizar el cálculo
     * @return devuleve los distintos resultados según la operación
     */
    fun operacion():Double {
        var resultado = 0.0
        if (this.numUno){
            resultado = this.num1 // Si aun no se ha introducido el segundo número la función devuleve el primer número
        }else
            when (this.op) {
                "+" -> {
                    resultado = (num1 + num2)
                }
                "-" -> {
                    resultado = (num1 - num2)
                }
                "*" -> {
                    resultado = (num1 * num2)
                }
                "/" -> {
                    resultado = (num1 / num2)
                }
                else -> resultado = this.num1
            }
        this.numUno = false // tras realizar una primera operación o añadir un número cambiamos el valor a false
        return resultado
    }

    /**
     * Función para resetear los valores a cero
     */
    fun resetear(){
        this.num1 = 0.0
        this.num2 = 0.0
        this.op = ""
        this.numUno = true
    }
}