package com.example.jododos3dados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jododos3dados.databinding.ActivitySortearDadosBinding

class SorterDadsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySortearDadosBinding
    private val listaDados = mutableListOf<Dados>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySortearDadosBinding.inflate(layoutInflater)
        listaDados.add(Dados(4))
        listaDados.add(Dados(6))
        listaDados.add(Dados(8))

        binding.btTrocarD1.setOnClickListener {
            listaDados[0].lados = mudarDados(listaDados[0].lados)
            binding.txtSaidaD1.text = "${listaDados[0].lados} lados"

        }
        binding.btTrocarD2.setOnClickListener {
            listaDados[1].lados = mudarDados(listaDados[1].lados)
            binding.txtSaidaD2.text = "${listaDados[1].lados} lados"
        }
        binding.btTrocarD3.setOnClickListener {
            listaDados[2].lados = mudarDados(listaDados[2].lados)
            binding.txtSaidaD3.text = "${listaDados[2].lados} lados"
        }

        binding.btLancar.setOnClickListener {
            binding.txtSaidaD1.text = listaDados[0].lancar().toString()
            binding.txtSaidaD2.text = listaDados[1].lancar().toString()
            binding.txtSaidaD3.text = listaDados[2].lancar().toString()
        }
        setContentView(binding.root)
    }

    fun mudarDados(lado:Int):Int {
        if (lado >= 4 && lado <= 8){
            return (lado + 2)
        }
        return 4
    }
}