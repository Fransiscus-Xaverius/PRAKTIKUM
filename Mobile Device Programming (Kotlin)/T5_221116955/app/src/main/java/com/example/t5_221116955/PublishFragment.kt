package com.example.t5_221116955

import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController

class PublishFragment : Fragment() {

    lateinit var topicTitleTv: TextView
    lateinit var topicContentTv:TextView
    lateinit var publishBtn:Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_publish, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        topicContentTv = view.findViewById(R.id.topicContentTv)
        topicTitleTv = view.findViewById(R.id.topicTitleEt)
        publishBtn = view.findViewById(R.id.publishBtn)

        publishBtn.setOnClickListener {
            var topic = topicTitleTv.text
            var content = topicContentTv.text
            var author = MockDB.currentUser!!.username

            if(topic.isNotEmpty() and content.isNotEmpty()){
                MockDB.addPost(topic.toString(),content.toString(),author)
                val text = "Published new Topic!"
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(this.requireContext(), text, duration)
                toast.show()
                findNavController().navigate(R.id.action_global_homeFragment)
            }
            else{
                val text = "Missing values!"
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(this.requireContext(), text, duration)
                toast.show()
            }
        }

    }

}