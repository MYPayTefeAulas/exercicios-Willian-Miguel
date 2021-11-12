package com.example.agendaa_7_bancodedados.viewmodel
import com.example.agendaa_7_bancodedados.model.Contato
import com.example.agendaa_7_bancodedados.repository.room.AppDatabase
import com.example.agendaa_7_bancodedados.repository.room.ContatoRepository

class ListaContatosViewModel(appDatabase: AppDatabase) {
    private val contatoRepository = ContatoRepository(appDatabase)

    fun getAllContatos(): List<Contato> {
        return contatoRepository.getAllContatos()
    }
}