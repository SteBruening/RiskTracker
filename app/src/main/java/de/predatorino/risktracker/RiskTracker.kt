package de.predatorino.risktracker

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.widget.Toast


class RiskTracker : AppCompatActivity() {

    private val mapFragment = MapFragment.newInstance()
    private val probabilityFragment = ProbabilityFragment.newInstance()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_risk_tracker)
        openFragment(mapFragment)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }




    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.nav_map -> {
                openFragment(mapFragment)
                return@OnNavigationItemSelectedListener true
            }

            R.id.nav_probability -> {
                openFragment(probabilityFragment)
                return@OnNavigationItemSelectedListener true
            }
            else -> return@OnNavigationItemSelectedListener false
        }
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }


}
