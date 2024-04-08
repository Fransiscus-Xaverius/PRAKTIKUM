package com.example.t4_221116955

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.t4_221116955.databinding.ActivityMainBinding
import com.example.t4_221116955.databinding.ActivityMenuBinding
import com.example.t4_221116955.databinding.MenuItemLayoutBinding

class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding
    private lateinit var rv: RecyclerView
    private lateinit var menuAdapter: MenuAdapter
    private lateinit var addBtn: Button
    private lateinit var backBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        rv = binding.menuRV
        setRecyclerSetting()

        addBtn = binding.addMenuBtn
        addBtn.setOnClickListener {
            val targetIntent = Intent(this@MenuActivity, AddMenuActivity::class.java)
            startActivity(targetIntent)
        }

        backBtn = binding.backMenuBtn
        backBtn.setOnClickListener {
            val targetIntent = Intent(this@MenuActivity, MainActivity::class.java)
            startActivity(targetIntent)
        }

    }

    private fun setRecyclerSetting(){
        menuAdapter = MenuAdapter(this, R.layout.menu_item_layout, MenuRepository.listOrder )
        rv.adapter = menuAdapter
        Log.d("adapter list amount", menuAdapter.itemCount.toString())
        rv.layoutManager = LinearLayoutManager(this)
    }
}