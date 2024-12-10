package com.example.assignment_3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class transactions_past : AppCompatActivity() {
//    val dbhelper = dbhelper(this)
//
//
//    lateinit var edt32 : EditText
//
//    lateinit var edt33 : EditText
//    lateinit var edt34 : EditText
//    lateinit var dpt1: DatePicker
//    lateinit var edt35 : EditText
//    lateinit var btninsert : Button
//    lateinit var btnshow : Button
//
//
//    fun showToastss(text:String)
//    {
//        Toast.makeText(this@transactions_past,text, Toast.LENGTH_LONG).show()
//    }
//
//    fun clearEdittexts()
//    {
//
//        edt32.setText("")
//        edt33.setText("")
//        edt34.setText("")
//        edt35.setText("")
//
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_transactions_past)


//        edt32 = findViewById(R.id.edt32)
//        edt33 = findViewById(R.id.edt33)
//        edt34 = findViewById(R.id.edt34)
//        dpt1 = findViewById(R.id.dpt1)
//        edt35 = findViewById(R.id.edt35)
//        btninsert = findViewById(R.id.btninsert)
//        btnshow = findViewById(R.id.btnshow)
//
//        btninsert.setOnClickListener {
//
//            try {
//                val day = dpt1.dayOfMonth
//                val month = dpt1.month + 1 // Months are indexed from 0
//                val year = dpt1.year
//                val selectedDate = "$day/$month/$year"
//
//                dbhelper.inserttransaction(
//                    edt32.text.toString(),
//                    edt33.text.toString(),
//                    edt34.text.toString(),
//                    selectedDate,
//                    edt35.text.toString()
//                )
//                clearEdittexts()
//                showToastss("Inserted")
//            }catch (e:Exception){
//                e.printStackTrace()
//                showToastss(e.message.toString())
//            }
//        }
//
//        btnshow.setOnClickListener {
//            intent = Intent(this,transaction_show::class.java)
//            startActivity(intent)
//        }

    }
}