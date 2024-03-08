package com.example.investapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.investapp.R
import com.example.investapp.databinding.ActivityMainBinding



lateinit var  binding: ActivityMainBinding

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFrag(Home())
        setContentView(R.layout.activity_home)

        val bottomNavigationView = findViewById <BottomNavigationView>(R.id.bottomnav)
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    replaceFrag(Home())
                    // Handle the home action
                    Toast.makeText(this, "Home Clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.searchItem -> {
                    replaceFrag(Product())
                    // Handle the dashboard action
                    Toast.makeText(this, "Products Clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.transact -> {
                    replaceFrag(Transact())
                    // Handle the notifications action
                    Toast.makeText(this, "Transaction Clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.profile -> {
                    replaceFrag(Account())
                    // Handle the notifications action
                    Toast.makeText(this, "Account Clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }



        }

    }




      fun replaceFrag(fragment: Fragment){
          val fragmentManager = supportFragmentManager
          val fragmentTransaction = fragmentManager.beginTransaction()
          fragmentTransaction.replace(R.id.home_frame,fragment)
          fragmentTransaction.commit()
    }

}