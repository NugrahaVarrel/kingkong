package com.example.pokeimages.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokeimages.data_class.PokemonDetail

class PokemonDetailViewModel : ViewModel() {
    private val _selectedPokemon = MutableLiveData<PokemonDetail>()
    val selectedPokemon: LiveData<PokemonDetail> get() = _selectedPokemon

    private val _pokemonList = MutableLiveData<List<PokemonDetail>>()
    val pokemonList: LiveData<List<PokemonDetail>> get() = _pokemonList

    fun setSelectedPokemon(pokemon: PokemonDetail) {
        _selectedPokemon.value = pokemon
    }

    fun setPokemonList(list: List<PokemonDetail>) {
        _pokemonList.value = list
    }
}