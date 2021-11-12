package com.example.agendaa_7_bancodedados.repository

import com.example.agendaa_7_bancodedados.model.Contato

interface ContatoDataSource {
    fun save(obj: Contato)
    fun insert(obj: Contato): Long
    fun update(obj: Contato)
    fun delete(obj: Contato)
    fun contatoById(id: Long): Contato
    fun getAllContatos(): List<Contato>
}