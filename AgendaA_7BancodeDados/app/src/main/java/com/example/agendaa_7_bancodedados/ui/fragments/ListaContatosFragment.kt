package com.example.agendaa_7_bancodedados.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.agendaa_7_bancodedados.R
import com.example.agendaa_7_bancodedados.adapters.ContatosAdapter
import com.example.agendaa_7_bancodedados.databinding.FragmentListaContatosBinding
import com.example.agendaa_7_bancodedados.enums.TipoOrdenacao
import com.example.agendaa_7_bancodedados.model.Contato
import com.example.agendaa_7_bancodedados.repository.room.AppDatabase
import com.example.agendaa_7_bancodedados.ui.EditarContatoActivity
import com.example.agendaa_7_bancodedados.utils.IntentsConstants
import com.example.agendaa_7_bancodedados.utils.PrefsConstants
import com.example.agendaa_7_bancodedados.viewmodel.ListaContatosViewModel
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class ListaContatosFragment : Fragment(), SearchView.OnQueryTextListener {
    private var _binding: FragmentListaContatosBinding? = null

    private val binding get() = _binding!!

    private lateinit var adapter: ContatosAdapter

    private lateinit var viewModel: ListaContatosViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListaContatosBinding.inflate(inflater, container, false)

        adapter = ContatosAdapter(mutableListOf(), ::onBtEditarClick)

        binding.rvContatos.layoutManager = LinearLayoutManager(context)
        binding.rvContatos.adapter = adapter
        binding.rvContatos.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayoutManager.VERTICAL
            )
        )

        doAsync {
            viewModel = ListaContatosViewModel(AppDatabase.getDatabase(requireContext()))
            val contatoList = viewModel.getAllContatos()

            uiThread {
                carregaLista(contatoList)
            }
        }

        initTopBar()

        return binding.root
    }

    private fun carregaLista(contatoList: List<Contato>) {
        val config = requireActivity().getSharedPreferences(PrefsConstants.FILE_CONFIGURACOES, 0)
        val ordenacaoSelecionada_str = config.getString(
            PrefsConstants.KEY_TIPO_ORDENACAO_CONTATOS,
            TipoOrdenacao.ORDEM_INSERCAO.toString()
        )
        val ordenacaoSelecionada: TipoOrdenacao = TipoOrdenacao.valueOf(ordenacaoSelecionada_str!!)
        when (ordenacaoSelecionada) {
            TipoOrdenacao.ALFABETICA_AZ -> {
                val listaOrdenada = contatoList.sortedBy { it.nome }
                adapter.swapData(listaOrdenada)
            }
            TipoOrdenacao.ALFABETICA_ZA -> {
                val listaOrdenada = contatoList.sortedByDescending { it.nome }
                adapter.swapData(listaOrdenada)
            }
            TipoOrdenacao.ORDEM_INSERCAO -> {
                adapter.swapData(contatoList)
            }
        }

    }

    private fun initTopBar() {
        binding.toolbarContatos.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.search_top_bar -> {
                    val searchView = menuItem?.actionView as SearchView
                    searchView.queryHint = "Digite para pesquisar"
                    searchView.setOnQueryTextListener(this)
                    true
                }
                else -> false
            }
        }
    }

    override fun onQueryTextChange(newText: String?): Boolean =
        onQueryTextSubmit(newText) // vai buscar a cada letra digitada

    override fun onQueryTextSubmit(query: String?): Boolean {
        val queryLowerCase = query.toString().lowercase()

        doAsync {
            val contatoList = viewModel.getAllContatos()

            uiThread {
                val listaFiltrada = contatoList.filter { contatoAtual ->
                    contatoAtual.nome.lowercase().contains(queryLowerCase)
                    contatoAtual.telefone.lowercase().contains(queryLowerCase)
                    contatoAtual.email.lowercase().contains(queryLowerCase)
                }
                adapter.swapData(listaFiltrada)
            }
        }

        return true
    }
    override fun onResume() {
        super.onResume()
        doAsync {
            val contatoList = viewModel.getAllContatos()

            uiThread {
                carregaLista(contatoList)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun onBtEditarClick(indiceLista: Int) {
        val intent = Intent(context, EditarContatoActivity::class.java)
        val idContato = adapter.listaContatos[indiceLista].id
        intent.putExtra(IntentsConstants.LONG_ID_CONTATO, idContato)
        startActivity(intent)
    }

}