package com.example.assignment9.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment9.databinding.GridItemViewBinding
import com.example.assignment9.network.FlagItem

class FlagGridAdapter(
    private var flag: List<FlagItem>
) : RecyclerView.Adapter<FlagGridAdapter.FlagPropertyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlagPropertyViewHolder {
        return FlagPropertyViewHolder(GridItemViewBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return flag.size
    }

    override fun onBindViewHolder(holder: FlagPropertyViewHolder, position: Int) {
        val flagProperty = flag[position]
        holder.bind(flagProperty)
    }

    class FlagPropertyViewHolder(private var binding: GridItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(flagProperty: FlagItem) {
            binding.property = flagProperty
            binding.executePendingBindings()
        }
    }
}