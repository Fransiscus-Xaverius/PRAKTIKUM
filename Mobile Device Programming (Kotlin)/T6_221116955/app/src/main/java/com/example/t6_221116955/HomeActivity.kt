package com.example.t6_221116955

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.t6_221116955.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var homeDisplayNameTv: TextView
    private lateinit var homeUsernameTv: TextView
    private lateinit var friendsRv:RecyclerView
    private lateinit var userViewModel: UserViewModel
    private lateinit var ChatViewModel: chatViewModel

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        homeDisplayNameTv = binding.homeDisplayNameTV
        homeUsernameTv = binding.homeUsernameTV
        friendsRv = binding.friendsRV

        // Initialize UserViewModel
        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]

        // Initialize ChatViewModel
        ChatViewModel = ViewModelProvider(this)[chatViewModel::class.java]

        // Get current user data from ViewModel
        val currentUser = userViewModel.getUserData(dataObj.curUser!!)

        // Set the TextViews with the user data
        homeDisplayNameTv.text = currentUser?.displayName
        homeUsernameTv.text = currentUser?.userName

        // Set the adapter for the RecyclerView
//        friendsRv.adapter = FriendAdapter((currentUser?.friends ?: emptyList()).toMutableList())
        friendsRv.adapter = FriendAdapter((currentUser?.friends ?: emptyList()).toMutableList(), this, ChatViewModel)
        friendsRv.layoutManager = LinearLayoutManager(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.homeMenuBtn -> {
                // Handle menu item 1 click
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.addFriendMenuBtn -> {
                // Handle menu item 2 click
                val intent = Intent(this, AddFriendActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.logoutBtn-> {
                // Handle menu item 3 click
                userViewModel.logout()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
