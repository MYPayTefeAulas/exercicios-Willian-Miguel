package com.example.listadefrutaselegumes

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listadefrutaselegumes.databinding.ActivityListaFrutasLegumesBinding

class ListaFrutasLegumesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListaFrutasLegumesBinding
    private val listaFrutas = listOf("uva", "pera", "laranja", "maca")
    private val listaLegumes = listOf("feijão", "arroz", "cebola")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListaFrutasLegumesBinding.inflate(layoutInflater)

        binding.btBuscar.setOnClickListener {
            binding.txtSaida.text = verificar(binding.txtEntrada.text.toString())
        }

        setContentView(binding.root)
    }
    fun verificar(entrada:String): String {

        var saida = ""
        var alimentoEncontrado = false
        for (fruta in listaFrutas){
            if (fruta == entrada) {
                saida = "É uma Fruta"
                alimentoEncontrado = true
                break
            }
        }
        for (legume in listaLegumes){
            if (legume == entrada) {
                saida = "É uma Legume"
                alimentoEncontrado = true
                break
            }
        }
        if (!alimentoEncontrado){
            saida = "Alimento não Identificado"
        }
        return saida
    }
}