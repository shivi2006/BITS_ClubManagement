package com.example.shiviMittal.ChatList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.shiviMittal.Chat.Model.ChatRoom
import com.example.shiviMittal.Chat.Repository.ChatRepo


class ChatListViewModel( application: Application): AndroidViewModel(application) {

    var repo: ChatListRepo = ChatListRepo()

    fun receiveChatList(): LiveData<MutableList<ChatList>> {

        val list_of_chats = liveData { emitSource(repo.callChatList()) }
        return list_of_chats
    }
}
