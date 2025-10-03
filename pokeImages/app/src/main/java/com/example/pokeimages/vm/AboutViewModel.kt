package com.example.pokeimages.vm

import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokeimages.network.PokeApiClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

sealed class StatusState {
    object Idle : StatusState()
    object Loading : StatusState()
    data class Success(val message: String) : StatusState()
    data class Error(val message: String) : StatusState()
}
class AboutViewModel : ViewModel() {
    private val _status = MutableLiveData<StatusState>(StatusState.Idle)
    val status: LiveData<StatusState> get() = _status

    fun loadStatus() {
        _status.value = StatusState.Loading

        viewModelScope.launch {
            try {
                val response = PokeApiClient.api.getStatusAPI(1)
                val isAvailable = response.results.isNotEmpty()

                if (isAvailable) {
                    _status.value = StatusState.Success("✅ Connection OK — ${response.results.size} results found")
                } else {
                    _status.value = StatusState.Error("❌ No results returned from API")
                }
            } catch (e: Exception) {
                _status.value = StatusState.Error("❌ Error: ${e.message}")
            }
        }
    }
}