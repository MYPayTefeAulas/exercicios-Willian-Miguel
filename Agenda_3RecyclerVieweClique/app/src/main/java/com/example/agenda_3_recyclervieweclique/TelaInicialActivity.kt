package com.example.agenda_3_recyclervieweclique

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.agenda_3_recyclervieweclique.databinding.ActivityTelaInicialBinding

class TelaInicialActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTelaInicialBinding
    private lateinit var adapter: ContatosAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTelaInicialBinding.inflate(layoutInflater)

        incializaLista()
        adapter = ContatosAdapter(mutableListOf(), ::onBtEditarClick)

        binding.rvContatos.layoutManager = LinearLayoutManager(this)
        binding.rvContatos.adapter = adapter
        binding.rvContatos.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

        adapter.swapData(Agenda.listaContatos)

        setContentView(binding.root)
    }
    private fun incializaLista() {
        Agenda.listaContatos.addAll(
            listOf(
                Contatos("1 Rodrigo", "1111","rodrigo@uea.edu.br"),
                Contatos("2 Willian", "2222","willian@uea.edu.br"),
                Contatos("3 Maria", "3333","maria@uea.edu.br"),
            )
        )
    }

    fun onBtEditarClick(indiceLista: Int) {
        val intent = Intent(this, EditarContatoActivity::class.java)
        intent.putExtra("indiceContato", indiceLista)
        startActivity(intent)
    }
    override fun onResume() {
        super.onResume()
        adapter.swapData(Agenda.listaContatos)
    }
}