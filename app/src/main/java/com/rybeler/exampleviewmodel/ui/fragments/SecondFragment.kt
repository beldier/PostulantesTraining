package com.rybeler.exampleviewmodel.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.navArgs
import com.rybeler.exampleviewmodel.data.network.ApiClient
import com.rybeler.exampleviewmodel.databinding.FragmentSecondBinding
import com.rybeler.exampleviewmodel.ui.adapters.CharactersAdapter
import com.rybeler.exampleviewmodel.ui.viewModel.SecondViewModel
import kotlinx.coroutines.launch

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private val args: SecondFragmentArgs by navArgs()
    private val viewModel: SecondViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.titleText.text = args.tituloText

        viewModel.caracteres.observe(viewLifecycleOwner) { updatedList ->
            binding.recycler.adapter = CharactersAdapter(updatedList)
        }

    }

}