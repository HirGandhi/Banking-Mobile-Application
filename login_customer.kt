package com.example.assignment_3

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class login_customer : AppCompatActivity() {
    val dbhelper = dbhelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_customer)
        var custuser = findViewById(R.id.custuser) as EditText
        var custpass = findViewById(R.id.custpass) as EditText
        var btnc = findViewById(R.id.btnc) as Button
        var button6 = findViewById(R.id.button6) as Button

        val sharedPreferences = applicationContext.getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
        val user = sharedPreferences.getString("name","")

        btnc.setOnClickListener {
            var name: String = custuser .text.toString()
            var password: String = custpass.text.toString()
            var cnt = dbhelper.login_cust(name, password)

            if(cnt >0) {
                val editor = sharedPreferences.edit()
                editor.putString("name", name)
                editor.putString("pass", password)
                val success = editor.commit()

                Toast.makeText(applicationContext, "Login Successful", Toast.LENGTH_LONG).show()
                intent = Intent(this,menu_sample::class.java)
                startActivity(intent)
            }else {
                Toast.makeText(applicationContext, "Sorry", Toast.LENGTH_LONG).show()
            }
        }

        button6.setOnClickListener {
            intent = Intent(this,Registration_customer::class.java)
            startActivity(intent)
        }
    }
}