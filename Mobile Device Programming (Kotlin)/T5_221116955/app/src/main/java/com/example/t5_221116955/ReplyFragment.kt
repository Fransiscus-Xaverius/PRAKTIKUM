package com.example.t5_221116955

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController

class ReplyFragment : Fragment() {

    lateinit var replyTopicTv:TextView
    lateinit var replyFragContentTv:TextView
    lateinit var replyML:EditText
    lateinit var publishBtn:Button
    lateinit var backBtn:Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reply, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        replyTopicTv = view.findViewById(R.id.replyTopicTv)
        replyFragContentTv = view.findViewById(R.id.replyFragContentTv)
        replyML = view.findViewById(R.id.replyML)
        publishBtn = view.findViewById(R.id.publishReplyBtn)
        backBtn = view.findViewById(R.id.replyBackBtn)

        replyTopicTv.text = MockDB.currentTopic!!.topic
        replyFragContentTv.text = MockDB.currentTopic!!.content

        publishBtn.setOnClickListener {
            if(replyML.text.isNotEmpty()){
                MockDB.currentTopic!!.replies.add(0,Reply(MockDB.currentUser!!.displayName, replyML.text.toString(), mutableListOf<String>(), mutableListOf<String>()))
                MockDB.currentTopic!!.replies = MockDB.currentTopic!!.replies.sortedByDescending { it.likes.size }.toMutableList()
                val action = ReplyFragmentDirections.actionGlobalDetailFragment(MockDB.currentTopic!!.id, MockDB.currentTopic!!)
                findNavController().navigate(action)
                MockDB.currentTopic = null

            }
            else{
                val text = "No reply given!"
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(this.requireContext(), text, duration)
                toast.show()
            }
        }

        backBtn.setOnClickListener {
            val action = ReplyFragmentDirections.actionGlobalDetailFragment(MockDB.currentTopic!!.id, MockDB.currentTopic!!)
            findNavController().navigate(action)
            MockDB.currentTopic = null
        }
    }
}