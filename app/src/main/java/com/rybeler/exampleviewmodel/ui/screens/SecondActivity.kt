package com.rybeler.exampleviewmodel.ui.screens

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.rybeler.exampleviewmodel.data.network.ApiClient
import com.rybeler.exampleviewmodel.databinding.ActivitySecondBinding
import com.rybeler.exampleviewmodel.ui.adapters.CharactersAdapter
import kotlinx.coroutines.launch

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setSupportActionBar(binding.myToolbar2)
        val tituloIntent = intent.getStringExtra("palabra")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        binding.textoTitulo.text = tituloIntent
//        binding.backButton.setOnClickListener {
//            finish()
//        }

        lifecycleScope.launch {
            val listCharacters = ApiClient.charactersService.getCharacters(0, 100).data.results
            binding.recycler.adapter = CharactersAdapter(listCharacters)

        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            // Handle the back button action here
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}