package com.fmunmar310.trabajogrupal

class Persona {
    var sexo = ""
    var altura = 0
    var peso = 0
    var edad = 0
    var resultadoIMC = 0f

    fun incrementarPeso(){
        peso++
    }
    fun decrementarPeso(){
        peso--
    }
    fun incrementarEdad(){
        edad++
    }
    fun decrementarEdad(){
        edad--
    }
    fun alturaEnCm():String{
        return "${altura.toString()} CM"
    }
    fun todosLosDatos():Boolean{
        return (sexo=="" || altura == 0 || peso==0 || edad == 0)
    }
}