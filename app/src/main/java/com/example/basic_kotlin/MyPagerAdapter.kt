package com.example.basic_kotlin

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyPagerAdapter(fa : FragmentActivity) : FragmentStateAdapter(fa) {
    private val NUM_PAGES = 3

    override fun getItemCount() = NUM_PAGES

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> { MyFragment.newInstance("Home", "")}
            1 -> { MyFragment.newInstance("Favorite", "")}
            else -> { MyFragment.newInstance("Profile", "")}
        }
    }
}