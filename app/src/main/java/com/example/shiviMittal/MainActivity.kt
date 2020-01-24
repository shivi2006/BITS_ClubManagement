

package com.example.shiviMittal

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    val listener = BottomNavigationView.OnNavigationItemSelectedListener{ menuItem:MenuItem ->


        when (menuItem.itemId) {
            R.id.attendance -> {
                val fragment1 = Attendance_class.newInstance()
                openFragment(fragment1)
                return@OnNavigationItemSelectedListener true

            }
            R.id.members -> {
                val fragment2 = Members_class.newInstance()
               openFragment(fragment2)
                return@OnNavigationItemSelectedListener true

            }
            R.id.events -> {
                val fragment3 = Events_class.newInstance()
               openFragment(fragment3)
                return@OnNavigationItemSelectedListener true
        }
            R.id.expenditure -> {
                val fragment4 = Expenditure_class.newInstance()
                openFragment(fragment4)
                return@OnNavigationItemSelectedListener true

            }

        }
        false
    }
    private fun openFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()

    }


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            setContentView(R.layout.activity_main)
            val bottomBar: BottomNavigationView = findViewById(R.id.bottom_bar)
            bottomBar.setOnNavigationItemSelectedListener(listener)


        }
    }
