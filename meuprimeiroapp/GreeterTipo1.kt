package com.example.meuprimeiroapp

class GreeterTipo1 (val cumprimento: String){
    fun greet(nome: String): String{
        val cumprimentoCompelto = "$cumprimento $nome"
        return cumprimentoCompelto
    }
}