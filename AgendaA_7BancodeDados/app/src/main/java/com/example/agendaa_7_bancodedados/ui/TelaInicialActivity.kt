package com.example.agendaa_7_bancodedados.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.agendaa_7_bancodedados.R
import com.example.agendaa_7_bancodedados.databinding.ActivityTelaInicialBinding
import com.example.agendaa_7_bancodedados.ui.fragments.AjustesFragment
import com.example.agendaa_7_bancodedados.ui.fragments.ListaContatosFragment

class TelaInicialActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTelaInicialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTelaInicialBinding.inflate(layoutInflater)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, ListaContatosFragment())
            .commit()

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.ic_home -> {
                    loadFragments(ListaContatosFragment(), FRAGMENT_HOME)
                    true
                }
                R.id.ic_ajustes -> {
                    loadFragments(AjustesFragment(), FRAGMENT_AJUSTES)
                    true
                }
                else ->
                    false
            }
        }

        setContentView(binding.root)
    }

    //Carrega os fragments e os empilha
    private fun loadFragments(fragment: Fragment, tag: String){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, fragment, tag)
            commit()
        }
    }

    companion object {
        private const val FRAGMENT_HOME = "FRAGMENT_HOME"
        private const val FRAGMENT_AJUSTES = "FRAGMENT_AJUSTES"
    }
}