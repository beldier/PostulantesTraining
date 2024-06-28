package com.rybeler.exampleviewmodel.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.rybeler.exampleviewmodel.R
import com.rybeler.exampleviewmodel.data.network.ApiClient
import com.rybeler.exampleviewmodel.databinding.ActivitySecondBinding
import com.rybeler.exampleviewmodel.databinding.FragmentSecondBinding
import com.rybeler.exampleviewmodel.ui.adapters.CharactersAdapter
import kotlinx.coroutines.launch

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        setContentView(binding.root)
//        setSupportActionBar(binding.myToolbar2)
//        val tituloIntent = intent.getStringExtra("palabra")
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        binding.textoTitulo.text = tituloIntent
//        binding.backButton.setOnClickListener {
//            finish()
//        }

        lifecycleScope.launch {
            val listCharacters = ApiClient.charactersService.getCharacters(0, 100).data.results
            binding.recycler.adapter = CharactersAdapter(listCharacters)

        }
    }

}