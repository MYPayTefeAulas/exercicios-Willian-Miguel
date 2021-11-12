package com.example.agendaa_7_bancodedados.repository.room

import com.example.agendaa_7_bancodedados.model.Contato
import com.example.agendaa_7_bancodedados.repository.ContatoDataSource

class ContatoRepository(database: AppDatabase) : ContatoDataSource {
    private val contatoDao = database.contatoDao()

    override fun contatoById(id: Long): Contato {
        return contatoDao.contatoById(id)
    }

    override fun save(obj: Contato) {
        if(obj.id == 0L) {
            val id = insert(obj)
            obj.id = id
        } else {
            update(obj)
        }
    }

    override fun insert(obj: Contato): Long {
        return contatoDao.insert(obj)
    }

    override fun update(obj: Contato) {
        return contatoDao.update(obj)
    }

    override fun delete(obj: Contato) {
        return contatoDao.delete(obj)
    }

    override fun getAllContatos(): List<Contato> {
        return contatoDao.getAllContatos()
    }
}