package com.example.assignment_3

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class search_accno : AppCompatActivity() {
    val dbhelper = dbhelper(this)

    lateinit var edtac : EditText
    lateinit var btnsearch : Button
    lateinit var list1 : ListView


    fun showToasts(text:String)
    {
        Toast.makeText(this@search_accno,text, Toast.LENGTH_LONG).show()
    }

    fun clearEdittexts()
    {
       edtac.setText("")
    }

    fun showlistview() {
        val res = dbhelper.searchaccno(edtac.text.toString())
        val ar = arrayListOf<String>()

        while (res.moveToNext()) {
            val row = res.getString(0).padEnd(5) + ":" +  // id
                      res.getString(1).padEnd(10) + ":" + // name
                    res.getString(5).padEnd(8) + ":" + // contact number
                    res.getString(7).padEnd(8) + ":" +
                    res.getString(8).padEnd(5)
            ar.add(row)
        }
        val adapter = ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, ar)
        list1.adapter = adapter

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_search_accno)

        btnsearch = findViewById(R.id.btnsearch) as Button
        edtac = findViewById(R.id.edtac) as EditText
        var txt11 = findViewById(R.id.txt11) as TextView
        list1 = findViewById(R.id.list1)

        btnsearch.setOnClickListener {
            try {
                val res = dbhelper.searchaccno(edtac.text.toString())

                if (res != null && res.moveToFirst()) {
                    showToasts("Account found")
                    showlistview()
                } else {
                    showToasts("Account not found")
                    list1.adapter = null  // Clear the ListView
                }
                clearEdittexts()
            } catch (e: Exception) {
                e.printStackTrace()
                showToasts(e.message.toString())
            }
        }

    }
}