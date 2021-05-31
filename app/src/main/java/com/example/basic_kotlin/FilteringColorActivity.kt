package com.example.basic_kotlin

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SeekBar
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.basic_kotlin.databinding.ActivityFilteringColorBinding

class FilteringColorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFilteringColorBinding
    private var red = 0
    private var green = 0
    private var blue = 0
    private val modes = mapOf(0 to null, 1 to PorterDuff.Mode.ADD, 2 to PorterDuff.Mode.CLEAR, 3 to PorterDuff.Mode.DARKEN, 4 to PorterDuff.Mode.DST,
        5 to PorterDuff.Mode.DST_ATOP, 6 to PorterDuff.Mode.DST_IN, 7 to PorterDuff.Mode.DST_OUT, 8 to PorterDuff.Mode.DST_OVER, 9 to PorterDuff.Mode.LIGHTEN,
        10 to PorterDuff.Mode.MULTIPLY, 11 to PorterDuff.Mode.OVERLAY, 12 to PorterDuff.Mode.SCREEN, 13 to PorterDuff.Mode.SRC, 14 to PorterDuff.Mode.SRC_ATOP,
        15 to PorterDuff.Mode.SRC_IN, 16 to PorterDuff.Mode.SRC_OUT, 17 to PorterDuff.Mode.SRC_OVER, 18 to PorterDuff.Mode.XOR)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilteringColorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Spinner
        var m: PorterDuff.Mode? = null
        val sData = resources.getStringArray(R.array.filter)
        binding.spinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sData)
        binding.spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                m = modes[p2]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

        // Red Seek Bar
        binding.sbRed.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                binding.tvRed.text = "$p1"
                red = p1
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                binding.tvRed.text = "${p0!!.progress}"
                red = p0.progress
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                binding.tvRed.text = "${p0!!.progress}"
                red = p0.progress
            }
        })

        // Green Seek Bar
        binding.sbGreen.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                binding.tvGreen.text = "$p1"
                green = p1
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                binding.tvGreen.text = "${p0!!.progress}"
                green = p0.progress
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                binding.tvGreen.text = "${p0!!.progress}"
                green = p0.progress
            }
        })

        // Blue Seek Bar
        binding.sbBlue.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                binding.tvBlue.text = "$p1"
                blue = p1
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                binding.tvBlue.text = "${p0!!.progress}"
                blue = p0.progress
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                binding.tvBlue.text = "${p0!!.progress}"
                blue = p0.progress
            }
        })

        // Apply Button
        binding.btnApply.setOnClickListener {
            if (m == null) {
                binding.image.colorFilter = m
                Toast.makeText(this, "Select Filter", Toast.LENGTH_SHORT).show()
            }
            else {
                val colorString = String.format("#%02X%02X%02X", red, green, blue)
                binding.image.setColorFilter(Color.parseColor(colorString), m)
            }
        }
    }

    fun loadImage(v: View){
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
        startForResult.launch(intent)
    }

    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result: ActivityResult ->
        if (result.data != null) binding.image.setImageURI(result.data?.data)
    }
}