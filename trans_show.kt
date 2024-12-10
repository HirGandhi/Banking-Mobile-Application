package com.example.assignment_3

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class trans_show : AppCompatActivity() {
    val dbhelper = dbhelper(this)

    lateinit var listv : ListView

    fun showlistview() {
        val res = dbhelper.getdatastrans()
        val ar = arrayListOf<String>()

        while (res.moveToNext()) {
            // Retrieve all fields from the cursor and concatenate them into a single row
            val row = res.getString(0).padEnd(10) + ":" +     // id
                    res.getString(1).padEnd(10) + ":" +     // name
                    res.getString(2).padEnd(10) + ":" +
                    res.getString(3).padEnd(10) + ":" +
                    res.getString(4).padEnd(10)
            ar.add(row)
        }
        val adapter = ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, ar)
        listv.adapter = adapter
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_trans_show)

        listv = findViewById(R.id.listv)

        showlistview()
    }
}