package com.example.atividadesprogramaoemandroid

class Pessoas(val nome: String, val fone: String){
    companion object{
        var totalPessoas = 0
            private set
    }
    init {
        totalPessoas++
    }
    fun veificarNomeAgenda(): Boolean{
        return nome == ""
    }
    fun verificarFoneAgenda(): Boolean{
        return fone == ""
    }
}