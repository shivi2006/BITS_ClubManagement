package com.example.shiviMittal.Members.View

import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.room.Room

import com.example.shiviMittal.Members.Model.MemberDes
import com.example.shiviMittal.Members.Model.MembersDatabase
import com.example.shiviMittal.R
import com.google.firebase.firestore.FirebaseFirestore

class AddMember : Fragment() {
    interface  Listener{
        fun callback( member : MemberDes){

        }

    }

    lateinit var globalcontext: Context

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_member, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name = view.findViewById<EditText>(R.id.view_name2)
        val position = view.findViewById<EditText>(R.id.view_position2)
        val contact = view.findViewById<EditText>(R.id.view_contact2)
        val button = view.findViewById<Button>(R.id.button_save)


        globalcontext = activity!!.applicationContext
        val db: MembersDatabase = Room.databaseBuilder(
            globalcontext,
            MembersDatabase::class.java,
            "Members_database"
        ).allowMainThreadQueries().build()
        Log.d("AddMember", "Database created")


        button.setOnClickListener { view ->
            if (TextUtils.isEmpty((name.text.toString())) && TextUtils.isEmpty(position.text.toString())) {
                Toast.makeText(
                    globalcontext,
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG
                ).show()
            } else {
                val members = MemberDes(
                    name.text.toString(),
                    position.text.toString(),
                    contact.text.toString()
                )
                //This members has to be updated on firebase
                var firebaseFirestore= FirebaseFirestore.getInstance()
                firebaseFirestore.collection("MemberDetails").add(members).addOnSuccessListener  { documentReference ->
                    Log.d(TAG, "DocumentSnapshot written with ID: ${documentReference.id}")
                }
                    .addOnFailureListener { e ->
                        Log.w(TAG, "Error adding document", e)
                    }

                //db.getMembersDao().insertAll(members)
                //Log.d("AddMember", "Saved in database${db.getMembersDao().getAll()}")
                val action =
                    AddMemberDirections.actionAddMemberToMembers()
                view!!.findNavController().navigate(action)


            }
        }


    }
/*
    override fun onResume() {
        super.onResume()
        globalcontext = getActivity()!!.applicationContext
        val db: MembersDatabase = Room.databaseBuilder(
            globalcontext,
            MembersDatabase::class.java,
            "members_database"
        ).allowMainThreadQueries().build()

        db.getMembersDao().insertAll(members)

        Log.d("AddMember", "Database created")
    }*/
}

