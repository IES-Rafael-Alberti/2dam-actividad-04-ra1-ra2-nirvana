package com.fmunmar310.calculadora

class Calculo (){
    var num1:Double = 0.0
    var num2:Double = 0.0
    var op:String =""

    fun operacion(calculo:Calculo):Double{
        if(calculo.op == "+") {
            return (num1 + num2).toDouble()
        }else if(calculo.op == "-") {
            return (num1 - num2).toDouble()
        }else if(calculo.op =="*") {
            return (num1 * num2).toDouble()
        }else if(calculo.op == "/") {
            return (num1 / num2).toDouble()
        }
        return 0.0
    }
}