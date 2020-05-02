package com.example.shiviMittal.Members.ViewModel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.shiviMittal.Members.Model.MemberDes
import com.example.shiviMittal.Members.Model.MembersDao
import com.example.shiviMittal.Members.Model.MembersDatabase
import com.example.shiviMittal.Members.Repository.MembersRepo

public class  MembersViewModel( application: Application):AndroidViewModel(application){


         val members_dao = MembersDatabase.getInstance(application).getMembersDao()
         var repo:MembersRepo = MembersRepo(members_dao,application)
         var members = liveData{emitSource(repo.members)}


         //application= getApplication<Application>()

   /* fun update(memberDes: MemberDes){
    repo.update(memberDes)
    }

    fun delete(memberDes: MemberDes){
        repo.delete(memberDes)
    }*/

    fun insert(memberDes: MemberDes){
        repo.insert(memberDes)

    }


}