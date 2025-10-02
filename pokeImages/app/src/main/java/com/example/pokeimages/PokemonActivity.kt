package com.example.pokeimages

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeimages.adapter.PokemonAdapter
import com.example.pokeimages.network.PokeApiClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PokemonActivity : AppCompatActivity() {

    private lateinit var progress: ProgressBar

    private lateinit var adapter : PokemonAdapter

    private lateinit var rvPokemon : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_list)

        progress = findViewById(R.id.progressBarPokemonList)
        rvPokemon = findViewById(R.id.rvPokemon)

        adapter = PokemonAdapter(mutableListOf(),
            onItemClick = {
                clicked ->
                val intent = Intent(this, PokemonDetailActivity::class.java).apply {
                    putExtra("ID", clicked.id)
                    putExtra("NAME", clicked.name)
                    putExtra("SPRITES", clicked.sprites.front_default)
                    putExtra("ARTWORK", clicked.sprites.front_default)
                    putExtra("WEIGHT", clicked.weight)
                }
                startActivity(intent)
            }
        )
        rvPokemon.layoutManager = LinearLayoutManager(this)
        rvPokemon.adapter = adapter

        loadPokemon()

    }

    private fun loadPokemon() {
        progress.visibility = View.VISIBLE
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val list = PokeApiClient.api.getPokemonList(20)
                val details = list.results.map { item ->
                    PokeApiClient.api.getPokemonDetail(item.name)
                }
                withContext(Dispatchers.Main) {
                    adapter.setData(details)
                    progress.visibility = View.GONE
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    progress.visibility = View.GONE
                    Toast.makeText(this@PokemonActivity, "Error: ${e.message}", Toast.LENGTH_LONG)
                        .show()
                }
            }
        }
    }
}
