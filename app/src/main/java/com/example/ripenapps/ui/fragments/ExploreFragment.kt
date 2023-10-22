package com.example.ripenapps.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ripenapps.R
import com.example.ripenapps.adapter.PropertyAdapter

import com.example.ripenapps.databinding.FragmentExploreBinding
import com.example.ripenapps.models.Items


class ExploreFragment : Fragment() {

    private var _binding:FragmentExploreBinding?=null
    private val binding get()=_binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        _binding= FragmentExploreBinding.inflate(inflater,container,false)
       return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycler.layoutManager = LinearLayoutManager(requireContext())
        val adapter = PropertyAdapter(requireContext())
        val element1 = Items(
            1,
            R.drawable.house,
            2499,
            3.5,
            "2 Beds|2 Baths",
            "Semi Furnished",
            "3 Court Square, Long Island City, NY 11101",
            "Skyline Tower",
            "Daniel Harris",
            "123456789"
        )
        val element2 = Items(
            2,
            R.drawable.flat,
            2499,
            3.5,
            "2 Beds|2 Baths",
            "Semi Furnished",
            "3 Court Square, Long Island City, NY 11101",
            "Skyline Tower",
            "Ronald Walker",
            "987654321"
        )

        adapter.submitList(listOf(element1, element2))
        binding.recycler.setHasFixedSize(true)
        binding.recycler.adapter = adapter



    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

}