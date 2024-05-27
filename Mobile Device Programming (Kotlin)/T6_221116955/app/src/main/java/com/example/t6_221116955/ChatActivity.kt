package com.example.t6_221116955

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ChatActivity : AppCompatActivity() {
    private lateinit var userViewModel: UserViewModel
    private lateinit var displayNameChatTV: TextView
    private lateinit var chatRV: RecyclerView
    private lateinit var sendBtn: Button
    private lateinit var sendChatMultiEt: TextView
    private lateinit var ChatViewModel: chatViewModel
    private lateinit var messageAdapter: MessageAdapter

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        ChatViewModel = ViewModelProvider(this)[chatViewModel::class.java]

        displayNameChatTV = findViewById(R.id.displayNameChatTV)
        chatRV = findViewById(R.id.chatRV)
        sendBtn = findViewById(R.id.sendChatBtn)
        sendChatMultiEt = findViewById(R.id.sendChatMultiEt)



        val username = intent.getStringExtra("USERNAME")
        // Use username to display the chat with the user
        val user = username?.let { userViewModel.getUserByUsername(it) }
        messageAdapter = MessageAdapter(ChatViewModel.getMessages(dataObj.curUser!!, user!!))
        chatRV.layoutManager = LinearLayoutManager(this)
        chatRV.adapter = messageAdapter
//        Toast.makeText(this, "Chatting with ${user?.displayName}", Toast.LENGTH_SHORT).show()
        displayNameChatTV.text = user?.displayName ?: "USER NOT FOUND"
        Toast.makeText(this, "Chatting with ${displayNameChatTV.text}", Toast.LENGTH_SHORT).show()
        dataObj.tarUser = user

        sendBtn.setOnClickListener {
            val messageText = sendChatMultiEt.text.toString()
            if (messageText.isNotEmpty()) {
                val sender = dataObj.curUser
                val receiver = dataObj.tarUser
                Toast.makeText(this, "Sender: ${sender?.userName}, Receiver: ${receiver?.userName}", Toast.LENGTH_SHORT).show()
                sender?.let { it1 -> receiver?.let { it2 ->
                    ChatViewModel.newMessage(it1,
                        it2, messageText)
                } }

                // Get the messages for the current user or from the current user
                val messages = ChatViewModel.getMessages(sender!!, receiver!!)

                // Update the messages in the adapter and notify the RecyclerView to refresh
                messageAdapter.messages = messages
                Toast.makeText(this, "Messages: ${messages.size}", Toast.LENGTH_SHORT).show()
                messageAdapter.notifyDataSetChanged()
                sendChatMultiEt.text = ""
            }
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