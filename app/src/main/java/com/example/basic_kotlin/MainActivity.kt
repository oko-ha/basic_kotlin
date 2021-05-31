package com.example.basic_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.basic_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener(ButtonListener())
        binding.btn2.setOnClickListener(ButtonListener())
        binding.btn3.setOnClickListener(ButtonListener())
    }

    inner class ButtonListener: View.OnClickListener {
        override fun onClick(v: View?) {
            when (v?.id) {
                R.id.btn1 -> myStartActivity(FilteringColorActivity::class.java)
                R.id.btn2 -> myStartActivity(ActivateImageActivity::class.java)
                R.id.btn3 -> myStartActivity(ScrollViewActivity::class.java)
            }
        }
    }

    fun myStartActivity(c: Class<*>) {
        val intent = Intent(this, c)
        startActivity(intent)
    }
}