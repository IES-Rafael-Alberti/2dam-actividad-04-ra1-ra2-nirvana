package com.fmunmar310.calculadora

class Calculo (var num1: Double, var num2:Double, var op:String){

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