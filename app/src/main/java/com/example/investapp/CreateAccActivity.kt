package com.example.investapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CreateAccActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_acc)

        val back = findViewById<FloatingActionButton>(R.id.back_icon)
        val register =findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.sign_up)
        val login = findViewById<TextView>(R.id.login)




        back.setOnClickListener {
            val backIntent = Intent(this, MainActivity::class.java)

            startActivity(backIntent)
        }
        register.setOnClickListener {
            val registerIntent = Intent( this,HomeActivity::class.java)
            startActivity(registerIntent)
        }
        login.setOnClickListener{
            val loginIntent = Intent(this, LoginActivity::class.java)
            startActivity(loginIntent)
        }


    }
}