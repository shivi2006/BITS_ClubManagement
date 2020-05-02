package com.example.shiviMittal.MyProfile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shiviMittal.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.my_profile.*


class MyProfile : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.my_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        fun signOut(){
            FirebaseAuth.getInstance().signOut()

        }


        sign_out.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                signOut()

            }

        }
        )
    }
}
