package com.example.assignment_3

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class transaction_history_display : AppCompatActivity() {
    val dbhelper = dbhelper(this)
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_transaction_history_display)

        val listView = findViewById<ListView>(R.id.transactionListView)
        val transactionList = ArrayList<String>()

        // Retrieve the customer name from shared preferences or session
        val sharedPreferences = getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
        val customerName = sharedPreferences.getString("name", "")

        val cursor = dbhelper.getDatatrans()
        while (cursor.moveToNext()) {
            val id = cursor.getString(cursor.getColumnIndex("fromm"))
            val from = cursor.getString(cursor.getColumnIndex("fromm"))
            val to = cursor.getString(cursor.getColumnIndex("too"))
            val amount = cursor.getString(cursor.getColumnIndex("amount"))


        }
        cursor.close()

        // Display the transaction history in a ListView
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, transactionList)
        listView.adapter = adapter

    }
}