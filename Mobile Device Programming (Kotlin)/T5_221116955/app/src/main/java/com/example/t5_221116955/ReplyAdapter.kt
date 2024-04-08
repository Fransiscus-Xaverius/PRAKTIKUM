package com.example.t5_221116955

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ReplyAdapter(
    val data: MutableList<Reply>,
): RecyclerView.Adapter<ReplyAdapter.ViewHolder>() {
    class ViewHolder(val row: View): RecyclerView.ViewHolder(row) {
        val replyItemUsernameTv:TextView = row.findViewById(R.id.replyItemUsernameTv)
        val replyContentTv:TextView = row.findViewById(R.id.replyContentTv)
        val replyLikeBtn:ImageButton = row.findViewById(R.id.replyLikeBtn)
        val replyDislikeBtn:ImageButton = row.findViewById(R.id.replyDislikeBtn)
        val replyLikedAmountTv:TextView = row.findViewById(R.id.replyLikedAmountTv)
        val replyDislikedAmountTv:TextView = row.findViewById(R.id.replyDislikedAmountTv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
        return ViewHolder(itemView.inflate(
            R.layout.reply_item, parent, false
        ))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val reply = data[position]
        holder.replyItemUsernameTv.text = reply.displayName
        holder.replyContentTv.text = reply.content
        holder.replyLikedAmountTv.text = reply.likes.size.toString()
        holder.replyDislikedAmountTv.text = reply.likes.size.toString()
        holder.replyLikeBtn.setOnClickListener {

        }
        holder.replyDislikeBtn.setOnClickListener {

        }
    }
}