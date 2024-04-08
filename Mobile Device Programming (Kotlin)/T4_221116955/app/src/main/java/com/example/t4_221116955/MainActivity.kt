package com.example.t4_221116955

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.t4_221116955.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var rv: RecyclerView
    private lateinit var orderAdapter: OrderAdapter
    private lateinit var manageBtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        //Info bantuan game programming kawan..
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        rv = binding.recycleView
        setRecyclerSetting()

        manageBtn = binding.manageBtn
        manageBtn.setOnClickListener {
            val targetIntent = Intent(this@MainActivity, MenuActivity::class.java)
            startActivity(targetIntent)
        }

    }

    private fun setRecyclerSetting(){
        orderAdapter = OrderAdapter(this, R.layout.order_item_layout, OrderRepository.listOrder )
        rv.adapter = orderAdapter
        Log.d("adapter list amount", orderAdapter.itemCount.toString())
        rv.layoutManager = LinearLayoutManager(this)
    }

}