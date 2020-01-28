package com.example.shiviMittal.Members

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shiviMittal.R

class Adapter(var member:MutableList<MemberDes>):RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.members_list,parent,false))
    }

    override fun getItemCount(): Int {
        return member.size
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        holder.name.text= member[position].name
        holder.position.text=member[position].position
        holder.contact.text=member[position].contact



    }
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val name:TextView= itemView.findViewById(R.id.view_name)
        val position:TextView=itemView.findViewById(R.id.view_position)
        val contact:TextView=itemView.findViewById(R.id.view_contact)
    }

}