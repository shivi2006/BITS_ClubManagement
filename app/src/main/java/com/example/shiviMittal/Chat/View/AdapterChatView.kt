package com.example.shiviMittal.Chat.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shiviMittal.Chat.Model.ChatRoom
import com.example.shiviMittal.R

class AdapterChatView():RecyclerView.Adapter<AdapterChatView.ViewHolder>() {


    var list:MutableList<ChatRoom> = ArrayList()

    override fun onCreateViewHolder(p: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(p.context).inflate(R.layout.chat_layout_row,p,false)
        return ViewHolder(view) // message layout left
    }

    override fun onBindViewHolder(p: ViewHolder, position: Int) {
        p.message_text.text= list[position].msg
       // p.message_time.text= list[position].time
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(list:MutableList<ChatRoom>){
        this.list = list
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

       // val message_time= itemView.findViewById(R.id.message_time) as TextView
        val message_text= itemView.findViewById(R.id.message_text) as TextView
    }
}