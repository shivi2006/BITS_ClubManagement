package com.example.shiviMittal.Members

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.shiviMittal.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton




class Members_class01 : Fragment() , AddMember.Listener {


    lateinit var globalcontext:Context
    lateinit var navController:NavController

    var members: MutableList<MemberDes> = mutableListOf()
    lateinit var  db: MembersDatabase
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        globalcontext= activity!!.applicationContext
        return inflater.inflate(R.layout.members_layout01,container,false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)





       // val bottomBar: BottomNavigationView = view.findViewById(R.id.bottom_bar)
        //navController=findNavController()
        //val topLevelDest= setOf(R.id.members,R.id.attendance,R.id.expenditure,R.id.events,R.id.members)
        //val appBarConfiguration= AppBarConfiguration(
          //setOf(
            //R.id.members,R.id.events,R.id.attendance,R.id.expenditure))

       // setupActionBarWithNavController(navController,appBarConfiguration)
        //bottomBar.setupWithNavController(navController)


        db = Room.databaseBuilder(globalcontext, MembersDatabase::class.java,
                "Members_database").allowMainThreadQueries().build()

//            val members: MutableList<MemberDes> = db.getMembersDao().getAll()

        // members.clear()
        members = db.getMembersDao().getAll()
        Log.d("check", "memebrs in onviewcreated${members}")
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
            recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            val adapter = Adapter(members)
            recyclerView.adapter = adapter
            adapter.notifyDataSetChanged()


            val fab =view.findViewById<FloatingActionButton>(R.id.fab)
            fab.setOnClickListener(object : View.OnClickListener {
                override fun onClick(view: View?) {
                    val action=Members_class01Directions.actionMembersToAddMember()
                    view!!.findNavController().navigate(action)
                    //val intent= Intent()
                    //startActivity(intent)


                }})}

    override fun callback(member: MemberDes) {
        db.getMembersDao().insertAll(member)
    }

    override fun onResume() {

        // members.clear()
        members=db.getMembersDao().getAll()
        view!!.findViewById<RecyclerView>(R.id.recycler_view).adapter = Adapter(members)
        view!!.findViewById<RecyclerView>(R.id.recycler_view).adapter!!.notifyDataSetChanged()
        Log.d("check2","onresume called memclas1${members}")
        super.onResume()
    }
}




