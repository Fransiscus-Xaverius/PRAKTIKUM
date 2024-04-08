package com.example.t5_221116955

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.lifecycle.VIEW_MODEL_STORE_OWNER_KEY
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import androidx.navigation.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import org.w3c.dom.Text

class DetailFragment : Fragment() {

    lateinit var detailTopicTitleTv:TextView
    lateinit var detailDisplayNameTv:TextView
    lateinit var detailLikeBtn:ImageButton
    lateinit var detailUpvotesTv:TextView
    lateinit var detailAnswerBtn:Button
    lateinit var replyRV:RecyclerView
    lateinit var contentTv:TextView
    lateinit var replyAdapter: ReplyAdapter
    lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    val navArgs:DetailFragmentArgs by navArgs<DetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val paramPost = navArgs.post

        detailTopicTitleTv = view.findViewById(R.id.detailTopicTitleTv)
        detailDisplayNameTv = view.findViewById(R.id.detaildisplayNameTv)
        detailLikeBtn = view.findViewById(R.id.detailLikeBtn)
        detailUpvotesTv = view.findViewById(R.id.detailUpvotesTv)
        detailAnswerBtn = view.findViewById(R.id.detailAnswerBtn)
        replyRV = view.findViewById(R.id.replyRV)
        contentTv = view.findViewById(R.id.contentTv)

        detailTopicTitleTv.text = paramPost.topic
        detailDisplayNameTv.text = paramPost.author
        contentTv.text = paramPost.content
        detailUpvotesTv.text = paramPost.likes.size.toString() + " Upvotes"

        detailAnswerBtn.setOnClickListener {
            MockDB.currentTopic = paramPost
            findNavController().navigate(R.id.action_global_replyFragment)
        }

        layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        replyAdapter = ReplyAdapter(paramPost.replies)

        replyRV.adapter = replyAdapter
        replyRV.layoutManager = layoutManager

    }


}