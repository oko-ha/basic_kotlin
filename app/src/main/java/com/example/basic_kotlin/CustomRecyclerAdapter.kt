package com.example.basic_kotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.basic_kotlin.databinding.CustomListBinding

class CustomViewHolder(private val binding: CustomListBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: Data) {
        binding.ivCustom.setImageResource(data.profile)
        binding.tvCustom.text = data.name
    }
}

class CustomRecyclerAdapter(private val dataList: ArrayList<Data>, val context: Context) : RecyclerView.Adapter<CustomViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val binding = CustomListBinding.inflate(LayoutInflater.from(context), parent, false)
        return CustomViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bind(dataList[position])
        // onClickListener 처리를 Adapter 에서 해주는게 편함
        holder.itemView.setOnClickListener {
            (context as CustomRecyclerViewActivity).recyclerClick(dataList[position])
        }
    }
}