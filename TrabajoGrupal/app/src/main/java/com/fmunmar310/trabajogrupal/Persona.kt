package com.fmunmar310.trabajogrupal

import java.io.Serializable

class Persona : Serializable {
    var sexo = ""
    var altura = 120f
    var peso = 60
    var edad = 30
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
        return "${altura.toString().substring(0,3)} CM"
    }
    fun todosLosDatos():Boolean{
        return (sexo=="")
    }
    fun calculaImc(){
        this.altura = this.altura/100
        this.resultadoIMC= this.peso/ (this.altura*this.altura)
    }
}