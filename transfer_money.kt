package com.example.assignment_3

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class transfer_money : AppCompatActivity() {
    val dbhelper = dbhelper(this)

    lateinit var edtAmount: EditText
    lateinit var edtToAccount: EditText
    lateinit var edtTransactionPassword: EditText
    lateinit var btnTransfer: Button
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_transfer_money)
        edtAmount = findViewById(R.id.edtAmount)
        edtToAccount = findViewById(R.id.edtToAccount)
        edtTransactionPassword = findViewById(R.id.edtTransactionPassword)
        btnTransfer = findViewById(R.id.btnTransfer)

        val sharedPreferences = getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
        val customerName = sharedPreferences.getString("name", "")
        val customerPass = sharedPreferences.getString("pass", "")

        btnTransfer.setOnClickListener {
            val amount = edtAmount.text.toString()
            val toAccount = edtToAccount.text.toString()
            val transactionPassword = edtTransactionPassword.text.toString()

            // Validate transaction password
            if (transactionPassword == customerPass) {
                val cursor = dbhelper.searchaccno(toAccount)
                if (cursor.moveToFirst()) {
                    // Retrieve customer account details
                    val currentBalance = cursor.getString(cursor.getColumnIndex("currbal")).toDouble()
                    val newBalance = currentBalance - amount.toDouble()

                    // Update the current balance in the database
                    dbhelper.updatestaff(
                        cursor.getInt(cursor.getColumnIndex("id")),
                        cursor.getString(cursor.getColumnIndex("from")),
                        cursor.getString(cursor.getColumnIndex("city")),
                        cursor.getString(cursor.getColumnIndex("email")),
                        cursor.getString(cursor.getColumnIndex("contactno")),
                        newBalance.toString(),
                        cursor.getString(cursor.getColumnIndex("dob"))
                    )

                    // Log the transaction
                    dbhelper.inserttransaction(
                        customerName.toString(),
                        toAccount,
                        transactionPassword,
                        amount
                    )

                    Toast.makeText(applicationContext, "Transfer Successful", Toast.LENGTH_LONG).show()
                    finish()
                } else {
                    Toast.makeText(applicationContext, "Invalid Account Number", Toast.LENGTH_LONG).show()
                }
                cursor.close()
            } else {
                Toast.makeText(applicationContext, "Invalid Transaction Password", Toast.LENGTH_LONG).show()
            }
        }
    }
}