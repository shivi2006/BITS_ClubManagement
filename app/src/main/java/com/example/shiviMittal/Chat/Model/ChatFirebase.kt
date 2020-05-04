package com.example.shiviMittal.Chat.Model

import android.app.Application
import android.content.ContentValues.TAG
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Database
import com.google.firebase.database.*
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot

class Chatfirebase {

    var messagelist: MutableLiveData<MutableList<ChatRoom>> = MutableLiveData()
    lateinit var messages: ChatRoom
     var list: MutableList<ChatRoom> = ArrayList()


    fun callDataFirebase(sender_id: String, receiver_id: String): LiveData<MutableList<ChatRoom>> {
        val firebaseFirestore = FirebaseFirestore.getInstance()
        firebaseFirestore.collection("chatRoom").document(sender_id + receiver_id)
            .collection("messages").orderBy("time").addSnapshotListener { snapshot, e ->

                if (snapshot != null) {
                    DocumentSnapshot.ServerTimestampBehavior.ESTIMATE
                    val i = 0
                    while (i < snapshot.documents.size) {
                        messages =
                            ChatRoom(
                                snapshot.documents[i]["msg"].toString(),
                                snapshot.documents[i]["sentby"].toString(),
                                snapshot.documents[i]["time"].toString()
                            )
                        list.add(messages)

                    }
                    messagelist.setValue(list)
                }
            }
    return messagelist
}
}






        /*val reference = FirebaseDatabase.getInstance().getReference().child("chatRoom")

        val getmessages: Query = reference.do
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

            }


            override fun onCancelled(databaseError: DatabaseError) {

                Log.w(TAG, "loadPost:onCancelled", databaseError.toException())

            }
        }
        reference.addValueEventListener(postListener)

        return


    }
}

      /*  val firebaseFirestore = FirebaseFirestore.getInstance()
        val chatMessages: LiveData<MutableList<ChatRoom>>
        var chatRoom: ChatRoom

        val menuListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                    var i = 0
                    while (i < dataSnapshot.result!!.documents.size) {
                        chatRoom =
                            ChatRoom(
                                it.result!!.documents[i]["msg"].toString(),
                                it.result!!.documents[i]["sentby"].toString(),
                                it.result!!.documents[i]["time"].toString(),
                            )
                        Log.d("$i", "Pushed")
                        i++
                    }
                }


            override fun onCancelled(p0: DatabaseError) {

                Log.d("Error", "Error occurred")

            }

        }
        return chatMessages
    }
}
*/