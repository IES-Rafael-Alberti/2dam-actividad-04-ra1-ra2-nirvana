package com.fmunmar310.calculadora

/**
 * Este es la clase cálculo que vamos a usar en la calculadora
 */
class Calculo (var num1: Double, var num2:Double, var op:String){
    /**
     * Función que utilizaremos para realizar el cálculo
     * @return devuleve los distintos resultados según la operación
     */
    fun operacion(op:String):Double{
        if(op == "+") {
            return (num1 + num2).toDouble()
        }else if(op == "-") {
            return (num1 - num2).toDouble()
        }else if(op =="*") {
            return (num1 * num2).toDouble()
        }else if(op == "/") {
            return (num1 / num2).toDouble()
        }
        return 0.0
    }
}