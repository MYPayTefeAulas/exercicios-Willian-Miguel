package com.example.atividadesprogramaoemandroid

class Agenda() {
    private val listaContatos = mutableListOf<Pessoas>()
    private var indiceAtual = 0

    fun testarContato(contato: Pessoas): String{
        var encontrou: String = "false"
        for (lista in listaContatos){
            if ((lista.nome == contato.nome) && (lista.fone == contato.fone)){
                encontrou = contato.nome
                break
            }
        }
        return encontrou
    }
    fun salvarContato (novoContato: Pessoas) {
        listaContatos.add(novoContato)
    }
    fun imprimirNomeContato(): String{
        if(indiceAtual == listaContatos.size)
            indiceAtual = 0
        val contatoAtual = listaContatos[indiceAtual]
        indiceAtual++
        return "${contatoAtual.nome}"
    }
    fun imprimirTelefoneContato(): String{
        indiceAtual -= 1
        if(indiceAtual == listaContatos.size)
            indiceAtual = 0
        val contatoAtual = listaContatos[indiceAtual]
        indiceAtual++
        return "${contatoAtual.fone}"
    }
    fun deletarContato(){
        if(indiceAtual>= 1){
            indiceAtual -= 1
            val contatoAtual = listaContatos[indiceAtual]
            listaContatos.remove(contatoAtual)
        } else {
            val contatoAtual = listaContatos[indiceAtual]
            listaContatos.remove(contatoAtual)
        }
    }
    fun retornaNumeroContatos(): Int{
        return listaContatos.size
    }
}