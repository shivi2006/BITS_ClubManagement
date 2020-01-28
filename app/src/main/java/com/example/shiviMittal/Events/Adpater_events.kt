package com.example.shiviMittal.Events

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shiviMittal.R

class Adpater_events(val titlelist:ArrayList<String>):RecyclerView.Adapter<Adpater_events.ViewHolder>() {

    override fun onCreateViewHolder(p: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(p.context).inflate(R.layout.cardsllist,p,false)
        return ViewHolder(view)


    }

    override fun onBindViewHolder(p: ViewHolder, position: Int) {
        p.description.text=titlelist[position]

    }




    override fun getItemCount(): Int {
        return titlelist.size
    }
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val description= itemView.findViewById(R.id.des) as TextView

    }




}