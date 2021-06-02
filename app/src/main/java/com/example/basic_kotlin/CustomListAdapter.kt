package com.example.basic_kotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.basic_kotlin.databinding.CustomListBinding

class Data1(val profile: Int, val name: String)

class CustomAdapter (private val context: Context, private val dataList: ArrayList<Data1>): BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding = CustomListBinding.inflate(LayoutInflater.from(context), parent, false)
        val profile = binding.ivCustom
        val name = binding.tvCustom
        val data = dataList[position]

        profile.setImageResource(data.profile)
        name.text = data.name

        return binding.root
    }

    override fun getItem(position: Int) = dataList[position]

    override fun getItemId(position: Int) = 0L

    override fun getCount() = dataList.size
}