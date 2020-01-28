package com.example.shiviMittal.Members

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities= [MemberDes::class],
    version=1,
    exportSchema = false
)
abstract class MembersDatabase: RoomDatabase() {
   abstract fun getMembersDao():MembersDao


}
