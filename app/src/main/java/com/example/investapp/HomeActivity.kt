package com.example.investapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.investapp.R
import com.example.investapp.assetAdapter

lateinit var cardImage: Array<Int>
lateinit var heading: Array<String>
lateinit var descrip: Array<String>

lateinit var investImage: Array<Int>
lateinit var nheading: Array<String>
lateinit var subheading: Array<String>

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        cardImage = arrayOf(
            R.drawable.dolar,
            R.drawable.silva,
            R.drawable.platim,
            R.drawable.dolar,
            R.drawable.silva,

        )
        heading = arrayOf(
            "Gold",
            "silva",
            "platin",
            "Gold",
            "silva",
        )
        descrip = arrayOf(
            "30% return",
            "60% return",
            "90% return",
            "30% return",
            "60% return",
        )

        val assRecycle: RecyclerView = findViewById(R.id.asscards)
        assRecycle.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        assRecycle.setHasFixedSize(true)
        val assetAdapter = assetAdapter(this@HomeActivity, assetListItems())
        assRecycle.adapter = assetAdapter

        investImage = arrayOf(
            R.drawable.news1,
            R.drawable.news2,
            R.drawable.news1,
            R.drawable.news2,
            R.drawable.news1
        )
        nheading = arrayOf(
            "Basic type of investment",
            "How much can you start with",
            "What is the best Crypto to strat with",
            "Current trends",
            "Investment patterns in the market",
        )
        subheading = arrayOf(
            "This is how you set foot into 2024 stock market. What next?",
            "What do you like to see? it's a very different market.",
            "With the approaching halving of bitcoin, it is easily the best option",
            "lets look into NFT and bitcoin ETF's have are dominating the current market",
            "you need to look into the trends that show Bullish market with the progress of the year",
        )
        val newsRecycle: RecyclerView =findViewById(R.id.invguide)
        newsRecycle.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL, true)
        val investAdapter = investAdapter(this@HomeActivity,investListItem())
        newsRecycle.adapter =investAdapter




        val hhome = findViewById<View>(R.id.home)
        hhome.setOnClickListener {
            val investIntent = Intent(this, HomeActivity::class.java)
            startActivity(investIntent)
        }

        val notif = findViewById<View>(R.id.notif)
        notif.setOnClickListener {
             val notifIntent = Intent(this, HomeActivity::class.java)
                startActivity(notifIntent)
            }


        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomnav)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    // Handle the home action
                    Toast.makeText(this, "Home Clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.searchItem -> {
                    // Handle the dashboard action
                    Toast.makeText(this, "Dashboard Clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.transact -> {
                    // Handle the notifications action
                    Toast.makeText(this, "Notifications Clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.profile -> {
                    // Handle the notifications action
                    Toast.makeText(this, "Notifications Clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }


        }

    }

    fun assetListItems():ArrayList<asset>{
        val newArrayList= ArrayList<asset>()
    for(i in cardImage.indices){
            val rasset = asset(cardImage[i],heading[i],descrip[i])
            newArrayList.add(rasset)
        }
    return newArrayList

    }
    fun investListItem(): ArrayList<investGuide>{
        val newsList= ArrayList<investGuide>()
        for(i in investImage.indices){
            val rnews = investGuide ( investImage[i], nheading[i], subheading[i])
            newsList.add(rnews)
        }
        return newsList
    }

}