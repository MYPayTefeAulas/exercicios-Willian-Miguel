package com.example.atividadesprogramaoemandroid

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.atividadesprogramaoemandroid.databinding.ActivityAgendaFoneBinding


class AgendaFoneActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAgendaFoneBinding
    private val agenda = Agenda()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgendaFoneBinding.inflate(layoutInflater)

        binding.btSalvar.setOnClickListener() {
            val nome = binding.txtNome.text.toString()
            val fone = binding.txtFone.text.toString()
            val pessoa = Pessoas(nome, fone)

            if (pessoa.veificarNomeAgenda() && pessoa.verificarFoneAgenda()) {
                binding.txtAviso.setTextColor(Color.rgb(216, 10, 12))
                binding.txtAviso.text = "Erro, Digitar novo Nome e Telefone"
            } else if (pessoa.veificarNomeAgenda()) {
                binding.txtAviso.setTextColor(Color.rgb(216, 12, 12))
                binding.txtAviso.text = "Erro, Digitar novo Nome"
            } else if (pessoa.verificarFoneAgenda()) {
                binding.txtAviso.setTextColor(Color.rgb(216, 12, 12))
                binding.txtAviso.text = "Erro, Digitar novo Fone"
            } else if (agenda.testarContato(pessoa) == "false") {
                agenda.salvarContato(pessoa)
                binding.txtAviso.setTextColor(Color.rgb(216, 12, 12))
                binding.txtAviso.text = "Contato Salvo"
            }
        }
        binding.btProximo.setOnClickListener() {
            binding.txtAviso.setText("")
            if (agenda.retornaNumeroContatos() == 0) {
                binding.txtAviso.setTextColor(Color.rgb(212, 12, 12))
                binding.txtAviso.text = "Nenhum contato salvo para Mostrar!"
            } else {
                binding.txtNome.setText(agenda.imprimirNomeContato())
                binding.txtFone.setText(agenda.imprimirTelefoneContato())
            }
            binding.btDeletar.setOnClickListener() {
                binding.txtFone.setText("")
                binding.txtFone.setText("")
                binding.txtAviso.setText("")
                if (agenda.retornaNumeroContatos() == 0) {
                    binding.txtAviso.setTextColor(Color.rgb(212, 12, 12))
                    binding.txtAviso.text = "Nenhum contato salvo para Mostrar!"
                } else agenda.deletarContato()
            }
            //Toast.makeText(this, "Teste", Toast.LENGTH_SHORT).show()

        }
        setContentView(binding.root)
    }

}