package com.example.pokeimages

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class PokemonDetailActivity : AppCompatActivity() {

    private var pokeId = -1
    private var pokeName: String? = ""
    private var pokeSprites: String?= ""
    private var pokeArtwork: String?= ""
    private var pokeWeight = 0

    private lateinit var ivSprite: ImageView
    private lateinit var ivArtwork: ImageView
    private lateinit var tvPokemonName: TextView
    private lateinit var tvInfo: TextView
    private lateinit var btnViewArtwork: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pokemon_detail)

        pokeId = intent.getIntExtra("ID", -1)
        pokeName = intent.getStringExtra("NAME")
        pokeSprites = intent.getStringExtra("SPRITES")
        pokeArtwork = intent.getStringExtra("ARTWORK")
        pokeWeight = intent.getIntExtra("WEIGHT", -1)

        ivSprite = findViewById(R.id.ivSprite)
        ivArtwork = findViewById(R.id.ivArtwork)
        tvPokemonName = findViewById(R.id.tvPokemonName)
        tvInfo = findViewById(R.id.tvInfo)

        tvPokemonName.text = pokeName ?: "Unknown Pokémon"
        tvInfo.text = "Height: --  |  Weight: $pokeWeight"

        Glide.with(this)
            .load(pokeSprites)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(ivSprite)

        Glide.with(this)
            .load(pokeArtwork)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(ivArtwork)
    }
}