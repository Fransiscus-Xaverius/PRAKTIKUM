package com.example.t5_221116955

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(
    val data: MutableList<Post>,
    var onAnswerClickListener: ((Post)-> Unit)
): RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    class ViewHolder(val row: View): RecyclerView.ViewHolder(row) {
        val topicTv:TextView = row.findViewById(R.id.trendingTopicTitleTV)
        val trendingAnswerBtn:Button = row.findViewById(R.id.trendingTopicAnswerBtn)
        val trendingLikeBtn:ImageButton = row.findViewById(R.id.trendingTopicLikeBtn)
        val likeAmountTv:TextView = row.findViewById(R.id.likeAmountTv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
        return ViewHolder(itemView.inflate(
            R.layout.post_item, parent ,false
        ))
    }

    override fun onBindViewHolder(holder: PostAdapter.ViewHolder, position: Int) {
        val post = data[position]
        holder.topicTv.text = post.topic
        holder.likeAmountTv.text = post.likes.size.toString()
        holder.trendingLikeBtn.setImageResource(R.drawable.liked_icon)
        if(MockDB.currentUser!!.username in post.likes){
            holder.trendingLikeBtn.setImageResource(R.drawable.not_liked_icon)
        }
        holder.trendingLikeBtn.setOnClickListener{
            if(MockDB.currentUser!!.username in post.likes){
                post.likes.remove(MockDB.currentUser!!.username)
                holder.trendingLikeBtn.setImageResource(R.drawable.not_liked_icon)
                holder.likeAmountTv.text = post.likes.size.toString()
            }
            else{
                post.likes.add(MockDB.currentUser!!.username)
                holder.trendingLikeBtn.setImageResource(R.drawable.liked_icon)
                holder.likeAmountTv.text = post.likes.size.toString()
            }
         }
        holder.trendingAnswerBtn.setOnClickListener {
            onAnswerClickListener.invoke(post)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

}