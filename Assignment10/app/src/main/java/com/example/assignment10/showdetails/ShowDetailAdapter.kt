package com.example.assignment10.showdetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment10.databinding.GridListBinding
import com.example.assignment10.domain.Game

class ShowDetailAdapter(
    private val game: List<Game>?
): RecyclerView.Adapter<ShowDetailAdapter.ViewHolder>() {
    class ViewHolder(private val binding: GridListBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(gameValue: Game) {
            binding.property = gameValue
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(GridListBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return game?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val gameValue = game?.get(position)
        if (gameValue != null) {
            holder.bind(gameValue)
        }
    }
}