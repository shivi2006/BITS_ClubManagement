package com.example.shiviMittal.Members
import androidx.room.Entity

@Entity(primaryKeys=["name","position","contact"])

class MemberDes(
    var name:String,
    var position:String,
    var contact:String
)