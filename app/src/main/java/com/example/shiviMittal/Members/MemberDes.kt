package com.example.shiviMittal.Members
import androidx.room.Entity

@Entity(primaryKeys=["contact"],tableName = "members")

class MemberDes(
    var name:String,
    var position:String,
    var contact:String
)