package com.example.t4_221116955

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.t4_221116955.databinding.ActivityAddMenuBinding
import com.example.t4_221116955.databinding.ActivityEditMenuBinding

class EditMenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditMenuBinding

    private lateinit var menuNameText: TextView
    private lateinit var menuPriceText: TextView

    private lateinit var doneBtn: Button
    private lateinit var backBtn: Button

    private var position:Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_menu)

        position = intent.getIntExtra("position", 0)

        binding = ActivityEditMenuBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        menuNameText = binding.editTextText
        menuPriceText = binding.editTextText2

        doneBtn = binding.button2
        backBtn = binding.button

        menuNameText.text = MenuRepository.listOrder[position].nama
        menuPriceText.text = MenuRepository.listOrder[position].price.toString()

        doneBtn.setOnClickListener {
            MenuRepository.listOrder[position].nama = menuNameText.text.toString()
            MenuRepository.listOrder[position].price = menuPriceText.text.toString().toInt()
            val targetIntent = Intent(this@EditMenuActivity, MenuActivity::class.java)
            startActivity(targetIntent)
        }

        backBtn.setOnClickListener {
            onBackPressed()
        }

    }
}