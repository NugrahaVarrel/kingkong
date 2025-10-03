package com.example.pokeimages.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokeimages.data_class.PokemonDetail
import com.example.pokeimages.network.PokeApiClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed class PokeUiState {
    object Idle : PokeUiState()
    object Loading : PokeUiState()
    data class Success(val data: List<PokemonDetail>) : PokeUiState()
    data class Error(val message: String) : PokeUiState()
}
class PokemonViewModel : ViewModel() {
    private val _state = MutableStateFlow<PokeUiState>(PokeUiState.Idle)
    val state: StateFlow<PokeUiState> = _state

    fun load(limit: Int = 20) {
        _state.value = PokeUiState.Loading
        viewModelScope.launch {
            try {
                val list = PokeApiClient.api.getPokemonList(limit)
                val details = list.results.map { PokeApiClient.api.getPokemonDetail(it.name) }
                _state.value = PokeUiState.Success(details)
            } catch (e: Exception) {
                _state.value = PokeUiState.Error(e.message ?: "Unknown error")
            }
        }
    }
}