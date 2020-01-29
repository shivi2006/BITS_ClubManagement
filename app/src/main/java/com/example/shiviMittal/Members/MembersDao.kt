package com.example.shiviMittal.Members

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MembersDao {

    @Insert
    fun insertAll(member:MemberDes)

    @Query( "SELECT * FROM members")
    fun getAll():MutableList<MemberDes>

}