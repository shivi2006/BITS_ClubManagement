package com.example.shiviMittal.Members

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.nfc.Tag
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
import com.example.shiviMittal.R

class AddMember : Fragment() {
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


        globalcontext = getActivity()!!.applicationContext
        val db: MembersDatabase = Room.databaseBuilder(
            globalcontext,
            MembersDatabase::class.java,
            "members_database"
        ).allowMainThreadQueries().build()
        Log.d("AddMember", "Database created")


        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {

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

                    db.getMembersDao().insertAll(members)
                    Log.d("AddMember", "Saved in database")
                    val action = AddMemberDirections.actionAddMemberToMembers()
                    view!!.findNavController().navigate(action)
                    //  val intent= Intent()
                    // startActivity(intent)

                }
            }
        }
        )



           /*
*/


    }

    override fun onResume() {
        super.onResume()
        globalcontext = getActivity()!!.applicationContext
        val db: MembersDatabase = Room.databaseBuilder(
            globalcontext,
            MembersDatabase::class.java,
            "members_database"
        ).allowMainThreadQueries().build()
        Log.d("AddMember", "Database created")
    }
}

