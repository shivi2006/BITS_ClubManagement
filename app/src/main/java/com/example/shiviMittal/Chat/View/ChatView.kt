package com.example.shiviMittal.Chat.View

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shiviMittal.Chat.Model.ChatRoom
import com.example.shiviMittal.Chat.ViewModel.ChatViewModel
import com.example.shiviMittal.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


class ChatView : AppCompatActivity(){

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val chatViewModel: ChatViewModel
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)


        chatViewModel = run { ViewModelProviders.of(this@ChatView).get(ChatViewModel::class.java) }
        chatViewModel.receiveData().observe(this, Observer {
            val adapter = Adpater_events(it)
            recyclerView.adapter = adapter
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