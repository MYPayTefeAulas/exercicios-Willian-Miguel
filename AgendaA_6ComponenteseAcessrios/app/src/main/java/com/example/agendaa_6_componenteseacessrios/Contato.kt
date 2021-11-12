package com.example.agendaa_6_componenteseacessrios

<<<<<<< HEAD
data class Contato(var nome: String, var telefone: String, var email: String, var favorito: Boolean = false) {
    val id = getProximoId()

    override fun toString(): String {
        return super.toString()
    }

    companion object {
        var lastId = -1

        fun getProximoId(): Int {
            return lastId++
        }
    }
}
=======
data class Contatos()
>>>>>>> main
