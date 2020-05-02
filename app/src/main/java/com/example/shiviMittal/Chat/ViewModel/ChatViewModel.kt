package com.example.shiviMittal.Chat.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.shiviMittal.Chat.Model.ChatRoom
import com.example.shiviMittal.Chat.Repository.ChatRepo
import com.example.shiviMittal.Members.Model.MembersDatabase
import com.example.shiviMittal.Members.Repository.MembersRepo

class  ChatViewModel( application: Application):AndroidViewModel(application){

    var repo: ChatRepo = ChatRepo(application)

    fun receiveData(): LiveData<MutableList<ChatRoom>> {

        val chat = liveData { emitSource(repo.receiveMessages()) }
        return chat
    }


    fun sendMessage(message:String){
        repo.sendNewTextMessage(message)
    }


    }
