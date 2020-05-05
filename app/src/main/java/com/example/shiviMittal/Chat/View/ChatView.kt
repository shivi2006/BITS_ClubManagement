package com.example.shiviMittal.Chat.View

import android.os.Bundle
import android.text.TextUtils
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shiviMittal.Chat.ViewModel.ChatViewModel
import com.example.shiviMittal.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ChatView : AppCompatActivity(){

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView3)
        val chatViewModel: ChatViewModel
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

            val adapter = AdapterChatView()
            recyclerView.adapter = adapter


             chatViewModel = run { ViewModelProviders.of(this@ChatView).get(ChatViewModel::class.java) }
             chatViewModel.receiveData().observe(this, Observer {
                 adapter.setData(it)
        })

            val fab = findViewById(R.id.fab) as FloatingActionButton
            val editText= findViewById<EditText>(R.id.input)

            fab.setOnClickListener { view ->

            val input = editText.text.toString()
            if (TextUtils.isEmpty(input)) {
                Toast.makeText(this,
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG
                ).show()
            } else {
                chatViewModel.sendMessage(input)
            }
    }
    }
}