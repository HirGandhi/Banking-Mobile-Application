package com.example.assignment_3

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class login_staff : AppCompatActivity() {
    val dbhelper = dbhelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_staff)

        var btnc = findViewById(R.id.btnc) as Button
        var button7 = findViewById(R.id.button7) as Button
        var staffuser = findViewById(R.id.staffuser) as EditText
        var staffpass = findViewById(R.id.staffpass) as EditText

        val sharedPreferences = applicationContext.getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
        val user = sharedPreferences.getString("name","")

        btnc.setOnClickListener {
            var name: String = staffuser .text.toString()
            var password: String = staffpass.text.toString()
            var cnt = dbhelper.login_staff(name, password)

            if(cnt >0) {
                val editor = sharedPreferences.edit()
                editor.putString("name", name)
                editor.putString("pass", password)
                val success = editor.commit()

                Toast.makeText(applicationContext, "Login Successful", Toast.LENGTH_LONG).show()
                intent = Intent(this,menu_staff::class.java)
                startActivity(intent)
            }else {
                Toast.makeText(applicationContext, "Sorry", Toast.LENGTH_LONG).show()
            }
        }

        button7.setOnClickListener {
            intent = Intent(this,Registration_staff::class.java)
            startActivity(intent)
        }
    }
}