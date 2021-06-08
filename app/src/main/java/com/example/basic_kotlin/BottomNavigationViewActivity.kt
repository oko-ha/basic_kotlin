package com.example.basic_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.basic_kotlin.databinding.ActivityBottomNavigationViewBinding

class BottomNavigationViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBottomNavigationViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomNavigationViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}