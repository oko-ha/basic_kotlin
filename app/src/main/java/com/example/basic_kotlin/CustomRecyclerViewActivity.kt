package com.example.basic_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basic_kotlin.databinding.ActivityCustomRecyclerViewBinding

class CustomRecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCustomRecyclerViewBinding
    private val dataList: ArrayList<Data> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addData()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = CustomRecyclerAdapter(dataList, this)
    }

    private fun addData() {
        for (i in 0..99)
            dataList.add(Data(R.drawable.image, "${i}번"))
    }

    fun recyclerClick(data: Data){
        Toast.makeText(this, data.name, Toast.LENGTH_SHORT).show()
    }
}