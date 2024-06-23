package com.rybeler.exampleviewmodel.ui.screens

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.rybeler.exampleviewmodel.MainViewModel
import com.rybeler.exampleviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels() // delegates

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.counterText.text = viewModel.contador.value.toString()
        setContentView(binding.root) // inflate, inflacion como se inflan las vistas en los activities?

        binding.increaseButton.setOnClickListener {
            viewModel.updateContador(1)
        }

        viewModel.contador.observe(this) {
            updateText()
        }

        binding.navegarButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            val bundle = Bundle()
            bundle.putString("palabra","Hello world")

            intent.putExtras(bundle)
            startActivity(intent)
        }

    }

    fun updateText() {
        binding.counterText.text = viewModel.contador.value.toString()
    }

}
