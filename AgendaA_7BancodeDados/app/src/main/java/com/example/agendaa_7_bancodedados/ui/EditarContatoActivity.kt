package com.example.agendaa_7_bancodedados.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.agendaa_7_bancodedados.R
import com.example.agendaa_7_bancodedados.databinding.ActivityEditarContatoBinding
import com.example.agendaa_7_bancodedados.model.Contato
import com.example.agendaa_7_bancodedados.repository.room.AppDatabase
import com.example.agendaa_7_bancodedados.utils.IntentsConstants
import com.example.agendaa_7_bancodedados.viewmodel.EditarContatoViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Classe EditarContatoActivity tela que abre ao apertar em EditarContatos, é chamada
 * a partir do Fragment ListaContatos
 *
 * Possui botão de salvar, deletar e marcar contato como favorito
 *
 * @author Rodrigo Barros Bernardino
 * <a href="mailto:rberna.contato@gmail.com">rberna.contato@gmail.com</a>
 */
class EditarContatoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditarContatoBinding
    private lateinit var viewModel: EditarContatoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditarContatoBinding.inflate(layoutInflater)

        setTitle("editar_contato")

        val idContato = intent.getLongExtra(IntentsConstants.LONG_ID_CONTATO, -1)

        doAsync {
            viewModel = EditarContatoViewModel(AppDatabase.getDatabase(this@EditarContatoActivity))
            val contatoEditando = viewModel.getContatoById(idContato)
            initElementos(contatoEditando)
        }
        setContentView(binding.root)
    }

    fun initElementos(contatoEditando: Contato) {
        val nome: String = contatoEditando.nome
        val email: String = contatoEditando.email
        val telefone: String = contatoEditando.telefone
        binding.agendaTxtTelefone.setText(telefone)
        binding.agendaTxtNome.setText(nome)
        binding.agendaTxtEmail.setText(email)
        binding.switchContatoFavorito.isChecked = contatoEditando.favorito

        binding.agendaBtSalvar.setOnClickListener {
            contatoEditando.nome = binding.agendaTxtNome.text.toString()
            contatoEditando.telefone = binding.agendaTxtTelefone.text.toString()
            contatoEditando.email = binding.agendaTxtEmail.text.toString()
            doAsync {
                viewModel.saveContato(contatoEditando)
                uiThread {
                    Toast.makeText(this@EditarContatoActivity, "contato_salvo", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }

        binding.btDeletar.setOnClickListener {
            val dialog = MaterialAlertDialogBuilder(this)
                .setTitle("deletar contato")
                .setMessage("realmente deletar")
                .setNegativeButton("cancelar",null)
                .setPositiveButton("deletar") { _, _ ->
                    doAsync {
                        viewModel.deleteContato(contatoEditando)
                        uiThread {
                            Toast.makeText(this@EditarContatoActivity, "contato_removido", Toast.LENGTH_SHORT).show()
                            finish()
                        }
                    }
                }
            dialog.show()
        }
        binding.switchContatoFavorito.setOnCheckedChangeListener { _, isChecked ->
            contatoEditando.favorito = isChecked
            doAsync {
                viewModel.saveContato(contatoEditando)
            }
        }
    }
}