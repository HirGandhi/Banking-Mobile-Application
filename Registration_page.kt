package com.example.assignment_3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Registration_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registration_page)

        var button3 = findViewById(R.id.button3) as Button
        var button4 = findViewById(R.id.button4) as Button

        button3.setOnClickListener{
            intent = Intent(this,Registration_customer::class.java)
            startActivity(intent)
        }

        button4.setOnClickListener{
            intent = Intent(this,Registration_staff::class.java)
            startActivity(intent)
        }
    }
}