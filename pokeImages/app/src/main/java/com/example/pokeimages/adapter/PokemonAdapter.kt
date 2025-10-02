package com.example.pokeimages.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokeimages.R
import com.example.pokeimages.data_class.PokemonDetail

class PokemonAdapter(
    private val items: MutableList<PokemonDetail>,
    private val onItemClick: (PokemonDetail) -> Unit
) : RecyclerView.Adapter<PokemonAdapter.VH>() {

    class VH(v: View) : RecyclerView.ViewHolder(v) {
        val tvName: TextView = v.findViewById(R.id.tvPokemonName)
        val ivSprite: ImageView = v.findViewById(R.id.ivPokemonSprite)
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