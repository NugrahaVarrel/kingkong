package com.example.pokeimages.storage.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pokeimages.storage.entity.PokemonFavorite

@Dao
interface PokemonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(favorite: PokemonFavorite)

    @Delete
    suspend fun removeFavorite(favorite: PokemonFavorite)

    @Query("SELECT * FROM pokemon_favorite")
    suspend fun getAllFavorites(): List<PokemonFavorite>

    @Query("SELECT EXISTS(SELECT 1 FROM pokemon_favorite WHERE id = :id)")
    suspend fun isFavorite(id: Int): Boolean
}