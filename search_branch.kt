package com.example.assignment_3

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class search_branch : AppCompatActivity() {
    val dbhelper = dbhelper(this)

    lateinit var sp12 :  Spinner
    lateinit var listv : ListView
    lateinit var btnsearch : Button

    fun showToasts(text:String)
    {
        Toast.makeText(this@search_branch,text, Toast.LENGTH_LONG).show()
    }

    fun clearEdittexts()
    {
        sp12.setSelection(0)
    }

//    fun showlistview() {
//        val res = dbhelper.getDatacust()
//        val ar = arrayListOf<String>()
//
//        while (res.moveToNext()) {
//            val row =  res.getString(0) + "\n" +  // id
//                     res.getString(1) + "\n" + // name
//                     res.getString(5) + "\n" + // contact number
//                     res.getString(6) + "\n" +
//                     res.getString(7) + "\n" +
//                     res.getString(8).padEnd(6)
//            ar.add(row)
//        }
//        val adapter = ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, ar)
//        listv.adapter = adapter
//
//    }

    fun showlistview(customerCount: Int, staffCount: Int) {
        val ar = arrayListOf<String>()
        ar.add("Customer Count: $customerCount")
        ar.add("Employee Count: $staffCount")

        val adapter = ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, ar)
        listv.adapter = adapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_search_branch)

        btnsearch = findViewById(R.id.btnsearch)
        sp12 = findViewById(R.id.sp12)
        listv = findViewById(R.id.listv)

        var branch = arrayOf("--select branch--","Branch 1","Branch 2","Branch 3","Branch 4","Branch 5")
        var arrayAdapter = ArrayAdapter(this,androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,branch)
        sp12.adapter=arrayAdapter


        btnsearch.setOnClickListener {
            try {
                val customerCount = dbhelper.searchcitycust(sp12.selectedItem.toString())
                val staffCount = dbhelper.searchcitystaff(sp12.selectedItem.toString())

                if (customerCount > 0 || staffCount > 0) {
                    showToasts("Branch found:\nCustomers: $customerCount\nEmployees: $staffCount")
                    showlistview(customerCount, staffCount)  // Pass the counts to showlistview
                } else {
                    showToasts("No customers or employees found in this branch")
                    listv.adapter = null  // Clear the ListView
                }
                clearEdittexts()
            } catch (e: Exception) {
                e.printStackTrace()
                showToasts(e.message.toString())
            }
        }


    }
}