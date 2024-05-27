package com.example.t6_221116955

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AddFriendActivity : AppCompatActivity() {
    private lateinit var userViewModel: UserViewModel
    private lateinit var searchFriendBtn: Button
    private lateinit var addFriendEt: EditText
    private lateinit var resultsTv: TextView
    private lateinit var searchFriendRv: RecyclerView
    private lateinit var userAdapter: UserAdapter

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_friend)

        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        searchFriendBtn = findViewById(R.id.SearchFriendBtn)
        addFriendEt = findViewById(R.id.addFriendEt)
        resultsTv = findViewById(R.id.resultsTV)
        searchFriendRv = findViewById(R.id.searchFriendRV)

        searchFriendRv.layoutManager = LinearLayoutManager(this)
        userAdapter = UserAdapter(emptyList<User>().toMutableList()) { user ->
            // Handle "Add Friend" button click here
            userViewModel.addFriend(user)
            Toast.makeText(this, "Added ${user.displayName}.", Toast.LENGTH_SHORT).show()
            userAdapter.removeUser(user) // Remove the user from the list
        }
        searchFriendRv.adapter = userAdapter

        //for some reason this shit is stupid slow.
        //might not work on your emulator, please check again on a phone
        //Android emulation, just like android programming, is dogshit.
        searchFriendBtn.setOnClickListener {
//            Toast.makeText(this, "Added ${u}.", Toast.LENGTH_SHORT).show()
            val username = addFriendEt.text.toString()
            val users = userViewModel.searchUsers(username)
            resultsTv.text = "Results (${users.size})"
            userAdapter.users = users as MutableList<User>
            Log.d("AddFriendActivity", "Users List: ${users.size}")
            userAdapter.notifyDataSetChanged()
        }
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