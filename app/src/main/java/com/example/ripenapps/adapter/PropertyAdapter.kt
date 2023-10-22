package com.example.ripenapps.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ripenapps.databinding.RecyclerCardBinding
import com.example.ripenapps.models.Items
import com.example.ripenapps.ui.fragments.BookActivity

class PropertyAdapter(val context: Context) : ListAdapter<Items, PropertyAdapter.PropertyViewHolder>(DiffUtil()) {
   inner class PropertyViewHolder(private val binding: RecyclerCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(items: Items) {


            Glide.with(binding.root.context).load(items.img).into(binding.imageView)
            binding.descriptionTxt.text=items.desrciption
            binding.priceTxt.text="$ ${items.price.toString()}"
            binding.ratingTxt.text=items.rating.toString()
            binding.typeTxt.text=items.type
            binding.cardLay.setOnClickListener{

                context.startActivity(Intent(context,BookActivity::class.java).putExtra("img",items.img))

            }
           // binding.house.background=


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PropertyViewHolder {
        val binding =RecyclerCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PropertyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PropertyViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class DiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<Items>() {
        override fun areItemsTheSame(oldItem: Items, newItem: Items): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Items, newItem: Items): Boolean {
            return oldItem == newItem
        }

    }
}