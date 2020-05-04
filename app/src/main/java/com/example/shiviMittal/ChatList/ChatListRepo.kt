package com.example.shiviMittal.ChatList

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shiviMittal.Chat.Model.ChatRoom
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore

class ChatListRepo {


    val sender_id: String = "f20190778"
    lateinit var my_chatlist: ChatList
    var chatlist_users:MutableLiveData<MutableList<ChatList>> = MutableLiveData()
    var list: MutableList<ChatList> = ArrayList()

    fun callChatList(): LiveData<MutableList<ChatList>> {

        val firebaseFirestore = FirebaseFirestore.getInstance()
        firebaseFirestore.collection("users").document(sender_id)
            .collection("UserChats").addSnapshotListener { snapshot, e ->

                if (snapshot != null) {
                    val i = 0
                    while (i < snapshot.documents.size) {
                        my_chatlist =
                            ChatList(
                                snapshot.documents[i]["lastmsg"].toString(),
                                snapshot.documents[i]["name"].toString(),
                                snapshot.documents[i]["time"].toString(),
                                snapshot.documents[i]["unreadno"].toString()
                            )
                        list.add(my_chatlist)
                    }
                        chatlist_users.setValue(list)
                }
            }
        return chatlist_users
    }
}