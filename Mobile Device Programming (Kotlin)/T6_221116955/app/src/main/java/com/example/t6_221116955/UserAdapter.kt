package com.example.t6_221116955

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter (
    var users: MutableList<User>,
    private val onAddFriendClickListener: (User) -> Unit
): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userName: TextView = itemView.findViewById(R.id.addFriendUsernameTV)
        val displayName: TextView = itemView.findViewById(R.id.addFriendDisplayNameTV)
        val addFriendButton: ImageButton = itemView.findViewById(R.id.addFriendBtn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.add_user_item, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.userName.text = user.userName
        holder.displayName.text = user.displayName
        holder.addFriendButton.setOnClickListener {
            onAddFriendClickListener(user)
        }
    }

    fun removeUser(user: User) {
        users.remove(user)
        notifyDataSetChanged()
    }

    override fun getItemCount() = users.size
}