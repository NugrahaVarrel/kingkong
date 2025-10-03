package com.example.pokeimages.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.pokeimages.R
import com.example.pokeimages.vm.PokemonDetailViewModel

class PokemonDetailFragment : Fragment() {
    private val detailViewModel: PokemonDetailViewModel by activityViewModels()

    private lateinit var tvName: TextView
    private lateinit var tvInfo: TextView
    private lateinit var ivSprite: ImageView

    private lateinit var artwork: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_pokemon_detail, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvName = view.findViewById(R.id.tvPokemonName)
        tvInfo = view.findViewById(R.id.tvInfo)
        ivSprite = view.findViewById(R.id.ivSprite)
        artwork = view.findViewById(R.id.ivArtwork)

        detailViewModel.selectedPokemon.observe(viewLifecycleOwner) { pokemon ->
            if (pokemon != null) {
                tvName.text = pokemon.name.capitalize()
                tvInfo.text = "Height: --  |  Weight: ${pokemon.weight}"
                Glide.with(this)
                    .load(pokemon.sprites.front_default)
                    .into(ivSprite)

                Glide.with(this)
                    .load(pokemon.sprites.front_default)
                    .into(artwork)
            }
        }
    }
}