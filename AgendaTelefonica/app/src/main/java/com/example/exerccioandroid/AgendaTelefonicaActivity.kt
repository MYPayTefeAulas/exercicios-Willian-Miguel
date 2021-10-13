package com.example.exerccioandroid

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.example.exerccioandroid.databinding.ActivityAgendaTelefonica2Binding
import com.example.exerccioandroid.databinding.ActivityAgendaTelefonicaBinding

class AgendaTelefonicaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAgendaTelefonica2Binding
    private var nome = ""
    private var fone = ""

    private val listaNomes = mutableListOf<Nomes>()
    private var indiceAtual = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAgendaTelefonica2Binding.inflate(layoutInflater)

        binding.btProximo.setOnClickListener {
            binding.txtSaida.text = imprimiNomes()
        }
        binding.btSalvar.setOnClickListener{
            nome = binding.txtNome.text.toString()
            binding.txtNome.text.clear()
            fone = binding.txtFone.text.toString().toInt().toString()
            binding.txtFone.text.clear()

            val nome = Nomes(nome, fone)
            listaNomes.add(nome)

        }

        setContentView(binding.root)
    }
    fun imprimiNomes(): String{
        if(indiceAtual >= listaNomes.size)
            indiceAtual = 0
        val nomeAtual = listaNomes[indiceAtual]
        indiceAtual++
        return "Nome: ${nomeAtual.nome}, Fone: ${nomeAtual.fone}"
    }
}