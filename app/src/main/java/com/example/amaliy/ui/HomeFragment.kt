package com.example.amaliy.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.amaliy.R
import com.example.amaliy.adapter.MyViewPagerAdapter
import com.example.amaliy.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var myViewPagerAdapter: MyViewPagerAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        myViewPagerAdapter = MyViewPagerAdapter(parentFragmentManager)
        binding.myViewPager.adapter = myViewPagerAdapter
        binding.myTabLayout.setupWithViewPager(binding.myViewPager)


        return binding.root
    }
}