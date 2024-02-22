package com.example.investapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.wajahatkarim3.easyvalidation.core.view_ktx.validator

class LoginActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var txtpass = findViewById<EditText>(R.id.password_act)
        var login = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.sign_up)
        var regis = findViewById<TextView>(R.id.acc_create)
        var email = findViewById<EditText>(R.id.email_act)


        login.setOnClickListener {
            var  vemail= email.text.toString()
            var vpass = txtpass.text.toString()


            fun isValidPass(vpass:String):Boolean{
                val passRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#\$%^&*()-+=]).{8,}$"
                return vpass.matches(passRegex.toRegex())

            }
            fun isValidEmail(email:String):Boolean{
                return Patterns.EMAIL_ADDRESS.matcher(vemail).matches()
            }

            val LoginIntent = Intent(this,HomeActivity::class.java)

            if( isValidEmail(vemail) && isValidPass(vpass)){

                startActivity(LoginIntent)
                Toast.makeText(this,"Welcome",Toast.LENGTH_SHORT).show()
                true
            }else{
                Toast.makeText(this, "Email or Password is Invalid", Toast.LENGTH_LONG).show()
                true
            }
        }
        regis.setOnClickListener {
            val registIntent = Intent(this, CreateAccActivity::class.java)
            startActivity(registIntent)
        }



    }
}