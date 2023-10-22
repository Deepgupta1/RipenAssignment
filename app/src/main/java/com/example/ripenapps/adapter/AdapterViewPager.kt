package com.example.ripenapps.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ripenapps.ui.fragments.ExploreFragment

class AdapterViewPager(fragmentActivity:FragmentActivity) : FragmentStateAdapter(fragmentActivity) {



    override fun getItemCount(): Int {
        return 5    }

    override fun createFragment(position: Int): Fragment {
        return ExploreFragment()
    }





}