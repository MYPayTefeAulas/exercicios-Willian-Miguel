package com.example.agendaa_7_bancodedados.viewmodel

import com.example.agendaa_7_bancodedados.model.Contato
import com.example.agendaa_7_bancodedados.repository.room.AppDatabase
import com.example.agendaa_7_bancodedados.repository.room.ContatoRepository

class EditarContatoViewModel(database: AppDatabase) {
    private val contatoRepository = ContatoRepository(database)

    fun getContatoById(id: Long): Contato {
        return contatoRepository.contatoById(id)
    }

    fun saveContato(contato: Contato){
        contatoRepository.save(contato)
    }

    fun deleteContato(contato: Contato) {
        contatoRepository.delete(contato)
    }
}