

package com.example.shiviMittal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentController
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(){
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setContentView(R.layout.fragment_login)
        //val button: Button =findViewById(R.id.login_button)
        //button.setOnClickListener(object :View.OnClickListener {
        //  override fun onClick(p0: View?) {
        //    val action = LoginDirections.actionLoginToMembers()
        //  p0!!.findNavController().navigate(action)


        val bottomBar: BottomNavigationView = findViewById(R.id.bottom_bar)
        navController = findNavController(R.id.nav_host_fragment)
        //val topLevelDest =
           // etOf(R.id.members, R.id.attendance, R.id.expenditure, R.id.events, R.id.members,R.id.login)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.members, R.id.events, R.id.attendance, R.id.expenditure
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        bottomBar.setupWithNavController(navController)


    }}

