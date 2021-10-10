package com.example.jododos3dados

import java.util.*

class Dados(var lados:Int) {
    val numaleatorio = Random()
    fun lancar():Int{
        return (1..lados).random()
    }
}