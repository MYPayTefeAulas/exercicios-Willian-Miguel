package com.example.jogoderpg

class Guerreiros( val nome: String, val forcaAtaque: Int, val vidaMaxima: Int) {
    var vidaAtual:  Int = vidaMaxima
    var forcaAtual: Int = forcaAtaque
    fun obterBarraVida(): String {
        ....
        return "[$barraVida]"
    }
}