package com.example.meuprimeiroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.meuprimeiroapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.btTrocar.setOnClickListener {
            //trocaTextoInput()
            //binding.txtHello.text = trocaTexto2()
            //binding.txtHello.text = calculaDobro()
            binding.txtHello.text = calcular()
        }

        val view =
            setContentView(binding.root)
    }

    //fun calculaDobro(): String {
    //val textoEntrada1 = binding.txtInput.text.toString()
    //val textoEntrada2 = binding.txtInput2.text.toString()
    //val numero1 = textoEntrada1.toInt()
    //val numero2 = textoEntrada2.toInt()
    //val dobro = numero1 * numero2
    //return dobro.toString()
    //}

    //fun trocaTexto() {
    //binding.txtHello.text = "MyPosto\nEsse App é para Postos de Combustíveis!"
    //}

    //fun trocaTexto2(): String {
    //return "MyPosto\nEsse App é para Postos de Combustíveis!"
    //}

    fun calcular(): String {
        val operacao = binding.txtOperacao.text.toString()
        val textoEntrada1 = binding.txtInput1.text.toString()
        val textoEntrada2 = binding.txtInput2.text.toString()
        val numero1 = textoEntrada1.toInt()
        val numero2 = textoEntrada2.toInt()
        var resultadoStr = ""
        when (operacao){
            "+" -> resultadoStr = (numero1 + numero2).toString()
            "-" -> resultadoStr = (numero1 - numero2).toString()
            "*" -> resultadoStr = (numero1 * numero2).toString()
            "/" -> resultadoStr = (numero1 / numero2).toString()
        }
        return resultadoStr.toString()
    }


    }

