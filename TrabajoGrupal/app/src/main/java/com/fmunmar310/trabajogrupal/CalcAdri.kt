package com.pmdm.calculadoraadri

// Calculadora Adrián

class CalcAdri {

    var op: Int = 0
    var n1: Float = 0F
    var n2: Float = 0F
    var resultado: Float = 0F

    var nCalc: Int = 0 // Contará las veces que se han hecho calculos de forma seguida sin pulsar el botón C
    var localizadorNum: Boolean = true // Si es true, esperará el 1er numero, si es false, el segundo número
    var Temp1: String = ""
    var Temp2: String = ""


    /**
     * Realiza la llamada al método adecuado para realizar el cálculo solicitado en la calculadora.
     */
    fun calculos() {
        when (op) {
            0 -> resultado = n1 + n2
            1 -> resultado = n1 - n2
            2 -> resultado = n1 * n2
            3 -> resultado = n1 / n2
        }
        nCalc += 1
    }

    /**
     * Según el valor de num, se devolverá la el simbolo de operación correspondiente:
     *
     */
    fun opPrint(num: Int): String {
        return when (num) {
            0 -> " + "
            1 -> " - "
            2 -> " * "
            3 -> " / "
            else -> ""
        }
    }

    /**
     * Está función permitirá mostrar en pantalla el operador correspondiente en forma de String
     */
    fun opPrint(): String {
        return when (op) {
            0 -> " + "
            1 -> " - "
            2 -> " x "
            3 -> " / "
            else -> ""
        }
    }

    /**
     * Aquí almacenaremos en una cadena los números añadidos en ambos Temp (Según corresponda),
     * también tendremos un control de dígitos para evitar errores.
     *
     * @param num nos dará un dígito del 1 a 9 o decimal
     */
    fun controlDeDigitos(num : Int) {
        if (num < 10){ // Si num>10, significará que es un dígito del 1 al 9
            if (localizadorNum) Temp1 += num.toString() // Pasamos el primer lote de números a string
            else Temp2 += num.toString() // Pasamos el segundo lote de números a string
        }
        else { // Aquí entraríamos en números decimales
            if (localizadorNum) {
                //En caso de que no se ponga un número, pondremos un 0 delante, quedando asi: 0.
                if (Temp1 == "") Temp1 = "0."
                // Si ya hay un número, solo añadimos el punto a la cadena
                else Temp1 += if (Temp1.contains('.')) "" else "."
            }
            else {
                // Aquí haremos lo mismo pero con el segundo loote de números
                if (Temp2 == "") Temp2 = "0."
                else Temp2 += if (Temp2.contains('.')) "" else "."
            }

        }
    }

    /**
     * Devuelve a la calculadora a los valores iniciales.
     *
     * @param resetNCalc, devolverá a valores iniciales el @param nCalc y el
     * @param resetResultado hará lo mismo con el @param resultado
     */
    fun resetCalc(resetNCalc: Boolean = true, resetResultado: Boolean = true){
        n1 = 0f
        n2 = 0f
        op = 0
        localizadorNum = true
        Temp1 = ""
        Temp2 = ""
        if (resetResultado) resultado = 0f
        if (resetNCalc) nCalc = 0
    }
}
