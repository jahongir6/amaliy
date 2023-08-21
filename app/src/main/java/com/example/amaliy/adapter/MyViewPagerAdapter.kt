package com.example.amaliy.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.amaliy.ui.ItemViewPaagerFragment

class MyViewPagerAdapter(fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager) {
    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        return if (position == 0)
            ItemViewPaagerFragment.newInstance(true)
        else
            ItemViewPaagerFragment.newInstance(false)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return if (position==0) "asosiy"
        else " zarirada"

    }
}