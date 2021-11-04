package com.example.jogoderpg

class Arena(guerreiro1: Guerreiros,guerreiro2: Guerreiros) {
    val listaBatalhaGuerreiro1 = mutableListOf<String>()
    val listaBatalhaGuerreiro2 = mutableListOf<String>()
    var danosG1: Int = 0
    var danosG2: Int = 0
    var turno  : Int = 0
    private var ataqueG1: Int= 0
    private var ataqueG2: Int= 0
    private var defesaG1: Int= 0
    private var defesaG2: Int= 0

    fun proximoTurno(guerreiro1: Guerreiros,guerreiro2: Guerreiros){
        ataqueG1 = guerreiro1.atacar()
    }
    fun obterTextoExibicao() {
    }
}