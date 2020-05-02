package com.example.shiviMittal.Members.Model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.squareup.okhttp.internal.Internal.instance

@Database(
    entities= [MemberDes::class],
    version=1,
    exportSchema = false
)
abstract class MembersDatabase: RoomDatabase() {

    // lateinit var db:MembersDatabase
    abstract fun getMembersDao(): MembersDao

    //lateinit var instance:MembersDatabase

    companion object {
         var Instance: MembersDatabase? = null

        fun getInstance(context: Context): MembersDatabase {
            val tempInstance = Instance
            if (tempInstance != null)
                return tempInstance
            synchronized(this) {

                var instance: MembersDatabase = Room.databaseBuilder(
                    context.getApplicationContext(), MembersDatabase::class.java,
                    "Members_d" + "atabase"
                ).allowMainThreadQueries().build()
                Instance=instance
                return instance
            }
        }

    }
}

