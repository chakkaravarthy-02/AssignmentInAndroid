package com.example.assignment7.show_details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment7.database.ColorItem
import com.example.assignment7.databinding.ListColorsBinding

class ColorAdapter(
    private val colors: List<ColorItem>,
) : RecyclerView.Adapter<ColorAdapter.ColorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListColorsBinding.inflate(layoutInflater, parent, false)
        return ColorViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        val color = colors[position]
        holder.bind(color)
    }

    override fun getItemCount(): Int {
        return colors.size
    }

    class ColorViewHolder(private val binding: ListColorsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(color: ColorItem) {
            binding.colorIdTextView.text = color.id.toString()
            binding.colorNameTextView.text = color.name

            binding.executePendingBindings() // Ensures immediate binding
        }
    }
}
