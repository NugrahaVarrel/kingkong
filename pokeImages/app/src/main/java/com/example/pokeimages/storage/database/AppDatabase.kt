package com.example.pokeimages.storage.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pokeimages.storage.dao.PokemonDao
import com.example.pokeimages.storage.entity.PokemonFavorite

@Database(entities = [PokemonFavorite::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pokemonDao() : PokemonDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun get(ctx: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    ctx.applicationContext,
                    AppDatabase::class.java,
                    "pokemon-db"
                )
                    .allowMainThreadQueries()
                    .build().also { INSTANCE = it }
            }
    }
}