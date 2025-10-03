package com.example.pokeimages.network

import com.example.pokeimages.data_class.AbilitiesResponse
import com.example.pokeimages.data_class.ActiveAPI
import com.example.pokeimages.data_class.PokemonDetail
import com.example.pokeimages.data_class.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApiService {
    @GET("pokemon")
    suspend fun getPokemonList(@Query("limit") limit: Int = 20): PokemonResponse

    @GET("pokemon/{name}")
    suspend fun getPokemonDetail(@Path("name") name: String): PokemonDetail

    @GET("pokemon")
    suspend fun getStatusAPI(@Query("limit") limit: Int = 1): ActiveAPI

}