package com.example.shiviMittal.ChatList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shiviMittal.R

class ChatListView : Fragment() {

    lateinit var chatListViewModel: ChatListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.chat_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        val adapter = ChatListAdapter()
        recyclerView.adapter = adapter

        chatListViewModel = run { ViewModelProviders.of(this@ChatListView).get(ChatListViewModel::class.java) }
        chatListViewModel.receiveChatList().observe(viewLifecycleOwner, Observer {
            Log.d("check chat", "receive data")
            adapter.setData(it)
        }

        )
    }
}

