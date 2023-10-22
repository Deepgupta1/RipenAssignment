package com.example.ripenapps.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ripenapps.databinding.RecyclerCardBinding
import com.example.ripenapps.databinding.ReviewsCardBinding
import com.example.ripenapps.models.Items
import com.example.ripenapps.models.Reviews
import com.example.ripenapps.ui.fragments.BookActivity

class ReviewAdapter : ListAdapter<Reviews, ReviewAdapter.ReviewViewHolder>(DiffUtil()) {
    inner class ReviewViewHolder(private val binding: ReviewsCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(reviews: Reviews) {


            Glide.with(binding.root.context).load(reviews.img).into(binding.imageView2)
            binding.name.text=reviews.name



        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val binding = ReviewsCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReviewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class DiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<Reviews>() {
        override fun areItemsTheSame(oldItem: Reviews, newItem: Reviews): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Reviews, newItem: Reviews): Boolean {
            return oldItem == newItem
        }

    }
}