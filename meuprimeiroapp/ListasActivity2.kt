package com.example.meuprimeiroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.meuprimeiroapp.databinding.ActivityListas2Binding
import com.example.meuprimeiroapp.databinding.ActivityMainBinding

class ListasActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityListas2Binding

    private var nome =""
    private var idade = 0
    private val listaPessoas = mutableListOf<Pessoa>()
    private val indiceAtual = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListas2Binding.inflate(layoutInflater)
        binding.btImprir.setOnClickListener {
            binding.txtSaida.text = imprimirPessoa()
        }
        binding.btSalvar.setOnClickListener {
            nome = binding.txtNome.toString()
            idade = binding.txtIdade.toString().toInt()
            binding.txtIdade.text.clear()
            val pessoa = Pessoa(nome, idade)
            listaPessoas.add(pessoa)
        }

        setContentView(R.layout.activity_listas2)
    }



    fun imprimirPessoa(): String{
        val pessoaAtual = listaPessoas[indiceAtual]
        //indiceAtual++
        return "Nome ${pessoaAtual.nome}, Idade ${pessoaAtual.idade}"
    }
}

class Pessoa(val nome: String, val idade: Int)
