package com.example.shiviMittal.Members.View

import android.content.Context
import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.shiviMittal.Members.Model.MemberDes
import com.example.shiviMittal.Members.ViewModel.MembersViewModel
import com.example.shiviMittal.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


class Members_class01 : Fragment() ,
    AddMember.Listener {


    lateinit var globalcontext: Context
    lateinit var navController: NavController
     var memberViewModel: MembersViewModel? =null

    // var members: MutableList<MemberDes> = mutableListOf()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        globalcontext = activity!!.applicationContext
        return inflater.inflate(R.layout.members_layout01, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)


            memberViewModel = activity?.run{ ViewModelProviders.of(this).get(MembersViewModel::class.java)}
            memberViewModel?.members?.observe(viewLifecycleOwner, Observer {

            val adapter = Adapter(it)
            recyclerView.adapter = adapter
            //adapter.notifyDataSetChanged()
        })

        val fab = view.findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val action =
                    Members_class01Directions.actionMembersToAddMember()
                view!!.findNavController().navigate(action)
            }
        }
        )

    }

    override fun callback(member: MemberDes) {
        memberViewModel?.insert(member)
    }
}


  /*  override fun onResume() {

        //members=MembersDatabase.getMembersDao().getAll()
        memberViewModel.members.clear()
        view!!.findViewById<RecyclerView>(R.id.recycler_view).adapter = Adapter(memberViewModel.members)
        view!!.findViewById<RecyclerView>(R.id.recycler_view).adapter!!.notifyDataSetChanged()
        super.onResume()
    }
}*/











