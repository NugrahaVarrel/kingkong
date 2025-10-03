package com.example.pokeimages.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeimages.R
import com.example.pokeimages.adapter.PokemonAdapter
import com.example.pokeimages.storage.dao.PokemonDao
import com.example.pokeimages.storage.database.AppDatabase
import com.example.pokeimages.vm.PokeUiState
import com.example.pokeimages.vm.PokemonDetailViewModel
import com.example.pokeimages.vm.PokemonViewModel
import kotlinx.coroutines.launch
import kotlin.getValue

class PokemonFragment : Fragment() {

    private val vm: PokemonViewModel by viewModels()
    private val detailVm: PokemonDetailViewModel by activityViewModels()
    private lateinit var dao: PokemonDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            vm.load()
        }

        dao = AppDatabase.get(requireContext()).pokemonDao()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_poke, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val rv = view.findViewById<RecyclerView>(R.id.rvPokeFrag)
        val progress = view.findViewById<ProgressBar>(R.id.progressFrag)
        val tvErr = view.findViewById<TextView>(R.id.tvErrorFrag)

        val adapter = PokemonAdapter(mutableListOf(), dao=dao) { pokemon ->
            detailVm.setSelectedPokemon(pokemon)

            parentFragmentManager.beginTransaction()
                .replace(R.id.pokemonContainer, PokemonDetailFragment())
                .addToBackStack(null)
                .commit()
        }
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                vm.state.collect { state ->
                    when (state) {
                        is PokeUiState.Idle -> {
                            progress.visibility = View.GONE
                            tvErr.visibility = View.GONE
                        }
                        is PokeUiState.Loading -> {
                            progress.visibility = View.VISIBLE
                            tvErr.visibility = View.GONE
                        }
                        is PokeUiState.Success -> {
                            progress.visibility = View.GONE
                            tvErr.visibility = View.GONE
                            adapter.setData(state.data)
                        }
                        is PokeUiState.Error -> {
                            progress.visibility = View.GONE
                            tvErr.visibility = View.VISIBLE
                            tvErr.text = state.message
                        }
                    }
                }
            }
        }
    }
}