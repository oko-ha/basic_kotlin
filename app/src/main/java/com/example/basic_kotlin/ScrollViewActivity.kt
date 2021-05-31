package com.example.basic_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.basic_kotlin.databinding.ActivityScrollViewBinding

class ScrollViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScrollViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScrollViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}