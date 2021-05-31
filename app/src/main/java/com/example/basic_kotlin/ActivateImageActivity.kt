package com.example.basic_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.basic_kotlin.databinding.ActivityActivateImageBinding

class ActivateImageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityActivateImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activate_image)
        binding = ActivityActivateImageBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onClick(v: View) {
        binding.image1.visibility = View.INVISIBLE
        binding.image2.visibility = View.INVISIBLE
        binding.image3.visibility = View.INVISIBLE

        when (v) {
            binding.btn1 -> binding.image1.visibility = View.VISIBLE
            binding.btn2 -> binding.image2.visibility = View.VISIBLE
            binding.btn3 -> binding.image3.visibility = View.VISIBLE
        }
    }
}