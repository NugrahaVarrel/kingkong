package com.example.pokeimages.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokeimages.R
import com.example.pokeimages.data_class.PokemonDetail
import com.example.pokeimages.storage.dao.PokemonDao
import com.example.pokeimages.storage.entity.PokemonFavorite
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PokemonAdapter(
    private val items: MutableList<PokemonDetail>,
    private val dao : PokemonDao,
    private val onItemClick: (PokemonDetail) -> Unit
) : RecyclerView.Adapter<PokemonAdapter.VH>() {

    class VH(v: View) : RecyclerView.ViewHolder(v) {
        val tvName: TextView = v.findViewById(R.id.tvPokemonName)
        val ivSprite: ImageView = v.findViewById(R.id.ivPokemonSprite)

        val btnFavorite : ImageButton = v.findViewById(R.id.btnFavorite)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pokemon, parent, false)
        return VH(v)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = items[position]
        holder.tvName.text = item.name.capitalize()
        Glide.with(holder.itemView)
            .load(item.sprites.front_default)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.ivSprite)

        holder.btnFavorite.setImageResource(R.drawable.ic_favorite_border)

        CoroutineScope(Dispatchers.IO).launch {
            val isFav = dao.isFavorite(item.id)
            withContext(Dispatchers.Main) {
                holder.btnFavorite.setImageResource(
                    if (isFav) R.drawable.ic_favorite_filled else R.drawable.ic_favorite_border
                )
            }
        }

        holder.btnFavorite.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val isFav = dao.isFavorite(item.id)
                if (isFav) {
                    dao.removeFavorite(
                        PokemonFavorite(
                            item.id,
                            item.name,
                            item.sprites.front_default
                        )
                    )
                } else {
                    dao.insertFavorite(PokemonFavorite(item.id, item.name, item.sprites.front_default))
                }
                // Update UI
                withContext(Dispatchers.Main) {
                    holder.btnFavorite.setImageResource(
                        if (!isFav) R.drawable.ic_favorite_filled else R.drawable.ic_favorite_border
                    )
                }
            }
        }


        holder.itemView.setOnClickListener {
            onItemClick(item)
        }
    }

    override fun getItemCount() = items.size

    fun setData(newItems: List<PokemonDetail>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}
