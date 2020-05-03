package com.example.shiviMittal.Chat.Repository

import android.app.Application
import android.content.ContentValues
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.shiviMittal.Chat.Model.ChatRoom
import com.example.shiviMittal.Chat.Model.Chatfirebase
import com.google.firebase.firestore.FirebaseFirestore
import java.time.LocalDateTime
class ChatRepo( application: Application) {

    val chat_object= Chatfirebase()
    var receiver_id:String = "f20190383"
    var sender_id:String = "f20190778"
    val time:String = LocalDateTime.now().toString()

    fun receiveMessages():LiveData<MutableList<ChatRoom>> {
        val my_chat = chat_object.callDataFirebase(sender_id,receiver_id)
        return my_chat
    }

    fun sendNewTextMessage( textInput:String){
        val chatRoom = ChatRoom(textInput, sender_id,time )

        //val hash_receiver_id= receiver_id.hashCode()
        //val hash_sender_id = sender_id.hashCode()
        //create a logic to make unique thread between users

        val firebaseFirestore = FirebaseFirestore.getInstance()


            firebaseFirestore.collection("chatRoom").document(sender_id + receiver_id)
                .collection("messages").add(chatRoom).addOnSuccessListener { documentReference ->

                    firebaseFirestore.collection("users").document(sender_id)
                        .collection("UserChats").document(receiver_id).update(mapOf(
                            "lastmsg" to textInput,
                            "time" to time,
                            "unreadno" to 2
                        ))
                        .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully updated!") }
                        .addOnFailureListener { e -> Log.w(TAG, "Error updating document", e) }

                        Log.d(ContentValues.TAG,
                        "DocumentSnapshot written with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w(ContentValues.TAG, "Error adding document", e)
                }
    }
        }




