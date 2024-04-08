package com.example.t5_221116955

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HomeFragment : Fragment() {

    lateinit var displayNameTv:TextView
    lateinit var trendingTopicRV:RecyclerView
    lateinit var newestTopicRV:RecyclerView
    lateinit var postAdapter: PostAdapter
    lateinit var layoutManager: RecyclerView.LayoutManager

    lateinit var newpostAdapter: NewPostAdapter
    lateinit var layoutManager2: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_home, container, false)

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        displayNameTv = view.findViewById(R.id.displayNameTv)
        trendingTopicRV = view.findViewById(R.id.trendingTopicRV)
        newestTopicRV = view.findViewById(R.id.newestTopicRV)

        displayNameTv.text = MockDB.currentUser?.displayName ?: "" //check if user is not logged in, stupid i know, but i just don't care at this point

        layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false)
        layoutManager2 = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)

        var hotTopics = MockDB.listPost.sortedByDescending { it.likes.size }.toMutableList().take(4).toMutableList() //this is a shitty cast but Yeah.. Kotlin sucks.
        var newestTopics = MockDB.listPost

        postAdapter = PostAdapter(hotTopics) { post ->
            val action = HomeFragmentDirections.actionGlobalDetailFragment(post.id, post)

            findNavController().navigate(action)
        }

        trendingTopicRV.adapter = postAdapter
        trendingTopicRV.layoutManager = layoutManager

        newpostAdapter = NewPostAdapter(newestTopics)

        newestTopicRV.adapter = newpostAdapter
        newestTopicRV.layoutManager = layoutManager2

    }

}