package com.example.ripenapps.ui.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ripenapps.R
import com.example.ripenapps.adapter.PropertyAdapter
import com.example.ripenapps.adapter.ReviewAdapter
import com.example.ripenapps.adapter.SimilarPropertiesAdapter
import com.example.ripenapps.databinding.ActivityBookBinding
import com.example.ripenapps.databinding.ActivityMainBinding
import com.example.ripenapps.models.Reviews
import com.example.ripenapps.models.SimilarProperties

class BookActivity : AppCompatActivity() {
    private var _binding: ActivityBookBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityBookBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.reviewsRecycler.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.similarRecycler.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val adapter = ReviewAdapter()
        val element1 = Reviews(1, "Abc", R.drawable.profile_pic, "Manisha Rajput")
        val element2 = Reviews(2, "DEF", R.drawable.profile_pic, "Avinash Bishnoi")

        adapter.submitList(listOf(element1, element2))
        binding.reviewsRecycler.setHasFixedSize(true)
        binding.reviewsRecycler.adapter = adapter


        val adapter2 = SimilarPropertiesAdapter()
        val el1 = SimilarProperties(1, R.drawable.house, "HOUSE")
        val el2 = SimilarProperties(2, R.drawable.flat, "CONDO")
        val el3 = SimilarProperties(3, R.drawable.house, "HOUSE")


        binding.back.setOnClickListener{
            onBackPressed()
        }

        adapter2.submitList(listOf(el1, el2, el3))
        binding.similarRecycler.setHasFixedSize(true)
        binding.similarRecycler.adapter = adapter2
    }
}