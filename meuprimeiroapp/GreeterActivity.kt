package com.example.meuprimeiroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.meuprimeiroapp.databinding.ActivityGreeterBinding

class GreeterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGreeterBinding
    private val listaNomes = mutableListOf<String>()
    private var indiceAtual = 0
    private lateinit var greeterAtual: GreeterTipo1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGreeterBinding.inflate(layoutInflater)

        val greeter1 = GreeterTipo1("Oi")
        val greeter2 = GreeterTipo1("Olá")
        greeterAtual = greeter1
        listaNomes.add("Willian")
        listaNomes.add("Keully")
        listaNomes.add("Tessa")
        listaNomes.add("Tasso")
        binding.brImprimir.setOnClickListener {
            val nomeAtual = listaNomes[indiceAtual]
            binding.txtSaida.text = greeterAtual.greet(nomeAtual)

            if (indiceAtual == listaNomes.size - 1) {
                indiceAtual = 0
            } else {
                indiceAtual++
            }
        }
        binding.brTrocar.setOnClickListener{
            if(greeterAtual == greeter1){
                greeterAtual = greeter2
                binding.textNumGreete.text = "2"
            }else{
                greeterAtual = greeter1
                binding.textNumGreete.text = "1"
            }
        }

        setContentView(binding.root)
    }
}