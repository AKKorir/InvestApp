package com.example.investapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class AssetsActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assets)

        val close = findViewById<TextView>(R.id.closebtn)
        close.setOnClickListener {
            val closeIntent = Intent(this, HomeActivity::class.java)
            startActivity(closeIntent)
        }
    }
}
