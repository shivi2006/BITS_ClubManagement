package com.example.shiviMittal.Members.Repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.shiviMittal.Members.Model.MemberDes
import com.example.shiviMittal.Members.Model.Memberfirebase
import com.example.shiviMittal.Members.Model.MembersDao
import com.example.shiviMittal.Members.Model.MembersDatabase

class MembersRepo( private val membersDao: MembersDao,application: Application) {

    val memberobject= Memberfirebase(application)

    var members: LiveData<MutableList<MemberDes>> = memberobject.callDataFirebase()

    fun insert(memberDes: MemberDes) {
        membersDao.insertAll(memberDes)
    }

}

