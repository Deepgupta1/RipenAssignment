package com.example.ripenapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ripenapps.databinding.SimilarPropertiesCardBinding
import com.example.ripenapps.models.SimilarProperties

class SimilarPropertiesAdapter : ListAdapter<SimilarProperties, SimilarPropertiesAdapter.SimilarViewHolder>(DiffUtil()) {
    inner class SimilarViewHolder(private val binding: SimilarPropertiesCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(similarProperty: SimilarProperties) {
            // Update this part to bind data from SimilarProperties
            // For example: Glide.with(binding.root.context).load(similarProperty.img).into(binding.imageView2)
            // binding.name.text = similarProperty.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimilarViewHolder {
        val binding = SimilarPropertiesCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SimilarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SimilarViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class DiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<SimilarProperties>() {
        override fun areItemsTheSame(oldItem: SimilarProperties, newItem: SimilarProperties): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: SimilarProperties, newItem: SimilarProperties): Boolean {
            return oldItem == newItem
        }
    }
}
