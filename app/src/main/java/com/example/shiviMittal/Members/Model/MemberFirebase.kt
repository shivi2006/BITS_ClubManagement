package com.example.shiviMittal.Members.Model

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.google.firebase.firestore.FirebaseFirestore

//import android.content.Context

//import com.google.firebase.firestore.FirebaseFirestore

public class Memberfirebase(application: Application) {
    lateinit var members: LiveData<MutableList<MemberDes>>
    var context = application.applicationContext
    fun callDataFirebase(): LiveData<MutableList<MemberDes>> {

        val firebaseFirestore = FirebaseFirestore.getInstance()
        firebaseFirestore.collection("MemberDetails").get().addOnCompleteListener {
            if (it.isSuccessful) {
                var i = 0
                while (i < it.result!!.documents.size) {
                    val members = MemberDes(
                        it.result!!.documents[i]["name"].toString(),
                        it.result!!.documents[i]["position"].toString(),
                        it.result!!.documents[i]["contact"].toString()
                    )
                    MembersDatabase.getInstance(context).getMembersDao().insertAll(members)
                    Log.d("$i", "Pushed")
                    i++
                }
            }

           // val members = MembersDatabase.getInstance(context).getMembersDao().getAll()
            //return members

        }
        members = MembersDatabase.getInstance(context).getMembersDao().getAll()
        return members

    }
}