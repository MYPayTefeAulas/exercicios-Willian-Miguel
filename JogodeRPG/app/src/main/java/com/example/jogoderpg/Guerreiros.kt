package com.example.jogoderpg
import java.util.*

class Guerreiros( val nome: String, val forcaAtaque: Int, val vidaMaxima: Int) {
    var vidaAtual:  Int = vidaMaxima
    var forcaAtual: Int = forcaAtaque
    fun obterBarraVida(): Int {
        return (1..10).random()
    }
}