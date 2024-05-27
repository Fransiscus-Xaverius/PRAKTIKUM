package com.example.t6_221116955

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FriendAdapter (
    var friends: MutableList<User>,
    private val context: Context,
    private val ChatViewModel: chatViewModel,
): RecyclerView.Adapter<FriendAdapter.FriendViewHolder>() {

    class FriendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val friend_name: TextView = itemView.findViewById(R.id.friend_name)
        val friend_lastmessage: TextView = itemView.findViewById(R.id.friend_lastmessage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.friend_item, parent, false)
        return FriendViewHolder(view)
    }

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        val friend = friends[position]
        holder.friend_name.text = friend.displayName
        // holder.friend_lastmessage.text = friend.messages.last().message

        val lastMessage = ChatViewModel.getLastMessage(dataObj.curUser!!, friend)
        if (lastMessage != null) {
            holder.friend_lastmessage.text = lastMessage.messageText
        } else {
            holder.friend_lastmessage.text = "(Chat room is empty)"
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(context, ChatActivity::class.java)
            intent.putExtra("USERNAME", friend.userName) // Pass the user's username to ChatActivity
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = friends.size
}