package com.fmunmar310.trabajogrupal



/**
 * Opera y almacena los numeros
 * @property num1 almacena el primer numero Int
 * @property num2 almacena el segundo numero Int
 * @property operacion almacena el simbolo de la operacion String
 * @property resultado almacena el resultado de la operacion entre el num1 y num2
 * @property esperandoA nos dice a que numero estamos esperando
 *
 */
class CalculoCarlos {
    var num1 = 0f
    var num2 = 0f
    var operacion = ""
    var resultado = 0f
    var esperandoA = "num1"
    var num1Decimal = false
    var num2Decimal = false

    /**
     * Suma num1 y num2
     * @return num1 mas num2
     */
    private fun sumar(): Float {
        return num1 + num2
    }
    /**
     * Multiplica num1 y num2
     * @return num1 por num2
     */
    private fun multiplicar(): Float {
        return num1 * num2
    }
    /**
     * Division num1 y num2
     * @return num1 entre num2
     */
    private fun dividir(): Float {
        return num1 / num2
    }
    /**
     * Resta num1 y num2
     * @return num1 menos num2
     */
    private fun restar(): Float {
        return num1 - num2
    }

    /**
     * segun la operacion pulsada realiza una operacion u otra
     */
    fun operar(){
        when(operacion){
            "÷" -> resultado = dividir()
            "+" -> resultado = sumar()
            "-" -> resultado = restar()
            "×" -> resultado = multiplicar()
        }
    }

    /**
     * resetea todas las variables
     */
    fun reset(){
        num1 = 0f
        num2 = 0f
        operacion = ""
        resultado = 0f
        esperandoA = "num1"
        num1Decimal = false
        num2Decimal = false
    }

    /**
     * convierte el num1 de tipo float a tipo String
     * corrige si es .0, si no tiene decimales no muestra decimales
     * @return num1 en formato String
     */
    fun num1toString():String{
        if (!num1Decimal||esPuntoCero(num1)){
            return numSinDecimal(num1)
        }
        return num1.toString()
    }
    /**
     * convierte el num2 de tipo float a tipo String
     * corrige si es .0, si no tiene decimales no muestra decimales
     * @return num2 en formato String
     */
    private fun num2toString():String{
        if (!num2Decimal){
            return numSinDecimal(num2)
        }
        return num2.toString()
    }
    /**
     * convierte el resultado de tipo float a tipo String
     * corrige si es .0, si no tiene decimales no muestra decimales
     * @return resultado en formato String
     */
    fun resultadotoString():String{
        if (esPuntoCero(resultado)){
            return numSinDecimal(resultado)
        }
        return resultado.toString()
    }

    /**
     * detecta si termina en .0 el float
     * @return true si termina en .0 false si no
     */
    private fun esPuntoCero(num:Float):Boolean{
        return (num.toString()[num.toString().lastIndex] == '0' && num.toString()[num.toString().lastIndex-1] == '.')
    }

    /**
     * Si contiene punto es decimal
     * @return si tiene un punto devuelve true, sino, false
     */
    fun tieneDecimal(num:Float):Boolean{
        return (num.toString().contains("."))
    }
    /**
     * recorta los decimales del numero que le pases
     * @param num el numero en tipo float
     * @return num en tipo String sin decimales
     */
    private fun numSinDecimal(num: Float):String{
        return num.toString().substring(0, num.toString().length-2)
    }

    /**
     * @return toda la cadena de una operacion, num1, la operacion, num2, igual y resultado
     */
    fun concatenarTodo():String{
        return "${this.num1toString()}${operacion}${this.num2toString()}=${this.resultadotoString()}"
    }

    /**
     * concatena num1 y la operacion
     * @return cadena con num1 y la operacion
     */
    fun concatenarNum1YOperacion():String{
        return "${this.num1toString()}$operacion"
    }

    /**
     * resetea todas las variables relacionadas con num2
     */
    fun resetNum2(){
        num2 = 0f
        num2Decimal = false
    }

}