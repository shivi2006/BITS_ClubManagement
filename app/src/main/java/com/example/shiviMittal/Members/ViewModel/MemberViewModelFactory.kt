package com.example.shiviMittal.Members.ViewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject


class MemberViewModelFactory:ViewModelProvider.Factory{

    @Inject
    lateinit var application: Application

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return MembersViewModel(application) as T
    }

}