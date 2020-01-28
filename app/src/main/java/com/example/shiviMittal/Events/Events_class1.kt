package com.example.shiviMittal.Events

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout.VERTICAL
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shiviMittal.Members.Adapter
import com.example.shiviMittal.Members.MemberDes
import com.example.shiviMittal.R
import kotlinx.android.synthetic.main.events_layout1.*

class Events_class1 : Fragment() {

    lateinit var globalcontext:Context

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.events_layout1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        globalcontext= getActivity()!!.applicationContext
        fun populateLists():ArrayList<String>{

            val titlelist= ArrayList<String>()
            titlelist.add("SIG on Machine Learning")
            titlelist.add("SIG on Cyber Security")
            titlelist.add("SIG on App Development")
            titlelist.add("SIG on Web Development")
            titlelist.add("SIG on Competitive Coding")
            titlelist.add("Hour Of Code")
            titlelist.add("Hackathon")
            titlelist.add("Checkmate")
            return titlelist


        }
        val titlelist=populateLists()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_events)
        recyclerView.layoutManager = LinearLayoutManager(globalcontext, RecyclerView.VERTICAL, false)
        val adapter=Adpater_events(titlelist)
        recyclerView.adapter=adapter

}}