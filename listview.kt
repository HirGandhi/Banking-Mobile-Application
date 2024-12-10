package com.example.assignment_3

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class listview : AppCompatActivity() {

    val dbhelper = dbhelper(this)

    lateinit var list1 : ListView

    fun showlistview() {
        val res = dbhelper.getDatacust()
        val ar = arrayListOf<String>()

        while (res.moveToNext()) {
            // Retrieve all fields from the cursor and concatenate them into a single row
            val row = res.getString(0).padEnd(4) + ":" +  // id
                    res.getString(1).padEnd(10) + ":" + // name
                    res.getString(2).padEnd(10) + ":" + // password
                    res.getString(3).padEnd(10) + ":" +  // gender
                    res.getString(4).padEnd(10) + ":" +   // email
                    res.getString(5).padEnd(10) + ":" + // account number
                    res.getString(6).padEnd(10) + ":" +
                    res.getString(7).padEnd(10) + ":" +
                    res.getString(8).padEnd(6)
            ar.add(row)
        }
        val adapter = ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, ar)
        list1.adapter = adapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_listview)

        list1 = findViewById(R.id.list1)

        showlistview()

    }
}