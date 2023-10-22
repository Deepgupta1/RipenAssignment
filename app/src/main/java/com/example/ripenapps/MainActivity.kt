package com.example.ripenapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.ripenapps.adapter.AdapterViewPager
import com.example.ripenapps.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val adapterViewPager=AdapterViewPager(this)
        binding.viewPager2.adapter = adapterViewPager

        binding.viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        binding.bottomNav.selectedItemId = R.id.m_booking

                    }

                    1 -> {
                        binding.bottomNav.selectedItemId = R.id.m_chat
                    }

                    2 -> {
                        binding.bottomNav.selectedItemId = R.id.m_explore
                    }
                    3->{
                        binding.bottomNav.selectedItemId=R.id.m_notification
                    }
                    4->{
                        binding.bottomNav.selectedItemId=R.id.m_profile
                    }
                }
            }
        })





    }

    override fun onDestroy() {
        super.onDestroy()
        _binding == null;
    }
}