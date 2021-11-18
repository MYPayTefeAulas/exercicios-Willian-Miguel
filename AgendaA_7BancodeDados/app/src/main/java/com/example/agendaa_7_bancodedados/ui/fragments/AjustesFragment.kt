package com.example.agendaa_7_bancodedados.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.agendaa_7_bancodedados.databinding.FragmentAjustesBinding
import com.example.agendaa_7_bancodedados.enums.TipoOrdenacao
import com.example.agendaa_7_bancodedados.model.Contato
import com.example.agendaa_7_bancodedados.repository.room.AppDatabase
import com.example.agendaa_7_bancodedados.utils.PrefsConstants
import org.jetbrains.anko.doAsync

class AjustesFragment : Fragment() {
    private var _binding: FragmentAjustesBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAjustesBinding.inflate(inflater, container, false)
        val view = binding.root

        val config = requireActivity().getSharedPreferences(PrefsConstants.FILE_CONFIGURACOES, 0)

        // descobre configuração atual de ordenação e marca RadioButton apropriado
        val ordenacaoSelecionada_str = config.getString(
            PrefsConstants.KEY_TIPO_ORDENACAO_CONTATOS,
            TipoOrdenacao.ORDEM_INSERCAO.toString()
        )
        val ordenacaoSelecionada: TipoOrdenacao = TipoOrdenacao.valueOf(ordenacaoSelecionada_str!!)
        when (ordenacaoSelecionada) {
            TipoOrdenacao.ALFABETICA_AZ -> binding.radioOrdenacaoAZ.isChecked = true
            TipoOrdenacao.ALFABETICA_ZA -> binding.radioOrdenacaoZA.isChecked = true
            TipoOrdenacao.ORDEM_INSERCAO -> binding.radioOrdenacaoInsercao.isChecked = true
        }

        binding.radioGroupOrdenacao.setOnCheckedChangeListener { _, checkedId ->
            var novoTipoOrdenacao = when (checkedId) {
                binding.radioOrdenacaoAZ.id -> TipoOrdenacao.ALFABETICA_AZ
                binding.radioOrdenacaoZA.id -> TipoOrdenacao.ALFABETICA_ZA
                binding.radioOrdenacaoInsercao.id -> TipoOrdenacao.ORDEM_INSERCAO
                else -> TipoOrdenacao.ORDEM_INSERCAO
                // Impossível o else ocorrer no nosso caso, pois colocamos todos os RadioButtons
            }

            val editor = config.edit()
            editor.putString(
                PrefsConstants.KEY_TIPO_ORDENACAO_CONTATOS,
                novoTipoOrdenacao.toString()
            )
            editor.apply()
        }

        binding.btAdicionarPadrao.setOnClickListener {
            doAsync {
                val db = AppDatabase.getDatabase(requireContext())
                LISTA_CONTATOS_PADRAO.forEach {
                    db.contatoDao().insert(it)
                }
            }
        }

        return view
    }

    companion object {
        val LISTA_CONTATOS_PADRAO = listOf(

            Contato(nome = "Willian", telefone = "12345", email = "wramos@uea.edu.br"),
            Contato(nome = "Raiane", telefone = "12345", email = "raiane@uea.edu.br"),

        )

    }
}