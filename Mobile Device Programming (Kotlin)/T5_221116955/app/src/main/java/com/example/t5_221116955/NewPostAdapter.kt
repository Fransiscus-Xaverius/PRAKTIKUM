package com.example.t5_221116955

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewPostAdapter(
    val data: MutableList<Post>,
): RecyclerView.Adapter<NewPostAdapter.ViewHolder>() {


    class ViewHolder(val row: View, data: MutableList<Post>): RecyclerView.ViewHolder(row) {
        val newTopicTitleTv:TextView = row.findViewById(R.id.newTopicTitleTv)
        val newTopicContentTv:TextView = row.findViewById(R.id.newTopicContentTv)
        val newTopicLikeBtn:ImageButton = row.findViewById(R.id.newTopicLikeBtn)
        val newTopicLikeAmountTv:TextView = row.findViewById(R.id.newTopicLikeAmountTv)
        val newTopicReplyAmountTv:TextView = row.findViewById(R.id.newTopicReplyAmountTv)

        init {
            row.setOnClickListener {
                //attempted to add an onclicklistener. Too bad!
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewPostAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
        return NewPostAdapter.ViewHolder(
            itemView.inflate(
                R.layout.new_post_item, parent, false
            ),
            data
        )
    }

    override fun onBindViewHolder(holder: NewPostAdapter.ViewHolder, position: Int) {
        val post = data[position]
        holder.newTopicTitleTv.text = post.topic
        holder.newTopicContentTv.text = post.content
        holder.newTopicLikeAmountTv.text = post.likes.size.toString()
        holder.newTopicReplyAmountTv.text = post.replies.size.toString()
        if(MockDB.currentUser!!.username in post.likes){
            holder.newTopicLikeBtn.setImageResource(R.drawable.liked_icon)
        }

    }

    override fun getItemCount(): Int {
        return data.size // Not declaring anything in this stupid function crashes the entire app. Nice! I want to go back to Backend Development.
    }

}