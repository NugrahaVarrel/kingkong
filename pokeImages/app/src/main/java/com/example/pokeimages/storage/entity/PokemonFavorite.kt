package com.example.pokeimages.storage.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("pokemon_favorite")
data class PokemonFavorite(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val spriteUrl: String
)
