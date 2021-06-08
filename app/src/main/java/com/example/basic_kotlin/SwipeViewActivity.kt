package com.example.basic_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.basic_kotlin.databinding.ActivitySwipeViewBinding
import com.google.android.material.tabs.TabLayoutMediator

class SwipeViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySwipeViewBinding
    private val tabTitle = listOf("Home", "Favorite", "Profile")
    private val tabIcon = listOf(
        R.drawable.ic_baseline_home_24,
        R.drawable.ic_baseline_favorite_24,
        R.drawable.ic_baseline_person_24
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySwipeViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPager.apply {
            adapter = MyPagerAdapter(context as FragmentActivity)
            setPageTransformer(ZoomOutPageTransformer())
        }

        TabLayoutMediator(binding.tabs, binding.viewPager) { tabs, position ->
            tabs.text = tabTitle[position]
            tabs.setIcon(tabIcon[position])
        }.attach()
    }
}