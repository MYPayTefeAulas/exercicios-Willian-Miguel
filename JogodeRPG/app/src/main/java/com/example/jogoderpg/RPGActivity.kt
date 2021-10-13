package com.example.jogoderpg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jogoderpg.databinding.ActivityRpgactivityBinding

class RPGActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRpgactivityBinding
    private var nome1 = ""
    private var nome2 = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRpgactivityBinding.inflate(layoutInflater)
        binding.btSalvar.setOnClickListener{

            nome1 = binding.txtG1.text.toString()
            nome2 = binding.txtG2.text.toString()
        }
        binding.btIniciar.setOnClickListener{

        }
        binding.btProximo.setOnClickListener {

        }
    setContentView(binding.root)
    }
}