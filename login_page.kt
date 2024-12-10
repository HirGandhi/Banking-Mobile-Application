package com.example.assignment_3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class login_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_page)

        var button = findViewById(R.id.button) as Button
        var button2 = findViewById(R.id.button2) as Button

        button.setOnClickListener{
            intent = Intent(this,login_customer::class.java)
            startActivity(intent)
        }

        button2.setOnClickListener{
            intent = Intent(this,login_staff::class.java)
            startActivity(intent)
        }
    }
}