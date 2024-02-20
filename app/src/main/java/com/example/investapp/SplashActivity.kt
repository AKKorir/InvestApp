@file:Suppress("DEPRECATION")

package com.example.investapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val create = findViewById<Button>(R.id.createAcc)
        val login = findViewById<TextView>(R.id.login)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        create.setOnClickListener {
            val signupIntent= Intent(this, CreateAccActivity::class.java)

            startActivity(signupIntent)
        }
        login.setOnClickListener {
            val loginIntent = Intent(this, LoginActivity::class.java)

            startActivity(loginIntent)
        }


    }
}