package com.example.shiviMittal.Members.Model

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.shiviMittal.Members.Model.MemberDes

@Dao
interface MembersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(member: MemberDes)

    //@Update
    //fun update(member: MemberDes)

  //  @Delete
    //fun delete(member:MemberDes)


    @Query( "SELECT * FROM members")
    fun getAll(): LiveData<MutableList<MemberDes>>

}