package com.example.basic_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import com.example.basic_kotlin.databinding.ActivityCustomListViewBinding

class CustomListViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCustomListViewBinding
    private var dataList = arrayListOf( // 리스트 뷰에 넣을 DATA 생성
        Data(R.drawable.image, "0번 아이유"),
        Data(R.drawable.image_1, "1번 아이유"),
        Data(R.drawable.image_2, "2번 아이유"),
        Data(R.drawable.image_3, "3번 아이유")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomListViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 리스트 뷰 어댑터 연결
        binding.listView.adapter = CustomAdapter(this, dataList)

        // 리스트 아이템 클릭 시 이름을 토스트 메시지로 전달
        binding.listView.onItemClickListener = AdapterView.OnItemClickListener{ parent, _, position, _ ->
            val selectedItem = parent.getItemAtPosition(position) as Data
            Toast.makeText(this, selectedItem.name, Toast.LENGTH_SHORT).show()
        }
    }
}